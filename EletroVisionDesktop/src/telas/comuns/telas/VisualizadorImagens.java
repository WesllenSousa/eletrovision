
package telas.comuns.telas;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.cadastros.CadastrarCamera;
import telas.cadastros.CadastrarDispositivoEletrico;
import telas.comuns.fileChooser.ImagemFileView;
import telas.comuns.fileChooser.ImagemFilter;
import telas.comuns.fileChooser.ImagemPreview;
import telas.geral.dependencias.CadEditarCenario;
import util.DiretorioUtil;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class VisualizadorImagens extends javax.swing.JDialog {
    
    private CadEditarCenario cadEditarCenario;
    private CadastrarDispositivoEletrico cadastrarDispositivoEletrico;
    private CadastrarCamera cadastrarCamera;
    
    private String diretorio;
    private String[] iterator;
    private Integer imagemAtual = 0;
    private BufferedImage buffer;
    private String diretorioAnterior = ".";

    public VisualizadorImagens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public VisualizadorImagens(java.awt.Frame parent, boolean modal, String diretorio, Object object) {
        super(parent, modal);
        initComponents();
        
        this.diretorio = diretorio;
        populaIterator();
        exibirImagem(diretorio+File.separator+iterator[imagemAtual]);
        analizaBotoesNavegacao();
        verificaInstancia(object);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bt_confirmar = new javax.swing.JButton();
        bt_fechar = new javax.swing.JButton();
        bt_adicionar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lb_imagem = new javax.swing.JLabel();
        bt_posterior = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizador de Imagens");
        setResizable(false);

        bt_confirmar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        bt_confirmar.setToolTipText("Salvar");
        bt_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarActionPerformed(evt);
            }
        });

        bt_fechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_adicionar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/adicionar_22x22.png"))); // NOI18N
        bt_adicionar.setToolTipText("Salvar");
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_adicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(bt_confirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_fechar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_adicionar)
                    .addComponent(bt_confirmar)
                    .addComponent(bt_fechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bt_posterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/seguir_22x22.png"))); // NOI18N
        bt_posterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_posteriorActionPerformed(evt);
            }
        });

        bt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/retornar_22x22.png"))); // NOI18N
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_posterior, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_imagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(bt_posterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(bt_anterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setBounds((screenSize.width-257)/2, (screenSize.height-223)/2, 257, 223);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

private void bt_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarActionPerformed
        ok();
}//GEN-LAST:event_bt_confirmarActionPerformed

private void bt_posteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_posteriorActionPerformed
        imagemAtual++;
        exibirImagem(diretorio+File.separator+iterator[imagemAtual]);
        analizaBotoesNavegacao();
}//GEN-LAST:event_bt_posteriorActionPerformed

private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        imagemAtual--;
        exibirImagem(diretorio+File.separator+iterator[imagemAtual]);
        analizaBotoesNavegacao();
}//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        abrir();
    }//GEN-LAST:event_bt_adicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_confirmar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_posterior;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_imagem;
    // End of variables declaration//GEN-END:variables

    private void populaIterator(){
        HashSet<String> hashSet = DiretorioUtil.listarArquivos(new File(diretorio));
        Iterator it = hashSet.iterator();
        Integer cont = 0;
        iterator = new String[hashSet.size()];
        while(it.hasNext()){
            iterator[cont] = it.next().toString();
            cont++;
        }
    }
    
    private void analizaBotoesNavegacao() {
        if(imagemAtual == 0){
            bt_anterior.setEnabled(false);
            bt_posterior.setEnabled(true);
        } else if(imagemAtual == (iterator.length-1)){
            bt_anterior.setEnabled(true);
            bt_posterior.setEnabled(false);
        } else {
            bt_anterior.setEnabled(true);
            bt_posterior.setEnabled(true);
        }
    }
    
    private void exibirImagem(String arquivo){
        File file = new File(arquivo);
        buffer = ImagemUtil.ler(file);
        lb_imagem.setIcon(new ImageIcon(ImagemUtil.bufferedImageParaImage(buffer)));   
    }
    
    private void ok() {
        if(cadEditarCenario != null) {
            cadEditarCenario.exibirImagem(buffer, new File(diretorio+File.separator+iterator[imagemAtual]).getName());
        } else if(cadastrarDispositivoEletrico != null) {
            cadastrarDispositivoEletrico.exibirImagem(buffer, new File(diretorio+File.separator+iterator[imagemAtual]).getName());
        } else if(cadastrarCamera != null) {
            cadastrarCamera.exibirImagem(buffer, new File(diretorio+File.separator+iterator[imagemAtual]).getName());
        }
        dispose();
    }

    private void verificaInstancia(Object object) {
        if(object instanceof CadEditarCenario) {
            cadEditarCenario = (CadEditarCenario) object;
        } else if(object instanceof CadastrarDispositivoEletrico) {
            cadastrarDispositivoEletrico = (CadastrarDispositivoEletrico) object;
        } else if(object instanceof CadastrarCamera) {
            cadastrarCamera = (CadastrarCamera) object;
        }
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
            BufferedImage imagem = ImagemUtil.ler(new File(diretorioAnterior));
            if(imagem != null) {
                ImagemUtil.salvar(imagem, diretorio+File.separator+fileChooser.getSelectedFile().getName());
                populaIterator();
                exibirImagem(diretorio+File.separator+fileChooser.getSelectedFile().getName());
            } else {
                InstanciasControle.getMensagens().bug(MensagensSoltas.comumImagemInvalida());
            }
        }    
    }
    
}
