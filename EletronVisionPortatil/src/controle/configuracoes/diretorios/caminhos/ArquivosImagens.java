
package controle.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosImagens {
    
 /*
* ==================================================================
   ========   ARQUIVOS DE IMAGENS =======================================
* ==================================================================
*/
    
    public static String logo(){
        return "/recursos/imagens/layout/logo.png";
    }
    
    public static String logo_nome(){
        return "/recursos/imagens/layout/logo_nome.png";
    }
    
    public static String fundo_topo(){
        return "/recursos/imagens/layout/fundo_topo.png";
    }
    
    public static String fundo_login(){
        return "/recursos/imagens/layout/fundoLogin_800x400.png";
    }
    
    /*
     * ==================================================================
         IMAGENS INTERNAS AO PROJETO
     * ==================================================================
     */
    
    //IMAGEM DAS MENSAGENS
    public static String msg_bug(){
        return "/recursos/imagens/mensagens/bug_64x64.png";
    }
    
    public static String msg_confirmacao(){
        return "/recursos/imagens/mensagens/confirmacao_64x64.png";
    }
    
    public static String msg_sucesso(){
        return "/recursos/imagens/mensagens/sucesso_64x64.png";
    }
    
    public static String msg_aviso(){
        return "/recursos/imagens/mensagens/aviso_64x64.png";
    }
    
    public static String msg_escolha(){
        return "/recursos/imagens/mensagens/escolha_64x64.png";
    }
    
    public static String msg_entradaDados(){
        return "/recursos/imagens/mensagens/inserirDados_64x64.png";
    }
    
    public static String diretorio_redes(){
        return pasta()+"redes";
    }
    
    private static String pasta() {
        return "midia"+File.separator;
    }
    
}
