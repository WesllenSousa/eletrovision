
package recursos.configuracoes.diretorios.caminhos;

import recursos.configuracoes.diretorios.Raiz;
import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosHTML {
    
    public static String cadastros(){
        return manual()+"modulos"+File.separator+"cadastros"+File.separator;
    }
    
    public static String ferramentas(){
        return manual()+"modulos"+File.separator+"ferramentas"+File.separator;
    }
    
    public static String geral(){
        return manual()+"modulos"+File.separator+"geral"+File.separator;
    }
    
    public static String pesquisas(){
        return manual()+"modulos"+File.separator+"pesquisas"+File.separator;
    }
    
    public static String relatorios(){
        return manual()+"modulos"+File.separator+"relatorios"+File.separator;
    }
    
    public static String manual(){
        return pasta()+"Manual"+File.separator;
    }
    
    public static String HTML(){
        return pasta();
    }
    
    private static String pasta() {
        return Raiz.getRaiz()+File.separator+"html"+File.separator;
        //return "html"+File.separator;
    }
    
    /*
     * Arquivos
     */
    
    public static String index(){
        return "index.html";
    }
    
    public static String agendarTarefas(){
        return "agendar-tarefas.html";
    }
    
    public static String cenarios(){
        return "cenarios.html";
    }
    
    public static String localizacaoGps(){
        return "localizacao-gps.html";
    }
    
    public static String logAcoes(){
        return "log-acoes.html";
    }
    
    public static String mapaDispositivos(){
        return "mapa-dispositivos.html";
    }
    
    public static String mensagens(){
        return "mensagens.html";
    }
    
    public static String visualizarCameras(){
        return "visualizar-cameras.html";
    }
    
    public static String desenharMapas(){
        return "desenhar-mapas.html";
    }
    
    public static String editarImagens(){
        return "editar-imagens.html";
    }
    
    public static String opcoes(){
        return "opcoes.html";
    }
    
    public static String reprodutorVideos(){
        return "reprodutor-videos.html";
    }
    
    public static String area(){
        return "area.html";
    }
    
    public static String camera(){
        return "camera.html";
    }
    
    public static String dispositivoEletrico(){
        return "dispositivo-eletrico.html";
    }
    
    public static String marca(){
        return "marca.html";
    }
    
    public static String moduloAcionamento(){
        return "modulo-acionamento.html";
    }
    
    public static String pessoa(){
        return "pessoa.html";
    }
    
    public static String predio(){
        return "predio.html";
    }
    
    public static String usuario(){
        return "usuario.html";
    }
    
    public static String acionamentos(){
        return "acionamentos.html";
    }
    
    public static String agendamentoTarefas(){
        return "agendamento-tarefas.html";
    }
    
    public static String dispositivos(){
        return "dispositivos.html";
    }
    
    public static String movimentos(){
        return "movimentos.html";
    }
    
    public static String pessoas(){
        return "pessoas.html";
    }
    
    public static String predios(){
        return "predios.html";
    }
    
}
