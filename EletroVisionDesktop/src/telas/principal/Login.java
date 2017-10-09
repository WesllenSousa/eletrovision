package telas.principal;

import recursos.configuracoes.bloqueio.ArquivoBloqueio;
import controle.controleAcesso.ConfiguraAutorizacao;
import controle.controleAcesso.VerificaAutorizacao;
import controle.processing.efeito.Lens;
import entidades.acesso.bean.AcessoBean;
import entidades.acesso.facade.AcessoFacade;
import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.facade.MensagemFacade;
import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.usuario.bean.UsuarioBean;
import entidades.usuario.facade.UsuarioFacade;
import java.util.ArrayList;
import java.util.Calendar;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.geral.dependencias.VerMensagensLocais;
import util.Criptografia;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Login extends javax.swing.JDialog {

    private Integer tentativas = 0, qtdeUsuarios = 0;

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        iniciaEfeito();
        preencharComUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_fundo = new javax.swing.JPanel();
        pn_autenticacao = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_usuario = new javax.swing.JComboBox();
        pw_senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação do Sistema");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pn_autenticacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pn_autenticacao.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Senha:");

        cb_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pw_senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pw_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pw_senhaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        jButton1.setText("Autenticar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pw_senha)
                            .addComponent(cb_usuario, javax.swing.GroupLayout.Alignment.LEADING, 0, 246, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pw_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_autenticacaoLayout = new javax.swing.GroupLayout(pn_autenticacao);
        pn_autenticacao.setLayout(pn_autenticacaoLayout);
        pn_autenticacaoLayout.setHorizontalGroup(
            pn_autenticacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_autenticacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_autenticacaoLayout.setVerticalGroup(
            pn_autenticacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_autenticacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_fundoLayout = new javax.swing.GroupLayout(pn_fundo);
        pn_fundo.setLayout(pn_fundoLayout);
        pn_fundoLayout.setHorizontalGroup(
            pn_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fundoLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(pn_autenticacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        pn_fundoLayout.setVerticalGroup(
            pn_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fundoLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(pn_autenticacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-752)/2, (screenSize.height-417)/2, 752, 417);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        autenticar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fechar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pw_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pw_senhaActionPerformed
        autenticar();
    }//GEN-LAST:event_pw_senhaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pn_autenticacao;
    private javax.swing.JPanel pn_fundo;
    private javax.swing.JPasswordField pw_senha;
    // End of variables declaration//GEN-END:variables

    /*
     *  ===============TELA==============================================
     */
    private void iniciaEfeito() {
        Lens lens = new Lens();
        pn_fundo.add(lens);
        lens.init();
    }

    private void preencharComUsuario() {
        cb_usuario.removeAllItems();
        cb_usuario.addItem("<Escolha um usuário>");
        for (UsuarioBean usuario : listarUsuarioNaoDeletado()) {
            cb_usuario.addItem(usuario);
            qtdeUsuarios++;
        }
    }

    /*
     *  ===============REGRA DE NEGOCIO======================================
     */
    private AcessoBean populaAcessoBean(UsuarioBean usuario) {
        AcessoBean bean = new AcessoBean();

        bean.setUsuario(usuario);
        bean.setDataHoraInicio(Calendar.getInstance());

        return bean;
    }

    private void autenticar() {
        if (tentativas == 3) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.loginTentativas());
            System.exit(0);
        }
        if (verificaUsuarioSenha()) {
            if (InstanciasTelas.getPrincipal() == null) {
                Principal principal = new Principal();
                principal.setVisible(true);
                principal.setFocusableWindowState(true);
            } else {
                InstanciasTelas.getPrincipal().exibirUsuarioLogado();
                InstanciasTelas.getPrincipal().iniciaServidor();
            }
            dispose();
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.loginInvalido());
        }
    }

    private boolean verificaUsuarioSenha() {
        tentativas++;

        if (pw_senha.getText().equals("admin")) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.loginAdmin());
            VerificaAutorizacao.semPermissoes();
            VerificaAutorizacao.cadastro_usuario = true;
            VerificaAutorizacao.cadastro_pessoa = true;
            return true;
        }

        UsuarioBean usuario = selecionaUsuarioPorLogin(cb_usuario.getSelectedItem().toString());
        if (usuario != null) {
            if (usuario.getPessoa().getSituacao() == EnumSituacaoPessoa.ATIVO) {
                if (usuario.getSenha().equals(Criptografia.MD5(pw_senha.getText()))) {
                    //VerificaAutorizacao.todasPermissoes();
                    configuraPermissoes(usuario);
                    InstanciasControle.setUsuarioLogado(usuario);
                    verificaMensagensLocais(usuario);
                    configuraAcesso(usuario);
                    return true;
                }
            } else {
                InstanciasControle.getMensagens().aviso(MensagensSoltas.loginPrivilegio());
            }
        }

        return false;
    }

    private void configuraPermissoes(UsuarioBean usuario) {
        VerificaAutorizacao.semPermissoes();
        ConfiguraAutorizacao configuraAutorizacao = new ConfiguraAutorizacao(usuario.getAutorizacao());
        configuraAutorizacao.populaAutorizacoes();
    }

    private void configuraAcesso(UsuarioBean usuario) {
        AcessoBean acesso = salvaAcesso(populaAcessoBean(usuario));
        InstanciasControle.setAcesso(acesso);
    }

    private void verificaMensagensLocais(UsuarioBean usuario) {
        for (MensagemBean mensagem : listarMensagensLocais()) {
            if (usuario.getPessoa().getCodigo() == mensagem.getDestino().getCodigo()) {
                if (mensagem.getExibir() == EnumExibirMensagem.INICIAR_SISTEMA && mensagem.getLeitura() == EnumLeituraMensagem.NAO) {
                    VerMensagensLocais dialog = new VerMensagensLocais(null, true, mensagem);
                    dialog.setVisible(true);
                }
            }
        }
    }

    private void fechar() {
        if (InstanciasTelas.getPrincipal() != null) {
            dispose();
        } else {
            ArquivoBloqueio.fecharSistema();
            System.exit(0);
        }
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private AcessoBean salvaAcesso(AcessoBean acesso) {
        AcessoFacade acessoFacade = FactoryFacade.getAcessoFacadeImpl();
        try {
            return acessoFacade.inserir(acesso);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<UsuarioBean> listarUsuarioNaoDeletado() {
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            return usuarioFacade.listarUsuarioNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }

    private UsuarioBean selecionaUsuarioPorLogin(String login) {
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            return usuarioFacade.selecionaUsuarioPorLogin(login);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<MensagemBean> listarMensagensLocais() {
        MensagemFacade mensagemFacade = FactoryFacade.getMensagemImpl();
        try {
            return mensagemFacade.listarMensagensLocal();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
