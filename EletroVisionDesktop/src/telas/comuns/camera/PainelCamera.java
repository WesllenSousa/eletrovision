
package telas.comuns.camera;

import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import recursos.internacionalizacao.MensagensErro;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class PainelCamera extends JPanel implements MouseListener, Runnable {
    
    private OpenCVFrameGrabber grabber;
    private BufferedImage bufferedImage;
    private EscolherCameras escolherCameras;
    private Integer identificacao;
    private Boolean rodando = true;
    
    private Integer largura, altura;
    
    public PainelCamera(Object tela, Integer identificacao, Integer largura, Integer altura) {
        verificaInstancias(tela); 
        this.largura = largura;
        this.altura = altura;
        this.identificacao = identificacao;
        addMouseListener(PainelCamera.this);
        iniciar();
    }
    
    private void iniciar() {
        try {
            grabber = new OpenCVFrameGrabber(identificacao);   
            grabber.start();
        } catch (Exception ex) {
            MensagensErro.cameraIniciar(ex); 
        }
    }
    
    private IplImage capturarImagem() {
        try {
            return grabber.grab();
        } catch (Exception ex) {
            MensagensErro.cameraIniciar(ex); 
        }
        return null;
    }
    
    @Override
    public void run() {
        try {  
            IplImage frame;
            while(rodando){
                frame = capturarImagem();
                if(frame != null) {
                    bufferedImage = ImagemUtil.redimencionar(frame.getBufferedImage(), largura, altura);
                } else {
                    break;
                }
                repaint();
            }
            grabber.stop();
            grabber.release();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bufferedImage != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
        }
    }

    private void verificaInstancias(Object tela) {
        if(tela instanceof EscolherCameras) {
            escolherCameras = (EscolherCameras) tela;
        }
    }
    
    public void parar() {
        rodando = false;
    }
    
    /*----------------------------------------------------------------------------*/    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(escolherCameras != null) {
            escolherCameras.confirmar(identificacao);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorder(BorderFactory.createEtchedBorder());
    } 
    
}
