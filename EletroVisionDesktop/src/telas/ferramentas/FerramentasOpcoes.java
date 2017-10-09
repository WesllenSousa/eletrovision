
package telas.ferramentas;

import recursos.configuracoes.sistema.ConfigConexaoBanco;
import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosAudio;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigMensagens;
import recursos.configuracoes.sistema.ConfigGerais;
import recursos.configuracoes.xml.carregarXMLs.CarregarHibernateCFG;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import util.*;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class FerramentasOpcoes extends javax.swing.JPanel {
    
    private Boolean bl_mensagens = false, bl_dispositivos = false, 
                    bl_bancoDados = false, bl_gerais = false;
    private Boolean statusReiniciar = false;

    public FerramentasOpcoes() {
        initComponents();
        
        preencherComboAlarme();
        
        lerMensagens();
        lerDispositivos();
        lerBancoDados();
        lerGerais();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSistema = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tb_pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        ck_msgAtivarMensagens = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cb_msgPorta = new javax.swing.JComboBox();
        ck_msgAtivarCelular = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tf_msgEmail = new javax.swing.JTextField();
        pw_msgSenha = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_msgServidor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tf_msgPorta = new javax.swing.JTextField();
        ck_msgAtivarEmail = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        ck_msgAtivarRede = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        ck_dpIniciarCameras = new javax.swing.JCheckBox();
        ck_dpDetectarFace = new javax.swing.JCheckBox();
        ck_dpDetectarOlhos = new javax.swing.JCheckBox();
        ck_dpDetectarCorpo = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cb_dpAlarme = new javax.swing.JComboBox();
        ck_dpGravarVideo = new javax.swing.JCheckBox();
        ck_dpDetectarObjeto = new javax.swing.JCheckBox();
        tf_dpIntervaloProcessamento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ck_dpAtivarDispositivos = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        tf_dpTempoControleAutomatico = new javax.swing.JTextField();
        ck_dpReconhecerFace = new javax.swing.JCheckBox();
        ck_dpDetectarMovimento = new javax.swing.JCheckBox();
        ck_dpAlteracaoAmbiente = new javax.swing.JCheckBox();
        tf_dpCodec = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        tf_dpLargura = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_dpAltura = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        ck_dpCampanhia = new javax.swing.JCheckBox();
        sl_sdSensibilidadeMovimento = new javax.swing.JSlider();
        jPanel11 = new javax.swing.JPanel();
        ck_dpAtivarAcionamento = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_bdNome = new javax.swing.JTextField();
        cb_bdBancoDados = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tf_bdHost = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_bdPorta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_bdUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pw_bdSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        ck_grAtivarSomCamera = new javax.swing.JCheckBox();
        ck_grAtivarSomSistema = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        ck_grAtivarExpiao = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        tf_grExpiaoTempo = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        ck_grAtivarServidor = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        ck_grAtivarAgendarTarefas = new javax.swing.JCheckBox();
        jPanel15 = new javax.swing.JPanel();
        rd_grCliente = new javax.swing.JRadioButton();
        rd_grServidor = new javax.swing.JRadioButton();
        jPanel23 = new javax.swing.JPanel();
        ck_grTelaMaximizada = new javax.swing.JCheckBox();

        tb_pane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tb_pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tb_paneStateChanged(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Geral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        ck_msgAtivarMensagens.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_msgAtivarMensagens.setText("Ativar envio de todas as mensagens");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_msgAtivarMensagens)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_msgAtivarMensagens)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Celular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Porta do Modem:");

        cb_msgPorta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_msgPorta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM10" }));

        ck_msgAtivarCelular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_msgAtivarCelular.setText("Ativar envio para o celular");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(ck_msgAtivarCelular)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_msgPorta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ck_msgAtivarCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_msgPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Email:*");

        tf_msgEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pw_msgSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Senha:*");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Servidor:*");

        tf_msgServidor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Porta:*");

        tf_msgPorta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ck_msgAtivarEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_msgAtivarEmail.setText("Ativar envio para o email");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(ck_msgAtivarEmail)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_msgPorta)
                            .addComponent(pw_msgSenha)
                            .addComponent(tf_msgServidor)
                            .addComponent(tf_msgEmail))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_msgAtivarEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_msgEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(pw_msgSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_msgServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_msgPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        ck_msgAtivarRede.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_msgAtivarRede.setText("Ativar envio pela rede");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_msgAtivarRede)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ck_msgAtivarRede)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        tb_pane.addTab("Mensagens", jPanel2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Câmeras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        ck_dpIniciarCameras.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpIniciarCameras.setText("Ativar câmeras ao iniciar o sistema.");

        ck_dpDetectarFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpDetectarFace.setText("Detectar Face");

        ck_dpDetectarOlhos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpDetectarOlhos.setText("Detectar Olhos");

        ck_dpDetectarCorpo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpDetectarCorpo.setText("Detectar Corpo");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Alarme:");

        cb_dpAlarme.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ck_dpGravarVideo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpGravarVideo.setText("Gravar Vídeo");

        ck_dpDetectarObjeto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpDetectarObjeto.setText("Detectar Objeto");

        tf_dpIntervaloProcessamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_dpIntervaloProcessamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Intervalo de Processamento (segundos).");

        ck_dpAtivarDispositivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpAtivarDispositivos.setText("Ativar Dispositivos");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Tempo ocioso para o controle automático (minutos).");

        tf_dpTempoControleAutomatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_dpTempoControleAutomatico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        ck_dpReconhecerFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpReconhecerFace.setText("Reconhecer Face");

        ck_dpDetectarMovimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpDetectarMovimento.setText("Detectar Movimento");

        ck_dpAlteracaoAmbiente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpAlteracaoAmbiente.setText("Detectar alteração no ambiente");

        tf_dpCodec.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_dpCodec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Codec (Id).");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Pessoas");

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Tempos");

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel22.setText("Tamando da exibição da imagem da câmera");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Largura(px):");

        tf_dpLargura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_dpLargura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Altura(px):");

        tf_dpAltura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_dpAltura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Ações");

        ck_dpCampanhia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpCampanhia.setText("Campanhia");

        sl_sdSensibilidadeMovimento.setPaintLabels(true);
        sl_sdSensibilidadeMovimento.setSnapToTicks(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_dpAlarme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ck_dpIniciarCameras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_dpLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_dpAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(tf_dpIntervaloProcessamento, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_dpTempoControleAutomatico)
                                    .addComponent(tf_dpCodec, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ck_dpGravarVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ck_dpCampanhia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ck_dpAtivarDispositivos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ck_dpDetectarObjeto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ck_dpAlteracaoAmbiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(ck_dpDetectarMovimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sl_sdSensibilidadeMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ck_dpDetectarFace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ck_dpReconhecerFace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ck_dpDetectarOlhos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ck_dpDetectarCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(ck_dpIniciarCameras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_dpAlarme, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_dpLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tf_dpAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_dpDetectarMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sl_sdSensibilidadeMovimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dpAlteracaoAmbiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dpDetectarObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dpAtivarDispositivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dpCampanhia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dpGravarVideo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_dpDetectarFace)
                    .addComponent(ck_dpDetectarOlhos)
                    .addComponent(ck_dpDetectarCorpo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dpReconhecerFace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_dpIntervaloProcessamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_dpTempoControleAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_dpCodec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acionamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        ck_dpAtivarAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dpAtivarAcionamento.setText("Conectar ao(s) módulo(s) de acionamento ao iniciar o sistema");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_dpAtivarAcionamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_dpAtivarAcionamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel10);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        tb_pane.addTab("Dispositivos", jPanel3);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Banco de Dados:*");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Nome:*");

        tf_bdNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_bdNome.setText("sistema");

        cb_bdBancoDados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_bdBancoDados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Postgres" }));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Host:*");

        tf_bdHost.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_bdHost.setText("127.0.0.1");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Porta:*");

        tf_bdPorta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_bdPorta.setText("5432");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Usuário:*");

        tf_bdUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Senha:*");

        pw_bdSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Testar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pw_bdSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_bdUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_bdBancoDados, 0, 326, Short.MAX_VALUE)
                            .addComponent(tf_bdNome)
                            .addComponent(tf_bdHost)
                            .addComponent(tf_bdPorta))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_bdBancoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_bdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_bdHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_bdPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_bdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(pw_bdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        tb_pane.addTab("Banco de Dados", jPanel4);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Áudio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12), java.awt.Color.black)); // NOI18N

        ck_grAtivarSomCamera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_grAtivarSomCamera.setText("Ativar sons das câmeras");

        ck_grAtivarSomSistema.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_grAtivarSomSistema.setText("Ativar sons do sistema");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ck_grAtivarSomCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_grAtivarSomSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grAtivarSomCamera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_grAtivarSomSistema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expião", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ck_grAtivarExpiao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_grAtivarExpiao.setText("Ativar ao iniciar o sistema");

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Tempo de Captura (Segundos).");

        tf_grExpiaoTempo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_grExpiaoTempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tf_grExpiaoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(ck_grAtivarExpiao, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grAtivarExpiao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_grExpiaoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servidor de Rede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        jPanel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ck_grAtivarServidor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_grAtivarServidor.setText("Ativar servidor ao iniciar o sistema");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grAtivarServidor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grAtivarServidor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendar Tarefas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        jPanel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ck_grAtivarAgendarTarefas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_grAtivarAgendarTarefas.setText("Ativar agendamento ao iniciar o sistema");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grAtivarAgendarTarefas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grAtivarAgendarTarefas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serviços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        grupoSistema.add(rd_grCliente);
        rd_grCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_grCliente.setText("Cliente");

        grupoSistema.add(rd_grServidor);
        rd_grServidor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_grServidor.setText("Servidor");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_grCliente)
                    .addComponent(rd_grServidor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_grCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_grServidor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        ck_grTelaMaximizada.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_grTelaMaximizada.setText("Abrir tela principal maximizada");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grTelaMaximizada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_grTelaMaximizada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel22);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        tb_pane.addTab("Gerais", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
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

private void tb_paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tb_paneStateChanged
    analisarAbas();
}//GEN-LAST:event_tb_paneStateChanged

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    gravarBancoDados();
    ConexaoJDBC conexaoJDBC = new ConexaoJDBC();
    if(conexaoJDBC.getConnection(pw_bdSenha.getText()) != null) {
        InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrConexaoEstabelecida());
    }
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_bdBancoDados;
    private javax.swing.JComboBox cb_dpAlarme;
    private javax.swing.JComboBox cb_msgPorta;
    private javax.swing.JCheckBox ck_dpAlteracaoAmbiente;
    private javax.swing.JCheckBox ck_dpAtivarAcionamento;
    private javax.swing.JCheckBox ck_dpAtivarDispositivos;
    private javax.swing.JCheckBox ck_dpCampanhia;
    private javax.swing.JCheckBox ck_dpDetectarCorpo;
    private javax.swing.JCheckBox ck_dpDetectarFace;
    private javax.swing.JCheckBox ck_dpDetectarMovimento;
    private javax.swing.JCheckBox ck_dpDetectarObjeto;
    private javax.swing.JCheckBox ck_dpDetectarOlhos;
    private javax.swing.JCheckBox ck_dpGravarVideo;
    private javax.swing.JCheckBox ck_dpIniciarCameras;
    private javax.swing.JCheckBox ck_dpReconhecerFace;
    private javax.swing.JCheckBox ck_grAtivarAgendarTarefas;
    private javax.swing.JCheckBox ck_grAtivarExpiao;
    private javax.swing.JCheckBox ck_grAtivarServidor;
    private javax.swing.JCheckBox ck_grAtivarSomCamera;
    private javax.swing.JCheckBox ck_grAtivarSomSistema;
    private javax.swing.JCheckBox ck_grTelaMaximizada;
    private javax.swing.JCheckBox ck_msgAtivarCelular;
    private javax.swing.JCheckBox ck_msgAtivarEmail;
    private javax.swing.JCheckBox ck_msgAtivarMensagens;
    private javax.swing.JCheckBox ck_msgAtivarRede;
    private javax.swing.ButtonGroup grupoSistema;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPasswordField pw_bdSenha;
    private javax.swing.JPasswordField pw_msgSenha;
    private javax.swing.JRadioButton rd_grCliente;
    private javax.swing.JRadioButton rd_grServidor;
    private javax.swing.JSlider sl_sdSensibilidadeMovimento;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_bdHost;
    private javax.swing.JTextField tf_bdNome;
    private javax.swing.JTextField tf_bdPorta;
    private javax.swing.JTextField tf_bdUsuario;
    private javax.swing.JTextField tf_dpAltura;
    private javax.swing.JTextField tf_dpCodec;
    private javax.swing.JTextField tf_dpIntervaloProcessamento;
    private javax.swing.JTextField tf_dpLargura;
    private javax.swing.JTextField tf_dpTempoControleAutomatico;
    private javax.swing.JTextField tf_grExpiaoTempo;
    private javax.swing.JTextField tf_msgEmail;
    private javax.swing.JTextField tf_msgPorta;
    private javax.swing.JTextField tf_msgServidor;
    // End of variables declaration//GEN-END:variables

    private void preencherComboAlarme() {
        HashSet<String> hashSet = DiretorioUtil.listarArquivos(new File(ArquivosAudio.diretorioAlarme()));
        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            cb_dpAlarme.addItem(iterator.next().toString());
        }
    }
    
    private void analisarAbas() {
        if(tb_pane.getSelectedIndex() == 0){
            bl_mensagens = true;
        } else if(tb_pane.getSelectedIndex() == 1){
            bl_dispositivos = true;
        } if(tb_pane.getSelectedIndex() == 2){
            bl_bancoDados = true;
        } if(tb_pane.getSelectedIndex() == 3){
            bl_gerais = true;
        }
    }

    private Boolean validaCampos(){
        if(bl_mensagens){
            if(Validacao.verificaStringVazia(tf_msgPorta.getText())){
                tb_pane.setSelectedIndex(0);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesPorta());
                return false;
            }
        } 
        if(bl_dispositivos){
            if(!Validacao.verificaNumeroInteger(tf_dpLargura.getText()) ||
                      Validacao.verificaNumeroNegativo(tf_dpLargura.getText())){
                tb_pane.setSelectedIndex(1);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesLargura());
                return false;
            } else if(!Validacao.verificaNumeroInteger(tf_dpAltura.getText()) ||
                      Validacao.verificaNumeroNegativo(tf_dpAltura.getText())){
                tb_pane.setSelectedIndex(1);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesAltura());
                return false;
            } else if(!Validacao.verificaNumeroInteger(tf_dpIntervaloProcessamento.getText()) ||
                      Validacao.verificaNumeroNegativo(tf_dpIntervaloProcessamento.getText())){
                tb_pane.setSelectedIndex(1);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesIntervaloProcessamento());
                return false;
            } else if(!Validacao.verificaNumeroInteger(tf_dpTempoControleAutomatico.getText()) ||
                      Validacao.verificaNumeroNegativo(tf_dpTempoControleAutomatico.getText())){
                tb_pane.setSelectedIndex(1);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesControleAutomatico());
                return false;
            } else if(!Validacao.verificaNumeroInteger(tf_dpCodec.getText())){
                tb_pane.setSelectedIndex(1);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesCodec());
                return false;
            }
        } 
        if(bl_bancoDados){
            if(Validacao.verificaStringVazia(tf_bdNome.getText())){
                tb_pane.setSelectedIndex(2);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesNome());
                return false;
            } else if(Validacao.verificaStringVazia(tf_bdHost.getText())){
                tb_pane.setSelectedIndex(2);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesHost());
                return false;
            } else if(!Validacao.verificaNumeroInteger(tf_bdPorta.getText()) ||
                      Validacao.verificaNumeroNegativo(tf_bdPorta.getText())){
                tb_pane.setSelectedIndex(2);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesPortaInvalida());
                return false;
            } else if(Validacao.verificaStringVazia(tf_bdUsuario.getText())){
                tb_pane.setSelectedIndex(2);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesUsuario());
                return false;
            } else if(Validacao.verificaStringVazia(pw_bdSenha.getText())){
                tb_pane.setSelectedIndex(2);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesSenha());
                return false;
            }
        }  
        if(bl_gerais){
            if(!Validacao.verificaNumeroInteger(tf_grExpiaoTempo.getText()) ||
                      Validacao.verificaNumeroNegativo(tf_grExpiaoTempo.getText())){
                tb_pane.setSelectedIndex(3);
                InstanciasControle.getMensagens().aviso(MensagensSoltas.ferrOpcoesTempoCaptura());
                return false;
            } 
        }
        return true;
    }
    
    public void salvar(){
        if(validaCampos()) {
            statusReiniciar = false;
            if(bl_mensagens){
                mensagens();
            }
            if(bl_dispositivos){
                dispositivos();
            }
            if(bl_bancoDados){
                bancoDados();
                statusReiniciar = true;
            }
            if(bl_gerais){
                outros();
            }
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrOpcoesSalvas());
            if(statusReiniciar){
                reiniciarSistema();
            }
        }
    }

    private void bancoDados() {
        gravarBancoDados();
        CarregarHibernateCFG cfg = new CarregarHibernateCFG(pw_bdSenha.getText());
    }

    private void dispositivos() {
        gravarDispositivos();
    }

    private void mensagens() {
        gravarMensagens();
    }

    private void outros() {
        gravarGerais();
    }
    
    private void reiniciarSistema(){
        if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrOpcoesReiniciar())) {
            System.exit(0);
        }
    }

    
