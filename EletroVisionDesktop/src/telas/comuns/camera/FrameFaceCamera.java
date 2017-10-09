
package telas.comuns.camera;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import entidades.camera.bean.CameraBean;
import entidades.camera.facade.CameraFacade;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.eventos.ArrastaComponentes;
import telas.comuns.imagens.ImagemPanel;
import util.DiretorioUtil;
import util.FacadeException;
import util.FactoryFacade;
import util.ImagemUtil;

/**
 *
 * @author Wesllen
 */
public class FrameFaceCamera extends javax.swing.JDialog {
    
    private PainelReconhecimentoFace painelFace;
    
    private String diretorioExcluir;
    private ImagemPanel imagemPanelExcluir;
    private Integer qtdeSalvas = 0;
    private String nomeAtual;
    private ArrayList<String> listaFacesEditar;

    public FrameFaceCamera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        iniciarCaptura();
    }
    
    public FrameFaceCamera(java.awt.Frame parent, boolean modal, String nomeAtual, String nomeAnterior) {
        super(parent, modal);
        initComponents();
        
        this.nomeAtual = nomeAtual.toUpperCase();       
        iniciarCaptura();
        lb_nome.setText(this.nomeAtual);
        
        if(nomeAnterior != null) {
            pesquisarImagens(nomeAnterior);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mn_face = new javax.swing.JPopupMenu();
        mi_excluir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        pn_imagens = new javax.swing.JPanel();
        pn_camera = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bt_salvarFace = new javax.swing.JButton();
        bt_reconhecer = new javax.swing.JButton();
        bt_fechar = new javax.swing.JButton();
        bt_confirmar = new javax.swing.JButton();
        lb_nome = new javax.swing.JLabel();

        mn_face.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        mi_excluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mi_excluir.setText("Excluir");
        mi_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_excluirActionPerformed(evt);
            }
        });
        mn_face.add(mi_excluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Faces");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout pn_imagensLayout = new javax.swing.GroupLayout(pn_imagens);
        pn_imagens.setLayout(pn_imagensLayout);
        pn_imagensLayout.setHorizontalGroup(
            pn_imagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        pn_imagensLayout.setVerticalGroup(
            pn_imagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        scroll.setViewportView(pn_imagens);

        pn_camera.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pn_camera.setPreferredSize(new java.awt.Dimension(500, 350));

        javax.swing.GroupLayout pn_cameraLayout = new javax.swing.GroupLayout(pn_camera);
        pn_camera.setLayout(pn_cameraLayout);
        pn_cameraLayout.setHorizontalGroup(
            pn_cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pn_cameraLayout.setVerticalGroup(
            pn_cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        bt_salvarFace.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_salvarFace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/salvar_22x22.png"))); // NOI18N
        bt_salvarFace.setText("Salvar face");
        bt_salvarFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarFaceActionPerformed(evt);
            }
        });

        bt_reconhecer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_reconhecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/face.png"))); // NOI18N
        bt_reconhecer.setText("Reconhecer");
        bt_reconhecer.setEnabled(false);
        bt_reconhecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_reconhecerActionPerformed(evt);
            }
        });

        bt_fechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/cancelar_22x22.png"))); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_confirmar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/confirmar_22x22.png"))); // NOI18N
        bt_confirmar.setText("Confirmar");
        bt_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_reconhecer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salvarFace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_confirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_fechar)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_fechar, bt_reconhecer, bt_salvarFace});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_salvarFace)
                    .addComponent(bt_reconhecer)
                    .addComponent(bt_fechar)
                    .addComponent(bt_confirmar))
                .addContainerGap())
        );

        lb_nome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lb_nome.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_camera, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addComponent(lb_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_camera, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        setBounds((screenSize.width-703)/2, (screenSize.height-765)/2, 703, 765);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_reconhecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_reconhecerActionPerformed
        lb_nome.setText("");
        bt_reconhecer.setEnabled(false);
        painelFace.setReconhecerFace(); 
    }//GEN-LAST:event_bt_reconhecerActionPerformed

    private void bt_salvarFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarFaceActionPerformed
        painelFace.salvarFace();
    }//GEN-LAST:event_bt_salvarFaceActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        fechar();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_bt_confirmarActionPerformed

    private void mi_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_excluirActionPerformed
        excluirFace();
    }//GEN-LAST:event_mi_excluirActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirmar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_reconhecer;
    private javax.swing.JButton bt_salvarFace;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lb_nome;
    public javax.swing.JMenuItem mi_excluir;
    public javax.swing.JPopupMenu mn_face;
    public javax.swing.JPanel pn_camera;
    private javax.swing.JPanel pn_imagens;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    public void setDiretorioExcluir(String diretorio, ImagemPanel imagemPanel) {
        this.diretorioExcluir = diretorio;
        this.imagemPanelExcluir = imagemPanel;
    }
    
    private void excluirFace() {
        if(DiretorioUtil.deletarArquivo(new File(diretorioExcluir))) {
            qtdeSalvas--;
            pn_imagens.remove(imagemPanelExcluir);
            pn_imagens.repaint();
        }
    }
    
    private void iniciarCaptura() {
        ArrayList<CameraBean> lista = listarCameraOrdenadaPorCodigo();
        String[] cameras = new String[lista.size()];
        Integer cont = 0;
        for(CameraBean cam : lista){
            cameras[cont] = cam.getNome();
            cont++;
        }
        if(lista != null && !lista.isEmpty()) {
            String nomeCamera = InstanciasControle.getMensagens().multiplaEscolha(MensagensSoltas.comumEscolherCamera(), cameras);
            if(nomeCamera != null) {
                String identificacao = null;
                for(CameraBean cam : lista){
                    if(nomeCamera.equals(cam.getNome())){
                        identificacao = cam.getIdentificacao();
                        break;
                    }
                }
                painelFace = new PainelReconhecimentoFace(this, Integer .parseInt(identificacao), 664, 460); 
                painelFace.setSize(664,460);
                painelFace.setLocation(5, 5);
                pn_camera.add(painelFace);
            } else {
                dispose();
            }
        } else {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.comumNenhumaCameraCadastrada());
        }
    }
    
    public void setNomeReconhecido(final String faceName, final String dist) { // update face name and its distance in the nameField
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                lb_nome.setText(faceName + ", "+MensagensSoltas.comumAproximacao()+" = (" + dist + ")");
                bt_reconhecer.setEnabled(true);
            }
        });
    }

    private void fechar() {
        if(painelFace != null) {
            painelFace.fechar();
        } 
        dispose();
    }

    public Integer obtemQuantidadeImagensSalvas() {
        return qtdeSalvas;
    }
    
    public void exibirImagem(BufferedImage bufferedImage, String diretorio){
        ImagemPanel imagemPanel = new ImagemPanel(this, diretorio);
        imagemPanel.setSize(125, 150);
        ArrastaComponentes arrastaComponentes = new ArrastaComponentes();
        imagemPanel.addMouseListener(arrastaComponentes);
        imagemPanel.addMouseMotionListener(arrastaComponentes);
        imagemPanel.draw(ImagemUtil.redimencionar(bufferedImage, 125, 150));
        pn_imagens.add(imagemPanel);
        organizar();
        qtdeSalvas++;
    }
    
    private void organizar(){
        Integer local = 10;
        Integer x = 10, y = 10;
        Integer largura = 125;
        Component[] components = pn_imagens.getComponents();
        for(int i = 0; i < components.length; i++){
            JPanel cenario = (JPanel) components[i];
            cenario.setLocation(local, y);
            local += largura + x;
        }
        Integer a = pn_imagens.getSize().height;
        Dimension d = new Dimension(local, a);
        pn_imagens.setPreferredSize(d);
        pn_imagens.invalidate();
        scroll.invalidate();
    }
    
    /*CADASTRO*/
    private Boolean validar() {
        if(qtdeSalvas < 3 || qtdeSalvas > 5) {
            InstanciasControle.getMensagens().aviso(MensagensSoltas.comumQtdeFaces());
            return false;
        } 
        return true;
    }
    
    private void confirmar() {
        if(validar() && InstanciasControle.getMensagens().confirmacao(MensagensSoltas.comumConfirmar())) {
            lb_nome.setText(nomeAtual); 
            deletarArquivos();         
            for(String imagem : DiretorioUtil.listarArquivos(new File(ArquivosImagens.diretorio_temporario()))) {
                DiretorioUtil.copiarArquivo(ArquivosImagens.diretorio_temporario()+File.separator+imagem, ArquivosImagens.diretorio_faces()+File.separator+imagem);
            }          
            InstanciasControle.getMensagens().sucesso(MensagensSoltas.comumSalvar()); 
            bt_reconhecer.setEnabled(true); 
        }
    }
    
    private void deletarArquivos() {
        File cache = new File(ArquivosImagens.diretorio_faces()+File.separator+"mycache.cache");
        if(DiretorioUtil.verificarDiretorioExiste(cache)) {
            DiretorioUtil.deletarArquivo(cache);
        }
        File temp = new File(ArquivosImagens.diretorio_temporario()+File.separator+"temp.png");
        if(DiretorioUtil.verificarDiretorioExiste(temp)) {
            DiretorioUtil.deletarArquivo(temp);
        }
        if(listaFacesEditar != null) {
            for(String face : listaFacesEditar) {
                File f = new File(ArquivosImagens.diretorio_faces()+File.separator+face);
                if(DiretorioUtil.verificarDiretorioExiste(f)) {
                    DiretorioUtil.deletarArquivo(f);
                }
            }
        }
    }
    
    /*ALTERAR*/
    private void pesquisarImagens(String nome) {
        listaFacesEditar = new ArrayList<>();
        Integer cont = 0;
        for(String imagem : DiretorioUtil.listarArquivos(new File(ArquivosImagens.diretorio_faces()))) {
            nome = nome.replace(' ', '_');
            if(imagem.indexOf(nome) != -1) {
                listaFacesEditar.add(imagem);
                String novaImagem = nomeAtual+"-"+cont+".png";
                DiretorioUtil.copiarArquivo(ArquivosImagens.diretorio_faces()+File.separator+imagem, 
                        ArquivosImagens.diretorio_temporario()+File.separator+novaImagem);
                File f = new File(ArquivosImagens.diretorio_temporario()+File.separator+novaImagem);
                exibirImagem(ImagemUtil.ler(f), f.getAbsolutePath());
                cont++;
            }
        }
        if(!listaFacesEditar.isEmpty()) {
            bt_reconhecer.setEnabled(true);
        } 
    }
    
    /*
     * BANCO DE DADOS
     */
    
    private ArrayList<CameraBean> listarCameraOrdenadaPorCodigo() {
        CameraFacade cameraFacade = FactoryFacade.getCameraImpl();
        try {
            return cameraFacade.listarCameraOrdenadaPorCodigo();
        } catch (FacadeException ex) {
        }
        return null;
    }

}
