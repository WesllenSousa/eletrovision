
package telas.ferramentas.dependencias;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import controle.openCV_javaCV_Pro.video.ExibirVideo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import telas.comuns.imagens.ImagemPanel;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class PlayerOpenCv extends javax.swing.JPanel {

    private ExecutorService executorService;
    private ExibirVideo exibirVideo;
    private ImagemPanel imagemPanel;
    private String diretorioVideoAtual;
    
    public PlayerOpenCv() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        bt_player = new javax.swing.JButton();
        pn_video = new javax.swing.JPanel();
        sl_velocidade = new javax.swing.JSlider();

        bt_player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/play_22x22.png"))); // NOI18N
        bt_player.setToolTipText("Começar execução do vídeo");
        bt_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_playerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_player, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_player)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_video.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pn_videoLayout = new javax.swing.GroupLayout(pn_video);
        pn_video.setLayout(pn_videoLayout);
        pn_videoLayout.setHorizontalGroup(
            pn_videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        pn_videoLayout.setVerticalGroup(
            pn_videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        sl_velocidade.setOrientation(javax.swing.JSlider.VERTICAL);
        sl_velocidade.setToolTipText("Velocidade do vídeo");
        sl_velocidade.setValue(0);
        sl_velocidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sl_velocidadeStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pn_video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sl_velocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_video, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sl_velocidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_playerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_playerActionPerformed
        if (!exibirVideo.getStatus()) {
            play();
        } else if (exibirVideo.getPause()) {
            continuar();
        } else {
            pause();
        }
    }//GEN-LAST:event_bt_playerActionPerformed

    private void sl_velocidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sl_velocidadeStateChanged
        exibirVideo.setVelocidade(sl_velocidade.getValue());
    }//GEN-LAST:event_sl_velocidadeStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_player;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JPanel pn_video;
    private javax.swing.JSlider sl_velocidade;
    // End of variables declaration//GEN-END:variables

    private void analizaBotoes() {
        if (exibirVideo == null) {
            bt_player.setEnabled(false);
        } else {
            bt_player.setEnabled(true);
        }
    }
    
    public void fim() {
        pararVideo();
        exibePrimeiraImagem();
        bt_player.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.video_play())));
    }

    public void pararVideo() {
        if (exibirVideo != null) {
            exibirVideo.setStatus(false);
            executorService.shutdown();
            executorService = null;
            exibirVideo = null;
            imagemPanel = null;
        }
    }
    
    public void exibePrimeiraImagem() {
        iniciarPainelImagem();
        exibirVideo = new ExibirVideo(diretorioVideoAtual, this);
        exibirVideo.setImagemPanel(imagemPanel, imagemPanel.getWidth(), imagemPanel.getHeight());
        executorService = Executors.newFixedThreadPool(1);
        analizaBotoes();
    }

    private void iniciarPainelImagem() {
        imagemPanel = new ImagemPanel();
        imagemPanel.setSize(350, 290);
        imagemPanel.setLocation(0, 0);
        pn_video.add(imagemPanel);
    }

    private void play() {
        exibirVideo.setVelocidade(sl_velocidade.getValue()); 
        exibirVideo.play();
        executorService.execute(exibirVideo);
        bt_player.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.video_pause())));
    }

    private void pause() {
        exibirVideo.pause();
        bt_player.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.video_play())));
    }
 
    private void continuar() {
        exibirVideo.continuar();
        bt_player.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.video_pause())));
    } 

    public String getDiretorioVideoAtual() {
        return diretorioVideoAtual;
    }

    public ImagemPanel getImagemPanel() {
        return imagemPanel;
    }

    public void setDiretorioVideoAtual(String diretorioVideoAtual) {
        this.diretorioVideoAtual = diretorioVideoAtual;
    }

    public ExibirVideo getExibirVideo() {
        return exibirVideo;
    }

    public JButton getBotaoPlayer() {
        return bt_player;
    }

}
