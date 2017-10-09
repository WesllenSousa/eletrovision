package telas.comuns.imagens;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class InternalFrameImagem extends JInternalFrame {
    
    private File arquivoImagem;
    private BufferedImage bufferedImage;
    private ImagemPanel imagemPanel;
    private JScrollPane scrollPane;

    public InternalFrameImagem() {
        this.iniciar();
    }
    
    public void pintarPanel(BufferedImage bufferedImage) {
        this.getImagePanel().setPreferredSize(new java.awt.Dimension(bufferedImage.getWidth(null), bufferedImage.getHeight(null)));
        this.getImagePanel().draw(bufferedImage);
    }

    public void exibirNoPainel() {
        this.carregarImagem();
        this.pintarPanel(this.getBufferedImage());
    }

    public void recarregar() {
        this.pintarPanel(this.getBufferedImage());
    }

    private void iniciar() {
        this.setImageFile(null);
        this.setBufferedImage(null);

        this.setImagePanel(new ImagemPanel());
        this.setScrollPane(new JScrollPane());

        this.getContentPane().setLayout(new java.awt.GridLayout());
        this.setClosable(false);
        this.setIconifiable(true);
        this.setMaximizable(false);
        this.setResizable(false);
        this.setAutoscrolls(true);
        this.setVisible(true);
        this.setSize(600, 500);

        this.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                fecharFrame();
            }
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            @Override
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        this.getScrollPane().setBackground(new java.awt.Color(153, 153, 255));
        this.getScrollPane().setBorder(new javax.swing.border.TitledBorder(null, null, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 204)));
        this.getScrollPane().setPreferredSize(new java.awt.Dimension(769, 60));
        this.getScrollPane().setViewportView(this.getImagePanel());

        getContentPane().add(this.getScrollPane(), new java.awt.GridLayout());
        this.getImagePanel().setBackground(new java.awt.Color(153, 153, 153));

        this.setFrameIcon(new ImageIcon(getClass().getResource(ArquivosImagens.logo())));

        this.pack();
    }

    private void carregarImagem() {
        this.setBufferedImage(ImagemUtil.ler(this.getImageFile()));
    }
    
    public File getImageFile() {
        return arquivoImagem;
    }

    public void setImageFile(File imageFile) {
        this.arquivoImagem = imageFile;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage buffer) {
        this.bufferedImage = buffer;
    }

    public ImagemPanel getImagePanel() {
        return imagemPanel;
    }

    private void setImagePanel(ImagemPanel imagePanel) {
        this.imagemPanel = imagePanel;
    }

    private JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    private void fecharFrame() {
        this.setBufferedImage(null);
        this.setImageFile(null);
        this.setImagePanel(null);
        this.setScrollPane(null);
        // chama o coletor de lixo
        System.gc();
    }

}


