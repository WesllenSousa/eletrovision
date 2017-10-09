
package telas.comuns.tablemodel;

import entidades.logAcoes.bean.LogAcoesBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class LogAcoesTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Descrição", "Data/Hora", "Responsável", "Ação", "Rede"};

    public LogAcoesTableModel(ArrayList<LogAcoesBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<LogAcoesBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<LogAcoesBean> list) {
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
        LogAcoesBean bean = (LogAcoesBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getDescricao();
                case 2:
                    return DataUtil.formataDataHHmmSS(bean.getDataHora());
                case 3:
                    return bean.getResponsavel();
                case 4:
                    if(bean.getAcionamento() != null)
                        return bean.getAcionamento();
                    else if(bean.getAgendarTarefas() != null)
                        return bean.getAgendarTarefas();
                    else if(bean.getDispositivoEletrico() != null)
                        return bean.getDispositivoEletrico();
                case 5:
                    if(bean.getRede() != null)
                        return bean.getRede().getDescricao();
                    else
                        return "-";
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
