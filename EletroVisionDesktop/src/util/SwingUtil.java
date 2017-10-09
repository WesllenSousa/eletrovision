package util;

import java.awt.Component;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import telas.comuns.tabbedPane.BotaoTabbedPane;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class SwingUtil {

    public static void limparCamposJTextField(JPanel jPanel) {
        Component[] components = jPanel.getComponents();
        JTextField jTextField = null;
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                jTextField = (JTextField) components[i];
                jTextField.setText("");
            }
        }
    }

    public static void limparCamposJTextArea(JPanel jPanel) {
        Component[] components = jPanel.getComponents();
        JTextArea jTextArea = null;
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextArea) {
                jTextArea = (JTextArea) components[i];
                jTextArea.setText("");
            }
        }
    }

    public static void desabilitarCamposJTextField(JPanel jPanel) {
        Component[] components = jPanel.getComponents();
        JTextField jTextField = null;
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                jTextField = (JTextField) components[i];
                jTextField.setEditable(false);
            }
        }
    }

    public static void abilitarCamposJTextField(JPanel jPanel) {
        Component[] components = jPanel.getComponents();
        JTextField jTextField = null;
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                jTextField = (JTextField) components[i];
                jTextField.setEditable(true);
            }
        }
    }

    public static void selecionaCampoJTextField(Component component) {
        JTextField jTextField = null;
        if (component instanceof JTextField) {
            jTextField = (JTextField) component;
            jTextField.setSelectionStart(0);
            jTextField.setSelectionEnd(jTextField.getText().length());
        }
    }

    public static void setarFocusCampoJTextField(final JTextField jTF) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTF.requestFocusInWindow();
            }
        });
    }

    public static void setaFocusCampoJTextArea(final JTextArea jTF) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTF.requestFocusInWindow();
            }
        });
    }

    public static Comparator getComparadorInteger() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer valor1 = null;
                Integer valor2 = null;
                try {
                    valor1 = (Integer) o1;
                    valor2 = (Integer) o2;
                } catch (Exception e) {
                    System.out.println(e);
                }
                return valor1.compareTo(valor2);
            }
        };
        return comparator;
    }

    public static Comparator getComparadorFloat() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Float valor1 = null;
                Float valor2 = null;
                try {
                    valor1 = Float.parseFloat(o1.toString());
                    valor2 = Float.parseFloat(o2.toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
                return valor1.compareTo(valor2);
            }
        };
        return comparator;
    }

    public static Comparator getComparadorDouble() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Double valor1 = null;
                Double valor2 = null;
                try {
                    valor1 = (Double) o1;
                    valor2 = (Double) o2;
                } catch (Exception e) {
                    System.out.println(e);
                }
                return valor1.compareTo(valor2);
            }
        };
        return comparator;
    }

    public static Comparator getComparadorDate() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Date valor1 = null;
                Date valor2 = null;
                try {
                    valor1 = DataUtil.formataData(o1.toString());
                    valor2 = DataUtil.formataData(o2.toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
                return valor1.compareTo(valor2);
            }
        };
        return comparator;
    }

    public static Comparator getComparadorDateHora() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Date valor1 = null;
                Date valor2 = null;
                try {
                    valor1 = DataUtil.formataDataHora(o1.toString());
                    valor2 = DataUtil.formataDataHora(o2.toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
                return valor1.compareTo(valor2);
            }
        };
        return comparator;
    }

    public static JPanel adicionarTabComBotaoFechar(JTabbedPane tabbedPane, String titulo, JPanel painel) {
        JPanel panel = painel;
        tabbedPane.addTab(titulo, panel);
        tabbedPane.setSelectedComponent(panel);
        Integer i = tabbedPane.getSelectedIndex();
        tabbedPane.setTabComponentAt(i, new BotaoTabbedPane(tabbedPane));
        return panel;
    }

    public static void fechaTabbedPanePeloTitulo(JTabbedPane tabbedPane, String titulo) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            String t = tabbedPane.getTitleAt(i);
            if (titulo.equals(t)) {
                tabbedPane.remove(i);
            }
        }
    }

    public static void desabilitarSelecaoToggleButton(JPanel panel) {
        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JToggleButton) {
                JToggleButton toggleButton = (JToggleButton) components[i];
                toggleButton.setSelected(false);
            }
        }
    }

    public static void selecionaItemCombo(Object bean, JComboBox combo) {
        Object c;
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (i > 0) {
                c = (Object) combo.getItemAt(i);
                if (c.toString().equals(bean.toString())) {
                    combo.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

}
