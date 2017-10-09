package telas.cadastros;

import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.autorizacao.bean.EnumDeletadoAutorizacao;
import entidades.autorizacao.facade.AutorizacaoFacade;
import entidades.modulo.bean.ModuloBean;
import entidades.modulo.facade.ModuloFacade;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.facade.PessoaFacade;
import entidades.usuario.bean.EnumDeletadoUsuario;
import entidades.usuario.bean.UsuarioBean;
import entidades.usuario.facade.UsuarioFacade;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import recursos.internacionalizacao.MensagensTelas;
import telas.principal.AtualizaTelas;
import telas.principal.Manual;
import util.*;

/**
 *
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class CadastrarUsuario extends javax.swing.JPanel {
    
    private DefaultListModel<ModuloBean> modeloModulo;
    private DefaultListModel<ModuloBean> modeloModuloAdicionados;

    public CadastrarUsuario() {
        initComponents();
        nomeiaTela();

        preencheComboTipo();
        preencherComboAutorizacao();
        prepararListaModulos();
        carregarTodosModulos();
        tf_codigoAutorizacao.setVisible(false);
    }
    
    private void nomeiaTela() {
        lb_codigo.setText(MensagensTelas.cad_codigo());
        lb_tipo.setText(MensagensTelas.cad_tipo());
        lb_pessoa.setText(MensagensTelas.cad_pessoa());
        lb_login.setText(MensagensTelas.cad_login());
        lb_senha.setText(MensagensTelas.cad_senha());
        lb_rSenha.setText(MensagensTelas.cad_rSenha());
        lb_autorizacoes.setText(MensagensTelas.cad_autorizacoes());
        lb_modulosDisponiveis.setText(MensagensTelas.cad_modulosDisponiveis());
        lb_modulosAdicionados.setText(MensagensTelas.cad_modulosAdicionados());
        
        tb_pane.setTitleAt(0, MensagensTelas.cad_dados());
        tb_pane.setTitleAt(1, MensagensTelas.cad_permissoes());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tb_pane = new javax.swing.JTabbedPane();
        pn_dados = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tf_codigo = new javax.swing.JTextField();
        pw_rSenha = new javax.swing.JPasswordField();
        lb_codigo = new javax.swing.JLabel();
        lb_rSenha = new javax.swing.JLabel();
        pw_senha = new javax.swing.JPasswordField();
        tf_login = new javax.swing.JTextField();
        lb_senha = new javax.swing.JLabel();
        lb_login = new javax.swing.JLabel();
        lb_tipo = new javax.swing.JLabel();
        lb_pessoa = new javax.swing.JLabel();
        cb_pessoa = new javax.swing.JComboBox();
        cb_tipo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lt_modulos = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lt_modulosAdicionados = new javax.swing.JList();
        lb_modulosDisponiveis = new javax.swing.JLabel();
        lb_modulosAdicionados = new javax.swing.JLabel();
        tf_codigoAutorizacao = new javax.swing.JTextField();
        lb_autorizacoes = new javax.swing.JLabel();
        cb_autorizacoes = new javax.swing.JComboBox();

        tb_pane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tb_pane.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tf_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_codigo.setEnabled(false);

        lb_codigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_codigo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_codigo.setText("Código:*");

        lb_rSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_rSenha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_rSenha.setText("R. Senha:*");

        tf_login.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lb_senha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_senha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_senha.setText("Senha:*");

        lb_login.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_login.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_login.setText("Login:*");

        lb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_tipo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_tipo.setText("Tipo:*");

        lb_pessoa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_pessoa.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_pessoa.setText("Pessoa:*");

        cb_pessoa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cb_tipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione um Tipo>", "Dono", "Família", "Vigia", "Funcionário", "Outros" }));
        cb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_codigo)
                            .addComponent(cb_tipo, 0, 248, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_pessoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_login, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_login))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pw_senha))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_rSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pw_rSenha)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_codigo)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tipo)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pessoa)
                    .addComponent(cb_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_login))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_senha)
                    .addComponent(pw_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_rSenha)
                    .addComponent(pw_rSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_dadosLayout = new javax.swing.GroupLayout(pn_dados);
        pn_dados.setLayout(pn_dadosLayout);
        pn_dadosLayout.setHorizontalGroup(
            pn_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        pn_dadosLayout.setVerticalGroup(
            pn_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        tb_pane.addTab("Dados", pn_dados);

        jScrollPane2.setViewportView(lt_modulos);

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(lt_modulosAdicionados);

        lb_modulosDisponiveis.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_modulosDisponiveis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_modulosDisponiveis.setText("Módulos Disponíveis");

        lb_modulosAdicionados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_modulosAdicionados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_modulosAdicionados.setText("Módulos Adicionados");

        tf_codigoAutorizacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tf_codigoAutorizacao.setEnabled(false);

        lb_autorizacoes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lb_autorizacoes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_autorizacoes.setText("Autorizações:");

        cb_autorizacoes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_autorizacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_autorizacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_codigoAutorizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lb_modulosDisponiveis, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_modulosAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lb_autorizacoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_autorizacoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_autorizacoes)
                    .addComponent(cb_autorizacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_modulosDisponiveis)
                    .addComponent(lb_modulosAdicionados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_codigoAutorizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_pane.addTab("Permissões", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
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

private void cb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipoActionPerformed
    if (cb_tipo.getSelectedIndex() > 0) {
        preencherComboPessoaPorTipo();
    }
}//GEN-LAST:event_cb_tipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!lt_modulos.isSelectionEmpty()) {
            ModuloBean modulo = (ModuloBean) lt_modulos.getSelectedValue();
            Integer indice = lt_modulos.getSelectedIndex();
            modeloModuloAdicionados.addElement(modulo);
            modeloModulo.removeElementAt(indice);
            lt_modulos.clearSelection();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!lt_modulosAdicionados.isSelectionEmpty()) {
            ModuloBean modulo = (ModuloBean) lt_modulosAdicionados.getSelectedValue();
            Integer indice = lt_modulosAdicionados.getSelectedIndex();
            modeloModulo.addElement(modulo);
            modeloModuloAdicionados.removeElementAt(indice);
            lt_modulosAdicionados.clearSelection();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cb_autorizacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_autorizacoesActionPerformed
        if(cb_autorizacoes.getSelectedIndex() != 0) {
            UsuarioBean usuario = selecionarUsuarioPorAutorizacao((AutorizacaoBean)cb_autorizacoes.getSelectedItem());
            carregarModulosPorUsuario(usuario);
            separaModulos(); 
        } else {
            if(modeloModulo != null && modeloModuloAdicionados != null) {
                modeloModuloAdicionados.clear();
                carregarTodosModulos();
            }
        }
    }//GEN-LAST:event_cb_autorizacoesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_autorizacoes;
    private javax.swing.JComboBox cb_pessoa;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_autorizacoes;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_modulosAdicionados;
    private javax.swing.JLabel lb_modulosDisponiveis;
    private javax.swing.JLabel lb_pessoa;
    private javax.swing.JLabel lb_rSenha;
    private javax.swing.JLabel lb_senha;
    private javax.swing.JLabel lb_tipo;
    private javax.swing.JList lt_modulos;
    private javax.swing.JList lt_modulosAdicionados;
    private javax.swing.JPanel pn_dados;
    private javax.swing.JPasswordField pw_rSenha;
    private javax.swing.JPasswordField pw_senha;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_codigoAutorizacao;
    private javax.swing.JTextField tf_login;
    // End of variables declaration//GEN-END:variables

    private void preencheComboTipo() {
        cb_tipo.removeAllItems();
        cb_tipo.addItem(MensagensTelas.cad_selecionarTipo());
        cb_tipo.addItem(EnumTipoPessoa.DONO);
        cb_tipo.addItem(EnumTipoPessoa.FAMILIA);
        cb_tipo.addItem(EnumTipoPessoa.FUNCIONARIO);
        cb_tipo.addItem(EnumTipoPessoa.VIGIA);
        cb_tipo.addItem(EnumTipoPessoa.OUTROS);
    }

    private void preencherComboPessoaPorTipo() {
        cb_pessoa.removeAllItems();
        cb_pessoa.addItem(MensagensTelas.cad_selecionarPessoa());
        for (PessoaBean pessoa : pesquisarPessoaPorTipo()) {
            cb_pessoa.addItem(pessoa);
        }
    }
    
    private void preencherComboAutorizacao() {
        cb_autorizacoes.removeAllItems();
        cb_autorizacoes.addItem(MensagensTelas.cad_novo());
        ArrayList<AutorizacaoBean> lista = listarAutorizacaoOrdenadaPorNome();
        if(!lista.isEmpty()) {
            for (AutorizacaoBean autorizacao : lista) {
                cb_autorizacoes.addItem(autorizacao);
            }
        }
    } 

    private Boolean verificaLoginExiste() {
        for (UsuarioBean usuario : pesquisaUsuarioPorCodigo()) {
            if (tf_codigo.getText().equals("") || !tf_codigo.getText().equals(usuario.getCodigo().toString())) {
                if (usuario.getLogin().equals(tf_login.getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean validaCampos() {
        if (cb_tipo.getSelectedIndex() == 0) {
            tb_pane.setSelectedIndex(0);
            cb_tipo.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadUsuarioTipo());
            return false;
        } else if (Validacao.verificaStringVazia(tf_login.getText())) {
            tb_pane.setSelectedIndex(0);
            tf_login.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadUsuarioLoginVazio());
            return false;
        } else if (verificaLoginExiste()) {
            tb_pane.setSelectedIndex(0);
            tf_login.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadUsuarioLoginExiste());
            tf_codigo.setText("");
            return false;
        } else if (Validacao.verificaStringVazia(pw_senha.getText())) {
            tb_pane.setSelectedIndex(0);
            pw_senha.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadUsuarioSenhaVazia());
            return false;
        } else if (!pw_senha.getText().equals(pw_rSenha.getText())) {
            tb_pane.setSelectedIndex(0);
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadUsuarioSenhaNaoCorrespondem());
            return false;
        } else if (cb_autorizacoes.getSelectedIndex() == 0 && modeloModuloAdicionados.isEmpty()) {
            tb_pane.setSelectedIndex(1);
            cb_autorizacoes.requestFocus();
            InstanciasControle.getMensagens().aviso(MensagensSoltas.cadUsuarioPermissao());
            return false;
        }

        return true;
    }

    private void limparCampos() {
        SwingUtil.limparCamposJTextField(pn_dados);
        cb_tipo.setSelectedIndex(0);
        cb_pessoa.setSelectedIndex(0);
        tf_login.setText(""); 
        pw_senha.setText("");
        pw_rSenha.setText("");
    }

    public void preencheCampos(UsuarioBean usuario) {
        tf_codigo.setText(usuario.getCodigo().toString());
        SwingUtil.selecionaItemCombo(usuario.getPessoa().getTipo().toString(), cb_tipo);
        preencherComboPessoaPorTipo();
        cb_tipo.setEnabled(false);
        cb_pessoa.removeAllItems();
        cb_pessoa.addItem(usuario.getPessoa());
        cb_pessoa.setEnabled(false);
        tf_login.setText(usuario.getLogin());
        tf_codigoAutorizacao.setText(usuario.getAutorizacao().getCodigo().toString());
        SwingUtil.selecionaItemCombo(usuario.getAutorizacao().toString(), cb_autorizacoes);
        
        carregarModulosPorUsuario(usuario);
        separaModulos();
    }
   
    private AutorizacaoBean popularAutorizacao() {
        AutorizacaoBean autorizacao = new AutorizacaoBean();
        
        if (!tf_codigoAutorizacao.getText().equals("")) {
            autorizacao.setCodigo(Integer.parseInt(tf_codigoAutorizacao.getText()));
        }
        autorizacao.setDeletado(EnumDeletadoAutorizacao.NAO);
        autorizacao.setDescricao(tf_login.getText()+"_AUTO");
        autorizacao.setModulos(obtemModulosAdicionados());
        
        return autorizacao;
    }

    private UsuarioBean popularUsuarioBean(AutorizacaoBean autorizacao) {
        UsuarioBean usuario = new UsuarioBean();

        if (!tf_codigo.getText().equals("")) {
            usuario.setCodigo(Integer.parseInt(tf_codigo.getText()));
        }
        usuario.setLogin(tf_login.getText());
        usuario.setSenha(Criptografia.MD5(pw_senha.getText()));
        usuario.setPessoa((PessoaBean) cb_pessoa.getSelectedItem());
        usuario.setDeletado(EnumDeletadoUsuario.NAO);
        usuario.setAutorizacao(autorizacao);

        return usuario;
    }

    public void salvar() {
        if (validaCampos()) {
            AutorizacaoBean autorizacao = inserirAutorizacao(popularAutorizacao());
            if (inserirUsuario(popularUsuarioBean(autorizacao)) != null) {
                InstanciasControle.getGerenciarAudio().exeSalvar();
                InstanciasControle.getMensagens().sucesso(MensagensSoltas.cadUsuarioSalvar());
                if (tf_codigo.getText().equals("")) {
                    limparCampos();
                }
                AtualizaTelas.pesquisarUsuario();
            }
        }
    }
    
    private void prepararListaModulos() {
        modeloModulo = new DefaultListModel<>();
        lt_modulos.setModel(modeloModulo);
        modeloModuloAdicionados = new DefaultListModel<>();
        lt_modulosAdicionados.setModel(modeloModuloAdicionados);
    }
     
    private void carregarTodosModulos() {
        modeloModulo.clear();
        ArrayList<ModuloBean> lista = listarModulosOrdenadosPorNome();
        for(ModuloBean modulo : lista) {
            modeloModulo.addElement(modulo);
        }
    }
    
    private void carregarModulosPorUsuario(UsuarioBean usuario) {
        modeloModuloAdicionados.clear();
        for(ModuloBean modulo : usuario.getAutorizacao().getModulos()) {
            modeloModuloAdicionados.addElement(modulo);
        }
    }
    
    private void separaModulos() {
        modeloModulo.clear();
        ModuloBean[] adicionados = new ModuloBean[modeloModuloAdicionados.getSize()];
        ArrayList<ModuloBean> lista = listarModulosOrdenadosPorNome();
        for(ModuloBean modulo : lista) {
            Boolean status = true;
            for(int i = 0; i < modeloModuloAdicionados.size(); i++) {
                adicionados[i] = modeloModuloAdicionados.getElementAt(i);
                if(adicionados[i].getCodigo() == modulo.getCodigo()) {
                    status = false;
                    break;
                }
            }
            if(status) {
                modeloModulo.addElement(modulo);
            }
        }
    }
    
    private ArrayList<ModuloBean> obtemModulosAdicionados() {
        ArrayList<ModuloBean> lista = new ArrayList<>();
        Enumeration<ModuloBean> enumeration = modeloModuloAdicionados.elements();
        while (enumeration.hasMoreElements()) {            
            lista.add(enumeration.nextElement());
        }
        return lista;
    }
    
    public void ajuda() {
        Manual manual = new Manual(ArquivosHTML.cadastros()+ArquivosHTML.usuario());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private UsuarioBean inserirUsuario(UsuarioBean usuario) {
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            return usuarioFacade.insereOuAltera(usuario);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<ModuloBean> listarModulosOrdenadosPorNome() {
        ModuloFacade moduloFacade = FactoryFacade.getModuloImpl();
        try {
            return moduloFacade.listarModulosOrdenadosPorNome();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private AutorizacaoBean inserirAutorizacao(AutorizacaoBean autorizacao) {
        AutorizacaoFacade autorizacaoFacade = FactoryFacade.getAutorizacaoImpl();
        try {
            return autorizacaoFacade.insereOuAltera(autorizacao);
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<PessoaBean> pesquisarPessoaPorTipo() {
        PessoaFacade pessoaFacade = FactoryFacade.getPessoaImpl();
        try {
            return pessoaFacade.pesquisarPessoaPorTipo((EnumTipoPessoa) cb_tipo.getSelectedItem());
        } catch (FacadeException ex) {
        }
        return null;
    }

    private ArrayList<UsuarioBean> pesquisaUsuarioPorCodigo() {
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            return usuarioFacade.listarUsuarioOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private ArrayList<AutorizacaoBean> listarAutorizacaoOrdenadaPorNome() {
        AutorizacaoFacade autorizacaoFacade = FactoryFacade.getAutorizacaoImpl();
        try {
            return autorizacaoFacade.listarAutorizacaoOrdenadaPorNome();
        } catch (FacadeException ex) {
        }
        return null;
    }
    
    private UsuarioBean selecionarUsuarioPorAutorizacao(AutorizacaoBean autorizacao) {
        UsuarioFacade usuarioFacade = FactoryFacade.getUsuarioImpl();
        try {
            return usuarioFacade.selecionarUsuarioPorAutorizacao(autorizacao);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
