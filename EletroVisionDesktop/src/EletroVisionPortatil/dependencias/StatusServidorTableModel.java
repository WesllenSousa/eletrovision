
package EletroVisionPortatil.dependencias;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import wsl.eletrovision.controle.serializado.ClientesConectado;
/**
 *
 * @author pierre
 */
public class StatusServidorTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"Contato", "Host", "Ip", "Porta", "Localização"};

    public StatusServidorTableModel(ArrayList<ClientesConectado> dados) {
        setLinhas(dados);
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 4) {
            return true;
        }
        return false;
    }

    public String[] getColunas() {
        return colunas;
    }

    public ArrayList<ClientesConectado> getLinhas() {
        return linhas;
    }
    
    public void limpaDados() {
        linhas.clear();
    }

    public void setColunas(String[] strings) {
        colunas = strings;
    }

    private void setLinhas(ArrayList<ClientesConectado> list) {
        linhas = list;
    }
    
    public void addLinha(ClientesConectado dado) {
        linhas.add(dado);
    }

    public void removeLinha(ClientesConectado dado) {
        linhas.remove(dado);
    }

    public void atualizaLinha(int index, ClientesConectado dado) {
        linhas.set(index, dado);
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
        ClientesConectado bean = (ClientesConectado) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getContato();
                case 1:
                    return bean.getHost();
                case 2:
                    return bean.getIp();
                case 3:
                    return bean.getPorta();
                case 4:
                    return "Localização";
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
    
}
