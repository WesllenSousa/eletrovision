
package EletroVisionPortatil.dependencias;

import EletroVisionPortatil.ConfiguracaoCenario;
import EletroVisionPortatil.ConfiguracaoCamera;
import EletroVisionPortatil.TelaCameras;
import EletroVisionPortatil.TelaCenario;
import EletroVisionPortatil.TelaDispositivos;
import EletroVisionPortatil.TelaMensagens;
import EletroVisionPortatil.TelaPrincipal;
import controle.mensagens.sistema.Mensagens;
import controle.redes.Cliente;
import controle.redes.Servidor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;

/**
 *
 * @author Wesllen
 */
public class InstanciasPortatil {
    
    private static Mensagens mensagens;
    private static Servidor servidor;
    private static Cliente cliente;
    
    private static TelaLogin telaLogin;
    private static TelaClientesConectados telaClientesConectados;
    private static TelaMensagens telaMensagens;
    private static TelaDispositivos telaDispositivos;
    private static TelaCenario telaCenario;
    private static TelaCameras telaCameras;
    private static ConfiguracaoCamera configuracaoCamera;
    private static ConfiguracaoCenario configuracaoCenario;
    private static TelaPrincipal telaPrincipal;
    
    private static ArrayList<ClientesConectado> clientesConectados;
    private static ArrayList<GuardaMensagem> guardaMensagens;
    private static ArrayList<GuardaDispositivo> guardaDispositivos;
    private static ArrayList<GuardaCenario> guardaCenarios;
    private static ArrayList<GuardaCamera> guardaCameras;

    public static Mensagens getMensagens() {
        return mensagens;
    }

    public static void setMensagens(Mensagens mensagens) {
        InstanciasPortatil.mensagens = mensagens;
    }

    public static Servidor getServidor() {
        return servidor;
    }

    public static void setServidor(Servidor servidor) {
        InstanciasPortatil.servidor = servidor;
    }

    public static TelaLogin getTelaLogin() {
        return telaLogin;
    }

    public static void setTelaLogin(TelaLogin telaLogin) {
        InstanciasPortatil.telaLogin = telaLogin;
    }

    public static ArrayList<ClientesConectado> getClientesConectados() {
        return clientesConectados;
    }

    public static void setClientesConectados(ArrayList<ClientesConectado> clientesConectados) {
        InstanciasPortatil.clientesConectados = clientesConectados;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        InstanciasPortatil.cliente = cliente;
    }

    public static TelaClientesConectados getTelaClientesConectados() {
        return telaClientesConectados;
    }

    public static void setTelaClientesConectados(TelaClientesConectados telaClientesConectados) {
        InstanciasPortatil.telaClientesConectados = telaClientesConectados;
    }
    
    public static TelaMensagens getTelaMensagens() {
        return telaMensagens;
    }

    public static void setTelaMensagens(TelaMensagens telaMensagens) {
        InstanciasPortatil.telaMensagens = telaMensagens;
    }

    public static ArrayList<GuardaMensagem> getGuardaMensagens() {
        return guardaMensagens;
    }

    public static void setGuardaMensagens(ArrayList<GuardaMensagem> guardaMensagens) {
        InstanciasPortatil.guardaMensagens = guardaMensagens;
    }

    public static ArrayList<GuardaDispositivo> getGuardaDispositivos() {
        return guardaDispositivos;
    }

    public static void setGuardaDispositivos(ArrayList<GuardaDispositivo> guardaDispositivos) {
        InstanciasPortatil.guardaDispositivos = guardaDispositivos;
    }

    public static TelaDispositivos getTelaDispositivos() {
        return telaDispositivos;
    }

    public static void setTelaDispositivos(TelaDispositivos telaDispositivos) {
        InstanciasPortatil.telaDispositivos = telaDispositivos;
    }

    public static ArrayList<GuardaCenario> getGuardaCenarios() {
        return guardaCenarios;
    }

    public static void setGuardaCenarios(ArrayList<GuardaCenario> guardaCenarios) {
        InstanciasPortatil.guardaCenarios = guardaCenarios;
    }

    public static TelaCenario getTelaCenario() {
        return telaCenario;
    }

    public static void setTelaCenario(TelaCenario telaCenario) {
        InstanciasPortatil.telaCenario = telaCenario;
    }

    public static ArrayList<GuardaCamera> getGuardaCameras() {
        return guardaCameras;
    }

    public static void setGuardaCameras(ArrayList<GuardaCamera> guardaCameras) {
        InstanciasPortatil.guardaCameras = guardaCameras;
    }

    public static TelaCameras getTelaCameras() {
        return telaCameras;
    }

    public static void setTelaCameras(TelaCameras telaCameras) {
        InstanciasPortatil.telaCameras = telaCameras;
    }

    public static ConfiguracaoCamera getConfiguracaoCamera() {
        return configuracaoCamera;
    }

    public static void setConfiguracaoCamera(ConfiguracaoCamera configuracaoCamera) {
        InstanciasPortatil.configuracaoCamera = configuracaoCamera;
    }

    public static ConfiguracaoCenario getConfiguracaoCenario() {
        return configuracaoCenario;
    }

    public static void setConfiguracaoCenario(ConfiguracaoCenario configuracaoCenario) {
        InstanciasPortatil.configuracaoCenario = configuracaoCenario;
    }

    public static TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }

    public static void setTelaPrincipal(TelaPrincipal telaPrincipal) {
        InstanciasPortatil.telaPrincipal = telaPrincipal;
    }

}
