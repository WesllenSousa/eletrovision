package wsl.eletrovision.controle.mensagem;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import wsl.eletrovision.controle.recursos.ConstantesRedes;
import wsl.eletrovision.controle.recursos.ConstantesTelas;
import wsl.eletrovision.controle.recursos.ExecutarAudio;
import wsl.eletrovision.controle.recursos.InstanciasPortatil;
import wsl.eletrovision.controle.redes.Cliente;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;
import wsl.eletrovision.controle.serializado.GuardaMensagem;
import wsl.eletrovision.telas.TelaConfigCamera;
import wsl.eletrovision.telas.TelaConfigCenario;
import wsl.eletrovision.telas.TelaMapa;
import wsl.eletrovision.telas.TelaVisualizarImagem;
import wsl.eletrovision.utils.ImagemUtil;

public class TrataMensagem {
	
	private static final String CATEGORIA = "wsl";
	private Handler handler;
    
    /*
     * MENSAGENS
     */
    public void verificaMensagemCliente(Cliente cliente, String mensagem) {
        try {
            /*
             * COMUNS
             */
            if (mensagem.equals(ConstantesRedes.CS_FIM)) {

                cliente.fecharConexao();
                InstanciasPortatil.setCliente(null);
                Log.i(CATEGORIA, "Cliente - Cliente desconectado.");

            } else if (mensagem.equals(ConstantesRedes.CS_CONECTANDO)) {

                String confirmacao = cliente.getEntrada().readObject().toString();
                handleConectar(confirmacao);
                Log.i(CATEGORIA, "Conexão confirmada.");

            } else if (mensagem.equals(ConstantesRedes.CS_MENSAGEM)) {

            	String usuario = cliente.getEntrada().readObject().toString();
                String texto = cliente.getEntrada().readObject().toString();
                String tipo = cliente.getEntrada().readObject().toString();
                
                if(tipo.equals(ConstantesRedes.TP_PESSOAS_DETECTADAS)) {
                	ExecutarAudio.pessoasDetectadas(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_CENARIO_ACIONADO)) {
                	ExecutarAudio.cenarioAcionado(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_DISPOSITIVO_LIGADO)) {
                	ExecutarAudio.dispositivoAcionado(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_AGENDAMENTO_DISPARADO)) {
                	ExecutarAudio.agendamentoDisparado(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_FACE_RECONHECIDA)) {
                	ExecutarAudio.faceReconhecida(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_VISITA)) {
                	ExecutarAudio.visita(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_MOVIMENTO_DETECTADO)) {
                	ExecutarAudio.movimento(InstanciasPortatil.getTelaPrincipal());
                } else if(tipo.equals(ConstantesRedes.TP_AMBIENTE_ALTERADO)) {
                	ExecutarAudio.ambiente(InstanciasPortatil.getTelaPrincipal());
                } else {
                	ExecutarAudio.telefone(InstanciasPortatil.getTelaPrincipal());
                }

                guardaMensagens(usuario, texto);
                handleMensagem();
                Log.i(CATEGORIA, "Mensagem recebida!");

            } else if (mensagem.equals(ConstantesRedes.CS_CLIENTE_CONECTADOS)) {
                
                ArrayList<ClientesConectado> lista = (ArrayList<ClientesConectado>) cliente.getEntrada().readObject();

                InstanciasPortatil.setClientesConectados(lista);
                handleClientesConectados();
                Log.i(CATEGORIA, "Clientes conectados recebidos!");

            } 
            /*
             * ESPECÍFICOS
             */ 
            else if (mensagem.equals(ConstantesRedes.CS_DISPOSITIVOS)) {
                
                ArrayList<GuardaDispositivo> lista = (ArrayList<GuardaDispositivo>) cliente.getEntrada().readObject();
                
                if(!lista.isEmpty()) {
	                InstanciasPortatil.setGuardaDispositivos(lista); 
	                handleDispositivoPreencherLista(1);
                } else {
                	handleDispositivoPreencherLista(0);
                }
                Log.i(CATEGORIA, "Lista de dispositivos recebida!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_ACIONAR_DISPOSITIVOS)) {
                
                String confirmacao = cliente.getEntrada().readObject().toString();
                handleDispositivoAcionar(confirmacao);
                Log.i(CATEGORIA, "Dispositivos acionado!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_CENARIOS)) {
                
                ArrayList<GuardaCenario> lista = (ArrayList<GuardaCenario>) cliente.getEntrada().readObject();
                
                if(!lista.isEmpty()) {
	                InstanciasPortatil.setGuardaCenarios(lista);
	                handleCenarioPreencherLista(1);
                } else {
                	handleCenarioPreencherLista(0);
                }
                Log.i(CATEGORIA, "Lista de cenários recebida!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_ACIONAR_CENARIOS)) {
                
                String confirmacao = cliente.getEntrada().readObject().toString();
                handleCenario(confirmacao);
                Log.i(CATEGORIA, "Cenário acionado!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_CAMERAS)) {
                
                ArrayList<GuardaCamera> lista = (ArrayList<GuardaCamera>) cliente.getEntrada().readObject();
                
                if(!lista.isEmpty()) {
	                InstanciasPortatil.setGuardaCameras(lista);
	                handleCameraPreencherLista(1);
                } else {
                	handleCameraPreencherLista(0);
                }
                Log.i(CATEGORIA, "Lista de câmeras recebida!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_TIRAR_FOTO)) {
                
                String confirmacao = cliente.getEntrada().readObject().toString();
                handleCamera(confirmacao); 
                if(confirmacao.equals("1")) {
                    byte[] bytes = ImagemUtil.lerBytesImagem(cliente.getEntrada());
                    if(bytes.length != 0) {
                    	Intent intent = new Intent(InstanciasPortatil.getTelaCamera(), TelaVisualizarImagem.class);
                    	intent.putExtra("imagem", bytes);
                    	InstanciasPortatil.getTelaCamera().startActivity(intent);
                    } 
                } 
                Log.i(CATEGORIA, "Foto recebida!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_TIRAR_ULTIMA_FOTO)) {
                
            	String confirmacao = cliente.getEntrada().readObject().toString();
            	handlePrincipal(confirmacao);             	
            	if(confirmacao.equals("1")) {
	                byte[] bytes = ImagemUtil.lerBytesImagem(cliente.getEntrada());
	                if(bytes.length != 0) {
	                	Intent intent = new Intent(InstanciasPortatil.getTelaPrincipal(), TelaVisualizarImagem.class);
	                	intent.putExtra("imagem", bytes);
	                	InstanciasPortatil.getTelaPrincipal().startActivity(intent);
	                	Log.i(CATEGORIA, "Última foto recebida!");
	                } 
            	} else {
            		Log.i(CATEGORIA, "Última foto indisponível!");
            	}
        		                
            } else if (mensagem.equals(ConstantesRedes.CS_CONFIG_CAMERA)) {
                
                final String codigo = cliente.getEntrada().readObject().toString();
                final ArrayList<String> lista = (ArrayList<String>) cliente.getEntrada().readObject();
                                
                handleCamera("-1");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                    	Intent intent = new Intent(InstanciasPortatil.getTelaPrincipal(), TelaConfigCamera.class);
                		intent.putExtra(ConstantesTelas.BD_CONFIG_CAMERA_CODIGO, codigo);
                		intent.putExtra(ConstantesTelas.BD_CONFIG_CAMERA_LISTA, lista);
                		InstanciasPortatil.getTelaPrincipal().startActivity(intent);
                    }
                });
                thread.start();
                Log.i(CATEGORIA, "Configurações recebidas!");
                 
            } else if (mensagem.equals(ConstantesRedes.CS_CONFIG_CAMERA_SALVAR)) {
                      
            	Log.i(CATEGORIA, "Confirmando alteração de configuração da câmera");
                handleConfigCamera();
                                
            } else if (mensagem.equals(ConstantesRedes.CS_CONFIG_ACIONAMENTO)) {
                
                final String codigo = cliente.getEntrada().readObject().toString();
                final ArrayList<String> lista = (ArrayList<String>) cliente.getEntrada().readObject();
                
                handleCenario("-1");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                    	Intent intent = new Intent(InstanciasPortatil.getTelaPrincipal(), TelaConfigCenario.class);
                		intent.putExtra(ConstantesTelas.BD_CONFIG_CENARIO_CODIGO, codigo);
                		intent.putExtra(ConstantesTelas.BD_CONFIG_CENARIO_LISTA, lista);
                		InstanciasPortatil.getTelaPrincipal().startActivity(intent);
                    }
                });
                thread.start();
                Log.i(CATEGORIA, "Configurações do cenário receebida!");
                
            } else if (mensagem.equals(ConstantesRedes.CS_CONFIG_ACIONAMENTO_SALVAR)) {
                
            	Log.i(CATEGORIA, "Confirmando alteração de configuração do cenário");
                handleConfigCenario();
                
            } else if (mensagem.equals(ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS)) {
            	
            	String confirmacao = cliente.getEntrada().readObject().toString();
            	handleLocalizacao(confirmacao);
                if(confirmacao.equals("0")) {
                	String latitude = cliente.getEntrada().readObject().toString();
                    String longitude = cliente.getEntrada().readObject().toString();
                    
                    Intent intent = new Intent(InstanciasPortatil.getTelaPrincipal(), TelaMapa.class);
            		intent.putExtra(ConstantesTelas.BD_MAPA_LATITUDE, Double.parseDouble(latitude));
            		intent.putExtra(ConstantesTelas.BD_MAPA_LONGITUDE, Double.parseDouble(longitude));
            		InstanciasPortatil.getTelaPrincipal().startActivity(intent);
                }    
                Log.i(CATEGORIA, "Localização GPS Informada!");
                
            }

        } catch (IOException ex) {
        	Log.e(CATEGORIA, "TrataMensagem-Cliente: "+ex);
    	} catch (ClassNotFoundException ex) {
    		Log.e(CATEGORIA, "TrataMensagem-Cliente: "+ex);
        }
    }
    
