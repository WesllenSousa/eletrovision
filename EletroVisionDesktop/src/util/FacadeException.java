package util;

import java.io.PrintWriter;
import java.io.StringWriter;
import telas.comuns.telas.Erro;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class FacadeException extends Exception {

    public FacadeException() {
        super();
        Erro dialog = new Erro(null, true, "FacadeException", obterErroCompleto(FacadeException.this));
        dialog.setVisible(true); 
    }

    public FacadeException(String arg0) {
        super(arg0);
    }

    public FacadeException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public FacadeException(Throwable arg0) {
        super(arg0);
    }
    
    private static String obterErroCompleto(Exception ex) {
        String erro = ex.getMessage()+"\n";
        StringWriter sw = new StringWriter();
        new Throwable("").printStackTrace(new PrintWriter(sw));
        erro += sw.toString();
        return erro;
    }

}
