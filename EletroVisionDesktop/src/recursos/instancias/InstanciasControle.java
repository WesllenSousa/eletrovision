package recursos.instancias;

import controle.mensagens.sistema.Mensagens;
import controle.openCV_javaCV_Pro.camera.IniciarCameras;
import controle.openCV_javaCV_Pro.processamento.dependencias.SalvarImgDetectada;
import controle.audio.GerenciarAudio;
import controle.dispositivos.GerenciarAcionamento;
import controle.mapa.GuardaLocalizacaoGPS;
import controle.quartz.ShedulerAgendarTarefas;
import entidades.acesso.bean.AcessoBean;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class InstanciasControle {

    private static String tituloTab;
    private static IniciarCameras iniciarCameras;
    private static GerenciarAudio gerenciarAudio;
    private static Mensagens mensagens;
    private static SalvarImgDetectada salvarImgDetectada;
    private static UsuarioBean usuarioLogado;
    private static AcessoBean acesso;
    private static ArrayList<GerenciarAcionamento> gerenciarAcionamentos;
    private static ShedulerAgendarTarefas shedulerAgendarTarefas;
    private static ArrayList<GuardaLocalizacaoGPS> guardaLocalizacaoGPSs;

    public static GerenciarAudio getGerenciarAudio() {
        return gerenciarAudio;
    }

    public static void setGerenciarAudio(GerenciarAudio gerenciarAudio) {
        InstanciasControle.gerenciarAudio = gerenciarAudio;
    }

    public static IniciarCameras getIniciarCameras() {
        return iniciarCameras;
    }

    public static void setIniciarCameras(IniciarCameras iniciarCameras) {
        InstanciasControle.iniciarCameras = iniciarCameras;
    }

    public static String getTituloTab() {
        return tituloTab;
    }

    public static void setTituloTab(String tituloTab) {
        InstanciasControle.tituloTab = tituloTab;
    }

    public static Mensagens getMensagens() {
        return mensagens;
    }

    public static void setMensagens(Mensagens mensagens) {
        InstanciasControle.mensagens = mensagens;
    }

    public static SalvarImgDetectada getSalvarImgDetectada() {
        return salvarImgDetectada;
    }

    public static void setSalvarImgDetectada(SalvarImgDetectada salvarImgDetectada) {
        InstanciasControle.salvarImgDetectada = salvarImgDetectada;
    }

    public static AcessoBean getAcesso() {
        return acesso;
    }

    public static void setAcesso(AcessoBean acesso) {
        InstanciasControle.acesso = acesso;
    }

    public static UsuarioBean getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(UsuarioBean usuarioLogado) {
        InstanciasControle.usuarioLogado = usuarioLogado;
    }

    public static ArrayList<GerenciarAcionamento> getGerenciarAcionamentos() {
        return gerenciarAcionamentos;
    }

    public static void setGerenciarAcionamentos(ArrayList<GerenciarAcionamento> gerenciarAcionamentos) {
        InstanciasControle.gerenciarAcionamentos = gerenciarAcionamentos;
    }

    public static ShedulerAgendarTarefas getShedulerAgendarTarefas() {
        return shedulerAgendarTarefas;
    }

    public static void setShedulerAgendarTarefas(ShedulerAgendarTarefas shedulerAgendarTarefas) {
        InstanciasControle.shedulerAgendarTarefas = shedulerAgendarTarefas;
    }

    public static ArrayList<GuardaLocalizacaoGPS> getGuardaLocalizacaoGPSs() {
        return guardaLocalizacaoGPSs;
    }

    public static void setGuardaLocalizacaoGPSs(ArrayList<GuardaLocalizacaoGPS> guardaLocalizacaoGPSs) {
        InstanciasControle.guardaLocalizacaoGPSs = guardaLocalizacaoGPSs;
    }

}
