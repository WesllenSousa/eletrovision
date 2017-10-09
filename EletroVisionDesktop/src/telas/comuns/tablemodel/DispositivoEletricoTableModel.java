
package telas.comuns.tablemodel;

import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DispositivoEletricoTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Nome", "Módulo de Acionamento", "Identificação", "Prédio", "Área", "Marca"};

    public DispositivoEletricoTableModel(ArrayList<DispositivoEletricoBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<DispositivoEletricoBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<DispositivoEletricoBean> list) {
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
        DispositivoEletricoBean bean = (DispositivoEletricoBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getNome();
                case 2:
                    return bean.getModuloAcionamento();
                case 3:
                    return bean.getIdentificacao();
                case 4:
                    return bean.getArea().getPredio();
                case 5:
                    return bean.getArea();
                case 6:
                    return bean.getMarcaBean();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
