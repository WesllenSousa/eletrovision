package controle.mensagens.rede;

import EletroVisionPortatil.dependencias.VisualizadorImagem;
import EletroVisionPortatil.dependencias.GuardaMensagem;
import EletroVisionPortatil.dependencias.InstanciasPortatil;
import EletroVisionPortatil.ConfiguracaoCenario;
import EletroVisionPortatil.ConfiguracaoCamera;
import EletroVisionPortatil.Mapa;
import EletroVisionPortatil.TelaPrincipal;
import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.diretorios.caminhos.ArquivosDiversos;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import controle.mapa.GuardaLocalizacaoGPS;
import controle.mensagens.sistema.MontarMensagens;
import controle.dispositivos.AcionarDispositivo;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import controle.redes.Cliente;
import controle.redes.ClienteEntrada;
import recursos.constantes.ConstantesRedes;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.configCamera.bean.EnumAmbienteStaticoConfigCamera;
import entidades.configCamera.bean.EnumCampanhiaConfigCamera;
import entidades.configCamera.bean.EnumCorpoConfigCamera;
import entidades.configCamera.bean.EnumDispositivoConfigCamera;
import entidades.configCamera.bean.EnumFaceConfigCamera;
import entidades.configCamera.bean.EnumGravarConfigCamera;
import entidades.configCamera.bean.EnumMovimentoConfigCamera;
import entidades.configCamera.bean.EnumObjetoConfigCamera;
import entidades.configCamera.bean.EnumOlhosConfigCamera;
import entidades.configCamera.bean.EnumReconhecerFaceConfigCamera;
import entidades.configCamera.bean.EnumTipoProcessamentoConfigCamera;
import entidades.configCamera.facade.ConfigCameraFacade;
import entidades.configPessoa.bean.EnumAlarmeGpsConfigPessoa;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.modulo.bean.ModuloBean;
import entidades.movimento.bean.MovimentoBean;
import entidades.movimento.facade.MovimentoFacade;
import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.PessoaBean;
import entidades.usuario.bean.UsuarioBean;
import entidades.usuario.facade.UsuarioFacade;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.principal.AnimacaoPrincipal;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;
import util.GpsUtil;
import util.ImagemUtil;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;

public class TrataMensagem {

