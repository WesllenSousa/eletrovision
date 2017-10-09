package telas.comuns.fileChooser;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ImagemFileView extends FileView {

    ImageIcon jpgIcon = Utils.createImageIcon(ArquivosImagens.JPG());
    ImageIcon gifIcon = Utils.createImageIcon(ArquivosImagens.GIF());
    ImageIcon tiffIcon = Utils.createImageIcon(ArquivosImagens.TIFF());
    ImageIcon pngIcon = Utils.createImageIcon(ArquivosImagens.PNG());

    @Override
    public String getName(File f) {
        return null;
    }

    @Override
    public String getDescription(File f) {
        return null;
    }

    @Override
    public Boolean isTraversable(File f) {
        return null;
    }

    @Override
    public String getTypeDescription(File f) {
        String extension = Utils.getExtension(f);
        String type = null;
        if (extension != null) {
            if (extension.equals(Utils.jpeg)
                    || extension.equals(Utils.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(Utils.gif)) {
                type = "GIF Image";
            } else if (extension.equals(Utils.tiff)
                    || extension.equals(Utils.tif)) {
                type = "TIFF Image";
            } else if (extension.equals(Utils.png)) {
                type = "PNG Image";
            }
        }
        return type;
    }

    @Override
    public Icon getIcon(File f) {
        String extension = Utils.getExtension(f);
        Icon icon = null;
        if (extension != null) {
            if (extension.equals(Utils.jpeg)
                    || extension.equals(Utils.jpg)) {
                icon = jpgIcon;
            } else if (extension.equals(Utils.gif)) {
                icon = gifIcon;
            } else if (extension.equals(Utils.tiff)
                    || extension.equals(Utils.tif)) {
                icon = tiffIcon;
            } else if (extension.equals(Utils.png)) {
                icon = pngIcon;
            }
        }
        return icon;
    }
    
}
