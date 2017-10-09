

package util;

import java.io.PrintWriter;
import java.io.StringWriter;
import telas.comuns.telas.BancoDados;
import telas.comuns.telas.Erro;

/**
 *
 * @author Wesllen Sousa Lima
 */

public class DaoException extends Exception {

    public DaoException(String arg0) {
        super(arg0);
        Erro dialog = new Erro(null, true, "DaoException", obterErroCompleto(DaoException.this));
        dialog.setVisible(true); 
        BancoDados dialog2 = new BancoDados(null, true);
        dialog2.setVisible(true); 
    }

    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DaoException(Throwable arg0) {
        super(arg0);
    }
    
    private static String obterErroCompleto(Exception ex) {
        String erro = ex.toString()+"\n";
        StringWriter sw = new StringWriter();
        new Throwable("").printStackTrace(new PrintWriter(sw));
        erro += sw.toString();
        return erro;
    }

}
