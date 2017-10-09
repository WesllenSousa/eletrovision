package telas.pesquisas;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import telas.comuns.tablemodel.ModuloAcionamentoTableModel;
import entidades.dispositivo.bean.EnumDeletadoDispositivo;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.cadastros.CadastrarModuloAcionamento;
import telas.comuns.templates.Cadastro;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class PesquisarModuloAcionamento extends javax.swing.JPanel {

    public PesquisarModuloAcionamento() {
        initComponents();
        carregarTabela();
        InstanciasTelas.setPesquisarModuloAcionamento(PesquisarModuloAcionamento.this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_pesquisa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cb_chave = new javax.swing.JComboBox();
        tf_pesquisa = new javax.swing.JTextField();

        tb_pesquisa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tb_pesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_pesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tb_pesquisa.setFillsViewportHeight(true);
        tb_pesquisa.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tb_pesquisa);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chave.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chave.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Nome", "Marca", "IP", "Porta", "Saída" }));

        tf_pesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisa)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
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

private void tf_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaKeyReleased
    tf_pesquisa.setText(tf_pesquisa.getText().toUpperCase());
    pesquisaTabelaPorColuna(cb_chave.getSelectedIndex(), tf_pesquisa.getText());
}//GEN-LAST:event_tf_pesquisaKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_chave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_pesquisa;
    private javax.swing.JTextField tf_pesquisa;
    // End of variables declaration//GEN-END:variables

    public void excluir() {
        if (verificarLinhaSelecionada()) {
            int[] linhas = tb_pesquisa.getSelectedRows();
            if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.pesqComumExcluir())) {
                ModuloAcionamentoBean modulo = null;
                for (int i = 0; i < linhas.length; i++) {
                    modulo = (ModuloAcionamentoBean) tb_pesquisa.getValueAt(linhas[i], -1);
                    modulo = excluirModuloAcionamento(modulo);
                }
                InstanciasControle.getGerenciarAudio().exeDeletar();
                if (modulo != null) {
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.pesqModuloAcionamentoExcluir());
                }
                carregarTabela();
            }
        }
    }

    public void editar() {
        if (verificarLinhaSelecionada()) {
            Cadastro cadastro = new Cadastro();
            SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Editar Módulo", cadastro);
            InstanciasTelas.getPrincipal().esperarTelas();
            CadastrarModuloAcionamento modulo = new CadastrarModuloAcionamento();
            modulo.preencheCampos((ModuloAcionamentoBean) tb_pesquisa.getValueAt(tb_pesquisa.getSelectedRow(), -1));
            InstanciasTelas.getPrincipal().redimencionarPainelCadastro(modulo, cadastro);
            cadastro.pn_principal.add(modulo);
            cadastro.verificaInstancias(modulo);
        }
    }

    private void popularTabela(ArrayList<ModuloAcionamentoBean> lista) {
        ModuloAcionamentoTableModel modelo = new ModuloAcionamentoTableModel(lista);
        tb_pesquisa.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        tb_pesquisa.setRowSorter(sorter);
        definirTamanhoColunas();
        definirAlinhamentoColunas();
    }

    private void carregarTabela() {
        popularTabela(listarModuloAcionamentoOrdenadaPorCodigo());
    }

    ////////////////////////////////////////////////////////////////////////////
    private void definirTamanhoColunas() {
        tb_pesquisa.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_pesquisa.getColumnModel().getColumn(1).setPreferredWidth(250);
        tb_pesquisa.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb_pesquisa.getColumnModel().getColumn(3).setPreferredWidth(150);
        tb_pesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);
        tb_pesquisa.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void definirAlinhamentoColunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_pesquisa.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_pesquisa.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_pesquisa.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_pesquisa.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
        tb_pesquisa.getColumnModel().getColumn(4).setCellRenderer(rendererCentro);
        tb_pesquisa.getColumnModel().getColumn(5).setCellRenderer(rendererCentro);
    }

    private void pesquisaTabelaPorColuna(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_pesquisa.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private boolean verificarLinhaSelecionada() {
        int linhaSelecionada = tb_pesquisa.getSelectedRow();
        if (linhaSelecionada != -1) {
            return true;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.pesqModuloAcionamentoSelecionar());
            return false;
        }
    }

    public void atualizarTela() {
        carregarTabela();
    }
    
    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.pesquisas()+ArquivosHTML.moduloAcionamento());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoOrdenadaPorCodigo() {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return moduloAcionamentoFacade.listarModuloAcionamentoOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ModuloAcionamentoBean excluirModuloAcionamento(ModuloAcionamentoBean moduloAcionamento) {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            moduloAcionamento.setDeletado(EnumDeletadoDispositivo.SIM);
            return moduloAcionamentoFacade.alterar(moduloAcionamento);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
