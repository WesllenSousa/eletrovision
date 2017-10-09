
package telas.comuns.templates;

import telas.pesquisas.PesquisarArea;
import telas.pesquisas.PesquisarCamera;
import telas.pesquisas.PesquisarDispositivoEletrico;
import telas.pesquisas.PesquisarMarca;
import telas.pesquisas.PesquisarModuloAcionamento;
import telas.pesquisas.PesquisarPessoa;
import telas.pesquisas.PesquisarPredio;
import telas.pesquisas.PesquisarUsuario;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Pesquisa extends javax.swing.JPanel {
    
    private PesquisarArea pesquisarArea;
    private PesquisarCamera pesquisarCamera;
    private PesquisarDispositivoEletrico pesquisarDispositivoEletrico;
    private PesquisarMarca pesquisarMarca;
    private PesquisarModuloAcionamento pesquisarModuloAcionamento;
    private PesquisarPessoa pesquisarPessoa;
    private PesquisarPredio pesquisarPredio;
    private PesquisarUsuario pesquisarUsuario;

    public Pesquisa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pn_principal = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        bt_ajuda = new javax.swing.JButton();

        setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/logo.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/midia/pesquisar_128x129.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/editar_22x22.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.setToolTipText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.setToolTipText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_principal.setName("PainelPrincipal"); // NOI18N

        javax.swing.GroupLayout pn_principalLayout = new javax.swing.GroupLayout(pn_principal);
        pn_principal.setLayout(pn_principalLayout);
        pn_principalLayout.setHorizontalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        pn_principalLayout.setVerticalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(51, 175, 233));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bt_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ajuda_22x22.png"))); // NOI18N
        bt_ajuda.setToolTipText("Ajuda");
        bt_ajuda.setOpaque(false);
        bt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_ajuda)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    excluir();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    editar();
}//GEN-LAST:event_jButton2ActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel pn_principal;
    // End of variables declaration//GEN-END:variables

    private void editar(){
        if(pesquisarCamera != null){
            pesquisarCamera.editar();
        } else if(pesquisarDispositivoEletrico != null){
            pesquisarDispositivoEletrico.editar();
        } else if(pesquisarMarca != null){
            pesquisarMarca.editar();
        } else if(pesquisarModuloAcionamento != null){
            pesquisarModuloAcionamento.editar();
        } else if(pesquisarPessoa != null){
            pesquisarPessoa.editar();
        } else if(pesquisarPredio != null){
            pesquisarPredio.editar();
        } else if(pesquisarUsuario != null){
            pesquisarUsuario.editar();
        } else if(pesquisarArea != null){
            pesquisarArea.editar();
        }
    }
    
    private void excluir(){
        if(pesquisarCamera != null){
            pesquisarCamera.excluir();
        } else if(pesquisarDispositivoEletrico != null){
            pesquisarDispositivoEletrico.excluir();
        } else if(pesquisarMarca != null){
            pesquisarMarca.excluir();
        } else if(pesquisarModuloAcionamento != null){
            pesquisarModuloAcionamento.excluir();
        } else if(pesquisarPessoa != null){
            pesquisarPessoa.excluir();
        } else if(pesquisarPredio != null){
            pesquisarPredio.excluir();
        } else if(pesquisarUsuario != null){
            pesquisarUsuario.excluir();
        } else if(pesquisarArea != null){
            pesquisarArea.excluir();
        }
    }
    
    private void ajuda(){
        if(pesquisarCamera != null){
            pesquisarCamera.ajuda();
        } else if(pesquisarDispositivoEletrico != null){
            pesquisarDispositivoEletrico.ajuda();
        } else if(pesquisarMarca != null){
            pesquisarMarca.ajuda();
        } else if(pesquisarModuloAcionamento != null){
            pesquisarModuloAcionamento.ajuda();
        } else if(pesquisarPessoa != null){
            pesquisarPessoa.ajuda();
        } else if(pesquisarPredio != null){
            pesquisarPredio.ajuda();
        } else if(pesquisarUsuario != null){
            pesquisarUsuario.ajuda();
        } else if(pesquisarArea != null){
            pesquisarArea.ajuda();
        }
    }
    
    public void verificaInstancias(Object object){
        if(object instanceof PesquisarCamera){
            pesquisarCamera = (PesquisarCamera) object;
        } else if(object instanceof PesquisarDispositivoEletrico){
            pesquisarDispositivoEletrico = (PesquisarDispositivoEletrico) object;
        } else if(object instanceof PesquisarMarca){
            pesquisarMarca = (PesquisarMarca) object;
        } else if(object instanceof PesquisarModuloAcionamento){
            pesquisarModuloAcionamento = (PesquisarModuloAcionamento) object;
        } else if(object instanceof PesquisarPessoa){
            pesquisarPessoa = (PesquisarPessoa) object;
        } else if(object instanceof PesquisarPredio){
            pesquisarPredio = (PesquisarPredio) object;
        } else if(object instanceof PesquisarUsuario){
            pesquisarUsuario = (PesquisarUsuario) object;
        } else if(object instanceof PesquisarArea){
            pesquisarArea = (PesquisarArea) object;
        }
    }
    
}
