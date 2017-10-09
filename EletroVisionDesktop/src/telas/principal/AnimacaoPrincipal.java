
package telas.principal;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.sistema.ConfigDispositivos;
import javax.swing.ImageIcon;
import recursos.instancias.InstanciasTelas;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AnimacaoPrincipal implements Runnable{
    
    private Integer qual, repeticoes;
    
    public AnimacaoPrincipal(Integer qual){
        this.qual = qual;
        repeticoes = 10;
    } 

    @Override
    public void run() {
        if(qual == 1) {
            animarMovimento();
            if(InstanciasTelas.getPrincipal() != null) {
                InstanciasTelas.getPrincipal().lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movDetectado())));
            }
        } else if(qual == 2) {
            animarPessoas();
            if(InstanciasTelas.getPrincipal() != null) {
                if(ConfigDispositivos.getDetectarFace() || ConfigDispositivos.getDetectarOlhos() || ConfigDispositivos.getDetectarCorpo()) {
                    InstanciasTelas.getPrincipal().lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaDetectada())));
                } else {
                    InstanciasTelas.getPrincipal().lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaInativa())));
                }
            }
        } else if(qual == 3) {
            animarAgendarTarefas();
            if(InstanciasTelas.getPrincipal() != null) {
                InstanciasTelas.getPrincipal().lb_agendarTarefas.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_agendarAtivo2())));
            }
        } else if(qual == 4) {
            animarDispositivos();
            if(InstanciasTelas.getPrincipal() != null) {
                InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_dispositivosLigados())));
            }
        } else if(qual == 5) {
            animarMensagens();
            if(InstanciasTelas.getPrincipal() != null) {
                InstanciasTelas.getPrincipal().lb_mensagens.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_mensagemEnviar2())));
            }
        } else if(qual == 6) {
            animarRedes();
            if(InstanciasTelas.getPrincipal() != null) {
                InstanciasTelas.getPrincipal().lb_rede.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_redeConectada())));
            }
        } 
    }
    
    private void esperar(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
    }

    private void animarMovimento() {
        if(InstanciasTelas.getPrincipal() != null) {
            for(int i = 0; i < repeticoes; i++){
                if(i % 2 == 0) { 
                    InstanciasTelas.getPrincipal().lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movDetectado())));
                } else {
                    InstanciasTelas.getPrincipal().lb_movimento.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_movDetectado2())));
                }
                esperar();
            }
        }
    }

    private void animarAgendarTarefas() {
        if(InstanciasTelas.getPrincipal() != null) {
            for(int i = 0; i < repeticoes; i++){
                if(i % 2 == 0) { 
                    InstanciasTelas.getPrincipal().lb_agendarTarefas.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_agendarAtivo())));
                } else {
                    InstanciasTelas.getPrincipal().lb_agendarTarefas.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_agendarAtivo2())));
                }
                esperar();
            }
        }
    }

    private void animarMensagens() {
        if(InstanciasTelas.getPrincipal() != null) {
            for(int i = 0; i < repeticoes; i++){
                if(i % 2 == 0) { 
                    InstanciasTelas.getPrincipal().lb_mensagens.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_mensagemEnviar())));
                } else {
                    InstanciasTelas.getPrincipal().lb_mensagens.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_mensagemEnviar2())));
                }
                esperar();
            }
        }
    }

    private void animarDispositivos() {
        if(InstanciasTelas.getPrincipal() != null) {
            for(int i = 0; i < repeticoes; i++){
                if(i % 2 == 0) { 
                    InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_dispositivosLigando())));
                } else {
                    InstanciasTelas.getPrincipal().lb_dispositivosEletricos.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_dispositivosLigados())));
                }
                esperar();
            }
        }
    }

    private void animarPessoas() {
        if(InstanciasTelas.getPrincipal() != null) {
            for(int i = 0; i < repeticoes; i++){
                if(i % 2 == 0) { 
                    InstanciasTelas.getPrincipal().lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaAnimar())));
                } else {
                    InstanciasTelas.getPrincipal().lb_pessoa.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_pessoaAnimar2())));
                }
                esperar();
            }
        }
    }
    
    private void animarRedes() {
        if(InstanciasTelas.getPrincipal() != null) {
            for(int i = 0; i < repeticoes; i++){
                if(i % 2 == 0) { 
                    InstanciasTelas.getPrincipal().lb_rede.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_redeConectada())));
                } else {
                    InstanciasTelas.getPrincipal().lb_rede.setIcon(new ImageIcon(getClass().getResource(ArquivosImagens.principal_redeConectada2())));
                }
                esperar();
            }
        }
    }
    
}
