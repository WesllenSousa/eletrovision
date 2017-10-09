
package telas.principal;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import recursos.configuracoes.diretorios.caminhos.ArquivosHTML;
import telas.comuns.html.HtmlPane;
import util.SistemaOperacional;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Manual extends javax.swing.JPanel {

    public Manual() {
        initComponents();
        
        if(SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.LINUX) {
            htmlPane(ArquivosHTML.manual()+"index.html");
        } else {
            nativeWebBrowser("file://"+ArquivosHTML.manual()+ArquivosHTML.index()); 
        }
    }
    
    public Manual(String link) {
        initComponents();
        
        if(SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.LINUX) {
            htmlPane(link);
        } else {
            nativeWebBrowser("file://"+link); 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();

        jPanel15.setBackground(new java.awt.Color(51, 175, 233));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private void htmlPane(String caminho) {
        HtmlPane htmlPane = new HtmlPane(caminho);
        htmlPane.setSize(1100, 800);
        scroll.setViewportView(htmlPane); 
        htmlPane.requestFocus();
    }
    
    private void nativeWebBrowser(String camingo) { 
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.setSize(1100, 800);
        webBrowser.navigate(camingo);
        webBrowser.setMenuBarVisible(false); 
        webBrowser.setLocationBarVisible(false);
        scroll.setViewportView(webBrowser);
    }
    
}
