
package controle.openCV_javaCV_Pro.video;

import util.ImagemUtil;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.awt.image.BufferedImage;

import java.io.File;
import telas.comuns.imagens.ImagemPanel;
import recursos.internacionalizacao.MensagensErro;
import telas.ferramentas.dependencias.PlayerOpenCv;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ExibirVideo implements Runnable{
    
    private OpenCVFrameGrabber grabber;
    private IplImage iplImage;
    private BufferedImage bufferedImage;
    private ImagemPanel imagemPanel;
    
    private Boolean pause, status = false;
    private Integer velocidade;
    private Integer width, heigth;
    
    private PlayerOpenCv tela;
    
    public ExibirVideo(String diretorio, PlayerOpenCv tela) {
        grabber = new OpenCVFrameGrabber(new File(diretorio));
        pause = false;
        velocidade = 50;
        this.tela = tela;
    }
    
    public void play() {
        try {
            grabber.start();
            status = true;
        } catch (Exception ex) {
            MensagensErro.videoIniciar(ex);
        }
    }
    
    private void stop() {
        try {
            grabber.stop();
            grabber.release();
            status = false;
        } catch (Exception ex) {
            MensagensErro.videoParar(ex);
        }
    }
    
    public void continuar() {
        pause = false;
    }
    
    public void pause() {
        pause = true;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Boolean getPause() {
        return pause;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public void setImagemPanel(ImagemPanel imagemPanel, Integer width, Integer heigth) {
        this.imagemPanel = imagemPanel;
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public void run() {
        while (status) {
            if(!pause) {
                capturarImagem();
                if(iplImage != null) {
                    setarBufferedImage();
                    mostrarImagem();   
                } else {
                    break;
                }
            } 
        }
        tela.fim();
        stop();
    }
    
    private void capturarImagem() {
        try {
            iplImage = grabber.grab();
            dormir(velocidade);
        } catch (Exception ex) { 
            System.out.println("Fim do vídeo: \n"+ex);
            status = false;
        }
    }
    
    private void setarBufferedImage() {
        if(iplImage != null){
            bufferedImage = iplImage.getBufferedImage();
        }
    }
    
    private void mostrarImagem() {
        if(imagemPanel != null){
            imagemPanel.draw(ImagemUtil.redimencionar(bufferedImage, width, heigth));
        }
    }

    private void dormir(Integer velocidade) {
        try {
            Thread.sleep(Integer.parseInt(velocidade+"0"));
        } catch (InterruptedException ex) {
        }
    }
    
}
