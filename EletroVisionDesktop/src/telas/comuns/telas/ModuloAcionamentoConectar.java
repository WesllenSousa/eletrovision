package telas.comuns.telas;

import controle.dispositivos.GerenciarAcionamento;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import recursos.instancias.InstanciasControle;
import telas.comuns.table.BotaoTabela;
import telas.comuns.tablemodel.ModuloAcionamentoConectarTableModel;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ModuloAcionamentoConectar extends javax.swing.JDialog {

    public ModuloAcionamentoConectar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        carregarTabela();
        if (InstanciasControle.getGerenciarAcionamentos() == null) {
            ArrayList<GerenciarAcionamento> lista = new ArrayList<>();
            InstanciasControle.setGerenciarAcionamentos(lista);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_modulos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conexão dos módulos de acionamento");
        setResizable(false);

        tb_modulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_modulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_modulos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-408)/2, (screenSize.height-254)/2, 408, 254);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_modulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_modulosMouseClicked
        if (tb_modulos.getSelectedColumn() == 1) {
            conectarDesconectar();
        }
    }//GEN-LAST:event_tb_modulosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_modulos;
    // End of variables declaration//GEN-END:variables

    private void conectarDesconectar() {
        if (tb_modulos.getValueAt(tb_modulos.getSelectedRow(), tb_modulos.getSelectedColumn()).equals("Conectar")) {
            GerenciarAcionamento gerenciarAcionamento = new GerenciarAcionamento(obtemModuloSelecionado());
            if (gerenciarAcionamento.isConnected()) {
                InstanciasControle.getGerenciarAcionamentos().add(gerenciarAcionamento);
            }
        } else {
            ModuloAcionamentoBean bean = obtemModuloSelecionado();
            if (InstanciasControle.getGerenciarAcionamentos() != null) {
                for (GerenciarAcionamento modulo : InstanciasControle.getGerenciarAcionamentos()) {
                    if (bean.getCodigo() == modulo.getGerente().getModuloAcionamento().getCodigo()) {
                        modulo.getGerente().disconnect();
                        InstanciasControle.getGerenciarAcionamentos().remove(modulo);
                        break;
                    }
                }
            }
        }
        carregarTabela();
    }

    private void carregarTabela() {
        popularTabela(listarModulosAcionamento());
        BotaoTabela botaoTabela = new BotaoTabela(tb_modulos, 1);
    }

    private void popularTabela(ArrayList<ModuloAcionamentoBean> lista) {
        ModuloAcionamentoConectarTableModel modelo = new ModuloAcionamentoConectarTableModel(lista);
        tb_modulos.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tb_modulos.setRowSorter(sorter);
        definirTamanhoColunas();
        definirAlinhamentoColunas();
    }

    private void definirTamanhoColunas() {
        tb_modulos.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_modulos.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    private void definirAlinhamentoColunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        tb_modulos.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_modulos.getColumnModel().getColumn(1).setCellRenderer(rendererCentro);
    }

    private ModuloAcionamentoBean obtemModuloSelecionado() {
        return (ModuloAcionamentoBean) tb_modulos.getValueAt(tb_modulos.getSelectedRow(), -1);
    }

    /*
     * BANCO DE DADOS
     */
    private ArrayList<ModuloAcionamentoBean> listarModulosAcionamento() {
        ModuloAcionamentoFacade moduloAcionamentoFacade = FactoryFacade.getModuloAcionamentoImpl();
        try {
            return moduloAcionamentoFacade.listarModuloAcionamentoNaoDeletado();
        } catch (FacadeException ex) {
        }
        return null;
    }

}
