
package telas.comuns.tablemodel;

import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class ModuloAcionamentoTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Nome", "Marca", "IP", "Porta", "Saída"};

    public ModuloAcionamentoTableModel(ArrayList<ModuloAcionamentoBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<ModuloAcionamentoBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<ModuloAcionamentoBean> list) {
        linhas = list;
    }

    //Retorna o numero de colunas no modelo
    //@see javax.swing.table.TableModel#getColumnCount()
    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    //Retorna o numero de linhas existentes no modelo
    //@see javax.swing.table.TableModel#getRowCount()
    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModuloAcionamentoBean bean = (ModuloAcionamentoBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getNome();
                case 2:
                    return bean.getMarcaBean().getNome();
                case 3:
                    return bean.getIdentificacao();
                case 4:
                    return bean.getPorta();
                case 5:
                    return bean.getQtdeSaida();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
