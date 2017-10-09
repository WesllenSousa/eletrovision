
package telas.comuns.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import telas.geral.dependencias.ItemAgendarTarefas;

/**
 *
 * @author Wesllen Sousa Lima      
 */
public class ItemAgendarTarefasTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Agendamento", "Vínculo"};

    public ItemAgendarTarefasTableModel(ArrayList<ItemAgendarTarefas> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<ItemAgendarTarefas> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<ItemAgendarTarefas> list) {
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
        ItemAgendarTarefas bean = (ItemAgendarTarefas) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getAgendarTarefas();
                case 1:
                    if(bean.getAcionamento() != null)
                        return bean.getAcionamento();
                    else if(bean.getMensagem() != null)
                        return bean.getMensagem();
                    else if(bean.getCamera() != null)
                        return bean.getCamera();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