/*
 *  ARQUIVOS
 */
    
    private void gravarMensagens(){
        Properties props = new Properties();
        
        props.setProperty("portaModem", cb_msgPorta.getSelectedItem().toString());
        props.setProperty("email", tf_msgEmail.getText());
        props.setProperty("senha", pw_msgSenha.getText());
        props.setProperty("servidor", tf_msgServidor.getText());
        props.setProperty("porta", tf_msgPorta.getText());
        if(ck_msgAtivarMensagens.isSelected()) { 
            props.setProperty("ativarMensagens", "0");
        } else {
            props.setProperty("ativarMensagens", "1");
        }
        if(ck_msgAtivarCelular.isSelected()) { 
            props.setProperty("ativarCelular", "0");
        } else {
            props.setProperty("ativarCelular", "1");
        }
        if(ck_msgAtivarEmail.isSelected()) { 
            props.setProperty("ativarEmail", "0");
        } else {
            props.setProperty("ativarEmail", "1");
        }
        if(ck_msgAtivarRede.isSelected()) { 
            props.setProperty("ativarRede", "0");
        } else {
            props.setProperty("ativarRede", "1");
        }
        
        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.mensagens(),
                "configuração de mensagens!");
        
        ConfigMensagens.setPortaModem(cb_msgPorta.getSelectedItem().toString());
        ConfigMensagens.setEmail(tf_msgEmail.getText());
        ConfigMensagens.setSenha(pw_msgSenha.getText());
        ConfigMensagens.setServidor(tf_msgServidor.getText());
        ConfigMensagens.setPorta(Integer.parseInt(tf_msgPorta.getText()));
        if(ck_msgAtivarMensagens.isSelected()) { 
            ConfigMensagens.setAtivarEnvioMensagens(true);
        } else {
            ConfigMensagens.setAtivarEnvioMensagens(false);
        }
        if(ck_msgAtivarCelular.isSelected()) { 
            ConfigMensagens.setAtivarEnvioCelular(true);
        } else {
            ConfigMensagens.setAtivarEnvioCelular(false);
        }
        if(ck_msgAtivarEmail.isSelected()) { 
            ConfigMensagens.setAtivarEnvioEmail(true);
        } else {
            ConfigMensagens.setAtivarEnvioEmail(false);
        }
        if(ck_msgAtivarRede.isSelected()) { 
            ConfigMensagens.setAtivarEnvioRede(true);
        } else {
            ConfigMensagens.setAtivarEnvioRede(false);
        }
    }
    
    private void lerMensagens(){
        Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.mensagens());
        if(props != null){
            String ativarMensagens = props.getProperty("ativarMensagens");
            String portaModem = props.getProperty("portaModem");
            String email = props.getProperty("email");
            String senha = props.getProperty("senha");
            String servidor = props.getProperty("servidor");
            String porta = props.getProperty("porta");
            String ativarCelular = props.getProperty("ativarCelular");
            String ativarEmail = props.getProperty("ativarEmail");
            String ativarRede = props.getProperty("ativarRede");
            
            cb_msgPorta.setSelectedItem(portaModem);
            tf_msgEmail.setText(email);
            pw_msgSenha.setText(senha);
            tf_msgServidor.setText(servidor);
            tf_msgPorta.setText(porta);
            if(ativarMensagens.equals("0")){
                ck_msgAtivarMensagens.setSelected(true);
            } else {
                ck_msgAtivarMensagens.setSelected(false);
            }
            if(ativarCelular.equals("0")){
                ck_msgAtivarCelular.setSelected(true);
            } else {
                ck_msgAtivarCelular.setSelected(false);
            }
            if(ativarEmail.equals("0")){
                ck_msgAtivarEmail.setSelected(true);
            } else {
                ck_msgAtivarEmail.setSelected(false);
            }
            if(ativarRede.equals("0")){
                ck_msgAtivarRede.setSelected(true);
            } else {
                ck_msgAtivarRede.setSelected(false);
            }
        }
    }
    
    private void gravarDispositivos(){
        Properties props = new Properties();
        props.setProperty("alarme", cb_dpAlarme.getSelectedItem().toString());
        props.setProperty("largura", tf_dpLargura.getText());
        props.setProperty("altura", tf_dpAltura.getText());
        props.setProperty("intervaloProcessamento", tf_dpIntervaloProcessamento.getText());
        props.setProperty("tempoControleAutomatico", tf_dpTempoControleAutomatico.getText());
        props.setProperty("codec", tf_dpCodec.getText());
        props.setProperty("sensibilidadeMovimento", (sl_sdSensibilidadeMovimento.getValue())+"");
        if(ck_dpIniciarCameras.isSelected()) { 
            props.setProperty("iniciarSistema", "0");
        } else {
            props.setProperty("iniciarSistema", "1");
        }
        if(ck_dpGravarVideo.isSelected()) { 
            props.setProperty("gravarVideo", "0");
        } else {
            props.setProperty("gravarVideo", "1");
        }
        if(ck_dpDetectarFace.isSelected()) { 
            props.setProperty("face", "0");
        } else {
            props.setProperty("face", "1");
        }
        if(ck_dpReconhecerFace.isSelected()) { 
            props.setProperty("reconhecerFace", "0");
        } else {
            props.setProperty("reconhecerFace", "1");
        }
        if(ck_dpDetectarOlhos.isSelected()) { 
            props.setProperty("olhos", "0");
        } else {
            props.setProperty("olhos", "1");
        }
        if(ck_dpDetectarCorpo.isSelected()) { 
            props.setProperty("corpo", "0");
        } else {
            props.setProperty("corpo", "1");
        }
        if(ck_dpAtivarAcionamento.isSelected()) {
            props.setProperty("ativarAcionamento", "0");
        } else {
            props.setProperty("ativarAcionamento", "1");
        }
        if(ck_dpDetectarObjeto.isSelected()) { 
            props.setProperty("objetos", "0");
        } else {
            props.setProperty("objetos", "1");
        }
        if(ck_dpAtivarDispositivos.isSelected()) { 
            props.setProperty("ativarDispositivos", "0");
        } else {
            props.setProperty("ativarDispositivos", "1");
        }
        if(ck_dpDetectarMovimento.isSelected()) { 
            props.setProperty("movimento", "0");
        } else {
            props.setProperty("movimento", "1"); 
        } 
        if(ck_dpAlteracaoAmbiente.isSelected()) { 
            props.setProperty("alteracaoAmbiente", "0");
        } else {
            props.setProperty("alteracaoAmbiente", "1"); 
        } 
        if(ck_dpCampanhia.isSelected()) { 
            props.setProperty("campanhia", "0");
        } else {
            props.setProperty("campanhia", "1");
        }
        
        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.dispositivos(),
                "configuração de dispositivos!");
        
        ConfigDispositivos.setAlarme(cb_dpAlarme.getSelectedItem().toString());
        ConfigDispositivos.setLargura(Integer.parseInt(tf_dpLargura.getText()));
        ConfigDispositivos.setAltura(Integer.parseInt(tf_dpAltura.getText()));
        ConfigDispositivos.setIntervaloProcessamento(Integer.parseInt(tf_dpIntervaloProcessamento.getText()));
        ConfigDispositivos.setTempoControleAutomatico(Integer.parseInt(tf_dpTempoControleAutomatico.getText()));
        ConfigDispositivos.setCodec(Integer.parseInt(tf_dpCodec.getText()));
        ConfigDispositivos.setSensibilidadeMovimento(sl_sdSensibilidadeMovimento.getValue());
        if(ck_dpGravarVideo.isSelected()) {
            ConfigDispositivos.setGravarVideo(true);
        } else {
            ConfigDispositivos.setGravarVideo(false);
        }
        if(ck_dpDetectarFace.isSelected()) { 
            ConfigDispositivos.setDetectarFace(true);
        } else {
            ConfigDispositivos.setDetectarFace(false);
        }
        if(ck_dpReconhecerFace.isSelected()) { 
            ConfigDispositivos.setReconhecerFaces(true);
        } else {
            ConfigDispositivos.setReconhecerFaces(false);
        }
        if(ck_dpDetectarOlhos.isSelected()) { 
            ConfigDispositivos.setDetectarOlhos(true);
        } else {
            ConfigDispositivos.setDetectarOlhos(false);
        }
        if(ck_dpDetectarCorpo.isSelected()) { 
            ConfigDispositivos.setDetectarCorpo(true);
        } else {
            ConfigDispositivos.setDetectarCorpo(false);
        }
        if(ck_dpAtivarAcionamento.isSelected()) {
            ConfigDispositivos.setAtivarAcionamento(true);
        } else {
            ConfigDispositivos.setAtivarAcionamento(false);
        }
        if(ck_dpDetectarObjeto.isSelected()) { 
            ConfigDispositivos.setDetectarObjeto(true);
        } else {
            ConfigDispositivos.setDetectarObjeto(false);
        }
        if(ck_dpAtivarDispositivos.isSelected()) { 
            ConfigDispositivos.setAtivarDispositivosCamera(true);
        } else {
            ConfigDispositivos.setAtivarDispositivosCamera(false);
        }
        if(ck_dpDetectarMovimento.isSelected()) { 
            ConfigDispositivos.setMovimento(true);
        } else {
            ConfigDispositivos.setMovimento(false);
        }
        if(ck_dpAlteracaoAmbiente.isSelected()) { 
            ConfigDispositivos.setAlteracaoAmbiente(true);
        } else {
            ConfigDispositivos.setAlteracaoAmbiente(false);
        }
        if(ck_dpCampanhia.isSelected()) { 
            ConfigDispositivos.setCampanhia(true);
        } else {
            ConfigDispositivos.setCampanhia(false);
        }
    }
    
    private void lerDispositivos(){
        Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.dispositivos());
        if(props != null){
            String alarme = props.getProperty("alarme");
            String largura = props.getProperty("largura");
            String altura = props.getProperty("altura");
            String iniciarSistema = props.getProperty("iniciarSistema");
            String gravarVideo = props.getProperty("gravarVideo");
            String face = props.getProperty("face");
            String reconhecerFace = props.getProperty("reconhecerFace");
            String olhos = props.getProperty("olhos");
            String corpo = props.getProperty("corpo");    
            String ativarAcionamento = props.getProperty("ativarAcionamento");
            String objetos = props.getProperty("objetos");
            String intervaloProcessamento = props.getProperty("intervaloProcessamento");
            String ativarDispositivosCameras = props.getProperty("ativarDispositivos");
            String tempoControleAutomatico = props.getProperty("tempoControleAutomatico");
            String movimento = props.getProperty("movimento");
            String alteracaoAmbiente = props.getProperty("alteracaoAmbiente");
            String codec = props.getProperty("codec");
            String sensibilidadeMovimento = props.getProperty("sensibilidadeMovimento");
            String campanhia = props.getProperty("campanhia"); 
            
            tf_dpLargura.setText(largura);
            tf_dpAltura.setText(altura);
            cb_dpAlarme.setSelectedItem(alarme);
            tf_dpIntervaloProcessamento.setText(intervaloProcessamento); 
            tf_dpTempoControleAutomatico.setText(tempoControleAutomatico);
            tf_dpCodec.setText(codec); 
            sl_sdSensibilidadeMovimento.setValue(Integer.parseInt(sensibilidadeMovimento));
            if(iniciarSistema.equals("0")){
                ck_dpIniciarCameras.setSelected(true);
            } else {
                ck_dpIniciarCameras.setSelected(false);
            }
            if(gravarVideo.equals("0")) {
                ck_dpGravarVideo.setSelected(true);
            } else {
                ck_dpGravarVideo.setSelected(false);
            }
            if(face.equals("0")){
                ck_dpDetectarFace.setSelected(true);
            } else {
                ck_dpDetectarFace.setSelected(false);
            }
            if(reconhecerFace.equals("0")){
                ck_dpReconhecerFace.setSelected(true);
            } else {
                ck_dpReconhecerFace.setSelected(false);
            }
            if(olhos.equals("0")){
                ck_dpDetectarOlhos.setSelected(true);
            } else {
                ck_dpDetectarOlhos.setSelected(false);
            }
            if(corpo.equals("0")){
                ck_dpDetectarCorpo.setSelected(true);
            } else {
                ck_dpDetectarCorpo.setSelected(false);
            }
            if(ativarAcionamento.equals("0")){
                ck_dpAtivarAcionamento.setSelected(true);
            } else {
                ck_dpAtivarAcionamento.setSelected(false);
            }
            if(objetos.equals("0")){
                ck_dpDetectarObjeto.setSelected(true);
            } else {
                ck_dpDetectarObjeto.setSelected(false);
            }
            if(ativarDispositivosCameras.equals("0")){
                ck_dpAtivarDispositivos.setSelected(true);
            } else {
                ck_dpAtivarDispositivos.setSelected(false);
            }
            if(movimento.equals("0")){
                ck_dpDetectarMovimento.setSelected(true);
            } else {
                ck_dpDetectarMovimento.setSelected(false);
            }
            if(alteracaoAmbiente.equals("0")){
                ck_dpAlteracaoAmbiente.setSelected(true);
            } else {
                ck_dpAlteracaoAmbiente.setSelected(false);
            }
            if(campanhia.equals("0")) {
                ck_dpCampanhia.setSelected(true);
            } else {
                ck_dpCampanhia.setSelected(false);
            }
        }
    }
    
    private void gravarBancoDados(){
        Properties props = new Properties();
        props.setProperty("banco", "postgresql");
        props.setProperty("driver", "org.postgresql.Driver");
        props.setProperty("nome", tf_bdNome.getText());
        props.setProperty("host", tf_bdHost.getText());
        props.setProperty("porta", tf_bdPorta.getText());
        props.setProperty("usuario", tf_bdUsuario.getText());

        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.conexaoBanco(),
                "configuração de conexão com o banco de dados!");
        
        ConfigConexaoBanco.setBanco("postgresql");
        ConfigConexaoBanco.setDriver("org.postgresql.Driver");
        ConfigConexaoBanco.setNomeBanco(tf_bdNome.getText());
        ConfigConexaoBanco.setHost(tf_bdHost.getText());
        ConfigConexaoBanco.setPorta(tf_bdPorta.getText());
        ConfigConexaoBanco.setUsuario(tf_bdUsuario.getText());
    }
    
    private void lerBancoDados(){
        Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.conexaoBanco());
        if (props != null) {
            String banco = props.getProperty("banco");
            String driver = props.getProperty("driver");
            String nome = props.getProperty("nome");
            String host = props.getProperty("host");
            String porta = props.getProperty("porta");
            String usuario = props.getProperty("usuario");

            cb_bdBancoDados.setSelectedItem(banco);
            tf_bdNome.setText(nome);
            tf_bdHost.setText(host);
            tf_bdPorta.setText(porta);
            tf_bdUsuario.setText(usuario);
        }
    }
    
    private void gravarGerais(){
        Properties props = new Properties();
        if(ck_grAtivarSomCamera.isSelected()) {
            props.setProperty("somCamera", "0");
        } else {
            props.setProperty("somCamera", "1");
        }
        if(ck_grAtivarSomSistema.isSelected()) {
            props.setProperty("somSistema", "0");
        } else {
            props.setProperty("somSistema", "1");
        }
        props.setProperty("tempoCapturaExpiao", tf_grExpiaoTempo.getText());
        if(ck_grAtivarExpiao.isSelected()) {
            props.setProperty("iniciarExpiao", "0");
        } else {
            props.setProperty("iniciarExpiao", "1");
        }
        if(ck_grAtivarServidor.isSelected()) {
            props.setProperty("iniciarServidor", "0");
        } else {
            props.setProperty("iniciarServidor", "1");
        }
        if(ck_grAtivarAgendarTarefas.isSelected()) {
            props.setProperty("ativarAgendarTarefas", "0");
        } else {
            props.setProperty("ativarAgendarTarefas", "1");
        }
        if(rd_grCliente.isSelected()) {
            props.setProperty("servico", "0");
        } else if(rd_grServidor.isSelected()) {
            props.setProperty("servico", "1");
        }
        if(ck_grTelaMaximizada.isSelected()) {
            props.setProperty("telaMaximizada", "0");
        } else {
            props.setProperty("telaMaximizada", "1");
        }
        
        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.gerais(),
                "Configuração diversas!");
        
        ConfigGerais.setTempoExpiao(Integer.parseInt(tf_grExpiaoTempo.getText()));
        if(ck_grAtivarSomCamera.isSelected()) {
            ConfigGerais.setAtivarSomCamera(true);
        } else {
            ConfigGerais.setAtivarSomCamera(false);
        }
        if(ck_grAtivarSomSistema.isSelected()) {
            ConfigGerais.setAtivarSomSistema(true);
        } else {
            ConfigGerais.setAtivarSomSistema(false);
        }
        if(ck_grAtivarAgendarTarefas.isSelected()) {
            ConfigGerais.setAtivarAgendarTarefas(true);
        } else {
            ConfigGerais.setAtivarAgendarTarefas(false);
        }
        if(rd_grCliente.isSelected()) {
            ConfigGerais.setServico(0);
        } else if(rd_grServidor.isSelected()) {
            ConfigGerais.setServico(1);
        }
        if(ck_grTelaMaximizada.isSelected()) {
            ConfigGerais.setTelaMaximizada(true);
        } else {
            ConfigGerais.setTelaMaximizada(false); 
        }
    }
    
    private void lerGerais(){
        Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.gerais());
        if(props != null){
            String somCamera = props.getProperty("somCamera");
            String somSistema = props.getProperty("somSistema");
            String tempoCapturaExpiao = props.getProperty("tempoCapturaExpiao");
            String iniciarExpiao = props.getProperty("iniciarExpiao");
            String iniciarServidor = props.getProperty("iniciarServidor");
            String ativarAgendarTarefas = props.getProperty("ativarAgendarTarefas");
            String servico = props.getProperty("servico");
            String telaMaximizada = props.getProperty("telaMaximizada");
            
            tf_grExpiaoTempo.setText(tempoCapturaExpiao);
            if(somCamera.equals("0")){
                ck_grAtivarSomCamera.setSelected(true);
            } else {
                ck_grAtivarSomCamera.setSelected(false); 
            }
            if(somSistema.equals("0")){
                ck_grAtivarSomSistema.setSelected(true);
            } else {
                ck_grAtivarSomSistema.setSelected(false); 
            }
            if(iniciarExpiao.equals("0")){ 
                ck_grAtivarExpiao.setSelected(true);
            } else {
                ck_grAtivarExpiao.setSelected(false); 
            }
            if(iniciarServidor.equals("0")){
                ck_grAtivarServidor.setSelected(true);
            } else {
                ck_grAtivarServidor.setSelected(false); 
            }
            if(ativarAgendarTarefas.equals("0")) {
                ck_grAtivarAgendarTarefas.setSelected(true);
            } else {
                ck_grAtivarAgendarTarefas.setSelected(false);
            }
            if(servico.equals("0")) {
                rd_grCliente.setSelected(true);
            } else {
                rd_grServidor.setSelected(true);
            }
            if(telaMaximizada.equals("0")) {
                ck_grTelaMaximizada.setSelected(true);
            } else {
                ck_grTelaMaximizada.setSelected(false);
            }
        }
    }

}
