
package telas.comuns.telas;

import recursos.configuracoes.sistema.ConfigMensagens;
import controle.mensagens.email.Email;
import java.io.File;
import javax.swing.JFileChooser;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import util.DiretorioUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Erro extends javax.swing.JDialog {

    public Erro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public Erro(java.awt.Frame parent, boolean modal, String titulo, String detalhe) {
        super(parent, modal);
        initComponents();
        
        lb_titulo.setText(titulo);
        ta_detalhes.setText(detalhe); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_enviar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_detalhes = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Erro");
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/acessoNegado_128x128.png"))); // NOI18N

        lb_titulo.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        lb_titulo.setText("Erro!");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bt_enviar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_enviar.setText("Enviar");
        bt_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_enviarActionPerformed(evt);
            }
        });

        bt_salvar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        ta_detalhes.setEditable(false);
        jScrollPane1.setViewportView(ta_detalhes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_enviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1)
                    .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_enviar, bt_salvar, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(bt_enviar)
                            .addComponent(bt_salvar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
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
        setBounds((screenSize.width-618)/2, (screenSize.height-345)/2, 618, 345);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_enviarActionPerformed
        enviar();
    }//GEN-LAST:event_bt_enviarActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvar();
    }//GEN-LAST:event_bt_salvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_enviar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTextPane ta_detalhes;
    // End of variables declaration//GEN-END:variables

    private void salvar() {
        JFileChooser fileChooser = new JFileChooser();
        Integer retorno = fileChooser.showDialog(this, "Salvar");
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String diretorio = fileChooser.getSelectedFile().getPath();
            File file = new File(diretorio+".txt");
            if(DiretorioUtil.verificarSeArquivoDiretorioExiste(file)){
                if(DiretorioUtil.gravarArquivoTxt(lb_titulo.getText() + ta_detalhes.getText(), file)) {
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.comumArquivoSalvar()); 
                }
            }
        }
    }

    private void enviar() {
        Email email = new Email(ConfigMensagens.getServidor(), ConfigMensagens.getPorta());
        email.origem(ConfigMensagens.getEmail(), ConfigMensagens.getNomeExibicao());
        email.autenticacao(usuarioEmail(ConfigMensagens.getEmail()), ConfigMensagens.getSenha());
        email.destino("wesllen.wsl@gmail.com", "Erro EletroVision");
        email.corpo(lb_titulo.getText(), ta_detalhes.getText());
        if(email.enviar()) {
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.emailSucesso());
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.emailErroEnviar());
        }
    }
    
    private String usuarioEmail(String email) {
        String usuario = "";
        for(int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@') {
                break;
            }
            usuario += email.charAt(i);
        }
        return usuario;
    }
    
}
