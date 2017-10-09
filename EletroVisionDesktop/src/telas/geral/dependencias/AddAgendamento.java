
package telas.geral.dependencias;

import telas.comuns.tablemodel.AgendarTarefasTableModel;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import util.FacadeException;
import util.FactoryFacade;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AddAgendamento extends javax.swing.JDialog {
    
    private VincularAgendarTarefas vincularAgendarTarefas;
    
    public AddAgendamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        popularTabelaAgendamento(new ArrayList<AgendarTarefasBean>());
    }
    
    public AddAgendamento(java.awt.Frame parent, boolean modal, Object tela) {
        super(parent, modal);
        initComponents();

        verificaInstancias(tela);
        carregarTabelaAgendamento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cb_chave = new javax.swing.JComboBox();
        tf_pesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_agendamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Agendamento");
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
        bt_salvar.setText("Adicionar");
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

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chave.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chave.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Descrição", "Disparo", "Tipo", "Ação", "Status" }));

        tf_pesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisa)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_agendamento.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_agendamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tb_agendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_agendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_agendamento);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        setBounds((screenSize.width-456)/2, (screenSize.height-405)/2, 456, 405);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        adicionar();
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void tf_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaKeyReleased
        tf_pesquisa.setText(tf_pesquisa.getText().toUpperCase());
        pesquisaTabelaPorColunaAgendamento(cb_chave.getSelectedIndex(), tf_pesquisa.getText());
    }//GEN-LAST:event_tf_pesquisaKeyReleased

    private void tb_agendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_agendamentoMouseClicked
        if(evt.getClickCount() == 2) {
            adicionar();
        }
    }//GEN-LAST:event_tb_agendamentoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JComboBox cb_chave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_agendamento;
    private javax.swing.JTextField tf_pesquisa;
    // End of variables declaration//GEN-END:variables

    private void carregarTabelaAgendamento() {
        popularTabelaAgendamento(listarAgendarTarefasNaoDeletada());
    }

    private void popularTabelaAgendamento(ArrayList<AgendarTarefasBean> lista) {
        AgendarTarefasTableModel modelo = new AgendarTarefasTableModel(lista);
        tb_agendamento.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        tb_agendamento.setRowSorter(sorter);
        definirTamanhoColunasAgendamento();
        definirAlinhamentoColunasAgendamento();
    }
    
    private void definirTamanhoColunasAgendamento() {
        tb_agendamento.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_agendamento.getColumnModel().getColumn(1).setPreferredWidth(200);
        tb_agendamento.getColumnModel().getColumn(2).setPreferredWidth(200);
        tb_agendamento.getColumnModel().getColumn(3).setPreferredWidth(100);
        tb_agendamento.getColumnModel().getColumn(4).setPreferredWidth(150);
        tb_agendamento.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void definirAlinhamentoColunasAgendamento() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_agendamento.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_agendamento.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_agendamento.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_agendamento.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
        tb_agendamento.getColumnModel().getColumn(4).setCellRenderer(rendererEsquerda);
        tb_agendamento.getColumnModel().getColumn(5).setCellRenderer(rendererEsquerda);
    }
    
    private AgendarTarefasBean obtemAgendarTarefaSelecionado() {
        return (AgendarTarefasBean) tb_agendamento.getValueAt(tb_agendamento.getSelectedRow(), -1);
    }

    private void pesquisaTabelaPorColunaAgendamento(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_agendamento.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    } 
    
    private ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletada() {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.listarAgendarTarefasNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    } 
    
    private void verificaInstancias(Object tela) {
        if(tela instanceof VincularAgendarTarefas) {
            this.vincularAgendarTarefas = (VincularAgendarTarefas) tela;
        }
    }
    
    private boolean verificarLinhaSelecionada() {
        int linhaSelecionada = tb_agendamento.getSelectedRow();
        if (linhaSelecionada != -1) {
            return true;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.gerAgendSelecionarAgendamento());
            return false;
        }
    }

    private void adicionar() {
        if(verificarLinhaSelecionada()) {
            if(vincularAgendarTarefas != null) {
                vincularAgendarTarefas.adicionaAgendamento(obtemAgendarTarefaSelecionado());
            }
            dispose();
        }
    }

}
