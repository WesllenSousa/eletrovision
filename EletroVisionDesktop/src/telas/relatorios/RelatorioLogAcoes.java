package telas.relatorios;

import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.logAcoes.facade.LogAcoesFacade;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import java.util.ArrayList;
import java.util.Calendar;
import telas.relatorios.dependencias.GeradorRelatorios;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelatorioLogAcoes extends javax.swing.JPanel {

    private LogAcoesFacade logAcoesFacade;
    private GeradorRelatorios geradorRelatorios;
    private PessoaFacade pessoaFacade;
    
    private Integer codigo = null;
    private EnumRedeLogAcoes rede = null;
    private Calendar dataInicio, dataFim;
    private PessoaBean pessoa = null;

    public RelatorioLogAcoes() {
        initComponents();
        instanciaClasses();
        
        preencheComboLogAcoes();
        preenchePessoas();
    }

    private void instanciaClasses() {

        if (logAcoesFacade == null) {
            logAcoesFacade = FactoryFacade.getLogAcoesImpl();
        }
        if (geradorRelatorios == null) {
            geradorRelatorios = new GeradorRelatorios();
        }

        if (pessoaFacade == null) {
            pessoaFacade = FactoryFacade.getPessoaImpl();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_logAcoesTodos = new javax.swing.JRadioButton();
        rb_logAcoesAcionamento = new javax.swing.JRadioButton();
        rb_logAcoesDipositivo = new javax.swing.JRadioButton();
        rb_logAcoesAgendamentos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_logAcoes = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_rede = new javax.swing.JComboBox();
        cb_resposnsavel = new javax.swing.JComboBox();
        tf_dataInicio = new net.sf.nachocalendar.components.DateField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_dataFim = new net.sf.nachocalendar.components.DateField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log de Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        rb_logAcoesTodos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_logAcoesTodos.setSelected(true);
        rb_logAcoesTodos.setText("Log de Ações");

        rb_logAcoesAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_logAcoesAcionamento.setText("Log de Ações de Acionamento");

        rb_logAcoesDipositivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_logAcoesDipositivo.setText("Log de Ações de Dispositivo Elétrico");

        rb_logAcoesAgendamentos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rb_logAcoesAgendamentos.setText("Log de Ações de Agendamentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_logAcoesTodos)
                    .addComponent(rb_logAcoesAcionamento)
                    .addComponent(rb_logAcoesDipositivo)
                    .addComponent(rb_logAcoesAgendamentos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(rb_logAcoesTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_logAcoesAcionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_logAcoesDipositivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_logAcoesAgendamentos)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Log de Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Log de Ações:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Rede:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Responsável:");

        cb_rede.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "Sim", "Não" }));

        tf_dataInicio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Entre:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("e");

        tf_dataFim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cb_logAcoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_rede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_resposnsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_logAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cb_rede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_resposnsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(289, 289, 289)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_logAcoes;
    private javax.swing.JComboBox cb_rede;
    private javax.swing.JComboBox cb_resposnsavel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_logAcoesAcionamento;
    private javax.swing.JRadioButton rb_logAcoesAgendamentos;
    private javax.swing.JRadioButton rb_logAcoesDipositivo;
    private javax.swing.JRadioButton rb_logAcoesTodos;
    private net.sf.nachocalendar.components.DateField tf_dataFim;
    private net.sf.nachocalendar.components.DateField tf_dataInicio;
    // End of variables declaration//GEN-END:variables

    private void preencheComboLogAcoes() {
        cb_logAcoes.addItem("todos");
        
        for(LogAcoesBean log : listarLogAcoesPorData()){
            cb_logAcoes.addItem(log);
        }
    }
    
    private void preenchePessoas() {
        cb_resposnsavel.addItem("todos");
        
        for(PessoaBean pessoabean : listarPessoaOrdenadaPorCodigo()){
            cb_resposnsavel.addItem(pessoabean);
        }
    }
     
    private void verificaOpcoes(){
        codigo = null; rede = null; dataFim = null; dataInicio = null;
        pessoa = null;
        
        if(cb_logAcoes.getSelectedIndex() != 0){
            codigo = ((LogAcoesBean)cb_logAcoes.getSelectedItem()).getCodigo();
        }
        
        if(cb_rede.getSelectedIndex() != 0){
            if(cb_rede.getSelectedIndex() == 1){
                rede = EnumRedeLogAcoes.SIM;
            } else if(cb_rede.getSelectedIndex() == 2){
                rede = EnumRedeLogAcoes.NAO;
            }
        }
        
        if(cb_resposnsavel.getSelectedIndex() != 0){
            pessoa = ((PessoaBean) cb_resposnsavel.getSelectedItem());
        }
    }
    
    public void exibir() {
        
        if (rb_logAcoesTodos.isSelected()){
            verificaOpcoes();
            geradorRelatorios.gerarRelatorioLogAcoes(listarLogAcoesCriteria(codigo,
                    rede, dataInicio, dataFim, pessoa),"Relatório de Log de Ações");
            
        } else if(rb_logAcoesAcionamento.isSelected()){
            
        } else if (rb_logAcoesDipositivo.isSelected()){
            
        } else if(rb_logAcoesAgendamentos.isSelected()){
            
        }
    }

    private ArrayList<LogAcoesBean> listarLogAcoesPorData() {
        try {
            return logAcoesFacade.listarlogAcoesOrdenadoPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo(){
        try {
            return pessoaFacade.listarPessoaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<LogAcoesBean> listarLogAcoesCriteria(Integer codigo,
            EnumRedeLogAcoes rede, Calendar dataInicio, Calendar dataFim,
            PessoaBean pessoa){
        try {
            return logAcoesFacade.listarLogAcoesCriteria(codigo, rede, dataInicio, dataFim, pessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
