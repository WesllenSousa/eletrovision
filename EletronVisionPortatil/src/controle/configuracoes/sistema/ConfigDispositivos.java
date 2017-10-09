
package controle.configuracoes.sistema;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigDispositivos {
    
    private static Boolean status; //verifica a leitura dos arquivos;
    
    private static String alarme;
    private Boolean cameraIniciaSistema;
    private static Boolean detectarFace;
    private static Boolean detectarOlhos;
    private static Boolean detectarCorpo;
    private static Boolean detectarObjeto;
    private static Integer largura;
    private static Integer altura;
    private static Boolean gravarVideo;  
    private static Boolean ativarAcionamento;
    private static Integer intervaloProcessamento;
    private static Boolean ativarDispositivosCamera;

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        ConfigDispositivos.status = status;
    }

    public Boolean getCameraIniciaSistema() {
        return cameraIniciaSistema;
    }

    public void setCameraIniciaSistema(Boolean cameraIniciaSistema) {
        this.cameraIniciaSistema = cameraIniciaSistema;
    }

    public static Boolean getDetectarCorpo() {
        return detectarCorpo;
    }

    public static void setDetectarCorpo(Boolean detectarCorpo) {
        ConfigDispositivos.detectarCorpo = detectarCorpo;
    }

    public static Boolean getDetectarFace() {
        return detectarFace;
    }

    public static void setDetectarFace(Boolean detectarFace) {
        ConfigDispositivos.detectarFace = detectarFace;
    }

    public static Boolean getDetectarOlhos() {
        return detectarOlhos;
    }

    public static void setDetectarOlhos(Boolean detectarOlhos) {
        ConfigDispositivos.detectarOlhos = detectarOlhos;
    }

    public static String getAlarme() {
        return alarme;
    }

    public static void setAlarme(String alarme) {
        ConfigDispositivos.alarme = alarme;
    }

    public static Integer getAltura() {
        return altura;
    }

    public static void setAltura(Integer altura) {
        ConfigDispositivos.altura = altura;
    }

    public static Integer getLargura() {
        return largura;
    }

    public static void setLargura(Integer largura) {
        ConfigDispositivos.largura = largura;
    }

    public static Boolean getAtivarAcionamento() {
        return ativarAcionamento;
    }

    public static void setAtivarAcionamento(Boolean ativarAcionamento) {
        ConfigDispositivos.ativarAcionamento = ativarAcionamento;
    }

    public static Boolean getGravarVideo() {
        return gravarVideo;
    }

    public static void setGravarVideo(Boolean gravarVideo) {
        ConfigDispositivos.gravarVideo = gravarVideo;
    }

    public static Boolean getDetectarObjeto() {
        return detectarObjeto;
    }

    public static void setDetectarObjeto(Boolean detectarObjeto) {
        ConfigDispositivos.detectarObjeto = detectarObjeto;
    }

    public static Integer getIntervaloProcessamento() {
        return intervaloProcessamento;
    }

    public static void setIntervaloProcessamento(Integer intervaloProcessamento) {
        ConfigDispositivos.intervaloProcessamento = intervaloProcessamento;
    }

    public static Boolean getAtivarDispositivosCamera() {
        return ativarDispositivosCamera;
    }

    public static void setAtivarDispositivosCamera(Boolean ativarDispositivosCamera) {
        ConfigDispositivos.ativarDispositivosCamera = ativarDispositivosCamera;
    }
  
}
