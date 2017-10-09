package controle.mensagens;

import controle.audio.ExecutarAudio;
import controle.redes.Cliente;
import controle.redes.dependencias.ConstantesRedes;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import recursos.InstanciasPortatil;
import telas.TelaPrincipal;
import telas.ConfiguracaoCamera;
import telas.ConfiguracaoCenario;
import telas.Mapa;
import telas.dependencias.GuardaMensagem;
import telas.dependencias.VisualizadorImagem;
import util.ImagemUtil;

public class TrataMensagem {
    
    /*
     * MENSAGENS
     */
    public void verificaMensagemCliente(Cliente cliente, String mensagem) {
        try {
            /*
             * COMUNS
             */
            switch (mensagem) {
                case ConstantesRedes.CS_FIM: {
                        cliente.fecharConexao();
                        InstanciasPortatil.getMensagens().aviso("Desconectado!");
                        TelaPrincipal.mi_conectar.setText("Conectar");
                        System.out.println("Cliente - Cliente desconectado.");
                        break;
                    }
                case ConstantesRedes.CS_CONECTANDO: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        InstanciasPortatil.getTelaLogin().confirmaConexao(confirmacao);
                        break;
                    }
                case ConstantesRedes.CS_MENSAGEM: {
                        String usuario = cliente.getEntrada().readObject().toString();
                        String texto = cliente.getEntrada().readObject().toString();
                        String tipo = cliente.getEntrada().readObject().toString();

                        System.out.println("Recebendo mensagem ");
                        switch (tipo) {
                            case ConstantesRedes.TP_PESSOAS_DETECTADAS:
                                ExecutarAudio.pessoasDetectadas();
                                break;
                            case ConstantesRedes.TP_CENARIO_ACIONADO:
                                ExecutarAudio.cenarioAcionado();
                                break;
                            case ConstantesRedes.TP_DISPOSITIVO_LIGADO:
                                ExecutarAudio.dispositivoAcionado();
                                break;
                            case ConstantesRedes.TP_AGENDAMENTO_DISPARADO:
                                ExecutarAudio.agendamentoDisparado();
                                break;
                            case ConstantesRedes.TP_FACE_RECONHECIDA:
                                ExecutarAudio.faceReconhecida();
                                break;
                            case ConstantesRedes.TP_VISITA:
                                ExecutarAudio.visita();
                                break;
                            case ConstantesRedes.TP_MOVIMENTO_DETECTADO:
                                ExecutarAudio.movimento();
                                break;
                            case ConstantesRedes.TP_AMBIENTE_ALTERADO:
                                ExecutarAudio.ambiente();
                                break;
                            default:
                                ExecutarAudio.telefone();
                                break;
                        }

                        guardaMensagens(usuario, texto);
                        if (InstanciasPortatil.getTelaMensagens() != null) {
                            InstanciasPortatil.getTelaMensagens().receber();
                        }
                        break;
                    }
                case ConstantesRedes.CS_CLIENTE_CONECTADOS: {
                        ArrayList<ClientesConectado> lista = (ArrayList<ClientesConectado>) cliente.getEntrada().readObject();
                        InstanciasPortatil.setClientesConectados(lista);
                        InstanciasPortatil.getTelaClientesConectados().carregaTabela();
                        break;
                    }
                case ConstantesRedes.CS_DISPOSITIVOS: {
                        ArrayList<GuardaDispositivo> lista = (ArrayList<GuardaDispositivo>) cliente.getEntrada().readObject();
                        if(!lista.isEmpty()) {
                            InstanciasPortatil.setGuardaDispositivos(lista); 
                            if(InstanciasPortatil.getTelaDispositivos() != null) {
                                InstanciasPortatil.getTelaDispositivos().carregarTabela();
                            }
                        } else {
                            InstanciasPortatil.getMensagens().aviso("Nenhum dispositivo cadastrado ou Acesso negado!");
                            InstanciasPortatil.getTelaDispositivos().getCarregamento().dispose();
                        }
                        break;
                    }
                case ConstantesRedes.CS_ACIONAR_DISPOSITIVOS: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        InstanciasPortatil.getTelaDispositivos().confirmacao(confirmacao);
                        break;
                    }
                case ConstantesRedes.CS_CENARIOS: {
                        ArrayList<GuardaCenario> lista = (ArrayList<GuardaCenario>) cliente.getEntrada().readObject();
                        if(!lista.isEmpty()) {
                            InstanciasPortatil.setGuardaCenarios(lista);
                            if(InstanciasPortatil.getTelaCenario() != null) {
                                InstanciasPortatil.getTelaCenario().carregarTabela();
                            }
                        } else {
                            InstanciasPortatil.getMensagens().aviso("Nenhum cenário cadastrado ou Acesso negado!");
                            InstanciasPortatil.getTelaCenario().getCarregamento().dispose();
                        }
                        break;
                    }
                case ConstantesRedes.CS_ACIONAR_CENARIOS: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        InstanciasPortatil.getTelaCenario().confirmacao(confirmacao);
                        break;
                    }
                case ConstantesRedes.CS_CAMERAS: {
                        ArrayList<GuardaCamera> lista = (ArrayList<GuardaCamera>) cliente.getEntrada().readObject();
                        if(!lista.isEmpty()) {
                            InstanciasPortatil.setGuardaCameras(lista);
                            if(InstanciasPortatil.getTelaCameras() != null) {
                                InstanciasPortatil.getTelaCameras().carregarTabela();
                            }
                        } else {
                            InstanciasPortatil.getMensagens().aviso("Nenhuma câmera cadastrada ou Acesso negado!");
                            InstanciasPortatil.getTelaCameras().getCarregamento().dispose();
                        }
                        break;
                    }
                case ConstantesRedes.CS_TIRAR_FOTO: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        InstanciasPortatil.getTelaCameras().confirmacao(confirmacao);
                        if(confirmacao.equals("1")) {
                            byte[] bytes = ImagemUtil.lerBytesImagem(cliente.getEntrada());
                            BufferedImage imagem = ImagemUtil.byteParaImage(bytes);
                            VisualizadorImagem dialog = new VisualizadorImagem(null, true);
                            dialog.exibeImagem(imagem);
                            dialog.setVisible(true); 
                        } 
                        break;
                    }
                case ConstantesRedes.CS_TIRAR_ULTIMA_FOTO: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        InstanciasPortatil.getTelaPrincipal().fecharCarregamento();
                        
                        if(confirmacao.equals("1")) {
                            byte[] bytes = ImagemUtil.lerBytesImagem(cliente.getEntrada());
                            BufferedImage imagem = ImagemUtil.byteParaImage(bytes);
                            VisualizadorImagem dialog = new VisualizadorImagem(null, true);
                            dialog.exibeImagem(imagem);
                            dialog.setVisible(true);
                        } else {
                            InstanciasPortatil.getMensagens().aviso("Última foto indisponível!"); 
                        }
                        break;
                    }
                case ConstantesRedes.CS_CONFIG_CAMERA: {
                        final String codigo = cliente.getEntrada().readObject().toString();
                        final ArrayList<String> lista = (ArrayList<String>) cliente.getEntrada().readObject();
                        System.out.println("Recebendo configuração da câmera");
                        InstanciasPortatil.getTelaCameras().getCarregamento().dispose();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConfiguracaoCamera dialog = new ConfiguracaoCamera(null, true);
                                InstanciasPortatil.setConfiguracaoCamera(dialog); 
                                dialog.setCodigo(Integer.parseInt(codigo));
                                dialog.preencheCampos(lista);
                                dialog.setVisible(true); 
                            }
                        });
                        thread.start();
                        break; 
                    }
                case ConstantesRedes.CS_CONFIG_CAMERA_SALVAR: {
                        System.out.println("Confirmando alteração de configuração da câmera");
                        InstanciasPortatil.getConfiguracaoCamera().confirmacao();
                        break;
                    }
                case ConstantesRedes.CS_CONFIG_ACIONAMENTO: {
                        final String codigo = cliente.getEntrada().readObject().toString();
                        final ArrayList<String> lista = (ArrayList<String>) cliente.getEntrada().readObject();
                        System.out.println("Recebendo configuração do cenário");
                        InstanciasPortatil.getTelaCenario().getCarregamento().dispose();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConfiguracaoCenario dialog = new ConfiguracaoCenario(null, true);
                                InstanciasPortatil.setConfiguracaoCenario(dialog); 
                                dialog.setCodigo(Integer.parseInt(codigo));
                                dialog.preencheCampos(lista);
                                dialog.setVisible(true); 
                            }
                        });
                        thread.start();
                        break; 
                    }
                case ConstantesRedes.CS_CONFIG_ACIONAMENTO_SALVAR: {
                        System.out.println("Confirmando alteração de configuração do cenário");
                        InstanciasPortatil.getConfiguracaoCenario().confirmacao();
                        break;
                    }
                case ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        if(confirmacao.equals("0")) {
                            String latitude = cliente.getEntrada().readObject().toString();
                            String longitude = cliente.getEntrada().readObject().toString();
                            Mapa mapa = new Mapa(Double.parseDouble(latitude), Double.parseDouble(longitude));
                            mapa.setVisible(true); 
                        } else {
                            InstanciasPortatil.getMensagens().aviso("GPS do usuário desligado!");
                        }
                        break;
                    }
            }
        } catch (IOException | ClassNotFoundException ex) {
            InstanciasPortatil.getMensagens().bug("Erro no método verificaMensagemCliente.\n" + ex);
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
            ArrayList<GuardaMensagem> guardaMensagems = new ArrayList<>();
            InstanciasPortatil.setGuardaMensagens(guardaMensagems);
        }
        GuardaMensagem guardaMensagem = new GuardaMensagem();
        guardaMensagem.setContato(usuario);
        guardaMensagem.setMensagem(mensagem);
        InstanciasPortatil.getGuardaMensagens().add(guardaMensagem);
    }
    
}
