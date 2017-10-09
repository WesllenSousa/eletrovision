/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.dispositivos.iorobotics;

import controle.dispositivos.ManageDevice;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
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
import recursos.internacionalizacao.MensagensSoltas;

/**
 *
 * @author Wesllen Sousa
 */
public class GerenciarIOrobotics implements ManageDevice {

    private InputStream in;
    private OutputStream out;

    private ModuloAcionamentoBean moduloAcionamento;
    private Boolean conexao = false;

    public GerenciarIOrobotics(ModuloAcionamentoBean moduloAcionamento) {
        this.moduloAcionamento = moduloAcionamento;
        init();
    }

    @Override
    public void init() {
        for (int i = 1; i <= 3; i++) {
            if (!conexao) {
                connect();
            } else {
                break;
            }
            waitShort();
        }
        if (!conexao) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerenciarAcionamentoVerificaEstado(
                    moduloAcionamento.getNome()));
        }
    }

    @Override
    public void connect() {
        try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(moduloAcionamento.getIdentificacao());
            SerialPort sp = (SerialPort) portId.open("iorobotics", 0);
            sp.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            sp.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

            in = sp.getInputStream();
            out = sp.getOutputStream();

            conexao = true;
            ConfigDispositivos.setAtivarAcionamento(true);
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerenciarAcionamentoSucesso(
                    moduloAcionamento.getNome()));
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException ex) {
            System.out.println(ex);
            conexao = false;
            ConfigDispositivos.setAtivarAcionamento(false);
        }
    }

    @Override
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

    @Override
    public Boolean turnOn(Integer porta) {
        if (isConnected()) {
            String command = "8OUAL";
            return envia(command + porta);
        } else {
            return false;
        }
    }

    @Override
    public Boolean turnOff(Integer porta) {
        if (isConnected()) {
            String command = "8OUAD";
            return envia(command + porta);
        } else {
            return false;
        }
    }

    @Override
    public void waitShort() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public Boolean isConnected() {
        if (in != null && out != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ModuloAcionamentoBean getModuloAcionamento() {
        return moduloAcionamento;
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

}
