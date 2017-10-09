
package telas.dependencias;

import controle.redes.dependencias.ConstantesRedes;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import recursos.InstanciasPortatil;
import telas.tabbedPane.BotaoTabela;
import util.RedeUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class TelaClientesConectados extends javax.swing.JDialog {
    
    private EsperarCirculo carregamento;
    
    public TelaClientesConectados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        InstanciasPortatil.setTelaClientesConectados(TelaClientesConectados.this);
        
        lb_ip.setText(RedeUtil.obtemIpLocal());
        popularTabela(new ArrayList<ClientesConectado>());
        solicitarContatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_ip = new javax.swing.JLabel();
        pn_contatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_contatos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        bt_fechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Situação do Servidor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Localização do servidor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        lb_ip.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lb_ip.setText("127.0.0.1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_contatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos conectados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        tb_contatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_contatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tb_contatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_contatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_contatos);

        javax.swing.GroupLayout pn_contatosLayout = new javax.swing.GroupLayout(pn_contatos);
        pn_contatos.setLayout(pn_contatosLayout);
        pn_contatosLayout.setHorizontalGroup(
            pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_contatosLayout.setVerticalGroup(
            pn_contatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_contatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_fechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagens/layout/cancelar_22x22.png"))); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_fechar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_contatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_contatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setBounds((screenSize.width-541)/2, (screenSize.height-525)/2, 541, 525);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        fechar();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void tb_contatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_contatosMouseClicked
        if(tb_contatos.getSelectedColumn() == 4) {
            gps(obtemInformacoesClienteSelecionado().getContato()); 
        }
    }//GEN-LAST:event_tb_contatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ip;
    private javax.swing.JPanel pn_contatos;
    private javax.swing.JTable tb_contatos;
    // End of variables declaration//GEN-END:variables

    public void carregaTabela() {
        carregamento.dispose();
        limparTabela();
        popularTabela(InstanciasPortatil.getClientesConectados());
        BotaoTabela botao = new BotaoTabela(tb_contatos, 4);
    }
    
    private void popularTabela(ArrayList<ClientesConectado> lista) {
        StatusServidorTableModel modelo = new StatusServidorTableModel(lista);
        tb_contatos.setModel(modelo);
        definirTamanhoColunas();
        definirAlinhamentoColunas();
    }
    
    private void definirTamanhoColunas() {
        tb_contatos.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_contatos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb_contatos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tb_contatos.getColumnModel().getColumn(3).setPreferredWidth(70);
        tb_contatos.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    
    private void definirAlinhamentoColunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        
        tb_contatos.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_contatos.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tb_contatos.getColumnModel().getColumn(2).setCellRenderer(rendererEsquerda);
        tb_contatos.getColumnModel().getColumn(3).setCellRenderer(rendererCentro);
        tb_contatos.getColumnModel().getColumn(4).setCellRenderer(rendererCentro);
    }
    
    private void limparTabela() {
        ((StatusServidorTableModel)tb_contatos.getModel()).limpaDados();
        tb_contatos.updateUI();
    } 
    
    private ClientesConectado obtemInformacoesClienteSelecionado() {
        return (ClientesConectado) tb_contatos.getValueAt(tb_contatos.getSelectedRow(), -1);
    }
    
    private void esperar() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                carregamento = new EsperarCirculo(null, true);
                carregamento.setVisible(true);
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    private void fechar() {
        InstanciasPortatil.setTelaClientesConectados(null);
        dispose();
    }

    private void solicitarContatos() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CLIENTE_CONECTADOS);
        }
    }
    
    private void gps(String usuario) {
        if(InstanciasPortatil.getCliente() != null) {
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_INFORMAR_LOCALIZACAO_GPS);
            InstanciasPortatil.getCliente().enviarDados(usuario);
        }
    }
    
}
