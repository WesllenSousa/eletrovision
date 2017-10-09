
package EletroVisionPortatil;

import EletroVisionPortatil.dependencias.DispositivoTableModel;
import EletroVisionPortatil.dependencias.InstanciasPortatil;
import recursos.constantes.ConstantesRedes;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.internacionalizacao.MensagensSoltas;
import telas.comuns.telas.EsperarCirculo;
import telas.comuns.table.BotaoTabela;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;

/**
 *
 * @author Wesllen
 */
public class TelaDispositivos extends javax.swing.JPanel {

    private EsperarCirculo carregamento;
    
    public TelaDispositivos() {
        initComponents();
        
        popularTabela(new ArrayList<GuardaDispositivo>());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_dispositivos = new javax.swing.JTable();

        tb_dispositivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_dispositivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dispositivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_dispositivos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_dispositivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dispositivosMouseClicked
        if (tb_dispositivos.getSelectedColumn() == 1) {
            acionar();
        }
    }//GEN-LAST:event_tb_dispositivosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_dispositivos;
    // End of variables declaration//GEN-END:variables

    public void carregarTabela() {
        carregamento.dispose();
        popularTabela(InstanciasPortatil.getGuardaDispositivos());
        BotaoTabela botaoTabela = new BotaoTabela(tb_dispositivos, 1);
    }
    
    private void popularTabela(ArrayList<GuardaDispositivo> lista) {
        DispositivoTableModel modelo = new DispositivoTableModel(lista);
        tb_dispositivos.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tb_dispositivos.setRowSorter(sorter);
        definirTamanhoColunas();
        definirAlinhamentoColunas();
    }
    
    private void definirTamanhoColunas() {
        tb_dispositivos.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_dispositivos.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    private void definirAlinhamentoColunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_dispositivos.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_dispositivos.getColumnModel().getColumn(1).setCellRenderer(rendererCentro);
    }
    
    private GuardaDispositivo obtemDispositivoSelecionado() {
        return (GuardaDispositivo) tb_dispositivos.getValueAt(tb_dispositivos.getSelectedRow(), -1);
    }
    
    private void acionar() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_ACIONAR_DISPOSITIVOS);
            InstanciasPortatil.getCliente().enviarDados(obtemDispositivoSelecionado().getCodigo());
        }
    }
    
    public void confirmacao(String confirmacao) {
        carregamento.dispose();
        switch (confirmacao) {
            case "0":
                InstanciasPortatil.getMensagens().bug(MensagensSoltas.portatilErroDispositivo());
                break;
            case "1":
                InstanciasPortatil.getMensagens().sucesso(MensagensSoltas.portatilDispositivoSucesso());
                break;
            case "2":
                InstanciasPortatil.getMensagens().aviso(MensagensSoltas.portatilAcionamentoDesativado());
                break;
        }
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

    public void solicitarDispositivos() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_DISPOSITIVOS);
        }
    }

}
