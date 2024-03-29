package telas.comuns.comboBox;

import java.awt.Component;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ImagemComboBox extends DefaultListCellRenderer {

    private Map<Object, Icon> icons = null;

    public ImagemComboBox(Map<Object, Icon> icons) {
        this.icons = icons;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //Aqui você chama o método da superclasse para pegar o JLabel que representa cada célula no JComboBox
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Icon icon = icons.get(value);
        label.setIcon(icon);
        return label;
    }
    
}
