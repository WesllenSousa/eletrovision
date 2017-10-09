package telas.ferramentas.dependencias;

import controle.filtros.EnumFiltro;
import controle.filtros.Filtros;
import java.awt.image.BufferedImage;
import telas.ferramentas.FerramentasEditarImagens;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Controles extends javax.swing.JDialog {
    
    private Filtros filtros;
    private FerramentasEditarImagens painel;
    
    private BufferedImage bufferAtual;
    private EnumFiltro enumFiltro = null;

    public Controles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        instanciaClasses();
    }
    
    public Controles(java.awt.Frame parent, boolean modal, FerramentasEditarImagens painel) {
        super(parent, modal);
        initComponents();
        instanciaClasses();
        
        this.painel = painel;
    }
    
    private void instanciaClasses(){
        if(filtros == null) {
            filtros = new Filtros();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb_slide1 = new javax.swing.JLabel();
        lb_slide2 = new javax.swing.JLabel();
        lb_slide3 = new javax.swing.JLabel();
        sl_slide1 = new javax.swing.JSlider();
        sl_slide2 = new javax.swing.JSlider();
        sl_slide3 = new javax.swing.JSlider();
        tf_slide1 = new javax.swing.JTextField();
        tf_slide2 = new javax.swing.JTextField();
        tf_slide3 = new javax.swing.JTextField();
        lb_slide4 = new javax.swing.JLabel();
        sl_slide4 = new javax.swing.JSlider();
        tf_slide4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lb_combo1 = new javax.swing.JLabel();
        cb_combo1 = new javax.swing.JComboBox();
        lb_combo2 = new javax.swing.JLabel();
        cb_combo2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        ck_checkbox1 = new javax.swing.JCheckBox();
        ck_checkbox2 = new javax.swing.JCheckBox();
        ck_checkbox3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controles");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lb_slide1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_slide1.setText("Controle 1");

        lb_slide2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_slide2.setText("Controle 2");

        lb_slide3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_slide3.setText("Controle 3");

        sl_slide1.setMinimum(1);
        sl_slide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sl_slide1MouseReleased(evt);
            }
        });
        sl_slide1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sl_slide1StateChanged(evt);
            }
        });

        sl_slide2.setMinimum(1);
        sl_slide2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sl_slide2MouseReleased(evt);
            }
        });
        sl_slide2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sl_slide2StateChanged(evt);
            }
        });

        sl_slide3.setMinimum(1);
        sl_slide3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sl_slide3MouseReleased(evt);
            }
        });
        sl_slide3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sl_slide3StateChanged(evt);
            }
        });

        tf_slide1.setEditable(false);
        tf_slide1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tf_slide2.setEditable(false);
        tf_slide2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tf_slide3.setEditable(false);
        tf_slide3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lb_slide4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_slide4.setText("Controle 4");

        sl_slide4.setMinimum(1);
        sl_slide4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sl_slide4MouseReleased(evt);
            }
        });
        sl_slide4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sl_slide4StateChanged(evt);
            }
        });

        tf_slide4.setEditable(false);
        tf_slide4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_slide4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_slide3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_slide2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_slide1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sl_slide3, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(sl_slide2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(sl_slide1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_slide1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_slide2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_slide3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sl_slide4, 0, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_slide4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_slide1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sl_slide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_slide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_slide2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sl_slide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_slide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_slide3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sl_slide3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_slide3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_slide4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sl_slide4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_slide4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_combo1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_combo1.setText("Combo1");

        cb_combo1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_combo1ActionPerformed(evt);
            }
        });

        lb_combo2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_combo2.setText("Combo2");

        cb_combo2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_combo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_combo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_combo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_combo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_combo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_combo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ck_checkbox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_checkbox1.setText("CheckBox1");
        ck_checkbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_checkbox1ActionPerformed(evt);
            }
        });

        ck_checkbox2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_checkbox2.setText("CheckBox2");
        ck_checkbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_checkbox2ActionPerformed(evt);
            }
        });

        ck_checkbox3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_checkbox3.setText("CheckBox3");
        ck_checkbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_checkbox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_checkbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_checkbox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_checkbox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_checkbox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_checkbox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_checkbox3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-253)/2, (screenSize.height-590)/2, 253, 590);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ok();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    exibirImagem(bufferAtual); 
    dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void sl_slide1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sl_slide1StateChanged
    tf_slide1.setText(sl_slide1.getValue()+"");
}//GEN-LAST:event_sl_slide1StateChanged

private void sl_slide2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sl_slide2StateChanged
    tf_slide2.setText(sl_slide2.getValue()+""); 
}//GEN-LAST:event_sl_slide2StateChanged

