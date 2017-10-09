
package telas.geral.dependencias;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigGerais;
import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acaoAgendamento.bean.EnumTipoVinculoAcaoAgendamento;
import entidades.acaoAgendamento.facade.AcaoAgendamentoFacade;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.camera.bean.CameraBean;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.mensagem.bean.MensagemBean;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.geral.GeralAgendarTarefas;
import util.FacadeException;
import util.FactoryFacade;
import util.Validacao;
 
/**
 *
 * @author Wesllen Sousa Lima
 */
public class CadAgendarTarefas extends javax.swing.JDialog {
    
    private GeralAgendarTarefas geralAgendarTarefas;
    private ArrayList acionamento, camera, mensagem;
    private String disparoLegivel="",mes="", dia="", hora="", minuto="", segundo="", semana="";
    
    public CadAgendarTarefas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadAgendarTarefas(java.awt.Frame parent, boolean modal, Object tela) {
        super(parent, modal);
        initComponents();
     
        verificaInstancias(tela);
        preencheCombosTempo();
    }
    
    public CadAgendarTarefas(java.awt.Frame parent, boolean modal, GeralAgendarTarefas geralAgendarTarefas, AgendarTarefasBean bean) {
        super(parent, modal);
        initComponents();
     
        this.geralAgendarTarefas = geralAgendarTarefas;
        preencheCombosTempo();
        AgendarTarefasBean agendarTarefas = selecionar(bean.getCodigo());
        mensagem = new ArrayList();
        for(MensagemBean m : agendarTarefas.getMensagens()) {
            mensagem.add(m);
        }
        acionamento = new ArrayList();
        for(AcionamentoBean a : agendarTarefas.getAcionamentos()) {
            acionamento.add(a);
        }
        camera = new ArrayList();
        for(CameraBean c : agendarTarefas.getCameras()) {
            camera.add(c);
        }
        preencheCampos(agendarTarefas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_contatos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_descricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_mes = new javax.swing.JComboBox();
        cb_dia = new javax.swing.JComboBox();
        cb_hora = new javax.swing.JComboBox();
        cb_minuto = new javax.swing.JComboBox();
        cb_segundo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cb_semana = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cb_acao = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_disparo = new javax.swing.JTextArea();
        bt_editar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Agendamento de Tarefas");
        setResizable(false);

        pn_contatos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Código:*");

        tf_codigo.setEditable(false);
        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Descrição:*");

        tf_descricao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Data:*");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Horário:*");

        cb_mes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês" }));
        cb_mes.setToolTipText("Mês");
        cb_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mesActionPerformed(evt);
            }
        });

        cb_dia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia" }));
        cb_dia.setToolTipText("Dia");
        cb_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_diaActionPerformed(evt);
            }
        });

        cb_hora.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_hora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hora" }));
        cb_hora.setToolTipText("Hora");
        cb_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_horaActionPerformed(evt);
            }
        });

        cb_minuto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_minuto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Minuto" }));
        cb_minuto.setToolTipText("Minuto");
        cb_minuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_minutoActionPerformed(evt);
            }
        });

        cb_segundo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_segundo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segundo" }));
        cb_segundo.setToolTipText("Segundo");
        cb_segundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_segundoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Semana:*");

        cb_semana.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_semana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os dias", "Segunda a Sexta", "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" }));
        cb_semana.setToolTipText("Semana");
        cb_semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_semanaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Tipo:*");

        cb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escolha o tipo>", "Mensagem", "Acionamento", "Câmera" }));
        cb_tipo.setToolTipText("Semana");
        cb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Ação:*");

        cb_acao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_acao.setToolTipText("Semana");
        cb_acao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_acaoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Disparo:*");

        ta_disparo.setEditable(false);
        ta_disparo.setColumns(20);
        ta_disparo.setLineWrap(true);
        ta_disparo.setRows(5);
        jScrollPane1.setViewportView(ta_disparo);

        bt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/pastaAberta_16x16.png"))); // NOI18N
        bt_editar.setToolTipText("Personalizar");
        bt_editar.setEnabled(false);
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_contatosLayout = new javax.swing.GroupLayout(pn_contatos);
        pn_contatos.setLayout(pn_contatosLayout);
        pn_contatosLayout.setHorizontalGroup(
            pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_contatosLayout.createSequentialGroup()
                        .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_contatosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_codigo)
                                    .addComponent(tf_descricao)))
                            .addGroup(pn_contatosLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pn_contatosLayout.createSequentialGroup()
                                        .addComponent(cb_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_minuto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_segundo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cb_semana, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pn_contatosLayout.createSequentialGroup()
                                        .addComponent(cb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pn_contatosLayout.createSequentialGroup()
                        .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_contatosLayout.createSequentialGroup()
                                .addComponent(cb_acao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        pn_contatosLayout.setVerticalGroup(
            pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cb_acao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_editar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_minuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_segundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_semana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_fechar)
                    .addComponent(bt_salvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_contatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_contatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        setBounds((screenSize.width-413)/2, (screenSize.height-488)/2, 413, 488);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvar();
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void cb_semanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_semanaActionPerformed
        if(cb_semana.getSelectedIndex() != 0) {
            cb_dia.setSelectedIndex(1);
        }
        if(cb_semana.getSelectedIndex() == 0) {
            semana = "Semana: todos dia da semana, ";
        } else {
            semana = "Semana: "+cb_semana.getSelectedItem()+"; ";
        }
        disparoLegivel = mes+dia+hora+minuto+segundo+semana;
        ta_disparo.setText(disparoLegivel);
    }//GEN-LAST:event_cb_semanaActionPerformed

    private void cb_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_horaActionPerformed
        cb_minuto.setSelectedIndex(2);
        cb_segundo.setSelectedIndex(2);
        if(cb_hora.getSelectedIndex() == 1) {
            hora = "Hora: toda hora, ";
        } else {
            hora = "Hora: "+cb_hora.getSelectedItem()+"; ";
        }
        disparoLegivel = mes+dia+hora+minuto+segundo+semana;
        ta_disparo.setText(disparoLegivel);
    }//GEN-LAST:event_cb_horaActionPerformed

    private void cb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipoActionPerformed
        if(cb_tipo.getSelectedIndex() > 0) {
            preencheComboAcao();
        }
    }//GEN-LAST:event_cb_tipoActionPerformed

    private void cb_acaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_acaoActionPerformed
        if(cb_tipo.getSelectedIndex() == 3 && cb_acao.getSelectedIndex() == 1) {
            cadastrarAcao();
        }
        if(cb_acao.getSelectedItem() != null) {
            if(cb_tipo.getSelectedIndex() == 3 && cb_acao.getSelectedItem().toString().substring(0, 6).equals("Person")) {
                bt_editar.setEnabled(true);
            } else {
                bt_editar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cb_acaoActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        editarAcao();
    }//GEN-LAST:event_bt_editarActionPerformed

    private void cb_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mesActionPerformed
        if(cb_mes.getSelectedIndex() == 1) {
            mes = "Mês: todo mês, ";
        } else {
            mes = "Mês: "+cb_mes.getSelectedItem()+"; ";
        }
        disparoLegivel = mes+dia+hora+minuto+segundo+semana;
        ta_disparo.setText(disparoLegivel);
    }//GEN-LAST:event_cb_mesActionPerformed

    private void cb_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_diaActionPerformed
         if(cb_dia.getSelectedIndex() == 1) {
            dia = "Dia: todo dia, ";
        } else {
            dia = "Dia: "+cb_dia.getSelectedItem()+"; ";
        }
         cb_semana.setSelectedIndex(0);
         disparoLegivel = mes+dia+hora+minuto+segundo+semana;
         ta_disparo.setText(disparoLegivel);
    }//GEN-LAST:event_cb_diaActionPerformed

    private void cb_minutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_minutoActionPerformed
        if(cb_minuto.getSelectedIndex() == 1) {
            minuto = "Minuto: todo minuto";
        } else {
            minuto = "Minuto: "+cb_minuto.getSelectedItem()+"; ";
        }
        disparoLegivel = mes+dia+hora+minuto+segundo+semana;
        ta_disparo.setText(disparoLegivel);
    }//GEN-LAST:event_cb_minutoActionPerformed

    private void cb_segundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_segundoActionPerformed
        if(cb_segundo.getSelectedIndex() == 1) {
            segundo = "Segundo: todo segundo";
        } else {
            segundo = "Segundo: "+cb_segundo.getSelectedItem()+"; ";
        }
        disparoLegivel = mes+dia+hora+minuto+segundo+semana;
        ta_disparo.setText(disparoLegivel);
    }//GEN-LAST:event_cb_segundoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JComboBox cb_acao;
    private javax.swing.JComboBox cb_dia;
    private javax.swing.JComboBox cb_hora;
    private javax.swing.JComboBox cb_mes;
    private javax.swing.JComboBox cb_minuto;
    private javax.swing.JComboBox cb_segundo;
    private javax.swing.JComboBox cb_semana;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pn_contatos;
    private javax.swing.JTextArea ta_disparo;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_descricao;
    // End of variables declaration//GEN-END:variables

    private void preencheCombosTempo() {
        cb_mes.addItem("Todos");
        for(int i = 1; i <= 12; i++) {
            cb_mes.addItem(i);
        }
        cb_dia.addItem("Todos");
        for(int i = 1; i <= 30; i++) {
            cb_dia.addItem(i);
        }
        cb_hora.addItem("Todas");
        for(int i = 0; i <= 23; i++) {
            cb_hora.addItem(i);
        }
        cb_minuto.addItem("Todos");
        for(int i = 0; i <= 59; i++) {
            cb_minuto.addItem(i);
        }
        cb_segundo.addItem("Todos");
        for(int i = 0; i <= 59; i++) {
            cb_segundo.addItem(i);
        }
    }
    
    private void preencheComboAcao() {
        cb_acao.removeAllItems();
        cb_acao.addItem("<Escolha uma ação>");
        if(cb_tipo.getSelectedIndex() == 3) {
            cb_acao.addItem("<Novo personalizado>");
        }
        for(AcaoAgendamentoBean acaoAgendamento : listarAcaoAgendamentoPorTipoVinculo()) { 
            cb_acao.addItem(acaoAgendamento); 
        }
    }
    
    private Boolean validaCampos() {
        if(Validacao.verificaStringVazia(tf_descricao.getText())) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendDescricao());
            return false;
        } else if(cb_tipo.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendTipo());
            return false;
        } else if(cb_acao.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendAcao());
            return false;
        } else if(cb_mes.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendMes());
            return false;
        } else if(cb_dia.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendDia());
            return false;
        } else if(cb_hora.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendHora());
            return false;
        } else if(cb_minuto.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendMinuto());
            return false;
        } else if(cb_segundo.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerAgendSegundo());
            return false;
        }
        return true;
    }
    
    private AgendarTarefasBean populaAgendarTarefasBean() {
        AgendarTarefasBean bean = new AgendarTarefasBean();
        
        if(!tf_codigo.getText().equals("")) {
            bean.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        bean.setDescricao(tf_descricao.getText().toUpperCase());
        bean.setDisparoLegivel(ta_disparo.getText());
        bean.setDisparo(montaDisparo());
        bean.setStatus(EnumStatusAgendarTarefas.ATIVO);
        bean.setDeletado(EnumDeletadoAgendarTarefas.NAO);
        if(cb_tipo.getSelectedIndex() == 1) {
            bean.setTipoVinculo(EnumTipoVinculoAgendarTarefas.MENSAGEM);
        } else if(cb_tipo.getSelectedIndex() == 2) {
            bean.setTipoVinculo(EnumTipoVinculoAgendarTarefas.ACIONAMENTO);
        } else if(cb_tipo.getSelectedIndex() == 3) {
            bean.setTipoVinculo(EnumTipoVinculoAgendarTarefas.CAMERA);
        }
        bean.setAcaoAgendamento((AcaoAgendamentoBean) cb_acao.getSelectedItem());
        if(geralAgendarTarefas != null) {
            bean.setAcionamentos(acionamento);
            bean.setMensagens(mensagem);
            bean.setCameras(camera);
        }
        
        return bean;
    }
    
    private AcaoAgendamentoBean populaAcaoAgendamentoBean(String acao) {
        AcaoAgendamentoBean acaoAgendamento = new AcaoAgendamentoBean();
        
        acaoAgendamento.setAcao(acao);
        acaoAgendamento.setTipoVinculo(EnumTipoVinculoAcaoAgendamento.CAMERA);
        
        return acaoAgendamento;
    }
    
    private void salvar() {
        if(validaCampos()) {
            if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.gerAgendConfirmacao())) {
                AgendarTarefasBean bean = salvarAgendarTarefas(populaAgendarTarefasBean());
                if(bean != null) {
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerAgendSalvar()); 
                    verificarAtualizacoes();
                    InstanciasControle.getShedulerAgendarTarefas().reiniciar();
                    InstanciasTelas.getPrincipal().lb_agendarTarefas.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_agendarAtivo())));
                    ConfigGerais.setAtivarAgendarTarefas(true);
                    dispose();
                }
            }
        }
    }
    
    private void verificarAtualizacoes() {
        if(geralAgendarTarefas != null) {
            geralAgendarTarefas.carregarTabelaAgendamento();
        }
    }
    
    private void preencheCampos(AgendarTarefasBean bean) {
        tf_codigo.setText(bean.getCodigo().toString());
        tf_descricao.setText(bean.getDescricao());  
        selecionaTipo(bean.getTipoVinculo());
        selecionaAcao(bean.getAcaoAgendamento());
        ta_disparo.setText(bean.getDisparoLegivel());
    }
    
    private void selecionaTipo(EnumTipoVinculoAgendarTarefas tipoVinculo) {
        for (int i = 0; i < cb_tipo.getItemCount(); i++) {
            if (i > 0) {
                if ((i-1) == tipoVinculo.getOrdem()) {
                    cb_tipo.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    private void selecionaAcao(AcaoAgendamentoBean bean) {
        AcaoAgendamentoBean c;
        for (int i = 0; i < cb_acao.getItemCount(); i++) {
            Integer j;
            if(cb_tipo.getSelectedIndex() == 3) {
                j = 1;
            } else {
                j = 0;
            }
            if (i > j) {
                c = (AcaoAgendamentoBean) cb_acao.getItemAt(i);
                if (c.toString().equals(bean.toString())) {
                    cb_acao.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    private void cadastrarAcao() {
        CadConfigCamera dialog = new CadConfigCamera(null, true, this);
        dialog.setVisible(true);
    }
    
    private void editarAcao() {
        CadConfigCamera dialog = new CadConfigCamera(null, true, this, reticaCodigoPersonalizado());
        dialog.setVisible(true);
    } 
    
    private Integer reticaCodigoPersonalizado() {
        String valor = cb_acao.getSelectedItem().toString();
        Integer codigo = 0, cont = 1;
        String c;
        do {
            c = valor.substring(valor.length()-cont, valor.length());
            if(Validacao.verificaNumeroInteger(c)) {
                codigo = Integer.parseInt(c);
            }
            cont++;
        } while(Validacao.verificaNumeroInteger(c));
        return codigo;
    }
    
    public void atualizaAcao(ConfigCameraBean configCamera) {
        AcaoAgendamentoBean acao = populaAcaoAgendamentoBean(configCamera.getCodigo().toString());
        if(insereOuAlteraAcaoAgendamento(acao) != null) {
            preencheComboAcao();
            selecionaAcao(acao);
        }
    }
    
    private void verificaInstancias(Object tela) {
        if(tela instanceof GeralAgendarTarefas) {
            this.geralAgendarTarefas = (GeralAgendarTarefas) tela;
        }
    }

    private String montaDisparo() {
        Boolean interrogacao = false;
        String segundo = "";
        if(cb_segundo.getSelectedIndex() == 1) {
            segundo = "* ";
        } else {
            segundo = cb_segundo.getSelectedItem()+" ";
        }
        String minuto = "";
        if(cb_minuto.getSelectedIndex() == 1) {
            minuto = "* ";
        } else {
            minuto = cb_minuto.getSelectedItem()+" ";
        }
        String hora = "";
        if(cb_hora.getSelectedIndex() == 1) {
            hora = "* ";
        } else {
            hora = cb_hora.getSelectedItem()+" ";
        }
        String diaMes = "";
        if(cb_dia.getSelectedIndex() == 1) {
            diaMes = "? ";
            interrogacao = true;
        } else {
            diaMes = cb_dia.getSelectedItem()+" ";
        }
        String mes = "";
        if(cb_mes.getSelectedIndex() == 1) {
            mes = "* ";
        } else {
            mes = cb_mes.getSelectedItem().toString()+" ";
        }
        String diaSemana = "";
        if(cb_semana.getSelectedIndex() == 0) {
            if(interrogacao) {
                diaSemana = "*";
            } else {
                diaSemana = "?";
            }
        } else if(cb_semana.getSelectedIndex() == 1) {
            diaSemana = "MON-FRI";
        } else {
            diaSemana = (cb_semana.getSelectedIndex()-1)+" ";
        }
        
        String disparo = segundo+minuto+hora+diaMes+mes+diaSemana;
        return disparo;
    }
      
    private ArrayList<AcaoAgendamentoBean> listarAcaoAgendamentoPorTipoVinculo() {
        AcaoAgendamentoFacade acaoAgendamentoFacade = FactoryFacade.getAcaoAgendamentoFacadeImpl();
        try {
            EnumTipoVinculoAcaoAgendamento enumtipo = null;
            if(cb_tipo.getSelectedIndex() == 1) {
                enumtipo = EnumTipoVinculoAcaoAgendamento.MENSAGEM;
            } else if(cb_tipo.getSelectedIndex() == 2) {
                enumtipo = EnumTipoVinculoAcaoAgendamento.ACIONAMENTO;
            } else if(cb_tipo.getSelectedIndex() == 3) {
                enumtipo = EnumTipoVinculoAcaoAgendamento.CAMERA;
            }
            return acaoAgendamentoFacade.listarAcaoAgendamentoPorTipoVinculo(enumtipo);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private AgendarTarefasBean selecionar(Integer codigo) {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.selecionarLazy(codigo);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private AgendarTarefasBean salvarAgendarTarefas(AgendarTarefasBean agendarTarefas) {
        AgendarTarefasFacade agendarTarefasFacade = FactoryFacade.getAgendarTarefasFacadeImpl();
        try {
            return agendarTarefasFacade.insereOuAltera(agendarTarefas);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private AcaoAgendamentoBean insereOuAlteraAcaoAgendamento(AcaoAgendamentoBean acaoAgendamento) {
        AcaoAgendamentoFacade acaoAgendamentoFacade = FactoryFacade.getAcaoAgendamentoFacadeImpl();
        try {
            return acaoAgendamentoFacade.insereOuAltera(acaoAgendamento);
        } catch (FacadeException ex) {
        }
        return null;
    }

}