    public void enviarMensagemServidor(Cliente cliente, String tipo, String usuario, String senha) {
        if (tipo.equals(ConstantesRedes.CS_INICIAR_CONEXAO)) {
            cliente.enviarDados(ConstantesRedes.CS_INICIAR_CONEXAO);
            cliente.enviarDados(usuario);
            cliente.enviarDados(senha);
        }
    }

    /*
     * COMUNS
     */

    private void guardaMensagens(String usuario, String mensagem) {
        if (InstanciasPortatil.getGuardaMensagens() == null) {
            ArrayList<GuardaMensagem> guardaMensagems = new ArrayList<GuardaMensagem>();
            InstanciasPortatil.setGuardaMensagens(guardaMensagems);
        }
        GuardaMensagem guardaMensagem = new GuardaMensagem();
        guardaMensagem.setContato(usuario);
        guardaMensagem.setMensagem(mensagem);
        InstanciasPortatil.getGuardaMensagens().add(guardaMensagem);
    }
    
    /*
     * HANDLE
     */
    
    public void handleConectar(String confirmacao) {
    	Bundle bundle = new Bundle();
    	bundle.putString(ConstantesTelas.BD_CONFIRMACAO_CONEXAO, confirmacao);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CONECTAR;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleMensagem() {
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_MENSAGEM;
    	handler.sendMessage(message);
    }
    
    private void handleCenarioPreencherLista(Integer acesso) {
    	Bundle bundle = new Bundle();
    	bundle.putInt(ConstantesTelas.BD_ACESSO, acesso);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CENARIO_PREENCHER_LISTA;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleCenario(String confirmacao) {
    	Bundle bundle = new Bundle();
    	bundle.putString(ConstantesTelas.BD_CONFIRMACAO_CENARIO, confirmacao);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CENARIO;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }

    private void handleDispositivoPreencherLista(Integer acesso) {
    	Bundle bundle = new Bundle();
    	bundle.putInt(ConstantesTelas.BD_ACESSO, acesso);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_DISPOSITIVO_PREENCHER_LISTA;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleDispositivoAcionar(String confirmacao) {
    	Bundle bundle = new Bundle();
    	bundle.putString(ConstantesTelas.BD_CONFIRMACAO_DISPOSITIVO, confirmacao);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_DISPOSITIVO;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleCameraPreencherLista(Integer acesso) {
    	Bundle bundle = new Bundle();
    	bundle.putInt(ConstantesTelas.BD_ACESSO, acesso);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CAMERA_PREENCHER_LISTA;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleCamera(String confirmacao) {
    	Bundle bundle = new Bundle();
    	bundle.putString(ConstantesTelas.BD_CONFIRMACAO_CAMERA, confirmacao);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CAMERA;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleClientesConectados() {
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_USUARIOS;
    	handler.sendMessage(message);
    }
    
    private void handleLocalizacao(String confirmacao) {
    	Bundle bundle = new Bundle();
    	bundle.putString(ConstantesTelas.BD_CONFIRMACAO_LOCALIZACAO, confirmacao);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_LOCALIZACAO_USUARIO;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }
    
    private void handleConfigCamera() {
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CONFIG_CAMERA;
    	handler.sendMessage(message);
    }
    
    private void handleConfigCenario() {
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_CONFIG_CENARIO;
    	handler.sendMessage(message);
    }
    
    private void handlePrincipal(String confirmacao) {
    	Bundle bundle = new Bundle();
    	bundle.putString(ConstantesTelas.BD_ULTIMA_FOTO, confirmacao);
    	Message message = new Message();
    	message.what = ConstantesTelas.HD_ULTIMA_FOTO;
    	message.setData(bundle);
    	handler.sendMessage(message);
    }

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
    
}