private void sl_slide3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sl_slide3StateChanged
    tf_slide3.setText(sl_slide3.getValue()+"");
}//GEN-LAST:event_sl_slide3StateChanged

private void sl_slide4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sl_slide4StateChanged
    tf_slide4.setText(sl_slide4.getValue()+"");
}//GEN-LAST:event_sl_slide4StateChanged

private void sl_slide1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sl_slide1MouseReleased
    filtrar();
}//GEN-LAST:event_sl_slide1MouseReleased

private void sl_slide2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sl_slide2MouseReleased
    filtrar();
}//GEN-LAST:event_sl_slide2MouseReleased

private void sl_slide3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sl_slide3MouseReleased
    filtrar();
}//GEN-LAST:event_sl_slide3MouseReleased

private void sl_slide4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sl_slide4MouseReleased
    filtrar();
}//GEN-LAST:event_sl_slide4MouseReleased

private void cb_combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_combo1ActionPerformed
    if(enumFiltro != null)
        filtrar();
}//GEN-LAST:event_cb_combo1ActionPerformed

private void cb_combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_combo2ActionPerformed
    if(enumFiltro != null)
        filtrar();
}//GEN-LAST:event_cb_combo2ActionPerformed

private void ck_checkbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_checkbox1ActionPerformed
    filtrar();
}//GEN-LAST:event_ck_checkbox1ActionPerformed

private void ck_checkbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_checkbox2ActionPerformed
    filtrar();
}//GEN-LAST:event_ck_checkbox2ActionPerformed

private void ck_checkbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_checkbox3ActionPerformed
    filtrar();
}//GEN-LAST:event_ck_checkbox3ActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    exibirImagem(bufferAtual); 
    dispose();
}//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_combo1;
    private javax.swing.JComboBox cb_combo2;
    private javax.swing.JCheckBox ck_checkbox1;
    private javax.swing.JCheckBox ck_checkbox2;
    private javax.swing.JCheckBox ck_checkbox3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lb_combo1;
    private javax.swing.JLabel lb_combo2;
    private javax.swing.JLabel lb_slide1;
    private javax.swing.JLabel lb_slide2;
    private javax.swing.JLabel lb_slide3;
    private javax.swing.JLabel lb_slide4;
    private javax.swing.JSlider sl_slide1;
    private javax.swing.JSlider sl_slide2;
    private javax.swing.JSlider sl_slide3;
    private javax.swing.JSlider sl_slide4;
    private javax.swing.JTextField tf_slide1;
    private javax.swing.JTextField tf_slide2;
    private javax.swing.JTextField tf_slide3;
    private javax.swing.JTextField tf_slide4;
    // End of variables declaration//GEN-END:variables

    public void configuraSlides(String controle1, String controle2, String controle3, String controle4) {
        if(controle1.equals("")){
            lb_slide1.setVisible(false);
            sl_slide1.setVisible(false);
            tf_slide1.setVisible(false);
        } else {
            lb_slide1.setText(controle1);
            tf_slide1.setText(sl_slide1.getValue()+"");
        }
        if(controle2.equals("")){
            lb_slide2.setVisible(false);
            sl_slide2.setVisible(false);
            tf_slide2.setVisible(false);
        } else {
            lb_slide2.setText(controle2);
            tf_slide2.setText(sl_slide2.getValue()+"");
        }
        if(controle3.equals("")){
            lb_slide3.setVisible(false);
            sl_slide3.setVisible(false);
            tf_slide3.setVisible(false);
        }  else {
            lb_slide3.setText(controle3);
            tf_slide3.setText(sl_slide3.getValue()+"");
        }
        if(controle4.equals("")){
            lb_slide4.setVisible(false);
            sl_slide4.setVisible(false);
            tf_slide4.setVisible(false);
        } else {
            lb_slide4.setText(controle4);
            tf_slide4.setText(sl_slide4.getValue()+"");
        }
    }
    
    public void configuraCombo(String combo1, String[] itens1, String combo2, String[] itens2) {
        if(combo1.equals("")) {
            lb_combo1.setVisible(false);
            cb_combo1.setVisible(false);
        } else {
            lb_combo1.setText(combo1);
            for(String item : itens1) {
                cb_combo1.addItem(item);
            }
        }
        if(combo2.equals("")) {
            lb_combo2.setVisible(false);
            cb_combo2.setVisible(false);
        } else {
            lb_combo2.setText(combo2);
            for(String item : itens2) {
                cb_combo2.addItem(item);
            }
        }
    }
    
    public void configuraCkeckBox(String checkbox1, String checkbox2, String checkbox3) {
        if(checkbox1.equals("")) {
            ck_checkbox1.setVisible(false);
        } else {
            ck_checkbox1.setText(checkbox1);
        }
        if(checkbox2.equals("")) {
            ck_checkbox2.setVisible(false);
        } else {
            ck_checkbox2.setText(checkbox2);
        }
        if(checkbox3.equals("")) {
            ck_checkbox3.setVisible(false);
        } else {
            ck_checkbox3.setText(checkbox3);
        }
    }
    
    public void inicializaControles(BufferedImage bufferedAtual, EnumFiltro enumFiltro){
        this.bufferAtual = bufferedAtual;
        this.enumFiltro = enumFiltro;
        
        filtrar();
    }
    
    private void filtrar() {
        if(enumFiltro == EnumFiltro.CONTRASTE){
            contraste();
        } else if(enumFiltro == EnumFiltro.DOBRAR){
            dobrar();
        } else if(enumFiltro == EnumFiltro.EXPOSICAO_LUZ){
            exposicaoLuz();
        } else if(enumFiltro == EnumFiltro.ADICAO){
            adicao();
        } else if(enumFiltro == EnumFiltro.GAMMA){
            gamma();
        } else if(enumFiltro == EnumFiltro.ESCALA_CINZA){
            escalaCinza();
        } else if(enumFiltro == EnumFiltro.HSBA){
            hsba();
        } else if(enumFiltro == EnumFiltro.INVERTER){
            inverter();
        } else if(enumFiltro == EnumFiltro.NIVEIS){
            niveis();
        } else if(enumFiltro == EnumFiltro.POSTERIZAR){
            posterizar();
        } else if(enumFiltro == EnumFiltro.RESCALAR){
            rescalar();
        } else if(enumFiltro == EnumFiltro.RGB){
            rgb();
        } else if(enumFiltro == EnumFiltro.SOLARIZAR){
            solarizar();
        } else if(enumFiltro == EnumFiltro.THRESHOLDING){
            thresholding();
        } else if(enumFiltro == EnumFiltro.MISTURAR){
            misturar();
        } else if(enumFiltro == EnumFiltro.VIDRO){
            vidro();
        } else if(enumFiltro == EnumFiltro.MARMORE){
            marmore();
        } else if(enumFiltro == EnumFiltro.CROMAR){
            cromar();
        } else if(enumFiltro == EnumFiltro.RELEVO){
            relevo();
        } else if(enumFiltro == EnumFiltro.SOBEL){
            sobel();
        }
    }
    
    private void ok() {
        dispose();
    }
    
    private void exibirImagem(BufferedImage bufferedImage){
        painel.exibirImagem(bufferedImage);
    }
    
