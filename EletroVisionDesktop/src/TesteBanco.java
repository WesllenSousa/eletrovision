
import recursos.configuracoes.diretorios.Raiz;
import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acaoAgendamento.facade.AcaoAgendamentoFacade;
import entidades.acesso.bean.AcessoBean;
import entidades.acesso.facade.AcessoFacade;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.autorizacao.facade.AutorizacaoFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.configCamera.bean.EnumCampanhiaConfigCamera;
import entidades.configCamera.bean.EnumCorpoConfigCamera;
import entidades.configCamera.bean.EnumFaceConfigCamera;
import entidades.configCamera.bean.EnumOlhosConfigCamera;
import entidades.configCamera.bean.EnumGravarConfigCamera;
import entidades.configCamera.bean.EnumMovimentoConfigCamera;
import entidades.configCamera.facade.ConfigCameraFacade;
import entidades.dispositivo.bean.EnumDeletadoDispositivo;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.email.bean.EmailBean;
import entidades.email.facade.EmailFacade;
import entidades.endereco.bean.EnderecoBean;
import entidades.endereco.facade.EnderecoFacade;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
import entidades.area.bean.EnumDeletadoArea;
import entidades.area.bean.AreaBean;
import entidades.area.facade.AreaFacade;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.logAcoes.facade.LogAcoesFacade;
import entidades.marca.bean.MarcaBean;
import entidades.marca.facade.MarcaFacade;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.modulo.bean.ModuloBean;
import entidades.modulo.facade.ModuloFacade;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import entidades.movimento.bean.MovimentoBean;
import entidades.movimento.facade.MovimentoFacade;
import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import entidades.predio.facade.PredioFacade;
import entidades.telefone.bean.EnumEnviarAutomaticoTelefone;
import entidades.telefone.bean.TelefoneBean;
import entidades.telefone.facade.TelefoneFacade;
import entidades.usuario.bean.UsuarioBean;
import entidades.usuario.facade.UsuarioFacade;
import java.util.ArrayList;
import java.util.Calendar;
import util.FacadeException;
import util.FactoryFacade;


/**
 *
 * @author Wesllen Sousa Lima
 */
public class TesteBanco {
    
    public static void main(String[] args) {
        TesteBanco t = new TesteBanco();
    }
    
    public TesteBanco(){
        Raiz.setRaiz(System.getProperty("user.dir"));
          
         /////////////////////////////////////////////////////////////////////////
        EnderecoBean enderecoBean = new EnderecoBean();
        enderecoBean.setBairro("Senador Helio Campos");
        enderecoBean.setCidade("Boa vista");
        enderecoBean.setEstado("Roraima");
        enderecoBean.setLogradouro("Comercial");
        enderecoBean.setNumero(12);
        enderecoBean.setReferencia("Comercio Sam Park");
        
        EnderecoFacade enderecoFacade  = FactoryFacade.getEnderecoImpl();
        try {
            enderecoFacade.inserir(enderecoBean);
        } catch (FacadeException ex) {           
        }
       
        
         /////////////////////////////////////////////////////////////////////////
        PessoaBean pessoaBean = new PessoaBean();
        pessoaBean.setCpf("0o090909");
        pessoaBean.setData(null);
        pessoaBean.setEndereco(enderecoBean);
        pessoaBean.setFoto("c:");
        pessoaBean.setNome("hendrio luis");
        pessoaBean.setRg("8u");
        pessoaBean.setSituacao(EnumSituacaoPessoa.ATIVO);
        pessoaBean.setTipo(EnumTipoPessoa.DONO);
        
        PessoaFacade pessoaFacade =  FactoryFacade.getPessoaImpl();
          try {
            pessoaFacade.inserir(pessoaBean);
        } catch (FacadeException ex) {
        }
  
          
         /////////////////////////////////////////////////////////////////////////  
        TelefoneBean telefone = new TelefoneBean();
        telefone.setNumero(123123);
        telefone.setEnviarAutomatico(EnumEnviarAutomaticoTelefone.ENVIAR);     
        telefone.setPessoa(pessoaBean);
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            telefoneFacade.inserir(telefone);
        } catch (FacadeException ex) {           
        }
          
         /////////////////////////////////////////////////////////////////////////
        AutorizacaoBean autorizacaoBean = new AutorizacaoBean();
        autorizacaoBean.setDescricao("POde inserir");
        autorizacaoBean.setModulos(null);
        
