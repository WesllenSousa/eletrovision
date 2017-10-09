
import com.jtattoo.plaf.mint.MintLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import telas.TelaPrincipal;


/**
 *
 * @author Wesllen Sousa Lima
 */
public class Main {
    
    public Main() {
        try {
            UIManager.setLookAndFeel(new MintLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex1) {
        }
        
        TelaPrincipal dialog = new TelaPrincipal();
        dialog.setVisible(true);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