    private SalvarLogAcoes salvarLogAcoes = new SalvarLogAcoes();   

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
                        if(TelaPrincipal.mi_conectar != null) {
                            TelaPrincipal.mi_conectar.setText("Conectar");
                        }
                        System.out.println("Cliente - Cliente desconectado.");
                        break;
                    }
                case ConstantesRedes.CS_CONECTANDO: {
                        String confirmacao = cliente.getEntrada().readObject().toString();
                        if(InstanciasPortatil.getTelaLogin() != null) {
                            InstanciasPortatil.getTelaLogin().confirmaConexao(confirmacao);
                        }
                        break;
                    }
                case ConstantesRedes.CS_MENSAGEM: {
                        String usuario = cliente.getEntrada().readObject().toString();
                        String texto = cliente.getEntrada().readObject().toString();
                        String tipo = cliente.getEntrada().readObject().toString();

                        System.out.println("Recebendo mensagem ");
                        switch (tipo) {
                            case ConstantesRedes.TP_PESSOAS_DETECTADAS:
                                break;
                            case ConstantesRedes.TP_CENARIO_ACIONADO:
                                break;
                            case ConstantesRedes.TP_DISPOSITIVO_LIGADO:
                                break;
                            case ConstantesRedes.TP_AGENDAMENTO_DISPARADO:
                                break;
                            case ConstantesRedes.TP_FACE_RECONHECIDA:
                                break;
                            case ConstantesRedes.TP_VISITA:
                                break;
                            case ConstantesRedes.TP_MOVIMENTO_DETECTADO:
                                break;
                            case ConstantesRedes.TP_AMBIENTE_ALTERADO:
                                break;
                        }

                        if(InstanciasPortatil.getTelaPrincipal() != null) { //Somente para portátil imbutido do EletroVision Desktop
                            guardaMensagens(usuario, texto);
                            if (InstanciasPortatil.getTelaMensagens() != null) {
                                InstanciasPortatil.getTelaMensagens().receber();
                            }
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
                            if (InstanciasPortatil.getTelaDispositivos() != null) {
                                InstanciasPortatil.getTelaDispositivos().carregarTabela();
                            }
                        }
        //                else {
        //                    GuardaInstancias.getMensagens().aviso("Nenhum dispositivo cadastrado ou Acesso negado!");
        //                }
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
                            if (InstanciasPortatil.getTelaCenario() != null) {
                                InstanciasPortatil.getTelaCenario().carregarTabela();
                            }
                        } 
        //                else {
        //                    GuardaInstancias.getMensagens().aviso("Nenhum cenário cadastrado ou Acesso negado!");
        //                }
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
                            if (InstanciasPortatil.getTelaCameras() != null) {
                                InstanciasPortatil.getTelaCameras().carregarTabela();
                            }
                        }
        //                else {
        //                    GuardaInstancias.getMensagens().aviso("Nenhuma câmera cadastrada ou Acesso negado!");
        //                }
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
                        if(InstanciasPortatil.getTelaPrincipal() != null) {
                            InstanciasPortatil.getTelaPrincipal().fecharCarregamento();
                        }
                        
                        if(confirmacao.equals("1")) {
                            byte[] bytes = ImagemUtil.lerBytesImagem(cliente.getEntrada());
                            BufferedImage imagem = ImagemUtil.byteParaImage(bytes);
                            VisualizadorImagem dialog = new VisualizadorImagem(null, true);
                            dialog.exibeImagem(imagem);
                            dialog.setVisible(true);
                        } else {
                            InstanciasControle.getMensagens().aviso(MensagensSoltas.portatilUltimaFoto()); 
                        }
                        System.out.println("Última foto recebida.");
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
                            InstanciasPortatil.getMensagens().aviso(MensagensSoltas.portatilGpsDesligado());
                        }
                        break;
                    }
            }
        } catch (IOException | ClassNotFoundException ex) {
            InstanciasPortatil.getMensagens().bug("Erro no método verificaMensagemCliente.\n" + ex);
        }
        
    }

    public void verificarMensagemServidor(ClienteEntrada clienteEntrada, String mensagem) {
        try {
            /*
             * COMUNS
             */
            switch (mensagem) {
                case ConstantesRedes.CS_FIM: {
                        if (clienteEntrada.getUsuario() != null) {
                            removeClienteConectado(clienteEntrada.getUsuario().getPessoa().getNome());
                        }
                        String msg = "Cliente(s) desconectado(s)!";
                        enviarMensagem(clienteEntrada, msg, "0");
                        clienteEntrada.fecharConexao();
                        System.out.println("Servidor - Cliente desconectado.");
                        break;
                    }
                case ConstantesRedes.CS_INICIAR_CONEXAO: {
                        String login = clienteEntrada.getEntrada().readObject().toString();
                        String senha = clienteEntrada.getEntrada().readObject().toString();
                        UsuarioBean usuario = verificaUsuarioSenha(login, senha);
                        Integer identificacaoConversa = 1; //clienteEntrada.getServidor().gerarIdentificacao();
                        clienteEntrada.setIdentificacaoConversa(identificacaoConversa);
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        if (usuario != null) {
                            //0: falha no login, 1: logado com sucesso, 2: usuario já logado 
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CONECTANDO, porta);
                            if (verificaUsuarioLogado(usuario.getPessoa().getNome())) {
                                clienteEntrada.setUsuario(usuario);
                                adicionarClienteConectado(clienteEntrada, usuario.getPessoa().getNome());

                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "1", porta);
                            } else {
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "2", porta);
                            }
                        } else {
                            clienteEntrada.getServidor().enviarDados(1, ConstantesRedes.CS_CONECTANDO, porta);
                            clienteEntrada.getServidor().enviarDados(1, "0", porta);
                        }
                        break;
                    }
                case ConstantesRedes.CS_MENSAGEM: {
                        String texto = clienteEntrada.getEntrada().readObject().toString();
                        String tipo = clienteEntrada.getEntrada().readObject().toString();
                        enviarMensagem(clienteEntrada, texto, tipo);
                        
                        switch (tipo) {
                            case ConstantesRedes.TP_PESSOAS_DETECTADAS:
                                break;
                            case ConstantesRedes.TP_CENARIO_ACIONADO:
                                break;
                            case ConstantesRedes.TP_DISPOSITIVO_LIGADO:
                                break;
                            case ConstantesRedes.TP_AGENDAMENTO_DISPARADO:
                                break;
                            case ConstantesRedes.TP_FACE_RECONHECIDA:
                                break;
                            case ConstantesRedes.TP_VISITA:
                                break;
                            case ConstantesRedes.TP_MOVIMENTO_DETECTADO:
                                break;
                            case ConstantesRedes.TP_AMBIENTE_ALTERADO:
                                break;
                            default:
                                salvarMensagem(populaMensagemBean(clienteEntrada.getUsuario().getPessoa(), texto));
                                break;
                        }
                        
                        break;
                    }
                case ConstantesRedes.CS_CLIENTE_CONECTADOS: {
                        System.out.println("Solicitando clientes conectados.");
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CLIENTE_CONECTADOS, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getClientesConectados(), porta);
                        break;
                    }
                case ConstantesRedes.CS_DISPOSITIVOS: {
                        System.out.println("Enviando lista de dispositivos");
                        verificaDispositivos(clienteEntrada.getUsuario());
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_DISPOSITIVOS);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaDispositivos());
                        break;
                    }
                case ConstantesRedes.CS_ACIONAR_DISPOSITIVOS: {
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        DispositivoEletricoBean dispositivoEletrico = selecionarDispositivo(Integer.parseInt(codigo));
                        System.out.println("ligando ou desligando dispositivo");
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        if (ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()) {
                            if (dispositivoEletrico != null) { 
                                Boolean acionar;
                                if (dispositivoEletrico.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.DESLIGADO) {
                                    acionar = AcionarDispositivo.ligarDispositivo(dispositivoEletrico);
                                } else {
                                    acionar = AcionarDispositivo.desligarDispositivo(dispositivoEletrico);
                                }
                                if (acionar) {
                                    verificaDispositivos(clienteEntrada.getUsuario());
                                    animarDispositivo();
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_DISPOSITIVOS);
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaDispositivos());
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_ACIONAR_DISPOSITIVOS, porta);
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "1", porta);
                                    salvarLogAcoes.salvarDispositivoEletrico(dispositivoEletrico, clienteEntrada.getUsuario().getPessoa(), EnumRedeLogAcoes.SIM);
                                    atualizaTelas();
                                    System.out.println("Dispositivo ligado!");
                                } else {
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_ACIONAR_DISPOSITIVOS, porta);
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "0", porta);
                                    enviarMensagem(clienteEntrada, 
                                            MontarMensagens.dispositivoFalha(clienteEntrada.getUsuario().getPessoa(), dispositivoEletrico),"0");
                                    System.out.println("Dispositivo não encontrado!");
                                }
                            }
                        } else {
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_ACIONAR_DISPOSITIVOS, porta);
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "2", porta);
                            enviarMensagem(clienteEntrada, 
                                    MontarMensagens.dispositivoConfiguracao(clienteEntrada.getUsuario().getPessoa(), dispositivoEletrico),"0");  
                            System.out.println("Dispositivo não acionado!");
                        }
                        break;
                    }
                case ConstantesRedes.CS_CENARIOS: {
                        System.out.println("Enviando lista de cenários");
                        verificaCenarios(clienteEntrada.getUsuario());
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CENARIOS);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaCenarios());
                        break;
                    }
                case ConstantesRedes.CS_ACIONAR_CENARIOS: {
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        String status = clienteEntrada.getEntrada().readObject().toString(); //0: desligado, 1: ligado    
                        AcionamentoBean acionamento = selecionarAcionamento(Integer.parseInt(codigo));
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        if (ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()
                                && acionamento.getStatus() == EnumStatusAcionamento.ATIVO) {
                            Boolean acionar = false;
                            for (ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                                switch (status) {
                                    case "0":
                                        if(item.getDispositivoEletrico().getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
                                            acionar = AcionarDispositivo.desligarDispositivo(item.getDispositivoEletrico());
                                        } else {
                                            acionar = true;
                                        }
                                        break;
                                    case "1":
                                        if(item.getDispositivoEletrico().getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.DESLIGADO) {
                                            acionar = AcionarDispositivo.ligarDispositivo(item.getDispositivoEletrico());
                                        } else {
                                            acionar = true;
                                        }
                                        break;
                                }
                                if (!acionar) {
                                    break;
                                }
                            }
                            if (acionar) { 
                                switch (status) {
                                    case "0":
                                        acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.DESLIGADO);
                                        break;
                                    case "1":
                                        acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.LIGADO);
                                        break;
                                }
                                alterarAcionamento(acionamento);
                                verificaCenarios(clienteEntrada.getUsuario());
                                animarDispositivo();
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CENARIOS);
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaCenarios());
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_ACIONAR_CENARIOS, porta);
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "1", porta);
                                salvarLogAcoes.salvarAcionamento(acionamento, clienteEntrada.getUsuario().getPessoa(), EnumRedeLogAcoes.SIM);
                                atualizaTelas();
                                System.out.println("Acionamento executado com sucesso!");
                            } else {
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_ACIONAR_CENARIOS, porta);
                                clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "0", porta);
                                enviarMensagem(clienteEntrada, MontarMensagens.acionamentoFalha(clienteEntrada.getUsuario().getPessoa(), acionamento),"0");
                                System.out.println("Acionamento não acionado!");
                            }
                        } else {
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_ACIONAR_CENARIOS, porta); 
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "2", porta);
                            enviarMensagem(clienteEntrada, MontarMensagens.acionamentoConfiguracao(clienteEntrada.getUsuario().getPessoa(), acionamento),"0");
                            System.out.println("Dispositivo não acionado!");
                        }
                        break;
                    }
                case ConstantesRedes.CS_CAMERAS: {
                        System.out.println("Enviando lista de câmeras");
                        verificaCameras(clienteEntrada.getUsuario());
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CAMERAS);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaCameras());
                        break;
                    }
                case ConstantesRedes.CS_TIRAR_FOTO: {
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        System.out.println("Tirando foto...");
                        CameraBean camera = selecionarCamera(Integer.parseInt(codigo));
                        String confirmacao="";
                        String arquivo = "";
                        if (InstanciasControle.getIniciarCameras().getStatus()) {
                            if(camera.getStatus() == EnumStatusDispositivo.ATIVO) {
                                for (ServidorCamera cam : InstanciasControle.getIniciarCameras().getServidoresCameras()) {
                                    if (cam.getCamera().getCodigo() == camera.getCodigo()) {
                                        arquivo = ArquivosDiversos.redes() + File.separator + System.currentTimeMillis() + ".jpg";
                                        ImagemUtil.salvar(cam.getBufferedImage(), arquivo);
                                        confirmacao = "1";
                                        break;
                                    }
                                }
                                if("".equals(confirmacao)) {
                                    confirmacao = "2";
                                }
                            } else {
                                confirmacao = "2";
                            }
                        } else {
                            confirmacao = "0";
                        }
                        byte[] bytes = null;
                        if(!arquivo.equals("")) {
                            bytes = ImagemUtil.imagemParaByte(new File(arquivo));
                        }
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        if(confirmacao.equals("1")) {
                            enviarMensagem(clienteEntrada, clienteEntrada.getUsuario().getPessoa()+" tirou uma foto!", "0");
                        }
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_TIRAR_FOTO, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), confirmacao, porta);
                        if(bytes != null) {
                            clienteEntrada.getServidor().enviaBytes(clienteEntrada.getIdentificacaoConversa(), bytes, bytes.length, porta);
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "", porta); //essa linha de código serve para completar o envio dos bytes
                        }
                        break;
                    }
                case ConstantesRedes.CS_TIRAR_ULTIMA_FOTO: {
                        MovimentoBean movimento = listarUltimoRegistroMovimento();
                        String diretorio = ArquivosImagens.diretorio_processamento()+movimento.getDiretorio();
                        byte[] bytes = ImagemUtil.imagemParaByte(new File(diretorio));
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_TIRAR_ULTIMA_FOTO, porta);
                        if(bytes != null) {
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "1", porta);
                            clienteEntrada.getServidor().enviaBytes(clienteEntrada.getIdentificacaoConversa(), bytes, bytes.length, porta);
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "", porta); //essa linha de código serve para completar o envio dos bytes
                            System.out.println("Última foto encaminhada...");
                        } else {
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "0", porta);
                            System.out.println("Erro ao enviar última foto");
                        }
                        break;
                    }
                case ConstantesRedes.CS_CONFIG_CAMERA: {
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        System.out.println("Solicitando configuração das câmeras");
                        CameraBean camera = selecionarCamera(Integer.parseInt(codigo));
                        
                        ArrayList<String> config = new ArrayList<>();
                        config.add(0, camera.getStatus().getOrdem().toString());
                        config.add(1, camera.getConfigCamera().getTipoProcessamento().getOrdem().toString());
                        config.add(2, camera.getConfigCamera().getMovimento().getOrdem().toString());
                        config.add(3, camera.getConfigCamera().getAmbienteStatico().getOrdem().toString());
                        config.add(4, camera.getConfigCamera().getObjeto().getOrdem().toString());
                        config.add(5, camera.getConfigCamera().getDispositivo().getOrdem().toString());
                        config.add(6, camera.getConfigCamera().getCampanhia().getOrdem().toString());
                        config.add(7, camera.getConfigCamera().getGravar().getOrdem().toString());
                        config.add(8, camera.getConfigCamera().getFace().getOrdem().toString());
                        config.add(9, camera.getConfigCamera().getOlhos().getOrdem().toString());
                        config.add(10, camera.getConfigCamera().getCorpo().getOrdem().toString());
                        config.add(11, camera.getConfigCamera().getReconhecerFace().getOrdem().toString());
                        
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CONFIG_CAMERA, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), codigo, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), config, porta);             
                        break;
                    }
                case ConstantesRedes.CS_CONFIG_CAMERA_SALVAR: {
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        ArrayList<String> configCamera = (ArrayList<String>) clienteEntrada.getEntrada().readObject();
                        System.out.println("Alterando câmeras...");
                        CameraBean camera = selecionarCamera(Integer.parseInt(codigo));
                        if(configCamera.get(0).equals("1")) {
                            camera.setStatus(EnumStatusDispositivo.ATIVO);
                        } else {
                            camera.setStatus(EnumStatusDispositivo.INATIVO);
                        }
                        if(configCamera.get(1).equals("0")) {
                            camera.getConfigCamera().setTipoProcessamento(EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE);
                        } else {
                            camera.getConfigCamera().setTipoProcessamento(EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO);
                        }
                        if(configCamera.get(2).equals("0")) {
                            camera.getConfigCamera().setMovimento(EnumMovimentoConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setMovimento(EnumMovimentoConfigCamera.NAO);
                        }
                        if(configCamera.get(3).equals("0")) {
                            camera.getConfigCamera().setAmbienteStatico(EnumAmbienteStaticoConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setAmbienteStatico(EnumAmbienteStaticoConfigCamera.NAO);
                        }
                        if(configCamera.get(4).equals("0")) {
                            camera.getConfigCamera().setObjeto(EnumObjetoConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setObjeto(EnumObjetoConfigCamera.NAO);
                        }
                        if(configCamera.get(5).equals("0")) {
                            camera.getConfigCamera().setDispositivo(EnumDispositivoConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setDispositivo(EnumDispositivoConfigCamera.NAO);
                        }
                        if(configCamera.get(6).equals("0")) {
                            camera.getConfigCamera().setCampanhia(EnumCampanhiaConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setCampanhia(EnumCampanhiaConfigCamera.NAO);
                        }
                        if(configCamera.get(7).equals("0")) {
                            camera.getConfigCamera().setGravar(EnumGravarConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setGravar(EnumGravarConfigCamera.NAO);
                        }
                        if(configCamera.get(8).equals("0")) {
                            camera.getConfigCamera().setFace(EnumFaceConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setFace(EnumFaceConfigCamera.NAO);
                        }
                        if(configCamera.get(9).equals("0")) {
                            camera.getConfigCamera().setOlhos(EnumOlhosConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setOlhos(EnumOlhosConfigCamera.NAO);
                        }
                        if(configCamera.get(10).equals("0")) {
                            camera.getConfigCamera().setCorpo(EnumCorpoConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setCorpo(EnumCorpoConfigCamera.NAO);
                        }
                        if(configCamera.get(11).equals("0")) {
                            camera.getConfigCamera().setReconhecerFace(EnumReconhecerFaceConfigCamera.SIM);
                        } else {
                            camera.getConfigCamera().setReconhecerFace(EnumReconhecerFaceConfigCamera.NAO);
                        }
                        alterarConfigCamera(camera.getConfigCamera());
                        alterarCamera(camera);
                        atualizaTelas();
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CONFIG_CAMERA_SALVAR, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CAMERAS);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaCameras());
                        break;
                    }
                case ConstantesRedes.CS_CONFIG_ACIONAMENTO: {
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        System.out.println("Solicitando configuração do cenário");
                        AcionamentoBean acionamento = selecionarAcionamento(Integer.parseInt(codigo));
                        ArrayList<String> config = new ArrayList<>();
                        config.add(0, acionamento.getStatus().getOrdem().toString());
                        config.add(1, acionamento.getTipo().getOrdem().toString());
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CONFIG_ACIONAMENTO, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), codigo, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), config, porta);
                        break;
                    }
                case ConstantesRedes.CS_CONFIG_ACIONAMENTO_SALVAR: {                       
                        String codigo = clienteEntrada.getEntrada().readObject().toString();
                        ArrayList<String> configAciomento = (ArrayList<String>) clienteEntrada.getEntrada().readObject();
                        
                        AcionamentoBean acionamento = selecionarAcionamento(Integer.parseInt(codigo));
                        
                        if(configAciomento.get(0).equals("1")) {
                            acionamento.setStatus(EnumStatusAcionamento.ATIVO);
                        } else {
                            acionamento.setStatus(EnumStatusAcionamento.INATIVO);
                        }
                        if(configAciomento.get(1).equals("0")) {
                            acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
                        } 
                        switch (configAciomento.get(1)) {
                            case "1":
                                acionamento.setTipo(EnumTipoAcionamento.CONTROLE_AUTOMATICO);
                                break;
                            case "2":
                                acionamento.setTipo(EnumTipoAcionamento.DETECTAR_PESSOAS);
                                break;
                            case "3":
                                acionamento.setTipo(EnumTipoAcionamento.RECONHECER_FACES);
                                break;
                            case "4":
                                acionamento.setTipo(EnumTipoAcionamento.ALARME);
                                break;
                            case "5":
                                acionamento.setTipo(EnumTipoAcionamento.MOVIMENTO);
                                break;
                        }
                        alterarAcionamento(acionamento);
                        atualizaTelas();
                        
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CONFIG_ACIONAMENTO_SALVAR, porta);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_CENARIOS);
                        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), InstanciasPortatil.getGuardaCenarios());
                        break;
                    }
                case ConstantesRedes.CS_POSTAR_LOCALIZACAO_GPS: {
                        System.out.println("postando localização GPS");
                        String latitude = clienteEntrada.getEntrada().readObject().toString();
                        String longitude = clienteEntrada.getEntrada().readObject().toString();
                        if(InstanciasControle.getGuardaLocalizacaoGPSs() == null) {
                            ArrayList<GuardaLocalizacaoGPS> lista = new ArrayList<>();
                            InstanciasControle.setGuardaLocalizacaoGPSs(lista);
                        }
                        GuardaLocalizacaoGPS localizacao = new GuardaLocalizacaoGPS();
                        localizacao.setUsario(clienteEntrada.getUsuario().getPessoa().getNome());
                        localizacao.setLatitude(Double.parseDouble(latitude));
                        localizacao.setLongitude(Double.parseDouble(longitude));
                        for(GuardaLocalizacaoGPS l : InstanciasControle.getGuardaLocalizacaoGPSs()) {
                            if(clienteEntrada.getUsuario().getPessoa().getNome().equals(l.getUsario())) {
                                InstanciasControle.getGuardaLocalizacaoGPSs().remove(l);
                                break;
                            }
                        }
                        InstanciasControle.getGuardaLocalizacaoGPSs().add(localizacao);
                        
                        if(clienteEntrada.getUsuario().getPessoa().getConfigPessoa().getAlarmeGps() == EnumAlarmeGpsConfigPessoa.ATIVAR) {
                            for(AcionamentoBean acionamento : listarAcionamentos()) {
                                if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento() && 
                                        acionamento.getStatus() == EnumStatusAcionamento.ATIVO && acionamento.getPredio() != null) {
                                    if(acionamento.getPredio().getConfigPredio() != null) {
                                        Double distancia = GpsUtil.getDistanciaMetros(Double.parseDouble(latitude), Double.parseDouble(longitude), 
                                                acionamento.getPredio().getConfigPredio().getLatitude(), acionamento.getPredio().getConfigPredio().getLongitude());
                                        System.out.println("Distância do prédio: "+distancia);
                                        if(distancia > 200.0) {
                                            acionamento.setTipo(EnumTipoAcionamento.ALARME);
                                        } else {
                                            for (ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                                                if(item.getDispositivoEletrico().getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
                                                    AcionarDispositivo.desligarDispositivo(item.getDispositivoEletrico());
                                                }
                                            }
                                            acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO); 
                                            acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.DESLIGADO);
                                        }
                                        alterarAcionamento(acionamento); 
                                    }
                                }
                            }
                        }
                        
                        atualizaTelas();
                        break;
                    }
                case ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS: {
                        String usuario = clienteEntrada.getEntrada().readObject().toString();
                        System.out.println("Solicitando localização GPS");
                        Boolean informou = false;
                        Integer porta = clienteEntrada.getClienteSaida().getSocket().getPort();
                        if(InstanciasControle.getGuardaLocalizacaoGPSs() != null) {
                            for(GuardaLocalizacaoGPS l : InstanciasControle.getGuardaLocalizacaoGPSs()) {
                                if(usuario.equals(l.getUsario())) {
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS, porta);
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "0", porta);
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), l.getLatitude().toString(), porta);
                                    clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), l.getLongitude().toString(), porta);
                                    informou = true;
                                    break;
                                }
                            }
                        }
                        if(informou == false) {
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS, porta);
                            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "1", porta);
                        }
                        break;
                    }
            }

        } catch (IOException | ClassNotFoundException ex) {
            InstanciasPortatil.getMensagens().bug("Erro no método verificarMensagemServidor.\n" + ex);
        }
    }

    public void enviarMensagemServidor(Cliente cliente, String tipo, String usuario, String senha) {
        if (tipo.equals(ConstantesRedes.CS_INICIAR_CONEXAO)) {
            cliente.enviarDados(ConstantesRedes.CS_INICIAR_CONEXAO);
            cliente.enviarDados(usuario);
            cliente.enviarDados(senha);
        }
    }
    
    private void enviarMensagem(ClienteEntrada clienteEntrada, String texto, String tipo) {
        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), ConstantesRedes.CS_MENSAGEM);
        if(clienteEntrada.getUsuario() != null) {
            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), clienteEntrada.getUsuario().getPessoa().getNome());
        } else {
            clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), "SERVIDOR");
        }
        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), texto);
        clienteEntrada.getServidor().enviarDados(clienteEntrada.getIdentificacaoConversa(), tipo);
    }

    /*
     * COMUNS
     */
    private UsuarioBean verificaUsuarioSenha(String login, String senha) {
        UsuarioBean usuario = selecionaUsuarioPorLogin(login);
        if (usuario != null) {
            if (usuario.getPessoa().getSituacao() == EnumSituacaoPessoa.ATIVO) {
                if (usuario.getSenha().equals(senha)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    private Boolean verificaUsuarioLogado(String usuario) {
        if (InstanciasPortatil.getClientesConectados() != null) {
            for (ClientesConectado c : InstanciasPortatil.getClientesConectados()) {
                if (c.getContato().equals(usuario)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void adicionarClienteConectado(ClienteEntrada clienteEntrada, String contato) {
        if (InstanciasPortatil.getClientesConectados() == null) {
            ArrayList<ClientesConectado> clientesConectados = new ArrayList<>();
            InstanciasPortatil.setClientesConectados(clientesConectados);
        }
        ClientesConectado clientesConectado = new ClientesConectado();
        clientesConectado.setContato(contato);
        clientesConectado.setHost(clienteEntrada.getClienteSaida().getSocket().getInetAddress().getHostName());
        clientesConectado.setIp(clienteEntrada.getClienteSaida().getSocket().getInetAddress().getHostAddress());
        clientesConectado.setPorta(clienteEntrada.getClienteSaida().getSocket().getPort());
        InstanciasPortatil.getClientesConectados().add(clientesConectado);
    }

    private void removeClienteConectado(String contato) {
        if(InstanciasPortatil.getClientesConectados() != null) {
            for (ClientesConectado clientesConectado : InstanciasPortatil.getClientesConectados()) {
                if (contato.equals(clientesConectado.getContato())) {
                    InstanciasPortatil.getClientesConectados().remove(clientesConectado);
                    System.out.println("Contato removido da lista de contatos conectados!");
                    break;
                }
            }
        }
    }

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

    public void animarRedes() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(6);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }

    private void animarDispositivo() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(4);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }

    /*
     * ESPECÍFICOS
     */
    private void verificaDispositivos(UsuarioBean usuario) {
        ArrayList<GuardaDispositivo> guardaDispositivos = new ArrayList<>();
        InstanciasPortatil.setGuardaDispositivos(guardaDispositivos);
        Boolean autorizado = false;
        for(ModuloBean modulo : usuario.getAutorizacao().getModulos()) {
            if(modulo.getNome().equals("Mapa Dispositivos")) {
                autorizado = true;
                break;
            }
        }
        if(autorizado) {
            for (DispositivoEletricoBean dispositivo : listarDispositivoEletricoNaoDeletado()) {
                GuardaDispositivo guardaDispositivo = new GuardaDispositivo();
                guardaDispositivo.setCodigo(dispositivo.getCodigo().toString());
                guardaDispositivo.setDispositivo(dispositivo.getNome());
                if (dispositivo.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
                    guardaDispositivo.setAcao("Desligar");
                } else {
                    guardaDispositivo.setAcao("Ligar");
                }
                InstanciasPortatil.getGuardaDispositivos().add(guardaDispositivo);
            }
        }
    }

    private void verificaCenarios(UsuarioBean usuario) {
        ArrayList<GuardaCenario> guardaCenarios = new ArrayList<>();
        InstanciasPortatil.setGuardaCenarios(guardaCenarios);
        Boolean autorizado = false;
        for(ModuloBean modulo : usuario.getAutorizacao().getModulos()) {
            if(modulo.getNome().equals("Cenario")) {
                autorizado = true;
                break;
            }
        }
        if(autorizado) {
            for (AcionamentoBean acionamento : listarAcionamentos()) {
                GuardaCenario guardaCenario = new GuardaCenario();
                guardaCenario.setCodigo(acionamento.getCodigo().toString());
                guardaCenario.setCenario(acionamento.getNome());
                if (acionamento.getLigarDesligar() == EnumLigarDesligarAcionamento.LIGADO) {
                    guardaCenario.setAcao("Desligar");
                } else {
                    guardaCenario.setAcao("Ligar");
                }
                guardaCenario.setConfiguracao("Alterar");
                InstanciasPortatil.getGuardaCenarios().add(guardaCenario);
            }
        }
    }

    private void verificaCameras(UsuarioBean usuario) {
        ArrayList<GuardaCamera> guardaCameras = new ArrayList<>();
        InstanciasPortatil.setGuardaCameras(guardaCameras);
        Boolean autorizado = false;
        for(ModuloBean modulo : usuario.getAutorizacao().getModulos()) {
            if(modulo.getNome().equals("Mapa Dispositivos")) {
                autorizado = true;
                break;
            }
        }
        if(autorizado) {
            for (CameraBean camera : listarCameraNaoDeletada()) {
                GuardaCamera guardaCamera = new GuardaCamera();
                guardaCamera.setCodigo(camera.getCodigo().toString());
                guardaCamera.setCamera(camera.getNome());
                guardaCamera.setAcao("Tirar Foto");
                guardaCamera.setConfiguracao("Alterar"); 
                InstanciasPortatil.getGuardaCameras().add(guardaCamera);
            }
        }
    }
    
    private void atualizaTelas() {
        AtualizaTelas.geralCenarios();
        AtualizaTelas.geralLocalizacaoGps();
        AtualizaTelas.geralMapaDispositivos();
    }
    
    private MensagemBean populaMensagemBean(PessoaBean oritem, String mensagem) {
        MensagemBean bean = new MensagemBean();

        bean.setAssunto("Rede");
        bean.setMensagem(mensagem);
        bean.setDataHora(Calendar.getInstance());
        bean.setOrigem(oritem);
        bean.setTipo(EnumTipoMensagem.REDE); 

        return bean;
    }

    /*
     * BANCO DE DADOS
     */
    
    private UsuarioBean selecionaUsuarioPorLogin(String login) {
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            return usuarioFacade.selecionaUsuarioPorLogin(login);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<DispositivoEletricoBean> listarDispositivoEletricoNaoDeletado() {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.listarDispositivoEletricoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private DispositivoEletricoBean selecionarDispositivo(Integer codigo) {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.selecionar(codigo);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<AcionamentoBean> listarAcionamentos() {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.listarAcionamentoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private AcionamentoBean selecionarAcionamento(Integer codigo) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.selecionar(codigo);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) {
        ItemAcionamentoFacade itemAcionamentoFacade = FactoryFacade.getItemAcionamentoImpl();
        try {
            return itemAcionamentoFacade.listarItemAcionamentoPorAcionamento(acionamento);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private void alterarAcionamento(AcionamentoBean acionamento) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            acionamentoFacade.alterar(acionamento);
        } catch (FacadeException ex) {
        }
    }
    
    private void alterarCamera(CameraBean camera) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            cameraFacade.alterar(camera);
        } catch (FacadeException ex) {
        }
    }
    
    private void alterarConfigCamera(ConfigCameraBean configCamera) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            configCameraFacade.alterar(configCamera);
        } catch (FacadeException ex) {
        }
    }

    private ArrayList<CameraBean> listarCameraNaoDeletada() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraNaoDeletada();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private CameraBean selecionarCamera(Integer codigo) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.selecionar(codigo);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private MovimentoBean listarUltimoRegistroMovimento() {
        MovimentoFacade movimentoFacade = FactoryFacade.getMovimentoImpl();
        try {
            return movimentoFacade.listarUltimoRegistro();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void salvarMensagem(MensagemBean mensagem) {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            mensagemFacade.inserir(mensagem);
        } catch (FacadeException ex) {
        }
    }
    
}
