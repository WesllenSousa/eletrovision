
package recursos.configuracoes.sistema;

/**
 *
 * @author Wesllen Sousa Lima
 */

public class ConfigMensagens {
    
    private static Boolean status; //verifica se o arquivo foi lido ao iniciar o sistema.
    
    private static Boolean ativarEnvioMensagens;
    private static Boolean ativarEnvioCelular;
    private static Boolean ativarEnvioEmail;
    private static Boolean ativarEnvioRede;
    private static String portaModem;
    private static String email;
    private static String nomeExibicao;
    private static String senha;
    private static String servidor;
    private static Integer porta;

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        ConfigMensagens.status = status;
    }
    
    public static Boolean getAtivarEnvioMensagens() {
        return ativarEnvioMensagens;
    }

    public static void setAtivarEnvioMensagens(Boolean ativarEnvioMensagens) {
        ConfigMensagens.ativarEnvioMensagens = ativarEnvioMensagens;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        ConfigMensagens.email = email;
    }

    public static String getNomeExibicao() {
        return nomeExibicao;
    }

    public static void setNomeExibicao(String nomeExibicao) {
        ConfigMensagens.nomeExibicao = nomeExibicao;
    }

    public static Integer getPorta() {
        return porta;
    }

    public static void setPorta(Integer porta) {
        ConfigMensagens.porta = porta;
    }

    public static String getPortaModem() {
        return portaModem;
    }

    public static void setPortaModem(String portaModem) {
        ConfigMensagens.portaModem = portaModem;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        ConfigMensagens.senha = senha;
    }

    public static String getServidor() {
        return servidor;
    }

    public static void setServidor(String servidor) {
        ConfigMensagens.servidor = servidor;
    }

    public static Boolean getAtivarEnvioCelular() {
        return ativarEnvioCelular;
    }

    public static void setAtivarEnvioCelular(Boolean ativarEnvioCelular) {
        ConfigMensagens.ativarEnvioCelular = ativarEnvioCelular;
    }

    public static Boolean getAtivarEnvioEmail() {
        return ativarEnvioEmail;
    }

    public static void setAtivarEnvioEmail(Boolean ativarEnvioEmail) {
        ConfigMensagens.ativarEnvioEmail = ativarEnvioEmail;
    }

    public static Boolean getAtivarEnvioRede() {
        return ativarEnvioRede;
    }

    public static void setAtivarEnvioRede(Boolean ativarEnvioRede) {
        ConfigMensagens.ativarEnvioRede = ativarEnvioRede;
    }
      
}
