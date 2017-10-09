package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.area.bean.AreaBean;
import entidades.area.facade.AreaFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.configCamera.bean.EnumAmbienteStaticoConfigCamera;
import entidades.configCamera.bean.EnumCampanhiaConfigCamera;
import entidades.configCamera.bean.EnumCorpoConfigCamera;
import entidades.configCamera.bean.EnumDispositivoConfigCamera;
import entidades.configCamera.bean.EnumFaceConfigCamera;
import entidades.configCamera.bean.EnumGravarConfigCamera;
import entidades.configCamera.bean.EnumMovimentoConfigCamera;
import entidades.configCamera.bean.EnumObjetoConfigCamera;
import entidades.configCamera.bean.EnumOlhosConfigCamera;
import entidades.configCamera.bean.EnumReconhecerFaceConfigCamera;
import entidades.configCamera.bean.EnumTipoProcessamentoConfigCamera;
import entidades.configCamera.facade.ConfigCameraFacade;
import entidades.dispositivo.bean.EnumDeletadoDispositivo;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.marca.bean.MarcaBean;
import entidades.marca.facade.MarcaFacade;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import entidades.predio.bean.PredioBean;
import entidades.predio.facade.PredioFacade;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.internacionalizacao.MensagensTelas;
import telas.comuns.camera.EscolherCameras;
import telas.comuns.telas.VisualizadorImagens;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.*;

