
package controle.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosAudio {
    
    public static String visita(){
        return pasta()+"audio"+File.separator+"visita.mp3";
    }
    
    public static String telefone(){
        return pasta()+"audio"+File.separator+"telefone.mp3";
    }
    
    public static String pessoas_detectadas(){
        return pasta()+"audio"+File.separator+"pessoas_detectadas.mp3";
    }
    
    public static String movimento_detectado(){
        return pasta()+"audio"+File.separator+"movimento_detectado.mp3";
    }
    
    public static String face_reconhecida(){
        return pasta()+"audio"+File.separator+"face_reconhecida.mp3";
    }
    
    public static String dispositivo_acionado(){
        return pasta()+"audio"+File.separator+"dispositivo_acionado.mp3";
    }
    
    public static String cenario_acionado(){
        return pasta()+"audio"+File.separator+"cenario_acionado.mp3";
    }
    
    public static String ambiente_alterado(){
        return pasta()+"audio"+File.separator+"ambiente_alterado.mp3";
    }
    
    public static String agendamento_disparado(){
        return pasta()+"audio"+File.separator+"agendamento_disparado.mp3";
    }
    
    private static String pasta() {
        return "midia"+File.separator;
    }
    
}
