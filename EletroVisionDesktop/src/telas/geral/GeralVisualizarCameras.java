
package telas.geral;

import EletroVisionPortatil.dependencias.InstanciasPortatil;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import recursos.constantes.ConstantesRedes;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.comboBox.ImagemComboBox;
import telas.comuns.camera.InternalFrameCamera;
import telas.principal.Manual;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralVisualizarCameras extends javax.swing.JPanel {
    
    private Integer frameDistancia, proxFrameX=0, proxFrameY=0;

    public GeralVisualizarCameras() {
        initComponents();
        InstanciasTelas.setGeralVisualizarCameras(GeralVisualizarCameras.this);
        
        preencherComboVisualizacao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp_areaTrabalho = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        cb_visualizacao = new javax.swing.JComboBox();
        bt_ajuda = new javax.swing.JButton();
        bt_ultimaFoto = new javax.swing.JButton();

        dp_areaTrabalho.setBackground(new java.awt.Color(240, 240, 240));
        dp_areaTrabalho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dp_areaTrabalhoMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(76, 158, 92));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cb_visualizacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cb_visualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_visualizacaoActionPerformed(evt);
            }
        });

        bt_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ajuda_22x22.png"))); // NOI18N
        bt_ajuda.setToolTipText("Ajuda");
        bt_ajuda.setOpaque(false);
        bt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajudaActionPerformed(evt);
            }
        });

        bt_ultimaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/aplicacaoPortatil/ultima_foto_22.png"))); // NOI18N
        bt_ultimaFoto.setToolTipText("Visualizar última foto");
        bt_ultimaFoto.setOpaque(false);
        bt_ultimaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ultimaFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_visualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_ultimaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cb_visualizacao)
            .addComponent(bt_ajuda)
            .addComponent(bt_ultimaFoto)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dp_areaTrabalho, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_areaTrabalho, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cb_visualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_visualizacaoActionPerformed
    if(dp_areaTrabalho.getAllFrames().length > 0){
        if(cb_visualizacao.getSelectedIndex() == 1){
            janelaCascata();
        } else if(cb_visualizacao.getSelectedIndex() == 2){
            janelaLadoLado();
        }
    }
}//GEN-LAST:event_cb_visualizacaoActionPerformed

private void dp_areaTrabalhoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dp_areaTrabalhoMouseReleased
    JInternalFrame frame = dp_areaTrabalho.getSelectedFrame(); 
}//GEN-LAST:event_dp_areaTrabalhoMouseReleased

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    private void bt_ultimaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimaFotoActionPerformed
        tirarUltimaFoto();
    }//GEN-LAST:event_bt_ultimaFotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_ultimaFoto;
    private javax.swing.JComboBox cb_visualizacao;
    private javax.swing.JDesktopPane dp_areaTrabalho;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void preencherComboVisualizacao() {
        Map<Object, Icon> itens = new HashMap<>();
        itens.put(".", new ImageIcon(getClass().getResource(ArquivosImagens.visual_cascata())));
        itens.put(",", new ImageIcon(getClass().getResource(ArquivosImagens.visual_ladoLado())));
        
        cb_visualizacao.addItem("."); 
        cb_visualizacao.addItem(","); 
        
        cb_visualizacao.setRenderer(new ImagemComboBox(itens));
        cb_visualizacao.setSelectedIndex(1);
    }
    
    public void iniciarVisualizacao(){
        dp_areaTrabalho.removeAll();
        for(ServidorCamera servidorCamera : InstanciasControle.getIniciarCameras().getServidoresCameras()){
            exibirCamera(servidorCamera); 
        }
        if(dp_areaTrabalho.getAllFrames().length > 0){
            if(cb_visualizacao.getSelectedIndex() == 1) {
                janelaCascata();
            } else if(cb_visualizacao.getSelectedIndex() == 2) {
                janelaLadoLado();
            }
        }
    }
    
    private void exibirCamera(ServidorCamera servidorCamera) {  
        InternalFrameCamera iif = new InternalFrameCamera(servidorCamera);
        iif.setTitle(servidorCamera.getCamera().getNome() + " - " + servidorCamera.getCamera().getIdentificacao());
        iif.setCamera();
        iif.show(); 
        
        dp_areaTrabalho.add(iif);

        servidorCamera.setImagemPanel(iif.getImagePanel(), ConfigDispositivos.getLargura(), ConfigDispositivos.getAltura());
        
        frameDistancia = iif.getHeight() - iif.getContentPane().getHeight();
        proxFrameX += frameDistancia;
        proxFrameY += frameDistancia;
        if (proxFrameX + ConfigDispositivos.getLargura() > dp_areaTrabalho.getWidth()) {
            proxFrameX = 0;
        }
        if (proxFrameY + ConfigDispositivos.getLargura() > dp_areaTrabalho.getHeight()) {
            proxFrameY = 0;
        }
    }
    
    private void tirarUltimaFoto() {
        if(InstanciasPortatil.getCliente() != null) {
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_TIRAR_ULTIMA_FOTO);
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerVisualClienteDesconectado()); 
        }
    }
     
    public void janelaCascata() {
        //retorna um array com todos frames da janela principal.
        JInternalFrame[] frames = dp_areaTrabalho.getAllFrames();
        int x = 10;
        int y = 10;
        
        for (int i = 0; i < frames.length; i++) {
            if (!frames[i].isIcon()) {  //se o frame não estiver iconizado.
                try {
                    frames[i].setMaximum(false); //tirna ele redimencionavel.
                    frames[i].reshape(x, y, ConfigDispositivos.getLargura(), ConfigDispositivos.getAltura()+50); //define sua posicao de tamanho.
                    x += frameDistancia;
                    y += frameDistancia;
                    if (proxFrameX + ConfigDispositivos.getLargura() > dp_areaTrabalho.getWidth()) {
                        x = 0;
                    }
                    if (proxFrameY + ConfigDispositivos.getLargura() > dp_areaTrabalho.getHeight()) {
                        y = 0;
                    }
                } catch (PropertyVetoException ex) {
                }
            }
        }
    }

    public void janelaLadoLado() {
        //retorna um array com todos frames da janela principal.
        JInternalFrame[] frames = dp_areaTrabalho.getAllFrames();
        //conta os quadros que não foram iconizados.
        int contarFrames = 0;
        for (int i = 0; i < frames.length; i++) {
            if (!frames[i].isIcon()) {
                contarFrames++;
            }
        }
        int linhas = (int) Math.sqrt(contarFrames);//as linhas é a raiz quadrada da quantidade de frames.
        int colunas = contarFrames / linhas;      //as colunas é a divisao dos frames pelas linhas;
        int linhasExtra = contarFrames % linhas;  //linhas extras.

        int width_ = dp_areaTrabalho.getWidth() / colunas; //obtem a largura do dividido pelo numero de colunas.
        int heigth_ = dp_areaTrabalho.getHeight() / linhas;
        int linh = 0;
        int col = 0;

        for (int i = 0; i < frames.length; i++) {
            if (!frames[i].isIcon()) {
                try {
                    frames[i].setMaximum(false);
                    frames[i].reshape(col * width_, linh * heigth_, width_, heigth_);
                    linh++;
                    if (linh == linhas) {
                        linh = 0; //zera a linha.
                        col++;    //avança uma coluna.
                        if (col == colunas - linhasExtra) {
                            linhas++; //adiciona linha extra.
                            heigth_ = dp_areaTrabalho.getHeight() / linhas;
                        }
                    }
                } catch (PropertyVetoException ex) {
                }
            }
        }
    }
    
    public void atualizarTela() {
        iniciarVisualizacao();
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.visualizarCameras());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
}
