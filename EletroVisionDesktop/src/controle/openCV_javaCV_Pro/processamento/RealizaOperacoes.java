package controle.openCV_javaCV_Pro.processamento;

import EletroVisionPortatil.dependencias.InstanciasPortatil;
import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigMensagens;
import controle.mensagens.celular.Celular;
import controle.mensagens.email.EnviarEmail;
import controle.mensagens.sistema.MontarMensagens;
import controle.dispositivos.AcionarDispositivo;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import recursos.constantes.ConstantesRedes;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.camera.bean.CameraBean;
import entidades.configCamera.bean.EnumCampanhiaConfigCamera;
import entidades.configCamera.bean.EnumDispositivoConfigCamera;
import entidades.configCamera.bean.EnumMovimentoConfigCamera;
import entidades.configCamera.bean.EnumAmbienteStaticoConfigCamera;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.movimento.bean.MovimentoBean;
import entidades.movimento.facade.MovimentoFacade;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import entidades.telefone.bean.EnumEnviarAutomaticoTelefone;
import entidades.telefone.bean.TelefoneBean;
import entidades.telefone.facade.TelefoneFacade;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import recursos.constantes.ConstantesSeguranca;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasControle;
import telas.principal.AnimacaoPrincipal;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RealizaOperacoes {
    
    public static final String ASSUNTO = ConstantesSistema.NOME_SISTEMA;
    
    private MovimentoBean movimento;
    private CameraBean camera;
    private String diretorio;
    private Calendar dataHora;
    private Integer condicao;
    private Boolean enviouMensagem = false;
    private SalvarLogAcoes salvarLogAcoes;
    
    private ServidorCamera s_camera;

    public RealizaOperacoes(ServidorCamera c_camera) {
        this.s_camera = c_camera;
        salvarLogAcoes = new SalvarLogAcoes();
    }

    public void inicia(CameraBean camera) {
        this.camera = camera;
        dataHora = Calendar.getInstance();
        condicao = s_camera.getStatusDeteccao().getObjetoCorpo();

        executarAudio();
        salvarImagem();
        salvarMovimento();
        if (condicao.equals(ConstantesSeguranca.OLHOS) || condicao.equals(ConstantesSeguranca.FACE) || condicao.equals(ConstantesSeguranca.CORPO)) {
            if (ConfigDispositivos.getCampanhia() && camera.getConfigCamera().getCampanhia() == EnumCampanhiaConfigCamera.SIM) {
                campanhia();
            } else {
                enviarMensagem(MontarMensagens.deteccao(movimento), ConstantesRedes.TP_PESSOAS_DETECTADAS);
            }
            if(camera.getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
                acionarDispositivoDetectarPessoas();
            }
        } else if(condicao.equals(ConstantesSeguranca.RECONHECER_FACE)) {
            if(camera.getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
                acionarDispositivoReconhecerFace();
            }
            enviarMensagem(MontarMensagens.faceReconhecida(s_camera.getStatusDeteccao()), ConstantesRedes.TP_FACE_RECONHECIDA);
        } else if(condicao.equals(ConstantesSeguranca.MOVIMENTO)) {
            if(ConfigDispositivos.getStatus() && ConfigDispositivos.getMovimento()
                    && camera.getConfigCamera().getMovimento() == EnumMovimentoConfigCamera.SIM) {
                enviarMensagem(MontarMensagens.movimento(movimento), ConstantesRedes.TP_MOVIMENTO_DETECTADO);
            }
        } else if(condicao.equals(ConstantesSeguranca.AMBIENTE_STATICO)) {
            if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAlteracaoAmbiente()
                    && camera.getConfigCamera().getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
                enviarMensagem(MontarMensagens.ambienteAlterado(movimento), ConstantesRedes.TP_AMBIENTE_ALTERADO);
            }
        } 
        limparStatusDeteccao();
    }

    private void executarAudio() {
        if (condicao.equals(ConstantesSeguranca.MOVIMENTO)) {
            if(ConfigDispositivos.getStatus() && ConfigDispositivos.getMovimento() 
                    && camera.getConfigCamera().getMovimento() == EnumMovimentoConfigCamera.SIM) {
                InstanciasControle.getGerenciarAudio().exeAlarme();
            }
        } else if (condicao.equals(ConstantesSeguranca.AMBIENTE_STATICO)) {
            if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAlteracaoAmbiente() 
                    && camera.getConfigCamera().getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
                InstanciasControle.getGerenciarAudio().exeAmbienteAlterado();
            }
        } else if (condicao.equals(ConstantesSeguranca.OBJETO)) {
            InstanciasControle.getGerenciarAudio().exeObjetoDetectado();
        } else if (condicao.equals(ConstantesSeguranca.FACE)) {
            InstanciasControle.getGerenciarAudio().exeFaceIdentificada(
                        s_camera.getStatusDeteccao().getQtdePessoas());
        } else if (condicao.equals(ConstantesSeguranca.OLHOS)) {
            InstanciasControle.getGerenciarAudio().exeOlhosIdentificados();
        } else if (condicao.equals(ConstantesSeguranca.CORPO)) {
            InstanciasControle.getGerenciarAudio().exeFaceIdentificada(
                        s_camera.getStatusDeteccao().getQtdePessoas());
        } else if (condicao.equals(ConstantesSeguranca.RECONHECER_FACE)) {
            InstanciasControle.getGerenciarAudio().exeFaceReconhecida();
        }
    } 
    
    private void campanhia() {
        InstanciasControle.getGerenciarAudio().exeCampanhia();
        enviarMensagem(MontarMensagens.visita(), ConstantesRedes.TP_VISITA);
    }
    
    private void acionarDispositivoDetectarPessoas() {
        if (ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento() && ConfigDispositivos.getAtivarDispositivosCamera()) {
            for (AcionamentoBean acionamento : camera.getAcionamentos()) {
                if(acionamento.getStatus() == EnumStatusAcionamento.ATIVO && acionamento.getTipo() == EnumTipoAcionamento.DETECTAR_PESSOAS) {
                    acionar(acionamento);
                } 
            }
        }
    }
    private void acionarDispositivoReconhecerFace() {
        if (ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento() && ConfigDispositivos.getAtivarDispositivosCamera()) {
            for (AcionamentoBean acionamento : camera.getAcionamentos()) {
                if(acionamento.getStatus() == EnumStatusAcionamento.ATIVO && acionamento.getTipo() == EnumTipoAcionamento.RECONHECER_FACES) {
                    acionar(acionamento);
                } 
            }
        }
    }
    
    private void acionar(AcionamentoBean acionamento) {
        Boolean acionar = true;
        for (ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
            if (item.getDispositivoEletrico().getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.DESLIGADO) {
                if (!AcionarDispositivo.ligarDispositivo(item.getDispositivoEletrico())) {
                    acionar = false;
                    break;
                } 
            }
        }
        if (acionar) {
            animarDispositivo();
            acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.LIGADO);
            alterarAcionamento(acionamento);
            salvarLogAcoes.salvarAcionamento(acionamento, InstanciasControle.getUsuarioLogado().getPessoa(), EnumRedeLogAcoes.NAO);
            AtualizaTelas.geralCenarios();
        }
    }

    private void enviarMensagem(String mensagem, String constanteRede) {
        if (ConfigMensagens.getStatus() && ConfigMensagens.getAtivarEnvioMensagens()) {
            if (movimento != null && s_camera.getStatusDeteccao().getMandarMensagem()) {
                if (ConfigMensagens.getAtivarEnvioEmail()) {
                    enviarEmail(mensagem);
                }
                if (ConfigMensagens.getAtivarEnvioRede()) {
                    enviaRede(constanteRede, mensagem);
                } else if (ConfigMensagens.getAtivarEnvioCelular()) {
                    enviarTopedoSMS(mensagem);
                }
                if(enviouMensagem) {
                    animarMensagens();
                }
                s_camera.getStatusDeteccao().setMandarMensagem(false);
            }
        }
    }

    private void enviarEmail(final String mensagem) {
        System.out.println("Enviando email...");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                EnviarEmail enviarEmail = new EnviarEmail();
                for (PessoaBean pessoa : listarPessoas()) {   
                    HashMap<String, File> anexos = new HashMap<>();
                    anexos.put(System.currentTimeMillis() + "", new File(ArquivosImagens.diretorio_processamento() + File.separator + diretorio));
                    enviarEmail.setAnexos(anexos);
                    if(enviarEmail.enviar(pessoa, ASSUNTO, mensagem)) {
                        salvarMensagem(populaMensagemBean(pessoa, EnumTipoMensagem.EMAIL, mensagem));
                        enviouMensagem = true;
                    }
                }
            }
        });
        thread.start();
    }
 
    public void enviaRede(String contanteRede, String mensagem) {
        if(InstanciasPortatil.getCliente() != null && InstanciasPortatil.getCliente().getStatusConexao()) {
            System.out.println("Enviando mensagem via rede...");
            salvarMensagem(populaMensagemBean(null, EnumTipoMensagem.REDE, mensagem));
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_MENSAGEM);
            InstanciasPortatil.getCliente().enviarDados(mensagem);
            InstanciasPortatil.getCliente().enviarDados(contanteRede);      
            enviouMensagem = true;
        }
    }
    
    private void enviarTopedoSMS(String mensagem) {
        System.out.println("Enviando torpeto SMS...");
        for (PessoaBean pessoa : listarPessoas()) {
            salvarMensagem(populaMensagemBean(pessoa, EnumTipoMensagem.CELULAR, mensagem));
            TelefoneBean telefone = selecionarTelefonePorPessoa(pessoa);
            if(telefone.getEnviarAutomatico() == EnumEnviarAutomaticoTelefone.ENVIAR) {
                Celular celular = new Celular(telefone.getNumero(), telefone.getDdd(), mensagem);
                if(celular.modem()) {
                    enviouMensagem = true;
                }
            }
        }
    }
    
    public void salvarImagem() {
        diretorio = InstanciasControle.getSalvarImgDetectada().salvarImagem(
                s_camera.getStatusDeteccao().getImagemSalvar(),
                ArquivosImagens.diretorio_processamento());
    }

    private MovimentoBean populaMovimentoBean() {
        MovimentoBean bean = new MovimentoBean();

        bean.setCamera(camera); 
        bean.setData_hms(dataHora);
        bean.setDiretorio(diretorio);
        bean.setQtdePessoas(s_camera.getStatusDeteccao().getQtdePessoas());
        bean.setQtdeObjetos(s_camera.getStatusDeteccao().getQtdeObjetos());

        return bean;
    }

    private MensagemBean populaMensagemBean(PessoaBean destino, EnumTipoMensagem en, String mensagem) {
        MensagemBean bean = new MensagemBean();

        bean.setAssunto(ASSUNTO);
        bean.setDataHora(dataHora);
        bean.setDestino(destino);
        bean.setMensagem(mensagem);
        bean.setMovimento(movimento);
        bean.setTipo(en);

        return bean;
    }

    private void animarMensagens() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(5);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }

    private void animarDispositivo() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(4);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private void limparStatusDeteccao() {
        s_camera.getStatusDeteccao().setDetectado(false);
        s_camera.getStatusDeteccao().setImagemSalvar(null);
        s_camera.getStatusDeteccao().setObjetoCorpo(-1);
        s_camera.getStatusDeteccao().setQtdeObjetos(0);
        s_camera.getStatusDeteccao().setQtdePessoas(0);
    }
    
    /*
     * OPERACOES CONTROLE AUTOMÁTICO, ALARME E MOVIMENTO
     */
    
    public void verificaControleAutomaticoOuAlarme(CameraBean camera) {      
        s_camera.getStatusDeteccao().setInicioControleAutomatico(System.currentTimeMillis());
        for (AcionamentoBean acionamento : camera.getAcionamentos()) {
            if(acionamento.getStatus() == EnumStatusAcionamento.ATIVO) { 
                if(acionamento.getTipo() == EnumTipoAcionamento.CONTROLE_AUTOMATICO || acionamento.getTipo() == EnumTipoAcionamento.ALARME
                        || acionamento.getTipo() == EnumTipoAcionamento.MOVIMENTO) {      
                    Boolean acionar = true;
                    for (ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                        if (item.getDispositivoEletrico().getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.DESLIGADO) {
                            if (!AcionarDispositivo.ligarDispositivo(item.getDispositivoEletrico())) {
                                acionar = false;
                                break;
                            }
                        }
                    }
                    if (acionar) {
                        System.out.println("Controle automático ou alarme ou movimento disparado.");
                        animarDispositivo();
                        acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.LIGADO);
                        alterarAcionamento(acionamento);
                        AtualizaTelas.geralCenarios();
                    }
                }
            }
        }
    }
    
    public void desligaControleAutomatico(CameraBean camera) {
        for (AcionamentoBean acionamento : camera.getAcionamentos()) {
            if(acionamento.getStatus() == EnumStatusAcionamento.ATIVO) { 
                if(acionamento.getTipo() == EnumTipoAcionamento.CONTROLE_AUTOMATICO) {
                    Boolean acionar = true;
                    for (ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                        if (item.getDispositivoEletrico().getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
                            if (!AcionarDispositivo.desligarDispositivo(item.getDispositivoEletrico())) {
                                acionar = false;
                                break;
                            } 
                        } else {
                            acionar = false;
                        }
                    }
                    if (acionar) {
                        System.out.println("Controle automático desativado.");
                        animarDispositivo();
                        acionamento.setLigarDesligar(EnumLigarDesligarAcionamento.DESLIGADO);
                        alterarAcionamento(acionamento);
                        AtualizaTelas.geralCenarios();
                    }
                }
            }
        }
    }

    /*
     * BANCO DE DADOS
     */
    
    private void salvarMovimento() {
        MovimentoFacade movimentoFacade = FactoryFacade.getMovimentoImpl();
        try {
            movimento = movimentoFacade.inserir(populaMovimentoBean());
        } catch (FacadeException ex) {
        }
    }

    private void salvarMensagem(MensagemBean mensagem) {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            mensagemFacade.inserir(mensagem);
        } catch (FacadeException ex) {
        }
    }

    private TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) {
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            return telefoneFacade.selecionarTelefonePorPessoa(pessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<PessoaBean> listarPessoas() {
        PessoaFacade pessoaFacade = FactoryFacade.getPessoaImpl();
        try {
            return (ArrayList<PessoaBean>) pessoaFacade.listar();
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
    
}
