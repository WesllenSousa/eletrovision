
package recursos.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosConfiguracao {
    
    public static File hibernate(){
        File file = new File(pasta()+"hibernate.cfg.xml");
        return file;
    }
    
    public static File serialPortControl(){
        File file = new File(pasta()+"serialportcontrol.dll");
        return file;
    }
    
    public static File pixels(){
        File file = new File(pasta()+"pixels.config");
        return file;
    }
    
    public static File conexaoBanco(){
        File file = new File(pasta()+"conexaobanco.config");
        return file;
    }
    
    public static File mensagens(){
        File file = new File(pasta()+"mensagens.config");
        return file;
    }
    
    public static File dispositivos(){
        File file = new File(pasta()+"dispositivos.config");
        return file;
    }
    
    public static File gerais(){
        File file = new File(pasta()+"gerais.config");
        return file;
    }
    
    public static File bloqueio(){
        File file = new File(pasta()+"bloqueio.config");
        return file;
    }
    
    public static File localizacaoGps(){
        File file = new File(pasta()+"localizacaogps.config");
        return file;
    }
    
    public static String pasta() {
        //return Raiz.getRaiz()+File.separator+"config"+File.separator;
        return "config"+File.separator;
    }
    
}
