
package EletroVisionPortatil.dependencias;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ListaMensagem extends javax.swing.JPanel {

    public ListaMensagem() {
        initComponents();
        setSize(399, 50); 
    }
    
    public ListaMensagem(Integer altura, Integer y) {
        initComponents();
        
        setSize(390, altura); 
        setLocation(0, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_nome = new javax.swing.JLabel();
        pn_mensagem = new javax.swing.JTextPane();

        setOpaque(false);

        lb_nome.setBackground(new java.awt.Color(204, 204, 204));
        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nome.setText("Nome");
        lb_nome.setOpaque(true);

        pn_mensagem.setEditable(false);
        pn_mensagem.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(pn_mensagem)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_nome;
    public javax.swing.JTextPane pn_mensagem;
    // End of variables declaration//GEN-END:variables

    public void setNome(String nome) {
        lb_nome.setText(nome);
    }
    
    public void setMensagem(String mensagem) {
        pn_mensagem.setText(mensagem);
    }

}
