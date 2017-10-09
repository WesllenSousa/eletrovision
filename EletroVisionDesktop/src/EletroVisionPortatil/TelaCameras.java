
package EletroVisionPortatil;

import EletroVisionPortatil.dependencias.CameraTableModel;
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
import wsl.eletrovision.controle.serializado.GuardaCamera;

/**
 *
 * @author Wesllen
 */
public class TelaCameras extends javax.swing.JPanel {
    
    private EsperarCirculo carregamento;

    public TelaCameras() {
        initComponents();
        
        popularTabela(new ArrayList<GuardaCamera>());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_camera = new javax.swing.JTable();

        tb_camera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_camera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cameraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_camera);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_cameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cameraMouseClicked
        if (tb_camera.getSelectedColumn() == 1) {
            tirarFoto();
        } else if(tb_camera.getSelectedColumn() == 2) {
            configuracao();
        }
    }//GEN-LAST:event_tb_cameraMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_camera;
    // End of variables declaration//GEN-END:variables

    public void carregarTabela() {
        carregamento.dispose();
        popularTabela(InstanciasPortatil.getGuardaCameras());
        BotaoTabela botaoTabela1 = new BotaoTabela(tb_camera, 1);
        BotaoTabela botaoTabela2 = new BotaoTabela(tb_camera, 2);
    }
    
    private void popularTabela(ArrayList<GuardaCamera> lista) {
        CameraTableModel modelo = new CameraTableModel(lista);
        tb_camera.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tb_camera.setRowSorter(sorter);
        definirTamanhoColunas();
        definirAlinhamentoColunas();
    }
    
    private void definirTamanhoColunas() {
        tb_camera.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_camera.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb_camera.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void definirAlinhamentoColunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_camera.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_camera.getColumnModel().getColumn(1).setCellRenderer(rendererCentro);
        tb_camera.getColumnModel().getColumn(2).setCellRenderer(rendererCentro);
    }
    
    private GuardaCamera obtemCameraSelecionada() {
        return (GuardaCamera) tb_camera.getValueAt(tb_camera.getSelectedRow(), -1);
    }
    
    private void tirarFoto() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_TIRAR_FOTO);
            InstanciasPortatil.getCliente().enviarDados(obtemCameraSelecionada().getCodigo());
        }
    }
    
    private void configuracao() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_CAMERA);
            InstanciasPortatil.getCliente().enviarDados(obtemCameraSelecionada().getCodigo());
        }
    }
    
    public void confirmacao(String confirmacao) {
        carregamento.dispose();
        switch (confirmacao) {
            case "0":
                InstanciasPortatil.getMensagens().aviso(MensagensSoltas.portatilCamerasDesligadas());
                break;
            case "2":
                InstanciasPortatil.getMensagens().aviso(MensagensSoltas.portatilCameraDesativada());
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

    public void solicitarCameras() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CAMERAS);
        }
    }

    public EsperarCirculo getCarregamento() {
        return carregamento;
    }
    
}
