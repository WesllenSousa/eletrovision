
package telas.relatorios;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
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
public class RelatorioAcionamento extends javax.swing.JPanel {
    
    private GeradorRelatorios geradorRelatorios;
    private AcionamentoFacade acionamentoFacade;
    private PredioFacade predioFacade;
    
    private Integer codigo;
    private EnumStatusAcionamento status;
    private EnumLigarDesligarAcionamento ligarDesligar;
    private EnumDeletadoAcionamento deletado;
    private EnumTipoAcionamento tipo;
    private PredioBean predio;
    
    public RelatorioAcionamento() {
        initComponents();
        instanciaClasses();
        
        preencherComboCenario();
        preencherComboPredio();
    }
    
    private void instanciaClasses(){
        if(geradorRelatorios == null) {
            geradorRelatorios = new GeradorRelatorios();
        }
        if(acionamentoFacade == null) {
            acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        }
        if(predioFacade == null) {
            predioFacade = FactoryFacade.getPredioImpl();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rd_cenario = new javax.swing.JRadioButton();
        rd_itensCenario = new javax.swing.JRadioButton();
        rd_cenarioCameras = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_cenario = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cb_status = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cb_situacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox();
        cb_predio = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_deletado = new javax.swing.JComboBox();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cenários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        rd_cenario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_cenario.setText("Cenário");

        rd_itensCenario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_itensCenario.setText("Itens do cenário");

        rd_cenarioCameras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_cenarioCameras.setText("Cenário agrupado por câmeras");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_cenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_itensCenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_cenarioCameras, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_cenario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_itensCenario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_cenarioCameras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções do cenários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cenário:");

        cb_cenario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Status:");

        cb_status.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Ativo", "Inativo" }));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Situação:");

        cb_situacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Ligado", "Desligado" }));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo:");

        cb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Nenhum acionamento", "Controle automático", "Detectar pessoas", "Reconhecer face", "Alarme" }));

        cb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Prédio:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Deletado?:");

        cb_deletado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_deletado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_predio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_cenario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_status, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_situacao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 168, Short.MAX_VALUE)
                    .addComponent(cb_deletado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_cenario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_predio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_deletado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cenario;
    private javax.swing.JComboBox cb_deletado;
    private javax.swing.JComboBox cb_predio;
    private javax.swing.JComboBox cb_situacao;
    private javax.swing.JComboBox cb_status;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_cenario;
    private javax.swing.JRadioButton rd_cenarioCameras;
    private javax.swing.JRadioButton rd_itensCenario;
    // End of variables declaration//GEN-END:variables

    private void preencherComboCenario() {
        cb_cenario.addItem("Todos os cenários");
        for(AcionamentoBean acionamento : listarAcionamentoOrdenadoPorNome()) {
            cb_cenario.addItem(acionamento);
        }
    }
    
    private void preencherComboPredio() {
        cb_predio.addItem("Todos os prédios");
        for(PredioBean predio_ : listarPredioNaoDeletado()) {
            cb_predio.addItem(predio_);  
        }
    }
    
    private void verificaOpcoes() {
        codigo = null; status = null; ligarDesligar = null; deletado = null;
        predio = null; tipo = null;
        if(cb_cenario.getSelectedIndex() != 0) {
            codigo = ((AcionamentoBean)cb_cenario.getSelectedItem()).getCodigo();
        }
        if(cb_status.getSelectedIndex() != 0) {
            if(cb_status.getSelectedIndex() == 1) {
                status = EnumStatusAcionamento.ATIVO;
            } else if(cb_status.getSelectedIndex() == 2) {
                status = EnumStatusAcionamento.INATIVO;
            }
        }
        if(cb_situacao.getSelectedIndex() != 0) {
            if(cb_situacao.getSelectedIndex() == 1) {
                ligarDesligar = EnumLigarDesligarAcionamento.LIGADO;
            } else if(cb_situacao.getSelectedIndex() == 2) {
                ligarDesligar = EnumLigarDesligarAcionamento.DESLIGADO;
            }
        }
        if(cb_tipo.getSelectedIndex() != 0) {
            if(cb_tipo.getSelectedIndex() == 1) {
                tipo = EnumTipoAcionamento.NENHUM_ACIONAMENTO;
            } else if(cb_tipo.getSelectedIndex() == 2) {
                tipo = EnumTipoAcionamento.CONTROLE_AUTOMATICO;
            } else if(cb_tipo.getSelectedIndex() == 3) {
                tipo = EnumTipoAcionamento.DETECTAR_PESSOAS;
            } else if(cb_tipo.getSelectedIndex() == 4) {
                tipo = EnumTipoAcionamento.RECONHECER_FACES;
            } else if(cb_tipo.getSelectedIndex() == 5) {
                tipo = EnumTipoAcionamento.ALARME;
            }
        }
        if(cb_predio.getSelectedIndex() != 0) {
            predio = (PredioBean) cb_predio.getSelectedItem();
        }
        if(cb_deletado.getSelectedIndex() == 0) {
            deletado = EnumDeletadoAcionamento.NAO;
        } else if(cb_deletado.getSelectedIndex() == 1) {
            deletado = EnumDeletadoAcionamento.SIM;
        }
    }
    
    public void exibir(){
        if(rd_cenario.isSelected()) {
            verificaOpcoes();
                geradorRelatorios.gerarRelatorioAcionamento(listarAcionamentoCriteria(
                        codigo, status, ligarDesligar, deletado, tipo, predio), "Relatório de Cenários");
        } else if(rd_itensCenario.isSelected()) {
            
        } else if(rd_cenarioCameras.isSelected()) {
            
        }
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorNome() {
        try {
            return acionamentoFacade.listarAcionamentoOrdenadoPorNome();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<PredioBean> listarPredioNaoDeletado() {
        try {
            return predioFacade.listarPredioNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<AcionamentoBean> listarAcionamentoCriteria(Integer codigo, EnumStatusAcionamento status, 
            EnumLigarDesligarAcionamento ligarDesligar, EnumDeletadoAcionamento deletado, EnumTipoAcionamento tipo,
            PredioBean predio) {
        try {
            return acionamentoFacade.listarAcionamentoCriteria(codigo, status, ligarDesligar, deletado, tipo, predio);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
