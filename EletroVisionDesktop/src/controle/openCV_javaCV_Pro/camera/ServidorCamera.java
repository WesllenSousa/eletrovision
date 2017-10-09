
package controle.openCV_javaCV_Pro.camera;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import java.util.concurrent.ExecutorService;
import com.googlecode.javacv.OpenCVFrameRecorder;
import recursos.configuracoes.diretorios.caminhos.ArquivosVideo;
import recursos.configuracoes.sistema.ConfigDispositivos;
import entidades.camera.bean.CameraBean;
import java.awt.image.BufferedImage;
import recursos.instancias.InstanciasControle;
import telas.comuns.imagens.ImagemPanel; 
import util.ImagemUtil;
import static com.googlecode.javacv.cpp.opencv_core.*;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.processamento.ProcessarImagem;
import controle.openCV_javaCV_Pro.processamento.RealizaOperacoes;
import controle.openCV_javaCV_Pro.processamento.dependencias.StatusDeteccao;
import controle.openCV_javaCV_Pro.processamento.detectar.AmbienteStatico;
import entidades.configCamera.bean.EnumGravarConfigCamera;
import entidades.configCamera.bean.EnumTipoProcessamentoConfigCamera;
import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ServidorCamera implements Runnable {
    
    private StatusDeteccao statusDeteccao = new StatusDeteccao();
    private RealizaOperacoes realizaOperacoes;
    private ProcessarImagem processarImagem;
    
    private CameraBean camera; 
    private ImagemPanel imagemPanel;
    private ExecutorService processamento;
    
    private FrameGrabber grabber;
    private OpenCVFrameRecorder recorder; 
    private IplImage imagemAtual;  
    private BufferedImage bufferedImage;
    
    private Integer contFrame = 1, width, heigth;
    private Boolean status, foto, pause, gravando, gravarManual; 
    private String diretorioVideoAtual;
    
    public ServidorCamera(CameraBean camera){ 
        this.camera = camera;
        statusDeteccao.setDetectado(false);
        configurarBooleans();
        processarImagem = new ProcessarImagem(this);
        realizaOperacoes = new RealizaOperacoes(this);
    }
    
    public ServidorCamera(String identificacao){ 
        camera = new CameraBean();
        camera.setIdentificacao(identificacao);
        configurarBooleans(); 
        foto = true;
    }
    
    public Boolean iniciarCamera(String identificacao){
        try {
            if(identificacao.indexOf("http") != -1) {
                grabber = new OpenCVFrameGrabber(identificacao);
            } else {
                grabber = new OpenCVFrameGrabber(Integer.parseInt(identificacao)); 
            }
            grabber.start();
            status = true;
        } catch (FrameGrabber.Exception ex) {
            MensagensErro.cameraIniciar(ex); 
            System.out.println("Erro ao iniciar câmera: "+ex);
            return false;
        }
        return true;
    }
    
    public void iniciarGravacao() {
        String diretorio = InstanciasControle.getSalvarImgDetectada().criarDiretorios(
                                ArquivosVideo.todosVideosInternos()).getAbsolutePath();
        diretorioVideoAtual = diretorio+File.separator+System.currentTimeMillis()+".mpeg";
        recorder = new OpenCVFrameRecorder(diretorioVideoAtual, imagemAtual.width(), imagemAtual.height());
        try {
            recorder.setVideoCodec(ConfigDispositivos.getCodec()); //Codec tem que procurar o número certo
            recorder.start(); 
            gravando = true;
            System.out.println("Gravação iniciada.");
        } catch (final Exception ex) {
            MensagensErro.cameraGravar(ex);
            System.out.println("Erro ao iniciar gravação: "+ex);
        }
    }
    
    public void parar(){
        try {
            if(gravando) {
                pararGravacao();
            }
            if(grabber != null) {
                grabber.stop();
                grabber.release();
                System.out.println("Câmera " + camera.getNome() + " parada.");
            }
        } catch (Exception ex) {
            MensagensErro.cameraParar(ex); 
            System.out.println("Erro ao parar câmera: "+ex);
        }
    }
    
    public void pararGravacao() {
         if(recorder != null) {
            try {
                recorder.stop();
                recorder.release();
                recorder = null;
                gravando = false;
                gravarManual = null;
                System.out.println("Gravação parada.");
            } catch (Exception ex) {
                MensagensErro.cameraPararGravacao(ex); 
                System.out.println("Erro ao parar gravação: "+ex);
            }   
        }
    }

    public void setImagemPanel(ImagemPanel imagemPanel, Integer width, Integer heigth) {
        this.imagemPanel = imagemPanel;
        this.width = width;
        this.heigth = heigth;
    }
    
    public void verificarAmbienteStatico() {
        if(camera.getConfigCamera().getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO) { 
            if(processarImagem.getAmbienteStatico() == null) {
                System.out.println("Ambiente statico iniciado.");
                AmbienteStatico ambienteStatico = new AmbienteStatico(imagemAtual);
                processarImagem.setAmbienteStatico(ambienteStatico); 
                processarImagem.setDetectarMovimento(null);
            }
        }
    }

    @Override
    public void run() {      
        getStatusDeteccao().setInicioControleAutomatico(System.currentTimeMillis());
        while (status) { 
            if(!pause) {
                capturarImagemCamera();              
                setarBufferedImage();
                mostrarImagem();
                if(imagemAtual != null && !foto) {
                    processar();       
                    gravar();
                    analizarFrames();
                } 
                contFrame++;
            } else {
                dormir(5000);
            }
        }
        parar();
        processamento.shutdownNow();
    }
    
    private void analizarFrames() {
        if(contFrame % 500 == 0) {
            getStatusDeteccao().setMandarMensagem(true);
            verificarAmbienteStatico();
        }
        if(contFrame % 200 == 0) {
            System.gc();
        }   
        if(contFrame >= 1000) {
            contFrame = 1;
        }
    }
    
    private void capturarImagemCamera(){
        try {
            imagemAtual = grabber.grab();
        } catch (FrameGrabber.Exception ex) {
            System.out.println("Erro ao capturar imagem câmera: "+ex);
            parar();
        } 
    }
    
    private void processarGravacao() {
        try {
            if(recorder != null) {
                recorder.record(imagemAtual);
            } else {
                iniciarGravacao();
            }
        } catch (final Exception ex) {
            ConfigDispositivos.setGravarVideo(false); 
            MensagensErro.cameraProcessarGravacao(ex); 
            System.out.println("Erro ao gravar: "+ex);
            pararGravacao();  
        }
    }
    
    private void processar() {
        if(getStatusDeteccao().verificaTempoExecucaoProcessamento()) {
            processamento.execute(new Runnable() {
                @Override
                public void run() {
                    getProcessarImagem().verificarProcessos(camera, imagemAtual, contFrame);    
                }
            });    
        } 
        if(contFrame % 9 == 0) {
            if(getStatusDeteccao().verificaTempoControleAutomatico()) {
                getRealizaOperacoes().desligaControleAutomatico(camera);
            }
        }
    }
    
    private void gravar() {
        if(gravarManual != null) {
            gravarManual();
        } else if(gravando) {
            gravarAutomatico();
        }
    }
    
    private void gravarManual() {
        if(gravarManual) {
            processarGravacao();
        } else {
            pararGravacao();
        }
    }
    
    public void gravarAutomatico() {
        if(ConfigDispositivos.getGravarVideo() && camera.getConfigCamera().getGravar() == EnumGravarConfigCamera.SIM) {
            if(!getStatusDeteccao().verificaTempoGravacao()) {
                processarGravacao();
            } else {
                pararGravacao();
            }
        } else {
            pararGravacao();
        }
    }
    
    private void setarBufferedImage() {
        if(imagemAtual != null){
            bufferedImage = imagemAtual.getBufferedImage();
        }
    }

    private void mostrarImagem() {
        if(imagemPanel != null && bufferedImage != null){
            imagemPanel.draw(ImagemUtil.redimencionar(bufferedImage, width, heigth));
        }
    }
    
    /*OUTROS*/

    private void dormir(Integer tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
        }
    }
    
    private void configurarBooleans(){
        foto = false;
        pause = false;
        gravando = false;
        status = false;
    }
    
    /*GETTER e SETTER*/
    
    public CameraBean getCamera() {
        return camera;
    }

    public void setCamera(CameraBean camera) {
        this.camera = camera;
    }
    
    public void setFoto(Boolean foto) {
        this.foto = foto;
    }

    public void setPause(Boolean pause) {
        this.pause = pause;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public Boolean getPause() {
        return pause;
    }

    public Boolean getGravando() {
        return gravando;
    } 
    
    public StatusDeteccao getStatusDeteccao() {
        return statusDeteccao;
    } 
    
    public ProcessarImagem getProcessarImagem() {
        return processarImagem;
    }

    public RealizaOperacoes getRealizaOperacoes() {
        return realizaOperacoes;
    }

    public void setGravarManual(Boolean gravarManual) {
        this.gravarManual = gravarManual;
    }

    public Boolean getGravarManual() {
        return gravarManual;
    }

    public String getDiretorioVideoAtual() {
        return diretorioVideoAtual;
    }

    public void setProcessamento(ExecutorService processamento) {
        this.processamento = processamento;
    }   
    
}
