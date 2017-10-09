package controle.audio;

import controle.configuracoes.diretorios.caminhos.ArquivosAudio;
import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ExecutarAudio {

    public static void pessoasDetectadas() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.pessoas_detectadas())); 
    }

    public static void cenarioAcionado() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.cenario_acionado()));
    }

    public static void dispositivoAcionado() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.dispositivo_acionado()));
    }

    public static void agendamentoDisparado() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.agendamento_disparado()));
    }

    public static void faceReconhecida() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.face_reconhecida()));
    }

    public static void visita() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.visita()));
    }

    public static void movimento() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.movimento_detectado()));
    }

    public static void ambiente() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.ambiente_alterado()));
    }
    
    public static void telefone() {
        Audio audio = new Audio(Boolean.TRUE);
        audio.executar(new File(ArquivosAudio.telefone()));
    }
    
}
