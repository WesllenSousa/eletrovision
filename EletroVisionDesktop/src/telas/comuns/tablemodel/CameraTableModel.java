package telas.comuns.tablemodel;

import entidades.area.bean.AreaBean;
import entidades.camera.bean.CameraBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesllen Sousa Lima,Hendrio Luis
 */
public class CameraTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Nome", "Identificaçao", "Prédio", "Área", "Marca"};

    public CameraTableModel(ArrayList<CameraBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<AreaBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<CameraBean> list) {
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
        CameraBean bean = (CameraBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getNome();
                case 2:
                    return bean.getIdentificacao();
                case 3:
                    return bean.getArea().getPredio();
                case 4:
                    return bean.getArea();
                case 5:
                    return bean.getMarcaBean();
                
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
}
