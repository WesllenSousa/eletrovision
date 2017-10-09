
package telas.comuns.tablemodel;

import entidades.mensagem.bean.MensagemBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MensagemTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Código", "Assunto", "Mensagem", "Destino", "Tipo", "Data/Hora", "Movimento"};

    public MensagemTableModel(ArrayList<MensagemBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<MensagemBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<MensagemBean> list) {
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
        MensagemBean bean = (MensagemBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getAssunto();
                case 2:
                    return bean.getMensagem();
                case 3:
                    if(bean.getDestino() != null) {
                        return bean.getDestino();
                    } else {
                        return "Todos usuários conectados";
                    }
                case 4:
                    return bean.getTipo().getDescricao();
                case 5:
                    return DataUtil.formataDataHora(bean.getDataHora());
                case 6:
                    return bean.getMovimento();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
