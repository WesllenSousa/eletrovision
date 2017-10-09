
package telas;

import controle.redes.dependencias.ConstantesRedes;
import java.util.ArrayList;
import recursos.InstanciasPortatil;
import telas.dependencias.EsperarCirculo;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfiguracaoCamera extends javax.swing.JDialog {
    
    private EsperarCirculo carregamento;
    private Integer codigo;
    
    public ConfiguracaoCamera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        tf_codigo.setVisible(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_tipoProcessamento = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        ck_movimento = new javax.swing.JCheckBox();
        ck_face = new javax.swing.JCheckBox();
        ck_olhos = new javax.swing.JCheckBox();
        ck_corpo = new javax.swing.JCheckBox();
        ck_objeto = new javax.swing.JCheckBox();
        ck_gravar = new javax.swing.JCheckBox();
        ck_dispositivos = new javax.swing.JCheckBox();
        ck_campanhia = new javax.swing.JCheckBox();
        rd_adaptarAmbiente = new javax.swing.JRadioButton();
        rd_mudancaAmbiente = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        ck_ambienteStatico = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        ck_reconhecerFace = new javax.swing.JCheckBox();
        tf_codigo = new javax.swing.JTextField();
        ck_ativar = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuração da câmera");
        setResizable(false);

        bt_fechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_salvar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_fechar, bt_salvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_fechar)
                    .addComponent(bt_salvar))
                .addContainerGap())
        );

        ck_movimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_movimento.setText("Detectar movimento");

        ck_face.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_face.setText("Detectar face");

        ck_olhos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_olhos.setText("Detectar olhos");

        ck_corpo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_corpo.setText("Detectar corpo");

        ck_objeto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_objeto.setText("Detectar objeto");

        ck_gravar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_gravar.setText("Gravar");

        ck_dispositivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dispositivos.setText("Acionar dispositivos");

        ck_campanhia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_campanhia.setText("Campanhia");

        grupo_tipoProcessamento.add(rd_adaptarAmbiente);
        rd_adaptarAmbiente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_adaptarAmbiente.setText("Adaptar ao ambiente");

        grupo_tipoProcessamento.add(rd_mudancaAmbiente);
        rd_mudancaAmbiente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_mudancaAmbiente.setText("Detectar mudança no ambiente");

        ck_ambienteStatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ambienteStatico.setText("Ambiente stático");

        ck_reconhecerFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_reconhecerFace.setText("Reconhecer Face");

        tf_codigo.setEditable(false);

        ck_ativar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ativar.setText("Ativar");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_face, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_movimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_adaptarAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(ck_reconhecerFace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ck_ativar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_mudancaAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_ambienteStatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_objeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_dispositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_campanhia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_gravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_olhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_corpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_ativar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rd_adaptarAmbiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_mudancaAmbiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_movimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_ambienteStatico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_objeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dispositivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_campanhia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_gravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_face)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_olhos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_corpo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_reconhecerFace)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-277)/2, (screenSize.height-498)/2, 277, 498);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if(InstanciasPortatil.getMensagens().confirmacao("Confirma a configuração de processamento da câmera?")) {
            salvar();
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JCheckBox ck_ambienteStatico;
    private javax.swing.JCheckBox ck_ativar;
    private javax.swing.JCheckBox ck_campanhia;
    private javax.swing.JCheckBox ck_corpo;
    private javax.swing.JCheckBox ck_dispositivos;
    private javax.swing.JCheckBox ck_face;
    private javax.swing.JCheckBox ck_gravar;
    private javax.swing.JCheckBox ck_movimento;
    private javax.swing.JCheckBox ck_objeto;
    private javax.swing.JCheckBox ck_olhos;
    private javax.swing.JCheckBox ck_reconhecerFace;
    private javax.swing.ButtonGroup grupo_tipoProcessamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton rd_adaptarAmbiente;
    private javax.swing.JRadioButton rd_mudancaAmbiente;
    private javax.swing.JTextField tf_codigo;
    // End of variables declaration//GEN-END:variables

    public void preencheCampos(ArrayList<String> configCamera) {
        if(configCamera.get(0).equals("0")) {
            ck_ativar.setSelected(true);
        } else {
            ck_ativar.setSelected(false);
        }
        if(configCamera.get(1).equals("0")) {
            rd_adaptarAmbiente.setSelected(true);
        } else {
            rd_mudancaAmbiente.setSelected(true);
        }
        if(configCamera.get(2).equals("1")) {
            ck_movimento.setSelected(true);
        } else {
            ck_movimento.setSelected(false);
        }
        if(configCamera.get(3).equals("1")) {
            ck_ambienteStatico.setSelected(true);
        } else {
            ck_ambienteStatico.setSelected(false);
        }
        if(configCamera.get(4).equals("1")) {
            ck_objeto.setSelected(true);
        } else {
            ck_objeto.setSelected(false);
        }
        if(configCamera.get(5).equals("1")) {
            ck_dispositivos.setSelected(true);
        } else {
            ck_dispositivos.setSelected(false);
        }
        if(configCamera.get(6).equals("1")) {
            ck_campanhia.setSelected(true);
        } else {
            ck_campanhia.setSelected(false);
        }
        if(configCamera.get(7).equals("1")) {
            ck_gravar.setSelected(true);
        } else {
            ck_gravar.setSelected(false);
        }
        if(configCamera.get(8).equals("1")) {
            ck_face.setSelected(true);
        } else {
            ck_face.setSelected(false);
        }
        if(configCamera.get(9).equals("1")) {
            ck_olhos.setSelected(true);
        } else {
            ck_olhos.setSelected(false);
        }
        if(configCamera.get(10).equals("1")) {
            ck_corpo.setSelected(true);
        } else {
            ck_corpo.setSelected(false);
        }
        if(configCamera.get(11).equals("1")) {
            ck_reconhecerFace.setSelected(true);
        } else {
            ck_reconhecerFace.setSelected(false);
        }
    }
     
    private ArrayList<String> populaConfigCameraBean() {
        ArrayList<String> configCamera = new ArrayList<>();
        
        if(ck_ativar.isSelected()) {
            configCamera.add(0, "1");
        } else {
            configCamera.add(0, "0");
        }
        if(rd_adaptarAmbiente.isSelected()) {
            configCamera.add(1, "0");
        } else {
            configCamera.add(1, "1");
        }
        if(ck_movimento.isSelected()) {
            configCamera.add(2, "0");
        } else {
            configCamera.add(2, "1");
        }
        if(ck_ambienteStatico.isSelected()) {
            configCamera.add(3, "0");
        } else {
            configCamera.add(3, "1");
        }
        if(ck_objeto.isSelected()) {
            configCamera.add(4, "0");
        } else {
            configCamera.add(4, "1");
        }
        if(ck_dispositivos.isSelected()) {
            configCamera.add(5, "0");
        } else {
            configCamera.add(5, "1");
        }
        if(ck_campanhia.isSelected()) {
            configCamera.add(6, "0");
        } else {
            configCamera.add(6, "1");
        }
        if(ck_gravar.isSelected()) {
            configCamera.add(7, "0");
        } else {
            configCamera.add(7, "1");
        }
        if(ck_face.isSelected()) {
            configCamera.add(8, "0");
        } else {
            configCamera.add(8, "1");
        }
        if(ck_olhos.isSelected()) {
            configCamera.add(9, "0");
        } else {
            configCamera.add(9, "1");
        }
        if(ck_corpo.isSelected()) {
            configCamera.add(10, "0");
        } else {
            configCamera.add(10, "1");
        }
        if(ck_reconhecerFace.isSelected()) {
            configCamera.add(11, "0");
        } else {
            configCamera.add(11, "1");
        }
        return configCamera;
    }
    
    private void salvar() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_CAMERA_SALVAR);
            InstanciasPortatil.getCliente().enviarDados(codigo);
            InstanciasPortatil.getCliente().enviarDados(populaConfigCameraBean());
        }
    }  
    
    private void esperar() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                carregamento = new EsperarCirculo(null, true);
                carregamento.setVisible(true);
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public void confirmacao() {
        carregamento.dispose();
        InstanciasPortatil.getMensagens().sucesso("Configurações alteradas com sucesso!");
        dispose();
    }
    
}
