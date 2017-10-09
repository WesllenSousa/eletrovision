
package controle.quartz.jobs;

import controle.LogAcoes.SalvarLogAcoes;
import recursos.configuracoes.sistema.ConfigGerais;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.configCamera.facade.ConfigCameraFacade;
import entidades.dispositivo.bean.EnumStatusDispositivo;
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
public class JobCamera implements Job{
    
    private SalvarLogAcoes salvarLogAcoes = new SalvarLogAcoes();

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("JobCamera executou");
        if(ConfigGerais.getStatus() && ConfigGerais.getAtivarAgendarTarefas()) {
            JobDetail jobDetail = jec.getJobDetail();
            for(AgendarTarefasBean bean : listarAgendarTarefasPorDisparoETipo(jobDetail.getKey().getName(), EnumTipoVinculoAgendarTarefas.CAMERA)) {
                for(CameraBean camera : bean.getCameras()) {
                    verificarCamera(bean, camera); 
                }
                salvarLogAcoes.salvarAgendarTarefas(bean, InstanciasControle.getUsuarioLogado().getPessoa());
                AtualizaTelas.geralMapaDispositivos();
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
    
    private void alterarCamera(CameraBean camera) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            cameraFacade.alterar(camera);
        } catch (FacadeException ex) {
        }
    }
    
    private ConfigCameraBean selecionarConfigCamera(Integer codigo) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            return configCameraFacade.selecionar(codigo);
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
    
    private void verificarCamera(AgendarTarefasBean agendarTarefas, CameraBean camera) {
        switch (agendarTarefas.getAcaoAgendamento().getAcao()) {
            case "Ativar Câmera":
                camera.setStatus(EnumStatusDispositivo.ATIVO);
                alterarCamera(camera);
                break;
            case "Desativar Câmera":
                camera.setStatus(EnumStatusDispositivo.INATIVO);
                alterarCamera(camera);
                break;
            default:
                Integer codigo = Integer.parseInt(agendarTarefas.getAcaoAgendamento().getAcao()); 
                ConfigCameraBean configCamera = selecionarConfigCamera(codigo);
                camera.setConfigCamera(configCamera);
                alterarCamera(camera);
                break;
        }
    }

}
