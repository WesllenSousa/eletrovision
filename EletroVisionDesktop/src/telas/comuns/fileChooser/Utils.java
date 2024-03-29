package telas.comuns.fileChooser;
import java.io.File;
import javax.swing.ImageIcon;

/* Utils.java is a 1.4 example used by FileChooserDemo2.java. */
/**
 *
 * @author Wesllen Sousa Lima
 */
public class Utils {
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";
    public final static String bmp = "bmp";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    /** Retorna um ImageIcon, ou nulo para arquivo inválido. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Utils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Não foi possível encontrar: " + path);
            return null;
        }
    }
}
