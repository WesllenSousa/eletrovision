
package recursos.internacionalizacao;

import util.Internacionalizacao;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MensagensTelas {
    
/* =============================================================================
 * =====================COMUNS==================================================
 * ===========================================================================*/
    
    public static String com_acoes() {
        return "Ações";
    }
    
    public static String com_adaptarAmbiente() {
        return "Adaptar ao Ambiente";
    }
    
    public static String com_mudancaAmbiente() {
        return "Detectar mudança no ambiente";
    }
    
    public static String com_gravar() {
        return "Gravar ";
    }
    
    public static String com_acionarDispositivos() {
        return "Acionar dispositivos";
    }
    
    public static String com_campanhia() {
        return "Campanhia";
    }
    
    public static String com_objeto() {
        return "Detectar objeto";
    }
    
    public static String com_face() {
        return "Detectar face";
    }
    
    public static String com_olhos() {
        return "Detectar olhos";
    }
    
    public static String com_corpo() {
        return "Detectar corpo";
    }
    
    public static String com_reconhecerFace() {
        return "Reconhecer face";
    }
    
    public static String com_movimento() {
        return "Movimento";
    }
    
    public static String com_ambienteStatico() {
        return "Ambiente stático";
    }
     
/* =============================================================================
 * =====================CADASTROS===============================================
 * ===========================================================================*/
    
    public static String cad_codigo() {
        if(Internacionalizacao.portugues()) {
            return "Código:*";
        } else {
            return "Code:*";
        }
    }
    
    public static String cad_nome() {
        return "Nome:*";
    }
    
    public static String cad_predio() {
        return "Prédio:*";
    }
    
    public static String cad_identificacao() {
        return "Identificação:*";
    }
    
    public static String cad_marca() {
        return "Marca:*";
    }
    
    public static String cad_area() {
        return "Área:*";
    }
    
    public static String cad_moduloAcionamento() {
        return "Módulo Acionamento:*";
    }
    
    public static String cad_duracao() {
        return "Duração:*";
    }
    
    public static String cad_permanente() {
        return "Permanente";
    }
    
    public static String cad_curto() {
        return "Curto";
    }
    
    public static String cad_saidaEletrica() {
        return "Saída Elétrica:*";
    }
    
    public static String cad_ip() {
        return "Ip:*";
    }
    
    public static String cad_porta() {
        return "Porta:*";
    }
    
    public static String cad_qtdeSaida() {
        return "Qtde Saídas:*";
    }
    
    public static String cad_cpf() {
        return "CPF:*";
    }
    
    public static String cad_rg() {
        return "RG:*";
    }
    
    public static String cad_nascimento() {
        return "Nascimento:*";
    }
    
    public static String cad_tipo() {
        return "Tipo:*";
    }
    
    public static String cad_celular() {
        return "Celular:*";
    }
    
    public static String cad_email() {
        return "Email:*";
    }
    
    public static String cad_enviarMensagemAutomatica() {
        return "Enviar mensagem automática";
    }
    
    public static String cad_enderecos() {
        return "Endereços";
    }
    
    public static String cad_endereco() {
        return "Endereço";
    }
    
    public static String cad_estado() {
        return "Estado:*";
    }
    
    public static String cad_cidade() {
        return "Cidade:*";
    }
    
    public static String cad_bairro() {
        return "Bairro:*";
    }
    
    public static String cad_logradouro() {
        return "Logradouro:*";
    }
    
    public static String cad_numero() {
        return "Número:*";
    }
    
    public static String cad_referencia() {
        return "Referência:*";
    }
    
    public static String cad_ativarAlarme() {
        return "Ativar alarme via localização GPS";
    }
    
    public static String cad_ativo() {
        return "Ativo";
    }
    
    public static String cad_dono() {
        return "Dono";
    }
    
    public static String cad_familia() {
        return "Família";
    }
    
    public static String cad_vigia() {
        return "Vigia";
    }
    
    public static String cad_funcionario() {
        return "Funcionário";
    }
    
    public static String cad_outros() {
        return "Outros";
    }
    
    public static String cad_dadosPessoais() {
        return "Dados Pessoais";
    }
    
    public static String cad_dados() {
        return "Dados";
    }
    
    public static String cad_processamento() {
        return "Processamento";
    }
    
    public static String cad_contatos() {
        return "Contatos";
    }
    
    public static String cad_conexao() {
        return "Conexão";
    }
    
    public static String cad_longitude() {
        return "Longitude:";
    }
    
    public static String cad_latitude() {
        return "Latitude:";
    }
    
    public static String cad_coordenadasGeograficas() {
        return "Coordenadas Geográficas (Para o GPS)";
    }
    
    public static String cad_tipoPredio() {
        return "<Escolha o tipo do prédio>";
    }
    
    public static String cad_residencia() {
        return "Residência";
    }
    
    public static String cad_comercio() {
        return "Comércio";
    }
    
    public static String cad_industria() {
        return "Industria";
    }
    
    public static String cad_imagem() {
        return "Imagem";
    }
    
    public static String cad_pessoa() {
        return "Pessoa:*";
    }
    
    public static String cad_login() {
        return "Login:*";
    }
    
    public static String cad_usuario() {
        return "Usuario:*";
    }
    
    public static String cad_senha() {
        return "Senha:*";
    }
    
    public static String cad_rSenha() {
        return "R. Senha:*";
    }
    
    public static String cad_autorizacoes() {
        return "Autorizações:";
    }
    
    public static String cad_modulosDisponiveis() {
        return "Módulos Disponíveis";
    }
    
    public static String cad_modulosAdicionados() {
        return "Módulos Adicionados";
    }
    
    public static String cad_permissoes() {
        return "Permissões";
    }
    
    public static String cad_pessoas() {
        return "Pessoas";
    }
    
    public static String cad_local() {
        return "Local";
    }
    
    public static String cad_rede() {
        return "Rede";
    }

    public static String cad_tipoProcessamento() {
        return "Tipo de processamento";
    }
    
    public static String cad_tipoConexao() {
        return "Tipo de conexão";
    }
    
    public static String cad_enderecosExistentes() {
        return "<Endereços Existentes>";
    }
   
    public static String cad_selecionarPredio() {
        return "<Selecione um Prédio>";
    }
    
    public static String cad_selecionarMarca() {
        return "<Selecione uma Marca>";
    }
    
    public static String cad_selecionarArea() {
        return "<Selecione um Área>";
    }
    
    public static String cad_selecionarSaidaEletrica() {
        return "<Selecione uma Saída Elétrica>";
    }
    
    public static String cad_selecionarModuloAcionamento() {
        return "<Selecione um Módulo Acionamento>";
    }
    
    public static String cad_selecionarDuracaoDispositivo() {
        return "<Selecione a duração dispositivo>";
    }
    
    public static String cad_selecionarTipo() {
        return "<Selecione um Tipo>";
    }
    
    public static String cad_selecionarPessoa() {
        return "<Selecione uma Pessoa>";
    }
    
    public static String cad_novo() {
        return "<Novo>";
    }
    
}
