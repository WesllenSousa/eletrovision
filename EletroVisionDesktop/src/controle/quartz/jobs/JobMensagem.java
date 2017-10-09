
package controle.quartz.jobs;

import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.sistema.ConfigGerais;
import recursos.configuracoes.sistema.ConfigMensagens;
import controle.mensagens.celular.Celular;
import controle.mensagens.email.EnviarEmail;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.pessoa.bean.PessoaBean;
import entidades.telefone.bean.TelefoneBean;
import entidades.telefone.facade.TelefoneFacade;
import java.util.ArrayList;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import recursos.instancias.InstanciasControle;
import telas.geral.dependencias.VerMensagensLocais;
import telas.principal.AnimacaoPrincipal;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class JobMensagem implements Job{
    
    private SalvarLogAcoes salvarLogAcoes = new SalvarLogAcoes();
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("JobMensagem executou");
        if(ConfigGerais.getStatus() && ConfigGerais.getAtivarAgendarTarefas()) {
            JobDetail jobDetail = jec.getJobDetail();
            for(AgendarTarefasBean bean : listarAgendarTarefasPorDisparoETipo(jobDetail.getKey().getName(), EnumTipoVinculoAgendarTarefas.MENSAGEM)) {
                for(MensagemBean mensagem : bean.getMensagens()) {
                    if(ConfigMensagens.getStatus() && ConfigMensagens.getAtivarEnvioMensagens()) {
                        verificarMensagem(bean, mensagem);
                    }
                }
                salvarLogAcoes.salvarAgendarTarefas(bean, InstanciasControle.getUsuarioLogado().getPessoa());
            }
            animarAgendarTarefas();
        }
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<AgendarTarefasBean> listarAgendarTarefasPorDisparoETipo(String disparo, EnumTipoVinculoAgendarTarefas tipoVinculo) {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.listarAgendarTarefasPorDisparoETipo(disparo, tipoVinculo);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) {
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            return telefoneFacade.selecionarTelefonePorPessoa(pessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    /*
     * REGRA DE NEGOCIO
     */
    
    private void animarAgendarTarefas() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(3);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private void animarMensagens() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(5);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private void verificarMensagem(AgendarTarefasBean agendarTarefas, MensagemBean mensagem) {
        if(agendarTarefas.getAcaoAgendamento().getAcao().equals("Enviar")) {
            enviarMensagem(mensagem); 
        }
    }

    private void enviarMensagem(final MensagemBean mensagem) {
        if(mensagem.getTipo() == EnumTipoMensagem.EMAIL) {
            if(ConfigMensagens.getAtivarEnvioEmail()) {
                EnviarEmail enviarEmail = new EnviarEmail();
                enviarEmail.enviar(mensagem.getDestino(), mensagem.getAssunto(), mensagem.getMensagem());
            }
        } else if(mensagem.getTipo() == EnumTipoMensagem.CELULAR) {
            if(ConfigMensagens.getAtivarEnvioCelular()) {
                TelefoneBean telefone = selecionarTelefonePorPessoa(mensagem.getDestino());
                Celular celular = new Celular(telefone.getNumero(), telefone.getDdd(), mensagem.getMensagem());
                celular.modem();
            }
        } else if(mensagem.getTipo() == EnumTipoMensagem.LOCAL) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    VerMensagensLocais dialog = new VerMensagensLocais(null, true, mensagem);
                    dialog.setVisible(true);
                }
            });
            thread.start();
        }
        animarMensagens();
    }

}
