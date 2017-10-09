
package telas.geral;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.acesso.bean.AcessoBean;
import entidades.acesso.facade.AcessoFacade;
import telas.comuns.tablemodel.MovimentoTableModel;
import telas.comuns.tablemodel.MensagemTableModel;
import telas.comuns.tablemodel.LogAcoesTableModel;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.logAcoes.facade.LogAcoesFacade;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.movimento.bean.MovimentoBean;
import entidades.movimento.facade.MovimentoFacade;
import java.io.File;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.ferramentas.FerramentasEditarImagens;
import telas.comuns.tablemodel.AcessoTableModel;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralLogAcoes extends javax.swing.JPanel {

    public GeralLogAcoes() {
        initComponents();

        carregarTabelaMovimento();
        carregarTabelaAcionamento();
        carregarTabelaMensagem();
        carregarTabelaDispositivoEletrico();
        carregarTabelaAgendarTarefas();
        carregarTabelaAcesso();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_principal = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_movimento = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        cb_chaveMovimento = new javax.swing.JComboBox();
        tf_pesquisaMovimento = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_acionamento = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        cb_chaveAcionamento = new javax.swing.JComboBox();
        tf_pesquisaAcionamento = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_mensagem = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        cb_chaveMensagem = new javax.swing.JComboBox();
        tf_pesquisaMensagem = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_dispositivoEletrico = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        cb_chaveDispositivoEletrico = new javax.swing.JComboBox();
        tf_pesquisaDispositivoEletrico = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_agendarTarefas = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        cb_chaveAgendarTarefas = new javax.swing.JComboBox();
        tf_pesquisaAgendarTarefas = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_acessos = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        cb_chaveAcesso = new javax.swing.JComboBox();
        tf_pesquisaAcesso = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        bt_ajuda = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/logo.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/midia/logAcoes_128x128.png"))); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_principal.setName("PainelPrincipal"); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tb_movimento.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_movimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tb_movimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_movimentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_movimento);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chaveMovimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chaveMovimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Data/Hora", "Diretório", "Qtde Pessoas", "Qtde Objetos", "Câmera" }));

        tf_pesquisaMovimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisaMovimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaMovimentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chaveMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisaMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chaveMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisaMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Ver Imagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Movimentos", jPanel1);

        tb_acionamento.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_acionamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tb_acionamento);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chaveAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chaveAcionamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Descrição", "Data/Hora", "Responsável", "Acionamento", "Rede" }));

        tf_pesquisaAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisaAcionamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaAcionamentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chaveAcionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisaAcionamento, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chaveAcionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisaAcionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cenários", jPanel4);

        tb_mensagem.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_mensagem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tb_mensagem);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chaveMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chaveMensagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Assunto", "Mensagem", "Destino", "Tipo", "Data/Hora", "Movimento" }));

        tf_pesquisaMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisaMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaMensagemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chaveMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisaMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chaveMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisaMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mensagens", jPanel5);

        tb_dispositivoEletrico.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_dispositivoEletrico.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tb_dispositivoEletrico);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chaveDispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chaveDispositivoEletrico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Descrição", "Data/Hora", "Responsável", "Acionamento", "Rede" }));

        tf_pesquisaDispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisaDispositivoEletrico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaDispositivoEletricoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chaveDispositivoEletrico, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisaDispositivoEletrico, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chaveDispositivoEletrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisaDispositivoEletrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dispositos Elétricos", jPanel9);

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
        jScrollPane5.setViewportView(tb_agendarTarefas);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chaveAgendarTarefas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chaveAgendarTarefas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Descrição", "Data/Hora", "Responsável", "Acionamento", "Rede" }));

        tf_pesquisaAgendarTarefas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisaAgendarTarefas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaAgendarTarefasKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chaveAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisaAgendarTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chaveAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisaAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agendar Tarefas", jPanel11);

        tb_acessos.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_acessos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane6.setViewportView(tb_acessos);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_chaveAcesso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_chaveAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Data/Hora Início", "Data/Hora Fim", "Usuário" }));

        tf_pesquisaAcesso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_pesquisaAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesquisaAcessoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_chaveAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisaAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chaveAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pesquisaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Acessos", jPanel3);

        javax.swing.GroupLayout pn_principalLayout = new javax.swing.GroupLayout(pn_principal);
        pn_principal.setLayout(pn_principalLayout);
        pn_principalLayout.setHorizontalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_principalLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        pn_principalLayout.setVerticalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_principalLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_pesquisaMovimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaMovimentoKeyReleased
        //tf_pesquisaMovimento.setText(tf_pesquisaMovimento.getText().toUpperCase());
        pesquisaTabelaPorColunaMovimento(cb_chaveMovimento.getSelectedIndex(), tf_pesquisaMovimento.getText());
    }//GEN-LAST:event_tf_pesquisaMovimentoKeyReleased

    private void tf_pesquisaAcionamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaAcionamentoKeyReleased
        //tf_pesquisaAcionamento.setText(tf_pesquisaAcionamento.getText().toUpperCase());
        pesquisaTabelaPorColunaAcionamento(cb_chaveAcionamento.getSelectedIndex(), tf_pesquisaAcionamento.getText());
    }//GEN-LAST:event_tf_pesquisaAcionamentoKeyReleased

    private void tf_pesquisaMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaMensagemKeyReleased
        //tf_pesquisaMensagem.setText(tf_pesquisaMensagem.getText().toUpperCase());
        pesquisaTabelaPorColunaMensagem(cb_chaveMensagem.getSelectedIndex(), tf_pesquisaMensagem.getText());
    }//GEN-LAST:event_tf_pesquisaMensagemKeyReleased

    private void tf_pesquisaDispositivoEletricoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaDispositivoEletricoKeyReleased
        //tf_pesquisaDispositivoEletrico.setText(tf_pesquisaDispositivoEletrico.getText().toUpperCase());
        pesquisaTabelaPorColunaDispositivoEletrico(cb_chaveDispositivoEletrico.getSelectedIndex(), tf_pesquisaDispositivoEletrico.getText());
    }//GEN-LAST:event_tf_pesquisaDispositivoEletricoKeyReleased

    private void tf_pesquisaAgendarTarefasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaAgendarTarefasKeyReleased
        //tf_pesquisaAgendarTarefas.setText(tf_pesquisaAgendarTarefas.getText().toUpperCase());
        pesquisaTabelaPorColunaAgendarTarefas(cb_chaveAgendarTarefas.getSelectedIndex(), tf_pesquisaAgendarTarefas.getText());
    }//GEN-LAST:event_tf_pesquisaAgendarTarefasKeyReleased

    private void tf_pesquisaAcessoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaAcessoKeyReleased
        //tf_pesquisaAcesso.setText(tf_pesquisaAcesso.getText().toUpperCase());
        pesquisaTabelaPorColunaAcesso(cb_chaveAcesso.getSelectedIndex(), tf_pesquisaAcesso.getText());
    }//GEN-LAST:event_tf_pesquisaAcessoKeyReleased

    private void tb_movimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_movimentoMouseClicked
        int coluna = tb_movimento.getSelectedColumn();
        if(coluna == 2) {
            visualizarImagemMovimento();
        }
    }//GEN-LAST:event_tb_movimentoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        visualizarImagemMovimento();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JComboBox cb_chaveAcesso;
    private javax.swing.JComboBox cb_chaveAcionamento;
    private javax.swing.JComboBox cb_chaveAgendarTarefas;
    private javax.swing.JComboBox cb_chaveDispositivoEletrico;
    private javax.swing.JComboBox cb_chaveMensagem;
    private javax.swing.JComboBox cb_chaveMovimento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JPanel pn_principal;
    private javax.swing.JTable tb_acessos;
    private javax.swing.JTable tb_acionamento;
    private javax.swing.JTable tb_agendarTarefas;
    private javax.swing.JTable tb_dispositivoEletrico;
    private javax.swing.JTable tb_mensagem;
    private javax.swing.JTable tb_movimento;
    private javax.swing.JTextField tf_pesquisaAcesso;
    private javax.swing.JTextField tf_pesquisaAcionamento;
    private javax.swing.JTextField tf_pesquisaAgendarTarefas;
    private javax.swing.JTextField tf_pesquisaDispositivoEletrico;
    private javax.swing.JTextField tf_pesquisaMensagem;
    private javax.swing.JTextField tf_pesquisaMovimento;
    // End of variables declaration//GEN-END:variables
 
    private void visualizarImagemMovimento() {
        if(verificarLinhaSelecionadaMovimento()) {
            MovimentoBean movimento = obtemMovimento();
            FerramentasEditarImagens painel = new FerramentasEditarImagens();
            painel.exibirImagem(ImagemUtil.ler(ArquivosImagens.diretorio_processamento()+File.separator+movimento.getDiretorio()));
            SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Editar Imagens", painel);
        }
    }
    
    private boolean verificarLinhaSelecionadaMovimento() {
        int linhaSelecionada = tb_movimento.getSelectedRow();
        if (linhaSelecionada != -1) {
            return true;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.gerLogSelecionarMovimento());
            return false;
        }
    }
    
    /*  
     * TABELAS
     */
    
    private void carregarTabelaMovimento() {
        popularTabelaMovimento(listarMovimentoOrdenadoPorData());
    }

    private void popularTabelaMovimento(ArrayList<MovimentoBean> lista) {
        MovimentoTableModel modelo = new MovimentoTableModel(lista);
        tb_movimento.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        sorter.setComparator(1, SwingUtil.getComparadorDate());
        sorter.setComparator(3, SwingUtil.getComparadorInteger());
        sorter.setComparator(4, SwingUtil.getComparadorInteger());
        tb_movimento.setRowSorter(sorter);
        definirTamanhoColunasMovimento();
        definirAlinhamentoColunasMovimento();
    }
    
    private void definirTamanhoColunasMovimento() {
        tb_movimento.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_movimento.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_movimento.getColumnModel().getColumn(2).setPreferredWidth(250);
        tb_movimento.getColumnModel().getColumn(3).setPreferredWidth(100);
        tb_movimento.getColumnModel().getColumn(4).setPreferredWidth(100);
        tb_movimento.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void definirAlinhamentoColunasMovimento() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_movimento.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_movimento.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_movimento.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_movimento.getColumnModel().getColumn(3).setCellRenderer(rendererCentro);
        tb_movimento.getColumnModel().getColumn(4).setCellRenderer(rendererCentro);
        tb_movimento.getColumnModel().getColumn(5).setCellRenderer(rendererEsquerda);
    }
    
    private MovimentoBean obtemMovimento() {
        return (MovimentoBean) tb_movimento.getValueAt( tb_movimento.getSelectedRow(), -1);
    }

    private void pesquisaTabelaPorColunaMovimento(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_movimento.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    private ArrayList<MovimentoBean> listarMovimentoOrdenadoPorData() {
        MovimentoFacade movimentoFacade = FactoryFacade.getMovimentoImpl();
        try {
            return movimentoFacade.listarMovimentoOrdenadoPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
       
    private void carregarTabelaAcionamento() {
        popularTabelaAcionamento(listarLogAcoesAcionamentoOrdenadoPorData());
    }

    private void popularTabelaAcionamento(ArrayList<LogAcoesBean> lista) {
        LogAcoesTableModel modelo = new LogAcoesTableModel(lista);
        tb_acionamento.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        sorter.setComparator(2, SwingUtil.getComparadorDate());
        tb_acionamento.setRowSorter(sorter);
        definirTamanhoColunasAcionamento();
        definirAlinhamentoColunasAcionamento();
    }
    
    private void definirTamanhoColunasAcionamento() {
        tb_acionamento.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_acionamento.getColumnModel().getColumn(1).setPreferredWidth(250);
        tb_acionamento.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb_acionamento.getColumnModel().getColumn(3).setPreferredWidth(200);
        tb_acionamento.getColumnModel().getColumn(4).setPreferredWidth(150);
        tb_acionamento.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void definirAlinhamentoColunasAcionamento() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_acionamento.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_acionamento.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_acionamento.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_acionamento.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
        tb_acionamento.getColumnModel().getColumn(4).setCellRenderer(rendererEsquerda);
        tb_acionamento.getColumnModel().getColumn(5).setCellRenderer(rendererCentro);
    }

    private void pesquisaTabelaPorColunaAcionamento(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_acionamento.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    private ArrayList<LogAcoesBean> listarLogAcoesAcionamentoOrdenadoPorData() {
        LogAcoesFacade logAcoesFacade = FactoryFacade.getLogAcoesImpl();
        try {
            return logAcoesFacade.listarlogAcoesAcionamentoOrdenadoPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void carregarTabelaDispositivoEletrico() {
        popularTabelaDispositivoEletrico(listarlogAcoesDispositivoEletricoOrdenadoPorData());
    }
    
    private void popularTabelaDispositivoEletrico(ArrayList<LogAcoesBean> lista) {
        LogAcoesTableModel modelo = new LogAcoesTableModel(lista);
        tb_dispositivoEletrico.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        sorter.setComparator(2, SwingUtil.getComparadorDate());
        tb_dispositivoEletrico.setRowSorter(sorter);
        definirTamanhoColunasDispositivoEletrico();
        definirAlinhamentoColunasDispositivoEletrico();
    }
    
    private void definirTamanhoColunasDispositivoEletrico() {
        tb_dispositivoEletrico.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_dispositivoEletrico.getColumnModel().getColumn(1).setPreferredWidth(250);
        tb_dispositivoEletrico.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb_dispositivoEletrico.getColumnModel().getColumn(3).setPreferredWidth(150);
        tb_dispositivoEletrico.getColumnModel().getColumn(4).setPreferredWidth(150);
        tb_dispositivoEletrico.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void definirAlinhamentoColunasDispositivoEletrico() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_dispositivoEletrico.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_dispositivoEletrico.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_dispositivoEletrico.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_dispositivoEletrico.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
        tb_dispositivoEletrico.getColumnModel().getColumn(4).setCellRenderer(rendererEsquerda);
        tb_dispositivoEletrico.getColumnModel().getColumn(5).setCellRenderer(rendererCentro);
    }

    private void pesquisaTabelaPorColunaDispositivoEletrico(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_dispositivoEletrico.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    } 
    
    private ArrayList<LogAcoesBean> listarlogAcoesDispositivoEletricoOrdenadoPorData() {
        LogAcoesFacade logAcoesFacade = FactoryFacade.getLogAcoesImpl();
        try {
            return logAcoesFacade.listarlogAcoesDispositivoEletricoOrdenadoPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void carregarTabelaAgendarTarefas() {
        popularTabelaAgendarTarefas(listarlogAcoesAgendarTarefasOrdenadoPorData());
    }
    
    private void popularTabelaAgendarTarefas(ArrayList<LogAcoesBean> lista) {
        LogAcoesTableModel modelo = new LogAcoesTableModel(lista);
        tb_agendarTarefas.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        sorter.setComparator(2, SwingUtil.getComparadorDate());
        tb_agendarTarefas.setRowSorter(sorter);
        definirTamanhoColunasAgendarTarefas();
        definirAlinhamentoColunasAgendarTarefas();
    }
    
    private void definirTamanhoColunasAgendarTarefas() {
        tb_agendarTarefas.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_agendarTarefas.getColumnModel().getColumn(1).setPreferredWidth(250);
        tb_agendarTarefas.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb_agendarTarefas.getColumnModel().getColumn(3).setPreferredWidth(200);
        tb_agendarTarefas.getColumnModel().getColumn(4).setPreferredWidth(200);
        tb_agendarTarefas.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void definirAlinhamentoColunasAgendarTarefas() {
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
        tb_agendarTarefas.getColumnModel().getColumn(5).setCellRenderer(rendererCentro);
    }

    private void pesquisaTabelaPorColunaAgendarTarefas(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_agendarTarefas.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    } 
    
    private ArrayList<LogAcoesBean> listarlogAcoesAgendarTarefasOrdenadoPorData() {
        LogAcoesFacade logAcoesFacade = FactoryFacade.getLogAcoesImpl();
        try {
            return logAcoesFacade.listarlogAcoesAgendarTarefasOrdenadoPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void carregarTabelaMensagem() {
        popularTabelaMensagem(listarMensagemOrdenadaPorData());
    }

    private void popularTabelaMensagem(ArrayList<MensagemBean> lista) {
        MensagemTableModel modelo = new MensagemTableModel(lista);
        tb_mensagem.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        tb_mensagem.setRowSorter(sorter);
        definirTamanhoColunasMensagem();
        definirAlinhamentoColunasMensagem();
    }
    
    private void definirTamanhoColunasMensagem() {
        tb_mensagem.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_mensagem.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_mensagem.getColumnModel().getColumn(2).setPreferredWidth(250);
        tb_mensagem.getColumnModel().getColumn(3).setPreferredWidth(200);
        tb_mensagem.getColumnModel().getColumn(4).setPreferredWidth(80);
        tb_mensagem.getColumnModel().getColumn(5).setPreferredWidth(150);
        tb_mensagem.getColumnModel().getColumn(6).setPreferredWidth(250);
    }

    private void definirAlinhamentoColunasMensagem() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_mensagem.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_mensagem.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_mensagem.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_mensagem.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
        tb_mensagem.getColumnModel().getColumn(4).setCellRenderer(rendererCentro);
        tb_mensagem.getColumnModel().getColumn(5).setCellRenderer(rendererEsquerda);
        tb_mensagem.getColumnModel().getColumn(6).setCellRenderer(rendererEsquerda);
    }

    private void pesquisaTabelaPorColunaMensagem(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_mensagem.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    private ArrayList<MensagemBean> listarMensagemOrdenadaPorData() {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            return mensagemFacade.listarMensagemOrdenadaPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void carregarTabelaAcesso() {
        popularTabelaAcesso(listarAcessoOrdenadoPorData());
    }

    private void popularTabelaAcesso(ArrayList<AcessoBean> lista) {
        AcessoTableModel modelo = new AcessoTableModel(lista);
        tb_acessos.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        sorter.setComparator(0, SwingUtil.getComparadorInteger());
        tb_acessos.setRowSorter(sorter);
        definirTamanhoColunasAcesso();
        definirAlinhamentoColunasAcesso();
    }
    
    private void definirTamanhoColunasAcesso() {
        tb_acessos.getColumnModel().getColumn(0).setPreferredWidth(70);
        tb_acessos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_acessos.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb_acessos.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void definirAlinhamentoColunasAcesso() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_acessos.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tb_acessos.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_acessos.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_acessos.getColumnModel().getColumn(3).setCellRenderer(rendererEsquerda);
    }

    private void pesquisaTabelaPorColunaAcesso(int col, String chave) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tb_acessos.getRowSorter();
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(chave, col);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    private ArrayList<AcessoBean> listarAcessoOrdenadoPorData() {
        AcessoFacade acessoFacade = FactoryFacade.getAcessoFacadeImpl();
        try {
            return acessoFacade.listarAcessosOrdenadoPorData();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.logAcoes());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
}
