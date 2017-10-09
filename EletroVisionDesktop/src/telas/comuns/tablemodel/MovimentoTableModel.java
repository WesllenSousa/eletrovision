
package telas.comuns.tablemodel;

import entidades.movimento.bean.MovimentoBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MovimentoTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Data/Hora", "Diretório", "Qtde Pessoas", "Qtde Objetos", "Câmera"};

    public MovimentoTableModel(ArrayList<MovimentoBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<MovimentoBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<MovimentoBean> list) {
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
        MovimentoBean bean = (MovimentoBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return DataUtil.formataDataHHmmSS(bean.getData_hms());
                case 2:
                    return bean.getDiretorio();
                case 3:
                    return bean.getQtdePessoas();
                case 4:
                    return bean.getQtdeObjetos();
                case 5:
                    return bean.getCamera();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
