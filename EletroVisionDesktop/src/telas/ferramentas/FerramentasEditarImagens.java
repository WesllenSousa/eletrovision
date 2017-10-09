
package telas.ferramentas;

import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import controle.filtros.EnumFiltro;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.fileChooser.ImagemFileView;
import telas.comuns.fileChooser.ImagemFilter;
import telas.comuns.fileChooser.ImagemPreview;
import telas.ferramentas.dependencias.Controles;
import telas.principal.Manual;
import util.DiretorioUtil;
import util.ImagemUtil;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class FerramentasEditarImagens extends javax.swing.JPanel {
    
    private Controles controles;
    
    private BufferedImage bufferNormal, bufferDesfazer, bufferAtual;
    
    private String diretorioAnterior = ".", diretorioImagemAtual, 
            arquivoAtual = null, arquivoAnterior = null;    
    private String[] iterator;
    private Integer imagemAtual=0;
    private Float tamanho = 1.0f;
    private TreePath treePath, treePathExcluir;

    public FerramentasEditarImagens() {
        initComponents();
        InstanciasTelas.setFerramentasEditarImagens(FerramentasEditarImagens.this);
        if_editarImagem.setFrameIcon(new ImageIcon(getClass().getResource(ArquivosImagens.logo())));
        
        montarArvoreDiretorios(null);
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mn_popupArvore = new javax.swing.JPopupMenu();
        mi_editar = new javax.swing.JMenuItem();
        mi_excluir = new javax.swing.JMenuItem();
        mi_criarPasta = new javax.swing.JMenuItem();
        mi_importarImagem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mi_definirMapaDispositivos = new javax.swing.JMenuItem();
        mi_definirMapaCenario = new javax.swing.JMenuItem();
        if_editarImagem = new javax.swing.JInternalFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        ivx_imagem = new org.jdesktop.swingx.JXImageView();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tr_arvoreDiretorios = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        bt_salvarDentro = new javax.swing.JButton();
        bt_salvarFora = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bt_primeiro = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();
        bt_posterior = new javax.swing.JButton();
        bt_ultimo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bt_desfazer = new javax.swing.JButton();
        bt_refazer = new javax.swing.JButton();
        bt_limpar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bt_maisZoom = new javax.swing.JButton();
        bt_menosZoom = new javax.swing.JButton();
        bt_zoomNormal = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem106 = new javax.swing.JMenuItem();
        mn_editar = new javax.swing.JMenu();
        jMenuItem107 = new javax.swing.JMenuItem();
        mn_filtro = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        mi_contraste = new javax.swing.JMenuItem();
        mi_dobrar = new javax.swing.JMenuItem();
        mi_exposicaoLuz = new javax.swing.JMenuItem();
        mi_adicao = new javax.swing.JMenuItem();
        mi_gamma = new javax.swing.JMenuItem();
        mi_escalaCinza = new javax.swing.JMenuItem();
        mi_hsba = new javax.swing.JMenuItem();
        mi_inverter = new javax.swing.JMenuItem();
        mi_nivel = new javax.swing.JMenuItem();
        mi_posterizar = new javax.swing.JMenuItem();
        mi_rescala = new javax.swing.JMenuItem();
        mi_rgb = new javax.swing.JMenuItem();
        mi_solarizar = new javax.swing.JMenuItem();
        mi_thresholding = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mi_misturar = new javax.swing.JMenuItem();
        mi_vidro = new javax.swing.JMenuItem();
        mi_marmore = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mi_cromar = new javax.swing.JMenuItem();
        mi_relevo = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        mi_detectarBordas = new javax.swing.JMenuItem();
        jPanel15 = new javax.swing.JPanel();
        bt_ajuda = new javax.swing.JButton();

        mi_editar.setText("Editar");
        mi_editar.setToolTipText("");
        mi_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_editarActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_editar);

        mi_excluir.setText("Excluir");
        mi_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_excluirActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_excluir);

        mi_criarPasta.setText("Nova Pasta");
        mi_criarPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_criarPastaActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_criarPasta);

        mi_importarImagem.setText("Importar Imagem");
        mi_importarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_importarImagemActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_importarImagem);

        jSeparator4.setToolTipText("");
        mn_popupArvore.add(jSeparator4);

        mi_definirMapaDispositivos.setText("Definir como mapa de dispositivos");
        mi_definirMapaDispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_definirMapaDispositivosActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_definirMapaDispositivos);

        mi_definirMapaCenario.setText("Definir como mapa do cenário");
        mi_definirMapaCenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_definirMapaCenarioActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_definirMapaCenario);

        if_editarImagem.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        if_editarImagem.setVisible(true);

        jSplitPane1.setResizeWeight(0.25);
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setContinuousLayout(true);

        javax.swing.GroupLayout ivx_imagemLayout = new javax.swing.GroupLayout(ivx_imagem);
        ivx_imagem.setLayout(ivx_imagemLayout);
        ivx_imagemLayout.setHorizontalGroup(
            ivx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );
        ivx_imagemLayout.setVerticalGroup(
            ivx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(ivx_imagem);

        tr_arvoreDiretorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tr_arvoreDiretoriosMouseClicked(evt);
            }
        });
        tr_arvoreDiretorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tr_arvoreDiretoriosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tr_arvoreDiretorios);

        jButton1.setText("Recarregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/abrir_22x22.png"))); // NOI18N
        jButton8.setToolTipText("Abrir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        bt_salvarDentro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/salvar_22x22.png"))); // NOI18N
        bt_salvarDentro.setToolTipText("Salvar");
        bt_salvarDentro.setEnabled(false);
        bt_salvarDentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarDentroActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_salvarDentro);

        bt_salvarFora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/salvarOutroLugar_22x22.png"))); // NOI18N
        bt_salvarFora.setToolTipText("Salvar em outro diretório");
        bt_salvarFora.setEnabled(false);
        bt_salvarFora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarForaActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_salvarFora);
        jToolBar1.add(jSeparator1);

        bt_primeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/primeiro_22x22.png"))); // NOI18N
        bt_primeiro.setToolTipText("Primeira Imagem");
        bt_primeiro.setEnabled(false);
        bt_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_primeiroActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_primeiro);

        bt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/retornar_22x22.png"))); // NOI18N
        bt_anterior.setToolTipText("Imagem anterior");
        bt_anterior.setEnabled(false);
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_anterior);

        bt_posterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/seguir_22x22.png"))); // NOI18N
        bt_posterior.setToolTipText("Imagem posterior");
        bt_posterior.setEnabled(false);
        bt_posterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_posteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_posterior);

        bt_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ultimo_22x22.png"))); // NOI18N
        bt_ultimo.setToolTipText("Última imagem");
        bt_ultimo.setEnabled(false);
        bt_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ultimoActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_ultimo);
        jToolBar1.add(jSeparator2);

        bt_desfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/desfazer_22x22.png"))); // NOI18N
        bt_desfazer.setToolTipText("Desfazer");
        bt_desfazer.setEnabled(false);
        bt_desfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_desfazerActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_desfazer);

        bt_refazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/refazer_22x22.png"))); // NOI18N
        bt_refazer.setToolTipText("Refazer");
        bt_refazer.setEnabled(false);
        bt_refazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refazerActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_refazer);

        bt_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/limpar_22x22.png"))); // NOI18N
        bt_limpar.setToolTipText("Limpar");
        bt_limpar.setEnabled(false);
        bt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_limpar);
        jToolBar1.add(jSeparator3);

        bt_maisZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zomMais_22x22.png"))); // NOI18N
        bt_maisZoom.setToolTipText("Limpar");
        bt_maisZoom.setFocusable(false);
        bt_maisZoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_maisZoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_maisZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_maisZoomActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_maisZoom);

        bt_menosZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zomMenos_22x22.png"))); // NOI18N
        bt_menosZoom.setToolTipText("Limpar");
        bt_menosZoom.setFocusable(false);
        bt_menosZoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_menosZoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_menosZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_menosZoomActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_menosZoom);

        bt_zoomNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zoomNormal_22x22.png"))); // NOI18N
        bt_zoomNormal.setToolTipText("Limpar");
        bt_zoomNormal.setFocusable(false);
        bt_zoomNormal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_zoomNormal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_zoomNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_zoomNormalActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_zoomNormal);

        jMenuBar1.setEnabled(false);

        jMenu1.setText("Arquivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Salvar imagem interna");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem106.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem106.setText("Salvar imagem externa");
        jMenuItem106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem106ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem106);

        jMenuBar1.add(jMenu1);

        mn_editar.setText("Editar");
        mn_editar.setEnabled(false);

        jMenuItem107.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem107.setText("Desenhar");
        jMenuItem107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem107ActionPerformed(evt);
            }
        });
        mn_editar.add(jMenuItem107);

        jMenuBar1.add(mn_editar);

        mn_filtro.setText("Filtros");
        mn_filtro.setEnabled(false);

        jMenu4.setText("Ajustar Cores");

        mi_contraste.setText("Contraste");
        mi_contraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_contrasteActionPerformed(evt);
            }
        });
        jMenu4.add(mi_contraste);

        mi_dobrar.setText("Dobrar");
        mi_dobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_dobrarActionPerformed(evt);
            }
        });
        jMenu4.add(mi_dobrar);

        mi_exposicaoLuz.setText("Exposicao a Luz");
        mi_exposicaoLuz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_exposicaoLuzActionPerformed(evt);
            }
        });
        jMenu4.add(mi_exposicaoLuz);

        mi_adicao.setText("Adição");
        mi_adicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_adicaoActionPerformed(evt);
            }
        });
        jMenu4.add(mi_adicao);

        mi_gamma.setText("Gamma");
        mi_gamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_gammaActionPerformed(evt);
            }
        });
        jMenu4.add(mi_gamma);

        mi_escalaCinza.setText("Escala de Cinza");
        mi_escalaCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_escalaCinzaActionPerformed(evt);
            }
        });
        jMenu4.add(mi_escalaCinza);

        mi_hsba.setText("HSBA");
        mi_hsba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_hsbaActionPerformed(evt);
            }
        });
        jMenu4.add(mi_hsba);

        mi_inverter.setText("Inverter");
        mi_inverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_inverterActionPerformed(evt);
            }
        });
        jMenu4.add(mi_inverter);

        mi_nivel.setText("Níveis");
        mi_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_nivelActionPerformed(evt);
            }
        });
        jMenu4.add(mi_nivel);

        mi_posterizar.setText("Posterizar");
        mi_posterizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_posterizarActionPerformed(evt);
            }
        });
        jMenu4.add(mi_posterizar);

        mi_rescala.setText("Rescalar");
        mi_rescala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_rescalaActionPerformed(evt);
            }
        });
        jMenu4.add(mi_rescala);

        mi_rgb.setText("RGB");
        mi_rgb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_rgbActionPerformed(evt);
            }
        });
        jMenu4.add(mi_rgb);

        mi_solarizar.setText("Solarizar");
        mi_solarizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_solarizarActionPerformed(evt);
            }
        });
        jMenu4.add(mi_solarizar);

        mi_thresholding.setText("Thresholding");
        mi_thresholding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_thresholdingActionPerformed(evt);
            }
        });
        jMenu4.add(mi_thresholding);

        mn_filtro.add(jMenu4);

        jMenu5.setText("Distorcoes");

        mi_misturar.setText("Misturar");
        mi_misturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_misturarActionPerformed(evt);
            }
        });
        jMenu5.add(mi_misturar);

        mi_vidro.setText("Vidro");
        mi_vidro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_vidroActionPerformed(evt);
            }
        });
        jMenu5.add(mi_vidro);

        mi_marmore.setText("Mármore");
        mi_marmore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_marmoreActionPerformed(evt);
            }
        });
        jMenu5.add(mi_marmore);

        mn_filtro.add(jMenu5);

        jMenu6.setText("Efeitos");

        mi_cromar.setText("Cromar");
        mi_cromar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_cromarActionPerformed(evt);
            }
        });
        jMenu6.add(mi_cromar);

        mi_relevo.setText("Relevo");
        mi_relevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_relevoActionPerformed(evt);
            }
        });
        jMenu6.add(mi_relevo);

        mn_filtro.add(jMenu6);

        jMenu9.setText("Bordas");

        mi_detectarBordas.setText("Sobel");
        mi_detectarBordas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarBordasActionPerformed(evt);
            }
        });
        jMenu9.add(mi_detectarBordas);

        mn_filtro.add(jMenu9);

        jMenuBar1.add(mn_filtro);

        if_editarImagem.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout if_editarImagemLayout = new javax.swing.GroupLayout(if_editarImagem.getContentPane());
        if_editarImagem.getContentPane().setLayout(if_editarImagemLayout);
        if_editarImagemLayout.setHorizontalGroup(
            if_editarImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        if_editarImagemLayout.setVerticalGroup(
            if_editarImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(if_editarImagemLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1))
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
            .addComponent(if_editarImagem)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(if_editarImagem))
        );

        try {
            if_editarImagem.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    abrir();
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    abrir();
}//GEN-LAST:event_jButton8ActionPerformed

