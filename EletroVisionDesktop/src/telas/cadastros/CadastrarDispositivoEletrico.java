package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.area.bean.AreaBean;
import entidades.area.facade.AreaFacade;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import entidades.dispositivo.bean.EnumDeletadoDispositivo;
import entidades.dispositivo.bean.EnumStatusDispositivo;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.bean.EnumDuracaoDispositivoEletrico;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.internacionalizacao.MensagensTelas;
import telas.comuns.telas.VisualizadorImagens;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;
import util.SwingUtil;
import util.Validacao;

/**
 *
 * @author Hendrio Luis
 */
public class CadastrarDispositivoEletrico extends javax.swing.JPanel {

    private String nomeArquivo = "";

    public CadastrarDispositivoEletrico() {
        initComponents();
        nomeiaTela();
        InstanciasTelas.setCadastrarDispositivoEletrico(CadastrarDispositivoEletrico.this);

        preencherComboMarca();
        preencherModulosAcionamento();
        preencherComboPredio();
        preencherComboDuracao();
    }

    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
        lb_moduloAcionamento.setText(MensagensTelas.cad_moduloAcionamento());
        lb_duracao.setText(MensagensTelas.cad_duracao());
        lb_saidaEletrica.setText(MensagensTelas.cad_saidaEletrica());
        lb_marca.setText(MensagensTelas.cad_marca());
        lb_predio.setText(MensagensTelas.cad_predio());
        lb_area.setText(MensagensTelas.cad_area());
        pn_imagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
                MensagensTelas.cad_imagem(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pn_campos = new javax.swing.JPanel();
        tf_nome = new javax.swing.JTextField();
        lb_nome = new javax.swing.JLabel();
        lb_saidaEletrica = new javax.swing.JLabel();
        lb_marca = new javax.swing.JLabel();
        cb_marca = new javax.swing.JComboBox();
        lb_moduloAcionamento = new javax.swing.JLabel();
        cb_modulo = new javax.swing.JComboBox();
        lb_area = new javax.swing.JLabel();
        cb_area = new javax.swing.JComboBox();
        lb_codigo = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        cb_identificacao = new javax.swing.JComboBox();
        lb_predio = new javax.swing.JLabel();
        cb_predio = new javax.swing.JComboBox();
        lb_duracao = new javax.swing.JLabel();
        cb_duracao = new javax.swing.JComboBox();
        pn_imagem = new javax.swing.JPanel();
        lb_imagem = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bt_addImage = new javax.swing.JButton();

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        lb_saidaEletrica.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_saidaEletrica.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_saidaEletrica.setText("Saída elétrica:*");

        lb_marca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_marca.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_marca.setText("Marca:*");

        cb_marca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_moduloAcionamento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_moduloAcionamento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_moduloAcionamento.setText("Módulo Acionamento:*");

        cb_modulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_modulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_moduloActionPerformed(evt);
            }
        });

        lb_area.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_area.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_area.setText("Área:*");
        lb_area.setToolTipText("");

        cb_area.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_codigo.setEnabled(false);

        cb_identificacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_predio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_predio.setText("Prédio:*");

        cb_predio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_predio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_predioActionPerformed(evt);
            }
        });

        lb_duracao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_duracao.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_duracao.setText("Duração:*");

        cb_duracao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_duracao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escolha a duração dispositivo>", "Permanente", "Curto" }));

        javax.swing.GroupLayout pn_camposLayout = new javax.swing.GroupLayout(pn_campos);
        pn_campos.setLayout(pn_camposLayout);
        pn_camposLayout.setHorizontalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_marca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_codigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_saidaEletrica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_predio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_moduloAcionamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_duracao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_area, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_predio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_modulo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_identificacao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_codigo))
                .addContainerGap())
        );
        pn_camposLayout.setVerticalGroup(
            pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_moduloAcionamento)
                    .addComponent(cb_modulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_saidaEletrica)
                    .addComponent(cb_identificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_duracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_duracao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_marca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_predio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_predio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_area))
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

        bt_addImage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_addImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/adicionar_22x22.png"))); // NOI18N
        bt_addImage.setToolTipText("Adicionar Foto");
        bt_addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_addImage, jButton1});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
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

