
package recursos.configuracoes.bloqueio;

import recursos.configuracoes.diretorios.ManipularArquivoProperties;
import recursos.configuracoes.diretorios.caminhos.ArquivosConfiguracao;
import recursos.internacionalizacao.MensagensSoltas;
import java.util.Properties;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen
 */
public class ArquivoBloqueio {
    
    public static boolean arquivoBloqueio() {
        Properties props = ManipularArquivoProperties.lerConfiguracao(ArquivosConfiguracao.bloqueio());
        if(props != null){
            String status = props.getProperty("status");
            if(status.equals("0")) {
                abrirSistema();
                return false;
            } else {
                if(InstanciasControle.getMensagens().confirmacao(MensagensSoltas.bloqueioArquivo())) {
                    abrirSistema();
                    return false;
                }
            }
        } else {
            abrirSistema();
        }
        return true;
    }
    
    public static void abrirSistema() {
        Properties props = new Properties();
        props.setProperty("status", "1");
        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.bloqueio(),
        "Configuração de bloqueio ao iniciar o sistema!");
    }
    
    public static void fecharSistema() {
        Properties props = new Properties();
        props.setProperty("status", "0");
        ManipularArquivoProperties.salvarConfiguracao(props, ArquivosConfiguracao.bloqueio(),
        "Configuração de bloqueio ao iniciar o sistema!");
    }
    
}
