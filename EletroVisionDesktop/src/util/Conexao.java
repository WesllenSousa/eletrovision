package util;

import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acesso.bean.AcessoBean;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.camera.bean.CameraBean;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.dispositivo.bean.DispositivoBean;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.email.bean.EmailBean;
import entidades.endereco.bean.EnderecoBean;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.area.bean.AreaBean;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.marca.bean.MarcaBean;
import entidades.mensagem.bean.MensagemBean;
import entidades.modulo.bean.ModuloBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.movimento.bean.MovimentoBean;
import entidades.pessoa.bean.PessoaBean;
import entidades.predio.bean.PredioBean;
import entidades.telefone.bean.TelefoneBean;
import entidades.usuario.bean.UsuarioBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import telas.comuns.telas.BancoDados;

/**
 *
 * @author Wesllen Sousa Lima
 */

public class Conexao {

    private static final SessionFactory sessionFactory;
    public static final ThreadLocal thread = new ThreadLocal();

    static {
        try {
            AnnotationConfiguration configuration = new AnnotationConfiguration();  
            configuration.addAnnotatedClass(AcaoAgendamentoBean.class);  
            configuration.addAnnotatedClass(AcessoBean.class);    
            configuration.addAnnotatedClass(AcionamentoBean.class);    
            configuration.addAnnotatedClass(AgendarTarefasBean.class);   
            configuration.addAnnotatedClass(AreaBean.class);
            configuration.addAnnotatedClass(AutorizacaoBean.class);   
            configuration.addAnnotatedClass(CameraBean.class);
            configuration.addAnnotatedClass(ConfigCameraBean.class);
            configuration.addAnnotatedClass(DispositivoBean.class);
            configuration.addAnnotatedClass(DispositivoEletricoBean.class);
            configuration.addAnnotatedClass(EmailBean.class);    
            configuration.addAnnotatedClass(EnderecoBean.class);
            configuration.addAnnotatedClass(ItemAcionamentoBean.class);
            configuration.addAnnotatedClass(LogAcoesBean.class);    
            configuration.addAnnotatedClass(MarcaBean.class);
            configuration.addAnnotatedClass(MensagemBean.class);
            configuration.addAnnotatedClass(ModuloBean.class);
            configuration.addAnnotatedClass(ModuloAcionamentoBean.class);
            configuration.addAnnotatedClass(MovimentoBean.class);
            configuration.addAnnotatedClass(PessoaBean.class);
            configuration.addAnnotatedClass(PredioBean.class);
            configuration.addAnnotatedClass(TelefoneBean.class);
            configuration.addAnnotatedClass(UsuarioBean.class);    
            sessionFactory = configuration.configure(ArquivosConfiguracao.hibernate()).buildSessionFactory();         
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
            abrirConfiguracaoConexao();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        Session s = (Session) thread.get();
        if (s == null) {
            s = sessionFactory.openSession();
            thread.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = (Session) thread.get();
        if (s != null) {
            s.close();
        }
        s = null;
        thread.set(null);
    }
    
    public static void abrirConfiguracaoConexao(){
        BancoDados dialog = new BancoDados(null, true);
        dialog.setVisible(true);
    }
    
}