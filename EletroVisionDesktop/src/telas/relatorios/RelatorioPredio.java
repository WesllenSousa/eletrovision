package telas.relatorios;

import entidades.predio.bean.EnumDeletadoPredio;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import entidades.predio.facade.PredioFacade;
import java.util.ArrayList;
import telas.relatorios.dependencias.GeradorRelatorios;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelatorioPredio extends javax.swing.JPanel {

    private PredioFacade predioFacade;
    private GeradorRelatorios geradorRelatorios;
    
    private Integer codigo = null;
    private EnumTipoPredio tipo = null;
    private EnumDeletadoPredio deletado = null;

    public RelatorioPredio() {
        initComponents();
        instanciaClasses();
        preencheComboPredio();
    }

    private void instanciaClasses() {
        if (predioFacade == null) {
            predioFacade = FactoryFacade.getPredioImpl();
        }
        if (geradorRelatorios == null) {
            geradorRelatorios = new GeradorRelatorios();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoPredios = new javax.swing.ButtonGroup();
        grupoOpcaoPredios = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_todosPredios = new javax.swing.JRadioButton();
        rb_enderecoPredio = new javax.swing.JRadioButton();
        rb_areaPredio = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        cb_predio = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_tipoPredio = new javax.swing.JComboBox();
        rb_deletado = new javax.swing.JRadioButton();
        rb_naoDeletado = new javax.swing.JRadioButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prédios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        grupoPredios.add(rb_todosPredios);
        rb_todosPredios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_todosPredios.setSelected(true);
        rb_todosPredios.setText("Prédio");

        grupoPredios.add(rb_enderecoPredio);
        rb_enderecoPredio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_enderecoPredio.setText("Endereço do Predio");

        grupoPredios.add(rb_areaPredio);
        rb_areaPredio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_areaPredio.setText("Áreas do Prédio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_areaPredio)
                    .addComponent(rb_enderecoPredio)
                    .addComponent(rb_todosPredios)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_todosPredios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_enderecoPredio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_areaPredio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opção Prédios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Prédios:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Tipo :");

        cb_tipoPredio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Residencia ", "Comercio", "Industria" }));

        grupoOpcaoPredios.add(rb_deletado);
        rb_deletado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_deletado.setText("Deletado");

        grupoOpcaoPredios.add(rb_naoDeletado);
        rb_naoDeletado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_naoDeletado.setSelected(true);
        rb_naoDeletado.setText("Não Deletado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_predio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_tipoPredio, 0, 166, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addComponent(rb_deletado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_naoDeletado)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_predio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tipoPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_deletado)
                    .addComponent(rb_naoDeletado))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_predio;
    private javax.swing.JComboBox cb_tipoPredio;
    private javax.swing.ButtonGroup grupoOpcaoPredios;
    private javax.swing.ButtonGroup grupoPredios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_areaPredio;
    private javax.swing.JRadioButton rb_deletado;
    private javax.swing.JRadioButton rb_enderecoPredio;
    private javax.swing.JRadioButton rb_naoDeletado;
    private javax.swing.JRadioButton rb_todosPredios;
    // End of variables declaration//GEN-END:variables

    private void preencheComboPredio() {
        cb_predio.addItem("Todos");
        for (PredioBean predio : listarPredioOrdenadoPorCodigo()) {
            cb_predio.addItem(predio);
        }
    }

    private void verificaOpcoes() {
        codigo = null;
        tipo = null;
        deletado = null;

        if (cb_predio.getSelectedIndex() != 0) {
            codigo = ((PredioBean) cb_predio.getSelectedItem()).getCodigo();
        }

        if (cb_tipoPredio.getSelectedIndex() != 0) {

            if (cb_tipoPredio.getSelectedIndex() == 1) {
                tipo = EnumTipoPredio.RESIDENCIA;
            } else if (cb_tipoPredio.getSelectedIndex() == 2) {
                tipo = EnumTipoPredio.COMERCIO;
            } else if (cb_tipoPredio.getSelectedIndex() == 3) {
                tipo = EnumTipoPredio.INDUSTRIA;
            }

        }

        if (rb_deletado.isSelected()) {
            deletado = EnumDeletadoPredio.DELETADO;
        } else if (rb_naoDeletado.isSelected()) {
            deletado = EnumDeletadoPredio.NAO;
        }
    }

    public void exibir() {

        if (rb_todosPredios.isSelected()) {
            verificaOpcoes();
            geradorRelatorios.gerarRelatorioPredio(listarPredioCriteria(codigo, tipo, deletado), "Relatório de Prédios");
        } else if (rb_enderecoPredio.isSelected()) {
        } else if (rb_areaPredio.isSelected()) {
        }

    }

    private ArrayList<PredioBean> listarPredioOrdenadoPorCodigo() {
        try {
            return predioFacade.listarPredioOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<PredioBean> listarPredioCriteria(Integer cogigo, EnumTipoPredio tipo, EnumDeletadoPredio deletado) {
        try {
            return predioFacade.listarPredioCriteria(codigo, tipo, deletado);
        } catch (FacadeException ex) {
        }
        return null;
    }
}