        AutorizacaoFacade autorizacaoFacade = FactoryFacade.getAutorizacaoImpl();
        try {
            autorizacaoFacade.inserir(autorizacaoBean);
        } catch (FacadeException ex) {           
        }
        
        
         /////////////////////////////////////////////////////////////////////////
        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setAutorizacao(autorizacaoBean);
        usuarioBean.setPessoa(pessoaBean);
        usuarioBean.setLogin("hendrio");
        usuarioBean.setSenha("123");
        
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            usuarioFacade.inserir(usuarioBean);
        } catch (FacadeException ex) {         
        }
        
        
        /////////////////////////////////////////////////////////////////////////
        MarcaBean marca = new MarcaBean();
        marca.setNome("system");
        marca.setCodigo(1);
        MarcaFacade marcaFacade = FactoryFacade.getMarcaImpl();
        try {
            marcaFacade.inserir(marca);
        } catch (FacadeException ex) {
        }
        
        AcaoAgendamentoBean acaoAgendamento = new AcaoAgendamentoBean();
        acaoAgendamento.setAcao("teste"); 
        AcaoAgendamentoFacade acaoAgendamentoFacade = FactoryFacade.getAcaoAgendamentoFacadeImpl();
        try {
            acaoAgendamentoFacade.inserir(acaoAgendamento);
        } catch (FacadeException ex) {
        }
        
         /////////////////////////////////////////////////////////////////////////
        AgendarTarefasBean agendarTarefas = new AgendarTarefasBean();
        agendarTarefas.setDescricao("Usar");
        agendarTarefas.setDisparo("Contar");
        agendarTarefas.setStatus(EnumStatusAgendarTarefas.ATIVO);
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            agendarTarefasFacade.inserir(agendarTarefas);
        } catch (FacadeException ex) {
        }
        
         /////////////////////////////////////////////////////////////////////////
        ModuloBean moduloBean = new ModuloBean();
        moduloBean.setNome("ModCozinha");
        moduloBean.setAutorizacoes(null);
        
        
        ModuloFacade moduloFacade = FactoryFacade.getModuloImpl();
        try {
            moduloFacade.inserir(moduloBean);
        } catch (FacadeException ex) {           
        }
        
         /////////////////////////////////////////////////////////////////////////
        EmailBean emailBean = new EmailBean();
        emailBean.setEmail("hendrio_luis@hotmail.com");
        emailBean.setPessoa(pessoaBean);
        emailBean.setSenha("12345");
        
        EmailFacade emailFacade = FactoryFacade.getEmailImpl();
        try {
            emailFacade.inserir(emailBean);
        } catch (FacadeException ex) {
        }
        
        
         /////////////////////////////////////////////////////////////////////////
        PredioBean predioBean = new PredioBean();
        predioBean.setEndereco(enderecoBean);
        predioBean.setFoto("c:");
        predioBean.setNome("Plaza");
        predioBean.setTipo(EnumTipoPredio.COMERCIO);
        
        PredioFacade predioFacade = FactoryFacade.getPredioImpl();
        try {
            predioFacade.inserir(predioBean);
        } catch (FacadeException ex) {
        }
        
        /////////////////////////////////////////////////////////////////////////
        AreaBean areaBean = new AreaBean();
        areaBean.setNome("Rua Estrela");
        areaBean.setDeletado(EnumDeletadoArea.SIM);
        
        AreaFacade localFacade = FactoryFacade.getAreaImpl();
        try {
            localFacade.inserir(areaBean);
        } catch (FacadeException ex) {
        }
        
        ///////////////////////////////////////////////////////////////////////
        CameraBean cameraBean  = new CameraBean();
        cameraBean.setDeletado(EnumDeletadoDispositivo.NAO);
        cameraBean.setIdentificacao("Camera Teste");
        cameraBean.setArea(areaBean);
        //cameraBean.setMarcaBean(marca);
        cameraBean.setNome("PGHT-22");
        cameraBean.setStatus(EnumStatusDispositivo.ATIVO);
        
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            cameraFacade.inserir(cameraBean);
        } catch (FacadeException ex) {
        }
        
        ArrayList<CameraBean> listaCameras = new ArrayList<>();
        listaCameras.add(cameraBean); 
        
        
         /////////////////////////////////////////////////////////////////////////
        AcionamentoBean acionamentoBean = new AcionamentoBean();
        //acionamentoBean.setAgendarTarefas(agendarTarefas);
        acionamentoBean.setDeletado(EnumDeletadoAcionamento.NAO);
        acionamentoBean.setNome("Aciona");
        acionamentoBean.setStatus(EnumStatusAcionamento.ATIVO);
        acionamentoBean.setCameras(listaCameras);
        
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            acionamentoFacade.inserir(acionamentoBean);
        } catch (FacadeException ex) {
        }
        
        
         /////////////////////////////////////////////////////////////////////////
        ConfigCameraBean configCameraBean = new  ConfigCameraBean();
        configCameraBean.setCampanhia(EnumCampanhiaConfigCamera.NAO);
        configCameraBean.setCodigo(3);
        configCameraBean.setCorpo(EnumCorpoConfigCamera.NAO);
        configCameraBean.setFace(EnumFaceConfigCamera.NAO);
        configCameraBean.setOlhos(EnumOlhosConfigCamera.NAO);
        configCameraBean.setGravar(EnumGravarConfigCamera.NAO);
        configCameraBean.setMovimento(EnumMovimentoConfigCamera.NAO);
        
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            configCameraFacade.inserir(configCameraBean);
        } catch (FacadeException ex) {
        }
        
        /////////////////////////////////////////////////////////////////////////
        
        AcessoBean acessoBean = new  AcessoBean();
        acessoBean.setDataHoraFim(Calendar.getInstance());
        acessoBean.setDataHoraInicio(Calendar.getInstance());
        acessoBean.setUsuario(null);
        
        AcessoFacade acessoFacade = FactoryFacade.getAcessoFacadeImpl();
        try {
            acessoFacade.inserir(acessoBean);
        } catch (FacadeException ex) {
        }
        
         /////////////////////////////////////////////////////////////////////////
        MensagemBean mensagemBean = new MensagemBean();
        mensagemBean.setDataHora(null);
        mensagemBean.setAssunto("Assunto"); 
        mensagemBean.setMensagem("Testando mensagem");
        mensagemBean.setMovimento(null);
        mensagemBean.setTipo(EnumTipoMensagem.EMAIL);
        
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            mensagemFacade.inserir(mensagemBean);
        } catch (FacadeException ex) {
        }
        
         /////////////////////////////////////////////////////////////////////////
        LogAcoesBean logAcoesBean = new LogAcoesBean();
        logAcoesBean.setAcionamento(acionamentoBean);
        logAcoesBean.setDataHora(Calendar.getInstance());
        logAcoesBean.setDescricao("Teste");
        logAcoesBean.setResponsavel(pessoaBean);
        logAcoesBean.setRede(EnumRedeLogAcoes.NAO);
        
        LogAcoesFacade logAcoesFacade = FactoryFacade.getLogAcoesImpl();
        try {
            logAcoesFacade.inserir(logAcoesBean);
        } catch (FacadeException ex) {

        }
        
         /////////////////////////////////////////////////////////////////////////
        MovimentoBean movimentoBean = new MovimentoBean();
        movimentoBean.setCodigo(Integer.SIZE);
        movimentoBean.setDiretorio("c:");
        movimentoBean.setQtdeObjetos(4);
        movimentoBean.setQtdePessoas(3);
        
        MovimentoFacade movimentoFacade = FactoryFacade.getMovimentoImpl();
        try {
            movimentoFacade.inserir(movimentoBean);
        } catch (FacadeException ex) {

        }
        
         /////////////////////////////////////////////////////////////////////////
        ItemAcionamentoBean itensAcionamentoBean = new ItemAcionamentoBean();
        itensAcionamentoBean.setAcionamento(acionamentoBean);
        itensAcionamentoBean.setDispositivoEletrico(null);
        
        ItemAcionamentoFacade itensAcionamentoFacade = FactoryFacade.getItemAcionamentoImpl();
        try {
            itensAcionamentoFacade.inserir(itensAcionamentoBean);
        } catch (FacadeException ex) {
        }
        
         /////////////////////////////////////////////////////////////////////////
        ModuloAcionamentoBean moduloAcionamentoBean = new ModuloAcionamentoBean();
        moduloAcionamentoBean.setDeletado(EnumDeletadoDispositivo.NAO);
        moduloAcionamentoBean.setIdentificacao("Teste");
        moduloAcionamentoBean.setMarcaBean(marca);
        moduloAcionamentoBean.setNome("ModTeste");
        moduloAcionamentoBean.setQtdeSaida(2);
        moduloAcionamentoBean.setStatus(EnumStatusDispositivo.ATIVO);
        
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            moduloAcionamentoFacade.inserir(moduloAcionamentoBean);
        } catch (FacadeException ex) {
        }
        
         /////////////////////////////////////////////////////////////////////////
        DispositivoEletricoBean dispositivoEletricoBean = new DispositivoEletricoBean();
        dispositivoEletricoBean.setDeletado(EnumDeletadoDispositivo.NAO);
        dispositivoEletricoBean.setIdentificacao("DisTeste");
        //dispositivoEletricoBean.setMarcaBean(marca);
        //dispositivoEletricoBean.setModuloAcionamento(moduloAcionamentoBean);
        dispositivoEletricoBean.setNome("Dispositivo de Teste");
        dispositivoEletricoBean.setLigarDesligar(EnumLigarDesligarDispositivoEletrico.LIGADO);
        
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            dispositivoEletricoFacade.inserir(dispositivoEletricoBean);
        } catch (FacadeException ex) {
        }    
        
    }
    
}
