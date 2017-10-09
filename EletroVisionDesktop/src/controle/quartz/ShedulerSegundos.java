/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.quartz;

import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensErro;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ShedulerSegundos {
    
    private Scheduler sheScheduler;
    
    public ShedulerSegundos(){
    }
    
    public void iniciar() {
        try {
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            sheScheduler = stdSchedulerFactory.getScheduler();
            jobServidorCamera();
            sheScheduler.start();
            System.out.println("Servidor câmera iniciado!");
        } catch (SchedulerException ex) {
            MensagensErro.shedulerExecutarTarefas(ex);
        }
    }

    private void jobServidorCamera() {
        try {
            JobDetail jobDetail = new JobDetailImpl("JobServidorCamera", Scheduler.DEFAULT_GROUP, null);
            SimpleTrigger tigger = new SimpleTriggerImpl(
                    "JobCamera", sheScheduler.DEFAULT_GROUP, new Date(), null, SimpleTrigger.REPEAT_INDEFINITELY, 1 * 100L);
            sheScheduler.scheduleJob(jobDetail, tigger);
        } catch (SchedulerException ex) {
            MensagensErro.shedulerExecutarTarefas(ex);
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
    
}
