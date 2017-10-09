package telas.comuns.fileChooser;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import recursos.internacionalizacao.MensagensSoltas;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ImagemFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.tiff)
                    || extension.equals(Utils.tif)
                    || extension.equals(Utils.gif)
                    || extension.equals(Utils.jpeg)
                    || extension.equals(Utils.jpg)
                    || extension.equals(Utils.bmp)
                    || extension.equals(Utils.png)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public String getDescription() {
        return MensagensSoltas.comumFilterImagens();
    }
    
}
