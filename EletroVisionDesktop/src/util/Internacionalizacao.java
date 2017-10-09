
package util;

import java.util.Locale;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Internacionalizacao {
    
    public static Boolean portugues() {
        Locale locale = Locale.getDefault();
        if(locale.getLanguage().equals("pt")) { 
            return true;
        } else {
            return false;
        }
    }
    
    public static Boolean ingles() {
        Locale locale = Locale.getDefault();
        if(locale.getLanguage().equals("en")) { 
            return true;
        } else {
            return false;
        }
    }
    
}
