
package controle.openCV_javaCV_Pro.camera;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_objdetect;
import controle.mensagens.sistema.MontarMensagens;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import recursos.internacionalizacao.MensagensSoltas;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import recursos.instancias.InstanciasControle;
import telas.comuns.telas.CarregarBarraProgresso;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class IniciarCameras {
    
    private ExecutorService executorService;
    private ArrayList<ServidorCamera> listaCamera;
    private Boolean status = false, pausa = false;
    private Integer tipoInicializacao;
    
    public IniciarCameras(){ 
        Loader.load(opencv_objdetect.class);    
        listaCamera = new ArrayList<>();
    }

    public void detectarCamerasCadastradas(CarregarBarraProgresso progresso) {
        tipoInicializacao = 0;
        listaCamera.clear();
        ArrayList<CameraBean> cameras = listaTodasCamerasAtivas();
        Integer cont = 1;
        Integer intervalo = 100 / cameras.size();
        for(CameraBean camera : cameras){
            ServidorCamera cam = new ServidorCamera(camera);
            System.out.print("Iniciando câmera: "+camera.getNome()+"...");
            String identificacao;
            if(camera.getPorta() != null) {
                identificacao = MontarMensagens.urlCameraConexao(camera.getIdentificacao(), camera.getPorta(), 
                        camera.getUsuario(), camera.getSenha()); 
            } else { 
                identificacao = camera.getIdentificacao();
            } 
            if(cam.iniciarCamera(identificacao)){
                listaCamera.add(cam);  
                System.out.println("iniciada.");
                if(progresso != null) {
                    atualizarStatus(progresso, intervalo, cont); 
                }
            }
            cont++;
        }
        if(listaCamera.size() > 0) {
            executorService = Executors.newFixedThreadPool(listaCamera.size());
        }
    }
    
    public void detectarTodasCameras(CarregarBarraProgresso progresso, Integer quantidade) {
        tipoInicializacao = 1;
        listaCamera.clear();
        Integer cont = 1;
        Integer intervalo = 100 / quantidade;
        for(int identificacao = 0; identificacao < quantidade; identificacao++){
            ServidorCamera cam = new ServidorCamera(identificacao+"");
            System.out.print("Iniciando câmera: "+identificacao+"...");
            if(cam.iniciarCamera(identificacao+"")){ 
                listaCamera.add(cam);   
                System.out.println("iniciada.");
                if(progresso != null) {
                    atualizarStatus(progresso, intervalo, cont); 
                }
            }
            cont++;
        }
        if(listaCamera.size() > 0) {
            executorService = Executors.newFixedThreadPool(listaCamera.size());
        }
    }
    
    public void prepararCamerasIndividuais() {
        tipoInicializacao = 0;
        listaCamera.clear();
        ArrayList<CameraBean> cameras = listaTodasCamerasAtivas();
        for(CameraBean camera : cameras){
            ServidorCamera cam = new ServidorCamera(camera);
            listaCamera.add(cam);
            System.out.println("Câmera: "+camera.getNome()+" preparada.");
        }
        if(listaCamera.size() > 0) {
            executorService = Executors.newFixedThreadPool(listaCamera.size());
        }
    }
    
    private void atualizarStatus(final CarregarBarraProgresso progresso, final Integer intervalo, final Integer cont) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                progresso.atualizar(intervalo * cont); 
            }
        });     
    }
    
    public void iniciarCaptura(){
        for(ServidorCamera servidorCamera : listaCamera) {
            servidorCamera.setProcessamento(Executors.newSingleThreadExecutor());
            executorService.execute(servidorCamera);
        }
        status = true;
    }
    
    public void iniciarCapturaIndividual(ServidorCamera servidorCamera){
        servidorCamera.setProcessamento(Executors.newSingleThreadExecutor());
        executorService.execute(servidorCamera);
        status = true;
        System.out.println("Câmera: "+servidorCamera.getCamera().getNome()+" iniciada.");
    }
    
    public void pararCaptura(){
        for(ServidorCamera camera : listaCamera){
            camera.setStatus(false);
        }
        status = false;
        pausa = false;
        esperar();
        if(executorService != null) {
            executorService.shutdownNow();
        }        
        if(tipoInicializacao == 0) {
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.camerasParar());
        }
        listaCamera.clear();
    }
    
    private void esperar() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }
    
    public void pausarCameras(Boolean pause) {
        pausa = pause;
        for(ServidorCamera camera : getServidoresCameras()) {
            camera.setPause(pause);
        }
    }
    
    public ArrayList<ServidorCamera> getServidoresCameras() {
        return listaCamera;
    }

    public Boolean getStatus() {
        return status;
    }

    public Boolean getPausa() {
        return pausa;
    }
    
    private ArrayList<CameraBean> listaTodasCamerasAtivas() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return (ArrayList<CameraBean>) cameraFacade.listarCamerasAtivas();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
