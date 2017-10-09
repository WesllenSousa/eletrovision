
package telas.comuns.tablemodel;

import entidades.acesso.bean.AcessoBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima      
 */
public class AcessoTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Data/Hora Início", "Data/Hora Fim", "Usuário"};

    public AcessoTableModel(ArrayList<AcessoBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<AcessoBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<AcessoBean> list) {
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
        AcessoBean bean = (AcessoBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return DataUtil.formataDataHHmmSS(bean.getDataHoraInicio());
                case 2:
                    if(bean.getDataHoraFim() != null)
                        return DataUtil.formataDataHHmmSS(bean.getDataHoraFim());
                    else
                        return "";
                case 3:
                    return bean.getUsuario().getPessoa();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
