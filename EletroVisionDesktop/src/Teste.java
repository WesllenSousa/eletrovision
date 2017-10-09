
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Teste {

    private InputStream in;
    private OutputStream out;

    private Boolean conexao = false;

    private String porta = "COM7";

    //Modulo acionamento 8OUAL1 8OUAI1
    //Dimmer 443841F80364
    public static void main(String[] args) {
        Teste teste = new Teste();
        teste.envia("8OUAI1");
        teste.disconnect();
    }

    public Teste() {
        for (int i = 1; i <= 3; i++) {
            if (!conexao) {
                connect();
            } else {
                break;
            }
            waitShort();
        }
    }

    public void connect() {
        try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(porta);
            SerialPort sp = (SerialPort) portId.open("iorobotics", 0);
            sp.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            sp.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

            in = sp.getInputStream();
            out = sp.getOutputStream();

            conexao = true;
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException ex) {
            System.out.println(ex);
            conexao = false;
            ConfigDispositivos.setAtivarAcionamento(false);
        }
    }

    public boolean envia(String command) {
        try {
            in.skip(in.available());
            out.write(command.getBytes());
            out.flush();
            return true;
        } catch (IOException ex) {
            InstanciasControle.getMensagens().bug(ex.toString());
            return false;
        }
    }

    public void waitShort() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }
    }

    public void disconnect() {
        try {
            if (in != null && out != null) {
                in.close();
                in = null;
                out.close();
                out = null;
            }
        } catch (IOException ex) {
            InstanciasControle.getMensagens().bug(ex.toString());
        }
    }

}
