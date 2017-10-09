
package util;

import recursos.internacionalizacao.MensagensSoltas;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class SistemaOperacional {
    
    public static final int LINUX = 1;
    public static final int WINDOWS = 2;
    public static final int MAC = 3;
    
    public static int identificaSistemaOperacional(){
        if(System.getProperty("os.name").indexOf("Linux") == 0){
            return 1;
        } else if(System.getProperty("os.name").indexOf("Windows") == 0){
            return 2;
        } else if(System.getProperty("os.name").indexOf("Mac") == 0){
            return 3;
        } else {
            InstanciasControle.getMensagens().bug(MensagensSoltas.sistemaOperacionalIdentificar());
            return 0;
        }      
    }
    
}
