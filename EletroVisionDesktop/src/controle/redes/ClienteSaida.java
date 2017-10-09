package controle.redes;

import recursos.constantes.ConstantesRedes;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSaida implements Runnable {

    private ObjectOutputStream saida;
    private Socket socket;

    public ClienteSaida(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        configurarSaida();
    }

    private void configurarSaida() {
        try {
            saida = new ObjectOutputStream(socket.getOutputStream());
            saida.flush();
        } catch (IOException ex) {
            System.out.println("Cliente Saida-configurarSaida: " + ex);
            //MensagensErro.redeConfigurar(ex);
        }
    }

    public void enviarDados(Object dado) {
        try {
            saida.writeObject(dado);
            saida.flush();
        } catch (IOException ex) {
            System.out.println("Cliente Saida-enviarDados: " + ex);
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

    public void fechaConexao() {
        enviarDados(ConstantesRedes.CS_FIM);
    }

    /*
     * GETs
     */
    public Socket getSocket() {
        return socket;
    }

    public ObjectOutputStream getSaida() {
        return saida;
    }
    
}
