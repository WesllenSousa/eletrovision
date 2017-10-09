
package recursos.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosScripts {
    
    public static String backupLinux(){
        return "scripts"+File.separator+"backup.sh";
    }
    
    public static String backupWindows(){
        return "scripts"+File.separator+"backup.bat";
    }
    
    public static String cascadeFace(){
        return "scripts"+File.separator+"haarcascade_frontalface_alt2.xml";
    }
    
    public static String cascadeCorpo(){
        return "scripts"+File.separator+"haarcascade_fullbody.xml";
    }
    
    public static String cascadeAutoCorpo(){
        return "scripts"+File.separator+"haarcascade_upperbody.xml";
    }
    
    public static String cascadeBaixoCorpo(){
        return "scripts"+File.separator+"haarcascade_lowerbody.xml";
    }
    
    public static String cascadeFaceOculos(){
        return "scripts"+File.separator+"haarcascade_eye_tree_eyeglasses.xml";
    }
    
}
