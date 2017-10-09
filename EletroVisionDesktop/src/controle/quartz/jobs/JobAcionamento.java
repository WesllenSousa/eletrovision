
package controle.quartz.jobs;

import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigGerais;
import controle.dispositivos.AcionarDispositivo;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import java.util.ArrayList;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import recursos.instancias.InstanciasControle;
import telas.principal.AnimacaoPrincipal;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class JobAcionamento implements Job{
    
    private SalvarLogAcoes salvarLogAcoes = new SalvarLogAcoes();

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("JobAcionamento executou");
        if(ConfigGerais.getStatus() && ConfigGerais.getAtivarAgendarTarefas()) {
            JobDetail jobDetail = jec.getJobDetail();
            for(AgendarTarefasBean bean : listarAgendarTarefasPorDisparoETipo(jobDetail.getKey().getName(), EnumTipoVinculoAgendarTarefas.ACIONAMENTO)) {
                for(AcionamentoBean acionamento : bean.getAcionamentos()) {
                    verificarAcionamento(bean, acionamento);
                }
                salvarLogAcoes.salvarAgendarTarefas(bean, InstanciasControle.getUsuarioLogado().getPessoa());
                AtualizaTelas.geralCenarios();
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
    
    /*
     * REGRA DE NEGOCIO
     */
    
    private void animarAgendarTarefas() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(3);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private void animarDispositivo() {
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(4);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private void verificarAcionamento(AgendarTarefasBean agendarTarefas, AcionamentoBean acionamento) {
        switch (agendarTarefas.getAcaoAgendamento().getAcao()) {
            case "Ligar acionamento":
                ligarDispositivos(acionamento);
                break;
            case "Desligar acionamento":
                desligarDispositivos(acionamento);
                break;
            case "Ativar acionamento":
                acionamento.setStatus(EnumStatusAcionamento.ATIVO);
                alterarAcionamento(acionamento);
                break;
            case "Desativar acionamento":
                acionamento.setStatus(EnumStatusAcionamento.INATIVO);
                alterarAcionamento(acionamento);
                break;
            case "Ativar Controle Automático":
                acionamento.setTipo(EnumTipoAcionamento.CONTROLE_AUTOMATICO);
                alterarAcionamento(acionamento);
                break;
            case "Desativar Controle Automático":
                acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
                alterarAcionamento(acionamento);
                break;
            case "Ativar Alarme":
                acionamento.setTipo(EnumTipoAcionamento.ALARME);
                alterarAcionamento(acionamento);
                break;
            case "Desativar Alarme":
                acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
                alterarAcionamento(acionamento);
                break;
            case "Ativar Detectar Face":
                acionamento.setTipo(EnumTipoAcionamento.DETECTAR_PESSOAS);
                alterarAcionamento(acionamento);
                break;
            case "Desativar Detectar Face":
                acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
                alterarAcionamento(acionamento);
                break;
            case "Ativar Reconhecer Face":
                acionamento.setTipo(EnumTipoAcionamento.RECONHECER_FACES);
                alterarAcionamento(acionamento);
                break;
            case "Desativar Reconhecer Face":
                acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
                alterarAcionamento(acionamento);
                break;
            case "Ativar Movimento":
                acionamento.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO);
                alterarAcionamento(acionamento);
                break;
            case "Desativar Movimento":
                acionamento.setTipo(EnumTipoAcionamento.MOVIMENTO);
                alterarAcionamento(acionamento);
                break;
        }
    }

    private void ligarDispositivos(AcionamentoBean acionamento) {
        if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()) {
            Boolean acionar = true;
            for(ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                if(!AcionarDispositivo.ligarDispositivo(item.getDispositivoEletrico())) {
                    acionar = false;
                    break;
                }
            }
            if(acionar) {
                salvarLogAcoes.salvarAcionamento(acionamento, InstanciasControle.getUsuarioLogado().getPessoa(), EnumRedeLogAcoes.NAO);
                animarDispositivo();
            } 
        }
    }
    
    private void desligarDispositivos(AcionamentoBean acionamento) {
        if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAtivarAcionamento()) {
            Boolean acionar = true;
            for(ItemAcionamentoBean item : listarItemAcionamentoPorAcionamento(acionamento)) {
                if(!AcionarDispositivo.desligarDispositivo(item.getDispositivoEletrico())) {
                    acionar = false;
                    break;
                }
            }
            if(acionar) {
                salvarLogAcoes.salvarAcionamento(acionamento, InstanciasControle.getUsuarioLogado().getPessoa(), EnumRedeLogAcoes.NAO);
                animarDispositivo();
            } 
        }
    }

}
