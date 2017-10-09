
package recursos.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosDiversos {
    
    public static String espiao(){
        return pasta()+"imagens"+File.separator+"imagens"+File.separator+"Expiao";
    }
    
    public static String redes() {
        return pasta()+"rede";
    }
    
    public static String pasta() {
        //eturn Raiz.getRaiz()+File.separator+"midia"+File.separator;
        return "midia"+File.separator;
    }
    
}
