
package controle.controleAcesso;

import telas.comuns.telas.AcessoNegado;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class VerificaAutorizacao {
    
    public static Boolean geral_visualizarCameras;
    public static Boolean geral_mapaDispositivos;
    public static Boolean geral_cenario;
    public static Boolean geral_localizacaoGPS;
    public static Boolean geral_mensagens;
    public static Boolean geral_agendarTarefas;
    public static Boolean geral_logAcoes;
    
    public static Boolean cadastro_pessoa;
    public static Boolean cadastro_usuario;
    public static Boolean cadastro_predio;
    public static Boolean cadastro_area;
    public static Boolean cadastro_marca;
    public static Boolean cadastro_camera;
    public static Boolean cadastro_moduloAcionamento;
    public static Boolean cadastro_dispositivoEletrico;
    
    public static Boolean pesquisar_pessoa;
    public static Boolean pesquisar_usuario;
    public static Boolean pesquisar_predio;
    public static Boolean pesquisar_area;
    public static Boolean pesquisar_marca;
    public static Boolean pesquisar_camera;
    public static Boolean pesquisar_moduloAcionamento;
    public static Boolean pesquisar_dispositivoEletrico;
    public static Boolean pesquisar_mensagem;
    
    public static Boolean relatorio_pessoa;
    public static Boolean relatorio_predio;
    public static Boolean relatorio_dispositivo;
    public static Boolean relatorio_mensagens;
    public static Boolean relatorio_movimento;
    public static Boolean relatorio_acionamento;
    public static Boolean relatorio_agendarTarefas;
    public static Boolean relatorio_logAcoes;
    
    public static Boolean ferramentas_editarImagens;
    public static Boolean ferramentas_reprodutorVideos;
    public static Boolean ferramentas_desenharMapas;
    public static Boolean ferramentas_opcoes;
    
    public static Boolean ajuda_manual;
    
    public static void todasPermissoes() { 
        VerificaAutorizacao.geral_visualizarCameras = true;
        VerificaAutorizacao.geral_mapaDispositivos = true;
        VerificaAutorizacao.geral_cenario = true;
        VerificaAutorizacao.geral_localizacaoGPS = true;
        VerificaAutorizacao.geral_mensagens = true;
        VerificaAutorizacao.geral_agendarTarefas = true;
        VerificaAutorizacao.geral_logAcoes = true;
        
        VerificaAutorizacao.cadastro_pessoa = true;
        VerificaAutorizacao.cadastro_usuario = true;
        VerificaAutorizacao.cadastro_predio = true;
        VerificaAutorizacao.cadastro_area = true;
        VerificaAutorizacao.cadastro_marca = true;
        VerificaAutorizacao.cadastro_camera = true;
        VerificaAutorizacao.cadastro_moduloAcionamento = true;
        VerificaAutorizacao.cadastro_dispositivoEletrico = true;
        
        VerificaAutorizacao.pesquisar_pessoa = true;
        VerificaAutorizacao.pesquisar_usuario = true;
        VerificaAutorizacao.pesquisar_predio = true;
        VerificaAutorizacao.pesquisar_area = true;
        VerificaAutorizacao.pesquisar_marca = true;
        VerificaAutorizacao.pesquisar_camera = true;
        VerificaAutorizacao.pesquisar_moduloAcionamento = true;
        VerificaAutorizacao.pesquisar_dispositivoEletrico = true;
        VerificaAutorizacao.pesquisar_mensagem = true;
        
        VerificaAutorizacao.relatorio_pessoa = true;
        VerificaAutorizacao.relatorio_predio = true;
        VerificaAutorizacao.relatorio_dispositivo = true;
        VerificaAutorizacao.relatorio_mensagens = true;
        VerificaAutorizacao.relatorio_movimento = true;
        VerificaAutorizacao.relatorio_acionamento = true;
        VerificaAutorizacao.relatorio_agendarTarefas = true;
        VerificaAutorizacao.relatorio_logAcoes = true;
        
        VerificaAutorizacao.ferramentas_editarImagens = true;
        VerificaAutorizacao.ferramentas_reprodutorVideos = true;
        VerificaAutorizacao.ferramentas_desenharMapas = true;
        VerificaAutorizacao.ferramentas_opcoes = true;
        
        VerificaAutorizacao.ajuda_manual = true; 
    }
    
    public static void semPermissoes() {
        VerificaAutorizacao.geral_agendarTarefas = false;
        VerificaAutorizacao.geral_cenario = false;
        VerificaAutorizacao.geral_mapaDispositivos = false;
        VerificaAutorizacao.geral_localizacaoGPS = false;
        VerificaAutorizacao.geral_mensagens = false;
        VerificaAutorizacao.geral_visualizarCameras = false;
        VerificaAutorizacao.geral_logAcoes = false;
        
        VerificaAutorizacao.cadastro_camera = false;
        VerificaAutorizacao.cadastro_dispositivoEletrico = false;
        VerificaAutorizacao.cadastro_marca = false;
        VerificaAutorizacao.cadastro_area = false;
        VerificaAutorizacao.cadastro_moduloAcionamento = false;
        VerificaAutorizacao.cadastro_pessoa = false;
        VerificaAutorizacao.cadastro_predio = false;
        VerificaAutorizacao.cadastro_usuario = false;
        
        VerificaAutorizacao.pesquisar_camera = false;
        VerificaAutorizacao.pesquisar_dispositivoEletrico = false;
        VerificaAutorizacao.pesquisar_marca = false;
        VerificaAutorizacao.pesquisar_moduloAcionamento = false;
        VerificaAutorizacao.pesquisar_pessoa = false;
        VerificaAutorizacao.pesquisar_predio = false;
        VerificaAutorizacao.pesquisar_usuario = false;
        VerificaAutorizacao.pesquisar_mensagem = false;
        
        VerificaAutorizacao.relatorio_acionamento = false;
        VerificaAutorizacao.relatorio_dispositivo = false;
        VerificaAutorizacao.relatorio_mensagens = false;
        VerificaAutorizacao.relatorio_movimento = false;
        VerificaAutorizacao.relatorio_pessoa = false;
        VerificaAutorizacao.relatorio_predio = false;
        VerificaAutorizacao.relatorio_agendarTarefas = false;
        VerificaAutorizacao.relatorio_logAcoes = false;
        
        VerificaAutorizacao.ferramentas_desenharMapas = false;
        VerificaAutorizacao.ferramentas_editarImagens = false;
        VerificaAutorizacao.ferramentas_reprodutorVideos = false;
        VerificaAutorizacao.ferramentas_opcoes = false;
        
        VerificaAutorizacao.ajuda_manual = false; 
    }
    
    public static void acessoNegado(){
        AcessoNegado acessoNegado = new AcessoNegado(null, true);
        acessoNegado.setVisible(true);
    }
    
}
