
package telas.comuns.table;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ComboBoxTabela extends AbstractCellEditor implements TableCellEditor{

    private JComboBox field;  
    private String[] values = {"Valor1", "Valor2"};  
  
    @Override  
    public Component getTableCellEditorComponent(JTable table,  
            Object value, boolean isSelected, int row, int column) {  
        field = new JComboBox(values);
        field.setSelectedItem(value); //Deixa o editor pré-selecionado com o valor da célula  
        return field;  
    }  
  
    @Override  
    public Object getCellEditorValue() {  
        return field.getSelectedItem().toString();  
    }
    
}