/**
 *
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class CadastrarCamera extends javax.swing.JPanel {

    private String nomeArquivo = "";
    private Collection<AcionamentoBean> acionamentos;

    public CadastrarCamera() {
        initComponents();
        nomeiaTela();
        InstanciasTelas.setCadastrarCamera(CadastrarCamera.this);
        
        preencherComboMarcas();
        preencherComboPredio();
        tf_codigoConfig.setVisible(false); 
        conexaoLocal();
    }
    
    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
        lb_marca.setText(MensagensTelas.cad_marca());
        lb_predio.setText(MensagensTelas.cad_predio());
        lb_area.setText(MensagensTelas.cad_area());       
        rd_adaptarAmbiente.setText(MensagensTelas.com_adaptarAmbiente());
        rd_mudancaAmbiente.setText(MensagensTelas.com_mudancaAmbiente());
        ck_gravar.setText(MensagensTelas.com_gravar());
        ck_dispositivos.setText(MensagensTelas.com_acionarDispositivos());
        ck_campanhia.setText(MensagensTelas.com_campanhia());
        ck_objeto.setText(MensagensTelas.com_objeto());
        ck_face.setText(MensagensTelas.com_face());
        ck_olhos.setText(MensagensTelas.com_olhos());
        ck_corpo.setText(MensagensTelas.com_corpo());
        ck_reconhecerFace.setText(MensagensTelas.com_reconhecerFace());
        ck_ativo.setText(MensagensTelas.cad_ativo()); 
        ck_movimento.setText(MensagensTelas.com_movimento());
        ck_ambienteStatico.setText(MensagensTelas.com_ambienteStatico()); 
        rd_local.setText(MensagensTelas.cad_local());
        rd_rede.setText(MensagensTelas.cad_rede());
        lb_identificacao.setText(MensagensTelas.cad_identificacao());
        lb_porta.setText(MensagensTelas.cad_porta());
        lb_usuario.setText(MensagensTelas.cad_usuario());
        lb_senha.setText(MensagensTelas.cad_senha());
        
        pn_imagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                MensagensTelas.cad_imagem(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
        pn_acoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                MensagensTelas.com_acoes(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
        pn_pessoas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                MensagensTelas.cad_pessoas(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
        pn_tipoProcessamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                MensagensTelas.cad_tipoProcessamento(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
        pn_tipoConexao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                MensagensTelas.cad_tipoProcessamento(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
        
        tb_pane.setTitleAt(0, MensagensTelas.cad_dados());
        tb_pane.setTitleAt(1, MensagensTelas.cad_processamento());
        tb_pane.setTitleAt(2, MensagensTelas.cad_conexao()); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoMovimento = new javax.swing.ButtonGroup();
        grupoConexao = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tb_pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pn_campos = new javax.swing.JPanel();
        tf_nome = new javax.swing.JTextField();
        lb_nome = new javax.swing.JLabel();
        lb_marca = new javax.swing.JLabel();
        cb_marca = new javax.swing.JComboBox();
        lb_area = new javax.swing.JLabel();
        cb_area = new javax.swing.JComboBox();
        lb_codigo = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        lb_predio = new javax.swing.JLabel();
        cb_predio = new javax.swing.JComboBox();
        ck_ativo = new javax.swing.JCheckBox();
        pn_imagem = new javax.swing.JPanel();
        lb_imagem = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pn_pessoas = new javax.swing.JPanel();
        ck_objeto = new javax.swing.JCheckBox();
        ck_face = new javax.swing.JCheckBox();
        ck_olhos = new javax.swing.JCheckBox();
        ck_corpo = new javax.swing.JCheckBox();
        ck_reconhecerFace = new javax.swing.JCheckBox();
        pn_acoes = new javax.swing.JPanel();
        ck_gravar = new javax.swing.JCheckBox();
        ck_dispositivos = new javax.swing.JCheckBox();
        ck_campanhia = new javax.swing.JCheckBox();
        ck_movimento = new javax.swing.JCheckBox();
        ck_ambienteStatico = new javax.swing.JCheckBox();
        pn_tipoProcessamento = new javax.swing.JPanel();
        tf_codigoConfig = new javax.swing.JTextField();
        rd_adaptarAmbiente = new javax.swing.JRadioButton();
        rd_mudancaAmbiente = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lb_identificacao = new javax.swing.JLabel();
        tf_identificacao = new javax.swing.JTextField();
        bt_identificacao = new javax.swing.JButton();
        lb_usuario = new javax.swing.JLabel();
        tf_usuario = new javax.swing.JTextField();
        lb_senha = new javax.swing.JLabel();
        lb_porta = new javax.swing.JLabel();
        tf_porta = new javax.swing.JTextField();
        pw_senha = new javax.swing.JPasswordField();
        pn_tipoConexao = new javax.swing.JPanel();
        rd_local = new javax.swing.JRadioButton();
        rd_rede = new javax.swing.JRadioButton();

        tb_pane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        lb_marca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_marca.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_marca.setText("Marca:*");

        cb_marca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_marca.setToolTipText("Selecione uma Marca");

        lb_area.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_area.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_area.setText("Área:*");

        cb_area.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_area.setToolTipText("Selecione um Predio");

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_codigo.setEnabled(false);

        lb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_predio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_predio.setText("Prédio:*");

        cb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_predio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_predioActionPerformed(evt);
            }
        });

        ck_ativo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ativo.setSelected(true);
        ck_ativo.setText("Ativo");

        javax.swing.GroupLayout pn_camposLayout = new javax.swing.GroupLayout(pn_campos);
        pn_campos.setLayout(pn_camposLayout);
        pn_camposLayout.setHorizontalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_predio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_predio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_marca, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_area, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_camposLayout.createSequentialGroup()
                        .addGap(0, 172, Short.MAX_VALUE)
                        .addComponent(ck_ativo)))
                .addContainerGap())
        );
        pn_camposLayout.setVerticalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_marca)
                    .addComponent(cb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_predio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_predio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_area))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_ativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_imagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        lb_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pn_imagemLayout = new javax.swing.GroupLayout(pn_imagem);
        pn_imagem.setLayout(pn_imagemLayout);
        pn_imagemLayout.setHorizontalGroup(
            pn_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_imagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_imagemLayout.setVerticalGroup(
            pn_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_imagemLayout.createSequentialGroup()
                .addComponent(lb_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        jButton1.setToolTipText("Cancelar Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/adicionar_22x22.png"))); // NOI18N
        jButton2.setToolTipText("Adicionar Foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pn_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        tb_pane.addTab("Dados", jPanel2);

        pn_pessoas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        ck_objeto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_objeto.setSelected(true);
        ck_objeto.setText("Detectar objeto");

        ck_face.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_face.setSelected(true);
        ck_face.setText("Detectar face");

        ck_olhos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_olhos.setSelected(true);
        ck_olhos.setText("Detectar olhos");

        ck_corpo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_corpo.setSelected(true);
        ck_corpo.setText("Detectar corpo");

        ck_reconhecerFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_reconhecerFace.setText("Reconhecer Face");

        javax.swing.GroupLayout pn_pessoasLayout = new javax.swing.GroupLayout(pn_pessoas);
        pn_pessoas.setLayout(pn_pessoasLayout);
        pn_pessoasLayout.setHorizontalGroup(
            pn_pessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_pessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_objeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_face, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_olhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_corpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_reconhecerFace, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_pessoasLayout.setVerticalGroup(
            pn_pessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_objeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_face)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_olhos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_corpo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_reconhecerFace)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_acoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        ck_gravar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_gravar.setText("Gravar");

        ck_dispositivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_dispositivos.setSelected(true);
        ck_dispositivos.setText("Acionar dispositivos");

        ck_campanhia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_campanhia.setText("Campanhia");

        ck_movimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_movimento.setSelected(true);
        ck_movimento.setText("Movimento");

        ck_ambienteStatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ambienteStatico.setSelected(true);
        ck_ambienteStatico.setText("Ambiente stático");

        javax.swing.GroupLayout pn_acoesLayout = new javax.swing.GroupLayout(pn_acoes);
        pn_acoes.setLayout(pn_acoesLayout);
        pn_acoesLayout.setHorizontalGroup(
            pn_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_acoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_movimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_ambienteStatico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_gravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ck_dispositivos, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(ck_campanhia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_acoesLayout.setVerticalGroup(
            pn_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_acoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_movimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_ambienteStatico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_gravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_dispositivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_campanhia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_tipoProcessamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de processamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        tf_codigoConfig.setEnabled(false);

        grupoMovimento.add(rd_adaptarAmbiente);
        rd_adaptarAmbiente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_adaptarAmbiente.setText("Adaptar ao ambiente");

        grupoMovimento.add(rd_mudancaAmbiente);
        rd_mudancaAmbiente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_mudancaAmbiente.setText("Detectar mudança no ambiente");

        javax.swing.GroupLayout pn_tipoProcessamentoLayout = new javax.swing.GroupLayout(pn_tipoProcessamento);
        pn_tipoProcessamento.setLayout(pn_tipoProcessamentoLayout);
        pn_tipoProcessamentoLayout.setHorizontalGroup(
            pn_tipoProcessamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tipoProcessamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_adaptarAmbiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_mudancaAmbiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_codigoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_tipoProcessamentoLayout.setVerticalGroup(
            pn_tipoProcessamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tipoProcessamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rd_adaptarAmbiente)
                .addComponent(rd_mudancaAmbiente)
                .addComponent(tf_codigoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pn_tipoProcessamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pn_acoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_pessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_tipoProcessamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_acoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_pessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tb_pane.addTab("Processamento", jPanel3);

        lb_identificacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_identificacao.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_identificacao.setText("Identificação:*");

        tf_identificacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        bt_identificacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_identificacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/novo_22x22.png"))); // NOI18N
        bt_identificacao.setToolTipText("Escolher Câmera");
        bt_identificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_identificacaoActionPerformed(evt);
            }
        });

        lb_usuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_usuario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_usuario.setText("Usuário:*");

        tf_usuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_senha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_senha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_senha.setText("Senha:*");

        lb_porta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_porta.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_porta.setText("Porta:*");

        tf_porta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        pw_senha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_porta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_identificacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tf_identificacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_identificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_usuario)
                    .addComponent(tf_porta)
                    .addComponent(pw_senha))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_identificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_identificacao)
                        .addComponent(tf_identificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_porta)
                    .addComponent(tf_porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_usuario)
                    .addComponent(tf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_senha)
                    .addComponent(pw_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pn_tipoConexao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de conexão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        grupoConexao.add(rd_local);
        rd_local.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_local.setSelected(true);
        rd_local.setText("Local ");
        rd_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_localActionPerformed(evt);
            }
        });

        grupoConexao.add(rd_rede);
        rd_rede.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_rede.setText("Rede");
        rd_rede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_redeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_tipoConexaoLayout = new javax.swing.GroupLayout(pn_tipoConexao);
        pn_tipoConexao.setLayout(pn_tipoConexaoLayout);
        pn_tipoConexaoLayout.setHorizontalGroup(
            pn_tipoConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tipoConexaoLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(rd_local)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_rede)
                .addGap(96, 96, 96))
        );
        pn_tipoConexaoLayout.setVerticalGroup(
            pn_tipoConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tipoConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rd_local)
                .addComponent(rd_rede))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_tipoConexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_tipoConexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tb_pane.addTab("Conexão", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lb_imagem.setIcon(null);
        nomeArquivo = "";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VisualizadorImagens dialog = new VisualizadorImagens(null, true, ArquivosImagens.diretorio_cameras(), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_identificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_identificacaoActionPerformed
        if(!InstanciasControle.getIniciarCameras().getStatus()) {
            escolherCameras();
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadCamerasOcupadas());
        }
    }//GEN-LAST:event_bt_identificacaoActionPerformed

    private void cb_predioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_predioActionPerformed
        preencherComboAreaPorPredio();
    }//GEN-LAST:event_cb_predioActionPerformed

    private void rd_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_localActionPerformed
        conexaoLocal();
    }//GEN-LAST:event_rd_localActionPerformed

    private void rd_redeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_redeActionPerformed
        conexaoRede();
    }//GEN-LAST:event_rd_redeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_identificacao;
    private javax.swing.JComboBox cb_area;
    private javax.swing.JComboBox cb_marca;
    private javax.swing.JComboBox cb_predio;
    private javax.swing.JCheckBox ck_ambienteStatico;
    private javax.swing.JCheckBox ck_ativo;
    private javax.swing.JCheckBox ck_campanhia;
    private javax.swing.JCheckBox ck_corpo;
    private javax.swing.JCheckBox ck_dispositivos;
    private javax.swing.JCheckBox ck_face;
    private javax.swing.JCheckBox ck_gravar;
    private javax.swing.JCheckBox ck_movimento;
    private javax.swing.JCheckBox ck_objeto;
    private javax.swing.JCheckBox ck_olhos;
    private javax.swing.JCheckBox ck_reconhecerFace;
    private javax.swing.ButtonGroup grupoConexao;
    private javax.swing.ButtonGroup grupoMovimento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_area;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_identificacao;
    private javax.swing.JLabel lb_imagem;
    private javax.swing.JLabel lb_marca;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_porta;
    private javax.swing.JLabel lb_predio;
    private javax.swing.JLabel lb_senha;
    private javax.swing.JLabel lb_usuario;
    private javax.swing.JPanel pn_acoes;
    private javax.swing.JPanel pn_campos;
    private javax.swing.JPanel pn_imagem;
    private javax.swing.JPanel pn_pessoas;
    private javax.swing.JPanel pn_tipoConexao;
    private javax.swing.JPanel pn_tipoProcessamento;
    private javax.swing.JPasswordField pw_senha;
    private javax.swing.JRadioButton rd_adaptarAmbiente;
    private javax.swing.JRadioButton rd_local;
    private javax.swing.JRadioButton rd_mudancaAmbiente;
    private javax.swing.JRadioButton rd_rede;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_codigoConfig;
    private javax.swing.JTextField tf_identificacao;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_porta;
    private javax.swing.JTextField tf_usuario;
    // End of variables declaration//GEN-END:variables

    private void conexaoLocal() {
        lb_identificacao.setText(MensagensTelas.cad_identificacao());
        bt_identificacao.setVisible(true);
        lb_porta.setVisible(false); 
        tf_porta.setVisible(false);
        lb_usuario.setVisible(false);
        tf_usuario.setVisible(false);
        lb_senha.setVisible(false);
        pw_senha.setVisible(false);
    }
    
    private void conexaoRede() {
        lb_identificacao.setText(MensagensTelas.cad_ip());
        bt_identificacao.setVisible(false);
        lb_porta.setVisible(true); 
        tf_porta.setVisible(true);
        lb_usuario.setVisible(true);
        tf_usuario.setVisible(true);
        lb_senha.setVisible(true);
        pw_senha.setVisible(true);
    }
    
    private void escolherCameras() {
        String valor = InstanciasControle.getMensagens().inserirDados(MensagensSoltas.cadCameraCameras());
        if(valor != null && validar(valor)) {
            Integer qtdeCameras = Integer.parseInt(valor); 
            if(qtdeCameras > 0) {
                EscolherCameras dialog = new EscolherCameras(null, true, this);
                dialog.preparaCameras(qtdeCameras);
                dialog.setVisible(true);
            } else {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.cadCameraQuantidade()); 
            }
        }
    }
    
    private boolean validar(String valor) {
        if (Validacao.verificaStringVazia(valor)) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadCameraValor());
            return false;
        } else if (!Validacao.verificaNumeroInteger(valor)) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadCameraNumero());
            return false;
        }
        return true;
    }
    
    ///////////METODOS DE VERIFICAÇÃO//////////////////////////////////////////
    private Boolean verificaNomeExiste() {
        for (CameraBean camera : listaCameraOrdenadaPorCodigo()) {
            if (!tf_codigo.getText().equals(camera.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(camera.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaNomeIgualDispositivoEletrico() {
        for (DispositivoEletricoBean dispositivo : listaDispositivoEletricoOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(dispositivo.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(dispositivo.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaNomeIgualModuloAcionamento() {
        for (ModuloAcionamentoBean modulo : listaModuloAcionamentoOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(modulo.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(modulo.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }
    ///////////FIM METODOS DE VERIFICAÇÃO//////////////////////////////////////////

    private void preencherComboMarcas() {
        cb_marca.removeAllItems();
        cb_marca.addItem(MensagensTelas.cad_selecionarMarca());
        for (MarcaBean marca : listaMarcas()) {
            cb_marca.addItem(marca);
        }
    }

    private void preencherComboPredio() {
        cb_predio.removeAllItems();
        cb_predio.addItem(MensagensTelas.cad_selecionarPredio());
        for (PredioBean predio : listaPredio()) {
            cb_predio.addItem(predio);
        }
    }

    private void preencherComboAreaPorPredio() {
        if (cb_predio.getSelectedIndex() > 0) {
            cb_area.removeAllItems();
            cb_area.addItem(MensagensTelas.cad_selecionarArea());
            for (AreaBean areaBean : listarAreaPorPredio()) {
                cb_area.addItem(areaBean);
            }
        }
    }

    private Boolean validaCampos() {
        if (Validacao.verificaStringVazia(tf_nome.getText())) {
            tf_nome.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeVazio());
            return false;
        } else if (verificaNomeExiste()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeExiste());
            return false;
        } else if (verificaNomeIgualDispositivoEletrico()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeDispositivoEletrico());
            return false;
        } else if (verificaNomeIgualModuloAcionamento()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeModuloAcionamento());
            return false;
        } else if (Validacao.verificaStringVazia(tf_identificacao.getText())) {
            tf_identificacao.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadCameraIdentificacaoVazia());
            return false;
        } else if (cb_marca.getSelectedIndex() == 0) {
            cb_marca.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumMarca());
            return false;
        } else if (cb_predio.getSelectedIndex() == 0) {
            cb_predio.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumPredio());
            return false;
        } else if (cb_area.getSelectedIndex() == 0) {
            cb_area.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumArea());
            return false;
        } else if (nomeArquivo.equals("")) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumImagem());
            return false;
        }

        return true;
    }

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_campos);
        cb_area.setSelectedIndex(0);
        cb_predio.setSelectedIndex(0);
        cb_marca.setSelectedIndex(0);
        nomeArquivo = "";
        lb_imagem.setIcon(null);
    }

    public void preencherCampos(CameraBean camera) {
        tf_codigo.setText(camera.getCodigo().toString());
        tf_nome.setText(camera.getNome());
        SwingUtil.selecionaItemCombo(camera.getArea().getPredio(), cb_predio);
        SwingUtil.selecionaItemCombo(camera.getArea(), cb_area);
        SwingUtil.selecionaItemCombo(camera.getMarcaBean(), cb_marca);
        nomeArquivo = camera.getFoto();
        lb_imagem.setIcon(new ImageIcon(ArquivosImagens.diretorio_cameras()+File.separator+camera.getFoto()));
        if(camera.getStatus() == EnumStatusDispositivo.ATIVO) {
            ck_ativo.setSelected(true);
        } else {
            ck_ativo.setSelected(false); 
        }
        tf_codigoConfig.setText(camera.getConfigCamera().getCodigo().toString()); 
        if(camera.getConfigCamera().getTipoProcessamento() == EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE) {
            rd_adaptarAmbiente.setSelected(true);
        } else {
            rd_mudancaAmbiente.setSelected(true); 
        }
        if(camera.getConfigCamera().getMovimento() == EnumMovimentoConfigCamera.SIM) {
            ck_movimento.setSelected(true); 
        } else {
            ck_movimento.setSelected(false); 
        }
        if(camera.getConfigCamera().getAmbienteStatico() == EnumAmbienteStaticoConfigCamera.SIM) {
            ck_ambienteStatico.setSelected(true);
        } else {
            ck_ambienteStatico.setSelected(false); 
        }
        if(camera.getConfigCamera().getGravar() == EnumGravarConfigCamera.SIM) {
            ck_gravar.setSelected(true); 
        } else {
            ck_gravar.setSelected(false); 
        }
        if(camera.getConfigCamera().getDispositivo() == EnumDispositivoConfigCamera.SIM) {
            ck_dispositivos.setSelected(true); 
        } else {
            ck_dispositivos.setSelected(false); 
        }
        if(camera.getConfigCamera().getCampanhia() == EnumCampanhiaConfigCamera.SIM) {
            ck_campanhia.setSelected(true); 
        } else {
            ck_campanhia.setSelected(false); 
        }
        if(camera.getConfigCamera().getObjeto() == EnumObjetoConfigCamera.SIM) {
            ck_objeto.setSelected(true); 
        } else {
            ck_objeto.setSelected(false); 
        }
        if(camera.getConfigCamera().getFace() == EnumFaceConfigCamera.SIM) {
            ck_face.setSelected(true); 
        } else {
            ck_face.setSelected(false); 
        }
        if(camera.getConfigCamera().getOlhos() == EnumOlhosConfigCamera.SIM) {
            ck_olhos.setSelected(true); 
        } else {
            ck_olhos.setSelected(false); 
        }
        if(camera.getConfigCamera().getCorpo() == EnumCorpoConfigCamera.SIM) {
            ck_corpo.setSelected(true); 
        } else {
            ck_corpo.setSelected(false); 
        }
        if(camera.getConfigCamera().getReconhecerFace() == EnumReconhecerFaceConfigCamera.SIM) {
            ck_reconhecerFace.setSelected(true); 
        } else {
            ck_reconhecerFace.setSelected(false); 
        }
        acionamentos = camera.getAcionamentos();
        tf_identificacao.setText(camera.getIdentificacao());
        System.out.println(camera.getIdentificacao());
        if(camera.getPorta() != null) {
            tf_porta.setText(camera.getPorta().toString());
            tf_usuario.setText(camera.getUsuario());
            pw_senha.setText(camera.getSenha());
            rd_rede.setSelected(true);
            conexaoRede();
        } else {
            rd_local.setSelected(true);
            conexaoLocal();
        }
    }

    /////////////// METODOS PARA POPULAR ENTIDADES//////////////////////////////
    private ConfigCameraBean popularConfigCamera() {
        ConfigCameraBean configCamera = new ConfigCameraBean();

        if(!tf_codigoConfig.getText().equals("")) {
            configCamera.setCodigo(Integer.parseInt(tf_codigoConfig.getText())); 
        }
        if(rd_adaptarAmbiente.isSelected()) {
            configCamera.setTipoProcessamento(EnumTipoProcessamentoConfigCamera.ADAPTAR_AMBIENTE);
        }
        if(rd_mudancaAmbiente.isSelected()) {
            configCamera.setTipoProcessamento(EnumTipoProcessamentoConfigCamera.AMBIENTE_STATICO);
        }
        if(ck_movimento.isSelected()) {
            configCamera.setMovimento(EnumMovimentoConfigCamera.SIM);
        } else {
            configCamera.setMovimento(EnumMovimentoConfigCamera.NAO);
        }
        if(ck_ambienteStatico.isSelected()) {
            configCamera.setAmbienteStatico(EnumAmbienteStaticoConfigCamera.SIM);
        } else {
            configCamera.setAmbienteStatico(EnumAmbienteStaticoConfigCamera.NAO); 
        }
        if(ck_objeto.isSelected()) {
            configCamera.setObjeto(EnumObjetoConfigCamera.SIM);
        } else {
            configCamera.setObjeto(EnumObjetoConfigCamera.NAO);
        }
        if(ck_dispositivos.isSelected()) {
            configCamera.setDispositivo(EnumDispositivoConfigCamera.SIM); 
        } else {
            configCamera.setDispositivo(EnumDispositivoConfigCamera.NAO); 
        }
        if(ck_campanhia.isSelected()) {
            configCamera.setCampanhia(EnumCampanhiaConfigCamera.SIM);
        } else {
            configCamera.setCampanhia(EnumCampanhiaConfigCamera.NAO);
        }
        if(ck_gravar.isSelected()) {
            configCamera.setGravar(EnumGravarConfigCamera.SIM); 
        } else {
            configCamera.setGravar(EnumGravarConfigCamera.NAO); 
        }
        if(ck_face.isSelected()) {
            configCamera.setFace(EnumFaceConfigCamera.SIM);
        } else {
            configCamera.setFace(EnumFaceConfigCamera.NAO);
        }
        if(ck_olhos.isSelected()) {
            configCamera.setOlhos(EnumOlhosConfigCamera.SIM);
        } else {
            configCamera.setOlhos(EnumOlhosConfigCamera.NAO);
        }
        if(ck_corpo.isSelected()) {
            configCamera.setCorpo(EnumCorpoConfigCamera.SIM);
        } else {
            configCamera.setCorpo(EnumCorpoConfigCamera.NAO);
        }
        if(ck_reconhecerFace.isSelected()) {
            configCamera.setReconhecerFace(EnumReconhecerFaceConfigCamera.SIM);
        } else {
            configCamera.setReconhecerFace(EnumReconhecerFaceConfigCamera.NAO);
        }
        return configCamera;
    }

    private CameraBean populaCamera(ConfigCameraBean configCamera) {
        CameraBean camera = new CameraBean();

        if (!tf_codigo.getText().equals("")) {
            camera.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        camera.setArea((AreaBean) cb_area.getSelectedItem());
        camera.setConfigCamera(configCamera);
        camera.setDeletado(EnumDeletadoDispositivo.NAO);
        camera.setFoto(nomeArquivo);
        camera.setMarcaBean((MarcaBean) cb_marca.getSelectedItem());
        camera.setNome(tf_nome.getText().toUpperCase());
        if(ck_ativo.isSelected()) {
            camera.setStatus(EnumStatusDispositivo.ATIVO);
        } else {
            camera.setStatus(EnumStatusDispositivo.INATIVO);
        }
        if(acionamentos != null) {
            camera.setAcionamentos(acionamentos); 
        }
        camera.setIdentificacao(tf_identificacao.getText());
        if(rd_rede.isSelected()) {
            camera.setPorta(Integer.parseInt(tf_porta.getText()));
            camera.setUsuario(tf_usuario.getText());
            camera.setSenha(pw_senha.getText());
        }

        return camera;
    } 

    ///////////////FIM METODOS PARA INSERIR NO BANCO//////////////////////////
    public void salvar() {
        if (validaCampos()) {
            ConfigCameraBean configCamera = inserirConfigCamera(popularConfigCamera());
            if (inserirCamera(populaCamera(configCamera)) != null) {
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadCameraSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                AtualizaTelas.pesquisarCamera();
                AtualizaTelas.geralMapaDispositivos();
            } 
        }
    }

    public void exibirImagem(BufferedImage buffer, String nomeArquivo) {
        lb_imagem.setIcon(new ImageIcon(ImagemUtil.bufferedImageParaImage(buffer)));
        this.nomeArquivo = nomeArquivo;
    }
    
    public void setIdentificacao(Integer identificacao) {
        tf_identificacao.setText(identificacao.toString());
    }
    
    public void atualizarTela() {
        preencherComboMarcas();
        preencherComboPredio();
        preencherComboAreaPorPredio();
    }
    
    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros()+ArquivosHTML.camera());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<ModuloAcionamentoBean> listaModuloAcionamentoOrdenadoPorCodigo() {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return moduloAcionamentoFacade.listarModuloAcionamentoOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<CameraBean> listaCameraOrdenadaPorCodigo() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<DispositivoEletricoBean> listaDispositivoEletricoOrdenadoPorCodigo() {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.listarDispositivoEletricoOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<MarcaBean> listaMarcas() {
        MarcaFacade marcaFacade = FactoryFacade.getMarcaImpl();
        try {
            return (ArrayList<MarcaBean>) marcaFacade.listarMarcaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<AreaBean> listarAreaPorPredio() {
        AreaFacade areaFacade = FactoryFacade.getAreaImpl();
        try {
            return areaFacade.pesquisarAreaPorPredio((PredioBean) cb_predio.getSelectedItem());
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<PredioBean> listaPredio() {
        PredioFacade predioFacade = FactoryFacade.getPredioImpl();
        try {
            return (ArrayList<PredioBean>) predioFacade.listar();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private CameraBean inserirCamera(CameraBean camera) {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.insereOuAltera(camera);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ConfigCameraBean inserirConfigCamera(ConfigCameraBean bean) {
        ConfigCameraFacade configCameraFacade = FactoryFacade.getConfigCameraImpl();
        try {
            return configCameraFacade.insereOuAltera(bean);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
