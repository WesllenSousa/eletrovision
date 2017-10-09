
package telas.comuns.telas;

import telas.comuns.camera.VisualizadorCamera;
import recursos.configuracoes.sistema.ConfigGerais;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.cadastros.CadastrarPessoa;
import telas.cadastros.CadastrarPredio;
import telas.comuns.fileChooser.ImagemFileView;
import telas.comuns.fileChooser.ImagemFilter;
import telas.comuns.fileChooser.ImagemPreview;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class EscolherFotoImagem extends javax.swing.JDialog {
    
    private CadastrarPessoa cadastrarPessoa;
    private CadastrarPredio cadastrarPredio;
    
    private BufferedImage imagem;

    public EscolherFotoImagem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public EscolherFotoImagem(java.awt.Frame parent, boolean modal, Object tela) {
        super(parent, modal);
        initComponents();
        
        verificaInstancia(tela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolha...");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/dispositivos/foto_64x64.png"))); // NOI18N
        jButton2.setToolTipText("Tirar foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/midia/Imagens_64x64.png"))); // NOI18N
        jButton3.setToolTipText("Escolher uma imagem externa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-178)/2, (screenSize.height-120)/2, 178, 120);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscarImagens();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tirarFoto();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables

    public void setarImagem(BufferedImage imagem){
        this.imagem = imagem;
    }
    
    private void buscarImagens() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ImagemFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileView(new ImagemFileView());
        fileChooser.setAccessory(new ImagemPreview(fileChooser));
        fileChooser.setCurrentDirectory(new File(ConfigGerais.getDiretorioAtual()));
        
        Integer retorno = fileChooser.showDialog(this, "Abrir");
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String arquivo = fileChooser.getSelectedFile().getAbsolutePath();
            ConfigGerais.setDiretorioAtual(arquivo);
            imagem = ImagemUtil.ler(arquivo);      
            finalizaEscolha();
        }
    }

    private void tirarFoto() {
        if(InstanciasControle.getIniciarCameras().getStatus()) {
            VisualizadorCamera tirarFoto = new VisualizadorCamera(null, true, this);
            tirarFoto.setVisible(true);
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.principalCamerasNaoIniciadas());
        }
    }
    
    public void finalizaEscolha(){
        if(cadastrarPessoa != null){
            cadastrarPessoa.setarFoto(imagem);
        } else if(cadastrarPredio != null){
            cadastrarPredio.setarFoto(imagem);
        } 
        dispose();
    }

    private void verificaInstancia(Object tela) {
        if (tela instanceof CadastrarPessoa) {
            cadastrarPessoa = (CadastrarPessoa) tela;
        } else if (tela instanceof CadastrarPredio) {
            cadastrarPredio = (CadastrarPredio) tela;
        }
    }
    
}
