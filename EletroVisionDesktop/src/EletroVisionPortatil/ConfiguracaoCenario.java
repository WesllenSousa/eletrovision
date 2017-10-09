
package EletroVisionPortatil;

import EletroVisionPortatil.dependencias.InstanciasPortatil;
import recursos.constantes.ConstantesRedes;
import java.util.ArrayList;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.telas.EsperarCirculo;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfiguracaoCenario extends javax.swing.JDialog {
    
    private EsperarCirculo carregamento;
    private Integer codigo;
    
    public ConfiguracaoCenario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        ck_ativar = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        rd_controleAutomatico = new javax.swing.JRadioButton();
        rd_detectarPessoas = new javax.swing.JRadioButton();
        rd_reconhecerFace = new javax.swing.JRadioButton();
        rd_nenhumAcionamento = new javax.swing.JRadioButton();
        rd_alarme = new javax.swing.JRadioButton();
        rd_movimento = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuração do cenário");
        setResizable(false);

        bt_fechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_salvar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
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

        ck_ativar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ativar.setText("Ativar");

        grupoTipo.add(rd_controleAutomatico);
        rd_controleAutomatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_controleAutomatico.setText("Controle automático");

        grupoTipo.add(rd_detectarPessoas);
        rd_detectarPessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_detectarPessoas.setText("Detectar pessoas");

        grupoTipo.add(rd_reconhecerFace);
        rd_reconhecerFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_reconhecerFace.setText("Reconhecer face");

        grupoTipo.add(rd_nenhumAcionamento);
        rd_nenhumAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_nenhumAcionamento.setText("Nenhum Acionamento");

        grupoTipo.add(rd_alarme);
        rd_alarme.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_alarme.setText("Alarme");

        grupoTipo.add(rd_movimento);
        rd_movimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_movimento.setText("Movimento");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ck_ativar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rd_nenhumAcionamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_controleAutomatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_detectarPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_reconhecerFace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rd_alarme, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_movimento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ck_ativar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rd_nenhumAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_controleAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_detectarPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_reconhecerFace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_alarme, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_movimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setBounds((screenSize.width-277)/2, (screenSize.height-307)/2, 277, 307);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.portatilConfiguracaoCenario())) {
            salvar();
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JCheckBox ck_ativar;
    private javax.swing.ButtonGroup grupoTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rd_alarme;
    private javax.swing.JRadioButton rd_controleAutomatico;
    private javax.swing.JRadioButton rd_detectarPessoas;
    private javax.swing.JRadioButton rd_movimento;
    private javax.swing.JRadioButton rd_nenhumAcionamento;
    private javax.swing.JRadioButton rd_reconhecerFace;
    // End of variables declaration//GEN-END:variables

    public void preencheCampos(ArrayList<String> configCamera) {
        if(configCamera.get(0).equals("0")) {
            ck_ativar.setSelected(true);
        } else {
            ck_ativar.setSelected(false);
        }
        switch (configCamera.get(1)) {
            case "0":
                rd_nenhumAcionamento.setSelected(true);
                break;
            case "1":
                rd_controleAutomatico.setSelected(true);
                break;
            case "2":
                rd_detectarPessoas.setSelected(true);
                break;
            case "3":
                rd_reconhecerFace.setSelected(true);
                break;
            case "4":
                rd_alarme.setSelected(true);
                break;
            case "5":
                rd_movimento.setSelected(true);
                break;
        }
    }
     
    private ArrayList<String> populaConfigBean() {
        ArrayList<String> configCamera = new ArrayList<>();
        
        if(ck_ativar.isSelected()) {
            configCamera.add(0, "1");
        } else {
            configCamera.add(0, "0");
        }
        if(rd_nenhumAcionamento.isSelected()) {
            configCamera.add(1, "0");
        } else if(rd_controleAutomatico.isSelected()) {
            configCamera.add(1, "1");
        } else if(rd_detectarPessoas.isSelected()) {
            configCamera.add(1, "2");
        } else if(rd_reconhecerFace.isSelected()) {
            configCamera.add(1, "3");
        } else if(rd_alarme.isSelected()) {
            configCamera.add(1, "4");
        } else if(rd_movimento.isSelected()) {
            configCamera.add(1, "5");
        }
        
        return configCamera;
    }
    
    private void salvar() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_ACIONAMENTO_SALVAR);
            InstanciasPortatil.getCliente().enviarDados(codigo);
            InstanciasPortatil.getCliente().enviarDados(populaConfigBean());
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
        InstanciasPortatil.getMensagens().sucesso(MensagensSoltas.portatilConfiguracoesAlteradas());
        dispose();
    }
    
}
