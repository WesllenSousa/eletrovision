
package telas.geral;

import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import controle.mapa.GuardaLocalizacaoGPS;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.Waypoint;
import org.jdesktop.swingx.mapviewer.WaypointPainter;
import recursos.instancias.InstanciasControle;
import recursos.instancias.InstanciasTelas;
import recursos.internacionalizacao.MensagensSoltas;
import telas.geral.dependencias.CoordenadasGeograficas;
import telas.principal.Manual;
import util.SwingUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GeralLocalizacaoGps extends javax.swing.JPanel {
    
    private Boolean bloquearCombo = false;
    
    public GeralLocalizacaoGps() {
        initComponents();
        InstanciasTelas.setGeralLocalizacaoGps(GeralLocalizacaoGps.this); 
        
        preencheUsuarios();   
        lerLocalizacao();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_usuarios = new javax.swing.JComboBox();
        bt_salvarPontoCentral = new javax.swing.JButton();
        bt_itPontoCentral = new javax.swing.JButton();
        bt_itPontoCentral1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        bt_ajuda = new javax.swing.JButton();
        mp_mapa = new org.jdesktop.swingx.JXMapKit();

        jPanel1.setBackground(new java.awt.Color(76, 158, 92));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cb_usuarios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cb_usuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Todos usuários conectados>" }));
        cb_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_usuariosActionPerformed(evt);
            }
        });

        bt_salvarPontoCentral.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_salvarPontoCentral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/pontocentral_22x22.png"))); // NOI18N
        bt_salvarPontoCentral.setToolTipText("Salvar localização central");
        bt_salvarPontoCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarPontoCentralActionPerformed(evt);
            }
        });

        bt_itPontoCentral.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_itPontoCentral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/irpontocentral_22x22.png"))); // NOI18N
        bt_itPontoCentral.setToolTipText("Ir localização central");
        bt_itPontoCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_itPontoCentralActionPerformed(evt);
            }
        });

        bt_itPontoCentral1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_itPontoCentral1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/limpar_22x22.png"))); // NOI18N
        bt_itPontoCentral1.setToolTipText("Mostra corrdenadas geográficas");
        bt_itPontoCentral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_itPontoCentral1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/acoes/ajuda_22x22.png"))); // NOI18N
        bt_ajuda.setToolTipText("Ajuda");
        bt_ajuda.setOpaque(false);
        bt_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salvarPontoCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_itPontoCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_itPontoCentral1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(bt_itPontoCentral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cb_usuarios, javax.swing.GroupLayout.Alignment.LEADING))
            .addComponent(bt_itPontoCentral1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_salvarPontoCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_ajuda)
        );

        mp_mapa.setDefaultProvider(org.jdesktop.swingx.JXMapKit.DefaultProviders.OpenStreetMaps);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mp_mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mp_mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_usuariosActionPerformed
        if(!bloquearCombo) {
            if(cb_usuarios.getSelectedIndex() != 0) {
                GuardaLocalizacaoGPS localizacao = (GuardaLocalizacaoGPS) cb_usuarios.getSelectedItem();
                exibePontoGeografico(localizacao.getLatitude(), localizacao.getLongitude());
                mp_mapa.getMainMap().setZoom(2);
            } else {
                lerLocalizacao();
            }   
        }
    }//GEN-LAST:event_cb_usuariosActionPerformed

    private void bt_salvarPontoCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarPontoCentralActionPerformed
        GeoPosition geoPosition = mp_mapa.getCenterPosition();
        salvarLocalizacao(geoPosition.getLatitude(), geoPosition.getLongitude());
        System.out.println("Latitude: "+geoPosition.getLatitude());
        System.out.println("Longitude: "+geoPosition.getLongitude());
    }//GEN-LAST:event_bt_salvarPontoCentralActionPerformed

    private void bt_itPontoCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_itPontoCentralActionPerformed
        lerLocalizacao();
    }//GEN-LAST:event_bt_itPontoCentralActionPerformed

    private void bt_itPontoCentral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_itPontoCentral1ActionPerformed
        if(cb_usuarios.getSelectedIndex() != 0) {
            GuardaLocalizacaoGPS localizacao = (GuardaLocalizacaoGPS) cb_usuarios.getSelectedItem();
            CoordenadasGeograficas dialog = new CoordenadasGeograficas(null, true, this, 
                    localizacao.getLatitude(), localizacao.getLongitude());
            dialog.setVisible(true);
        } else {
            CoordenadasGeograficas dialog = new CoordenadasGeograficas(null, true, this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_bt_itPontoCentral1ActionPerformed

    private void bt_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_bt_ajudaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajuda;
    private javax.swing.JButton bt_itPontoCentral;
    private javax.swing.JButton bt_itPontoCentral1;
    private javax.swing.JButton bt_salvarPontoCentral;
    private javax.swing.JComboBox cb_usuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXMapKit mp_mapa;
    // End of variables declaration//GEN-END:variables

    private void preencheUsuarios() {
        bloquearCombo = true;
        if(InstanciasControle.getGuardaLocalizacaoGPSs() != null) {
            WaypointPainter painter = new WaypointPainter();
            Set waypoints = new HashSet();
            cb_usuarios.removeAllItems();
            cb_usuarios.addItem("<Todos usuários conectados>");
            for(GuardaLocalizacaoGPS localizacao : InstanciasControle.getGuardaLocalizacaoGPSs()) {
                cb_usuarios.addItem(localizacao); 
                Waypoint waypoint = new Waypoint(localizacao.getLatitude(), localizacao.getLongitude());
                waypoints.add(waypoint);  
            } 
            painter.setWaypoints(waypoints);
            mp_mapa.getMainMap().setOverlayPainter(painter); 
        }
        bloquearCombo = false;
    }

    private void salvarLocalizacao(Double latitude, Double longitude) {
        Properties props = new Properties();
        props.setProperty("latitude", latitude+"");
        props.setProperty("longitude", longitude+"");

        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.localizacaoGps(),
                "Guarda a localização central GPS!");
        
        exibePontoGeografico(latitude, longitude);
        InstanciasControle.getMensagens().sucesso(MensagensSoltas.gerGpsSalvarPonto());
    }
    
    private void lerLocalizacao(){
        Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.localizacaoGps());
        if (props != null) {
            String latitude = props.getProperty("latitude");
            String longitude = props.getProperty("longitude");

            exibePontoGeografico(Double.parseDouble(latitude), Double.parseDouble(longitude));
            mp_mapa.getMainMap().setZoom(50);
        }
    }
    
    public void exibePontoGeografico(Double latitude, Double longitude) {
        mp_mapa.setAddressLocation(new GeoPosition(latitude, longitude));
    }
    
    public void atualizarTela() {
        preencheUsuarios();
    }
    
    private void ajuda() {
        Manual manual = new Manual(ArquivosHTML.geral()+ArquivosHTML.localizacaoGps());
        SwingUtil.adicionarTabComBotaoFechar(InstanciasTelas.getPrincipal().tb_principal, "Ajuda", manual); 
    }
   
}
