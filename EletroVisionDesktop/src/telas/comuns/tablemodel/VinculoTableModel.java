
package telas.comuns.tablemodel;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wesllen Sousa Lima      
 */
public class VinculoTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Descrição", "Ação"};

    public VinculoTableModel(ArrayList<AgendarTarefasBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<AgendarTarefasBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<AgendarTarefasBean> list) {
        linhas = list;
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
        AgendarTarefasBean bean = (AgendarTarefasBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getDescricao();
                case 2:
                    return bean.getAcaoAgendamento();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
