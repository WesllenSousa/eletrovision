
package recursos.instancias;

import telas.cadastros.CadastrarArea;
import telas.cadastros.CadastrarCamera;
import telas.cadastros.CadastrarDispositivoEletrico;
import telas.cadastros.CadastrarModuloAcionamento;
import telas.ferramentas.FerramentasEditarImagens;
import telas.geral.GeralAgendarTarefas;
import telas.geral.GeralCenario;
import telas.geral.GeralLocalizacaoGps;
import telas.geral.GeralMapaDispositivos;
import telas.geral.GeralVisualizarCameras;
import telas.pesquisas.PesquisarArea;
import telas.pesquisas.PesquisarCamera;
import telas.pesquisas.PesquisarDispositivoEletrico;
import telas.pesquisas.PesquisarMarca;
import telas.pesquisas.PesquisarModuloAcionamento;
import telas.pesquisas.PesquisarPessoa;
import telas.pesquisas.PesquisarPredio;
import telas.pesquisas.PesquisarUsuario;
import telas.principal.Principal;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class InstanciasTelas {
    
    private static Principal principal;
    
    private static GeralLocalizacaoGps geralLocalizacaoGps;
    private static GeralCenario geralCenario;
    private static GeralMapaDispositivos geralMapaDispositivos;
    private static GeralVisualizarCameras geralVisualizarCameras;
    private static GeralAgendarTarefas geralAgendarTarefas;
    
    private static FerramentasEditarImagens ferramentasEditarImagens;
    
    private static CadastrarArea cadastrarArea;
    private static CadastrarCamera cadastrarCamera;
    private static CadastrarModuloAcionamento cadastrarModuloAcionamento;
    private static CadastrarDispositivoEletrico cadastrarDispositivoEletrico;
    
    private static PesquisarArea pesquisarArea;
    private static PesquisarCamera pesquisarCamera;
    private static PesquisarDispositivoEletrico pesquisarDispositivoEletrico;
    private static PesquisarMarca pesquisarMarca;
    private static PesquisarModuloAcionamento pesquisarModuloAcionamento;
    private static PesquisarPessoa pesquisarPessoa;
    private static PesquisarUsuario pesquisarUsuario;
    private static PesquisarPredio pesquisarPredio;

    public static GeralLocalizacaoGps getGeralLocalizacaoGps() {
        return geralLocalizacaoGps;
    }

    public static void setGeralLocalizacaoGps(GeralLocalizacaoGps geralLocalizacaoGps) {
        InstanciasTelas.geralLocalizacaoGps = geralLocalizacaoGps;
    }

    public static Principal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(Principal principal) {
        InstanciasTelas.principal = principal;
    }

    public static GeralCenario getGeralCenario() {
        return geralCenario;
    }

    public static void setGeralCenario(GeralCenario geralCenario) {
        InstanciasTelas.geralCenario = geralCenario;
    }

    public static GeralMapaDispositivos getGeralMapaDispositivos() {
        return geralMapaDispositivos;
    }

    public static void setGeralMapaDispositivos(GeralMapaDispositivos geralMapaDispositivos) {
        InstanciasTelas.geralMapaDispositivos = geralMapaDispositivos;
    }

    public static CadastrarArea getCadastrarArea() {
        return cadastrarArea;
    }

    public static void setCadastrarArea(CadastrarArea cadastrarArea) {
        InstanciasTelas.cadastrarArea = cadastrarArea;
    }

    public static CadastrarCamera getCadastrarCamera() {
        return cadastrarCamera;
    }

    public static void setCadastrarCamera(CadastrarCamera cadastrarCamera) {
        InstanciasTelas.cadastrarCamera = cadastrarCamera;
    }

    public static CadastrarModuloAcionamento getCadastrarModuloAcionamento() {
        return cadastrarModuloAcionamento;
    }

    public static void setCadastrarModuloAcionamento(CadastrarModuloAcionamento cadastrarModuloAcionamento) {
        InstanciasTelas.cadastrarModuloAcionamento = cadastrarModuloAcionamento;
    }

    public static CadastrarDispositivoEletrico getCadastrarDispositivoEletrico() {
        return cadastrarDispositivoEletrico;
    }

    public static void setCadastrarDispositivoEletrico(CadastrarDispositivoEletrico cadastrarDispositivoEletrico) {
        InstanciasTelas.cadastrarDispositivoEletrico = cadastrarDispositivoEletrico;
    }

    public static PesquisarArea getPesquisarArea() {
        return pesquisarArea;
    }

    public static void setPesquisarArea(PesquisarArea pesquisarArea) {
        InstanciasTelas.pesquisarArea = pesquisarArea;
    }

    public static PesquisarCamera getPesquisarCamera() {
        return pesquisarCamera;
    }

    public static void setPesquisarCamera(PesquisarCamera pesquisarCamera) {
        InstanciasTelas.pesquisarCamera = pesquisarCamera;
    }

    public static PesquisarDispositivoEletrico getPesquisarDispositivoEletrico() {
        return pesquisarDispositivoEletrico;
    }

    public static void setPesquisarDispositivoEletrico(PesquisarDispositivoEletrico pesquisarDispositivoEletrico) {
        InstanciasTelas.pesquisarDispositivoEletrico = pesquisarDispositivoEletrico;
    }

    public static PesquisarMarca getPesquisarMarca() {
        return pesquisarMarca;
    }

    public static void setPesquisarMarca(PesquisarMarca pesquisarMarca) {
        InstanciasTelas.pesquisarMarca = pesquisarMarca;
    }

    public static PesquisarModuloAcionamento getPesquisarModuloAcionamento() {
        return pesquisarModuloAcionamento;
    }

    public static void setPesquisarModuloAcionamento(PesquisarModuloAcionamento pesquisarModuloAcionamento) {
        InstanciasTelas.pesquisarModuloAcionamento = pesquisarModuloAcionamento;
    }

    public static PesquisarPessoa getPesquisarPessoa() {
        return pesquisarPessoa;
    }

    public static void setPesquisarPessoa(PesquisarPessoa pesquisarPessoa) {
        InstanciasTelas.pesquisarPessoa = pesquisarPessoa;
    }

    public static PesquisarUsuario getPesquisarUsuario() {
        return pesquisarUsuario;
    }

    public static void setPesquisarUsuario(PesquisarUsuario pesquisarUsuario) {
        InstanciasTelas.pesquisarUsuario = pesquisarUsuario;
    } 

    public static PesquisarPredio getPesquisarPredio() {
        return pesquisarPredio;
    }

    public static void setPesquisarPredio(PesquisarPredio pesquisarPredio) {
        InstanciasTelas.pesquisarPredio = pesquisarPredio;
    }

    public static GeralVisualizarCameras getGeralVisualizarCameras() {
        return geralVisualizarCameras;
    }

    public static void setGeralVisualizarCameras(GeralVisualizarCameras geralVisualizarCameras) {
        InstanciasTelas.geralVisualizarCameras = geralVisualizarCameras;
    }

    public static FerramentasEditarImagens getFerramentasEditarImagens() {
        return ferramentasEditarImagens;
    }

    public static void setFerramentasEditarImagens(FerramentasEditarImagens ferramentasEditarImagens) {
        InstanciasTelas.ferramentasEditarImagens = ferramentasEditarImagens;
    }

    public static GeralAgendarTarefas getGeralAgendarTarefas() {
        return geralAgendarTarefas;
    }

    public static void setGeralAgendarTarefas(GeralAgendarTarefas geralAgendarTarefas) {
        InstanciasTelas.geralAgendarTarefas = geralAgendarTarefas;
    }   
    
}
