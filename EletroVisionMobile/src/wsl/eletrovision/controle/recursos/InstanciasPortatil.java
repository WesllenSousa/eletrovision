
package wsl.eletrovision.controle.recursos;

import java.util.ArrayList;

import wsl.eletrovision.controle.redes.Cliente;
import wsl.eletrovision.controle.serializado.ClientesConectado;
import wsl.eletrovision.controle.serializado.GuardaCamera;
import wsl.eletrovision.controle.serializado.GuardaCenario;
import wsl.eletrovision.controle.serializado.GuardaDispositivo;
import wsl.eletrovision.controle.serializado.GuardaMensagem;
import wsl.eletrovision.telas.TelaCamera;
import wsl.eletrovision.telas.TelaMapa;
import wsl.eletrovision.telas.TelaPrincipal;

/**
 *
 * @author Wesllen
 */
public class InstanciasPortatil {
    
    private static Cliente cliente;
    private static ArrayList<ClientesConectado> clientesConectados;
    private static ArrayList<GuardaMensagem> guardaMensagens;
    private static ArrayList<GuardaDispositivo> guardaDispositivos;
    private static ArrayList<GuardaCenario> guardaCenarios;
    private static ArrayList<GuardaCamera> guardaCameras;
    
    private static TelaPrincipal telaPrincipal;
    private static TelaMapa telaMapa;
    private static TelaCamera telaCamera;

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

	public static TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

	public static void setTelaPrincipal(TelaPrincipal telaPrincipal) {
		InstanciasPortatil.telaPrincipal = telaPrincipal;
	}

	public static TelaMapa getTelaMapa() {
		return telaMapa;
	}

	public static void setTelaMapa(TelaMapa telaMapa) {
		InstanciasPortatil.telaMapa = telaMapa;
	}

	public static TelaCamera getTelaCamera() {
		return telaCamera;
	}

	public static void setTelaCamera(TelaCamera telaCamera) {
		InstanciasPortatil.telaCamera = telaCamera;
	}
        
}
