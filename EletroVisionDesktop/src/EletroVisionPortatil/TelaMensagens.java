
package EletroVisionPortatil;

import EletroVisionPortatil.dependencias.ExibirListaMensagem;
import EletroVisionPortatil.dependencias.GuardaMensagem;
import EletroVisionPortatil.dependencias.InstanciasPortatil;
import recursos.constantes.ConstantesRedes;
import recursos.internacionalizacao.MensagensSoltas;

/**
 *
 * @author Wesllen
 */
public class TelaMensagens extends javax.swing.JPanel {
    
    private ExibirListaMensagem lista = new ExibirListaMensagem(this);

    public TelaMensagens() {
        initComponents();
        
        preencherMensagens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        pn_mensagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        et_mensagem = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setName("");
        scroll.setOpaque(false);

        pn_mensagem.setOpaque(false);

        javax.swing.GroupLayout pn_mensagemLayout = new javax.swing.GroupLayout(pn_mensagem);
        pn_mensagem.setLayout(pn_mensagemLayout);
        pn_mensagemLayout.setHorizontalGroup(
            pn_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        pn_mensagemLayout.setVerticalGroup(
            pn_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        scroll.setViewportView(pn_mensagem);

        et_mensagem.setColumns(20);
        et_mensagem.setRows(5);
        jScrollPane1.setViewportView(et_mensagem);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/aplicacaoPortatil/enviar_36.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        enviar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea et_mensagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel pn_mensagem;
    public javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private void enviar() {
        if (InstanciasPortatil.getCliente() != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_MENSAGEM);
                    InstanciasPortatil.getCliente().enviarDados(et_mensagem.getText().toString());
                    InstanciasPortatil.getCliente().enviarDados("0");
                }
            }).start();
            InstanciasPortatil.getMensagens().sucesso(MensagensSoltas.portatilMensagemEnviada());
        } else {
            InstanciasPortatil.getMensagens().aviso(MensagensSoltas.portatilDesconectado());
        }
    }
    
    public void receber() {
        et_mensagem.setText("");
        preencherMensagens();
    }
    
    private void preencherMensagens() {
        pn_mensagem.removeAll();
        lista.zerarY();
        if (InstanciasPortatil.getGuardaMensagens() != null && !InstanciasPortatil.getGuardaMensagens().isEmpty()) {
            for (GuardaMensagem guardaMensagem : InstanciasPortatil.getGuardaMensagens()) {
                lista.exibir(guardaMensagem.getContato(), guardaMensagem.getMensagem());
            }
        }
    }

}
