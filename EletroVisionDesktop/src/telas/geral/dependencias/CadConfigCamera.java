package telas.geral.dependencias;

import entidades.configCamera.bean.ConfigCameraBean;
import entidades.configCamera.bean.EnumAmbienteStaticoConfigCamera;
import entidades.configCamera.bean.EnumCampanhiaConfigCamera;
import entidades.configCamera.bean.EnumCorpoConfigCamera;
import entidades.configCamera.bean.EnumDispositivoConfigCamera;
import entidades.configCamera.bean.EnumFaceConfigCamera;
import entidades.configCamera.bean.EnumGravarConfigCamera;
import entidades.configCamera.bean.EnumMovimentoConfigCamera;
import entidades.configCamera.bean.EnumObjetoConfigCamera;
import entidades.configCamera.bean.EnumOlhosConfigCamera;
import entidades.configCamera.bean.EnumReconhecerFaceConfigCamera;
import entidades.configCamera.bean.EnumTipoProcessamentoConfigCamera;
import entidades.configCamera.facade.ConfigCameraFacade;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class CadConfigCamera extends javax.swing.JDialog {

    private CadAgendarTarefas cadAgendarTarefas;

    public CadConfigCamera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tf_codigo.setVisible(false);
    }

    public CadConfigCamera(java.awt.Frame parent, boolean modal, Object tela) {
        super(parent, modal);
        initComponents();
        tf_codigo.setVisible(false);

        verificaInstancias(tela);
    }

    public CadConfigCamera(java.awt.Frame parent, boolean modal, Object tela, Integer codigo) {
        super(parent, modal);
        initComponents();
        tf_codigo.setVisible(false);

        tf_codigo.setText(codigo.toString());
        verificaInstancias(tela);
        preencheCampos(selecionar(codigo));
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
        ck_acionarDispositivos = new javax.swing.JCheckBox();
        ck_campanhia = new javax.swing.JCheckBox();
        rd_adaptarAmbiente = new javax.swing.JRadioButton();
        rd_mudancaAmbiente = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        ck_ambienteStatico = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        ck_reconhecerFace = new javax.swing.JCheckBox();
        tf_codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Agendamento de Tarefas");
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
                .addContainerGap(24, Short.MAX_VALUE)
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

        ck_acionarDispositivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_acionarDispositivos.setText("Acionar dispositivos");

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

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ck_ambienteStatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_adaptarAmbiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_corpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_olhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_face, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_objeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_mudancaAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_movimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_acionarDispositivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(ck_reconhecerFace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ck_campanhia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_gravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(ck_acionarDispositivos)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setBounds((screenSize.width-289)/2, (screenSize.height-476)/2, 289, 476);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.gerDispositivosConfiguracao())) {
            salvar();
        }
    }//GEN-LAST:event_bt_salvarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JCheckBox ck_acionarDispositivos;
    private javax.swing.JCheckBox ck_ambienteStatico;
    private javax.swing.JCheckBox ck_campanhia;
    private javax.swing.JCheckBox ck_corpo;
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
    private javax.swing.JRadioButton rd_adaptarAmbiente;
    private javax.swing.JRadioButton rd_mudancaAmbiente;
    private javax.swing.JTextField tf_codigo;
    // End of variables declaration//GEN-END:variables

    private void preencheCampos(ConfigCameraBean configCamera) {
        if (configCamera.getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE) {
            rd_adaptarAmbiente.setSelected(true);
        } else {
            rd_mudancaAmbiente.setSelected(true);
        }
        if (configCamera.getMovimento() == EnumMovimentoConfigCamera.SIM) {
            ck_movimento.setSelected(true);
        } else {
            ck_movimento.setSelected(false);
        }
        if (configCamera.getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
            ck_ambienteStatico.setSelected(true);
        } else {
            ck_ambienteStatico.setSelected(false);
        }
        if (configCamera.getGravar() == EnumGravarConfigCamera.SIM) {
            ck_gravar.setSelected(true);
        } else {
            ck_gravar.setSelected(false);
        }
        if (configCamera.getObjeto() == EnumObjetoConfigCamera.SIM) {
            ck_objeto.setSelected(true);
        } else {
            ck_objeto.setSelected(false);
        }
        if (configCamera.getDispositivo() == EnumDispositivoConfigCamera.SIM) {
            ck_acionarDispositivos.setSelected(true);
        } else {
            ck_acionarDispositivos.setSelected(false);
        }
        if (configCamera.getCampanhia() == EnumCampanhiaConfigCamera.SIM) {
            ck_campanhia.setSelected(true);
        } else {
            ck_campanhia.setSelected(false);
        }
        if (configCamera.getFace() == EnumFaceConfigCamera.SIM) {
            ck_face.setSelected(true);
        } else {
            ck_face.setSelected(false);
        }
        if (configCamera.getOlhos() == EnumOlhosConfigCamera.SIM) {
            ck_olhos.setSelected(true);
        } else {
            ck_olhos.setSelected(false);
        }
        if (configCamera.getCorpo() == EnumCorpoConfigCamera.SIM) {
            ck_corpo.setSelected(true);
        } else {
            ck_corpo.setSelected(false);
        }
        if (configCamera.getReconhecerFace() == EnumReconhecerFaceConfigCamera.SIM) {
            ck_reconhecerFace.setSelected(true);
        } else {
            ck_reconhecerFace.setSelected(false);
        }
    }

    private ConfigCameraBean populaConfigCameraBean() {
        ConfigCameraBean configCamera = new ConfigCameraBean();

        if (!tf_codigo.getText().equals("")) {
            configCamera.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        if (rd_adaptarAmbiente.isSelected()) {
            configCamera.setTipoProcessamento(EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE);
        } else {
            configCamera.setTipoProcessamento(EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO);
        }
        if (ck_movimento.isSelected()) {
            configCamera.setMovimento(EnumMovimentoConfigCamera.SIM);
        } else {
            configCamera.setMovimento(EnumMovimentoConfigCamera.NAO);
        }
        if (ck_ambienteStatico.isSelected()) {
            configCamera.setAmbienteStatico(EnumAmbienteStaticoConfigCamera.SIM);
        } else {
            configCamera.setAmbienteStatico(EnumAmbienteStaticoConfigCamera.NAO);
        }
        if (ck_objeto.isSelected()) {
            configCamera.setObjeto(EnumObjetoConfigCamera.SIM);
        } else {
            configCamera.setObjeto(EnumObjetoConfigCamera.NAO);
        }
        if (ck_acionarDispositivos.isSelected()) {
            configCamera.setDispositivo(EnumDispositivoConfigCamera.SIM);
        } else {
            configCamera.setDispositivo(EnumDispositivoConfigCamera.NAO);
        }
        if (ck_campanhia.isSelected()) {
            configCamera.setCampanhia(EnumCampanhiaConfigCamera.SIM);
        } else {
            configCamera.setCampanhia(EnumCampanhiaConfigCamera.NAO);
        }
        if (ck_gravar.isSelected()) {
            configCamera.setGravar(EnumGravarConfigCamera.SIM);
        } else {
            configCamera.setGravar(EnumGravarConfigCamera.NAO);
        }
        if (ck_face.isSelected()) {
            configCamera.setFace(EnumFaceConfigCamera.SIM);
        } else {
            configCamera.setFace(EnumFaceConfigCamera.NAO);
        }
        if (ck_olhos.isSelected()) {
            configCamera.setOlhos(EnumOlhosConfigCamera.SIM);
        } else {
            configCamera.setOlhos(EnumOlhosConfigCamera.NAO);
        }
        if (ck_corpo.isSelected()) {
            configCamera.setCorpo(EnumCorpoConfigCamera.SIM);
        } else {
            configCamera.setCorpo(EnumCorpoConfigCamera.NAO);
        }
        if (ck_reconhecerFace.isSelected()) {
            configCamera.setReconhecerFace(EnumReconhecerFaceConfigCamera.SIM);
        } else {
            configCamera.setReconhecerFace(EnumReconhecerFaceConfigCamera.NAO);
        }

        return configCamera;
    }

    private void salvar() {
        ConfigCameraBean c = insereOuAltera(populaConfigCameraBean());
        if (c != null) {
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerDispositivosConfiguracaoSalvar());
            verificaAtualizacoes(c);
            dispose();
        } else {
            //Ganbiarra devido o hibernate não alterar da primeiro vez. verificar!!!!
            salvar();
        }
    }

    private void verificaAtualizacoes(ConfigCameraBean configCamera) {
        if (cadAgendarTarefas != null) {
            if (tf_codigo.getText().equals("")) {
                cadAgendarTarefas.atualizaAcao(configCamera);
            }
        }
    }

    private void verificaInstancias(Object tela) {
        if (tela instanceof CadAgendarTarefas) {
            cadAgendarTarefas = (CadAgendarTarefas) tela;
        }
    }
    
    /*
     * BANCO DE DADOS
     */

    private ConfigCameraBean insereOuAltera(ConfigCameraBean configCamera) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            return configCameraFacade.insereOuAltera(configCamera);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ConfigCameraBean selecionar(Integer codigo) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            return configCameraFacade.selecionar(codigo);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
