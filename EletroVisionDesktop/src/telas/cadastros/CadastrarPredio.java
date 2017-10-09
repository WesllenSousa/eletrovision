package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.configPredio.bean.ConfigPredioBean;
import entidades.configPredio.facade.ConfigPredioFacade;
import entidades.endereco.bean.EnderecoBean;
import entidades.endereco.facade.EnderecoFacade;
import entidades.predio.bean.EnumDeletadoPredio;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import entidades.predio.facade.PredioFacade;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.internacionalizacao.MensagensTelas;
import telas.comuns.telas.EscolherFotoImagem;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;
import util.SwingUtil;
import util.Validacao;

/**
 *
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class CadastrarPredio extends javax.swing.JPanel {

    private BufferedImage foto;

    public CadastrarPredio() {
        initComponents();
        nomeiaTela();
        tf_codigoEndereco.setVisible(false);
        tf_codigoConfigPredio.setVisible(false);

        removerFoto();    
        preencherComboEndereco();
        preencherComboTipoPredio();
    }
    
    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
        lb_tipo.setText(MensagensTelas.cad_tipo());
        lb_enderecos.setText(MensagensTelas.cad_enderecos());
        lb_estado.setText(MensagensTelas.cad_estado());
        lb_cidade.setText(MensagensTelas.cad_cidade());
        lb_bairro.setText(MensagensTelas.cad_bairro());
        lb_logradouro.setText(MensagensTelas.cad_logradouro());
        lb_numero.setText(MensagensTelas.cad_numero());
        lb_referencia.setText(MensagensTelas.cad_referencia());
        lb_longitude.setText(MensagensTelas.cad_longitude());
        lb_latitude.setText(MensagensTelas.cad_latitude()); 
        pn_coordenadasGeograficas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                MensagensTelas.cad_coordenadasGeograficas(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12)));
        
        tb_pane.setTitleAt(0, MensagensTelas.cad_dados());
        tb_pane.setTitleAt(1, MensagensTelas.cad_endereco());
        tb_pane.setTitleAt(2, MensagensTelas.cad_outros());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tb_pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pn_camposDados = new javax.swing.JPanel();
        lb_nome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        lb_tipo = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox();
        lb_codigo = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnx_imagem = new org.jdesktop.swingx.JXImageView();
        pn_camposEndereco = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pn_en = new javax.swing.JPanel();
        pn_endereco = new javax.swing.JPanel();
        tf_cidade = new javax.swing.JTextField();
        lb_estado = new javax.swing.JLabel();
        lb_numero = new javax.swing.JLabel();
        tf_numero = new javax.swing.JTextField();
        tf_logradouro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_referencia = new javax.swing.JTextArea();
        lb_bairro = new javax.swing.JLabel();
        tf_bairro = new javax.swing.JTextField();
        cb_estado = new javax.swing.JComboBox();
        lb_cidade = new javax.swing.JLabel();
        lb_logradouro = new javax.swing.JLabel();
        lb_referencia = new javax.swing.JLabel();
        lb_enderecos = new javax.swing.JLabel();
        cb_enderecos = new javax.swing.JComboBox();
        tf_codigoEndereco = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        pn_coordenadasGeograficas = new javax.swing.JPanel();
        lb_longitude = new javax.swing.JLabel();
        tf_longitude = new javax.swing.JTextField();
        lb_latitude = new javax.swing.JLabel();
        tf_latitude = new javax.swing.JTextField();
        tf_codigoConfigPredio = new javax.swing.JTextField();

        tb_pane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_tipo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_tipo.setText("Tipo:*");

        cb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Escolha o tipo do prédio>", "Residência", "Comércio", "Industria" }));

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        tf_codigo.setEditable(false);
        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pn_camposDadosLayout = new javax.swing.GroupLayout(pn_camposDados);
        pn_camposDados.setLayout(pn_camposDadosLayout);
        pn_camposDadosLayout.setHorizontalGroup(
            pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposDadosLayout.createSequentialGroup()
                .addGroup(pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nome)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_camposDadosLayout.setVerticalGroup(
            pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_codigo)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tipo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pnx_imagem.setDragEnabled(true);

        javax.swing.GroupLayout pnx_imagemLayout = new javax.swing.GroupLayout(pnx_imagem);
        pnx_imagem.setLayout(pnx_imagemLayout);
        pnx_imagemLayout.setHorizontalGroup(
            pnx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        pnx_imagemLayout.setVerticalGroup(
            pnx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_camposDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnx_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_camposDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnx_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        tb_pane.addTab("Dados", jPanel2);

        tf_cidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_estado.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_estado.setText("Estado:*");

        lb_numero.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_numero.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_numero.setText("Número:*");

        tf_logradouro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ta_referencia.setColumns(20);
        ta_referencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ta_referencia.setRows(5);
        jScrollPane2.setViewportView(ta_referencia);

        lb_bairro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_bairro.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_bairro.setText("Bairro:*");

        tf_bairro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione um Estado>", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Minas Gerais", "Mato Grosso do Sul", "Mato Grosso", "Pará", "Paraíba", "Pernambuco", "Piauí", "Paraná", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins" }));

        lb_cidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_cidade.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_cidade.setText("Cidade:*");

        lb_logradouro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_logradouro.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_logradouro.setText("Logradouro:*");

        lb_referencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_referencia.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_referencia.setText("Referência:*");

        lb_enderecos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_enderecos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_enderecos.setText("Endereços:");

        cb_enderecos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_enderecos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Endereços Existentes>", "Amapá", "Distrito Federal", "Rio de Janeiro", "São Paulo", "Mato Grosso", "Mato Grosso do Sul", "Rondônia", "Goiania", "Minas Gerais", "Pará", "Roraima" }));
        cb_enderecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_enderecosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_enderecoLayout = new javax.swing.GroupLayout(pn_endereco);
        pn_endereco.setLayout(pn_enderecoLayout);
        pn_enderecoLayout.setHorizontalGroup(
            pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_enderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_enderecos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_bairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_logradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_referencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tf_numero, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(tf_cidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_bairro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_logradouro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_estado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_enderecos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_enderecoLayout.setVerticalGroup(
            pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_enderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_enderecos)
                    .addComponent(cb_enderecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_estado)
                    .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cidade)
                    .addComponent(tf_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_bairro)
                    .addComponent(tf_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_logradouro)
                    .addComponent(tf_logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_numero)
                    .addComponent(tf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_referencia)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tf_codigoEndereco.setEnabled(false);

        javax.swing.GroupLayout pn_enLayout = new javax.swing.GroupLayout(pn_en);
        pn_en.setLayout(pn_enLayout);
        pn_enLayout.setHorizontalGroup(
            pn_enLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_enLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(tf_codigoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        pn_enLayout.setVerticalGroup(
            pn_enLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_enLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_enLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_codigoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(pn_en);

        javax.swing.GroupLayout pn_camposEnderecoLayout = new javax.swing.GroupLayout(pn_camposEndereco);
        pn_camposEndereco.setLayout(pn_camposEnderecoLayout);
        pn_camposEnderecoLayout.setHorizontalGroup(
            pn_camposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pn_camposEnderecoLayout.setVerticalGroup(
            pn_camposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        tb_pane.addTab("Endereço", pn_camposEndereco);

        pn_coordenadasGeograficas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coordenadas Geográficas (Para o GPS)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        lb_longitude.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_longitude.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_longitude.setText("Longitude:");

        tf_longitude.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_latitude.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_latitude.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_latitude.setText("Latitude:");

        tf_latitude.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pn_coordenadasGeograficasLayout = new javax.swing.GroupLayout(pn_coordenadasGeograficas);
        pn_coordenadasGeograficas.setLayout(pn_coordenadasGeograficasLayout);
        pn_coordenadasGeograficasLayout.setHorizontalGroup(
            pn_coordenadasGeograficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_coordenadasGeograficasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_coordenadasGeograficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_latitude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_longitude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_coordenadasGeograficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_longitude, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_latitude, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_coordenadasGeograficasLayout.setVerticalGroup(
            pn_coordenadasGeograficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_coordenadasGeograficasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_coordenadasGeograficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_longitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_longitude))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_coordenadasGeograficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_latitude)
                    .addComponent(tf_latitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tf_codigoConfigPredio.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_coordenadasGeograficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(tf_codigoConfigPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_codigoConfigPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_coordenadasGeograficas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        tb_pane.addTab("Outros", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    abrirTelaEscolherImagem();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        removerFoto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_enderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_enderecosActionPerformed
        preencheCamposEndereco();
    }//GEN-LAST:event_cb_enderecosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_enderecos;
    private javax.swing.JComboBox cb_estado;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_bairro;
    private javax.swing.JLabel lb_cidade;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_enderecos;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_latitude;
    private javax.swing.JLabel lb_logradouro;
    private javax.swing.JLabel lb_longitude;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_numero;
    private javax.swing.JLabel lb_referencia;
    private javax.swing.JLabel lb_tipo;
    private javax.swing.JPanel pn_camposDados;
    private javax.swing.JPanel pn_camposEndereco;
    private javax.swing.JPanel pn_coordenadasGeograficas;
    private javax.swing.JPanel pn_en;
    private javax.swing.JPanel pn_endereco;
    private org.jdesktop.swingx.JXImageView pnx_imagem;
    private javax.swing.JTextArea ta_referencia;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_bairro;
    private javax.swing.JTextField tf_cidade;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_codigoConfigPredio;
    private javax.swing.JTextField tf_codigoEndereco;
    private javax.swing.JTextField tf_latitude;
    private javax.swing.JTextField tf_logradouro;
    private javax.swing.JTextField tf_longitude;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_numero;
    // End of variables declaration//GEN-END:variables

    private void preencherComboTipoPredio() {
        cb_tipo.removeAllItems();
        cb_tipo.addItem(MensagensTelas.cad_tipoPredio());
        cb_tipo.addItem(MensagensTelas.cad_residencia());
        cb_tipo.addItem(MensagensTelas.cad_comercio());
        cb_tipo.addItem(MensagensTelas.cad_industria());
    }
    
    public void setarFoto(BufferedImage foto) {
        this.foto = foto;
        exibirFoto();
    }

    private void abrirTelaEscolherImagem() {
        EscolherFotoImagem dialog = new EscolherFotoImagem(null, true, this);
        dialog.setVisible(true);
    }

    private Boolean verificaPredioExiste() {
        for (PredioBean predio : selecionaPredioOrdenadoPorCodigo()) {
            if (!tf_codigo.getText().equals(predio.getCodigo().toString())) {
                if (predio.getNome().equals(tf_nome.getText().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean validaCampos() {
        if (Validacao.verificaStringVazia(tf_nome.getText())) {
            tb_pane.setSelectedIndex(0);
            tf_nome.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeVazio());
            return false;
        } else if (verificaPredioExiste()) {
            tb_pane.setSelectedIndex(0);
            tf_nome.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeExiste());
            return false;
        } else if (cb_tipo.getSelectedIndex() == 0) {
            tb_pane.setSelectedIndex(0);
            cb_tipo.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPredioTipo());
            return false;
        } else if (cb_estado.getSelectedIndex() == 0) {
            tb_pane.setSelectedIndex(1);
            cb_estado.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumEstadoSelecionar());
            return false;
        } else if (Validacao.verificaStringVazia(tf_cidade.getText())) {
            tb_pane.setSelectedIndex(1);
            tf_cidade.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumCidadeVazia());
            return false;
        } else if (Validacao.verificaStringVazia(tf_bairro.getText())) {
            tb_pane.setSelectedIndex(1);
            tf_bairro.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumBairroVazio());
            return false;
        } else if (Validacao.verificaStringVazia(tf_logradouro.getText())) {
            tb_pane.setSelectedIndex(1);
            tf_logradouro.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumLogradouroVazio());
            return false;
        } else if (Validacao.verificaStringVazia(tf_numero.getText())) {
            tb_pane.setSelectedIndex(1);
            tf_numero.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNumeroVazio());
            return false;
        } else if (!Validacao.verificaNumeroInteger(tf_numero.getText().trim())) {
            tb_pane.setSelectedIndex(1);
            tf_numero.requestFocus();
            tf_numero.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNumeroInvalido());
            return false;
        } else if (Validacao.verificaNumeroNegativo(tf_numero.getText().trim())) {
            tb_pane.setSelectedIndex(1);
            tf_numero.requestFocus();
            tf_numero.setText("");
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNumeroNegativo());
            return false;
        } else if (Validacao.verificaStringVazia(ta_referencia.getText())) {
            tb_pane.setSelectedIndex(1);
            ta_referencia.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumReferenciaVazia());
            return false;
        } else if (!tf_longitude.getText().equals("") && !Validacao.verificaNumeroDouble(tf_longitude.getText())) {
            tb_pane.setSelectedIndex(2);
            tf_longitude.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPredioLongitude());
            return false;
        } else if ((!tf_longitude.getText().equals("") || !tf_latitude.getText().equals("")) 
                && !Validacao.verificaNumeroDouble(tf_latitude.getText())) {
            tb_pane.setSelectedIndex(2);
            tf_latitude.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPredioLatitude());
            return false;
        }
        
        return true;
    }

    private void exibirFoto() {
        pnx_imagem.setImage(ImagemUtil.redimencionar(foto, 200, 150));
    }

    private void removerFoto() {
        foto = ImagemUtil.ler(ArquivosImagens.sistema_semImagem());
        exibirFoto();
        foto = null;
    }

    /////////////// METODOS PARA POPULAR ENTIDADES//////////////////////////////
    private EnderecoBean populaEnderecoBean() {
        EnderecoBean endereco = new EnderecoBean();

        if (!tf_codigoEndereco.getText().equals("")) {
            endereco.setCodigo(Integer.parseInt(tf_codigoEndereco.getText()));
        }
        endereco.setEstado(cb_estado.getSelectedItem().toString().toUpperCase());
        endereco.setCidade(tf_cidade.getText().toUpperCase());
        endereco.setBairro(tf_bairro.getText().toUpperCase());
        endereco.setLogradouro(tf_logradouro.getText().toUpperCase());
        endereco.setNumero(Integer.parseInt(tf_numero.getText()));
        endereco.setReferencia(ta_referencia.getText().toUpperCase()); 
        
        return endereco;
    }

    private PredioBean populaPredio(EnderecoBean endereco, ConfigPredioBean configPredio) {
        PredioBean predio = new PredioBean();

        predio.setNome(tf_nome.getText().toUpperCase());
        if (!tf_codigo.getText().equals("")) {
            predio.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        predio.setDeletado(EnumDeletadoPredio.NAO);
        predio.setEndereco(endereco);
        if(foto != null) {
            predio.setFoto(tf_nome.getText().replace(' ', '_') + ".png");
        }
        if (cb_tipo.getSelectedIndex() == 1) {
            predio.setTipo(EnumTipoPredio.RESIDENCIA);
        } else if (cb_tipo.getSelectedIndex() == 2) {
            predio.setTipo(EnumTipoPredio.COMERCIO);
        } else if (cb_tipo.getSelectedIndex() == 3) {
            predio.setTipo(EnumTipoPredio.INDUSTRIA);
        }
        predio.setConfigPredio(configPredio); 
        
        return predio;
    }
    
    private ConfigPredioBean populaConfigPredioBean() {
        ConfigPredioBean bean = new ConfigPredioBean();
        
        if (!tf_codigoConfigPredio.getText().equals("")) {
            bean.setCodigo(Integer.parseInt(tf_codigoConfigPredio.getText()));
        }
        bean.setLongitude(Double.parseDouble(tf_longitude.getText()));
        bean.setLatitude(Double.parseDouble(tf_latitude.getText()));
        
        return bean;
    }

    ///////////////FIM METODOS PARA POPULAR ENTIDADES/////////////////////////
    ///////////////METODOS PARA INSERIR NO BANCO/////////////////////////////
   
    private Boolean inserirEntidades() {
        EnderecoBean endereco = inserirEndereco(populaEnderecoBean());
        ConfigPredioBean configPredio = null;
        if(!tf_latitude.getText().equals("") && !tf_longitude.getText().equals("")) {
            configPredio = inserirConfigPredio(populaConfigPredioBean());
        }
        if (endereco == null) {
            return false;
        }
        if (inserirPredio(populaPredio(endereco, configPredio)) == null) {
            return false;
        }
        return true;
    }

    ///////////////FIM METODOS PARA INSERIR NO BANCO//////////////////////////
    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_camposDados);
        cb_tipo.setSelectedIndex(0);
        SwingUtil.limparCamposJTextField(pn_endereco);
        cb_estado.setSelectedIndex(0);
        ta_referencia.setText("");
        removerFoto();
    }

    public void preencheCampos(PredioBean predio) {
        tf_codigo.setText(predio.getCodigo().toString());
        tf_nome.setText(predio.getNome());
        SwingUtil.selecionaItemCombo(predio.getTipo().toString(), cb_tipo);
        SwingUtil.selecionaItemCombo(predio.getEndereco().getEstado(), cb_estado);
        tf_cidade.setText(predio.getEndereco().getCidade());
        tf_bairro.setText(predio.getEndereco().getBairro());
        tf_logradouro.setText(predio.getEndereco().getLogradouro());
        tf_numero.setText(predio.getEndereco().getNumero().toString());
        ta_referencia.setText(predio.getEndereco().getReferencia());  
        if(predio.getConfigPredio() != null) {
            tf_latitude.setText(predio.getConfigPredio().getLatitude().toString());
        }
        if(predio.getConfigPredio() != null) {
            tf_longitude.setText(predio.getConfigPredio().getLongitude().toString()); 
        }
        if(predio.getFoto() != null) {
            foto = ImagemUtil.ler(ArquivosImagens.diretorio_cadastros()+File.separator+predio.getFoto());
            exibirFoto();
        } else {
            removerFoto();
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    public void salvar() {
        if (validaCampos()) {
            if (inserirEntidades()) {
                if(foto != null) {
                    ImagemUtil.salvar(foto, ArquivosImagens.diretorio_cadastros() + File.separator + tf_nome.getText().replace(' ', '_') + ".png");
                }
                
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadPredioSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                preencherComboEndereco();
                AtualizaTelas.pesquisarPredio();
                AtualizaTelas.cadastrarArea();
                AtualizaTelas.cadastrarCamera();
                AtualizaTelas.cadastrarDispositivoEletrico();
                AtualizaTelas.ferramentasEditarImagens();
            }
        }
    }
    
    private void preencherComboEndereco() {
        cb_enderecos.removeAllItems();
        cb_enderecos.addItem(MensagensTelas.cad_enderecosExistentes());
        for(String endereco : listarEnderecoOrdenadoPorLogradouro()) {
            cb_enderecos.addItem(endereco); 
        }
    }
    
    private void preencheCamposEndereco() {
        if(cb_enderecos.getSelectedIndex() != 0 && cb_enderecos.getSelectedItem() != null) {
            EnderecoBean endereco = pesquisarEnderecoPorLogradouro(cb_enderecos.getSelectedItem().toString());
            if(endereco != null) {
                SwingUtil.selecionaItemCombo(endereco.getEstado(), cb_estado);
                tf_cidade.setText(endereco.getCidade());
                tf_bairro.setText(endereco.getBairro());
                tf_logradouro.setText(endereco.getLogradouro());
                tf_numero.setText(endereco.getNumero().toString());
                ta_referencia.setText(endereco.getReferencia());
                tf_codigoEndereco.setText(endereco.getCodigo().toString());
            }
        } else {
            cb_estado.setSelectedIndex(0);
            tf_cidade.setText("");
            tf_bairro.setText("");
            tf_logradouro.setText("");
            tf_numero.setText("");
            ta_referencia.setText("");
            tf_codigoEndereco.setText("");
        }
    }
    
    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros()+ArquivosHTML.predio());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<PredioBean> selecionaPredioOrdenadoPorCodigo() {
        PredioFacade predioFacade = FactoryFacade.getPredioImpl();
        try {
            return predioFacade.listarPredioOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private EnderecoBean pesquisarEnderecoPorLogradouro(String logradouro) {
        EnderecoFacade enderecoFacade = FactoryFacade.getEnderecoImpl();
        try {
            return enderecoFacade.pesquisarEnderecoPorLogradouro(logradouro);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<String> listarEnderecoOrdenadoPorLogradouro() {
        EnderecoFacade enderecoFacade = FactoryFacade.getEnderecoImpl();
        try {
            return enderecoFacade.listarEnderecoOrdenadaPorLogradouro();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private PredioBean inserirPredio(PredioBean predio) {
        PredioFacade predioFacade = FactoryFacade.getPredioImpl();
        try {
            return predioFacade.insereOuAltera(predio);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private EnderecoBean inserirEndereco(EnderecoBean endereco) {
        EnderecoFacade enderecoFacade = FactoryFacade.getEnderecoImpl();
        try {
            return enderecoFacade.insereOuAltera(endereco);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ConfigPredioBean inserirConfigPredio(ConfigPredioBean configPredio) {
        ConfigPredioFacade configPredioFacade = FactoryFacade.getConfigPredioFacadeImpl();
        try {
            return configPredioFacade.insereOuAltera(configPredio);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