private void mi_contrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_contrasteActionPerformed
    contraste();
}//GEN-LAST:event_mi_contrasteActionPerformed

private void mi_dobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_dobrarActionPerformed
    dobrar();
}//GEN-LAST:event_mi_dobrarActionPerformed

private void bt_salvarForaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarForaActionPerformed
    salvarImagemForaSistema();
}//GEN-LAST:event_bt_salvarForaActionPerformed

private void bt_salvarDentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarDentroActionPerformed
    salvarImagemInterna();
}//GEN-LAST:event_bt_salvarDentroActionPerformed

private void bt_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_primeiroActionPerformed
    imagemAtual = 0;
    exibirImagemNormal(diretorioImagemAtual+File.separator+iterator[imagemAtual]);
    analisarBotoesNavegacao(3);
}//GEN-LAST:event_bt_primeiroActionPerformed

private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
    imagemAtual--;
    exibirImagemNormal(diretorioImagemAtual+File.separator+iterator[imagemAtual]);
    analisarBotoesNavegacao(3);
}//GEN-LAST:event_bt_anteriorActionPerformed

private void bt_posteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_posteriorActionPerformed
    imagemAtual++;
    exibirImagemNormal(diretorioImagemAtual+File.separator+iterator[imagemAtual]);
    analisarBotoesNavegacao(3);
}//GEN-LAST:event_bt_posteriorActionPerformed

