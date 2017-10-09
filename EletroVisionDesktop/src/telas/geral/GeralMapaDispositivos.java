package telas.geral;

import telas.geral.dependencias.PainelMapa;
import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigMapa;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JPanel;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.camera.VisualizadorCamera;
import telas.comuns.eventos.ArrastaComponentes;
import telas.comuns.imagens.ImagemPanel;
import telas.geral.dependencias.VincularAgendarTarefas;
import telas.principal.Manual;
import util.ArquivosUtil;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralMapaDispositivos extends javax.swing.JPanel {

    private Properties props;
    private Integer larguraMapa = 50, alturaMapa = 50;
    private ImagemPanel imagemPanel;
    public DispositivoEletricoBean dispositivoEletricoSelecionado;
    public CameraBean cameraSelecionada;

    public GeralMapaDispositivos() {
        initComponents();
        InstanciasTelas.setGeralMapaDispositivos(GeralMapaDispositivos.this);
 
        lerArquivoMapas();
        carregaImagemMapa();
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mn_camera = new javax.swing.JPopupMenu();
        mi_visualizarCamera = new javax.swing.JMenuItem();
        mi_ativarDesativarC = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        m_tipoProcessamento = new javax.swing.JMenu();
        mi_adaptarAmbiente = new javax.swing.JRadioButtonMenuItem();
        mi_mudancaAmbiente = new javax.swing.JRadioButtonMenuItem();
        m_pessoas = new javax.swing.JMenu();
        mi_detectarFace = new javax.swing.JCheckBoxMenuItem();
        mi_reconhecerFace = new javax.swing.JCheckBoxMenuItem();
        mi_detectarOlho = new javax.swing.JCheckBoxMenuItem();
        mi_detectarCorpo = new javax.swing.JCheckBoxMenuItem();
        m_acoes = new javax.swing.JMenu();
        mi_movimento = new javax.swing.JCheckBoxMenuItem();
        mi_ambienteStatico = new javax.swing.JCheckBoxMenuItem();
        mi_detectarObjeto = new javax.swing.JCheckBoxMenuItem();
        mi_dispositivos = new javax.swing.JCheckBoxMenuItem();
        mi_campanhia = new javax.swing.JCheckBoxMenuItem();
        mi_gravar = new javax.swing.JCheckBoxMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mi_agendarTarefa = new javax.swing.JMenuItem();
        mn_dispositivoEletrico = new javax.swing.JPopupMenu();
        mi_ligarDesligar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mi_ativarDesativarD = new javax.swing.JMenuItem();
        grupoAdaptarAmbiente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        bt_zoomMenos = new javax.swing.JButton();
        bt_zoomMais = new javax.swing.JButton();
        bt_ajuda = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        pn_imagem = new javax.swing.JPanel();
        pn_mapa = new org.jdesktop.swingx.JXPanel();

        mn_camera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mi_visualizarCamera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_visualizarCamera.setText("Visualizar câmera");
        mi_visualizarCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_visualizarCameraActionPerformed(evt);
            }
        });
        mn_camera.add(mi_visualizarCamera);

        mi_ativarDesativarC.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_ativarDesativarC.setText("Desativar");
        mi_ativarDesativarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ativarDesativarCActionPerformed(evt);
            }
        });
        mn_camera.add(mi_ativarDesativarC);
        mn_camera.add(jSeparator7);

        m_tipoProcessamento.setText("Tipo Processamento");
        m_tipoProcessamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        grupoAdaptarAmbiente.add(mi_adaptarAmbiente);
        mi_adaptarAmbiente.setText("Adaptar ao Ambiente");
        mi_adaptarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_adaptarAmbienteActionPerformed(evt);
            }
        });
        m_tipoProcessamento.add(mi_adaptarAmbiente);

        grupoAdaptarAmbiente.add(mi_mudancaAmbiente);
        mi_mudancaAmbiente.setSelected(true);
        mi_mudancaAmbiente.setText("Detectar Mudança no Ambiente");
        mi_mudancaAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_mudancaAmbienteActionPerformed(evt);
            }
        });
        m_tipoProcessamento.add(mi_mudancaAmbiente);

        mn_camera.add(m_tipoProcessamento);

        m_pessoas.setText("Face");
        m_pessoas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mi_detectarFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_detectarFace.setSelected(true);
        mi_detectarFace.setText("Detectar Face");
        mi_detectarFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarFaceActionPerformed(evt);
            }
        });
        m_pessoas.add(mi_detectarFace);

        mi_reconhecerFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_reconhecerFace.setText("Reconhecer Face");
        mi_reconhecerFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_reconhecerFaceActionPerformed(evt);
            }
        });
        m_pessoas.add(mi_reconhecerFace);

        mi_detectarOlho.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_detectarOlho.setSelected(true);
        mi_detectarOlho.setText("Detectar Olhos");
        mi_detectarOlho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarOlhoActionPerformed(evt);
            }
        });
        m_pessoas.add(mi_detectarOlho);

        mi_detectarCorpo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_detectarCorpo.setText("Detectar Corpo");
        mi_detectarCorpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarCorpoActionPerformed(evt);
            }
        });
        m_pessoas.add(mi_detectarCorpo);

        mn_camera.add(m_pessoas);

        m_acoes.setText("Ações");
        m_acoes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mi_movimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_movimento.setSelected(true);
        mi_movimento.setText("Movimento");
        mi_movimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_movimentoActionPerformed(evt);
            }
        });
        m_acoes.add(mi_movimento);

        mi_ambienteStatico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_ambienteStatico.setSelected(true);
        mi_ambienteStatico.setText("Ambiente stático");
        mi_ambienteStatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ambienteStaticoActionPerformed(evt);
            }
        });
        m_acoes.add(mi_ambienteStatico);

        mi_detectarObjeto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_detectarObjeto.setSelected(true);
        mi_detectarObjeto.setText("Detectar Objeto");
        mi_detectarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_detectarObjetoActionPerformed(evt);
            }
        });
        m_acoes.add(mi_detectarObjeto);

        mi_dispositivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_dispositivos.setSelected(true);
        mi_dispositivos.setText("Ativar dispositivos");
        mi_dispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_dispositivosActionPerformed(evt);
            }
        });
        m_acoes.add(mi_dispositivos);

        mi_campanhia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_campanhia.setSelected(true);
        mi_campanhia.setText("Campanhia");
        mi_campanhia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_campanhiaActionPerformed(evt);
            }
        });
        m_acoes.add(mi_campanhia);

        mi_gravar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_gravar.setSelected(true);
        mi_gravar.setText("Gravar");
        mi_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_gravarActionPerformed(evt);
            }
        });
        m_acoes.add(mi_gravar);

        mn_camera.add(m_acoes);
        mn_camera.add(jSeparator6);

        mi_agendarTarefa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_agendarTarefa.setText("Agendar Tarefa");
        mi_agendarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_agendarTarefaActionPerformed(evt);
            }
        });
        mn_camera.add(mi_agendarTarefa);

        mn_dispositivoEletrico.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mi_ligarDesligar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_ligarDesligar.setText("Ligar");
        mi_ligarDesligar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ligarDesligarActionPerformed(evt);
            }
        });
        mn_dispositivoEletrico.add(mi_ligarDesligar);
        mn_dispositivoEletrico.add(jSeparator5);

        mi_ativarDesativarD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_ativarDesativarD.setText("Desativar");
        mi_ativarDesativarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ativarDesativarDActionPerformed(evt);
            }
        });
        mn_dispositivoEletrico.add(mi_ativarDesativarD);

        jPanel1.setBackground(new java.awt.Color(76, 158, 92));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bt_zoomMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zomMenos_22x22.png"))); // NOI18N
        bt_zoomMenos.setToolTipText("DiminuirZoom");
        bt_zoomMenos.setOpaque(false);
        bt_zoomMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_zoomMenosActionPerformed(evt);
            }
        });

        bt_zoomMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/zomMais_22x22.png"))); // NOI18N
        bt_zoomMais.setToolTipText("Aumentar Zoom");
        bt_zoomMais.setOpaque(false);
        bt_zoomMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_zoomMaisActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_zoomMais, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_zoomMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_zoomMais, bt_zoomMenos});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_zoomMenos)
            .addComponent(bt_zoomMais)
            .addComponent(bt_ajuda)
        );

        pn_mapa.setAlpha(0.8F);

        javax.swing.GroupLayout pn_mapaLayout = new javax.swing.GroupLayout(pn_mapa);
        pn_mapa.setLayout(pn_mapaLayout);
        pn_mapaLayout.setHorizontalGroup(
            pn_mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        pn_mapaLayout.setVerticalGroup(
            pn_mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_imagemLayout = new javax.swing.GroupLayout(pn_imagem);
        pn_imagem.setLayout(pn_imagemLayout);
        pn_imagemLayout.setHorizontalGroup(
            pn_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_mapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_imagemLayout.setVerticalGroup(
            pn_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_mapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scroll.setViewportView(pn_imagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll))
        );
    }// </editor-fold>//GEN-END:initComponents

private void bt_zoomMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_zoomMenosActionPerformed
    alterarTamanho(larguraMapa - 10, alturaMapa - 10);
    verificarBotoesZoom();
}//GEN-LAST:event_bt_zoomMenosActionPerformed

