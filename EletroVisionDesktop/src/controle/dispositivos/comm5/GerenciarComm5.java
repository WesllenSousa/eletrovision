package controle.dispositivos.comm5;

import controle.dispositivos.ManageDevice;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.internacionalizacao.MensagensSoltas;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import javax.swing.ImageIcon;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GerenciarComm5 implements ManageDevice {

    private ModuloAcionamentoBean moduloAcionamento;
    private AcessaSerialPortControl serialPortControl;
    private Boolean conexao = false;

    public GerenciarComm5(ModuloAcionamentoBean moduloAcionamento) {
        this.moduloAcionamento = moduloAcionamento;

        init();
    }

    @Override
    public void init() {
        //Tenta conectar n vezes
        for (int i = 1; i <= 5; i++) {
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
        serialPortControl = new AcessaSerialPortControl();
        serialPortControl.init();
        Integer handle = serialPortControl.create();
        serialPortControl.setImpl(handle);
        serialPortControl.connect(moduloAcionamento.getIdentificacao(), moduloAcionamento.getPorta());
        serialPortControl.waitForConnected(Short.parseShort(30 + ""));
        Integer estado = serialPortControl.isConnected();
        verificaEstado(estado);
        if (estado != 0) {
            InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_dispositivosLigados())));
            System.out.println("Módulo de acionamento conectado!");
        }
    }

    @Override
    public void disconnect() {
        serialPortControl.disconnect();
        Integer estado = serialPortControl.isConnected();
        if (estado == 0) {
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerenciarAcionamentoDesconectar(
                    moduloAcionamento.getNome()));
            InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_dispositivosDesligados())));
        }
        serialPortControl.destroy();
        serialPortControl = null;
        System.out.println("Módulo de acionamento desconectado!");
    }

    @Override
    public Boolean turnOn(Integer porta) {
        if (verificaConexao()) {
            serialPortControl.writeString("set " + porta + "\r\n");
            serialPortControl.writeString("outputs \r\n");
            serialPortControl.waitForBytesWritten(1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean turnOff(Integer porta) {
        if (verificaConexao()) {
            serialPortControl.writeString("reset " + porta + "\r\n");
            serialPortControl.writeString("outputs \r\n");
            serialPortControl.waitForBytesWritten(1);
            return true;
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
        return conexao;
    }

    @Override
    public ModuloAcionamentoBean getModuloAcionamento() {
        return moduloAcionamento;
    }

    private Boolean verificaConexao() {
        if (serialPortControl.isConnected() != 0) {
            return true;
        } else {
            InstanciasControle.getMensagens().aviso(
                    MensagensSoltas.gerenciarAcionamentoVerificaConexao(moduloAcionamento.getNome()));
            return false;
        }
    }

    private void verificaEstado(Integer estado) {
        if (estado == 0) {
            conexao = false;
            ConfigDispositivos.setAtivarAcionamento(false);
        } else {
            conexao = true;
            ConfigDispositivos.setAtivarAcionamento(true);
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerenciarAcionamentoSucesso(
                    moduloAcionamento.getNome()));
        }
    }

}