//======================================================================
    
    private void contraste(){     
        Float intensidade = sl_slide1.getValue()/50f;
        Float brilho = sl_slide2.getValue()/50f;
        BufferedImage bufferedFiltro = filtros.contraste(bufferAtual, intensidade, brilho);
        exibirImagem(bufferedFiltro);
    }

    private void dobrar() {
        Float angulo = sl_slide1.getValue() / 0.28f;
        Float transicao = sl_slide2.getValue()/100f;
        BufferedImage bufferedFiltro = filtros.dobrar(bufferAtual, angulo, transicao);
        exibirImagem(bufferedFiltro);
    }

    private void exposicaoLuz() {
        Float intensidade = sl_slide1.getValue() / 20f;
        BufferedImage bufferedFiltro = filtros.exposicaoLuz(bufferAtual, intensidade);
        exibirImagem(bufferedFiltro);
    }

    private void adicao() {
        Integer adicao = sl_slide1.getValue();
        Integer polarizacao = sl_slide2.getValue();
        BufferedImage bufferedFiltro = filtros.adicao(bufferAtual, adicao, polarizacao);
        exibirImagem(bufferedFiltro);
    }

    private void gamma() {
        Float gamma = sl_slide1.getValue() / 33.5f;
        BufferedImage bufferedFiltro = filtros.gamma(bufferAtual, gamma);
        exibirImagem(bufferedFiltro);
    }

    private void escalaCinza() {
        BufferedImage bufferedFiltro = filtros.escalaCinza(bufferAtual);
        exibirImagem(bufferedFiltro);
    }

    private void hsba() {
        Float cor;
        Float saturacao;
        Float brilho;
        if(sl_slide1.getValue() >= 50)
            cor = sl_slide1.getValue() / 100f;
        else 
            cor = sl_slide1.getValue() / -50f;
        if(sl_slide2.getValue() >= 50)
            saturacao = sl_slide2.getValue() / 100f;
        else
            saturacao = sl_slide2.getValue() / -50f;
        if(sl_slide3.getValue() >= 50)
            brilho = sl_slide3.getValue() / 100f;
        else
            brilho = sl_slide3.getValue() / -50f;
        BufferedImage bufferedFiltro = filtros.hsba(bufferAtual, cor, saturacao, brilho);
        exibirImagem(bufferedFiltro);
    }

    private void inverter() {
        BufferedImage bufferedFiltro = filtros.inverter(bufferAtual);
        exibirImagem(bufferedFiltro);
    }
    
    private void niveis() {
        Float nivelAlto = sl_slide1.getValue() / 100f;
        Float nivelBaixo = sl_slide2.getValue() / 100f;
        Float nivelSaidaAlto = sl_slide3.getValue() / 100f;
        Float nivelSaidaBaixo = sl_slide4.getValue() / 100f;
        BufferedImage bufferedFiltro = filtros.niveis(bufferAtual, nivelAlto, nivelBaixo, nivelSaidaAlto, nivelSaidaBaixo);
        exibirImagem(bufferedFiltro);
    }
    
    private void posterizar() {
        Integer niveis = sl_slide1.getValue();
        BufferedImage bufferedFiltro = filtros.posterizar(bufferAtual, niveis);
        exibirImagem(bufferedFiltro);
    }

    private void rescalar() {
        Float scala = sl_slide1.getValue() / 20f;
        BufferedImage bufferedFiltro = filtros.rescalar(bufferAtual, scala);
        exibirImagem(bufferedFiltro);
    }

    private void rgb() {
        Float r = sl_slide1.getValue() / 0.4f;
        Float g = sl_slide2.getValue() / 0.4f;
        Float b = sl_slide3.getValue() / 0.4f;
        BufferedImage bufferedFiltro = filtros.rgb(bufferAtual, r, g, b);
        exibirImagem(bufferedFiltro);
    }

    private void solarizar() {
        BufferedImage bufferedFiltro = filtros.solarizar(bufferAtual);
        exibirImagem(bufferedFiltro);
    }

    private void thresholding() {
        Integer altoThresholding = Math.round(sl_slide1.getValue() / 0.4f);
        Integer baixoThresholding = Math.round(sl_slide2.getValue() / 0.4f);
        BufferedImage bufferedFiltro = filtros.thresholding(bufferAtual, altoThresholding, baixoThresholding);
        exibirImagem(bufferedFiltro);
    }

    private void misturar() {
        Float scala = sl_slide1.getValue() * 1f;
        Integer borda = cb_combo1.getSelectedIndex();
        BufferedImage bufferedFiltro = filtros.misturar(bufferAtual, scala, borda);
        exibirImagem(bufferedFiltro);
    }

    private void vidro() {
        Integer qtde = sl_slide1.getValue();
        Integer borda = cb_combo1.getSelectedIndex();
        BufferedImage bufferedFiltro = filtros.vidro(bufferAtual, qtde, borda);
        exibirImagem(bufferedFiltro);
    }
    
    private void marmore() {
        Float scala = sl_slide1.getValue() * 1f;
        Float qtde = sl_slide2.getValue() * 1f;
        Float turbulencia = sl_slide3.getValue() * 1f;
        Integer borda = cb_combo1.getSelectedIndex();
        BufferedImage bufferedFiltro = filtros.marmore(bufferAtual, scala, qtde, turbulencia, borda);
        exibirImagem(bufferedFiltro);
    }

    private void cromar() {
        Float softness = sl_slide1.getValue() / 2f;
        Float altura = sl_slide2.getValue() / 20f;
        Float quantidade = sl_slide3.getValue() / 1f;
        Float exposicao = sl_slide4.getValue() / 1f;
        BufferedImage bufferedFiltro = filtros.cromar(bufferAtual, softness, altura, quantidade, exposicao);
        exibirImagem(bufferedFiltro);
    }
    
    private void relevo() {
        Float angulo = sl_slide1.getValue() / 100f;
        Float elevacao = sl_slide2.getValue() / 100f;
        Float intesidade = sl_slide3.getValue() / 100f;
        BufferedImage bufferedFiltro = filtros.relevo(bufferAtual, angulo, elevacao, intesidade);
        exibirImagem(bufferedFiltro);
    }
    
    private void sobel() {
        BufferedImage bufferedFiltro = filtros.sobel(bufferAtual);
        exibirImagem(bufferedFiltro);
    }
    
}
