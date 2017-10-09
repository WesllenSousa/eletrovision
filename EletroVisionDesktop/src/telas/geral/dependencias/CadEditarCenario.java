
package telas.geral.dependencias;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
import entidades.predio.bean.PredioBean;
import entidades.predio.facade.PredioFacade;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.telas.VisualizadorImagens;
import telas.geral.GeralCenario;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;
import util.Validacao;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class CadEditarCenario extends javax.swing.JDialog {
    
    private GeralCenario cenario;
    private Integer insereAltera; //0-cadastrar, 1-editar
    
    private DefaultListModel<DispositivoEletricoBean> modeloDispositivosEletrico;
    private DefaultListModel<DispositivoEletricoBean> modeloDispositivosAdicionados;
    private DefaultListModel<CameraBean> modeloCamera;
    private DefaultListModel<CameraBean> modeloCamerasAdicionadas;
    
    private String nomeArquivo = "";
    
    public CadEditarCenario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pn_vinculoCameras.setVisible(false);
        cb_predio.setVisible(false);
        
        preencherComboPredio();
        preparaListaDispositivosEletricos();
        preparaListaCameras();
        carregaTodosDispositivosEletricos();
        carregaTodasCameras();
        insereAltera = 0;
    }
    
    public CadEditarCenario(java.awt.Frame parent, boolean modal, GeralCenario cenario, Integer status) {
        super(parent, modal);
        initComponents();
        cb_predio.setVisible(false);
        
        preencherComboPredio();
        preparaListaDispositivosEletricos();
        preparaListaCameras();
        
        this.insereAltera = status;
        this.cenario = cenario;
        
        if(this.insereAltera == 1){
            preencherCampos();
            carregaDispositivosEletricosDesteCenario(); 
            separaDispositivosEletricos();
            carregaCamerasDesteCenario();
            separaCameras();
        } else {
            pn_vinculoCameras.setVisible(false);
            carregaTodosDispositivosEletricos();
            carregaTodasCameras();
            exibirImagem(ImagemUtil.redimencionar(ImagemUtil.ler(ArquivosImagens.sistema_semImagem()), 32, 32), nomeArquivo);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoStatus = new javax.swing.ButtonGroup();
        grupoTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        pn_principal = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        rd_ativar = new javax.swing.JRadioButton();
        rd_desativar = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        ck_vincularCamera = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lt_listaDispositivosEletricos = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bt_ir = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lt_listaDispositivosAdicionados = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        pn_vinculoCameras = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lt_listaCameras = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        bt_ir1 = new javax.swing.JButton();
        bt_voltar1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lt_listaCamerasAdicionadas = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rd_controleAutomatico = new javax.swing.JRadioButton();
        rd_detectarPessoas = new javax.swing.JRadioButton();
        rd_reconhecerFaces = new javax.swing.JRadioButton();
        rd_alarme = new javax.swing.JRadioButton();
        cb_predio = new javax.swing.JComboBox();
        rd_movimento = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lb_imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Cenário");

        jPanel1.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/logo.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/midia/casa_128x128.png"))); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.setToolTipText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        jLabel3.setText("* : Campos Obrigatórios");

        jButton6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        jButton6.setText("Fechar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton2))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pn_principal.setName("PainelPrincipal"); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Nome:*");

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        grupoStatus.add(rd_ativar);
        rd_ativar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_ativar.setSelected(true);
        rd_ativar.setText("Ativar");

        grupoStatus.add(rd_desativar);
        rd_desativar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_desativar.setText("Desativar");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Status:*");

        ck_vincularCamera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_vincularCamera.setText("Vincular Câmera");
        ck_vincularCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_vincularCameraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rd_ativar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rd_desativar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ck_vincularCamera))
                    .addComponent(tf_nome))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_desativar)
                    .addComponent(rd_ativar)
                    .addComponent(jLabel5)
                    .addComponent(ck_vincularCamera))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jScrollPane2.setViewportView(lt_listaDispositivosEletricos);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Dispositivos Elétricos");

        bt_ir.setText(">");
        bt_ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_irActionPerformed(evt);
            }
        });

        bt_voltar.setText("<");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_ir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(bt_ir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_voltar)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(lt_listaDispositivosAdicionados);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Adicionados");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(lt_listaCameras);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Câmeras");

        bt_ir1.setText(">");
        bt_ir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ir1ActionPerformed(evt);
            }
        });

        bt_voltar1.setText("<");
        bt_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_ir1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(bt_ir1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_voltar1)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(lt_listaCamerasAdicionadas);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Adicionados");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Tipo do acionamento:");

        grupoTipo.add(rd_controleAutomatico);
        rd_controleAutomatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_controleAutomatico.setText("Controle Automático");
        rd_controleAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_controleAutomaticoActionPerformed(evt);
            }
        });

        grupoTipo.add(rd_detectarPessoas);
        rd_detectarPessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_detectarPessoas.setSelected(true);
        rd_detectarPessoas.setText("Detectar Pessoas");
        rd_detectarPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_detectarPessoasActionPerformed(evt);
            }
        });

        grupoTipo.add(rd_reconhecerFaces);
        rd_reconhecerFaces.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_reconhecerFaces.setText("Reconhecer Faces");
        rd_reconhecerFaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_reconhecerFacesActionPerformed(evt);
            }
        });

        grupoTipo.add(rd_alarme);
        rd_alarme.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_alarme.setText("Alarme");
        rd_alarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_alarmeActionPerformed(evt);
            }
        });

        cb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        grupoTipo.add(rd_movimento);
        rd_movimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rd_movimento.setText("Movimento");
        rd_movimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_movimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_vinculoCamerasLayout = new javax.swing.GroupLayout(pn_vinculoCameras);
        pn_vinculoCameras.setLayout(pn_vinculoCamerasLayout);
        pn_vinculoCamerasLayout.setHorizontalGroup(
            pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_vinculoCamerasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_vinculoCamerasLayout.createSequentialGroup()
                        .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11)
                    .addGroup(pn_vinculoCamerasLayout.createSequentialGroup()
                        .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rd_movimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rd_controleAutomatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_vinculoCamerasLayout.createSequentialGroup()
                                .addComponent(rd_detectarPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rd_reconhecerFaces, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_vinculoCamerasLayout.createSequentialGroup()
                                .addComponent(rd_alarme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_predio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_vinculoCamerasLayout.setVerticalGroup(
            pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_vinculoCamerasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_controleAutomatico)
                    .addComponent(rd_detectarPessoas)
                    .addComponent(rd_reconhecerFaces, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_alarme)
                    .addComponent(cb_predio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_movimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_vinculoCamerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_vinculoCameras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_vinculoCameras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        jButton1.setToolTipText("Cancelar Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/adicionar_22x22.png"))); // NOI18N
        jButton3.setToolTipText("Adicionar Foto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        lb_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(lb_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_principalLayout = new javax.swing.GroupLayout(pn_principal);
        pn_principal.setLayout(pn_principalLayout);
        pn_principalLayout.setHorizontalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_principalLayout.setVerticalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_principalLayout.createSequentialGroup()
                .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_principalLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 304, Short.MAX_VALUE))
                    .addGroup(pn_principalLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setBounds((screenSize.width-927)/2, (screenSize.height-604)/2, 927, 604);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salvar();
    }//GEN-LAST:event_jButton2ActionPerformed

private void bt_irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_irActionPerformed
        if(!lt_listaDispositivosEletricos.isSelectionEmpty()) {
            DispositivoEletricoBean dispositivoEletrico = (DispositivoEletricoBean) lt_listaDispositivosEletricos.getSelectedValue();
            Integer indice = lt_listaDispositivosEletricos.getSelectedIndex();
            modeloDispositivosAdicionados.addElement(dispositivoEletrico);
            modeloDispositivosEletrico.removeElementAt(indice);
            lt_listaDispositivosEletricos.clearSelection();
        }
}//GEN-LAST:event_bt_irActionPerformed

