package telas.geral.dependencias;

import telas.comuns.tablemodel.VinculoTableModel;
import controle.openCV_javaCV_Pro.processamento.RealizaOperacoes;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.geral.GeralMensagens;
import telas.principal.AtualizaTelas;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class VincularAgendarTarefas extends javax.swing.JDialog {

    private GeralMensagens geralMensagens;

    public VincularAgendarTarefas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        preencheComboVinculo();
        popularTabelaItem(new ArrayList<AgendarTarefasBean>());
    }

    public VincularAgendarTarefas(java.awt.Frame parent, boolean modal, Integer tipoVinculo, Object vinculo) {
        super(parent, modal);
        initComponents();

        preencheComboVinculo();
        popularTabelaItem(new ArrayList<AgendarTarefasBean>());
        cb_tipoVinculo.setSelectedIndex(tipoVinculo);
        if (vinculo != null) {
            verificaVinculo(vinculo);
        } else {
            if(tipoVinculo == 1) {
                cb_vinculo.addItem("<Nova mensagem>");
                cb_vinculo.setSelectedIndex(cb_vinculo.getItemCount()-1);
            }
        }
    }

    public VincularAgendarTarefas(java.awt.Frame parent, boolean modal, Integer tipoVinculo, Object vinculo,
            Object tela) {
        super(parent, modal);
        initComponents();

        preencheComboVinculo();
        popularTabelaItem(new ArrayList<AgendarTarefasBean>());
        cb_tipoVinculo.setSelectedIndex(tipoVinculo);
        if (vinculo != null) {
            verificaVinculo(vinculo);
        } else {
            if(tipoVinculo == 1) {
                cb_vinculo.addItem("<Nova mensagem>");
                cb_vinculo.setSelectedIndex(cb_vinculo.getItemCount()-1);
            }
        }
        verificarInstancias(tela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cb_vinculo = new javax.swing.JComboBox();
        bt_adicionar = new javax.swing.JButton();
        bt_remover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_agendamento = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cb_tipoVinculo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vincular Agendamentos");

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Vínculo:");

        cb_vinculo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_vinculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vinculoActionPerformed(evt);
            }
        });

        bt_adicionar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/adicionar_22x22.png"))); // NOI18N
        bt_adicionar.setToolTipText("Adicionar agendamento");
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });

        bt_remover.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        bt_remover.setToolTipText("Remover agendamento");
        bt_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tb_agendamento);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Tipo:");

        cb_tipoVinculo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipoVinculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escolha um tipo>", "Mensagem", "Cenário", "Câmera" }));
        cb_tipoVinculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipoVinculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_remover))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_tipoVinculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_vinculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cb_tipoVinculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_vinculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_adicionar)
                    .addComponent(bt_remover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        setBounds((screenSize.width-481)/2, (screenSize.height-547)/2, 481, 547);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        abrirTelaAdicionar();
    }//GEN-LAST:event_bt_adicionarActionPerformed

    private void bt_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerActionPerformed
        perguntarRemover();
    }//GEN-LAST:event_bt_removerActionPerformed

    private void cb_tipoVinculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipoVinculoActionPerformed
        if (cb_tipoVinculo.getSelectedIndex() > 0) {
            preencheComboVinculo();
            popularTabelaItem(new ArrayList<AgendarTarefasBean>());
        } else {
            popularTabelaItem(new ArrayList<AgendarTarefasBean>());
        }
        bt_adicionar.setEnabled(false);
        bt_remover.setEnabled(false);
    }//GEN-LAST:event_cb_tipoVinculoActionPerformed

    private void cb_vinculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vinculoActionPerformed
        if (cb_vinculo.getSelectedIndex() > 0) {
            carregaTabelaAgendamento();
            bt_adicionar.setEnabled(true);
            bt_remover.setEnabled(true);
        } else {
            bt_adicionar.setEnabled(false);
            bt_remover.setEnabled(false);
            popularTabelaItem(new ArrayList<AgendarTarefasBean>());
        }
    }//GEN-LAST:event_cb_vinculoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        confirmar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_remover;
    private javax.swing.JComboBox cb_tipoVinculo;
    private javax.swing.JComboBox cb_vinculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_agendamento;
    // End of variables declaration//GEN-END:variables

    private void preencheComboVinculo() {
        cb_vinculo.removeAllItems();
        cb_vinculo.addItem("<Escolha um vínculo>");
        if (cb_tipoVinculo.getSelectedIndex() == 1) {
            for (MensagemBean mensagem : listarMensagemManual()) {
                cb_vinculo.addItem(mensagem);
            }
        } else if (cb_tipoVinculo.getSelectedIndex() == 2) {
            for (AcionamentoBean acionamento : listarAcionamentoOrdenadoPorNome()) {
                cb_vinculo.addItem(acionamento);
            }
        } else if (cb_tipoVinculo.getSelectedIndex() == 3) {
            for (CameraBean camera : listarCameraOrdenadoPorNome()) {
                cb_vinculo.addItem(camera);
            }
        }
    }
    
    private void confirmar() {
        if (cb_tipoVinculo.getSelectedIndex() == 1) {
            atualizaMensagem();
        } else if (cb_tipoVinculo.getSelectedIndex() == 2) {
            atualizaAcionamento();
        } else if (cb_tipoVinculo.getSelectedIndex() == 3) {
            atualizaCamera();
        }
        AtualizaTelas.geralAgendarTarefas();
        dispose();
    }

    private void atualizaMensagem() {
        if(!cb_vinculo.getSelectedItem().equals("<Nova mensagem>")) { //Nova mensagem
            MensagemBean mensagem = (MensagemBean) cb_vinculo.getSelectedItem();
            mensagem.setAgendarTarefas(obtemListaAgendamentos());
            alterarMensagem(mensagem);
        }
        if (geralMensagens != null) {
            geralMensagens.atualizarAgendamento(obtemListaAgendamentos());
        }
    }

    private void atualizaAcionamento() {
        AcionamentoBean acionamento = (AcionamentoBean) cb_vinculo.getSelectedItem();
        acionamento.setAgendarTarefas(obtemListaAgendamentos());
        alterarAcionamento(acionamento);
    }

    private void atualizaCamera() {
        CameraBean camera = (CameraBean) cb_vinculo.getSelectedItem();
        camera.setAgendarTarefas(obtemListaAgendamentos());
        alterarCamera(camera);
    }

    private void verificarInstancias(Object tela) {
        if (tela instanceof GeralMensagens) {
            geralMensagens = (GeralMensagens) tela;
        }
    }

    private void verificaVinculo(Object vinculo) {
        if (vinculo instanceof AcionamentoBean) {
            AcionamentoBean acionamento = (AcionamentoBean) vinculo;
            selecionarVinculo(acionamento.toString());
        } else if (vinculo instanceof MensagemBean) {
            MensagemBean mensagem = (MensagemBean) vinculo;
            selecionarVinculo(mensagem.toString());
        } else if (vinculo instanceof CameraBean) {
            CameraBean camera = (CameraBean) vinculo;
            selecionarVinculo(camera.toString());
        }
    }

    private void selecionarVinculo(String bean) {
        String c;
        for (int i = 0; i < cb_vinculo.getItemCount(); i++) {
            if (i > 0) {
                c = (String) cb_vinculo.getItemAt(i).toString();
                if (c.toString().equals(bean.toString())) {
                    cb_vinculo.setSelectedIndex(i);
                }
            }
        }
    }

    private void abrirTelaAdicionar() {
        AddAgendamento dialog = new AddAgendamento(null, true, this);
        dialog.setVisible(true);
    }

    private void perguntarRemover() {
        if (verificarLinhaSelecionada()) {
            if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.gerAgendExcluirAgendamento())) {
                AgendarTarefasBean bean = (AgendarTarefasBean) tb_agendamento.getValueAt(tb_agendamento.getSelectedRow(), -1);
                ((VinculoTableModel) tb_agendamento.getModel()).removeLinha(bean);
                tb_agendamento.updateUI();
                tb_agendamento.clearSelection();
                remover(bean);
            }
        }
    }

    private void adicionar(AgendarTarefasBean bean) {
        if (cb_tipoVinculo.getSelectedIndex() == 1) {
            if(!cb_vinculo.getSelectedItem().equals("<Nova mensagem>")) {
                MensagemBean mensagem = (MensagemBean) cb_vinculo.getSelectedItem();
                mensagem.getAgendarTarefas().add(bean); 
                alterarMensagem(mensagem);
            }
        } else if (cb_tipoVinculo.getSelectedIndex() == 2) {
            AcionamentoBean acionamento = (AcionamentoBean) cb_vinculo.getSelectedItem();
            acionamento.getAgendarTarefas().add(bean);
            alterarAcionamento(acionamento);
        } else if (cb_tipoVinculo.getSelectedIndex() == 3) {
            CameraBean camera = (CameraBean) cb_vinculo.getSelectedItem();
            camera.getAgendarTarefas().add(bean);
            alterarCamera(camera);
        }
    }

    private void remover(AgendarTarefasBean bean) {
        if (cb_tipoVinculo.getSelectedIndex() == 1) {
            if(!cb_vinculo.getSelectedItem().equals("<Nova mensagem>")) { //Nova mensagem
                MensagemBean mensagem = (MensagemBean) cb_vinculo.getSelectedItem();
                for(AgendarTarefasBean beanMsg : mensagem.getAgendarTarefas()) {
                    if(bean.equals(beanMsg)) {
                        mensagem.getAgendarTarefas().remove(beanMsg);
                        break;
                    }
                }
                alterarMensagem(mensagem);
            }
        } else if (cb_tipoVinculo.getSelectedIndex() == 2) {
            AcionamentoBean acionamento = (AcionamentoBean) cb_vinculo.getSelectedItem();
            for(AgendarTarefasBean beanAcio : acionamento.getAgendarTarefas()) {
                if(bean.equals(beanAcio)) {
                    acionamento.getAgendarTarefas().remove(beanAcio);
                    break;
                }
            }
            alterarAcionamento(acionamento);
        } else if (cb_tipoVinculo.getSelectedIndex() == 3) {
            CameraBean camera = (CameraBean) cb_vinculo.getSelectedItem();
            for(AgendarTarefasBean beanCam : camera.getAgendarTarefas()) {
                if(bean.equals(beanCam)) {
                    camera.getAgendarTarefas().remove(beanCam);
                    break;
                }
            }
            alterarCamera(camera);
        }
    }

    /*
     * TABELA
     */
    private void carregaTabelaAgendamento() {
        Object vinculo = cb_vinculo.getSelectedItem();
        ArrayList<AgendarTarefasBean> lista = new ArrayList<>();
        if (vinculo instanceof AcionamentoBean) {
            AcionamentoBean acionamento = (AcionamentoBean) vinculo;
            for(AgendarTarefasBean a : acionamento.getAgendarTarefas()) {
                lista.add(a);
            } 
        } else if (vinculo instanceof MensagemBean) {
            MensagemBean mensagem = (MensagemBean) vinculo;
            for(AgendarTarefasBean a : mensagem.getAgendarTarefas()) {
                lista.add(a);
            } 
        } else if (vinculo instanceof CameraBean) {
            CameraBean camera = (CameraBean) vinculo;
            for(AgendarTarefasBean a : camera.getAgendarTarefas()) {
                lista.add(a);
            } 
        }
        popularTabelaItem(lista);
    }

    private void popularTabelaItem(ArrayList<AgendarTarefasBean> lista) {
        VinculoTableModel modelo = new VinculoTableModel(lista);
        tb_agendamento.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tb_agendamento.setRowSorter(sorter);
        definirTamanhoColunasItem();
        definirAlinhamentoColunasItem();
    }

    private void definirTamanhoColunasItem() {
        tb_agendamento.getColumnModel().getColumn(0).setPreferredWidth(50);
        tb_agendamento.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_agendamento.getColumnModel().getColumn(2).setPreferredWidth(150);
    }

    private void definirAlinhamentoColunasItem() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_agendamento.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_agendamento.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_agendamento.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
    }

    private ArrayList<AgendarTarefasBean> obtemListaAgendamentos() { 
        return ((VinculoTableModel) tb_agendamento.getModel()).getLinhas();
    }

    public void adicionaAgendamento(AgendarTarefasBean bean) {
        ((VinculoTableModel) tb_agendamento.getModel()).addLinha(bean);
        tb_agendamento.getSelectionModel().setSelectionInterval(tb_agendamento.getRowCount() - 1, tb_agendamento.getRowCount() - 1);
        tb_agendamento.updateUI();
        adicionar(bean);
    }

    private boolean verificarLinhaSelecionada() {
        int linhaSelecionada = tb_agendamento.getSelectedRow();
        if (linhaSelecionada != -1 && !obtemListaAgendamentos().isEmpty()) {
            return true;
        } else if (obtemListaAgendamentos().isEmpty()) {
            InstanciasControle.getMensagens().bug(MensagensSoltas.gerAgendTabelaVazia());
            return false;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.gerAgendSelecionarAgendamento());
            return false;
        }
    }

    /*
     * BANCO DADOS
     */
    
    private AcionamentoBean alterarAcionamento(AcionamentoBean acionamento) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.alterar(acionamento);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private MensagemBean alterarMensagem(MensagemBean mensagem) {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            return mensagemFacade.alterar(mensagem);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private CameraBean alterarCamera(CameraBean camera) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.alterar(camera);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<MensagemBean> listarMensagemManual() {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            return mensagemFacade.listarMensagensManual(RealizaOperacoes.ASSUNTO);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorNome() {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.listarAcionamentoOrdenadoPorNome();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<CameraBean> listarCameraOrdenadoPorNome() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraOrdenadaPorNome();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
