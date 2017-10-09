
package telas.relatorios;

import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
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
public class RelatorioMensagens extends javax.swing.JPanel {
    
    private MensagemFacade mensagemFacade;
    private PessoaFacade pessoaFacade;
    private GeradorRelatorios geradorRelatorios;
    
    private Integer codigo;
    private EnumTipoMensagem tipo;
    private EnumExibirMensagem exibir;
    private EnumLeituraMensagem leitura;
    private Calendar dataInicio, dataFim;
    private PessoaBean origem, destino;
    
    public RelatorioMensagens() {
        initComponents();
        instanciaClasses();
        
        preencheComboPessoas();
        preencheComboMensagem();
    }
    
    private void instanciaClasses(){
        if(mensagemFacade == null) {
            mensagemFacade = FactoryFacade.getMensagemImpl();
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rd_mensagem = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        cb_tipoMensagem = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_mensagem = new javax.swing.JComboBox();
        cb_exibicao = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cb_leitura = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_dataInicio = new net.sf.nachocalendar.components.DateField();
        tf_dataFim = new net.sf.nachocalendar.components.DateField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_origem = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cb_destino = new javax.swing.JComboBox();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatórios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        rd_mensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_mensagem.setSelected(true);
        rd_mensagem.setText("Mensagem");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_mensagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções Mensagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        cb_tipoMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipoMensagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Email", "Celular", "Local" }));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tipo:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mensagem:");

        cb_mensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cb_exibicao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_exibicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Ao iniciar o sistema", "Ao finalizar o sistema" }));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Exibição:");

        cb_leitura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_leitura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Lido", "Não Lido" }));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Leitura:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Entre:");

        tf_dataInicio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tf_dataFim.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("e");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Origem:");

        cb_origem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Destino:");

        cb_destino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_leitura, 0, 151, Short.MAX_VALUE)
                                    .addComponent(cb_tipoMensagem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_exibicao, 0, 1, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_mensagem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tf_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_origem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_destino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_tipoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_exibicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_leitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_origem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_destino;
    private javax.swing.JComboBox cb_exibicao;
    private javax.swing.JComboBox cb_leitura;
    private javax.swing.JComboBox cb_mensagem;
    private javax.swing.JComboBox cb_origem;
    private javax.swing.JComboBox cb_tipoMensagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_mensagem;
    private net.sf.nachocalendar.components.DateField tf_dataFim;
    private net.sf.nachocalendar.components.DateField tf_dataInicio;
    // End of variables declaration//GEN-END:variables

    private void preencheComboPessoas() {
        cb_origem.addItem("Todas");
        cb_origem.addItem("Sistema");
        cb_destino.addItem("Todas");
        cb_destino.addItem("Sistema");
        for(PessoaBean pessoa : listarPessoaOrdenadaPorCodigo()) {
            cb_origem.addItem(pessoa);
            cb_destino.addItem(pessoa); 
        }
    }
    
    private void preencheComboMensagem() {
        cb_mensagem.addItem("Todas");
        for(MensagemBean mensagem : listarMensagemOrdenadaPorCodigo()) {
            cb_mensagem.addItem(mensagem);
        }
    }
    
    private void verificaOpcoes() {
        codigo = null; tipo = null; exibir = null; leitura = null; dataInicio = null;
        dataFim = null; origem = null; destino= null;
        if(cb_mensagem.getSelectedIndex() != 0) {
            codigo = ((MensagemBean)cb_mensagem.getSelectedItem()).getCodigo();
        }
        if(cb_tipoMensagem.getSelectedIndex() != 0) {
            if(cb_tipoMensagem.getSelectedIndex() == 1) {
                tipo = EnumTipoMensagem.EMAIL;
            } else if(cb_tipoMensagem.getSelectedIndex() == 2) {
                tipo = EnumTipoMensagem.CELULAR;
            } else if(cb_tipoMensagem.getSelectedIndex() == 3) {
                tipo = EnumTipoMensagem.LOCAL;
                cb_exibicao.setEnabled(true);
            }
        }
        if(cb_exibicao.getSelectedIndex() != 0) {
            if(cb_exibicao.getSelectedIndex() == 1 ){
                exibir = EnumExibirMensagem.INICIAR_SISTEMA;
            } else if(cb_exibicao.getSelectedIndex() == 2 ){
                exibir = EnumExibirMensagem.SAIR_SISTEMA;
            }
        }
        
        if(cb_leitura.getSelectedIndex() != 0){
            if(cb_leitura.getSelectedIndex() == 1 ){
                leitura = EnumLeituraMensagem.SIM;
            } else if(cb_leitura.getSelectedIndex() == 2 ){
                leitura = EnumLeituraMensagem.NAO;
            }
                    
        }
        
        if(cb_origem.getSelectedIndex() != 0){
            origem = (PessoaBean) cb_origem.getSelectedItem();
        }
        
        if(cb_destino.getSelectedIndex() != 0){
            destino = (PessoaBean) cb_destino.getSelectedItem();
        }
    }
    
    public void exibir(){
        if(rd_mensagem.isSelected()) {
            verificaOpcoes();
            geradorRelatorios.gerarRelatorioMensagem(listarMensagensCriteria(codigo, 
                    tipo, exibir, leitura, dataInicio, dataFim, origem, destino), "Relatório de Mensagens");
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
    
    private ArrayList<MensagemBean> listarMensagemOrdenadaPorCodigo() {
        try {
            return mensagemFacade.listarMensagemOrdenadaPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<MensagemBean> listarMensagensCriteria(Integer codigo, EnumTipoMensagem tipo, 
                EnumExibirMensagem exibir, EnumLeituraMensagem leitura, Calendar dataInicio, Calendar dataFim, 
                PessoaBean origem, PessoaBean destino) {
        try {
            return mensagemFacade.listarMensagemCriteria(codigo, tipo, exibir, leitura, 
                    dataInicio, dataFim, origem, destino);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
