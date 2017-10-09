
package telas.geral;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import controle.mensagens.celular.Celular;
import controle.mensagens.email.EnviarEmail;
import recursos.internacionalizacao.MensagensSoltas;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import entidades.telefone.bean.TelefoneBean;
import entidades.telefone.facade.TelefoneFacade;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JFileChooser;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import telas.comuns.fileChooser.ImagemFileView;
import telas.comuns.fileChooser.ImagemFilter;
import telas.comuns.fileChooser.ImagemPreview;
import telas.geral.dependencias.VincularAgendarTarefas;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.SwingUtil;
import util.Validacao;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralMensagens extends javax.swing.JPanel {
    
    private HashMap<String, File> anexos;
    private ArrayList<AgendarTarefasBean> agendarTarefas = null;

    public GeralMensagens() {
        initComponents();
        
        anexos = new HashMap<>();
        preencheCombosPara();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        bt_enviar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        bt_salvar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        bt_ajuda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tb_pane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_emailMensagem = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_emailAnexos = new javax.swing.JLabel();
        cb_emailPara = new javax.swing.JComboBox();
        tf_emailAssunto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bt_emailAgendarTarefas = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_celularMensagem = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lb_celularCaracter = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_celularPara = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        bt_celularAgendarTarefas = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cb_localPara = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_localMensagem = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        cb_localExibir = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        bt_localAgendarTarefas = new javax.swing.JButton();

        setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/logo.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/mensagens/mensagens_128x128.png"))); // NOI18N

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

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bt_enviar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/mensagens/enviar_22x22.png"))); // NOI18N
        bt_enviar.setText("Enviar e Salvar");
        bt_enviar.setToolTipText("Salvar");
        bt_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_enviarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        jLabel12.setText("* : Campos Obrigatórios");

        bt_salvar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        bt_salvar.setText("Somente Salvar");
        bt_salvar.setToolTipText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_enviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salvar)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_enviar, bt_salvar});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_salvar)
                        .addComponent(bt_enviar)))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(76, 158, 92));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bt_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ajuda_22x22.png"))); // NOI18N
        bt_ajuda.setToolTipText("Ajuda");
        bt_ajuda.setOpaque(false);
        bt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_ajuda)
        );

        tb_pane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tb_pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tb_paneStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Para:*");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Anexos:");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Anexar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ta_emailMensagem.setColumns(20);
        ta_emailMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ta_emailMensagem.setLineWrap(true);
        ta_emailMensagem.setRows(5);
        ta_emailMensagem.setWrapStyleWord(true);
        jScrollPane2.setViewportView(ta_emailMensagem);

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Mensagem:*");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Anexados:");

        lb_emailAnexos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_emailAnexos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_emailAnexos.setText("0");

        cb_emailPara.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_emailPara.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<escolha>" }));

        tf_emailAssunto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Assunto:*");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("Agendar Tarefas:");

        bt_emailAgendarTarefas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/vincular_22x22.png"))); // NOI18N
        bt_emailAgendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_emailAgendarTarefasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_emailPara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_emailAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_emailAssunto)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_emailAnexos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_emailPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1)
                    .addComponent(jLabel7)
                    .addComponent(lb_emailAnexos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_emailAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_emailAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb_pane.addTab("Email", jPanel3);

        ta_celularMensagem.setColumns(20);
        ta_celularMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ta_celularMensagem.setLineWrap(true);
        ta_celularMensagem.setRows(5);
        ta_celularMensagem.setWrapStyleWord(true);
        ta_celularMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ta_celularMensagemKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(ta_celularMensagem);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Mensagem:*");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Máximo:");

        lb_celularCaracter.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lb_celularCaracter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_celularCaracter.setText("50");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Caracteres");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Para:*");

        cb_celularPara.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_celularPara.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<escolha>" }));

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("Agendar Tarefas:*");

        bt_celularAgendarTarefas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/vincular_22x22.png"))); // NOI18N
        bt_celularAgendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_celularAgendarTarefasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_celularAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cb_celularPara, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_celularCaracter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_celularPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lb_celularCaracter)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_celularAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb_pane.addTab("Celular", jPanel4);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Para:*");

        cb_localPara.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Mensagem:*");

        ta_localMensagem.setColumns(20);
        ta_localMensagem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ta_localMensagem.setLineWrap(true);
        ta_localMensagem.setRows(5);
        ta_localMensagem.setWrapStyleWord(true);
        jScrollPane4.setViewportView(ta_localMensagem);

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Exibir:*");

        cb_localExibir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_localExibir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<escolha>", "Ao Logar", "Ao Sair", "Agendamento" }));

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Agendar Tarefas:");

        bt_localAgendarTarefas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/vincular_22x22.png"))); // NOI18N
        bt_localAgendarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_localAgendarTarefasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_localPara, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_localExibir, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_localAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_localPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cb_localExibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_localAgendarTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb_pane.addTab("Local", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        anexar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ta_celularMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ta_celularMensagemKeyReleased
        analisaCaracterCelular(evt);
    }//GEN-LAST:event_ta_celularMensagemKeyReleased

