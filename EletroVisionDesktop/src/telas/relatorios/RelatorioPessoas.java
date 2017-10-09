
package telas.relatorios;

import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import recursos.instancias.InstanciasControle;
import telas.relatorios.dependencias.GeradorRelatorios;
import util.DataUtil;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RelatorioPessoas extends javax.swing.JPanel {
    
    private PessoaFacade pessoaFacade;
    private GeradorRelatorios geradorRelatorios;
    
    private Integer codigo = null;
    private EnumTipoPessoa tipo = null;
    private EnumSituacaoPessoa situacao = null;
    
    public RelatorioPessoas() {
        initComponents();
        instanciaClasses();
        
        preencheComboPessoas();
    }
    
    private void instanciaClasses(){
        if(pessoaFacade == null) {
            pessoaFacade = FactoryFacade.getPessoaImpl();
        }
        if(geradorRelatorios == null) {
            geradorRelatorios = new GeradorRelatorios();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoPessoas = new javax.swing.ButtonGroup();
        grupoAtivo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rd_todasPessoas = new javax.swing.JRadioButton();
        rd_enderecoPessoas = new javax.swing.JRadioButton();
        rd_contatosPessoas = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        rd_aniversariantesMes = new javax.swing.JRadioButton();
        rd_acessos = new javax.swing.JRadioButton();
        rd_autorizacoesUsuario = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        cb_tipoPessoa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        rd_ativo = new javax.swing.JRadioButton();
        rd_inativo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        cb_pessoa = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_acessos = new javax.swing.JComboBox();
        tf_dataInicio = new net.sf.nachocalendar.components.DateField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_dataFim = new net.sf.nachocalendar.components.DateField();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatórios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        grupoPessoas.add(rd_todasPessoas);
        rd_todasPessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_todasPessoas.setText("Pessoa");

        grupoPessoas.add(rd_enderecoPessoas);
        rd_enderecoPessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_enderecoPessoas.setText("Endereço da Pessoa");

        grupoPessoas.add(rd_contatosPessoas);
        rd_contatosPessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_contatosPessoas.setText("Contato das Pessoa");

        grupoPessoas.add(rd_aniversariantesMes);
        rd_aniversariantesMes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_aniversariantesMes.setText("Aniversariantes do Mês");

        grupoPessoas.add(rd_acessos);
        rd_acessos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_acessos.setText("Acessos");

        grupoPessoas.add(rd_autorizacoesUsuario);
        rd_autorizacoesUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_autorizacoesUsuario.setText("Autorizações do Usuário");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_todasPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_enderecoPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_contatosPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rd_aniversariantesMes, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(rd_acessos, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(rd_autorizacoesUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_todasPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_enderecoPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_contatosPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_aniversariantesMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_acessos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_autorizacoesUsuario)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        cb_tipoPessoa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Dono", "Família", "Funcionário", "Vigia" }));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tipos:");

        grupoAtivo.add(rd_ativo);
        rd_ativo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_ativo.setText("Ativo");

        grupoAtivo.add(rd_inativo);
        rd_inativo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_inativo.setText("Inativo");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Pessoa:");

        cb_pessoa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_pessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rd_ativo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rd_inativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cb_tipoPessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_tipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_ativo)
                    .addComponent(rd_inativo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Acessos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Acessos:");

        cb_acessos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tf_dataInicio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Entre:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("e");

        tf_dataFim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jButton1.setText("Exemplo para pegar valor da data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_acessos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_acessos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tf_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Date data = (Date) tf_dataInicio.getValue();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        
        InstanciasControle.getMensagens().aviso(DataUtil.formataData(data));
        InstanciasControle.getMensagens().aviso(DataUtil.formataData(calendar));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_acessos;
    private javax.swing.JComboBox cb_pessoa;
    private javax.swing.JComboBox cb_tipoPessoa;
    private javax.swing.ButtonGroup grupoAtivo;
    private javax.swing.ButtonGroup grupoPessoas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rd_acessos;
    private javax.swing.JRadioButton rd_aniversariantesMes;
    private javax.swing.JRadioButton rd_ativo;
    private javax.swing.JRadioButton rd_autorizacoesUsuario;
    private javax.swing.JRadioButton rd_contatosPessoas;
    private javax.swing.JRadioButton rd_enderecoPessoas;
    private javax.swing.JRadioButton rd_inativo;
    private javax.swing.JRadioButton rd_todasPessoas;
    private net.sf.nachocalendar.components.DateField tf_dataFim;
    private net.sf.nachocalendar.components.DateField tf_dataInicio;
    // End of variables declaration//GEN-END:variables

    private void preencheComboPessoas() {
        cb_pessoa.addItem("Todas");
        for(PessoaBean pessoa : listarPessoaOrdenadaPorCodigo()) {
            cb_pessoa.addItem(pessoa);
        }
    }
    
    private void verificaOpcoes() {
        codigo = null; tipo = null; situacao = null;
        if(cb_pessoa.getSelectedIndex() != 0) {
            codigo = ((PessoaBean)cb_pessoa.getSelectedItem()).getCodigo();
        }
        if(cb_tipoPessoa.getSelectedIndex() != 0) {
            if(cb_tipoPessoa.getSelectedIndex() == 1) {
                tipo = EnumTipoPessoa.DONO;
            } else if(cb_tipoPessoa.getSelectedIndex() == 2) {
                tipo = EnumTipoPessoa.FAMILIA;
            } else if(cb_tipoPessoa.getSelectedIndex() == 3) {
                tipo = EnumTipoPessoa.FUNCIONARIO;
            } else if(cb_tipoPessoa.getSelectedIndex() == 4) {
                tipo = EnumTipoPessoa.VIGIA;
            }
        }
        if(rd_ativo.isSelected()) {
            situacao = EnumSituacaoPessoa.ATIVO;
        } else if(rd_inativo.isSelected()) {
            situacao = EnumSituacaoPessoa.INATIVO;
        }
    }
    
    public void exibir(){
        if(rd_todasPessoas.isSelected()) {
            verificaOpcoes();
            geradorRelatorios.gerarRelatorioPessoa(listarPessoasCriteria(codigo, tipo, situacao), 
                "Relatório de Pessoas");
        } else if(rd_enderecoPessoas.isSelected()) {
            
        } else if(rd_contatosPessoas.isSelected()) {
            
        } else if(rd_aniversariantesMes.isSelected()) {
            
        }
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo() {
        try {
            return pessoaFacade.listarPessoaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<PessoaBean> listarPessoasCriteria(Integer codigo, EnumTipoPessoa tipo, 
            EnumSituacaoPessoa situacao) {
        try {
            return pessoaFacade.listarPessoasCriteria(codigo, tipo, situacao);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
