
package recursos;

import telas.ConfiguracaoCamera;
import telas.ConfiguracaoCenario;
import telas.dependencias.GuardaMensagem;
import controle.mensagens.Mensagens;
import controle.redes.Cliente;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;
import java.util.ArrayList;
import telas.TelaCameras;
import telas.TelaCenario;
import telas.TelaDispositivos;
import telas.TelaMensagens;
import telas.TelaPrincipal;
import telas.dependencias.*;

/**
 *
 * @author Wesllen
 */
public class InstanciasPortatil {
    
    private static Mensagens mensagens;
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
    
    private static String tituloTab;

    public static Mensagens getMensagens() {
        return mensagens;
    }

    public static void setMensagens(Mensagens mensagens) {
        InstanciasPortatil.mensagens = mensagens;
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

    public static String getTituloTab() {
        return tituloTab;
    }

    public static void setTituloTab(String tituloTab) {
        InstanciasPortatil.tituloTab = tituloTab;
    }

    public static ArrayList<GuardaCamera> getGuardaCameras() {
        return guardaCameras;
    }

    public static void setGuardaCameras(ArrayList<GuardaCamera> guardaCameras) {
        InstanciasPortatil.guardaCameras = guardaCameras;
    }

    public static ArrayList<GuardaCenario> getGuardaCenarios() {
        return guardaCenarios;
    }

    public static void setGuardaCenarios(ArrayList<GuardaCenario> guardaCenarios) {
        InstanciasPortatil.guardaCenarios = guardaCenarios;
    }

    public static TelaCameras getTelaCameras() {
        return telaCameras;
    }

    public static void setTelaCameras(TelaCameras telaCameras) {
        InstanciasPortatil.telaCameras = telaCameras;
    }

    public static TelaCenario getTelaCenario() {
        return telaCenario;
    }

    public static void setTelaCenario(TelaCenario telaCenario) {
        InstanciasPortatil.telaCenario = telaCenario;
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
