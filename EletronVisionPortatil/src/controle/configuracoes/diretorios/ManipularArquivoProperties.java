
package controle.configuracoes.diretorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import recursos.InstanciasPortatil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ManipularArquivoProperties {

    public static void salvarConfiguracao(Properties props, File file, String comentario) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            props.store(out, comentario);
        } catch (IOException ex) {
            InstanciasPortatil.getMensagens().bug("Erro ao gravar arquivo" + ex);
        }
    }

    public static Properties lerConfiguracao(File file) {
        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream(file);
            props.load(in);
            in.close();
            return props;
        } catch (IOException ex) {
            InstanciasPortatil.getMensagens().bug("Erro ao ler arquivo" + ex);
            return null;
        }
    }
    
}
