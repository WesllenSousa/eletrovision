
package controle.controleAcesso;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.modulo.bean.ModuloBean;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfiguraAutorizacao {
    
    private AutorizacaoBean autorizacao;
    
    public ConfiguraAutorizacao(AutorizacaoBean autorizacao){       
        this.autorizacao = autorizacao;
    }
    
    public void populaAutorizacoes(){
        for(ModuloBean modulo : autorizacao.getModulos()) {
            
            switch (modulo.getNome()) {
                case "Visualizar Camera":
                    VerificaAutorizacao.geral_visualizarCameras = true;
                    break;
                case "Mapa Dispositivos":
                    VerificaAutorizacao.geral_mapaDispositivos = true;
                    break;
                case "Cenario":
                    VerificaAutorizacao.geral_cenario = true;
                    break;
               case "Mensagem":
                    VerificaAutorizacao.geral_mensagens = true;
                    break;
               case "Agendar Tarefas":
                    VerificaAutorizacao.geral_agendarTarefas = true;
                    break;
               case "Log Acoes":
                    VerificaAutorizacao.geral_logAcoes = true;
                    break; 
               case "Localizacao Gps":
                    VerificaAutorizacao.geral_localizacaoGPS = true;
                    break;
                   
               case "Cadastrar Pessoa":
                    VerificaAutorizacao.cadastro_pessoa = true;
                    break;
               case "Cadastrar Usuario":
                    VerificaAutorizacao.cadastro_usuario = true;
                    break;
               case "Cadastrar Predio":
                    VerificaAutorizacao.cadastro_predio = true;
                    break;
               case "Cadastrar Area":
                    VerificaAutorizacao.cadastro_area = true;
                    break;
               case "Cadastrar Marca":
                    VerificaAutorizacao.cadastro_marca = true;
                    break;
               case "Cadastrar Camera":
                    VerificaAutorizacao.cadastro_camera = true;
                    break;
               case "Cadastrar Modulo Acionamento":
                    VerificaAutorizacao.cadastro_moduloAcionamento = true;
                    break;
               case "Cadastrar Dispositivo Eletrico":
                    VerificaAutorizacao.cadastro_dispositivoEletrico = true;
                    break;
                   
               case "Pesquisar Pessoa":
                    VerificaAutorizacao.pesquisar_pessoa = true;
                    break;
               case "Pesquisar Usuario":
                    VerificaAutorizacao.pesquisar_usuario = true;
                    break;
               case "Pesquisar Predio":
                    VerificaAutorizacao.pesquisar_predio = true;
                    break;
               case "Pesquisar Area":
                    VerificaAutorizacao.pesquisar_area = true;
                    break;
               case "Pesquisar Marca":
                    VerificaAutorizacao.pesquisar_marca = true;
                    break;
               case "Pesquisar Camera":
                    VerificaAutorizacao.pesquisar_camera = true;
                    break;
               case "Pesquisar Modulo Acionamento":
                    VerificaAutorizacao.pesquisar_moduloAcionamento = true;
                    break;
               case "Pesquisar Dispositivo Eletrico":
                    VerificaAutorizacao.pesquisar_dispositivoEletrico = true;
                    break;
               case "Pesquisar Mensagem":
                    VerificaAutorizacao.pesquisar_mensagem = true;
                    break;
                   
               case "Relatorio Pessoa":
                    VerificaAutorizacao.relatorio_pessoa = true;
                    break;
               case "Relatorio Predio":
                    VerificaAutorizacao.relatorio_predio = true;
                    break;
               case "Relatorio Dispositivo":
                    VerificaAutorizacao.relatorio_dispositivo = true;
                    break;
               case "Relatorio Mensagem":
                    VerificaAutorizacao.relatorio_mensagens = true;
                    break;
               case "Relatorio Movimento":
                    VerificaAutorizacao.relatorio_movimento = true;
                    break;
               case "Relatorio Acionamento":
                    VerificaAutorizacao.relatorio_acionamento = true;
                    break;
               case "Relatorio Agendamento":
                    VerificaAutorizacao.relatorio_agendarTarefas = true;
                    break;
               case "Relatorio LogAcoes":
                    VerificaAutorizacao.relatorio_logAcoes = true;
                    break;
                   
               case "Ferramenta Editar Imagem":
                    VerificaAutorizacao.ferramentas_editarImagens = true;
                    break;
               case "Ferramenta Reprodutor Video":
                    VerificaAutorizacao.ferramentas_reprodutorVideos = true;
                    break;
               case "Ferramenta Desenhar Mapa":
                    VerificaAutorizacao.ferramentas_desenharMapas = true;
                    break;
               case "Ferramenta Opcao":
                    VerificaAutorizacao.ferramentas_opcoes = true;
                    break;
                   
               case "Manual":
                    VerificaAutorizacao.ajuda_manual = true;
                    break;
            }
            
        }
    }
    
}
