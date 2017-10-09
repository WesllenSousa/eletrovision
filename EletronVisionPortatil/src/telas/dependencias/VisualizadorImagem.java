
package telas.dependencias;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import recursos.InstanciasPortatil;
import util.DiretorioUtil;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class VisualizadorImagem extends javax.swing.JDialog {

    public VisualizadorImagem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();
        bt_fechar1 = new javax.swing.JButton();
        pnx_imagem = new org.jdesktop.swingx.JXImageView();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizador de Imagem");

        bt_fechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_fechar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar1.setText("Salvar");
        bt_fechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fechar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(489, Short.MAX_VALUE)
                .addComponent(bt_fechar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_fechar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_fechar)
                    .addComponent(bt_fechar1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnx_imagemLayout = new javax.swing.GroupLayout(pnx_imagem);
        pnx_imagem.setLayout(pnx_imagemLayout);
        pnx_imagemLayout.setHorizontalGroup(
            pnx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnx_imagemLayout.setVerticalGroup(
            pnx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnx_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnx_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-696)/2, (screenSize.height-609)/2, 696, 609);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_fechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fechar1ActionPerformed
        salvar();
    }//GEN-LAST:event_bt_fechar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_fechar1;
    private javax.swing.JPanel jPanel3;
    private org.jdesktop.swingx.JXImageView pnx_imagem;
    // End of variables declaration//GEN-END:variables

    public void exibeImagem(BufferedImage bufferedImage) {
        pnx_imagem.setImage(bufferedImage);
    }
    
    private void salvar() {
        JFileChooser fileChooser = new JFileChooser();
        Integer retorno = fileChooser.showDialog(this, "Salvar");
        
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String diretorio = fileChooser.getSelectedFile().getPath();
            File file = new File(diretorio+".png");
            if(DiretorioUtil.verificarSeArquivoDiretorioExiste(file)){
                ImagemUtil.salvar(ImagemUtil.imageParaBufferedImage(pnx_imagem.getImage(), Boolean.TRUE), file);
                InstanciasPortatil.getMensagens().sucesso("Imagem salva com sucesso!");
            }
        }
    }
    
}