private void bt_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimoActionPerformed
    imagemAtual = iterator.length-1;
    exibirImagemNormal(diretorioImagemAtual+File.separator+iterator[imagemAtual]);
    analisarBotoesNavegacao(3);
}//GEN-LAST:event_bt_ultimoActionPerformed

private void bt_desfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_desfazerActionPerformed
    exibirImageBufferFazerDesfazer(bufferDesfazer);
    analizarBotoesRefazer(0);
}//GEN-LAST:event_bt_desfazerActionPerformed

private void bt_refazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refazerActionPerformed
    exibirImageBufferFazerDesfazer(bufferAtual);
    analizarBotoesRefazer(1);
}//GEN-LAST:event_bt_refazerActionPerformed

private void bt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparActionPerformed
    exibirImageBuffer(bufferNormal);
    analizarBotoesRefazer(3);
}//GEN-LAST:event_bt_limparActionPerformed

private void mi_exposicaoLuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_exposicaoLuzActionPerformed
    exposicaoLuz();
}//GEN-LAST:event_mi_exposicaoLuzActionPerformed

private void mi_adicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_adicaoActionPerformed
    adicao();
}//GEN-LAST:event_mi_adicaoActionPerformed

private void mi_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_excluirActionPerformed
    excluirImagem();
}//GEN-LAST:event_mi_excluirActionPerformed

private void mi_definirMapaDispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_definirMapaDispositivosActionPerformed
    definirMapa(0);
}//GEN-LAST:event_mi_definirMapaDispositivosActionPerformed

private void mi_criarPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_criarPastaActionPerformed
    novaPasta();
}//GEN-LAST:event_mi_criarPastaActionPerformed

