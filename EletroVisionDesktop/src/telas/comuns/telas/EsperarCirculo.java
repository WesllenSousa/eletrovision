
package telas.comuns.telas;

import java.util.Calendar;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class EsperarCirculo extends javax.swing.JDialog{
    
    private Integer tempoInicial, tempoFinal;
    
    public EsperarCirculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        lbx_busy.setBusy(true);
    }
    
    public EsperarCirculo(java.awt.Frame parent, boolean modal, String descricao) {
        super(parent, modal);
        initComponents();
       
        lbx_busy.setBusy(true);
        lbx_busy.setText(descricao); 
    }

    public EsperarCirculo(java.awt.Frame parent, boolean modal, Integer segundo) {
        super(parent, modal);
        initComponents();
       
        lbx_busy.setBusy(true);
        tempoInicial = Integer.parseInt(DataUtil.formataSegundo(Calendar.getInstance()));
        tempoFinal = tempoInicial + segundo;
        
        timer1.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        lbx_busy = new org.jdesktop.swingx.JXBusyLabel();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbx_busy.setText("Carregando...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbx_busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbx_busy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-174)/2, (screenSize.height-88)/2, 174, 88);
    }// </editor-fold>//GEN-END:initComponents

private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
    tempoInicial = Integer.parseInt(DataUtil.formataSegundo(Calendar.getInstance()));
    if(tempoInicial >= tempoFinal){
        dispose();
    }
}//GEN-LAST:event_timer1OnTime

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXBusyLabel lbx_busy;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

}
