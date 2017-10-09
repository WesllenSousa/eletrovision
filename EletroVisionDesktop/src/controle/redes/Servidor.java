package controle.redes;

import EletroVisionPortatil.dependencias.InstanciasPortatil;
import recursos.internacionalizacao.MensagensErro;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.constantes.ConstantesRedes;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import recursos.instancias.InstanciasControle;

public class Servidor implements Runnable {

    private ServerSocket serverSocket;
    private HashMap<Integer, ArrayList<ClienteEntrada>> conexoes;
    private Boolean statusConexao;

    public Servidor() {
        conexoes = new HashMap<>();
        try {
            serverSocket = new ServerSocket(ConstantesRedes.CS_PORTA);
            statusConexao = true;
            InstanciasPortatil.setServidor(Servidor.this); 
            System.out.println("Servidor criado com sucesso!");
        } catch (IOException ex) {
            InstanciasControle.getMensagens().bug(MensagensSoltas.redesServidorCriar() + ex);
            System.out.println("Servidor: " + ex);
            statusConexao = false;
        }
    }

    @Override
    public void run() {
        while (statusConexao) {
            esperaConexoes();
        }
    }

    private void esperaConexoes() {
        try {
            Socket socket = serverSocket.accept();
            System.out.println("Conexão aceita: " + socket.getInetAddress().getHostAddress());
            
            ClienteSaida clienteSaida = new ClienteSaida(socket);
            Thread thread = new Thread(clienteSaida);
            thread.start();

            ClienteEntrada clienteEntrada = new ClienteEntrada(clienteSaida, this);
            Thread thread1 = new Thread(clienteEntrada);
            thread1.start();
        } catch (IOException ex) {
            System.out.println("Servidor-aceitarConexao: " + ex);
            //MensagensErro.redeProcessar(ex); 
        }
    }

    public void enviarDados(Integer identificacaoConexao, Object dado) {
        if (conexoes.get(identificacaoConexao) != null) {
            for (ClienteEntrada clienteEntrada : conexoes.get(identificacaoConexao)) {
                clienteEntrada.getClienteSaida().enviarDados(dado);
            }
        }
    }
 
    public void enviarDados(Integer identificacaoConexao, Object dado, Integer porta) {
        for (ClienteEntrada clienteEntrada : conexoes.get(identificacaoConexao)) {
            if (clienteEntrada.getClienteSaida().getSocket().getPort() == porta) {
                clienteEntrada.getClienteSaida().enviarDados(dado);
            }
        }
    }
    
    public void enviaBytes(Integer identificacaoConexao, byte[] bytes, int tamanho, Integer porta) {
        for (ClienteEntrada clienteEntrada : conexoes.get(identificacaoConexao)) {
            if(clienteEntrada.getClienteSaida().getSocket().getPort() == porta) {
                clienteEntrada.getClienteSaida().enviaBytes(bytes, 0, tamanho);
            }
        }
    }

    public void fechaConexao() {
        do {
            for (ArrayList<ClienteEntrada> clientesEntradas : conexoes.values()) {
                Boolean status = false;
                for (ClienteEntrada clienteEntrada : clientesEntradas) {
                    clienteEntrada.getClienteSaida().fechaConexao();
                    clienteEntrada.fecharConexao();
                    status = true;
                    break;
                }
                if (status) {
                    break;
                }
            }
        } while (!conexoes.values().isEmpty());
        try {
            serverSocket.close();
            statusConexao = false;
            InstanciasPortatil.setServidor(null);
            InstanciasPortatil.setClientesConectados(null); 
        } catch (IOException ex) {
            System.out.println("Servidor-fecharConexao: " + ex);
            MensagensErro.redeFechar(ex); 
        }
    }

    /*
     * GETs
     */
    public Boolean getStatusConexao() {
        return statusConexao;
    }

    public HashMap<Integer, ArrayList<ClienteEntrada>> getConversas() {
        return conexoes;
    }

    public void adicionarClienteConexao(Integer identificacaoConversa, ClienteEntrada clienteEntrada) {
        if (!conexoes.containsKey(identificacaoConversa)) {
            ArrayList<ClienteEntrada> ce = new ArrayList<>();
            conexoes.put(identificacaoConversa, ce);
        }
        ArrayList<ClienteEntrada> clientesEntrada = conexoes.get(identificacaoConversa);
        if (!clientesEntrada.contains(clienteEntrada)) {
            clientesEntrada.add(clienteEntrada);
            System.out.println("Servidor adicionou o cliente a identificação da conexão: " + identificacaoConversa);
        }
    }

    public void removerClienteConexao(Integer identificacaoConversa, ClienteEntrada clienteEntrada) {
        ArrayList<ClienteEntrada> clientes = conexoes.get(identificacaoConversa);
        if (clientes != null) {
            for (ClienteEntrada ce : clientes) {
                if (ce.getClienteSaida().getSocket().getPort() == clienteEntrada.getClienteSaida().getSocket().getPort()) {
                    clientes.remove(ce);
                    System.out.println("Servidor removeu o cliente da identificação da conexão: " + identificacaoConversa);
                    break;
                }
            }
        }
        if (clientes != null && clientes.isEmpty()) {
            conexoes.remove(identificacaoConversa);
            System.out.println("Servidor removeu a conversa: " + identificacaoConversa);
        }
    }

    public Integer gerarIdentificacao() {
        return conexoes.size() + 1;
    }
    
}