private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvar();
}//GEN-LAST:event_bt_salvarActionPerformed

private void bt_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enviarActionPerformed
        enviar();
}//GEN-LAST:event_bt_enviarActionPerformed

private void tb_paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tb_paneStateChanged
        if(tb_pane.getSelectedIndex() == 2) {
            bt_enviar.setEnabled(false);
        } else {
            bt_enviar.setEnabled(true);
        }
}//GEN-LAST:event_tb_paneStateChanged

    private void bt_emailAgendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_emailAgendarTarefasActionPerformed
        agendarTarefa();
    }//GEN-LAST:event_bt_emailAgendarTarefasActionPerformed

    private void bt_celularAgendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_celularAgendarTarefasActionPerformed
        agendarTarefa();
    }//GEN-LAST:event_bt_celularAgendarTarefasActionPerformed

    private void bt_localAgendarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_localAgendarTarefasActionPerformed
        agendarTarefa();
    }//GEN-LAST:event_bt_localAgendarTarefasActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_celularAgendarTarefas;
    private javax.swing.JButton bt_emailAgendarTarefas;
    private javax.swing.JButton bt_enviar;
    private javax.swing.JButton bt_localAgendarTarefas;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JComboBox cb_celularPara;
    private javax.swing.JComboBox cb_emailPara;
    private javax.swing.JComboBox cb_localExibir;
    private javax.swing.JComboBox cb_localPara;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JLabel lb_celularCaracter;
    private javax.swing.JLabel lb_emailAnexos;
    private javax.swing.JTextArea ta_celularMensagem;
    private javax.swing.JTextArea ta_emailMensagem;
    private javax.swing.JTextArea ta_localMensagem;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_emailAssunto;
    // End of variables declaration//GEN-END:variables
   
    /*
     *  ===============TELA==============================================
     */
    
    private void preencheCombosPara() {
        cb_emailPara.removeAllItems();
        cb_celularPara.removeAllItems();
        cb_localPara.removeAllItems();
        cb_emailPara.addItem("<Escolha>");
        cb_celularPara.addItem("<Escolha>");
        cb_localPara.addItem("<Escolha>");
        for(PessoaBean pessoa : listaPessoasNaoDeletadas()) {
            cb_emailPara.addItem(pessoa);
            cb_celularPara.addItem(pessoa);
            cb_localPara.addItem(pessoa);
        }
    }

    private void analisaCaracterCelular(KeyEvent evento) {
        Integer cont =  ta_celularMensagem.getText().length();
        lb_celularCaracter.setText((50-cont)+"");
        if(cont >= 50){
            ta_celularMensagem.setEditable(false);
        } else {
            ta_celularMensagem.setEditable(true);
        }
        if(evento.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            ta_celularMensagem.setEditable(true);
        }
    }
    
    private Boolean validaCampos() {
        if(tb_pane.getSelectedIndex() == 0) {
            if(cb_emailPara.getSelectedIndex() == 0) {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgPessoa());
                return false;
            } else if(Validacao.verificaStringVazia(tf_emailAssunto.getText())){
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgAssunto());
                return false;
            } else if(Validacao.verificaStringVazia(ta_emailMensagem.getText())){
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgMensagem());
                return false;
            }
        } else if(tb_pane.getSelectedIndex() == 1) {
            if(cb_celularPara.getSelectedIndex() == 0) {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgPessoa());
                return false;
            } if(Validacao.verificaStringVazia(ta_celularMensagem.getText())) {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgMensagem());
                return false;
            } 
        } else if(tb_pane.getSelectedIndex() == 2) {
            if(cb_localPara.getSelectedIndex() == 0) {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgPessoa());
                return false;
            } else if(cb_localExibir.getSelectedIndex() == 0) {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgExibicao());
                return false;
            } if(Validacao.verificaStringVazia(ta_localMensagem.getText())) {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.gerMsgMensagem());
                return false;
            } 
        }      
        return true;
    }
    
 /*
 *  ===============BANCO DE DADOS=========================================
 */
    
    private MensagemBean salvarMensagem(MensagemBean mensagem) {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            return mensagemFacade.insereOuAltera(mensagem);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<PessoaBean> listaPessoasNaoDeletadas() {
        PessoaFacade pessoaFacade = FactoryFacade.getPessoaImpl();
        try {
            return pessoaFacade.listarCameraNaoDeletada();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) {
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            return telefoneFacade.selecionarTelefonePorPessoa(pessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }

  /*
 *  ===============REGRA DE NEGOCIO=========================================
 */
    
    private MensagemBean populaMensagemBean() {
        MensagemBean bean = new MensagemBean();
        
        if(tb_pane.getSelectedIndex() == 0) {
            bean.setAssunto(tf_emailAssunto.getText());
            bean.setMensagem(ta_emailMensagem.getText());
            bean.setOrigem(null);
            bean.setDestino((PessoaBean) cb_emailPara.getSelectedItem());
            bean.setTipo(EnumTipoMensagem.EMAIL);
        } else if(tb_pane.getSelectedIndex() == 1) {
            bean.setAssunto("Celular");
            bean.setMensagem(ta_celularMensagem.getText());
            bean.setOrigem(null);
            bean.setDestino((PessoaBean) cb_celularPara.getSelectedItem());
            bean.setTipo(EnumTipoMensagem.CELULAR);
        } else if(tb_pane.getSelectedIndex() == 2) {
            bean.setAssunto("Local");
            bean.setMensagem(ta_localMensagem.getText());
            bean.setOrigem(InstanciasControle.getUsuarioLogado().getPessoa());
            bean.setDestino((PessoaBean) cb_localPara.getSelectedItem());
            bean.setTipo(EnumTipoMensagem.LOCAL);
            bean.setLeitura(EnumLeituraMensagem.NAO);
            if(cb_localExibir.getSelectedIndex() == 1) {
                bean.setExibir(EnumExibirMensagem.INICIAR_SISTEMA);
            } else if(cb_localExibir.getSelectedIndex() == 2) {
                bean.setExibir(EnumExibirMensagem.SAIR_SISTEMA);
            } else if(cb_localExibir.getSelectedIndex() == 3) {
                bean.setExibir(EnumExibirMensagem.AGENDAMENTO);
            }
        }
        bean.setAgendarTarefas(agendarTarefas);
        bean.setDataHora(Calendar.getInstance());
        
        return bean;
    }

    private void salvar() {
        if(validaCampos()) {
            if(salvarMensagem(populaMensagemBean()) != null) {
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerMsgSalvar());
                AtualizaTelas.geralAgendarTarefas();
                limparCampos();
            }
        }
    }
    
    private void enviar() {
        if(validaCampos()) {
            if(tb_pane.getSelectedIndex() == 0) {
                email();
            } else if(tb_pane.getSelectedIndex() == 1) {
                celular();
            }
        }
    }    
    
    private void anexar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ImagemFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileView(new ImagemFileView());
        fileChooser.setAccessory(new ImagemPreview(fileChooser));
        
        Integer retorno = fileChooser.showDialog(this, "Abrir");
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            anexos.put(arquivo.getName(), arquivo);
            lb_emailAnexos.setText(anexos.size()+"");
        }
    }
    
    private void email() {
        PessoaBean pessoa = (PessoaBean) cb_emailPara.getSelectedItem();
        EnviarEmail enviarEmail = new EnviarEmail();
        enviarEmail.setAnexos(anexos);
        if(enviarEmail.enviar(pessoa, tf_emailAssunto.getText(), ta_emailMensagem.getText())) {
            salvar();
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.emailSucesso());
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.emailErroEnviar());
        }
    }
    
    private void celular() {
        PessoaBean pessoa = (PessoaBean) cb_celularPara.getSelectedItem();
        TelefoneBean telefone = selecionarTelefonePorPessoa(pessoa);
        Celular celular = new Celular(telefone.getNumero(), telefone.getDdd(), ta_celularMensagem.getText());
        if(celular.modem()) {
            salvar();
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.celularSucesso());
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.celularErroEnviar());
        }
    }
    
    private void agendarTarefa() {
        VincularAgendarTarefas dialog = new VincularAgendarTarefas(null, true, ConstantesSistema.VINCULO_MENSAGEM, null, this);
        dialog.setVisible(true); 
    } 
    
    public void atualizarAgendamento(ArrayList<AgendarTarefasBean> agendarTarefas) {
        InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerMsgVincular());
        this.agendarTarefas = agendarTarefas;
    }
    
    private void limparCampos() {
        if(tb_pane.getSelectedIndex() == 0) {
            cb_emailPara.setSelectedIndex(0);
            lb_emailAnexos.setText("0"); 
            tf_emailAssunto.setText("");
            ta_emailMensagem.setText("");
        } else if(tb_pane.getSelectedIndex() == 1) {
            cb_celularPara.setSelectedIndex(0);
            ta_celularMensagem.setText("");
        } else if(tb_pane.getSelectedIndex() == 2) {
            cb_localPara.setSelectedIndex(0);
            cb_localExibir.setSelectedIndex(0);
            ta_localMensagem.setText("");
        }
        anexos = new HashMap<>();
        agendarTarefas = null;
    }
    
    public void enviarSmsComLocalizacao(String sms) {
        tb_pane.setSelectedIndex(1);
        ta_celularMensagem.setText(sms);
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.mensagens());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }

}
