
package controle.configuracoes.sistema;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigGerais {
    
    private static Boolean status; //verifica a leitura dos arquivos;
    
    private static Boolean ativarSomCamera;
    private static Boolean ativarSomSistema;
    private static Integer expiaoAgendarTarefas;
    private static Integer tempoExpiao;
    private static Boolean ativarAgendarTarefas;
    private Boolean expiaoIniciaSistema; //0-iniciar 1-nao iniciar
    private Boolean servidorIniciarSistema; //0-iniciar 1-nao iniciar
    private static String diretorioAtual = ".";

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        ConfigGerais.status = status;
    }

    public static Integer getExpiaoAgendarTarefas() {
        return expiaoAgendarTarefas;
    }

    public static void setExpiaoAgendarTarefas(Integer expiaoAgendarTarefas) {
        ConfigGerais.expiaoAgendarTarefas = expiaoAgendarTarefas;
    }

    public Boolean getExpiaoIniciaSistema() {
        return expiaoIniciaSistema;
    }

    public void setExpiaoIniciaSistema(Boolean expiaoIniciaSistema) {
        this.expiaoIniciaSistema = expiaoIniciaSistema;
    }

    public static Boolean getAtivarSomCamera() {
        return ativarSomCamera;
    }

    public static void setAtivarSomCamera(Boolean ativarSomCamera) {
        ConfigGerais.ativarSomCamera = ativarSomCamera;
    }

    public static Boolean getAtivarSomSistema() {
        return ativarSomSistema;
    }

    public static void setAtivarSomSistema(Boolean ativarSomSistema) {
        ConfigGerais.ativarSomSistema = ativarSomSistema;
    }

    public Boolean getServidorIniciarSistema() {
        return servidorIniciarSistema;
    }

    public void setServidorIniciarSistema(Boolean servidorIniciarSistema) {
        this.servidorIniciarSistema = servidorIniciarSistema;
    }

    public static Boolean getAtivarAgendarTarefas() {
        return ativarAgendarTarefas;
    }

    public static void setAtivarAgendarTarefas(Boolean ativarAgendarTarefas) {
        ConfigGerais.ativarAgendarTarefas = ativarAgendarTarefas;
    }

    public static Integer getTempoExpiao() {
        return tempoExpiao;
    }

    public static void setTempoExpiao(Integer tempoExpiao) {
        ConfigGerais.tempoExpiao = tempoExpiao;
    }

    public static String getDiretorioAtual() {
        return diretorioAtual;
    }

    public static void setDiretorioAtual(String diretorioAtual) {
        ConfigGerais.diretorioAtual = diretorioAtual;
    }
    
}
