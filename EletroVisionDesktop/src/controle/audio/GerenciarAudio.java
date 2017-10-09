
package controle.audio;

import recursos.configuracoes.diretorios.caminhos.ArquivosAudio;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.configuracoes.sistema.ConfigGerais;
import java.io.File;
import telas.principal.AnimacaoPrincipal;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GerenciarAudio {
    
    public GerenciarAudio(){
    }
    
//=================MOVIMENTO============================================
    
    private void animar(Integer i){
        AnimacaoPrincipal animacaoPrincipal = new AnimacaoPrincipal(i);
        Thread thread = new Thread(animacaoPrincipal);
        thread.start();
    }
    
    private Boolean somCameraAtivado(){
        return ConfigGerais.getAtivarSomCamera();
    } 
    
    public void exeAlarme(){   
        animar(1);
        if(somCameraAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.diretorioAlarme()+File.separator+ConfigDispositivos.getAlarme()));
        }
    }
    
    public void exeAmbienteAlterado(){
        animar(1);
        if(somCameraAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.ambienteAlterado()));
        }  
    }
    
    public void exeObjetoDetectado(){
        animar(1);
        if(somCameraAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.objetoDetectado()));
        }  
    }
    
    public void exeFaceIdentificada(Integer qtde){
        animar(2);
        String som = "";
        if(qtde == 1) {
            som = ArquivosAudio.umaPessoasDetectada();
        } else if(qtde == 2) {
            som = ArquivosAudio.duasPessoasDetectada();
        } else if(qtde == 3) {
            som = ArquivosAudio.tresPessoasDetectada();
        } else if(qtde == 4) {
            som = ArquivosAudio.quatroPessoasDetectada();
        } else if(qtde == 5) {
            som = ArquivosAudio.cincoPessoasDetectada();
        } else if(qtde > 5) {
            som = ArquivosAudio.maisPessoasDetectada();
        }
        if(somCameraAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(som));
        }
    }
    
    public void exeOlhosIdentificados(){
        animar(2);
        if(somCameraAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.pessoasIdentificadas()));
        }
    }
    
    public void exeFaceReconhecida(){
        animar(2);
        if(somCameraAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.faceReconhecida()));
        }
    }
    
//=================SISTEMA===============================================
    
    private Boolean somSistemaAtivado(){
        if(ConfigGerais.getStatus() != null && ConfigGerais.getStatus()) {
            return ConfigGerais.getAtivarSomSistema();
        } else {
            return false;
        }
    }
    
    public void exeAbrirJanela(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisAbrirJanela()));
        }
    }
    
    public void exeAviso(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisAviso()));
        }
    }
    
    public void exeDeletar(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisDeletar()));
        }
    }
    
    public void exeErro(){
        if(somSistemaAtivado()) { 
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisErro()));
        }
    }
    
    public void exeFoto(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisFoto()));
        }
    }
    
    public void exePergunta(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisPergunta()));
        }
    }
    
    public void exeSalvar(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisSalvar()));
        }
    }
    
    public void exeIniciar(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisIniciar()));
        }
    }

    public void exeTelefone(){
        animar(6); 
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisTelefone()));
        }
    }
    
    public void exeCampanhia(){
        if(somSistemaAtivado()) {
            Audio audio = new Audio(Boolean.TRUE);
            audio.executar(new File(ArquivosAudio.sisCampanhia()));
        }
    }
    
}
