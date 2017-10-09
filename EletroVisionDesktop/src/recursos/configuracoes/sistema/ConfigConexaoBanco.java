
package recursos.configuracoes.sistema;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigConexaoBanco {
    
    private static Boolean status; //verifica a leitura dos arquivos;
    
    private static String banco;
    private static String driver;
    private static String host;
    private static String porta;
    private static String nomeBanco;
    private static String usuario;

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        ConfigConexaoBanco.status = status;
    }    

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        ConfigConexaoBanco.host = host;
    }

    public static String getPorta() {
        return porta;
    }

    public static void setPorta(String porta) {
        ConfigConexaoBanco.porta = porta;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConfigConexaoBanco.usuario = usuario;
    }

    public static String getNomeBanco() {
        return nomeBanco;
    }

    public static void setNomeBanco(String banco) {
        ConfigConexaoBanco.nomeBanco = banco;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        ConfigConexaoBanco.driver = driver;
    }

    public static String getBanco() {
        return banco;
    }

    public static void setBanco(String banco) {
        ConfigConexaoBanco.banco = banco;
    }  
    
}
