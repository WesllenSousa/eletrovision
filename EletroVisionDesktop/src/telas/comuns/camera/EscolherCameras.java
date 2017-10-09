
package telas.comuns.camera;

import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import recursos.instancias.InstanciasControle;
import telas.cadastros.CadastrarCamera;
import telas.comuns.imagens.ImagemPanel;
import telas.comuns.telas.CarregarBarraProgresso;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class EscolherCameras extends javax.swing.JDialog {
    
    private CadastrarCamera cadastrarCamera;
    
    public EscolherCameras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public EscolherCameras(java.awt.Frame parent, boolean modal, Object tela) {
        super(parent, modal);
        initComponents();

        verificaInstancia(tela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        pn_cameras = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolher Câmeras");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout pn_camerasLayout = new javax.swing.GroupLayout(pn_cameras);
        pn_cameras.setLayout(pn_camerasLayout);
        pn_camerasLayout.setHorizontalGroup(
            pn_camerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        pn_camerasLayout.setVerticalGroup(
            pn_camerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        scroll.setViewportView(pn_cameras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-516)/2, (screenSize.height-267)/2, 516, 267);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        pararCameras();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pn_cameras;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    public void preparaCameras(Integer quantidade){    
        CarregarBarraProgresso progresso = new CarregarBarraProgresso(null, true, quantidade);
        progresso.setVisible(true);  
        exibirCamera();
    }
    
    private void exibirCamera(){
        for(ServidorCamera camera : InstanciasControle.getIniciarCameras().getServidoresCameras()){
            ImagemPanel painel = new ImagemPanel(EscolherCameras.this, camera.getCamera().getIdentificacao());
            painel.setSize(250, 200);
            painel.setLocation(10, 10);
            camera.setImagemPanel(painel, 250, 200); 
            pn_cameras.add(painel); 
            organizar();
        }
    }
    
    private void organizar(){
        Integer local = 10;
        Integer x = 10, y = 10;
        Integer largura = 250;
        Component[] components = pn_cameras.getComponents();
        for(int i = 0; i < components.length; i++){
            JPanel cenario = (JPanel) components[i];
            cenario.setLocation(local, y);
            local += largura + x;
        }
        Integer a = pn_cameras.getSize().height;
        Dimension d = new Dimension(local, a);
        pn_cameras.setPreferredSize(d);
        pn_cameras.invalidate();
        scroll.invalidate();
    }
    
    public void confirmar(Integer identificacao) {
        cadastrarCamera.setIdentificacao(identificacao);
        pararCameras();
        dispose();
    }
    
    private void pararCameras() {
        InstanciasControle.getIniciarCameras().pararCaptura();
    }
    
    private void verificaInstancia(Object tela) {
        if(tela instanceof CadastrarCamera) {
            cadastrarCamera = (CadastrarCamera) tela;
        }
    }

}
