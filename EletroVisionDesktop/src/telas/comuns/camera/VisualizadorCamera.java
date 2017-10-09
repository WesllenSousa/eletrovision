
package telas.comuns.camera;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import entidades.camera.bean.CameraBean;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.imagens.ImagemPanel;
import telas.comuns.telas.EscolherFotoImagem;
import util.DiretorioUtil;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class VisualizadorCamera extends javax.swing.JDialog {
    
    private EscolherFotoImagem escolherFotoImagem;
    private InternalFrameCamera internalFrameCamera;
    private ServidorCamera servidorCamera;
    private String diretorioVideo;
    private Boolean gravou = false;
     
    public VisualizadorCamera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        escolherCamera();  
        exibirImagem();
    }
    
    public VisualizadorCamera(java.awt.Frame parent, boolean modal, Object tela) {
        super(parent, modal);
        initComponents();
        
        verificarInstancias(tela);
        escolherCamera();  
        exibirImagem();
    }
    
    public VisualizadorCamera(java.awt.Frame parent, boolean modal, Object tela, ServidorCamera servidorCamera) {
        super(parent, modal);
        initComponents();
        
        verificarInstancias(tela);
        this.servidorCamera = servidorCamera;
        exibirImagem();
    }
    
    public VisualizadorCamera(java.awt.Frame parent, boolean modal, Object tela, CameraBean camera) {
        super(parent, modal);
        initComponents();
        
        verificarInstancias(tela);
        definirCameras(camera); 
        exibirImagem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_foto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();
        bt_confirmar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        bt_salvar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bt_foto = new javax.swing.JButton();
        bt_retornarFoto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bt_gravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tirar Foto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pn_foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pn_foto.setPreferredSize(new java.awt.Dimension(350, 255));

        javax.swing.GroupLayout pn_fotoLayout = new javax.swing.GroupLayout(pn_foto);
        pn_foto.setLayout(pn_fotoLayout);
        pn_fotoLayout.setHorizontalGroup(
            pn_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pn_fotoLayout.setVerticalGroup(
            pn_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        bt_fechar.setToolTipText("Cancelar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        bt_confirmar.setToolTipText("Confirmar");
        bt_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_confirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_fechar)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_fechar, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(bt_confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/salvar_32x32.png"))); // NOI18N
        bt_salvar.setToolTipText("Salvar");
        bt_salvar.setFocusable(false);
        bt_salvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_salvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_salvar);
        jToolBar1.add(jSeparator2);

        bt_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/dispositivos/foto_32x32.png"))); // NOI18N
        bt_foto.setToolTipText("Tirar Foto");
        bt_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fotoActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_foto);

        bt_retornarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/refazer_32x32.png"))); // NOI18N
        bt_retornarFoto.setToolTipText("Desfazer");
        bt_retornarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_retornarFotoActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_retornarFoto);
        jToolBar1.add(jSeparator1);

        bt_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/gravar_22x22.png"))); // NOI18N
        bt_gravar.setFocusable(false);
        bt_gravar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_gravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gravarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_gravar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_foto, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-370)/2, (screenSize.height-402)/2, 370, 402);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_retornarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_retornarFotoActionPerformed
        servidorCamera.setPause(false);
    }//GEN-LAST:event_bt_retornarFotoActionPerformed

    private void bt_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fotoActionPerformed
        servidorCamera.setPause(true);
        InstanciasControle.getGerenciarAudio().exeFoto();
    }//GEN-LAST:event_bt_fotoActionPerformed

    private void bt_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_bt_confirmarActionPerformed

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        fechar();
    }//GEN-LAST:event_bt_fecharActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
}//GEN-LAST:event_formWindowClosing

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvar();
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gravarActionPerformed
        gravar();
    }//GEN-LAST:event_bt_gravarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirmar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_foto;
    private javax.swing.JButton bt_gravar;
    private javax.swing.JButton bt_retornarFoto;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pn_foto;
    // End of variables declaration//GEN-END:variables

    private void escolherCamera() {
        String[] cameras = new String[InstanciasControle.getIniciarCameras().getServidoresCameras().size()];
        Integer cont = 0;
        for(ServidorCamera cam : InstanciasControle.getIniciarCameras().getServidoresCameras()){
            cameras[cont] = cam.getCamera().getNome();
            cont++;
        }
        String nomeCamera = InstanciasControle.getMensagens().multiplaEscolha(MensagensSoltas.comumEscolherCamera(), cameras);
        for(ServidorCamera cam : InstanciasControle.getIniciarCameras().getServidoresCameras()){
            if(nomeCamera.equals(cam.getCamera().getNome())){
                servidorCamera = cam;
                break;
            }
        }
    }
    
    private void definirCameras(CameraBean camera) {
        for(ServidorCamera cam : InstanciasControle.getIniciarCameras().getServidoresCameras()){
            if(camera.getNome().equals(cam.getCamera().getNome())){
                servidorCamera = cam; 
                break;
            }
        }
    }
    
    private void exibirImagem(){
        ImagemPanel imagemPanel = new ImagemPanel();
        imagemPanel.setSize(350,255);
        imagemPanel.setLocation(0, 0);
        pn_foto.add(imagemPanel);
        if(servidorCamera != null) {
            servidorCamera.setImagemPanel(imagemPanel, imagemPanel.getWidth(), imagemPanel.getHeight());
            servidorCamera.setFoto(true);
        }
    }
    
    private void salvar() {
        String tipoSalvamento = MensagensSoltas.comumFoto();
        if(gravou) {
            String[] cameras = new String[2];
            cameras[0] = MensagensSoltas.comumFoto(); cameras[1] = MensagensSoltas.comumGravacao();
            tipoSalvamento = InstanciasControle.getMensagens().multiplaEscolha(MensagensSoltas.comumGravacaoConfirmar(), cameras);
        }
        
        JFileChooser fileChooser = new JFileChooser();
        Integer retorno = fileChooser.showDialog(this, "Salvar");   
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String diretorio = fileChooser.getSelectedFile().getPath();
            if(tipoSalvamento.equals(MensagensSoltas.comumFoto())) {
                File file = new File(diretorio+".png");
                if(DiretorioUtil.verificarSeArquivoDiretorioExiste(file)){
                    ImagemUtil.salvar(servidorCamera.getBufferedImage(), file);
                    InstanciasControle.getMensagens().sucesso(MensagensSoltas.comumImagemSalvar());
                }
            } else {
                if(servidorCamera.getGravarManual() == null) {
                    File destino = new File(diretorio+".avi");
                    if(DiretorioUtil.verificarSeArquivoDiretorioExiste(destino)){
                        System.out.println(diretorioVideo);
                        System.out.println(destino.getAbsolutePath());
                        DiretorioUtil.copiarArquivo(diretorioVideo, destino.getAbsolutePath());
                        InstanciasControle.getMensagens().sucesso(MensagensSoltas.comumGravacaoSalvar());
                    }
                } else {
                    InstanciasControle.getMensagens().aviso(MensagensSoltas.comumGravacaoParar());
                }
            }
        }
    }
    
    private void confirmar() {
        servidorCamera.setPause(false); 
        servidorCamera.setFoto(false);
        confirmarTela();
        dispose();
    }
    
    private void confirmarTela() {
        if(escolherFotoImagem != null) {
            escolherFotoImagem.setarImagem(servidorCamera.getBufferedImage());
            escolherFotoImagem.finalizaEscolha();
        } else if(internalFrameCamera != null) {
        }
    }
    
    private void verificarInstancias(Object tela) {
        if(tela instanceof EscolherFotoImagem) {
            this.escolherFotoImagem = (EscolherFotoImagem) tela;
        } else if(tela instanceof InternalFrameCamera) {
            this.internalFrameCamera = (InternalFrameCamera) tela;
        }
    }

    private void gravar() {
        if(ConfigDispositivos.getGravarVideo()) {
            gravou = true;
            if(servidorCamera.getGravarManual() == null) {
                servidorCamera.setGravarManual(true);
                bt_gravar.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.visualizarCameras_gravando())));
            } else {
                diretorioVideo = servidorCamera.getDiretorioVideoAtual();
                servidorCamera.setGravarManual(false);
                bt_gravar.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.visualizarCameras_gravar())));
            }
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.comumDesativarGravacao()); 
        }
    }
    
    private void fechar() {
        if(servidorCamera != null) {
            servidorCamera.setPause(false);
            servidorCamera.setFoto(false);
        }
        dispose();
    }
    
}
