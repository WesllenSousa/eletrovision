package telas.comuns.tablemodel;

import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima,Hendrio Luis
 */
public class PessoaTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Nome", "CPF", "Nascimento", "Tipo"};

    public PessoaTableModel(ArrayList<PessoaBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<PessoaBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<PessoaBean> list) {
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
        PessoaBean bean = (PessoaBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getNome();
                case 2:
                    return bean.getCpf();
                case 3:
                    return DataUtil.formataData(bean.getData());
                case 4:
                    return bean.getTipo();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