private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        if(!lt_listaDispositivosAdicionados.isSelectionEmpty()) {
            DispositivoEletricoBean dispositivoEletrico = (DispositivoEletricoBean) lt_listaDispositivosAdicionados.getSelectedValue();
            Integer indice = lt_listaDispositivosAdicionados.getSelectedIndex();
            modeloDispositivosEletrico.addElement(dispositivoEletrico);
            modeloDispositivosAdicionados.removeElementAt(indice);
            lt_listaDispositivosAdicionados.clearSelection();
        }
}//GEN-LAST:event_bt_voltarActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
}//GEN-LAST:event_jButton6ActionPerformed

    private void bt_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar1ActionPerformed
        if (!lt_listaCamerasAdicionadas.isSelectionEmpty()) {
            CameraBean camera = (CameraBean) lt_listaCamerasAdicionadas.getSelectedValue();
            Integer indice = lt_listaCamerasAdicionadas.getSelectedIndex();
            modeloCamera.addElement(camera);
            modeloCamerasAdicionadas.removeElementAt(indice);
            lt_listaCamerasAdicionadas.clearSelection();
        }
    }//GEN-LAST:event_bt_voltar1ActionPerformed

    private void bt_ir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ir1ActionPerformed
        if (!lt_listaCameras.isSelectionEmpty()) {
            CameraBean camera = (CameraBean) lt_listaCameras.getSelectedValue();
            Integer indice = lt_listaCameras.getSelectedIndex();
            modeloCamerasAdicionadas.addElement(camera);
            modeloCamera.removeElementAt(indice);
            lt_listaCameras.clearSelection();
        }
    }//GEN-LAST:event_bt_ir1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lb_imagem.setIcon(null);
        nomeArquivo = "";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        VisualizadorImagens dialog = new VisualizadorImagens(null, true, ArquivosImagens.diretorio_cenario(), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ck_vincularCameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_vincularCameraMouseClicked
        if(ck_vincularCamera.isSelected()) {
            pn_vinculoCameras.setVisible(true);
        } else {
            pn_vinculoCameras.setVisible(false);
        }
    }//GEN-LAST:event_ck_vincularCameraMouseClicked

    private void rd_controleAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_controleAutomaticoActionPerformed
        cb_predio.setVisible(false);
    }//GEN-LAST:event_rd_controleAutomaticoActionPerformed

    private void rd_detectarPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_detectarPessoasActionPerformed
        cb_predio.setVisible(false);
    }//GEN-LAST:event_rd_detectarPessoasActionPerformed

    private void rd_reconhecerFacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_reconhecerFacesActionPerformed
        cb_predio.setVisible(false);
    }//GEN-LAST:event_rd_reconhecerFacesActionPerformed

    private void rd_alarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_alarmeActionPerformed
        cb_predio.setVisible(true);
    }//GEN-LAST:event_rd_alarmeActionPerformed

    private void rd_movimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_movimentoActionPerformed
        cb_predio.setVisible(false);
    }//GEN-LAST:event_rd_movimentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ir;
    private javax.swing.JButton bt_ir1;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JButton bt_voltar1;
    private javax.swing.JComboBox cb_predio;
    private javax.swing.JCheckBox ck_vincularCamera;
    private javax.swing.ButtonGroup grupoStatus;
    private javax.swing.ButtonGroup grupoTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lb_imagem;
    private javax.swing.JList lt_listaCameras;
    private javax.swing.JList lt_listaCamerasAdicionadas;
    private javax.swing.JList lt_listaDispositivosAdicionados;
    private javax.swing.JList lt_listaDispositivosEletricos;
    public javax.swing.JPanel pn_principal;
    private javax.swing.JPanel pn_vinculoCameras;
    private javax.swing.JRadioButton rd_alarme;
    private javax.swing.JRadioButton rd_ativar;
    private javax.swing.JRadioButton rd_controleAutomatico;
    private javax.swing.JRadioButton rd_desativar;
    private javax.swing.JRadioButton rd_detectarPessoas;
    private javax.swing.JRadioButton rd_movimento;
    private javax.swing.JRadioButton rd_reconhecerFaces;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables

    private void preencherCampos() {
        if(cenario.acionamentoSelecionado.getTipo() == EnumTipoAcionamento.NENHUM_ACIONAMENTO) {
            pn_vinculoCameras.setVisible(false);
        } else { 
            pn_vinculoCameras.setVisible(true);
            ck_vincularCamera.setSelected(true);
            if(cenario.acionamentoSelecionado.getTipo() == EnumTipoAcionamento.CONTROLE_AUTOMATICO) {
                rd_controleAutomatico.setSelected(true);
            } else if(cenario.acionamentoSelecionado.getTipo() == EnumTipoAcionamento.DETECTAR_PESSOAS) {
                rd_detectarPessoas.setSelected(true);
            } else if(cenario.acionamentoSelecionado.getTipo() == EnumTipoAcionamento.RECONHECER_FACES) {
                rd_reconhecerFaces.setSelected(true);
            } else if(cenario.acionamentoSelecionado.getTipo() == EnumTipoAcionamento.ALARME) {
                rd_alarme.setSelected(true);
                cb_predio.setVisible(true);
            } else if(cenario.acionamentoSelecionado.getTipo() == EnumTipoAcionamento.MOVIMENTO) {
                rd_movimento.setSelected(true); 
            }
        }
        tf_nome.setText(cenario.acionamentoSelecionado.getNome());
        if(cenario.acionamentoSelecionado.getStatus() == EnumStatusAcionamento.ATIVO) {
            rd_ativar.setSelected(true);
        } else {
            rd_desativar.setSelected(true);
        }
        exibirImagem(ImagemUtil.ler(ArquivosImagens.diretorio_cenario()+File.separator+cenario.acionamentoSelecionado.getFoto()),
                    cenario.acionamentoSelecionado.getFoto());
        if(cenario.acionamentoSelecionado.getPredio() != null) {
            selecionaPredio(cenario.acionamentoSelecionado.getPredio());
        }
    }
    
    private void selecionaPredio(PredioBean predio) {
        PredioBean c;
        for (int i = 0; i < cb_predio.getItemCount(); i++) {
            if (i > 0) {
                c = (PredioBean) cb_predio.getItemAt(i);
                if (c.toString().equals(predio.toString())) {
                    cb_predio.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private AcionamentoBean salvarAcionamento(AcionamentoBean acionamento) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.insereOuAltera(acionamento);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private void salvarItemAcionamentos(ItemAcionamentoBean itemAcionamento) {
        ItemAcionamentoFacade itemAcionamentoFacade = FactoryFacade.getItemAcionamentoImpl();
        try {
            itemAcionamentoFacade.insereOuAltera(itemAcionamento);
        } catch (FacadeException ex) {
        }
    }
    
    private Boolean deletarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) {
        ItemAcionamentoFacade itemAcionamentoFacade = FactoryFacade.getItemAcionamentoImpl();
        try {
            return itemAcionamentoFacade.deletarItemAcionamentoPorAcionamento(acionamento);
        } catch (FacadeException ex) {
        }
        return false;
    }
    
    private ArrayList<DispositivoEletricoBean> listarDispositivoEletricoNaoDeletado() {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.listarDispositivoEletricoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<CameraBean> listarCamerasNaoDeletada() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraNaoDeletada();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) {
        ItemAcionamentoFacade itemAcionamentoFacade = FactoryFacade.getItemAcionamentoImpl();
        try {
            return itemAcionamentoFacade.listarItemAcionamentoPorAcionamento(acionamento);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private AcionamentoBean selecionaAcionamentoPorNome(String nome) {
        AcionamentoFacade acionamentoFacade = FactoryFacade.getAcionamentoImpl();
        try {
            return acionamentoFacade.selecionaAcionamentoPorNome(nome);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<PredioBean> listarPredioNaoDeletado() {
        PredioFacade predioFacade = FactoryFacade.getPredioImpl();
        try {
            return predioFacade.listarPredioNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
   /*
 *  ===============REGRA DE NEGOCIO=========================================
 */
    
    private void preparaListaDispositivosEletricos() {
        modeloDispositivosEletrico = new DefaultListModel<>();
        lt_listaDispositivosEletricos.setModel(modeloDispositivosEletrico);
        modeloDispositivosAdicionados = new DefaultListModel<>();
        lt_listaDispositivosAdicionados.setModel(modeloDispositivosAdicionados);
    }
    
    private void preparaListaCameras() {
        modeloCamera = new DefaultListModel<>();
        lt_listaCameras.setModel(modeloCamera);
        modeloCamerasAdicionadas = new DefaultListModel<>();
        lt_listaCamerasAdicionadas.setModel(modeloCamerasAdicionadas);
    }
    
    private void carregaTodosDispositivosEletricos() {
        ArrayList<DispositivoEletricoBean> lista = listarDispositivoEletricoNaoDeletado();
        for(DispositivoEletricoBean dp : lista) {
            modeloDispositivosEletrico.addElement(dp);
        }
    }

    private void carregaDispositivosEletricosDesteCenario() {
        ArrayList<ItemAcionamentoBean> itens = listarItemAcionamentoPorAcionamento(cenario.acionamentoSelecionado);
        for(ItemAcionamentoBean item : itens) {
            modeloDispositivosAdicionados.addElement(item.getDispositivoEletrico());
        }
    }
    
    private void separaDispositivosEletricos() {
        modeloDispositivosEletrico.clear();
        DispositivoEletricoBean[] adicionados = new DispositivoEletricoBean[modeloDispositivosAdicionados.getSize()];
        ArrayList<DispositivoEletricoBean> lista = listarDispositivoEletricoNaoDeletado();
        for(DispositivoEletricoBean modulo : lista) {
            Boolean status = true;
            for(int i = 0; i < modeloDispositivosAdicionados.size(); i++) {
                adicionados[i] = modeloDispositivosAdicionados.getElementAt(i);
                if(adicionados[i].getCodigo() == modulo.getCodigo()) {
                    status = false;
                    break;
                }
            }
            if(status) {
                modeloDispositivosEletrico.addElement(modulo);
            }
        }
    }
    
    private void carregaTodasCameras() {
        ArrayList<CameraBean> lista = listarCamerasNaoDeletada();
        for(CameraBean cm : lista) {
            modeloCamera.addElement(cm);
        }
    }

    private void carregaCamerasDesteCenario() {
        for(CameraBean camera : cenario.acionamentoSelecionado.getCameras()) {
            modeloCamerasAdicionadas.addElement(camera);
        }
    }
    
    private void separaCameras() {
        modeloCamera.clear();
        CameraBean[] adicionados = new CameraBean[modeloCamerasAdicionadas.getSize()];
        ArrayList<CameraBean> lista = listarCamerasNaoDeletada();
        for(CameraBean modulo : lista) {
            Boolean status = true;
            for(int i = 0; i < modeloCamerasAdicionadas.size(); i++) {
                adicionados[i] = modeloCamerasAdicionadas.getElementAt(i);
                if(adicionados[i].getCodigo() == modulo.getCodigo()) {
                    status = false;
                    break;
                }
            }
            if(status) {
                modeloCamera.addElement(modulo);
            }
        }
    }
    
    private Boolean validaCampos(){
        if(Validacao.verificaStringVazia(tf_nome.getText())) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioNome());
            return false;
        } else if(nomeArquivo.equals("")) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioImagem());
            return false;
        }  else if(modeloDispositivosAdicionados.isEmpty()) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioDispositivoEletrico());
            return false;
        } else if(insereAltera == 0 && selecionaAcionamentoPorNome(tf_nome.getText()) != null) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioNomeExiste());
            return false;
        } else if(rd_alarme.isSelected() && cb_predio.getSelectedIndex() == 0) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerCenarioPredio());
            return false;
        }
        
        return true;
    }
    
    private AcionamentoBean populaAcionamentoBean() {
        AcionamentoBean bean = new AcionamentoBean();
        
        if(insereAltera == 1){
            bean.setCodigo(cenario.acionamentoSelecionado.getCodigo());
        }
        bean.setNome(tf_nome.getText());
        bean.setFoto(nomeArquivo);
        bean.setDeletado(EnumDeletadoAcionamento.NAO);
        if(rd_ativar.isSelected()) {
            bean.setStatus(EnumStatusAcionamento.ATIVO);
        } else {
            bean.setStatus(EnumStatusAcionamento.INATIVO);
        }
        bean.setCameras(obtemCamerasAdicionadas()); 
        bean.setLigarDesligar(EnumLigarDesligarAcionamento.DESLIGADO); 
        if(ck_vincularCamera.isSelected()) {
            if(rd_controleAutomatico.isSelected()) {
                bean.setTipo(EnumTipoAcionamento.CONTROLE_AUTOMATICO);
            } else if(rd_detectarPessoas.isSelected()) {
                bean.setTipo(EnumTipoAcionamento.DETECTAR_PESSOAS);
            } else if(rd_reconhecerFaces.isSelected()) {
                bean.setTipo(EnumTipoAcionamento.RECONHECER_FACES);
            } else if(rd_alarme.isSelected()) {
                bean.setTipo(EnumTipoAcionamento.ALARME);
                bean.setPredio((PredioBean) cb_predio.getSelectedItem());
            } else if(rd_movimento.isSelected()) {
                bean.setTipo(EnumTipoAcionamento.MOVIMENTO);
            }
        } else {
            bean.setTipo(EnumTipoAcionamento.NENHUM_ACIONAMENTO); 
        }
        
        return bean;
    }
    
    private ItemAcionamentoBean populaItemAcionamentoBean(AcionamentoBean acionamento, DispositivoEletricoBean dispositivo) {
        ItemAcionamentoBean bean = new ItemAcionamentoBean();
       
        bean.setAcionamento(acionamento);
        bean.setDispositivoEletrico(dispositivo);
        
        return bean;
    }
    
    private void salvar() {
        if(validaCampos()){  
            AcionamentoBean acionamento = salvarAcionamento(populaAcionamentoBean());
            if(acionamento != null) {
                deletarItemAcionamentoPorAcionamento(acionamento);
                for(int i = 0; i < modeloDispositivosAdicionados.size(); i++) {
                    salvarItemAcionamentos(populaItemAcionamentoBean(acionamento, modeloDispositivosAdicionados.getElementAt(i)));
                }  
                if(insereAltera == 0){
                    cenario.adionaCenario(acionamento);
                } else {
                    cenario.carregarCenarios();
                }
                if(rd_ativar.isSelected()){
                    cenario.mi_ativarDesativar.setText("Ativar");
                } else {
                    cenario.mi_ativarDesativar.setText("Desativar");
                }
                cenario.ativarDesativar();
            }
            dispose();
        }
    }
    
    public void exibirImagem(BufferedImage buffer, String nomeArquivo) {
        lb_imagem.setIcon(new ImageIcon(ImagemUtil.bufferedImageParaImage(buffer)));   
        this.nomeArquivo = nomeArquivo;
    }

    private ArrayList<CameraBean> obtemCamerasAdicionadas() {
        ArrayList<CameraBean> lista = new ArrayList<>();
        Enumeration<CameraBean> enumeration = modeloCamerasAdicionadas.elements();
        while (enumeration.hasMoreElements()) {            
            lista.add(enumeration.nextElement());
        }
        return lista;
    }

    private void preencherComboPredio() {
        cb_predio.addItem("<Escolha um prédio>");
        for(PredioBean predio : listarPredioNaoDeletado()) {
            cb_predio.addItem(predio); 
        }
    } 
    
}
