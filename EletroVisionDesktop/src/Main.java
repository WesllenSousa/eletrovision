
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import controle.audio.GerenciarAudio;
import recursos.configuracoes.bloqueio.ArquivoBloqueio;
import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.Raiz;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.sistema.ConfigConexaoBanco;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigMensagens;
import recursos.configuracoes.sistema.ConfigGerais;
import controle.expiao.Expiar;
import controle.mensagens.sistema.Mensagens;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.camera.IniciarCameras;
import controle.openCV_javaCV_Pro.processamento.dependencias.SalvarImgDetectada;
import controle.quartz.ShedulerAgendarTarefas;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import recursos.instancias.InstanciasControle;
import telas.principal.TelaSplash;
import telas.principal.Login;
import util.SistemaOperacional;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Main {

    private ConfigDispositivos configDispositivos = new ConfigDispositivos();
    private ConfigGerais configGerais = new ConfigGerais();

    private Boolean statusIniciaExpiao = true;
    private Boolean statusIniciaCameras = true;
    private Boolean statusIniciaAgendamento = true;

    public Main() throws InterruptedException, InvocationTargetException {
        carregaLookAndFeel();

        TelaSplash splash = new TelaSplash();
        splash.atualizarBarraProgresso(10);

        inicializarNativeSwing();
        obtemRaizProjeto();
        //obtemRaizExecutavel();

        splash.atualizarBarraProgresso(20);
        iniciarClasses();

        splash.atualizarBarraProgresso(50);
        carregarConfiguracoes();
        if (ArquivoBloqueio.arquivoBloqueio()) {
            System.exit(0);
        }

        splash.atualizarBarraProgresso(70);
        iniciarProcessos();

        splash.atualizarBarraProgresso(90);
        Login login = new Login(null, true);

        splash.atualizarBarraProgresso(100);
        splash.close();

        login.setVisible(true);

    }

    private void inicializarNativeSwing() {
        if (SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.WINDOWS) {
            NativeInterface.open();
        }
    }

    private void carregaLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new MintLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            MensagensErro.lookAndFeel(ex);
        }
    }

    private void iniciarClasses() {
        Mensagens msg = new Mensagens();
        InstanciasControle.setMensagens(msg);
        SalvarImgDetectada salvarImgDetectada = new SalvarImgDetectada();
        InstanciasControle.setSalvarImgDetectada(salvarImgDetectada);
        IniciarCameras iniciarCameras = new IniciarCameras();
        InstanciasControle.setIniciarCameras(iniciarCameras);
        GerenciarAudio gerenciarAudio = new GerenciarAudio();
        InstanciasControle.setGerenciarAudio(gerenciarAudio);
        ShedulerAgendarTarefas shedulerAgendarTarefas = new ShedulerAgendarTarefas();
        InstanciasControle.setShedulerAgendarTarefas(shedulerAgendarTarefas);
    }

    private void obtemRaizExecutavel() {
        try {
            String caminho = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            caminho = caminho.substring(1, caminho.lastIndexOf('/') + 1);
            Raiz.setRaiz(caminho);
        } catch (URISyntaxException e) {
            MensagensErro.raiz(e);
        }
    }

    private void obtemRaizProjeto() {
        Raiz.setRaiz(System.getProperty("user.dir"));
    }

    private void carregarConfiguracoes() {
        Properties props;

        props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.conexaoBanco());
        if (props != null) {
            ConfigConexaoBanco.setStatus(true);

            String banco = props.getProperty("banco");
            String driver = props.getProperty("driver");
            String nome = props.getProperty("nome");
            String host = props.getProperty("host");
            String porta = props.getProperty("porta");
            String usuario = props.getProperty("usuario");

            ConfigConexaoBanco.setBanco(banco);
            ConfigConexaoBanco.setDriver(driver);
            ConfigConexaoBanco.setHost(host);
            ConfigConexaoBanco.setNomeBanco(nome);
            ConfigConexaoBanco.setPorta(porta);
            ConfigConexaoBanco.setUsuario(usuario);
        } else {
            ConfigConexaoBanco.setStatus(false);
        }

        props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.gerais());
        if (props != null) {
            ConfigGerais.setStatus(true);

            String somCamera = props.getProperty("somCamera");
            String somSistema = props.getProperty("somSistema");
            String iniciarExpiao = props.getProperty("iniciarExpiao");
            String tempoCapturaExpiao = props.getProperty("tempoCapturaExpiao");
            String iniciarServidor = props.getProperty("iniciarServidor");
            String ativarAgendarTarefas = props.getProperty("ativarAgendarTarefas");
            String servico = props.getProperty("servico");
            String telaMaximizada = props.getProperty("telaMaximizada");

            if (somCamera.equals("0")) {
                ConfigGerais.setAtivarSomCamera(true);
            } else {
                ConfigGerais.setAtivarSomCamera(false);
            }
            if (somSistema.equals("0")) {
                ConfigGerais.setAtivarSomSistema(true);
            } else {
                ConfigGerais.setAtivarSomSistema(false);
            }
            ConfigGerais.setTempoExpiao(Integer.parseInt(tempoCapturaExpiao));
            if (iniciarExpiao.equals("0")) {
                configGerais.setExpiaoIniciaSistema(true);
            } else {
                configGerais.setExpiaoIniciaSistema(false);
            }
            if (iniciarServidor.equals("0")) {
                ConfigGerais.setServidorIniciarSistema(true);
            } else {
                ConfigGerais.setServidorIniciarSistema(false);
            }
            if (ativarAgendarTarefas.equals("0")) {
                ConfigGerais.setAtivarAgendarTarefas(true);
            } else {
                ConfigGerais.setAtivarAgendarTarefas(false);
            }
            if (servico.equals("0")) {
                ConfigGerais.setServico(0);
            } else {
                ConfigGerais.setServico(1);
            }
            if (telaMaximizada.equals("0")) {
                ConfigGerais.setTelaMaximizada(true);
            } else {
                ConfigGerais.setTelaMaximizada(false);
            }
        } else {
            ConfigGerais.setStatus(false);
            statusIniciaExpiao = false;
            statusIniciaAgendamento = false;
        }

        props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.dispositivos());
        if (props != null) {
            ConfigDispositivos.setStatus(true);

            String alarme = props.getProperty("alarme");
            String largura = props.getProperty("largura");
            String altura = props.getProperty("altura");
            String iniciarSistema = props.getProperty("iniciarSistema");
            String gravarVideo = props.getProperty("gravarVideo");
            String face = props.getProperty("face");
            String reconhecerFace = props.getProperty("reconhecerFace");
            String olhos = props.getProperty("olhos");
            String corpo = props.getProperty("corpo");
            String ativarAcionamento = props.getProperty("ativarAcionamento");
            String objetos = props.getProperty("objetos");
            String intervaloProcessamento = props.getProperty("intervaloProcessamento");
            String ativarDispositivosCameras = props.getProperty("ativarDispositivos");
            String tempoControleAutomatico = props.getProperty("tempoControleAutomatico");
            String movimento = props.getProperty("movimento");
            String alteracaoAmbiente = props.getProperty("alteracaoAmbiente");
            String codec = props.getProperty("codec");
            String sensibilidadeMovimento = props.getProperty("sensibilidadeMovimento");
            String campanhia = props.getProperty("campanhia");

            ConfigDispositivos.setAlarme(alarme);
            ConfigDispositivos.setLargura(Integer.parseInt(largura));
            ConfigDispositivos.setAltura(Integer.parseInt(altura));
            ConfigDispositivos.setIntervaloProcessamento(Integer.parseInt(intervaloProcessamento));
            ConfigDispositivos.setTempoControleAutomatico(Integer.parseInt(tempoControleAutomatico));
            ConfigDispositivos.setCodec(Integer.parseInt(codec));
            ConfigDispositivos.setSensibilidadeMovimento(Integer.parseInt(sensibilidadeMovimento));
            if (iniciarSistema.equals("0")) {
                configDispositivos.setCameraIniciaSistema(true);
            } else {
                configDispositivos.setCameraIniciaSistema(false);
            }
            if (gravarVideo.equals("0")) {
                ConfigDispositivos.setGravarVideo(true);
            } else {
                ConfigDispositivos.setGravarVideo(false);
            }
            if (face.equals("0")) {
                ConfigDispositivos.setDetectarFace(true);
            } else {
                ConfigDispositivos.setDetectarFace(false);
            }
            if (reconhecerFace.equals("0")) {
                ConfigDispositivos.setReconhecerFaces(true);
            } else {
                ConfigDispositivos.setReconhecerFaces(false);
            }
            if (olhos.equals("0")) {
                ConfigDispositivos.setDetectarOlhos(true);
            } else {
                ConfigDispositivos.setDetectarOlhos(false);
            }
            if (corpo.equals("0")) {
                ConfigDispositivos.setDetectarCorpo(true);
            } else {
                ConfigDispositivos.setDetectarCorpo(false);
            }
            if (ativarAcionamento.equals("0")) {
                ConfigDispositivos.setAtivarAcionamento(true);
            } else {
                ConfigDispositivos.setAtivarAcionamento(false);
            }
            if (objetos.equals("0")) {
                ConfigDispositivos.setDetectarObjeto(true);
            } else {
                ConfigDispositivos.setDetectarObjeto(false);
            }
            if (ativarDispositivosCameras.equals("0")) {
                ConfigDispositivos.setAtivarDispositivosCamera(true);
            } else {
                ConfigDispositivos.setAtivarDispositivosCamera(false);
            }
            if (movimento.equals("0")) {
                ConfigDispositivos.setMovimento(true);
            } else {
                ConfigDispositivos.setMovimento(false);
            }
            if (alteracaoAmbiente.equals("0")) {
                ConfigDispositivos.setAlteracaoAmbiente(true);
            } else {
                ConfigDispositivos.setAlteracaoAmbiente(false);
            }
            if (campanhia.equals("0")) {
                ConfigDispositivos.setCampanhia(true);
            } else {
                ConfigDispositivos.setCampanhia(false);
            }
        } else {
            ConfigDispositivos.setStatus(false);
            statusIniciaCameras = false;
        }

        props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.mensagens());
        if (props != null) {
            ConfigMensagens.setStatus(true);

            String ativarMensagens = props.getProperty("ativarMensagens");
            String portaModem = props.getProperty("portaModem");
            String email = props.getProperty("email");
            String senha = props.getProperty("senha");
            String servidor = props.getProperty("servidor");
            String porta = props.getProperty("porta");
            String ativarCelular = props.getProperty("ativarCelular");
            String ativarEmail = props.getProperty("ativarEmail");
            String ativarRede = props.getProperty("ativarRede");

            ConfigMensagens.setPortaModem(portaModem);
            ConfigMensagens.setEmail(email);
            ConfigMensagens.setSenha(senha);
            ConfigMensagens.setServidor(servidor);
            ConfigMensagens.setPorta(Integer.parseInt(porta));
            if (ativarMensagens.equals("0")) {
                ConfigMensagens.setAtivarEnvioMensagens(true);
            } else {
                ConfigMensagens.setAtivarEnvioMensagens(false);
            }
            if (ativarCelular.equals("0")) {
                ConfigMensagens.setAtivarEnvioCelular(true);
            } else {
                ConfigMensagens.setAtivarEnvioCelular(false);
            }
            if (ativarEmail.equals("0")) {
                ConfigMensagens.setAtivarEnvioEmail(true);
            } else {
                ConfigMensagens.setAtivarEnvioEmail(false);
            }
            if (ativarRede.equals("0")) {
                ConfigMensagens.setAtivarEnvioRede(true);
            } else {
                ConfigMensagens.setAtivarEnvioRede(false);
            }
        } else {
            ConfigMensagens.setStatus(false);
        }
    }

    private void iniciarProcessos() {
        iniciaExpiao();
        iniciaCameras();
        iniciarAgendamentos();
    }

    private void iniciaExpiao() {
        if (statusIniciaExpiao) {
            if (configGerais.getExpiaoIniciaSistema()) {
                Expiar expiar = new Expiar();
                expiar.setStatus(Boolean.TRUE);
                Thread thread = new Thread(expiar);
                thread.start();
            }
        }
    }

    private void iniciaCameras() {
        if (statusIniciaCameras) {
            if (configDispositivos.getCameraIniciaSistema()) {
                IniciarCameras iniciarCameras = new IniciarCameras();
                iniciarCameras.detectarCamerasCadastradas(null);
                iniciarCameras.iniciarCaptura();
                InstanciasControle.setIniciarCameras(iniciarCameras);
            }
        }
    }

    private void iniciarAgendamentos() {
        if (statusIniciaAgendamento) {
            if (ConfigGerais.getAtivarAgendarTarefas()) {
                InstanciasControle.getShedulerAgendarTarefas().iniciar();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
        } catch (InterruptedException | InvocationTargetException ex) {
            MensagensErro.main(ex);
        }
    }

}
