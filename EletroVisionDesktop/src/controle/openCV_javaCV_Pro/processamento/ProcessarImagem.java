
package controle.openCV_javaCV_Pro.processamento;

import controle.openCV_javaCV_Pro.processamento.detectar.AmbienteStatico;
import controle.openCV_javaCV_Pro.processamento.detectar.DetectarMovimento;
import controle.openCV_javaCV_Pro.processamento.detectar.DetectarObjetos;
import controle.openCV_javaCV_Pro.processamento.detectar.DetectarFaces;
import controle.openCV_javaCV_Pro.processamento.detectar.DetectarOlhos;
import controle.openCV_javaCV_Pro.processamento.detectar.DetectarCorpo;
import static com.googlecode.javacv.cpp.opencv_core.*;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import controle.openCV_javaCV_Pro.processamento.detectar.*;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.configCamera.bean.*;
import java.awt.Point;
import recursos.constantes.ConstantesSeguranca;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ProcessarImagem {
    
    private ServidorCamera servidorCamera;
    private DetectarMovimento detectarMovimento = null;
    private AmbienteStatico ambienteStatico = null;

    public ProcessarImagem(ServidorCamera c_camera) {
        this.servidorCamera = c_camera;
    }
    
    public void verificarProcessos(CameraBean camera, IplImage imagemAtual, Integer contFrame) {
        if(servidorCamera.getStatusDeteccao().getDetectado()) {
            return;
        }  
        if(contFrame % 5 == 0 && camera.getConfigCamera().getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE) {
            if(verificarMovimento(imagemAtual)) {   
                camera = selecionaCamera(camera.getCodigo()); 
                servidorCamera.setCamera(camera); 

                servidorCamera.getStatusDeteccao().setInicioProcessamento(System.currentTimeMillis());
                servidorCamera.getStatusDeteccao().setInicioGravacao(System.currentTimeMillis());
                verificaOperacoesMovimento(camera);
            }
        } else if(contFrame % 5 == 0 && camera.getConfigCamera().getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO) {
            if(verificarAmbienteStatico(imagemAtual)) {
                camera = selecionaCamera(camera.getCodigo());
                servidorCamera.setCamera(camera); 

                servidorCamera.getStatusDeteccao().setInicioProcessamento(System.currentTimeMillis());
                servidorCamera.getStatusDeteccao().setInicioGravacao(System.currentTimeMillis());
                verificaOperacoesAlteracaoAmbiente(camera);
            }
        }
        if(servidorCamera.getStatusDeteccao().getDetectado()) { 
            System.out.println("Câmera: "+camera.getNome()); 
            verificarFaces(imagemAtual, camera);
            if(!servidorCamera.getStatusDeteccao().getObjetoCorpo().equals(ConstantesSeguranca.FACE)
                    && !servidorCamera.getStatusDeteccao().getObjetoCorpo().equals(ConstantesSeguranca.RECONHECER_FACE)) {
                verificarOlhos(imagemAtual, camera);
                if(!servidorCamera.getStatusDeteccao().getObjetoCorpo().equals(ConstantesSeguranca.OLHOS)) {
                    verificarCorpo(imagemAtual, camera);  
                    if(!servidorCamera.getStatusDeteccao().getObjetoCorpo().equals(ConstantesSeguranca.CORPO)) {
                        verificarObjetos(imagemAtual, camera);
                    }
                }         
            }
            servidorCamera.getRealizaOperacoes().inicia(camera);
        }
    }
    
    /*
     * PROCESSAMENTOS
     */
    
    private Boolean verificarMovimento(IplImage imagemAtual){
        if(detectarMovimento == null) {
            detectarMovimento = new DetectarMovimento();
            detectarMovimento.iniciar(imagemAtual); 
            ambienteStatico = null;
        }
        detectarMovimento.calcularMovimento(imagemAtual);
        IplImage imagemCentroide = IplImage.create(imagemAtual.width(), imagemAtual.height(), IPL_DEPTH_8U, 1);
        cvCopy(detectarMovimento.getImgAtual(), imagemCentroide);
        Point centroide = detectarMovimento.getCentroide();
        if (centroide != null) {
            cvCircle(imagemCentroide, cvPoint(centroide.x, centroide.y), 8, //raio
                    CvScalar.YELLOW, CV_FILLED, CV_AA, 0);  
            if(detectarMovimento.reportarCentroid()){       
                servidorCamera.getStatusDeteccao().setDetectado(true);
                servidorCamera.getStatusDeteccao().setObjetoCorpo(ConstantesSeguranca.MOVIMENTO);
                servidorCamera.getStatusDeteccao().setImagemSalvar(imagemAtual.getBufferedImage());
                return true;
            }
        }
        return false;
    }
    
    private Boolean verificarAmbienteStatico(IplImage imagemAtual) { 
        if(ambienteStatico != null) {
            ambienteStatico.detectar(imagemAtual);
            if(ambienteStatico.reportarObjetos()) {
                servidorCamera.getStatusDeteccao().setDetectado(true);
                servidorCamera.getStatusDeteccao().setObjetoCorpo(ConstantesSeguranca.AMBIENTE_STATICO);
                servidorCamera.getStatusDeteccao().setImagemSalvar(imagemAtual.getBufferedImage());
                return true;
            }
        }
        return false;
    }
    
    private void verificarObjetos(IplImage imagemAtual, CameraBean camera) {  
        if(!servidorCamera.getStatusDeteccao().getDetectadoObjeto() && 
                ConfigDispositivos.getDetectarObjeto() && camera.getConfigCamera().getObjeto() == EnumObjetoConfigCamera.SIM) {
            servidorCamera.getStatusDeteccao().setDetectadoObjeto(true);
            DetectarObjetos detectarObjetos = new DetectarObjetos(imagemAtual, servidorCamera);
            try {
                detectarObjetos.detectar();
                servidorCamera.getStatusDeteccao().setDetectadoObjeto(false);
            } catch (Exception ex) {
                MensagensErro.detectarObjeto(ex);
                System.out.println("Detectar objeto: "+ex);
            }
        }
    }
    
    private void verificarFaces(IplImage imagemAtual, CameraBean camera){
        if(!servidorCamera.getStatusDeteccao().getDetectadoFace() && 
                ConfigDispositivos.getDetectarFace() && camera.getConfigCamera().getFace() == EnumFaceConfigCamera.SIM) {
            servidorCamera.getStatusDeteccao().setDetectadoFace(true);
            DetectarFaces detectarFaces = new DetectarFaces(imagemAtual, servidorCamera);
            try {
                detectarFaces.detectar();
                servidorCamera.getStatusDeteccao().setDetectadoFace(false);
            } catch (Exception ex) {
                MensagensErro.detectarFace(ex);
                System.out.println("Detectar face: "+ex);
            }
        }
    }
    
    private void verificarOlhos(IplImage imagemAtual, CameraBean camera){
        if(!servidorCamera.getStatusDeteccao().getDetectadoOlhos() && 
                ConfigDispositivos.getDetectarOlhos() && camera.getConfigCamera().getOlhos() == EnumOlhosConfigCamera.SIM) {
            servidorCamera.getStatusDeteccao().setDetectadoOlhos(true);
            DetectarOlhos detectarOlhos = new DetectarOlhos(imagemAtual, servidorCamera);
            try {
                detectarOlhos.detectar();
                servidorCamera.getStatusDeteccao().setDetectadoOlhos(false); 
            } catch (Exception ex) {
                MensagensErro.detectarOlhos(ex);
                System.out.println("Detectar olhos: "+ex);
            }
        }
    }
    
    private void verificarCorpo(IplImage imagemAtual, CameraBean camera){
        if(!servidorCamera.getStatusDeteccao().getDetectadoCorpo() && 
                ConfigDispositivos.getDetectarCorpo() && camera.getConfigCamera().getCorpo() == EnumCorpoConfigCamera.SIM) {
            servidorCamera.getStatusDeteccao().setDetectadoCorpo(true);
            DetectarCorpo detectarCorpo = new DetectarCorpo(imagemAtual, servidorCamera);
            try {
                detectarCorpo.detectar();
                servidorCamera.getStatusDeteccao().setDetectadoCorpo(false); 
            } catch (Exception ex) {
                MensagensErro.detectarCorpo(ex);
                System.out.println("Detectar corpo: "+ex);
            }
        }
    }
    
    /*private void verificarAutoCorpo(IplImage imagemAtual, CameraBean camera){
        if(!servidorCamera.getStatusDeteccao().getDetectado() && 
                ConfigDispositivos.getDetectarCorpo() && camera.getConfigCamera().getCorpo() == EnumCorpoConfigCamera.SIM) {
            DetectarAutoCorpo detectarAutoCorpo = new DetectarAutoCorpo(imagemAtual, servidorCamera);
            try {
                detectarAutoCorpo.detectar();
            } catch (Exception ex) {
                MensagensErro.detectarCorpo(ex);
                System.out.println("Detectar AutoCorpo: "+ex);
            }
        }
    }
    
    private void verificarBaixoCorpo(IplImage imagemAtual, CameraBean camera){
        if(!servidorCamera.getStatusDeteccao().getDetectado() && 
                ConfigDispositivos.getDetectarCorpo() && camera.getConfigCamera().getCorpo() == EnumCorpoConfigCamera.SIM) {
            DetectarBaixoCorpo detectarBaixoCorpo = new DetectarBaixoCorpo(imagemAtual, servidorCamera);
            try {
                detectarBaixoCorpo.detectar();
            } catch (Exception ex) {
                MensagensErro.detectarCorpo(ex);
                System.out.println("Detectar BaixoCorpo: "+ex);
            }
        }
    }*/
    
    /*
     * OPERAÇÕES
     */
    
    private void verificaOperacoesMovimento(CameraBean camera) {
        if(ConfigDispositivos.getStatus() && ConfigDispositivos.getMovimento()
                && camera.getConfigCamera().getMovimento() == EnumMovimentoConfigCamera.SIM) {
            servidorCamera.gravarAutomatico();
            if(ConfigDispositivos.getAtivarAcionamento() && ConfigDispositivos.getAtivarDispositivosCamera()) {
                if(camera.getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
                    servidorCamera.getRealizaOperacoes().verificaControleAutomaticoOuAlarme(camera); 
                } 
            }
        }
    } 
    
    private void verificaOperacoesAlteracaoAmbiente(CameraBean camera) {
        if(ConfigDispositivos.getStatus() && ConfigDispositivos.getAlteracaoAmbiente()
                && camera.getConfigCamera().getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
            servidorCamera.getStatusDeteccao().setInicioProcessamento(System.currentTimeMillis());
            servidorCamera.getStatusDeteccao().setInicioGravacao(System.currentTimeMillis());
            servidorCamera.gravarAutomatico();
            if(ConfigDispositivos.getAtivarAcionamento() && ConfigDispositivos.getAtivarDispositivosCamera()) {
                if(camera.getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
                    servidorCamera.getRealizaOperacoes().verificaControleAutomaticoOuAlarme(camera); 
                }
            }
        }
    }
    
    public AmbienteStatico getAmbienteStatico() {
        return ambienteStatico;
    }

    public DetectarMovimento getDetectarMovimento() {
        return detectarMovimento;
    }

    public void setAmbienteStatico(AmbienteStatico ambienteStatico) {
        this.ambienteStatico = ambienteStatico;
    }

    public void setDetectarMovimento(DetectarMovimento detectarMovimento) {
        this.detectarMovimento = detectarMovimento;
    }
    
    private CameraBean selecionaCamera(Integer codigo) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.selecionar(codigo);
        } catch (FacadeException ex) {
        }
        return null;
    }
   
}
