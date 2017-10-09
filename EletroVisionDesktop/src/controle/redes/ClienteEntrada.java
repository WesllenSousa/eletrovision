package controle.redes;

import controle.mensagens.rede.TrataMensagem;
import entidades.usuario.bean.UsuarioBean;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClienteEntrada implements Runnable {

    private ObjectInputStream entrada;
    private Servidor servidor;
    private ClienteSaida clienteSaida;
    private TrataMensagem tratarMensagem;
    private Integer identificacaoConversa;
    
    private UsuarioBean usuario;

    public ClienteEntrada(ClienteSaida clienteSaida, Servidor servidor) {
        tratarMensagem = new TrataMensagem();
        this.clienteSaida = clienteSaida;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        configuraEntrada();
        configuraProcessa();
    }

    public void configuraEntrada() {
        try {
            entrada = new ObjectInputStream(clienteSaida.getSocket().getInputStream());
        } catch (IOException ex) {
            //MensagensErro.redeConfigurar(ex);
        }
    }

    private void configuraProcessa() {
        try {
            do {
                String mensagem = entrada.readObject().toString();
                tratarMensagem.animarRedes();
                tratarMensagem.verificarMensagemServidor(this, mensagem);
            } while (servidor.getStatusConexao());
        } catch (IOException | ClassNotFoundException ex) {
           System.out.println("ClienteEntrada-configurarProcessar: " + ex);
           //MensagensErro.redeProcessar(ex);
        }
    } 

    public void fecharConexao() {
        try {
            servidor.removerClienteConexao(identificacaoConversa, this);
            entrada.close();
            clienteSaida.getSaida().close();
            clienteSaida.getSocket().close();
        } catch (IOException ex) {
            System.out.println("Cliente Entrada-fecharConexao: " + ex);
            //MensagensErro.redeFechar(ex);
        }
    }

    /*
     * GETTERS SETTERS
     */
    public Servidor getServidor() {
        return servidor;
    }

    public ClienteSaida getClienteSaida() {
        return clienteSaida;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public TrataMensagem getTratarMensagem() {
        return tratarMensagem;
    }

    public Integer getIdentificacaoConversa() {
        return identificacaoConversa;
    }

    public void setIdentificacaoConversa(Integer identificacaoConversa) {
        this.identificacaoConversa = identificacaoConversa;
        servidor.adicionarClienteConexao(identificacaoConversa, this);
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
    
}