private void mi_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_editarActionPerformed
    editar();
}//GEN-LAST:event_mi_editarActionPerformed

private void jMenuItem107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem107ActionPerformed
    editar();
}//GEN-LAST:event_jMenuItem107ActionPerformed

private void mi_gammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_gammaActionPerformed
    gamma();
}//GEN-LAST:event_mi_gammaActionPerformed

private void mi_escalaCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_escalaCinzaActionPerformed
    escalaCinza();
}//GEN-LAST:event_mi_escalaCinzaActionPerformed

private void mi_hsbaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_hsbaActionPerformed
    hsba();
}//GEN-LAST:event_mi_hsbaActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    atualizarArvore();
}//GEN-LAST:event_jButton1ActionPerformed

private void tr_arvoreDiretoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tr_arvoreDiretoriosMouseClicked
    treePath = tr_arvoreDiretorios.getSelectionPath();
    if(treePath != null){
        arquivo(treePath);
        if(evt.getButton() == MouseEvent.BUTTON3){
            exibirMenuPopup(evt);
        } else if (verificaExtensao(arquivoAtual)) {
            definirLocalImagens(); 
            perguntarSalvamento();
            exibirImagemNormal(arquivoAtual);
            analisarBotoesNavegacao(3);
            SwingUtil.fechaTabbedPanePeloTitulo(InstanciasTelas.getPrincipal().tb_principal, "Editando...");
        }
    }
}//GEN-LAST:event_tr_arvoreDiretoriosMouseClicked

