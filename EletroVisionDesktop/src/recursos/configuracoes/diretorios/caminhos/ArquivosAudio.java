
package recursos.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosAudio {
    
    /*
    * ==================================================================
       ========   Diretorios =================================================
    * ==================================================================
    */
    
    public static String diretorioAlarme(){
        return pasta()+File.separator+"alarmes";
    }
    
     /*
    * ==================================================================
       ========   ARQUIVOS =================================================
    * ==================================================================
    */
    
    //ALARMES
    public static String alarme1(){
        return pasta()+"alarmes"+File.separator+"mov_Alarme_1.mp3";
    }
    
    //MOVIMENTO
    public static String objetoDetectado(){
        return pasta()+"movimentos"+File.separator+"mov_ObjetoDetectado.mp3";
    }
    
    public static String ambienteAlterado(){
        return pasta()+"movimentos"+File.separator+"mov_ambienteAlterado.mp3";
    }
    
    public static String pessoasIdentificadas(){
        return pasta()+"movimentos"+File.separator+"mov_PessoasIdentificadas.mp3";
    }
    
    public static String umaPessoasDetectada(){
        return pasta()+"movimentos"+File.separator+"mov_UmaPessoaDetectada.mp3";
    }
    
    public static String duasPessoasDetectada(){
        return pasta()+"movimentos"+File.separator+"mov_DuasPessoasDetectadas.mp3";
    }
    
    public static String tresPessoasDetectada(){
        return pasta()+"movimentos"+File.separator+"mov_TresPessoasDetectadas.mp3";
    }
    
    public static String quatroPessoasDetectada(){
        return pasta()+"movimentos"+File.separator+"mov_QuatroPessoasDetectadas.mp3";
    }
    
    public static String cincoPessoasDetectada(){
        return pasta()+"movimentos"+File.separator+"mov_CincoPessoasDetectadas.mp3";
    }
    
    public static String maisPessoasDetectada(){
        return pasta()+"movimentos"+File.separator+"mov_MaisPessoasDetectadas.mp3";
    }
    
    public static String faceReconhecida(){
        return pasta()+"movimentos"+File.separator+"mov_FaceReconhecida.mp3";
    }
    
    //SISTEMA
    public static String sisAbrirJanela(){
        return pasta()+"sistema"+File.separator+"abrirJanela.mp3";
    }
    
    public static String sisAviso(){
        return pasta()+"sistema"+File.separator+"aviso.mp3";
    }
    
    public static String sisDeletar(){
        return pasta()+"sistema"+File.separator+"deletar.mp3";
    }
    
    public static String sisErro(){
        return pasta()+"sistema"+File.separator+"erro.mp3";
    }
    
    public static String sisFoto(){
        return pasta()+"sistema"+File.separator+"foto.mp3";
    }
    
    public static String sisPergunta(){
        return pasta()+"sistema"+File.separator+"perguntar.mp3";
    }
    
    public static String sisSalvar(){
        return pasta()+"sistema"+File.separator+"salvar.mp3";
    }
    
    public static String sisIniciar(){
        return pasta()+"sistema"+File.separator+"iniciar.mp3";
    }
    
    public static String sisTelefone(){
        return pasta()+"sistema"+File.separator+"telefone.mp3";
    }
    
    public static String sisCampanhia(){
        return pasta()+"sistema"+File.separator+"campanhia.mp3";
    }
    
    //PASTA
    public static String pasta(){
        return "midia"+File.separator+"audio"+File.separator;
    }
    
}