private void cb_predioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_predioActionPerformed
    preencherComboAreaPorPredio();
}//GEN-LAST:event_cb_predioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lb_imagem.setIcon(null);
        nomeArquivo = "";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addImageActionPerformed
        VisualizadorImagens dialog = new VisualizadorImagens(null, true, ArquivosImagens.diretorio_dispositivos(), this);
        dialog.setVisible(true);
    }//GEN-LAST:event_bt_addImageActionPerformed

    private void cb_moduloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_moduloActionPerformed
        if (cb_modulo.getSelectedIndex() > 0) {
            preencheComboIdentficacaoPorModuloAcionamento();
        }
    }//GEN-LAST:event_cb_moduloActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addImage;
    private javax.swing.JComboBox cb_area;
    private javax.swing.JComboBox cb_duracao;
    private javax.swing.JComboBox cb_identificacao;
    private javax.swing.JComboBox cb_marca;
    private javax.swing.JComboBox cb_modulo;
    private javax.swing.JComboBox cb_predio;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_area;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_duracao;
    private javax.swing.JLabel lb_imagem;
    private javax.swing.JLabel lb_marca;
    private javax.swing.JLabel lb_moduloAcionamento;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_predio;
    private javax.swing.JLabel lb_saidaEletrica;
    private javax.swing.JPanel pn_campos;
    private javax.swing.JPanel pn_imagem;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables

    private void preencherComboDuracao() {
        cb_duracao.removeAllItems();
        cb_duracao.addItem(MensagensTelas.cad_selecionarDuracaoDispositivo());
        cb_duracao.addItem(MensagensTelas.cad_permanente());
        cb_duracao.addItem(MensagensTelas.cad_curto());
    }

    private void preencherComboMarca() {
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

    private void preencherModulosAcionamento() {
        cb_modulo.removeAllItems();
        cb_modulo.addItem(MensagensTelas.cad_selecionarModuloAcionamento());
        for (ModuloAcionamentoBean modulo : listaModulosAcionamento()) {
            cb_modulo.addItem(modulo);
        }
    }

    private void preencheComboIdentficacaoPorModuloAcionamento() {
        if (cb_modulo.getSelectedIndex() > 0) {
            cb_identificacao.removeAllItems();
            cb_identificacao.addItem(MensagensTelas.cad_selecionarSaidaEletrica());
            ModuloAcionamentoBean bean = (ModuloAcionamentoBean) cb_modulo.getSelectedItem();
            for (int i = 1; i <= bean.getQtdeSaida(); i++) {
                cb_identificacao.addItem(i);
            }
        }
    }

    ///////////METODOS DE VERIFICAÇÃO//////////////////////////////////////////
    private Boolean verificaNomeExiste() {
        for (ModuloAcionamentoBean modulo : listaModuloAcionamentoOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(modulo.getCodigo().toString())) {
                if (tf_nome.getText().toUpperCase().equals(modulo.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaNomeIgualCamera() {
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
        } else if (verificaNomeIgualCamera()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeCamera());
            return false;
        } else if (verificaNomeIgualDispositivoEletrico()) {
            tf_nome.requestFocus();
            tf_nome.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeDispositivoEletrico());
            return false;
        } else if (cb_modulo.getSelectedIndex() == 0) {
            cb_modulo.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadDispositivoEletricoModulo());
            return false;
        } else if (cb_identificacao.getSelectedIndex() == 0) {
            cb_identificacao.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadDispositivoEletricoSaidaEletrica());
            return false;
        } else if (cb_predio.getSelectedIndex() == 0) {
            cb_predio.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumPredio());
            return false;
        } else if (cb_marca.getSelectedIndex() == 0) {
            cb_marca.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumMarca());
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
    ///////////FIM METODOS DE VERIFICAÇÃO///////////////////////////////////////

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_campos);
        cb_modulo.setSelectedIndex(0);
        cb_area.setSelectedIndex(0);
        cb_marca.setSelectedIndex(0);
        cb_identificacao.setSelectedIndex(0);
        cb_predio.setSelectedIndex(0);
        cb_duracao.setSelectedIndex(0);
        nomeArquivo = "";
        lb_imagem.setIcon(null);
    }

    ////////////////////////////////////////////////////////////////////////////
    private DispositivoEletricoBean populaDispositivoEletrico() {
        DispositivoEletricoBean dispositivoEletrico = new DispositivoEletricoBean();

        if (!tf_codigo.getText().equals("")) {
            dispositivoEletrico.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        dispositivoEletrico.setModuloAcionamento((ModuloAcionamentoBean) cb_modulo.getSelectedItem());
        dispositivoEletrico.setArea((AreaBean) cb_area.getSelectedItem());
        dispositivoEletrico.setDeletado(EnumDeletadoDispositivo.NAO);
        dispositivoEletrico.setIdentificacao(cb_identificacao.getSelectedItem().toString());
        dispositivoEletrico.setMarcaBean((MarcaBean) cb_marca.getSelectedItem());
        dispositivoEletrico.setNome(tf_nome.getText().toUpperCase());
        dispositivoEletrico.setStatus(EnumStatusDispositivo.ATIVO);
        dispositivoEletrico.setLigarDesligar(EnumLigarDesligarDispositivoEletrico.DESLIGADO);
        dispositivoEletrico.setFoto(nomeArquivo);
        if (cb_duracao.getSelectedIndex() == 1) {
            dispositivoEletrico.setDuracao(EnumDuracaoDispositivoEletrico.PERMANENTE);
        } else if (cb_duracao.getSelectedIndex() == 2) {
            dispositivoEletrico.setDuracao(EnumDuracaoDispositivoEletrico.CURTO);
        }

        return dispositivoEletrico;
    }

    public void salvar() {
        if (validaCampos()) {
            if (insereDispositivoEletrico(populaDispositivoEletrico()) != null) {
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadDispositivoEletricoSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                AtualizaTelas.pesquisarDispositivoEletrico();
                AtualizaTelas.geralMapaDispositivos();
            }
        }
    }

    public void exibirImagem(BufferedImage buffer, String nomeArquivo) {
        lb_imagem.setIcon(new ImageIcon(ImagemUtil.bufferedImageParaImage(buffer)));
        this.nomeArquivo = nomeArquivo;
    }

    public void atualizarTela() {
        preencherComboMarca();
        preencherModulosAcionamento();
        preencherComboPredio();
        preencherComboAreaPorPredio();
    }

    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros() + ArquivosHTML.dispositivoEletrico());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual);
    }

    public void preencheCampos(DispositivoEletricoBean dispositivoEletrico) {
        tf_codigo.setText(dispositivoEletrico.getCodigo().toString());
        tf_nome.setText(dispositivoEletrico.getNome());
        nomeArquivo = dispositivoEletrico.getFoto();
        lb_imagem.setIcon(new ImageIcon(ArquivosImagens.diretorio_dispositivos()
                + File.separator + dispositivoEletrico.getFoto()));

        SwingUtil.selecionaItemCombo(dispositivoEletrico.getModuloAcionamento(), cb_modulo);
        SwingUtil.selecionaItemCombo(dispositivoEletrico.getIdentificacao(), cb_identificacao);
        if (dispositivoEletrico.getDuracao() == EnumDuracaoDispositivoEletrico.PERMANENTE) {
            cb_duracao.setSelectedIndex(1);
        } else if (dispositivoEletrico.getDuracao() == EnumDuracaoDispositivoEletrico.CURTO) {
            cb_duracao.setSelectedIndex(2);
        }
        SwingUtil.selecionaItemCombo(dispositivoEletrico.getMarcaBean(), cb_marca);
        SwingUtil.selecionaItemCombo(dispositivoEletrico.getArea().getPredio(), cb_predio);
        SwingUtil.selecionaItemCombo(dispositivoEletrico.getArea(), cb_area);
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

    private ArrayList<ModuloAcionamentoBean> listaModulosAcionamento() {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return (ArrayList<ModuloAcionamentoBean>) moduloAcionamentoFacade.listar();
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

    private ArrayList<AreaBean> listarAreaPorPredio() {
        AreaFacade areaFacade = FactoryFacade.getAreaImpl();
        try {
            return areaFacade.pesquisarAreaPorPredio((PredioBean) cb_predio.getSelectedItem());
        } catch (FacadeException ex) {
        }
        return null;
    }

    private DispositivoEletricoBean insereDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico) {
        DispositivoEletricoFacade dispositivoEletricoFacade = FactoryFacade.getDispositivoEletricoImpl();
        try {
            return dispositivoEletricoFacade.insereOuAltera(dispositivoEletrico);
        } catch (FacadeException ex) {
        }
        return null;
    }

}
