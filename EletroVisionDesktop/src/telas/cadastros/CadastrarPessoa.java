package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.configPessoa.bean.ConfigPessoaBean;
import entidades.configPessoa.bean.EnumAlarmeGpsConfigPessoa;
import entidades.configPessoa.facade.ConfigPessoaFacade;
import entidades.email.bean.EmailBean;
import entidades.email.bean.EnumEnviarAutomaticoEmail;
import entidades.email.facade.EmailFacade;
import entidades.endereco.bean.EnderecoBean;
import entidades.endereco.facade.EnderecoFacade;
import entidades.pessoa.bean.EnumDeletadoPessoa;
import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import entidades.telefone.bean.EnumEnviarAutomaticoTelefone;
import entidades.telefone.bean.TelefoneBean;
import entidades.telefone.facade.TelefoneFacade;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.internacionalizacao.MensagensTelas;
import telas.comuns.camera.FrameFaceCamera;
import telas.comuns.telas.EscolherFotoImagem;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.*;

/**
 *
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class CadastrarPessoa extends javax.swing.JPanel {

    private BufferedImage foto;
    private String nomeAnterior;

    public CadastrarPessoa() {
        initComponents();
        nomeiaTela();
        tf_codigoCelular.setVisible(false);
        tf_codigoEmail.setVisible(false);
        tf_codigoEndereco.setVisible(false);
        tf_codigoConfigPessoa.setVisible(false);

        removerFoto();
        preencherComboEndereco();
        preencherComboTipos();
    }

    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_nome.setText(MensagensTelas.cad_nome());
        lb_cpf.setText(MensagensTelas.cad_cpf());
        lb_rg.setText(MensagensTelas.cad_rg());
        lb_nascimento.setText(MensagensTelas.cad_nascimento());
        lb_tipo.setText(MensagensTelas.cad_tipo());
        ck_ativo.setText(MensagensTelas.cad_ativo());
        lb_celular.setText(MensagensTelas.cad_celular());
        lb_email.setText(MensagensTelas.cad_email());
        ck_enviarAutomaticoCelular.setText(MensagensTelas.cad_enviarMensagemAutomatica());
        ck_enviarAutomaticoEmail.setText(MensagensTelas.cad_enviarMensagemAutomatica());
        lb_enderecos.setText(MensagensTelas.cad_enderecos());
        lb_estado.setText(MensagensTelas.cad_estado());
        lb_cidade.setText(MensagensTelas.cad_cidade());
        lb_bairro.setText(MensagensTelas.cad_bairro());
        lb_logradouro.setText(MensagensTelas.cad_logradouro());
        lb_numero.setText(MensagensTelas.cad_numero());
        lb_referencia.setText(MensagensTelas.cad_referencia());
        ck_ativarAlarmeGps.setText(MensagensTelas.cad_ativarAlarme());

        tb_pane.setTitleAt(0, MensagensTelas.cad_dadosPessoais());
        tb_pane.setTitleAt(1, MensagensTelas.cad_contatos());
        tb_pane.setTitleAt(2, MensagensTelas.cad_endereco());
        tb_pane.setTitleAt(3, MensagensTelas.cad_outros());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tb_pane = new javax.swing.JTabbedPane();
        pn_dados_pessoais = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bt_face = new javax.swing.JButton();
        pn_camposDadosPessoa = new javax.swing.JPanel();
        lb_rg = new javax.swing.JLabel();
        tf_cpf = new javax.swing.JFormattedTextField();
        lb_cpf = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        tf_dataNascimento = new net.sf.nachocalendar.components.DateField();
        lb_nascimento = new javax.swing.JLabel();
        lb_tipo = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox();
        tf_codigo = new javax.swing.JTextField();
        lb_codigo = new javax.swing.JLabel();
        tf_rg = new javax.swing.JTextField();
        ck_ativo = new javax.swing.JCheckBox();
        pnx_imagem = new org.jdesktop.swingx.JXImageView();
        pn_cont = new javax.swing.JPanel();
        pn_contatos = new javax.swing.JPanel();
        lb_celular = new javax.swing.JLabel();
        tf_ddd = new javax.swing.JFormattedTextField();
        tf_celular = new javax.swing.JFormattedTextField();
        tf_email = new javax.swing.JTextField();
        lb_email = new javax.swing.JLabel();
        ck_enviarAutomaticoCelular = new javax.swing.JCheckBox();
        ck_enviarAutomaticoEmail = new javax.swing.JCheckBox();
        tf_codigoCelular = new javax.swing.JTextField();
        tf_codigoEmail = new javax.swing.JTextField();
        pn_end = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pn_en = new javax.swing.JPanel();
        pn_endereco = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_referencia = new javax.swing.JTextArea();
        tf_cidade = new javax.swing.JTextField();
        lb_estado = new javax.swing.JLabel();
        lb_logradouro = new javax.swing.JLabel();
        lb_numero = new javax.swing.JLabel();
        tf_numero = new javax.swing.JTextField();
        lb_referencia = new javax.swing.JLabel();
        lb_bairro = new javax.swing.JLabel();
        tf_bairro = new javax.swing.JTextField();
        cb_estado = new javax.swing.JComboBox();
        tf_logradouro = new javax.swing.JTextField();
        lb_cidade = new javax.swing.JLabel();
        lb_enderecos = new javax.swing.JLabel();
        cb_enderecos = new javax.swing.JComboBox();
        tf_codigoEndereco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ck_ativarAlarmeGps = new javax.swing.JCheckBox();
        tf_codigoConfigPessoa = new javax.swing.JTextField();

        tb_pane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tb_pane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tb_pane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

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

        bt_face.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_face.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/face.png"))); // NOI18N
        bt_face.setToolTipText("Cadastrar face");
        bt_face.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_faceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_face, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bt_face, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        lb_rg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_rg.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_rg.setText("RG:*");

        try {
            tf_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_cpf.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_cpf.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_cpf.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_cpf.setText("CPF:*");

        lb_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nome.setText("Nome:*");

        tf_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tf_dataNascimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_nascimento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_nascimento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_nascimento.setText("Nascimento:*");

        lb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_tipo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_tipo.setText("Tipo:*");

        cb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione um Tipo>", "Dono", "Família", "Vigia", "Funcionário", "Outros" }));
        cb_tipo.setToolTipText("Selecione um Tipo");

        tf_codigo.setEditable(false);
        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        tf_rg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        ck_ativo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ativo.setSelected(true);
        ck_ativo.setText("Ativo");

        javax.swing.GroupLayout pn_camposDadosPessoaLayout = new javax.swing.GroupLayout(pn_camposDadosPessoa);
        pn_camposDadosPessoa.setLayout(pn_camposDadosPessoaLayout);
        pn_camposDadosPessoaLayout.setHorizontalGroup(
            pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_camposDadosPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_camposDadosPessoaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ck_ativo))
                    .addGroup(pn_camposDadosPessoaLayout.createSequentialGroup()
                        .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_cpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_rg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_nascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_tipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nome)
                            .addComponent(tf_codigo)
                            .addComponent(tf_cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(tf_dataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_rg)
                            .addComponent(cb_tipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_camposDadosPessoaLayout.setVerticalGroup(
            pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_camposDadosPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf)
                    .addComponent(tf_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_rg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nascimento)
                    .addComponent(tf_dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_camposDadosPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ck_ativo)
                .addGap(18, 18, 18))
        );

        pnx_imagem.setDragEnabled(true);

        javax.swing.GroupLayout pnx_imagemLayout = new javax.swing.GroupLayout(pnx_imagem);
        pnx_imagem.setLayout(pnx_imagemLayout);
        pnx_imagemLayout.setHorizontalGroup(
            pnx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnx_imagemLayout.setVerticalGroup(
            pnx_imagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_dados_pessoaisLayout = new javax.swing.GroupLayout(pn_dados_pessoais);
        pn_dados_pessoais.setLayout(pn_dados_pessoaisLayout);
        pn_dados_pessoaisLayout.setHorizontalGroup(
            pn_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dados_pessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_camposDadosPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnx_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(205, 205, 205))
        );
        pn_dados_pessoaisLayout.setVerticalGroup(
            pn_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dados_pessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dados_pessoaisLayout.createSequentialGroup()
                        .addComponent(pnx_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_camposDadosPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        tb_pane.addTab("Dados Pessoais", pn_dados_pessoais);

        lb_celular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_celular.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_celular.setText("Celular:*");

        try {
            tf_ddd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tf_celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tf_celular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tf_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_email.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_email.setText("Email:*");

        ck_enviarAutomaticoCelular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_enviarAutomaticoCelular.setText("Enviar mensagem automática");

        ck_enviarAutomaticoEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_enviarAutomaticoEmail.setText("Enviar mensagem automática");

        javax.swing.GroupLayout pn_contatosLayout = new javax.swing.GroupLayout(pn_contatos);
        pn_contatos.setLayout(pn_contatosLayout);
        pn_contatosLayout.setHorizontalGroup(
            pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_celular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_contatosLayout.createSequentialGroup()
                        .addComponent(tf_ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_celular))
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_enviarAutomaticoCelular)
                    .addComponent(ck_enviarAutomaticoEmail))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pn_contatosLayout.setVerticalGroup(
            pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_celular)
                    .addComponent(tf_ddd)
                    .addComponent(tf_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_enviarAutomaticoCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_email)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_enviarAutomaticoEmail))
                .addContainerGap())
        );

        tf_codigoCelular.setEnabled(false);

        tf_codigoEmail.setEnabled(false);

        javax.swing.GroupLayout pn_contLayout = new javax.swing.GroupLayout(pn_cont);
        pn_cont.setLayout(pn_contLayout);
        pn_contLayout.setHorizontalGroup(
            pn_contLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_contLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_codigoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_codigoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_contatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pn_contLayout.setVerticalGroup(
            pn_contLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_contatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_codigoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_codigoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        tb_pane.addTab("Contatos", pn_cont);

        ta_referencia.setColumns(20);
        ta_referencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ta_referencia.setRows(5);
        jScrollPane2.setViewportView(ta_referencia);

        tf_cidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_estado.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_estado.setText("Estado:*");

        lb_logradouro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_logradouro.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_logradouro.setText("Logradouro:*");

        lb_numero.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_numero.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_numero.setText("Número:*");

        tf_numero.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_referencia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_referencia.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_referencia.setText("Referência:*");

        lb_bairro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_bairro.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_bairro.setText("Bairro:*");

        tf_bairro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione um Estado>", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Minas Gerais", "Mato Grosso do Sul", "Mato Grosso", "Pará", "Paraíba", "Pernambuco", "Piauí", "Paraná", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins" }));

        tf_logradouro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_cidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_cidade.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_cidade.setText("Cidade:*");

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
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_numero)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(tf_cidade)
                    .addComponent(tf_bairro)
                    .addComponent(tf_logradouro)
                    .addComponent(cb_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(tf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_referencia)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tf_codigoEndereco.setEnabled(false);

        javax.swing.GroupLayout pn_enLayout = new javax.swing.GroupLayout(pn_en);
        pn_en.setLayout(pn_enLayout);
        pn_enLayout.setHorizontalGroup(
            pn_enLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_enLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_codigoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        pn_enLayout.setVerticalGroup(
            pn_enLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_enLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_codigoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
            .addGroup(pn_enLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(pn_en);

        javax.swing.GroupLayout pn_endLayout = new javax.swing.GroupLayout(pn_end);
        pn_end.setLayout(pn_endLayout);
        pn_endLayout.setHorizontalGroup(
            pn_endLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pn_endLayout.setVerticalGroup(
            pn_endLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tb_pane.addTab("Endereço", pn_end);

        ck_ativarAlarmeGps.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ck_ativarAlarmeGps.setText("Ativar alarme via localização GPS");

        tf_codigoConfigPessoa.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_ativarAlarmeGps)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(tf_codigoConfigPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_ativarAlarmeGps)
                    .addComponent(tf_codigoConfigPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        tb_pane.addTab("Outros", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
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

    private void bt_faceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_faceActionPerformed
        face();
    }//GEN-LAST:event_bt_faceActionPerformed

    private void cb_enderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_enderecosActionPerformed
        preencheCamposEndereco();
    }//GEN-LAST:event_cb_enderecosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_face;
    private javax.swing.JComboBox cb_enderecos;
    private javax.swing.JComboBox cb_estado;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.JCheckBox ck_ativarAlarmeGps;
    private javax.swing.JCheckBox ck_ativo;
    private javax.swing.JCheckBox ck_enviarAutomaticoCelular;
    private javax.swing.JCheckBox ck_enviarAutomaticoEmail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_bairro;
    private javax.swing.JLabel lb_celular;
    private javax.swing.JLabel lb_cidade;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_cpf;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_enderecos;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_logradouro;
    private javax.swing.JLabel lb_nascimento;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_numero;
    private javax.swing.JLabel lb_referencia;
    private javax.swing.JLabel lb_rg;
    private javax.swing.JLabel lb_tipo;
    private javax.swing.JPanel pn_camposDadosPessoa;
    private javax.swing.JPanel pn_cont;
    private javax.swing.JPanel pn_contatos;
    private javax.swing.JPanel pn_dados_pessoais;
    private javax.swing.JPanel pn_en;
    private javax.swing.JPanel pn_end;
    private javax.swing.JPanel pn_endereco;
    private org.jdesktop.swingx.JXImageView pnx_imagem;
    private javax.swing.JTextArea ta_referencia;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_bairro;
    private javax.swing.JFormattedTextField tf_celular;
    private javax.swing.JTextField tf_cidade;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_codigoCelular;
    private javax.swing.JTextField tf_codigoConfigPessoa;
    private javax.swing.JTextField tf_codigoEmail;
    private javax.swing.JTextField tf_codigoEndereco;
    private javax.swing.JFormattedTextField tf_cpf;
    private net.sf.nachocalendar.components.DateField tf_dataNascimento;
    private javax.swing.JFormattedTextField tf_ddd;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_logradouro;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_numero;
    private javax.swing.JTextField tf_rg;
    // End of variables declaration//GEN-END:variables

    private void preencherComboTipos() {
        cb_tipo.removeAllItems();
        cb_tipo.addItem(MensagensTelas.cad_selecionarTipo());
        cb_tipo.addItem(MensagensTelas.cad_dono());
        cb_tipo.addItem(MensagensTelas.cad_familia());
        cb_tipo.addItem(MensagensTelas.cad_vigia());
        cb_tipo.addItem(MensagensTelas.cad_funcionario());
        cb_tipo.addItem(MensagensTelas.cad_outros());
    }

    private void preencherComboEndereco() {
        cb_enderecos.removeAllItems();
        cb_enderecos.addItem(MensagensTelas.cad_enderecosExistentes());
        for (String endereco : listarEnderecoOrdenadoPorLogradouro()) {
            cb_enderecos.addItem(endereco);
        }
    }

    private Boolean verificaCpfExiste(String cpf) {
        for (PessoaBean pessoa : listarPessoaOrdenadaPorCodigo()) {
            if (!tf_codigo.getText().equals(pessoa.getCodigo().toString())) {
                if (pessoa.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificaTelefoneExiste(Integer numero) {
        TelefoneBean telefone = selecionarTelefonePorNumero(numero);
        if (telefone != null) {
            if (tf_codigoCelular.getText().equals("")) {
                return true;
            } else if (telefone.getCodigo() != Integer.parseInt(tf_codigoEmail.getText())) {
                return true;
            }
        }
        return false;
    }

    private Boolean verificaEmailExiste(String email) {
        EmailBean emails = selecionarEmailPorEmail(email);
        if (emails != null) {
            if (tf_codigoEmail.getText().equals("")) {
                return true;
            } else if (emails.getCodigo() != Integer.parseInt(tf_codigoEmail.getText())) {
                return true;
            }
        }
        return false;
    }

    public void setarFoto(BufferedImage foto) {
        this.foto = foto;
        exibirFoto();
    }

    private void abrirTelaEscolherImagem() {
        EscolherFotoImagem dialog = new EscolherFotoImagem(null, true, this);
        dialog.setVisible(true);
    }

    private void exibirFoto() {
        pnx_imagem.setImage(ImagemUtil.redimencionar(foto, 200, 150));
    }

    private void removerFoto() {
        foto = ImagemUtil.ler(ArquivosImagens.sistema_semImagem());
        exibirFoto();
        foto = null;
    }

    private Boolean validaCampos() {
        if (Validacao.verificaStringVazia(tf_nome.getText())) {
            tb_pane.setSelectedIndex(0);
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNomeVazio());
            tf_nome.requestFocus();
            return false;
        } else if (Validacao.verificaStringVazia(Validacao.retiraMascara(tf_cpf.getText()))) {
            tb_pane.setSelectedIndex(0);
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaCpfVazio());
            tf_cpf.requestFocus();
            return false;
        } else if (!Validacao.verificaCPF(Validacao.retiraMascara(tf_cpf.getText()))) {
            tb_pane.setSelectedIndex(0);
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaCpfInvalido());
            tf_cpf.requestFocus();
            return false;
        } else if (verificaCpfExiste(Validacao.retiraMascara(tf_cpf.getText()))) {
            tb_pane.setSelectedIndex(0);
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaCpfExiste());
            tf_cpf.requestFocus();
            tf_cpf.setText("");
            return false;
        } else if (Validacao.verificaStringVazia(tf_rg.getText().trim())) {
            tb_pane.setSelectedIndex(0);
            tf_rg.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaRgVazio());
            return false;
        } else if (!Validacao.verificaNumeroInteger(tf_rg.getText().trim())) {
            tb_pane.setSelectedIndex(0);
            tf_rg.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaRgInvalido());
            return false;
        } else if (Validacao.verificaNumeroNegativo(tf_rg.getText().trim())) {
            tb_pane.setSelectedIndex(0);
            tf_rg.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaRgNegativo());
            return false;
        } else if (DataUtil.verificarDataMaiorDataAtual(DataUtil.converteDateParaCalendar((Date) tf_dataNascimento.getValue()))) {
            InstanciasControle.getMensagens().aviso(tf_dataNascimento.getName());
            tb_pane.setSelectedIndex(0);
            tf_dataNascimento.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaDataMaiorAtual());
            return false;
        } else if (cb_tipo.getSelectedIndex() == 0) {
            tb_pane.setSelectedIndex(0);
            cb_tipo.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaTipoPessoa());
            return false;
        } else if (Validacao.verificaStringVazia(Validacao.retiraMascara(tf_ddd.getText()))) {
            tb_pane.setSelectedIndex(1);
            tf_celular.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaDDDvazio());
            return false;
        } else if (Validacao.verificaStringVazia(Validacao.retiraMascara(tf_celular.getText()))) {
            tb_pane.setSelectedIndex(1);
            tf_ddd.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaCelularVazio());
            return false;
        } else if (verificaTelefoneExiste(Integer.parseInt(Validacao.retiraMascara(tf_celular.getText())))) {
            tb_pane.setSelectedIndex(1);
            tf_celular.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaCelularExiste());
            return false;
        } else if (!Validacao.verificaEmail(tf_email.getText())) {
            tb_pane.setSelectedIndex(1);
            tf_email.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaEmailInvalido());
            return false;
        } else if (verificaEmailExiste(tf_email.getText())) {
            tb_pane.setSelectedIndex(1);
            tf_email.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaEmailExiste());
            return false;
        } else if (cb_estado.getSelectedIndex() == 0) {
            tb_pane.setSelectedIndex(2);
            cb_estado.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumEstadoSelecionar());
            return false;
        } else if (Validacao.verificaStringVazia(tf_cidade.getText())) {
            tb_pane.setSelectedIndex(2);
            tf_cidade.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumCidadeVazia());
            return false;
        } else if (Validacao.verificaStringVazia(tf_bairro.getText())) {
            tb_pane.setSelectedIndex(2);
            tf_bairro.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumBairroVazio());
            return false;
        } else if (Validacao.verificaStringVazia(tf_logradouro.getText())) {
            tb_pane.setSelectedIndex(2);
            tf_logradouro.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumLogradouroVazio());
            return false;
        } else if (Validacao.verificaStringVazia(tf_numero.getText())) {
            tb_pane.setSelectedIndex(2);
            tf_numero.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNumeroVazio());
            return false;
        } else if (!Validacao.verificaNumeroInteger(tf_numero.getText().trim())) {
            tb_pane.setSelectedIndex(2);
            tf_numero.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNumeroInvalido());
            return false;
        } else if (Validacao.verificaNumeroNegativo(tf_numero.getText().trim())) {
            tb_pane.setSelectedIndex(2);
            tf_numero.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumNumeroNegativo());
            return false;
        } else if (Validacao.verificaStringVazia(ta_referencia.getText())) {
            tb_pane.setSelectedIndex(2);
            ta_referencia.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadComumReferenciaVazia());
            return false;
        }

        return true;
    }
    ///////////////METODOS PARA POPULAR ENTIDADES///////////////////////////////

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

    private PessoaBean populaPessoaBean(EnderecoBean endereco, ConfigPessoaBean configPessoa) {
        PessoaBean pessoa = new PessoaBean();

        if (!tf_codigo.getText().equals("")) {
            pessoa.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        pessoa.setNome(tf_nome.getText().toUpperCase());
        pessoa.setCpf(Validacao.retiraMascara(tf_cpf.getText()));
        pessoa.setRg(Validacao.retiraMascara(tf_rg.getText()));
        pessoa.setData(DataUtil.converteDateParaCalendar((Date) tf_dataNascimento.getValue()));
        if (cb_tipo.getSelectedIndex() == 1) {
            pessoa.setTipo(EnumTipoPessoa.DONO);
        } else if (cb_tipo.getSelectedIndex() == 2) {
            pessoa.setTipo(EnumTipoPessoa.FAMILIA);
        } else if (cb_tipo.getSelectedIndex() == 3) {
            pessoa.setTipo(EnumTipoPessoa.VIGIA);
        } else if (cb_tipo.getSelectedIndex() == 4) {
            pessoa.setTipo(EnumTipoPessoa.FUNCIONARIO);
        } else if (cb_tipo.getSelectedIndex() == 5) {
            pessoa.setTipo(EnumTipoPessoa.OUTROS);
        }
        pessoa.setEndereco(endereco);
        pessoa.setDeletado(EnumDeletadoPessoa.NAO);
        if (foto != null) {
            pessoa.setFoto(tf_nome.getText().replace(' ', '_') + ".png");
        }
        if (ck_ativo.isSelected()) {
            pessoa.setSituacao(EnumSituacaoPessoa.ATIVO);
        } else {
            pessoa.setSituacao(EnumSituacaoPessoa.INATIVO);
        }
        pessoa.setConfigPessoa(configPessoa);

        return pessoa;
    }

    private EmailBean populaEmailBean(PessoaBean pessoaBean) {
        EmailBean email = new EmailBean();

        if (!tf_codigoEmail.getText().equals("")) {
            email.setCodigo(Integer.parseInt(tf_codigoEmail.getText()));
        }
        email.setEmail(tf_email.getText());
        email.setPessoa(pessoaBean);
        if (ck_enviarAutomaticoEmail.isSelected()) {
            email.setEnviarAutomatico(EnumEnviarAutomaticoEmail.ENVIAR);
        } else {
            email.setEnviarAutomatico(EnumEnviarAutomaticoEmail.NAOENVIAR);
        }

        return email;
    }

    private TelefoneBean populaTelefoneBean(PessoaBean pessoaBean) {
        TelefoneBean telefone = new TelefoneBean();

        if (!tf_codigoCelular.getText().equals("")) {
            telefone.setCodigo(Integer.parseInt(tf_codigoCelular.getText()));
        }
        telefone.setDdd(Integer.parseInt(tf_ddd.getText()));
        telefone.setNumero(Integer.parseInt((Validacao.retiraMascara(tf_celular.getText()))));
        telefone.setDdd(Integer.parseInt(tf_ddd.getText()));
        telefone.setPessoa(pessoaBean);
        if (ck_enviarAutomaticoCelular.isSelected()) {
            telefone.setEnviarAutomatico(EnumEnviarAutomaticoTelefone.ENVIAR);
        } else {
            telefone.setEnviarAutomatico(EnumEnviarAutomaticoTelefone.NAOENVIAR);
        }

        return telefone;
    }

    private ConfigPessoaBean populaConfigPessoaBean() {
        ConfigPessoaBean bean = new ConfigPessoaBean();

        if (!tf_codigoConfigPessoa.getText().equals("")) {
            bean.setCodigo(Integer.parseInt(tf_codigoConfigPessoa.getText()));
        }
        if (ck_ativarAlarmeGps.isSelected()) {
            bean.setAlarmeGps(EnumAlarmeGpsConfigPessoa.ATIVAR);
        } else {
            bean.setAlarmeGps(EnumAlarmeGpsConfigPessoa.DESATIVAR);
        }

        return bean;
    }

    ///////////////FIM METODOS PARA POPULAR ENTIDADES//////////////////////////////
    ///////////////METODOS PARA INSERIR NO BANCO/////////////////////////////
    private Boolean inserirEntidades() {
        EnderecoBean endereco = inserirEndereco(populaEnderecoBean());
        ConfigPessoaBean configPessoa = inserirConfigPessoa(populaConfigPessoaBean());
        PessoaBean pessoa = inserirPessoa(populaPessoaBean(endereco, configPessoa));
        if (endereco == null) {
            return false;
        } else if (pessoa == null) {
            return false;
        } else if (inserirEmail(populaEmailBean(pessoa)) == null) {
            return false;
        } else if (inserirTelefone(populaTelefoneBean(pessoa)) == null) {
            return false;
        }
        return true;
    }
    ///////////////FIM METODOS PARA INSERIR NO BANCO///////////////////////////

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_camposDadosPessoa);
        tf_cpf.setText("");
        cb_tipo.setSelectedIndex(0);
        SwingUtil.limparCamposJTextField(pn_contatos);
        SwingUtil.limparCamposJTextField(pn_endereco);
        ta_referencia.setText("");
        cb_estado.setSelectedIndex(0);
        ck_ativo.setSelected(true);
        tf_dataNascimento.setValue(null);
        ck_enviarAutomaticoCelular.setSelected(false);
        ck_enviarAutomaticoEmail.setSelected(false);
        ck_ativarAlarmeGps.setSelected(false);
        removerFoto();
    }

    public void preencheCampos(PessoaBean pessoa) {
        nomeAnterior = pessoa.getNome();
        TelefoneBean telefone = selecionaTelefonePorPessoa(pessoa);
        EmailBean email = selecionaEmailPorPessoa(pessoa);
        tf_codigo.setText(pessoa.getCodigo().toString());
        tf_nome.setText(pessoa.getNome());
        tf_cpf.setText(pessoa.getCpf());
        tf_rg.setText(pessoa.getRg());
        tf_dataNascimento.setValue(DataUtil.formataData(pessoa.getData()));
        SwingUtil.selecionaItemCombo(pessoa.getTipo().toString(), cb_tipo);
        tf_codigoEndereco.setText(pessoa.getEndereco().getCodigo().toString());
        SwingUtil.selecionaItemCombo(pessoa.getEndereco().getEstado(), cb_estado);
        tf_cidade.setText(pessoa.getEndereco().getCidade());
        tf_bairro.setText(pessoa.getEndereco().getBairro());
        tf_logradouro.setText(pessoa.getEndereco().getLogradouro());
        tf_numero.setText(pessoa.getEndereco().getNumero().toString());
        ta_referencia.setText(pessoa.getEndereco().getReferencia());
        tf_codigoCelular.setText(telefone.getCodigo().toString());
        tf_ddd.setText(telefone.getDdd().toString());
        tf_celular.setText(telefone.getNumero().toString());
        tf_codigoEmail.setText(email.getCodigo().toString());
        tf_email.setText(email.getEmail());
        if (telefone.getEnviarAutomatico() == EnumEnviarAutomaticoTelefone.ENVIAR) {
            ck_enviarAutomaticoCelular.setSelected(true);
        } else {
            ck_enviarAutomaticoCelular.setSelected(false);
        }
        if (email.getEnviarAutomatico() == EnumEnviarAutomaticoEmail.ENVIAR) {
            ck_enviarAutomaticoEmail.setSelected(true);
        } else {
            ck_enviarAutomaticoEmail.setSelected(false);
        }
        if (pessoa.getFoto() != null) {
            foto = ImagemUtil.ler(ArquivosImagens.diretorio_cadastros() + File.separator + pessoa.getFoto());
            exibirFoto();
        } else {
            removerFoto();
        }
        tf_codigoConfigPessoa.setText(pessoa.getConfigPessoa().getCodigo().toString());
        if (pessoa.getConfigPessoa().getAlarmeGps() == EnumAlarmeGpsConfigPessoa.ATIVAR) {
            ck_ativarAlarmeGps.setSelected(true);
        } else {
            ck_ativarAlarmeGps.setSelected(false);
        }
    }

    public void salvar() {
        if (validaCampos()) {
            if (inserirEntidades()) {
                if (foto != null) {
                    ImagemUtil.salvar(foto, ArquivosImagens.diretorio_cadastros() + File.separator + tf_nome.getText().replace(' ', '_') + ".png");
                }

                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadPessoaSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                preencherComboEndereco();
                AtualizaTelas.pesquisarPessoas();
                AtualizaTelas.ferramentasEditarImagens();
            }
        }
    }

    private void face() {
        if (!tf_nome.getText().equals("")) {
            DiretorioUtil.deletarArquivosDiretorio(new File(ArquivosImagens.diretorio_temporario()));
            FrameFaceCamera dialog = new FrameFaceCamera(null, true, tf_nome.getText().replace(' ', '_'), nomeAnterior);
            dialog.setVisible(true);
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadPessoaPreencherNome());
            tf_nome.requestFocus();
        }
    }

    private void preencheCamposEndereco() {
        if (cb_enderecos.getSelectedIndex() != 0 && cb_enderecos.getSelectedItem() != null) {
            EnderecoBean endereco = pesquisarEnderecoPorLogradouro(cb_enderecos.getSelectedItem().toString());
            if (endereco != null) {
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
        Manual manual = new Manual(ArquivosHTML.cadastros() + ArquivosHTML.pessoa());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual);
    }

    /*
     * BANCO DE DADOS
     */
    private ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo() {
        PessoaFacade pessoaFacade = FactoryFacade.getPessoaImpl();
        try {
            return pessoaFacade.listarPessoaOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private TelefoneBean selecionaTelefonePorPessoa(PessoaBean pessoa) {
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            return telefoneFacade.selecionarTelefonePorPessoa(pessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private EmailBean selecionaEmailPorPessoa(PessoaBean pessoa) {
        EmailFacade emailFacade = FactoryFacade.getEmailImpl();
        try {
            return emailFacade.selecionarEmailPorPessoa(pessoa);
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

    private EnderecoBean pesquisarEnderecoPorLogradouro(String logradouro) {
        EnderecoFacade enderecoFacade = FactoryFacade.getEnderecoImpl();
        try {
            return enderecoFacade.pesquisarEnderecoPorLogradouro(logradouro);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private PessoaBean inserirPessoa(PessoaBean pessoa) {
        PessoaFacade pessoaFacade = FactoryFacade.getPessoaImpl();
        try {
            return pessoaFacade.insereOuAltera(pessoa);
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

    private TelefoneBean inserirTelefone(TelefoneBean telefone) {
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            return telefoneFacade.insereOuAltera(telefone);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private EmailBean inserirEmail(EmailBean email) {
        EmailFacade emailFacade = FactoryFacade.getEmailImpl();
        try {
            return emailFacade.insereOuAltera(email);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ConfigPessoaBean inserirConfigPessoa(ConfigPessoaBean configPessoa) {
        ConfigPessoaFacade configPessoaFacade = FactoryFacade.getConfigPessoaFacadeImpl();
        try {
            return configPessoaFacade.insereOuAltera(configPessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private TelefoneBean selecionarTelefonePorNumero(Integer numero) {
        TelefoneFacade telefoneFacade = FactoryFacade.getTelefoneFacadeImpl();
        try {
            return telefoneFacade.selecionarTelefonePorNumero(numero);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private EmailBean selecionarEmailPorEmail(String email) {
        EmailFacade emailFacade = FactoryFacade.getEmailImpl();
        try {
            return emailFacade.selecionarEmailPorEmail(email);
        } catch (FacadeException ex) {
        }
        return null;
    }

}
