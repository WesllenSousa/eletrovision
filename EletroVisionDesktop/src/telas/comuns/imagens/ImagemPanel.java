package telas.comuns.imagens;

import telas.comuns.camera.FrameFaceCamera;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import telas.comuns.camera.EscolherCameras;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ImagemPanel extends JPanel implements MouseListener {

    private FrameFaceCamera frameFaceCamera;
    private EscolherCameras escolherCameras;
    
    private BufferedImage bufferedImage;
    private String identificacao;

    public ImagemPanel() {
        this.init();
    }
    
    public ImagemPanel(Object tela, String identificacao) {
        this.init();
        verificaInstancias(tela); 
        this.identificacao = identificacao;
        addMouseListener(ImagemPanel.this);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage buffer) {
        this.bufferedImage = buffer;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.getBufferedImage() != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.drawImage(this.getBufferedImage(), 0, 0, this.getBufferedImage().getWidth(), this.getBufferedImage().getHeight(), this);
        }
    }

    private void init() {
        this.setBufferedImage(null);
    }

    public void draw(BufferedImage bufferedImage) {
        this.setBufferedImage(bufferedImage);
        this.repaint();
    }
    
    private void verificaInstancias(Object tela) {
        if(tela instanceof FrameFaceCamera) {
            frameFaceCamera = (FrameFaceCamera) tela;
        } else if(tela instanceof EscolherCameras) {
            escolherCameras = (EscolherCameras) tela;
        }
    }
    
/*----------------------------------------------------------------------------*/    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(frameFaceCamera != null ) {
            frameFaceCamera.setDiretorioExcluir(identificacao, this);
            frameFaceCamera.mn_face.show(e.getComponent(), e.getX(), e.getY()); 
        } else if(escolherCameras != null) {
            escolherCameras.confirmar(Integer.parseInt(identificacao));
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
