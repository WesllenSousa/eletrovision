
package telas.comuns.telas;

import java.awt.event.KeyEvent;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class CarregarBarraProgresso extends javax.swing.JDialog {
    
    private Integer quantidade;
     
    public CarregarBarraProgresso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CarregarBarraProgresso(java.awt.Frame parent, boolean modal, Integer tipo) {
        super(parent, modal);
        initComponents();
        
        this.quantidade = tipo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pg_barraProgresso = new javax.swing.JProgressBar();
        bt_iniciar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicialização de câmeras");
        setResizable(false);

        bt_iniciar.setText("Iniciar");
        bt_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_iniciarActionPerformed(evt);
            }
        });
        bt_iniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bt_iniciarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pg_barraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(bt_iniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pg_barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        setBounds((screenSize.width-383)/2, (screenSize.height-97)/2, 383, 97);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_iniciarActionPerformed
        bt_iniciar.setText("Iniciando...");
        bt_iniciar.setEnabled(false);
        if(quantidade == 0) {
            carregarCamerasCadastradas();
        } else {
            carregarTodasCameras();
        }
    }//GEN-LAST:event_bt_iniciarActionPerformed

    private void bt_iniciarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_iniciarKeyReleased
        if(evt.getKeyChar() == KeyEvent.VK_ENTER) {
            bt_iniciar.setText("Iniciando...");
            bt_iniciar.setEnabled(false);
            if(quantidade == 0) {
                carregarCamerasCadastradas();
            } else {
                carregarTodasCameras();
            }
        }
    }//GEN-LAST:event_bt_iniciarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_iniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar pg_barraProgresso;
    // End of variables declaration//GEN-END:variables

    public void atualizar(Integer valor) {
        pg_barraProgresso.setValue(valor);
    }
    
    private void carregarCamerasCadastradas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InstanciasControle.getIniciarCameras().detectarCamerasCadastradas(CarregarBarraProgresso.this);
                InstanciasControle.getIniciarCameras().iniciarCaptura();
                dispose();
            }
        }).start();
    }
    
    private void carregarTodasCameras() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InstanciasControle.getIniciarCameras().detectarTodasCameras(CarregarBarraProgresso.this, quantidade);
                InstanciasControle.getIniciarCameras().iniciarCaptura();
                dispose();
            }
        }).start();
    }

}
