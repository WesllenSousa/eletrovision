package telas;

import org.jdesktop.swingx.mapviewer.GeoPosition;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Mapa extends javax.swing.JFrame {

    public Mapa() {
        initComponents();
    }

    public Mapa(Double longitude, Double latitude) {
        initComponents();

        exibePontoGeografico(latitude, longitude); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mp_mapa = new org.jdesktop.swingx.JXMapKit();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mapa");

        mp_mapa.setDefaultProvider(org.jdesktop.swingx.JXMapKit.DefaultProviders.OpenStreetMaps);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mp_mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mp_mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-632)/2, (screenSize.height-534)/2, 632, 534);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXMapKit mp_mapa;
    // End of variables declaration//GEN-END:variables

    private void exibePontoGeografico(Double latitude, Double longitude) {
        mp_mapa.getMainMap().setZoom(2);
        mp_mapa.setAddressLocation(new GeoPosition(latitude, longitude));
    }
    
}
