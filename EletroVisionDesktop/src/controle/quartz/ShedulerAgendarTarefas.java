
package controle.quartz;

import recursos.internacionalizacao.MensagensErro;
import controle.quartz.jobs.JobAcionamento;
import controle.quartz.jobs.JobCamera;
import controle.quartz.jobs.JobMensagem;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import java.text.ParseException;
import java.util.ArrayList;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import recursos.instancias.InstanciasControle;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ShedulerAgendarTarefas {

    private Scheduler sheScheduler;
    
    public ShedulerAgendarTarefas(){
    }
    
    public void iniciar() {
        try {
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            sheScheduler = stdSchedulerFactory.getScheduler();
            for(AgendarTarefasBean agendarTarefas : listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas.MENSAGEM)) {
                jobMensagem(agendarTarefas.getDisparo());
            }
            for(AgendarTarefasBean agendarTarefas : listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas.ACIONAMENTO)) {
                jobAcionamento(agendarTarefas.getDisparo());
            }
            for(AgendarTarefasBean agendarTarefas : listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas.CAMERA)) {
                jobCamera(agendarTarefas.getDisparo());
            }
            sheScheduler.start();
            System.out.println("Agendamento iniciado");
        } catch (SchedulerException ex) {
            MensagensErro.shedulerExecutarTarefas(ex);
        }
    }

    private void jobMensagem(String disparo){
        try {
            JobDetail jobDetail = new JobDetailImpl(disparo, Scheduler.DEFAULT_GROUP, JobMensagem.class);
            CronTrigger tigger = new CronTriggerImpl(disparo, Scheduler.DEFAULT_GROUP, disparo);
            sheScheduler.scheduleJob(jobDetail, tigger);
        } catch (ParseException | SchedulerException ex) {
            MensagensErro.shedulerJob(ex);
        } 
    }
    
    private void jobAcionamento(String disparo){
        try {
            JobDetail jobDetail = new JobDetailImpl(disparo, Scheduler.DEFAULT_GROUP, JobAcionamento.class);
            CronTrigger tigger = new CronTriggerImpl(disparo, Scheduler.DEFAULT_GROUP, disparo);
            sheScheduler.scheduleJob(jobDetail, tigger);
        } catch (ParseException | SchedulerException ex) {
            MensagensErro.shedulerJob(ex);
        } 
    }
    
    private void jobCamera(String disparo){
        try {
            JobDetail jobDetail = new JobDetailImpl(disparo, Scheduler.DEFAULT_GROUP, JobCamera.class);
            CronTrigger tigger = new CronTriggerImpl(disparo, Scheduler.DEFAULT_GROUP, disparo);
            sheScheduler.scheduleJob(jobDetail, tigger);
        } catch (ParseException | SchedulerException ex) {
            MensagensErro.shedulerJob(ex);
        } 
    }

    public void reiniciar(){
        parar();
        ShedulerAgendarTarefas s = new ShedulerAgendarTarefas();
        s.iniciar();
        InstanciasControle.setShedulerAgendarTarefas(s);
    }
    
    public void parar(){
        try {
            if(sheScheduler != null && sheScheduler.isStarted()) {
                sheScheduler.shutdown();
                System.out.println("Agendamento parado");
            }
        } catch (SchedulerException ex) {
            MensagensErro.shedulerReiniciar(ex); 
        }
    }
    
    private ArrayList<AgendarTarefasBean> listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas tipoVinculo) {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.listarAgendarTarefasPorTipo(tipoVinculo);
        } catch (FacadeException ex) {
        }
        return null;
    }

}
