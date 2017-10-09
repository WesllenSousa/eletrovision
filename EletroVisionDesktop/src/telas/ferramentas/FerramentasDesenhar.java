package telas.ferramentas;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.ferramentas.dependencias.Cores;
import telas.ferramentas.dependencias.Paint;
import telas.principal.Manual;
import util.DiretorioUtil;
import util.ImagemUtil;
import util.SwingUtil;
import util.Validacao;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class FerramentasDesenhar extends javax.swing.JPanel {

    private FerramentasEditarImagens ferramentasEditarImagens = null;
    private Cores cores;
    private Paint paint;
    private String arquivoEditar;

    public FerramentasDesenhar() {
        initComponents();

        btt_lapis.setSelected(true);
        pn_cor.setBackground(Color.BLACK);

        cores = new Cores(null, true, this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_ferramentas = new javax.swing.JPanel();
        bt_limpa = new javax.swing.JButton();
        pn_cor = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        bt_salvar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btt_lapis = new javax.swing.JToggleButton();
        btt_linha = new javax.swing.JToggleButton();
        btt_quadrado = new javax.swing.JToggleButton();
        btt_circulo = new javax.swing.JToggleButton();
        btt_quadradof = new javax.swing.JToggleButton();
        btt_circulof = new javax.swing.JToggleButton();
        btt_borracha = new javax.swing.JToggleButton();
        scroll = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        bt_ajuda = new javax.swing.JButton();

        bt_limpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/limparTudo_22x22.png"))); // NOI18N
        bt_limpa.setToolTipText("Limpar Tudo");
        bt_limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limpaActionPerformed(evt);
            }
        });

        pn_cor.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        pn_cor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pn_cor.setForeground(java.awt.Color.white);
        pn_cor.setToolTipText("Clique aqui para alterar a cor");
        pn_cor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_corMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_corMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_corMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_corLayout = new javax.swing.GroupLayout(pn_cor);
        pn_cor.setLayout(pn_corLayout);
        pn_corLayout.setHorizontalGroup(
            pn_corLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        pn_corLayout.setVerticalGroup(
            pn_corLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/salvar_22x22.png"))); // NOI18N
        bt_salvar.setToolTipText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        btt_lapis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/lapis_22x22.png"))); // NOI18N
        btt_lapis.setToolTipText("Lápis");
        btt_lapis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_lapisActionPerformed(evt);
            }
        });

        btt_linha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/linha_22x22.png"))); // NOI18N
        btt_linha.setToolTipText("Linha");
        btt_linha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_linhaActionPerformed(evt);
            }
        });

        btt_quadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/retangulo_22x22.png"))); // NOI18N
        btt_quadrado.setToolTipText("Retangulo");
        btt_quadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_quadradoActionPerformed(evt);
            }
        });

        btt_circulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/circulo_22x22.png"))); // NOI18N
        btt_circulo.setToolTipText("Círculo");
        btt_circulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_circuloActionPerformed(evt);
            }
        });

        btt_quadradof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/retanguloPreenchido_22x22.png"))); // NOI18N
        btt_quadradof.setToolTipText("Retangulo Preenchido");
        btt_quadradof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_quadradofActionPerformed(evt);
            }
        });

        btt_circulof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/circuloPrenchido_22x22.png"))); // NOI18N
        btt_circulof.setToolTipText("Círculo Preenchido");
        btt_circulof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_circulofActionPerformed(evt);
            }
        });

        btt_borracha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/formasGeometricas/borracha_22x22.png"))); // NOI18N
        btt_borracha.setToolTipText("Borracha");
        btt_borracha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_borrachaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ferramentasLayout = new javax.swing.GroupLayout(pn_ferramentas);
        pn_ferramentas.setLayout(pn_ferramentasLayout);
        pn_ferramentasLayout.setHorizontalGroup(
            pn_ferramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
            .addGroup(pn_ferramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ferramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ferramentasLayout.createSequentialGroup()
                        .addGroup(pn_ferramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt_limpa, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_borracha, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_circulof, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_quadradof, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_circulo, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_quadrado, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_linha, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(btt_lapis, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(bt_salvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pn_cor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_ferramentasLayout.setVerticalGroup(
            pn_ferramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ferramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_lapis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_linha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_quadrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_circulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_quadradof)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_circulof)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_borracha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_limpa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addComponent(pn_ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pn_ferramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

private void bt_limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limpaActionPerformed
    if (InstanciasControle.getMensagens().confirmacao(MensagensSoltas.ferrLimparTudo())) {
        paint.limparPainel();
        iniciarPaintVazio();
        btt_lapis.setSelected(true);
        pn_cor.setBackground(Color.black);
    }
}//GEN-LAST:event_bt_limpaActionPerformed

private void pn_corMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_corMouseEntered
    pn_cor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
}//GEN-LAST:event_pn_corMouseEntered

private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
    salvar();
}//GEN-LAST:event_bt_salvarActionPerformed

private void btt_lapisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_lapisActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.LAPIS;
    btt_lapis.setSelected(true);
}//GEN-LAST:event_btt_lapisActionPerformed

private void btt_linhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_linhaActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.LINHA;
    btt_linha.setSelected(true);
}//GEN-LAST:event_btt_linhaActionPerformed