private void tr_arvoreDiretoriosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr_arvoreDiretoriosKeyReleased
    treePath = tr_arvoreDiretorios.getSelectionPath();
    if(treePath != null){
        arquivo(treePath);
        if (verificaExtensao(arquivoAtual)) {
            definirLocalImagens(); 
            perguntarSalvamento();           
            exibirImagemNormal(arquivoAtual);
            analisarBotoesNavegacao(3);
            SwingUtil.fechaTabbedPanePeloTitulo(InstanciasTelas.getPrincipal().tb_principal, "Editando...");
        }
    }
}//GEN-LAST:event_tr_arvoreDiretoriosKeyReleased

    private void mi_inverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_inverterActionPerformed
        inverter();
    }//GEN-LAST:event_mi_inverterActionPerformed

    private void mi_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_nivelActionPerformed
        niveis();
    }//GEN-LAST:event_mi_nivelActionPerformed

    private void mi_posterizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_posterizarActionPerformed
        posterizar();
    }//GEN-LAST:event_mi_posterizarActionPerformed

    private void mi_rescalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_rescalaActionPerformed
        rescalar();
    }//GEN-LAST:event_mi_rescalaActionPerformed

    private void mi_rgbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_rgbActionPerformed
        rgb();
    }//GEN-LAST:event_mi_rgbActionPerformed

    private void mi_solarizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_solarizarActionPerformed
        solarizar();
    }//GEN-LAST:event_mi_solarizarActionPerformed

    private void mi_thresholdingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_thresholdingActionPerformed
        thresholding();
    }//GEN-LAST:event_mi_thresholdingActionPerformed

    private void mi_misturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_misturarActionPerformed
        misturar();
    }//GEN-LAST:event_mi_misturarActionPerformed

    private void mi_vidroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_vidroActionPerformed
        vidro();
    }//GEN-LAST:event_mi_vidroActionPerformed

    private void mi_marmoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_marmoreActionPerformed
        marmore();
    }//GEN-LAST:event_mi_marmoreActionPerformed

    private void mi_cromarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_cromarActionPerformed
        cromar();
    }//GEN-LAST:event_mi_cromarActionPerformed

    private void mi_importarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_importarImagemActionPerformed
        importarImagem();
    }//GEN-LAST:event_mi_importarImagemActionPerformed

    private void mi_relevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_relevoActionPerformed
        relevo();
    }//GEN-LAST:event_mi_relevoActionPerformed

    private void mi_detectarBordasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarBordasActionPerformed
        sobel();
    }//GEN-LAST:event_mi_detectarBordasActionPerformed

    private void bt_maisZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_maisZoomActionPerformed
        tamanho += 0.1f;
        alterarTamanho(tamanho);
    }//GEN-LAST:event_bt_maisZoomActionPerformed

    private void bt_menosZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_menosZoomActionPerformed
        tamanho -= 0.1f;
        if(tamanho < 0.1f) {
            tamanho = 0.1f;
        }
        alterarTamanho(tamanho);
    }//GEN-LAST:event_bt_menosZoomActionPerformed

    private void bt_zoomNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_zoomNormalActionPerformed
        tamanho = 1.0f;
        alterarTamanho(tamanho);
    }//GEN-LAST:event_bt_zoomNormalActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        salvarImagemInterna();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem106ActionPerformed
        salvarImagemForaSistema();
    }//GEN-LAST:event_jMenuItem106ActionPerformed

    private void mi_definirMapaCenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_definirMapaCenarioActionPerformed
        definirMapa(1);
    }//GEN-LAST:event_mi_definirMapaCenarioActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_desfazer;
    private javax.swing.JButton bt_limpar;
    private javax.swing.JButton bt_maisZoom;
    private javax.swing.JButton bt_menosZoom;
    private javax.swing.JButton bt_posterior;
    private javax.swing.JButton bt_primeiro;
    private javax.swing.JButton bt_refazer;
    private javax.swing.JButton bt_salvarDentro;
    private javax.swing.JButton bt_salvarFora;
    private javax.swing.JButton bt_ultimo;
    private javax.swing.JButton bt_zoomNormal;
    private javax.swing.JInternalFrame if_editarImagem;
    private org.jdesktop.swingx.JXImageView ivx_imagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem106;
    private javax.swing.JMenuItem jMenuItem107;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mi_adicao;
    private javax.swing.JMenuItem mi_contraste;
    private javax.swing.JMenuItem mi_criarPasta;
    private javax.swing.JMenuItem mi_cromar;
    private javax.swing.JMenuItem mi_definirMapaCenario;
    private javax.swing.JMenuItem mi_definirMapaDispositivos;
    private javax.swing.JMenuItem mi_detectarBordas;
    private javax.swing.JMenuItem mi_dobrar;
    private javax.swing.JMenuItem mi_editar;
    private javax.swing.JMenuItem mi_escalaCinza;
    private javax.swing.JMenuItem mi_excluir;
    private javax.swing.JMenuItem mi_exposicaoLuz;
    private javax.swing.JMenuItem mi_gamma;
    private javax.swing.JMenuItem mi_hsba;
    private javax.swing.JMenuItem mi_importarImagem;
    private javax.swing.JMenuItem mi_inverter;
    private javax.swing.JMenuItem mi_marmore;
    private javax.swing.JMenuItem mi_misturar;
    private javax.swing.JMenuItem mi_nivel;
    private javax.swing.JMenuItem mi_posterizar;
    private javax.swing.JMenuItem mi_relevo;
    private javax.swing.JMenuItem mi_rescala;
    private javax.swing.JMenuItem mi_rgb;
    private javax.swing.JMenuItem mi_solarizar;
    private javax.swing.JMenuItem mi_thresholding;
    private javax.swing.JMenuItem mi_vidro;
    private javax.swing.JMenu mn_editar;
    private javax.swing.JMenu mn_filtro;
    private javax.swing.JPopupMenu mn_popupArvore;
    private javax.swing.JTree tr_arvoreDiretorios;
    // End of variables declaration//GEN-END:variables

    /*
     *  ===============TELA==============================================
     */
    
    private void arquivo(TreePath treePath) {
        if(arquivoAtual != null) {
            arquivoAnterior = arquivoAtual;
        } else {
            arquivoAnterior = extrairDiretorioArvore(treePath);
        }
        arquivoAtual = extrairDiretorioArvore(treePath);
    }
    
    private void abilitarComponentes(){
        mn_editar.setEnabled(true);
        mn_filtro.setEnabled(true); 
        bt_salvarDentro.setEnabled(true);
        bt_salvarFora.setEnabled(true);
        bt_anterior.setEnabled(true);
        bt_primeiro.setEnabled(true);
        bt_posterior.setEnabled(true);
        bt_ultimo.setEnabled(true);
    }
    
    private void desabilitarComponentes(){
        mn_editar.setEnabled(false);
        mn_filtro.setEnabled(false); 
        bt_salvarDentro.setEnabled(false);
        bt_salvarFora.setEnabled(false);
        bt_anterior.setEnabled(false);
        bt_primeiro.setEnabled(false);
        bt_posterior.setEnabled(false);
        bt_ultimo.setEnabled(false);
    }
    
    private void analisarBotoesNavegacao(Integer status) {
        if(status == 0){
            bt_anterior.setEnabled(true);
            bt_posterior.setEnabled(true);
            bt_primeiro.setEnabled(true);
            bt_ultimo.setEnabled(true);
        } else if(status == 1){
            bt_anterior.setEnabled(false);
            bt_posterior.setEnabled(false);
            bt_primeiro.setEnabled(false);
            bt_ultimo.setEnabled(false);
        } else if(status == 3) {
            if(imagemAtual == 0 && imagemAtual == (iterator.length-1)){
                bt_anterior.setEnabled(false);
                bt_primeiro.setEnabled(false);
                bt_posterior.setEnabled(false);
                bt_ultimo.setEnabled(false);
            } else if(imagemAtual == 0){
                bt_anterior.setEnabled(false);
                bt_primeiro.setEnabled(false);
                bt_posterior.setEnabled(true);
                bt_ultimo.setEnabled(true);
            } else if(imagemAtual == (iterator.length-1)){
                bt_anterior.setEnabled(true);
                bt_primeiro.setEnabled(true);
                bt_posterior.setEnabled(false);
                bt_ultimo.setEnabled(false);
            }
        }
    }
    
    private void analizarBotoesRefazer(Integer status){
        if(status == 0){
            bt_refazer.setEnabled(true);
            bt_desfazer.setEnabled(false);
        } else if(status == 1){
            bt_refazer.setEnabled(false);
            bt_desfazer.setEnabled(true);
        } else  if(status == 3){
            bt_refazer.setEnabled(false);
            bt_desfazer.setEnabled(false);
        } else if(status == 4){
            bt_refazer.setEnabled(true);
            bt_desfazer.setEnabled(true);
        }
    }
    
    private void exibirMenuPopup(MouseEvent evt) {
        String diretorioArvore = extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath());
        if(!verificaExtensao(diretorioArvore)){
            Integer numeroPath = tr_arvoreDiretorios.getSelectionPath().getPathCount();
            if(numeroPath > 2) {
                mi_excluir.setEnabled(true);
            } else { 
                mi_excluir.setEnabled(false);
            }
            mi_definirMapaDispositivos.setEnabled(false);
            if(diretorioArvore.indexOf("ImagensEditadas") != -1){
                mi_criarPasta.setEnabled(true);
            } else {
                mi_criarPasta.setEnabled(false);
            }
        } else {     
            mi_excluir.setEnabled(true);
            mi_definirMapaDispositivos.setEnabled(true);
            mi_criarPasta.setEnabled(false);
        }
        String arquivo;
        if (tr_arvoreDiretorios.getSelectionPath().getParentPath() != null) {
            arquivo = DiretorioUtil.extrairNomeArquivoDiretorio(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath().getParentPath()));
            if(arquivo.indexOf("Mapas") == -1){
               mi_definirMapaDispositivos.setEnabled(false); 
               mi_definirMapaCenario.setEnabled(false);
            } else {
                mi_definirMapaDispositivos.setEnabled(true);
                mi_definirMapaCenario.setEnabled(true); 
            }
        }
        if(verificaExtensao(diretorioArvore)){
            mi_editar.setEnabled(true);
        } else {
            mi_editar.setEnabled(false);
        }
        mn_popupArvore.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    
   /*
 *  ===============REGRA DE NEGOCIO=========================================
 */
    
    private void configuraSlides(String controle1, String controle2, String controle3, String controle4) {
        controles = new Controles(null, true, this);
        controles.configuraSlides(controle1, controle2, controle3, controle4);
    }
    
    private void configuraCombo(String combo1, String[] itens1, String combo2, String[] itens2) {
        controles.configuraCombo(combo1, itens1, combo2, itens2);
    }
    
    private void configuraCkeckBox(String checkbox1, String checkbox2, String checkbox3) {
        controles.configuraCkeckBox(checkbox1, checkbox2, checkbox3);
    }
    
    private void configuraControle(EnumFiltro enumFiltro, Integer abrir) { 
        controles.inicializaControles(bufferAtual, enumFiltro);
        if(abrir == 0) {
            controles.setVisible(true);
        }
    }
    
    private void importarImagem() {
        abrir();
        salvarImagemInterna();
    }
    
    private void abrir() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(diretorioAnterior));
        fileChooser.addChoosableFileFilter(new ImagemFilter());
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setFileView(new ImagemFileView());
        fileChooser.setAccessory(new ImagemPreview(fileChooser));
        
        Integer retorno = fileChooser.showDialog(this, "Abrir");
        if (retorno == JFileChooser.APPROVE_OPTION) {
            diretorioAnterior = fileChooser.getSelectedFile().getAbsolutePath();
            if(ImagemUtil.ler(new File(diretorioAnterior)) != null) {
                exibirImagemNormal(diretorioAnterior);
            }
        }    
    }
    
    private void exibirImagemNormal(String arquivo){
        File file = new File(arquivo);
        ivx_imagem.setImage(ImagemUtil.ler(file));
        abilitarComponentes();
        bufferNormal = ImagemUtil.imageParaBufferedImage(ivx_imagem.getImage(), Boolean.TRUE);
        bufferAtual = bufferNormal;
        if_editarImagem.setTitle(file.getName());
        bufferDesfazer = null;
        
        bt_limpar.setEnabled(false);
        analizarBotoesRefazer(3);
    }
    
    private void exibirImageBuffer(BufferedImage bufferedImage) {
        ivx_imagem.removeAll();
        ivx_imagem.setImage(bufferedImage);
        
        bufferDesfazer = bufferAtual;
        bufferAtual = bufferedImage;
        
        bt_limpar.setEnabled(true);
        analizarBotoesRefazer(1);
    }
    
    private void exibirImageBufferFazerDesfazer(BufferedImage bufferedImage) {
        ivx_imagem.removeAll();
        ivx_imagem.setImage(bufferedImage);
    }
    
    private void alterarTamanho(Float tamanho){
        ivx_imagem.setScale(tamanho);
    }

    private void salvarImagemForaSistema() {
        JFileChooser fileChooser = new JFileChooser();
        Integer retorno = fileChooser.showDialog(this, "Salvar");
        
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String diretorio = fileChooser.getSelectedFile().getPath();
            File file = new File(diretorio+".png");
            if(DiretorioUtil.verificarSeArquivoDiretorioExiste(file)){
                ImagemUtil.salvar(ImagemUtil.imageParaBufferedImage(ivx_imagem.getImage(), Boolean.TRUE), file);
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrImagemSalvar());
            }
        }
    }

    private void salvarImagemInterna() {
        if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrImagemPergunta())){
            String[] opcoes = new String[2];
            opcoes[0] = "Imagens Editadas"; opcoes[1] = "Mapas";
            String qual = InstanciasControle.getMensagens().multiplaEscolha(MensagensSoltas.ferrDestino(), opcoes);
            String dir = "";
            if(qual != null) {
                switch (qual) {
                    case "Imagens Editadas":
                        dir = obtemDiretorioImagem(ArquivosImagens.diretorio_imagensEditadas());
                        break;
                    case "Mapas":
                        dir = obtemDiretorioImagem(ArquivosImagens.diretorio_mapas());
                        break;
                }
                String nome = InstanciasControle.getMensagens().inserirDados(MensagensSoltas.ferrNomeImagem());
                if(nome != null){
                    nome = nome.replace(' ', '_');
                    File file = new File(dir+File.separator+nome+".png");
                    if(DiretorioUtil.verificarSeArquivoDiretorioExiste(file)){
                        ImagemUtil.salvar(ImagemUtil.imageParaBufferedImage(ivx_imagem.getImage(), Boolean.TRUE), file);
                        InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrImagemSalvar());
                        atualizarArvore();
                        bufferDesfazer = null;
                    }  
                }
            }
        }
    }
    
    private String obtemDiretorioImagem(String dir){
        HashSet<String> hashSet = DiretorioUtil.listarDiretorios(new File(dir));
        String[] diretorios;
        if(hashSet.size() > 0){
            Iterator it = hashSet.iterator();
            diretorios = new String[hashSet.size()+1];
            diretorios[0] = "Raiz";
            Integer cont = 1;
            while(it.hasNext()){
                diretorios[cont] = it.next().toString();
                cont++;
            }
        } else {
            return dir;
        }     
        String diretorio = InstanciasControle.getMensagens().multiplaEscolha(MensagensSoltas.ferrDiretorio(), diretorios);
        if(diretorio.equals("Raiz")){
            return dir;
        } else {
            return obtemDiretorioImagem(dir += File.separator+diretorio);
        }
    }

    private void montarArvoreDiretorios(TreePath treePath) {
        tr_arvoreDiretorios.removeAll();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Imagens");
        TreeNode treeNode = DiretorioUtil.listarArquivosEDiretorioJTree(raiz, new File(ArquivosImagens.diretorio_todasImagensInternas()));
        DefaultTreeModel modelo = new DefaultTreeModel(treeNode);
        modelo.setAsksAllowsChildren(true);
        tr_arvoreDiretorios.setModel(modelo);
        definirAparenciaArvore();
        if(treePath != null && treePathExcluir != null) {
            tr_arvoreDiretorios.setSelectionPath(treePathExcluir);
            tr_arvoreDiretorios.expandPath(tr_arvoreDiretorios.getSelectionPath());
            tr_arvoreDiretorios.updateUI();
            treePathExcluir = null;
        }
    }

    private void definirAparenciaArvore() {
        DefaultTreeCellRenderer rederer = new DefaultTreeCellRenderer();
        rederer.setLeafIcon(new ImageIcon(getClass().getResource(ArquivosImagens.arvore_arquivoImagem())));
        rederer.setClosedIcon(new ImageIcon(getClass().getResource(ArquivosImagens.arvore_pastaFechada())));
        rederer.setOpenIcon(new ImageIcon(getClass().getResource(ArquivosImagens.arvore_pastaAberta())));
        rederer.setTextNonSelectionColor(Color.BLACK);
        rederer.setTextSelectionColor(Color.RED);
        tr_arvoreDiretorios.setCellRenderer(rederer);
    }

    private String extrairDiretorioArvore(TreePath selectionPath) {
        String path = selectionPath.toString();
        String diretorio="";
        for(int i = 0; i < path.length(); i++) {
            char caracter = path.charAt(i);
            if(caracter == '[' || caracter == ']') {
                continue;
            } else if(caracter == ' ' || caracter == ' ') {
                continue;
            } else {
                diretorio += caracter;
            }
        }
        diretorio = ArquivosImagens.diretorio_todasImagens() + diretorio.replace(',', File.separatorChar);
        return diretorio;
    }

    private void definirLocalImagens() {
        if(verificaImagemDisponivelArvore()){
            popularDiretorioImagem();
            populaIterator();
            imagemAtual = 0;
            if(iterator.length > 0){
                analisarBotoesNavegacao(3);        
            } else {
                exibirImagemNormal(ArquivosImagens.sistema_semImagem());
                desabilitarComponentes();
                analisarBotoesNavegacao(1);
            }
        } 
    }
    
    private Boolean verificaImagemDisponivelArvore(){
        Integer numeroPath = tr_arvoreDiretorios.getSelectionPath().getPathCount();
        if(numeroPath >= 2){
            return true;
        } else {
            analisarBotoesNavegacao(1);
            return false;
        }
    }
    
    private void popularDiretorioImagem(){
        String diretorio = extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath());
        if(verificaExtensao(diretorio)){
            diretorioImagemAtual = extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath().getParentPath());
        } else { 
            diretorioImagemAtual = diretorio;
        }
    }

    private void populaIterator(){
        HashSet<String> hashSet = DiretorioUtil.listarArquivos(new File(diretorioImagemAtual));
        Iterator it = hashSet.iterator();
        Integer cont = 0;
        iterator = new String[hashSet.size()];
        while(it.hasNext()){
            iterator[cont] = it.next().toString();
            cont++;
        }
    }
    
    private Boolean verificaExtensao(String diretorio){
        if(diretorio.endsWith(".png") || diretorio.endsWith(".PNG") || diretorio.endsWith(".JPG") || diretorio.endsWith(".jpg") 
                || diretorio.endsWith(".jpeg") || diretorio.endsWith(".gif")){
            return true;
        } else {
            return false;
        }
    }

    private void excluirImagem() {
        TreePath[] treePaths = tr_arvoreDiretorios.getSelectionPaths();
        for(TreePath path : treePaths) {
            String arquivo = extrairDiretorioArvore(path);
            treePathExcluir = path.getParentPath();
            if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrExcluirPerguntar()+" '"
                    + DiretorioUtil.extrairNomeArquivoDiretorio(arquivo) + "' ?")){
                if(DiretorioUtil.deletarDiretorioArquivo(new File(arquivo))){
                    InstanciasControle.getGerenciarAudio().exeDeletar();
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrExcluirSucesso()); 
                } else {
                    InstanciasControle.getMensagens().bug(MensagensSoltas.ferrExcluirErro());
                }
            }
        }
        atualizarArvore();
        exibirImagemNormal(ArquivosImagens.sistema_semImagem());
        desabilitarComponentes();
        analisarBotoesNavegacao(1);
    }
    
    private void definirMapa(Integer i){
        String arquivo = DiretorioUtil.extrairNomeArquivoDiretorio(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath()));
        if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrDefinirMapa(arquivo))){  
            Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.pixels());
            if(props == null) {
                props = new Properties();
            }
            if(i == 0) {
                props.setProperty("mapaDispositivos", arquivo);
            } else if(i == 1) {
                props.setProperty("mapaCenarios", arquivo);
            }
            ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.pixels(), "Configuração dos Mapas");
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrMapaDefinido());
        } 
    }

    private void novaPasta() {
        String nomePasta = InstanciasControle.getMensagens().inserirDadosComValorInicial(MensagensSoltas.ferrNomePasta(), MensagensSoltas.ferrPasta());
        if(nomePasta != null){
            nomePasta = nomePasta.replace(' ', '_');
            String diretorio = extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath());
            DiretorioUtil.criarDiretorioComArquivo(new File(diretorio+"/"+nomePasta));
            atualizarArvore();
        }
    }

    private void editar() {
        FerramentasDesenhar painel = new FerramentasDesenhar();
        painel.setEditar(this, arquivoAtual);
        JPanel panel = SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Editando...", painel);
        if(panel != null){           
            bt_limpar.setEnabled(true);
            analizarBotoesRefazer(1);
            InstanciasTelas.getPrincipal().esperarTelas();
            painel.iniciarPaintImagem(bufferAtual);
            bufferDesfazer = bufferAtual;
        }
    }

    private void perguntarSalvamento() {
        if(bufferDesfazer != null) {
            if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrImagemAlterada())){
                if(verificaExtensao(arquivoAnterior)){
                    ImagemUtil.salvar(bufferAtual, new File(arquivoAnterior));
                    atualizarArvore();
                    bufferDesfazer = null;
                }
            } else {
                bufferDesfazer = null;
                String arquivo = extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath());
                exibirImagemNormal(arquivo);
            }
        }
    }
    
    public void atualizarArvore() {
        montarArvoreDiretorios(treePath);
    }
    
    public void exibirImagem(BufferedImage bufferedImage){
        exibirImageBuffer(bufferedImage);
    }
    
    public void atualizarTela() {
        atualizarArvore();
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.ferramentas()+ArquivosHTML.editarImagens());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * FILTROS
     */
    
    private void contraste(){     
        configuraSlides("Intensidade", "Brilho", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.CONTRASTE, 0);
    }

    private void dobrar() {
        configuraSlides("Ângulo", "Transição", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.DOBRAR, 0);
    }

    private void exposicaoLuz() {
        configuraSlides("Intensidade", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.EXPOSICAO_LUZ, 0);
    }

    private void adicao() {
        configuraSlides("Adição", "Polarização", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.ADICAO, 0);
    }

    private void gamma() {
        configuraSlides("Gamma", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.GAMMA, 0);
    }

    private void escalaCinza() {
        configuraSlides("", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.ESCALA_CINZA, 1);
    }

    private void hsba() {
        configuraSlides("Cor", "Saturação", "Brilho", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.HSBA, 0);
    }

    private void inverter() {
        configuraSlides("", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.INVERTER, 1);
    }
    
    private void niveis() {
        configuraSlides("Nível Alto", "Nível Baixo", "Nível Saída Alto", "Nível Saída Baixo");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.NIVEIS, 0);
    }
    
    private void posterizar() {
        configuraSlides("Níveis", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.POSTERIZAR, 0);
    }

    private void rescalar() {
        configuraSlides("Scala", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.RESCALAR, 0);
    }

    private void rgb() {
        configuraSlides("Vermelho", "Verde", "Azul", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.RGB, 0);
    }

    private void solarizar() {
        configuraSlides("", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.SOLARIZAR, 1);
    }

    private void thresholding() {
        configuraSlides("Alto Thresholding", "Baixo Thresholding", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.THRESHOLDING, 0);
    }

    private void misturar() {
        String[] bordas = {"Wrap", "Clamp", "Transparência"};
        configuraSlides("Escala", "", "", "");
        configuraCombo("Bordas", bordas, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.MISTURAR, 0);
    }

    private void vidro() {
        String[] bordas = {"Wrap", "Clamp", "Transparência"};
        configuraSlides("Quantidade", "", "", "");
        configuraCombo("Bordas", bordas, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.VIDRO, 0);
    }

    private void marmore() {
        String[] bordas = {"Wrap", "Clamp", "Transparência"};
        configuraSlides("Scala", "Quantidade", "Turbulência", "");
        configuraCombo("Bordas", bordas, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.MARMORE, 0);
    }

    private void cromar() {
        configuraSlides("Softness", "Altura", "Quantidade", "Exposição");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.CROMAR, 0);
    }

    private void relevo() {
        configuraSlides("Ângulo", "Elevação", "Relevo", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.RELEVO, 0);
    }

    private void sobel() {
        configuraSlides("", "", "", "");
        configuraCombo("", null, "", null);
        configuraCkeckBox("", "", "");
        configuraControle(EnumFiltro.SOBEL, 1);
    }
    
}
