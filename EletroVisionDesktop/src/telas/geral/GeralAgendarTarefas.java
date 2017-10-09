
package telas.geral;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import telas.comuns.tablemodel.ItemAgendarTarefasTableModel;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.facade.AcionamentoFacade;
import telas.comuns.tablemodel.AgendarTarefasTableModel;
import telas.geral.dependencias.CadAgendarTarefas;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.geral.dependencias.*;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralAgendarTarefas extends javax.swing.JPanel {

    public GeralAgendarTarefas() {
        initComponents();
        InstanciasTelas.setGeralAgendarTarefas(GeralAgendarTarefas.this); 
        
        carregarTabelaAgendamento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_principal = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cb_chave = new javax.swing.JComboBox();
        tf_pesquisa = new javax.swing.JTextField();
        tb_pane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_agendarTarefas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_itens = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        bt_editar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        bt_desativar = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        bt_ajuda = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/logo.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/midia/calendario_128x128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_principal.setName("PainelPrincipal"); // NOI18N

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

        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tb_pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tb_paneStateChanged(evt);
            }
        });

        tb_agendarTarefas.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_agendarTarefas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tb_agendarTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_agendarTarefasMouseClicked(evt);
            }
        });
        tb_agendarTarefas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_agendarTarefasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_agendarTarefas);

        tb_pane.addTab("Agendamentos", jScrollPane1);

        tb_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_itens.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tb_itens);

        tb_pane.addTab("Itens", jScrollPane2);

        javax.swing.GroupLayout pn_principalLayout = new javax.swing.GroupLayout(pn_principal);
        pn_principal.setLayout(pn_principalLayout);
        pn_principalLayout.setHorizontalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tb_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        pn_principalLayout.setVerticalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_principalLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bt_editar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/editar_22x22.png"))); // NOI18N
        bt_editar.setText("Editar");
        bt_editar.setToolTipText("Salvar");
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        bt_excluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setToolTipText("Salvar");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        bt_novo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/novo_22x22.png"))); // NOI18N
        bt_novo.setText("Novo");
        bt_novo.setToolTipText("Salvar");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_desativar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_desativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/desativar_22x22.png"))); // NOI18N
        bt_desativar.setText("Desativar");
        bt_desativar.setToolTipText("Salvar");
        bt_desativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_desativarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_desativar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(bt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_editar)
                    .addComponent(bt_excluir)
                    .addComponent(bt_novo)
                    .addComponent(bt_desativar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(76, 158, 92));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bt_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ajuda_22x22.png"))); // NOI18N
        bt_ajuda.setToolTipText("Ajuda");
        bt_ajuda.setOpaque(false);
        bt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_ajuda, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        editar();
    }//GEN-LAST:event_bt_editarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        excluir();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        novo();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void tf_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaKeyReleased
        if(tb_pane.getSelectedIndex() == 0) {
            tf_pesquisa.setText(tf_pesquisa.getText().toUpperCase());
            pesquisaTabelaPorColunaAgendamento(cb_chave.getSelectedIndex(), tf_pesquisa.getText());
        } else if(tb_pane.getSelectedIndex() == 0) {
            tf_pesquisa.setText(tf_pesquisa.getText().toUpperCase());
            pesquisaTabelaPorColunaItem(cb_chave.getSelectedIndex(), tf_pesquisa.getText());
        }
    }//GEN-LAST:event_tf_pesquisaKeyReleased

    private void bt_desativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_desativarActionPerformed
        ativarDesativar();
    }//GEN-LAST:event_bt_desativarActionPerformed

    private void tb_agendarTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_agendarTarefasMouseClicked
        verificarAgendarTarefas();
    }//GEN-LAST:event_tb_agendarTarefasMouseClicked

    private void tb_agendarTarefasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_agendarTarefasKeyReleased
        verificarAgendarTarefas();
    }//GEN-LAST:event_tb_agendarTarefasKeyReleased

    private void tb_paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tb_paneStateChanged
        if(tb_pane.getSelectedIndex() == 0) {
            bt_desativar.setEnabled(true);
            bt_editar.setEnabled(true);
            bt_novo.setEnabled(true);
            cb_chave.setEnabled(true);
            tf_pesquisa.setEnabled(true); 
        } else if(tb_pane.getSelectedIndex() == 1) {
            if(verificarLinhaSelecionadaAgendarTarefas()) {
                carregarTabelaItem();
                bt_desativar.setEnabled(false);
                bt_editar.setEnabled(false);
                bt_novo.setEnabled(false);
                cb_chave.setEnabled(false);
                tf_pesquisa.setEnabled(false); 
            } else {
                tb_pane.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tb_paneStateChanged

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_desativar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JComboBox cb_chave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel pn_principal;
    private javax.swing.JTable tb_agendarTarefas;
    private javax.swing.JTable tb_itens;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_pesquisa;
    // End of variables declaration//GEN-END:variables

    private void novo() {
        tb_pane.setSelectedIndex(0);
        CadAgendarTarefas dialog = new CadAgendarTarefas(null, true, this);
        dialog.setVisible(true);
    }

    private void editar() {
        if(verificarLinhaSelecionadaAgendarTarefas()) {
            tb_pane.setSelectedIndex(0);
            CadAgendarTarefas dialog = new CadAgendarTarefas(null, true, this, obtemAgendarTarefaSelecionado());
            dialog.setVisible(true);
        }
    }

    private void excluir() {
        if(tb_pane.getSelectedIndex() == 0) {
            if(verificarLinhaSelecionadaAgendarTarefas() 
                    && InstanciasControle.getMensagens().confirmacao(MensagensSoltas.pesqComumExcluir())) {
                int[] linhas = tb_agendarTarefas.getSelectedRows();
                for (int i = 0; i < linhas.length; i++) {
                    AgendarTarefasBean bean = (AgendarTarefasBean) tb_agendarTarefas.getValueAt(linhas[i], -1);
                    for(AcionamentoBean acionamento : bean.getAcionamentos()) {
                        acionamento.setAgendarTarefas(null);
                        alterarAcionameto(acionamento);
                    }
                    for(MensagemBean mensagem : bean.getMensagens()) {
                        mensagem.setAgendarTarefas(null);
                        alterarMensagem(mensagem);
                    }
                    for(CameraBean camera : bean.getCameras()) {
                        camera.setAgendarTarefas(null);
                        alterarCamera(camera);
                    }
                    bean.setDeletado(EnumDeletadoAgendarTarefas.SIM);
                    alterarAgendarTarefas(bean);
                }
                carregarTabelaAgendamento();
            }
        } else if(tb_pane.getSelectedIndex() == 1) {
            if(verificarLinhaSelecionadaItens() 
                    && InstanciasControle.getMensagens().confirmacao(MensagensSoltas.pesqComumExcluir())) {
                int[] linhas = tb_itens.getSelectedRows();
                for (int i = 0; i < linhas.length; i++) {
                    ItemAgendarTarefas item = (ItemAgendarTarefas) tb_itens.getValueAt(linhas[i], -1);
                    if(item.getAcionamento() != null) {
                        item.getAcionamento().setAgendarTarefas(null);
                        alterarAcionameto(item.getAcionamento());
                    } else if(item.getMensagem() != null) {
                        item.getMensagem().setAgendarTarefas(null);
                        alterarMensagem(item.getMensagem());
                    } else if(item.getCamera() != null) {
                        item.getCamera().setAgendarTarefas(null);
                        alterarCamera(item.getCamera());
                    }
                    carregarTabelaAgendamento();
                    tb_pane.setSelectedIndex(0); 
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerAgendItemExcluido());
                }
            }
        }
    }
    
    private void ativarDesativar() {
        tb_pane.setSelectedIndex(0);
        if(verificarLinhaSelecionadaAgendarTarefas()) {
            if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.gerAgendAtivarDesativar(bt_desativar.getText()))) {
                AgendarTarefasBean bean = obtemAgendarTarefaSelecionado();
                switch (bt_desativar.getText()) {
                    case "Ativar":
                        bean.setStatus(EnumStatusAgendarTarefas.ATIVO);
                        break;
                    case "Desativar":
                        bean.setStatus(EnumStatusAgendarTarefas.INATIVO);
                        break;
                }
                alterarAgendarTarefas(bean);
                verificarAgendarTarefas();
            }
        }
    }
    
    private void verificarAgendarTarefas() {
        AgendarTarefasBean bean = obtemAgendarTarefaSelecionado();
        if(bean.getStatus() == EnumStatusAgendarTarefas.ATIVO) {
            bt_desativar.setText("Desativar");
        } else if(bean.getStatus() == EnumStatusAgendarTarefas.INATIVO) {
            bt_desativar.setText("Ativar");
        }   
    }
     
    private boolean verificarLinhaSelecionadaAgendarTarefas() {
        int linhaSelecionada = tb_agendarTarefas.getSelectedRow();
        if (linhaSelecionada != -1) {
            return true;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.gerAgendSelecionarAgendamento());
            return false;
        }
    }
    
    private boolean verificarLinhaSelecionadaItens() {
        int linhaSelecionada = tb_itens.getSelectedRow();
        if (linhaSelecionada != -1) {
            return true;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.gerAgendSelecionarItem());
            return false;
        }
    }
    
    /*   
     * TABELAS
     */
    
    public void carregarTabelaAgendamento() {
        popularTabelaAgendamento(listarAgendarTarefasNaoDeletado());
    }

    private void popularTabelaAgendamento(ArrayList<AgendarTarefasBean> lista) {
        AgendarTarefasTableModel modelo = new AgendarTarefasTableModel(lista);
        tb_agendarTarefas.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        tb_agendarTarefas.setRowSorter(sorter);
        definirTamanhoColunasAgendamento();
        definirAlinhamentoColunasAgendamento();
    }
    
    private void definirTamanhoColunasAgendamento() {
        tb_agendarTarefas.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_agendarTarefas.getColumnModel().getColumn(1).setPreferredWidth(200);
        tb_agendarTarefas.getColumnModel().getColumn(2).setPreferredWidth(200);
        tb_agendarTarefas.getColumnModel().getColumn(3).setPreferredWidth(100);
        tb_agendarTarefas.getColumnModel().getColumn(4).setPreferredWidth(150);
        tb_agendarTarefas.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void definirAlinhamentoColunasAgendamento() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_agendarTarefas.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_agendarTarefas.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_agendarTarefas.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_agendarTarefas.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
        tb_agendarTarefas.getColumnModel().getColumn(4).setCellRenderer(rendererEsquerda);
        tb_agendarTarefas.getColumnModel().getColumn(5).setCellRenderer(rendererEsquerda);
    }
    
    private AgendarTarefasBean obtemAgendarTarefaSelecionado() {
        return (AgendarTarefasBean) tb_agendarTarefas.getValueAt(tb_agendarTarefas.getSelectedRow(), -1);
    }

    private void pesquisaTabelaPorColunaAgendamento(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_agendarTarefas.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }  
    
    private void carregarTabelaItem() {
        ArrayList<ItemAgendarTarefas> itens = new ArrayList<>();
        AgendarTarefasBean bean = obtemAgendarTarefaSelecionado();
        for(AcionamentoBean acionamento : bean.getAcionamentos()) {
            ItemAgendarTarefas itemAgendarTarefas = new ItemAgendarTarefas();
            itemAgendarTarefas.setAgendarTarefas(bean);
            itemAgendarTarefas.setAcionamento(acionamento);
            itens.add(itemAgendarTarefas);
        }
        for(MensagemBean mensagem : bean.getMensagens()) {
            ItemAgendarTarefas itemAgendarTarefas = new ItemAgendarTarefas();
            itemAgendarTarefas.setAgendarTarefas(bean);
            itemAgendarTarefas.setMensagem(mensagem);
            itens.add(itemAgendarTarefas);
        }
        for(CameraBean camera : bean.getCameras()) {
            ItemAgendarTarefas itemAgendarTarefas = new ItemAgendarTarefas();
            itemAgendarTarefas.setAgendarTarefas(bean);
            itemAgendarTarefas.setCamera(camera);
            itens.add(itemAgendarTarefas);
        }
        popularTabelaItem(itens);
    }

    private void popularTabelaItem(ArrayList<ItemAgendarTarefas> lista) {
        ItemAgendarTarefasTableModel modelo = new ItemAgendarTarefasTableModel(lista);
        tb_itens.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tb_itens.setRowSorter(sorter);
        definirTamanhoColunasItem();
        definirAlinhamentoColunasItem();
    }
    
    private void definirTamanhoColunasItem() {
        tb_itens.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_itens.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void definirAlinhamentoColunasItem() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_itens.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_itens.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
    }

    private void pesquisaTabelaPorColunaItem(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_itens.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    public void atualizarTela() {
        carregarTabelaAgendamento();
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.agendarTarefas());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletado() {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.listarAgendarTarefasNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    } 
    
    private AgendarTarefasBean alterarAgendarTarefas(AgendarTarefasBean bean) {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.alterar(bean);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void alterarAcionameto(AcionamentoBean acionamento) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            acionamentoFacade.alterar(acionamento);
        } catch (FacadeException ex) {
        }
    }
    
    private void alterarMensagem(MensagemBean mensagem) {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            mensagemFacade.alterar(mensagem);
        } catch (FacadeException ex) {
        }
    }
    
    private void alterarCamera(CameraBean camera) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            cameraFacade.alterar(camera);
        } catch (FacadeException ex) {
        }
    }
    
}
