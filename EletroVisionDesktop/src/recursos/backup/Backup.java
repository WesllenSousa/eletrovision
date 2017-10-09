
package recursos.backup;

import recursos.configuracoes.diretorios.caminhos.ArquivosScripts;
import recursos.internacionalizacao.MensagensErro;
import recursos.internacionalizacao.MensagensSoltas;
import java.io.IOException;
import recursos.instancias.InstanciasControle;
import util.SistemaOperacional;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Backup {
    
    public static void executaBackUp(){
        if(SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.LINUX){
            Backup.copiaSegurancaLinux();
        } else if(SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.WINDOWS) {
            Backup.copiaSegurancaWindows();
        } else if(SistemaOperacional.identificaSistemaOperacional() == SistemaOperacional.MAC) {
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.backup());
        }
    }

    public static void copiaSegurancaWindows(){
        try {
            Runtime.getRuntime().exec(ArquivosScripts.backupWindows());
            Runtime.getRuntime().runFinalization();
        } catch (IOException ex) {
            MensagensErro.backupPGdump(ex); 
        }
    }
    
    public static void copiaSegurancaLinux(){
        try {
            Runtime.getRuntime().exec(ArquivosScripts.backupLinux());
            Runtime.getRuntime().runFinalization();
        } catch (IOException ex) {
            MensagensErro.backupPGdump(ex); 
        }
    }
    
}
 