
package EletroVisionPortatil;

import EletroVisionPortatil.dependencias.CenarioTableModel;
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
import wsl.eletrovision.controle.serializado.GuardaCenario;

/**
 *
 * @author Wesllen
 */
public class TelaCenario extends javax.swing.JPanel {
    
    private EsperarCirculo carregamento;

    public TelaCenario() {
        initComponents();
        
        popularTabela(new ArrayList<GuardaCenario>());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_cenarios = new javax.swing.JTable();

        tb_cenarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_cenarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cenariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_cenarios);

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

    private void tb_cenariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cenariosMouseClicked
        if (tb_cenarios.getSelectedColumn() == 1) {
            acionar();
        } else if(tb_cenarios.getSelectedColumn() == 2) {
            configuracao();
        }
    }//GEN-LAST:event_tb_cenariosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_cenarios;
    // End of variables declaration//GEN-END:variables

    public void carregarTabela() {
        if(carregamento != null) {
            carregamento.dispose();
        }
        popularTabela(InstanciasPortatil.getGuardaCenarios());
        BotaoTabela botaoTabela1 = new BotaoTabela(tb_cenarios, 1);
        BotaoTabela botaoTabela2 = new BotaoTabela(tb_cenarios, 2);
    }
    
    private void popularTabela(ArrayList<GuardaCenario> lista) {
        CenarioTableModel modelo = new CenarioTableModel(lista);
        tb_cenarios.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tb_cenarios.setRowSorter(sorter);
        definirTamanhoColunas();
        definirAlinhamentoColunas();
    }
    
    private void definirTamanhoColunas() {
        tb_cenarios.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_cenarios.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb_cenarios.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void definirAlinhamentoColunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_cenarios.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_cenarios.getColumnModel().getColumn(1).setCellRenderer(rendererCentro);
        tb_cenarios.getColumnModel().getColumn(2).setCellRenderer(rendererCentro);
    }
    
    private GuardaCenario obtemCenarioSelecionado() {
        return (GuardaCenario) tb_cenarios.getValueAt(tb_cenarios.getSelectedRow(), -1);
    }
    
    private void acionar() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_ACIONAR_CENARIOS);
            InstanciasPortatil.getCliente().enviarDados(obtemCenarioSelecionado().getCodigo());
            switch (obtemCenarioSelecionado().getAcao()) {
                case "Ligar":
                    InstanciasPortatil.getCliente().enviarDados("1");
                    break;
                case "Desligar":
                    InstanciasPortatil.getCliente().enviarDados("0");
                    break;
            }
        }
    }
    
    private void configuracao() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CONFIG_ACIONAMENTO);
            InstanciasPortatil.getCliente().enviarDados(obtemCenarioSelecionado().getCodigo());
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

    public void solicitarCenarios() {
        if(InstanciasPortatil.getCliente() != null) {
            esperar();
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_CENARIOS);
        }
    }
    
    public EsperarCirculo getCarregamento() {
        return carregamento;
    }
    
}
