package controle.redes;

import EletroVisionPortatil.dependencias.InstanciasPortatil;
import controle.mensagens.rede.TrataMensagem;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.constantes.ConstantesRedes;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import recursos.instancias.InstanciasControle;

public class Cliente implements Runnable {

    private Socket socket;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private Boolean statusConexao;

    private TrataMensagem tratarMensagem;
    private String host;
    
    private String usuario, senha;
   
    public Cliente(String host, String usuario, String senha) {
        tratarMensagem = new TrataMensagem();
        this.host = host;
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, ConstantesRedes.CS_PORTA);
            statusConexao = true;
            System.out.println("Cliente - Conexão realizada com sucesso! ");
        } catch (IOException ex) {
            System.out.println("Cliente-criarSocket: " + ex);
            InstanciasControle.getMensagens().aviso(MensagensSoltas.redesClienteIniciar()+ex);
            statusConexao = false;
        }
        if (statusConexao) {
            configuraEntradaSaida();
            processarConexao();
        }
    }

    private void configuraEntradaSaida() {
        try {
            saida = new ObjectOutputStream(socket.getOutputStream());
            saida.flush();
            entrada = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Cliente: " + ex);
            //MensagensErro.redeConfigurar(ex);
        }
    }

    private void processarConexao() {
        verificarTipoCliente();
        do {
            try {
                String mensagem = entrada.readObject().toString();
                tratarMensagem.verificaMensagemCliente(this, mensagem);
            } catch (IOException | ClassNotFoundException ex) {
                fecharConexao();
                System.out.println("Cliente-processarConexao: " + ex);
                //MensagensErro.redeProcessar(ex);
            }
        } while (statusConexao);
    }

    public void fecharConexao() {
        enviarDados(ConstantesRedes.CS_FIM);
        try {
            saida.close();
            entrada.close();
            socket.close();
            statusConexao = false;
            InstanciasPortatil.setCliente(null);
        } catch (IOException ex) {
            System.out.println("Cliente-fecharConexao: " + ex);
            //MensagensErro.redeFechar(ex);
        }
    }

    public void enviarDados(Object dado) {
        try {
            saida.writeObject(dado);
            saida.flush();
        } catch (IOException ex) {
            System.out.println("Cliente-enviarDados: " + ex);
            //MensagensErro.redeEnviarDados(ex);
        }
    }
    
    public void enviaBytes(byte[] bytes, int offset, int tamanho) {
        try {
            saida.write(bytes, offset, tamanho);
            saida.flush();
        } catch (IOException ex) {
            System.out.println("SocketConectado - enviarDados: \n" + ex);
            //MensagensErro.redeEnviarDados(ex);
        }
    }

    private void verificarTipoCliente() {
        tratarMensagem.enviarMensagemServidor(this, ConstantesRedes.CS_INICIAR_CONEXAO, usuario, senha);
    }

    /*
     * GETs
     */
    public Boolean getStatusConexao() {
        return statusConexao;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public TrataMensagem getTratarMensagem() {
        return tratarMensagem;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUsuario() {
        return usuario;
    }  

}
