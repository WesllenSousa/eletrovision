package telas.ferramentas;

import chrriis.dj.nativeswing.swtimpl.components.win32.JWMediaPlayer;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.diretorios.caminhos.ArquivosVideo;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.ferramentas.dependencias.PlayerOpenCv;
import telas.principal.Manual;
import util.DiretorioUtil;
import util.ImagemUtil;
import util.SistemaOperacional;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class FerramentasReprodVideos extends javax.swing.JPanel {

    private PlayerOpenCv playerOpenCv;
    private JWMediaPlayer playerNative;

    public FerramentasReprodVideos() {
        initComponents();

        montarArvoreDiretorios();
        if (SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.LINUX) {
            playerOpenCv = new PlayerOpenCv();
            scroll.setViewportView(playerOpenCv);
        } else if (SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.WINDOWS) {
            playerNative = new JWMediaPlayer();
            playerNative.setControlBarVisible(true);
            scroll.setViewportView(playerNative);
        }
        if (playerOpenCv == null) {
            bt_capturarImage.setVisible(false);
        }
        bt_salvar.setEnabled(false);
        bt_capturarImage.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mn_popupArvore = new javax.swing.JPopupMenu();
        mi_salvar = new javax.swing.JMenuItem();
        mi_excluir = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tr_arvoreDiretorios = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        bt_salvar = new javax.swing.JButton();
        bt_capturarImage = new javax.swing.JButton();
        bt_ajuda = new javax.swing.JButton();

        mi_salvar.setText("Salvar");
        mi_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_salvarActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_salvar);

        mi_excluir.setText("Excluir");
        mi_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_excluirActionPerformed(evt);
            }
        });
        mn_popupArvore.add(mi_excluir);

        jSplitPane1.setResizeWeight(0.2);
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setContinuousLayout(true);

        tr_arvoreDiretorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tr_arvoreDiretoriosMouseClicked(evt);
            }
        });
        tr_arvoreDiretorios.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                tr_arvoreDiretoriosValueChanged(evt);
            }
        });
        tr_arvoreDiretorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tr_arvoreDiretoriosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tr_arvoreDiretorios);

        jButton1.setText("Recarregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        jSplitPane1.setLeftComponent(jPanel5);
        jSplitPane1.setRightComponent(scroll);

        jPanel15.setBackground(new java.awt.Color(76, 158, 92));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/salvarOutroLugar_22x22.png"))); // NOI18N
        bt_salvar.setOpaque(false);
        bt_salvar.setToolTipText("Salvar vídeo");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_capturarImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/imagem_22x22.png"))); // NOI18N
        bt_capturarImage.setOpaque(false);
        bt_capturarImage.setToolTipText("Capturar e salvar Imagem");
        bt_capturarImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_capturarImageActionPerformed(evt);
            }
        });

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
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_capturarImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(bt_salvar)
            .addComponent(bt_capturarImage)
            .addComponent(bt_ajuda)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1))
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

private void mi_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_excluirActionPerformed
    excluir();
}//GEN-LAST:event_mi_excluirActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    montarArvoreDiretorios();
}//GEN-LAST:event_jButton1ActionPerformed

private void tr_arvoreDiretoriosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_tr_arvoreDiretoriosValueChanged
    analizarArvore();
}//GEN-LAST:event_tr_arvoreDiretoriosValueChanged

