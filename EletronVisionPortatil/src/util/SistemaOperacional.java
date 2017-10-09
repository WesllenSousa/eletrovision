
package util;

import recursos.InstanciasPortatil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class SistemaOperacional {
    
    public static int identificaSistemaOperacional(){
        if(System.getProperty("os.name").indexOf("Linux") == 0){
            return 1;
        } else if(System.getProperty("os.name").indexOf("Windows") == 0){
            return 2;
        } else if(System.getProperty("os.name").indexOf("Mac") == 0){
            return 3;
        } else {
            InstanciasPortatil.getMensagens().bug("Erro ao identificar Sistema Operacional");
            return 0;
        }      
    }
    
}
