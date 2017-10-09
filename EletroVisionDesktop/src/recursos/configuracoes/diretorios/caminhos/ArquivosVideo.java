
package recursos.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosVideo {
    
    public static String todosVideos(){
        return "midia";
    }
    
    public static String todosVideosInternos(){
        return "midia"+File.separator+"videos";
    }
    
}
