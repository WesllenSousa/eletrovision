
package telas.comuns.tablemodel;

import controle.dispositivos.GerenciarAcionamento;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen Sousa Lima, Hendrio Luis
 */
public class ModuloAcionamentoConectarTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Módulo de Acionamento", "Conectado?"};

    public ModuloAcionamentoConectarTableModel(ArrayList<ModuloAcionamentoBean> dados) {
        setLinhas(dados);
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<ModuloAcionamentoBean> getLinhas() {
        return linhas;
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<ModuloAcionamentoBean> list) {
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
    public boolean isCellEditable(int row, int col) {
        if (col == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModuloAcionamentoBean bean = (ModuloAcionamentoBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getNome();
                case 1:
                    String valor="";
                    if(InstanciasControle.getGerenciarAcionamentos() != null) {
                        for(GerenciarAcionamento modulo : InstanciasControle.getGerenciarAcionamentos()) {
                            if(bean.getCodigo() == modulo.getGerente().getModuloAcionamento().getCodigo()) {
                                if(modulo.isConnected()) {
                                    valor = "Desconectar";
                                } else {
                                    valor = "Conectar";
                                }
                            }
                        }
                    } 
                    if(valor.equals("")) { 
                        valor = "Conectar";
                    }
                    return valor;
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
