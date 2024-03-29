package controle.mensagens.celular.modem;

/**
 *
 * @author Wesllen Sousa Lima
 */

import recursos.internacionalizacao.MensagensErro;
import java.io.*;
import javax.comm.*;

public class SerialToGsm {

    private InputStream in;
    private OutputStream out;
    private String lastIndexRead;
    private String senderNum;
    private String smsMsg;
    
    private String porta;

    public SerialToGsm(String porta) {
        this.porta = porta;
    }
    
    public Boolean iniciar() {
        try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(porta);
            SerialPort sp = (SerialPort) portId.open("Sms_GSM", 0);
            sp.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            sp.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

            in = sp.getInputStream();
            out = sp.getOutputStream();

            if(in != null && out != null) {
                sendAndRecv("+++AT", 30);       // delay for 20 sec/10
                sendAndRecv("AT&F", 30);
                sendAndRecv("ATE0", 30);        // echo off
                sendAndRecv("AT +CMEE=1", 30);  // verbose error messages
                sendAndRecv("AT+CMGF=0", 70);   // set pdu mode
            }
            return true;
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException ex) {
            return false; 
        }
    }

    private String sendAndRecv(String s, int timeout) {
        try {
            in.skip(in.available());
            System.out.println("=> " + s);
            s = s + "\r";         // add CR
            out.write(s.getBytes());
            out.flush();

            String strIn = new String();
            for (int i = 0; i < timeout; i++) {
                int numChars = in.available();
                if (numChars > 0) {
                    byte[] bb = new byte[numChars];
                    in.read(bb, 0, numChars);
                    strIn += new String(bb);
                }

                if (strIn.indexOf(">\r\n") != -1) {
                    break;
                }

                if (strIn.indexOf("OK\r\n") != -1) {
                    break;
                }

                if (strIn.indexOf("ERROR") != -1) { // if find 'error' wait for CR+LF
                    if (strIn.indexOf("\r\n", strIn.indexOf("ERROR") + 1) != -1) {
                        break;
                    }
                }

                Thread.sleep(100); // delay 1/10 sec
            }

            System.out.println("<= " + strIn);

            if (strIn.length() == 0) {
                return "ERROR: len 0";
            }

            return strIn;
        } catch (IOException | InterruptedException ex) {
            MensagensErro.serialToGsmEnviar(ex);
            return "ERROR: send e recv Exception";
        }
    }

    public String sendSms(String numToSend, String whatToSend) {
        ComputeSmsData sms = new ComputeSmsData();
        sms.setAsciiTxt(whatToSend);
        sms.setTelNum(numToSend);

        String s = new String();
        s = sendAndRecv("AT+CMGS=" + (sms.getCompletePduData().length() / 2) + "\r", 30);
        System.out.println("==> AT+CMGS=" + (sms.getCompletePduData().length() / 2));
        System.out.println("<== " + s);
        if (s.indexOf(">") != -1) {
            // if this sintax won't work try remove 00 prefix
            s = sendAndRecv("00" + sms.getCompletePduData() + "\u001A", 150);

            return s;
        } else {
            return "ERROR";
        }
    }

    // used to reset message data
    private void resetGsmObj() {
        lastIndexRead = null;
        senderNum = null;
        smsMsg = null;
    }

    public String checkSms() {
        String str = new String();
        String strGsm = new String();
        strGsm = sendAndRecv("AT+CMGL=0", 30);  // list unread msg and sign them as read
        // if answer contain ERROR then ERROR
        if (strGsm.indexOf("ERROR") != -1) {
            resetGsmObj();
            return strGsm; // error
        }

        strGsm = sendAndRecv("AT+CMGL=1", 30);  // list read msg
        // if answer contain ERROR then ERROR
        if (strGsm.indexOf("ERROR") != -1) {
            resetGsmObj();
            return strGsm; // error
        }

        // evaluate message index
        if (strGsm.indexOf(':') <= 0) {
            resetGsmObj();
            return ("ERROR unexpected answer");
        }

        str = strGsm.substring(strGsm.indexOf(':') + 1, strGsm.indexOf(','));
        str = str.trim(); // remove white spaces
//        System.out.println("Index: " + str);
        lastIndexRead = str;

        // find message string
        // -------------------
        // look for start point (search \r, then skip \n, add and one more for right char
        int startPoint = strGsm.indexOf("\r", (strGsm.indexOf(":") + 1)) + 2;
        int endPoint = strGsm.indexOf("\r", startPoint + 1);
        if (endPoint == -1) {
            // only one message
            endPoint = strGsm.length();
        }

        // extract string
        str = strGsm.substring(startPoint, endPoint);
        System.out.println("String to be decoded :" + str);

        ComputeSmsData sms = new ComputeSmsData();
        sms.setRcvdPdu(str);
//        SMSCNum = new String(sms.getRcvdPduSMSC());
        senderNum = sms.getRcvdSenderNumber();
        smsMsg = sms.getRcvdPduTxt();

        System.out.println("SMSC number:   " + sms.getRcvdPduSMSC());
        System.out.println("Sender number: " + sms.getRcvdSenderNumber());
        System.out.println("Message: " + sms.getRcvdPduTxt());

        return "OK";
    }

    public String readSmsSender() {
        return senderNum;
    }

    public String readSms() {
        return smsMsg;
    }

    public String delSms() {
        if (!"".equals(lastIndexRead)) {
            return sendAndRecv("AT+CMGD=" + lastIndexRead, 30);
        }
        return ("ERROR");
    }
    
    public void liberarPortas() {
        try {
            in.close();
            out.close();
        } catch (IOException ex) {
            MensagensErro.serialToGsmFechar(ex);
        }
    }
    
}