private void tr_arvoreDiretoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tr_arvoreDiretoriosMouseClicked
    executarAcaoArvore(evt);
}//GEN-LAST:event_tr_arvoreDiretoriosMouseClicked

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvar();
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_capturarImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_capturarImageActionPerformed
        capturarImagem();
    }//GEN-LAST:event_bt_capturarImageActionPerformed

    private void tr_arvoreDiretoriosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr_arvoreDiretoriosKeyReleased
        executarAcaoArvore(evt);
    }//GEN-LAST:event_tr_arvoreDiretoriosKeyReleased

    private void mi_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_salvarActionPerformed
        salvar();
    }//GEN-LAST:event_mi_salvarActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_capturarImage;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem mi_excluir;
    private javax.swing.JMenuItem mi_salvar;
    private javax.swing.JPopupMenu mn_popupArvore;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTree tr_arvoreDiretorios;
    // End of variables declaration//GEN-END:variables

    private void carregarPlayerOpenCv() {
        popularDiretorioVideo();
        if (playerOpenCv.getDiretorioVideoAtual() != null && verificaExtensao(playerOpenCv.getDiretorioVideoAtual())) {
            playerOpenCv.exibePrimeiraImagem();
            playerOpenCv.getImagemPanel().draw(ImagemUtil.ler(ArquivosImagens.video_prepararVideo()));
        } else {
            playerOpenCv.pn_video.removeAll();
        }
    }

    private void popularDiretorioVideo() {
        String diretorio = extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath());
        if (!verificaExtensao(diretorio)) {
            if (tr_arvoreDiretorios.getSelectionPath().getParentPath() != null) {
                playerOpenCv.setDiretorioVideoAtual(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath().getParentPath()));
            }
        } else {
            playerOpenCv.setDiretorioVideoAtual(diretorio);
        }
    }

    private void capturarImagem() {
        if (playerOpenCv != null) {
            salvarImagemInterna(playerOpenCv.getExibirVideo().getBufferedImage());
        }
    }

    private void carregarPlayerNative() {
        if (verificaExtensao(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath()))) {
            Runnable loadPlayerFileRunnable = new Runnable() {
                @Override
                public void run() {
                    playerNative.load(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath()));
                }
            };
            loadPlayerFileRunnable.run();
        }
    }

    private void montarArvoreDiretorios() {
        tr_arvoreDiretorios.removeAll();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Videos");
        TreeNode treeNode = DiretorioUtil.listarArquivosEDiretorioJTree(raiz, new File(ArquivosVideo.todosVideosInternos()));
        DefaultTreeModel modelo = new DefaultTreeModel(treeNode);
        modelo.setAsksAllowsChildren(true);
        tr_arvoreDiretorios.setModel(modelo);
        definirAparenciaArvore();
    }

    private void definirAparenciaArvore() {
        DefaultTreeCellRenderer rederer = new DefaultTreeCellRenderer();
        rederer.setLeafIcon(new ImageIcon(getClass().getResource(ArquivosImagens.arvore_arquivoVideo())));
        rederer.setClosedIcon(new ImageIcon(getClass().getResource(ArquivosImagens.arvore_pastaFechada())));
        rederer.setOpenIcon(new ImageIcon(getClass().getResource(ArquivosImagens.arvore_pastaAberta())));
        rederer.setTextNonSelectionColor(Color.BLACK);
        rederer.setTextSelectionColor(Color.RED);
        tr_arvoreDiretorios.setCellRenderer(rederer);
    }

    public String extrairDiretorioArvore(TreePath selectionPath) {
        String path = selectionPath.toString();
        String diretorio = "";
        for (int i = 0; i < path.length(); i++) {
            char caracter = path.charAt(i);
            if (caracter == '[' || caracter == ']') {
                continue;
            } else if (caracter == ' ' || caracter == ' ') {
                continue;
            } else {
                diretorio += caracter;
            }
        }
        diretorio = ArquivosVideo.todosVideos() + "/" + diretorio.replace(',', '/');
        return diretorio;
    }

    private Boolean verificaExtensao(String diretorio) {
        if (diretorio.endsWith(".avi") || diretorio.endsWith(".mpeg")) {
            return true;
        } else {
            return false;
        }
    }

    private void excluir() {
        TreePath[] treePaths = tr_arvoreDiretorios.getSelectionPaths();
        for (TreePath treePath : treePaths) {
            String arquivo = extrairDiretorioArvore(treePath);
            if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrExcluirPerguntar() + " '" + DiretorioUtil.extrairNomeArquivoDiretorio(arquivo) + "' ?")) {
                if (DiretorioUtil.deletarDiretorioArquivo(new File(arquivo))) {
                    InstanciasControle.getGerenciarAudio().exeDeletar();
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrExcluirSucesso());
                } else {
                    InstanciasControle.getMensagens().bug(MensagensSoltas.ferrExcluirErro());
                }
            }
        }
        montarArvoreDiretorios();
    }

    private void salvar() {
        JFileChooser fileChooser = new JFileChooser();
        Integer retorno = fileChooser.showDialog(this, "Salvar");

        if (retorno == JFileChooser.APPROVE_OPTION) {
            String destino = fileChooser.getSelectedFile().getPath() + ".mpeg";
            TreePath treePath = tr_arvoreDiretorios.getSelectionPath();
            String origem = extrairDiretorioArvore(treePath);
            DiretorioUtil.copiarArquivo(origem, destino);
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrVideoSalvo());
        }
    }

    private void salvarImagemInterna(BufferedImage bufferedImage) {
        if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrImagemPergunta())) {
            String dir = obtemDiretorioImagem(ArquivosImagens.diretorio_imagensEditadas());
            String nome = InstanciasControle.getMensagens().inserirDados(MensagensSoltas.ferrNomeImagem());
            if (nome != null) {
                nome = nome.replace(' ', '_');
                File file = new File(dir + "/" + nome + ".png");
                if (DiretorioUtil.verificarSeArquivoDiretorioExiste(file)) {
                    ImagemUtil.salvar(ImagemUtil.imageParaBufferedImage(bufferedImage, Boolean.TRUE), file);
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrImagemSalvar());
                }
            }
        }
    }

    private String obtemDiretorioImagem(String dir) {
        HashSet<String> hashSet = DiretorioUtil.listarDiretorios(new File(dir));
        String[] diretorios;
        if (hashSet.size() > 0) {
            Iterator it = hashSet.iterator();
            diretorios = new String[hashSet.size() + 1];
            diretorios[0] = "Raiz";
            Integer cont = 1;
            while (it.hasNext()) {
                diretorios[cont] = it.next().toString();
                cont++;
            }
        } else {
            return dir;
        }
        String diretorio = InstanciasControle.getMensagens().multiplaEscolha(MensagensSoltas.ferrDiretorio(), diretorios);
        if (diretorio.equals("Raiz")) {
            return dir;
        } else {
            return obtemDiretorioImagem(dir += "/" + diretorio);
        }
    }

    private void analizarArvore() {
        if (tr_arvoreDiretorios.getSelectionPath() != null) {
            if (playerOpenCv != null) {
                playerOpenCv.pararVideo();
            } else if (playerOpenCv != null && verificaExtensao(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath()))) {
                carregarPlayerNative();
            }
            if (verificaExtensao(extrairDiretorioArvore(tr_arvoreDiretorios.getSelectionPath()))) {
                if (playerOpenCv != null) {
                    playerOpenCv.getBotaoPlayer().setEnabled(true);
                }
                bt_salvar.setEnabled(true);
                bt_capturarImage.setEnabled(true);
            } else {
                if (playerOpenCv != null) {
                    playerOpenCv.getBotaoPlayer().setEnabled(false);
                }
                bt_salvar.setEnabled(false);
                bt_capturarImage.setEnabled(false);
            }
        }
    }

    private void executarAcaoArvore(InputEvent evento) {
        TreePath treePath = tr_arvoreDiretorios.getSelectionPath();
        if (treePath != null) {
            if(evento instanceof MouseEvent) {
                MouseEvent evt = (MouseEvent) evento;
                if (evt != null && evt.getButton() == MouseEvent.BUTTON3) {
                    if(verificaExtensao(extrairDiretorioArvore(treePath))) {
                        mi_salvar.setEnabled(true);
                    } else {
                        mi_salvar.setEnabled(false); 
                    }
                    mn_popupArvore.show(evt.getComponent(), evt.getX(), evt.getY());
                } else {
                    if (playerOpenCv != null) {
                        carregarPlayerOpenCv();
                    } else if (playerNative != null) {
                        carregarPlayerNative();
                    }
                }
            } else if(evento instanceof KeyEvent) {
                KeyEvent evt = (KeyEvent) evento;
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (playerOpenCv != null) {
                        carregarPlayerOpenCv();
                    } else if (playerNative != null) {
                        carregarPlayerNative();
                    }
                }
            }
        }
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.ferramentas()+ArquivosHTML.reprodutorVideos());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
}