private void btt_quadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_quadradoActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.RETANGULO;
    btt_quadrado.setSelected(true);
}//GEN-LAST:event_btt_quadradoActionPerformed

private void btt_circuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_circuloActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.CIRCULO;
    btt_circulo.setSelected(true);
}//GEN-LAST:event_btt_circuloActionPerformed

private void btt_quadradofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_quadradofActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.RETTANGULOF;
    btt_quadradof.setSelected(true);
}//GEN-LAST:event_btt_quadradofActionPerformed

private void btt_circulofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_circulofActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.CIRCULOF;
    btt_circulof.setSelected(true);
}//GEN-LAST:event_btt_circulofActionPerformed

private void btt_borrachaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_borrachaActionPerformed
    desabilitarSelecaoToggleButton();
    paint.status = paint.BORRACHA;
    btt_borracha.setSelected(true);
}//GEN-LAST:event_btt_borrachaActionPerformed

private void pn_corMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_corMouseExited
    pn_cor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
}//GEN-LAST:event_pn_corMouseExited

private void pn_corMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_corMouseClicked
    cores.cc_cor.setColor(pn_cor.getBackground());
    cores.setVisible(true);
    paint.atualizarCores(pn_cor.getBackground().getRed(), pn_cor.getBackground().getGreen(), pn_cor.getBackground().getBlue());
}//GEN-LAST:event_pn_corMouseClicked

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_limpa;
    public javax.swing.JButton bt_salvar;
    private javax.swing.JToggleButton btt_borracha;
    private javax.swing.JToggleButton btt_circulo;
    private javax.swing.JToggleButton btt_circulof;
    private javax.swing.JToggleButton btt_lapis;
    private javax.swing.JToggleButton btt_linha;
    private javax.swing.JToggleButton btt_quadrado;
    private javax.swing.JToggleButton btt_quadradof;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JPanel pn_cor;
    private javax.swing.JPanel pn_ferramentas;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    public void iniciarPaintVazio() {
        paint = new Paint(scroll.getWidth(), scroll.getHeight());
        paint.criarBuffereImage();
        scroll.setViewportView(paint); 
        paint.desenhaBufferImage();
    }
    
    public void iniciarPaintImagem(BufferedImage bufferedImage) {
        paint = new Paint(bufferedImage.getWidth(), bufferedImage.getHeight());
        paint.setBufferedImage(bufferedImage);     
        scroll.setViewportView(paint);
        paint.desenhaBufferImage();
    }

    private void desabilitarSelecaoToggleButton() {
        SwingUtil.desabilitarSelecaoToggleButton(pn_ferramentas);
    }

    private void salvar() {
        if(ferramentasEditarImagens != null) {
            ImagemUtil.salvar(paint.obtemImagem(), new File(arquivoEditar));
            ferramentasEditarImagens.atualizarArvore();
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrImagemSalvar());
        } else {
            String nome = InstanciasControle.getMensagens().inserirDadosComValorInicial(MensagensSoltas.ferrMapaPergunta(),
                    MensagensSoltas.ferrMapa());
            nome = nome.replace(' ', '_');
            if (!Validacao.verificaStringVazia(nome)) {
                File file = new File(ArquivosImagens.diretorio_mapas() + "/" + nome + ".png");
                if (DiretorioUtil.verificarSeArquivoDiretorioExiste(file)) {
                    ImagemUtil.salvar(paint.obtemImagem(), file);
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.ferrImagemSalvar());
                }
            }
        }
    }

    public void setEditar(FerramentasEditarImagens ferramentasEditarImagens, String arquivo) {
        arquivoEditar = arquivo;
        this.ferramentasEditarImagens = ferramentasEditarImagens;
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.ferramentas()+ArquivosHTML.desenharMapas());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
     
}
