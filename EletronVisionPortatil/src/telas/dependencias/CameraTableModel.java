
package telas.dependencias;

import wsl.eletrovision.controle.serializado.GuardaCamera;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class CameraTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Câmera", "Ação", "Configuração"};

    public CameraTableModel(ArrayList<GuardaCamera> dados) {
        setLinhas(dados);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 1) {
            return true;
        }
        return false;
    }

    public void addLinha(Object dado) {
        linhas.add(dado);
    }

    public void removeLinha(Object dado) {
        linhas.remove(dado);
    }

    public void atualizaLinha(int index, Object dado) {
        linhas.set(index, dado);
    }

    public void limpaDados() {
        linhas.clear();
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<GuardaCamera> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<GuardaCamera> list) {
        linhas = list;
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class getColumnClass(int column) {
        Class klass = String.class; 
        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 1) {

        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GuardaCamera bean = (GuardaCamera) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCamera();
                case 1:
                    return bean.getAcao();
                case 2:
                    return bean.getConfiguracao();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
