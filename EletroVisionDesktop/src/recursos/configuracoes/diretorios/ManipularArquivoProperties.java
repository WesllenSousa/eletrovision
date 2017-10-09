
package recursos.configuracoes.diretorios;

import recursos.internacionalizacao.MensagensErro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ManipularArquivoProperties {

    public static void salvarConfiguracao(Properties props, File file, String comentario) {
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            props.store(out, comentario);
        } catch (IOException ex) {
            MensagensErro.arquivosPropertiesSalvar(ex);
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
            MensagensErro.arquivosPropertiesLer(ex);
            return null;
        }
    }
    
}