private void bt_zoomMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_zoomMaisActionPerformed
    alterarTamanho(larguraMapa + 10, alturaMapa + 10);
    verificarBotoesZoom();
}//GEN-LAST:event_bt_zoomMaisActionPerformed

private void mi_ativarDesativarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ativarDesativarCActionPerformed
    ativarDesativarCamera();
}//GEN-LAST:event_mi_ativarDesativarCActionPerformed

private void mi_adaptarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_adaptarAmbienteActionPerformed
    adaptarAmbiente();
}//GEN-LAST:event_mi_adaptarAmbienteActionPerformed

private void mi_mudancaAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_mudancaAmbienteActionPerformed
    mudancaAmbiente();
}//GEN-LAST:event_mi_mudancaAmbienteActionPerformed

private void mi_detectarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarObjetoActionPerformed
    detectarObjeto();
}//GEN-LAST:event_mi_detectarObjetoActionPerformed

private void mi_detectarFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarFaceActionPerformed
    detectarFace();
}//GEN-LAST:event_mi_detectarFaceActionPerformed

private void mi_detectarOlhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarOlhoActionPerformed
    detectarOlho();
}//GEN-LAST:event_mi_detectarOlhoActionPerformed

private void mi_detectarCorpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_detectarCorpoActionPerformed
    detectarCorpo();
}//GEN-LAST:event_mi_detectarCorpoActionPerformed

private void mi_campanhiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_campanhiaActionPerformed
    campanhia();
}//GEN-LAST:event_mi_campanhiaActionPerformed

private void mi_ativarDesativarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ativarDesativarDActionPerformed
    ativarDesativarDispositivoEletrico();
}//GEN-LAST:event_mi_ativarDesativarDActionPerformed

private void mi_ligarDesligarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ligarDesligarActionPerformed
    ligarDesligarDispositivoEletrico();
}//GEN-LAST:event_mi_ligarDesligarActionPerformed

private void mi_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_gravarActionPerformed
    gravar();
}//GEN-LAST:event_mi_gravarActionPerformed

    private void mi_dispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_dispositivosActionPerformed
        dispositivos();
    }//GEN-LAST:event_mi_dispositivosActionPerformed

    private void mi_agendarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_agendarTarefaActionPerformed
        agendarTarefa();
    }//GEN-LAST:event_mi_agendarTarefaActionPerformed

    private void mi_reconhecerFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_reconhecerFaceActionPerformed
        reconhecerFace();
    }//GEN-LAST:event_mi_reconhecerFaceActionPerformed

    private void mi_visualizarCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_visualizarCameraActionPerformed
        visualizarCamera();
    }//GEN-LAST:event_mi_visualizarCameraActionPerformed

    private void mi_movimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_movimentoActionPerformed
        movimento();
    }//GEN-LAST:event_mi_movimentoActionPerformed

    private void mi_ambienteStaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ambienteStaticoActionPerformed
        ambienteStatico();
    }//GEN-LAST:event_mi_ambienteStaticoActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_zoomMais;
    private javax.swing.JButton bt_zoomMenos;
    private javax.swing.ButtonGroup grupoAdaptarAmbiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JMenu m_acoes;
    private javax.swing.JMenu m_pessoas;
    private javax.swing.JMenu m_tipoProcessamento;
    public javax.swing.JRadioButtonMenuItem mi_adaptarAmbiente;
    private javax.swing.JMenuItem mi_agendarTarefa;
    public javax.swing.JCheckBoxMenuItem mi_ambienteStatico;
    public javax.swing.JMenuItem mi_ativarDesativarC;
    public javax.swing.JMenuItem mi_ativarDesativarD;
    public javax.swing.JCheckBoxMenuItem mi_campanhia;
    public javax.swing.JCheckBoxMenuItem mi_detectarCorpo;
    public javax.swing.JCheckBoxMenuItem mi_detectarFace;
    public javax.swing.JCheckBoxMenuItem mi_detectarObjeto;
    public javax.swing.JCheckBoxMenuItem mi_detectarOlho;
    public javax.swing.JCheckBoxMenuItem mi_dispositivos;
    public javax.swing.JCheckBoxMenuItem mi_gravar;
    public javax.swing.JMenuItem mi_ligarDesligar;
    public javax.swing.JCheckBoxMenuItem mi_movimento;
    public javax.swing.JRadioButtonMenuItem mi_mudancaAmbiente;
    public javax.swing.JCheckBoxMenuItem mi_reconhecerFace;
    public javax.swing.JMenuItem mi_visualizarCamera;
    public javax.swing.JPopupMenu mn_camera;
    public javax.swing.JPopupMenu mn_dispositivoEletrico;
    private javax.swing.JPanel pn_imagem;
    private org.jdesktop.swingx.JXPanel pn_mapa;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    /*
     * ===============TELA==============================================
     */
    private void carregaImagemMapa() {
        BufferedImage bufferedImage;
        if (ConfigMapa.getMapaDispositivos() != null) {
            bufferedImage = ImagemUtil.ler(ArquivosImagens.diretorio_mapas() + File.separator + ConfigMapa.getMapaDispositivos());
        } else {
            bufferedImage = ImagemUtil.ler(ArquivosImagens.sistema_semImagem());
        }
        imagemPanel = new ImagemPanel();
        imagemPanel.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());

        Dimension dimension = new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
        pn_mapa.setPreferredSize(dimension);
        pn_imagem.setPreferredSize(dimension);

        imagemPanel.draw(bufferedImage);
        pn_imagem.add(imagemPanel);
        pn_imagem.repaint();
        pn_mapa.repaint();
        scroll.repaint();
    }

    private void verificarBotoesZoom() {
        if (larguraMapa <= 150) {
            bt_zoomMais.setEnabled(true);
        } else {
            bt_zoomMais.setEnabled(false);
        }
        if (larguraMapa >= 50) {
            bt_zoomMenos.setEnabled(true);
        } else {
            bt_zoomMenos.setEnabled(false);
        }
    }

    private void alterarTamanho(Integer largura, Integer altura) {
        larguraMapa = largura;
        alturaMapa = altura;
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            JPanel cenario = (JPanel) components[i];
            cenario.setSize(larguraMapa, alturaMapa);
        }
    }
    
    public void visualizarCamera() {
        if(InstanciasControle.getIniciarCameras().getStatus()) {
            VisualizadorCamera dialog = new VisualizadorCamera(null, true, null, cameraSelecionada);
            dialog.setVisible(true); 
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.gerDispositivosCameras());
        }
    }

    public void ativarDesativarCamera() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.ativarDesativarCamera();
            }
        }
    }

    public void adaptarAmbiente() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.adaptarAmbiente();
            }
        }
    }

    public void mudancaAmbiente() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.mudancaAmbiente();
            }
        }
    }
    
    public void movimento() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.movimento();
            }
        }
    }
    
    public void ambienteStatico() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.ambienteStatico();
            }
        }
    }

    public void detectarObjeto() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.detectarObjeto();
            }
        }
    }

    public void detectarFace() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.detectarFace();
            }
        }
    }
    
    public void reconhecerFace() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.reconhecerFace();
            }
        }
    }

    public void detectarOlho() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.detectarOlho();
            }
        }
    }

    public void detectarCorpo() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.detectarCorpo();
            }
        }
    }

    public void campanhia() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.campanhia();
            }
        }
    }

    private void dispositivos() { 
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.dispositivos();
            }
        }
    }

    private void gravar() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(cameraSelecionada.getNome())) {
                painelMapa.gravar();
            }
        }
    }

    public void ativarDesativarDispositivoEletrico() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(dispositivoEletricoSelecionado.getNome())) {
                painelMapa.ativarDesativarDispositivoEletrico();
            }
        }
    }

    public void ligarDesligarDispositivoEletrico() {
        Component[] components = pn_mapa.getComponents();
        for (int i = 0; i < components.length; i++) {
            PainelMapa painelMapa = (PainelMapa) components[i];
            if (painelMapa.getName().equals(dispositivoEletricoSelecionado.getNome())) {
                painelMapa.ligarDesligarDispositivoEletrico();
            }
        }
    }

    /*
     * ===============BANCO DE DADOS=========================================
     */
    private ArrayList<DispositivoEletricoBean> listarDispositivosEletricosNaoDeletados() {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.listarDispositivoEletricoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<CameraBean> listarCameraNaoDeletada() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraNaoDeletada();
        } catch (FacadeException ex) {
        }
        return null;
    }

    /*
     * ===============REGRA DE NEGOCIO=========================================
     */
    private void lerArquivoMapas() {
        props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.pixels());
        if (props != null) {
            ConfigMapa.setStatus(true);
            String mapa = props.getProperty("mapaDispositivos");
            ConfigMapa.setMapaDispositivos(mapa);
        } else { 
            props = new Properties();
            ConfigDispositivos.setStatus(false);
        }
    }

    public void carregaMapaDispositivos() {
        pn_mapa.removeAll();
        for (DispositivoEletricoBean dispositivoEletrico : listarDispositivosEletricosNaoDeletados()) {
            PainelMapa painelMapa = new PainelMapa(this, dispositivoEletrico);
            painelMapa.setName(dispositivoEletrico.getNome());
            painelMapa.setSize(larguraMapa, alturaMapa);
            if(props != null) {
                painelMapa.setLocation(verificaLocalizacaoDispositivoEletrico(dispositivoEletrico));
            }
            ArrastaComponentes arrastaComponentes = new ArrastaComponentes(painelMapa);
            painelMapa.addMouseListener(arrastaComponentes);
            painelMapa.addMouseMotionListener(arrastaComponentes);
            pn_mapa.add(painelMapa);
        }
        for (CameraBean camera : listarCameraNaoDeletada()) {
            PainelMapa painelMapa = new PainelMapa(this, camera);
            painelMapa.setName(camera.getNome());
            painelMapa.setSize(larguraMapa, alturaMapa);
            if(props != null) {
                painelMapa.setLocation(verificaLocalizacaoCamera(camera));
            }
            ArrastaComponentes arrastaComponentes = new ArrastaComponentes(painelMapa);
            painelMapa.addMouseListener(arrastaComponentes);
            painelMapa.addMouseMotionListener(arrastaComponentes);
            pn_mapa.add(painelMapa);
        }
        pn_mapa.repaint();
    }

    private Point verificaLocalizacaoDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico) {
        if(props != null) {
            String codigo = dispositivoEletrico.getCodigo().toString();
            String coordenadas = props.getProperty("DispositivoEletrico_" + codigo);
            return ArquivosUtil.retornaLocalizacaoPixels(coordenadas);
        }
        return null;
    }

    private Point verificaLocalizacaoCamera(CameraBean camera) {
        if(props != null) {
            String codigo = camera.getCodigo().toString();
            String coordenadas = props.getProperty("Camera_" + codigo);
            return ArquivosUtil.retornaLocalizacaoPixels(coordenadas);
        }
        return null;
    } 

    public Properties getProps() {
        return props;
    }

    private void agendarTarefa() {
        VincularAgendarTarefas dialog = new VincularAgendarTarefas(null, true, ConstantesSistema.VINCULO_DISPOSITIVO, cameraSelecionada);
        dialog.setVisible(true);
    }
    
    public void atualizarTela() {
        carregaMapaDispositivos();
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.mapaDispositivos());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
}
