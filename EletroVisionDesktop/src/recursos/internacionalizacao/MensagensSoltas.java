
package recursos.internacionalizacao;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MensagensSoltas {
    
/* =============================================================================
 * =====================CONTROLE================================================
 * ===========================================================================*/
   
/* -----------------------CONFIGURAÇÕES---------------------------------------*/
    
    public static String bloqueioArquivo() {
        return "Foi detectado que o ELETRO VISION já está aberto ou o ele não foi fechado corretamente!\n"
             + "Se o ELETRO VISION não estiver aberto desconsidere esta mensagem. \n"
             + "OBS: É importante considerar que duas instancias abertas do ELETRO VISION pode causar\n sérios problemas!"
             + "\n\nDeseja realmente continuar?";
    }
    
    public static String xmlGravar() {
        return "Arquivo xml salvo com sucesso!";
    }
    
 /* -----------------------MENSAGEM-------------------------------------------*/

    public static String celularSucesso() {
        return "SMS enviado com sucesso!";
    }
    
    public static String celularErroEnviar() {
        return "Erro ao enviar Mensagem - possíveis causas: \n"
                + " 1) Verificar se o modem está conectado. \n"
                + " 2) Verificar se a porta do modem está configurada corretamente.\n";
    }
    
    public static String emailSucesso() {
        return "Email enviado com sucesso!";
    }
    
    public static String emailErroEnviar() {
        return "Erro ao enviar email - Verifique sua conexão!";
    }
       
    public static String mensagemErro() {
        return "Error";
    }
    
    public static String mensagemSucesso() {
        return "Sucesso";
    }
    
    public static String mensagemAviso() {
        return "Aviso";
    }
    
    public static String mensagemConfirmacao() {
        return "Confirmação";
    }
    
    public static String mensagemEscolha() {
        return "Escolha";
    }
    
    public static String mensagemInformeDado() {
        return "Informe o dado";
    }
    
/* -----------------------GERENCIARACIONAMENTO-------------------------------*/
    
    public static String gerenciarAcionamentoVerificaConexao(String nome) {
        return "Módulo de Acionamento "+nome+" desconectado!";
    }
    
    public static String gerenciarAcionamentoVerificaEstado(String nome) {
        return "Não foi possível conectar ao Módulo de Acionamento " + nome + ".";
    }
    
    public static String gerenciarAcionamentoSucesso(String nome) {
        return "Conexão realizada com sucesso \n no Módulo de Acionamento "+nome+".";
    }
    
    public static String gerenciarAcionamentoDesconectar(String nome) {
        return "Módulo de acionamento "+nome+" desconectado com sucesso.";
    }
    
/* ------------------------CÂMERAS--------------------------------------------*/
    
    public static String camerasParar() {
        return "Câmeras paradas com sucesso!";
    }
    
/*----------------------REDES-------------------------------------------------*/
    
    public static String redesClienteIniciar() {
        return "Servidor não encontrado!";
    }
    
    public static String redesServidorCriar() {
        return "Erro ao criar servidor!";
    }
    
 /* ============================================================================
 * =====================RECURSOS================================================
 * ===========================================================================*/
    
    public static String backup() {
        return "Não foi possível fazer BackUp devido erro na identificação do Sistema Operacional!";
    }
    
 /* ============================================================================
 * =====================TELAS===================================================
 * ===========================================================================*/
    
/* -----------------------PRINCIPAL-------------------------------------------*/
    
    /* Categoria: STATUS */
    
    public static String principal_status_visualizarCameras() {
        return "Abrindo o visualizador de câmeras...";
    }
    
    public static String principal_status_cadastrarPessoas() {
        return "Abrindo o cadastro de pessoas...";
    }
    
    public static String principal_status_cadastrarUsuarios() {
        return "Abrindo o cadastro de usuários...";
    }
    
    public static String principal_status_cadastrarPredios() {
        return "Abrindo o cadastro de prédios...";
    }
    
    public static String principal_status_cadastrarCameras() {
        return "Abrindo o cadastro de câmeras...";
    }
    
    public static String principal_status_cadastrarAreas() {
        return "Abrindo o cadastro de áreas...";
    }
    
    public static String principal_status_cadastrarModuloAcionamento() {
        return "Abrindo o cadastro de módulos de acionamentos...";
    }
    
    public static String principal_status_cadastrarDispositivosEletricos() {
        return "Abrindo o cadastro de dispositivos elétricos...";
    }
    
    public static String principal_status_manual() {
        return "Abrindo o manual...";
    }
    
    public static String principal_status_relatorioPessoas() {
        return "Abrindo o relatório de pessoas...";
    }
    
    public static String principal_status_relatorioPredios() {
        return "Abrindo o relatório de prédios...";
    }
    
    public static String principal_status_relatorioDispositivos() {
        return "Abrindo o relatório de dispositivos...";
    }
    
    public static String principal_status_ferramentasEditarImagens() {
        return "Abrindo o editor de imagens...";
    }
    
    public static String principal_status_ferramentasOpcoes() {
        return "Abrindo as opções...";
    }
    
    public static String principal_status_relatorioMensagens() {
        return "Abrindo o relatório de mensagens...";
    }
    
    public static String principal_status_relatorioMovimentos() {
        return "Abrindo o relatório de movimentos...";
    }
    
    public static String principal_status_mapaDispositivos() {
        return "Abrindo o mapa de dispositivos...";
    }
    
    public static String principal_status_cenario() {
        return "Abrindo o cenário...";
    }
    
    public static String principal_status_agendarTarefas() {
        return "Abrindo o agendador de tarefas...";
    }
    
    public static String principal_status_cadastrarMarca() {
        return "Abrindo o cadastro de marcas...";
    }
    
    public static String principal_status_ferramentasDesenharMapas() {
        return "Abrindo o criador de mapas...";
    }
    
    public static String principal_status_mensagens() {
        return "Abrindo as mensagens...";
    }
    
    public static String principal_status_relatorioAcionamento() {
        return "Abrindo o relatório de acionamentos...";
    }
    
    public static String principal_status_pesquisarPessoas() {
        return "Abrindo o pesquisar pessoas...";
    }
    
    public static String principal_status_pesquisarUsuarios() {
        return "Abrindo o pesquisar usuários...";
    }
    
    public static String principal_status_pesquisarAreas() {
        return "Abrindo o pesquisar áreas...";
    }
    
    public static String principal_status_pesquisarPredio() {
        return "Abrindo o pesquisar prédios...";
    }
    
    public static String principal_status_pesquisarCamera() {
        return "Abrindo o pesquisar câmeras...";
    }
    
    public static String principal_status_pesquisarModuloAcionamento() {
        return "Abrindo o pesquisar módulos de acionamento...";
    }
    
    public static String principal_status_pesquisarDispositivoEletrico() {
        return "Abrindo o pesquisar dispositivos elétricos...";
    }
    
    public static String principal_status_pesquisarMarcas() {
        return "Abrindo o pesquisar marcas...";
    }
    
    public static String principal_status_logAcoes() {
        return "Abrindo o log de ações...";
    }
    
    public static String principal_status_relatorioAgendarTarefas() {
        return "Abrindo o relatório de agendamento de tarefas...";
    }
    
    public static String principal_status_relatoriologAcoes() {
        return "Abrindo o relatório de log de ações...";
    }
    
    public static String principal_status_localizacaoGps() {
        return "Abrindo o mapa de localização GPS...";
    }
    
    public static String principal_status_reprodutorVideos() {
        return "Abrindo reprodutor de vídeos...";
    }
    
    /* Categoria: OUTROS TELA PRINCIPAL */
    
    public static String principalIniciarCameras() {
        return "Deseja iniciar as câmeras?";
    }
    
    public static String principalPararCameras() {
        return "Deseja parar as câmeras?";
    }
    
    public static String principalServidorDesconectado() {
        return "Servidor Desconectado!";
    }
    
    public static String principalTrocarUsuarios() {
        return "Deseja realmente trocar de usuário!";
    }
    
    public static String principalCamerasNaoIniciadas() {
        return "As câmeras não foram iniciadas!";
    }
    
    public static String principalCamerasPreparadas() {
        return "Câmeras preparadas com sucesso!\nAbra a tela de visualização de câmeras \n e inicie uma por uma.";
    }
    
    public static String principalEncontrarCameras() {
        return "Nenhuma câmera foi encontrada, possíveis motivos: \n"
             + " 1) OpenCV instalado incorretamente.\n"
             + " 2) Câmeras desconectadas.\n"
             + " 3) Nenhuma câmera cadastrada.";
    }
    
    public static String principalConfigGerais() {
        return "Não foi possível ler as configurações gerais!\nVá em opcões e Reconfigure,\n"
                    + "Caso Contrário, o sistema não funcionará corretamente.";
    }
    
    public static String principalConfigDispositivos() {
        return "Não foi possível configurar os dispositivos!\nVá em opcões e reconfigure os dispositivos,\n"
                    + "Caso Contrário, o sistema não funcionará corretamente.";
    }
    
    public static String principalConfigMensagens() {
        return "Não foi possível configurar as mensagens!\nVá em opcões e reconfigure as mensagens,\n"
                    + "Caso Contrário, o sistema não funcionará corretamente.";
    }
    
    public static String principalFecharSistema() {
        return "Deseja realmente fechar o Sistema?";
    }
    
    public static String principalServico() {
        return "Operação somente permitida para EletroVision Servidor.";
    }
    
    /* Categoria: LOGIN */
    
    public static String loginTentativas() {
        return "Número de tentativas esgotadas!\nO sistema será fechado.";
    }
    
    public static String loginInvalido() {
        return "Usuário ou senha inválida";
    }
    
    public static String loginAdmin() {
        return "Algumas funções não funcionam com o usuário ADMIN!\n"
                    + "É recomentado você criar o novo usuário ou entrar com um usuário válido.";
    }
    
    public static String loginPrivilegio() {
        return "Esse usuário está inativo!\n"
                    + "Por isso ele(a) não tem o privilégio de entrar no sistema.";
    }
    
/* -----------------------CADASTROS-------------------------------------------*/
    
    /* Categoria: COMUM */
    
    public static String cadComumNomeVazio() {
        return "Campo 'Nome' Vazio!";
    }
    
    public static String cadComumNomeExiste() {
        return "Nome já Exite!";
    }
    
    public static String cadComumNomeDispositivoEletrico() {
        return "Nome não pode ser igual a um Dispositivo Elétrico!";
    }
    
    public static String cadComumNomeModuloAcionamento() {
        return "Nome não pode ser igual a um Módulo de Acionamento!";
    }
    
    public static String cadComumNomeCamera() {
        return "Nome não pode ser igual a uma Câmera!";
    }
    
    public static String cadComumMarca() {
        return "Selecione uma Marca!";
    }
    
    public static String cadComumPredio() {
        return "Selecione um Prédio!";
    }
    
    public static String cadComumArea() {
        return "Selecione um Área!";
    }
    
    public static String cadComumImagem() {
        return "Selecione uma imagem!";
    }
    
    public static String cadComumEstadoSelecionar() {
        return "Selecione um estado!";
    }
    
    public static String cadComumCidadeVazia() {
        return "Campo 'Cidade' vazio!";
    }
    
    public static String cadComumBairroVazio() {
        return "Campo 'Bairro' vazio!";
    }
    
    public static String cadComumLogradouroVazio() {
        return "Campo 'Logradouro' vazio!";
    }
    
    public static String cadComumNumeroVazio() {
        return "Campo 'Número' vazio!";
    }
    
    public static String cadComumNumeroInvalido() {
        return "Campo 'Número' inválido!";
    }
    
    public static String cadComumNumeroNegativo() {
        return "Campo 'Número' não pode ser negativo!";
    }
    
    public static String cadComumReferenciaVazia() {
        return "Campo 'Referência' vazio!";
    }
    
    public static String conexaoErroModuloAcionamento(String ex) {
        return "Não foi possível conectar com o módulo de acionamento!\n"+ex;
    }
            
    /* Categoria: ÁREA */
    
    public static String cadAreaPredio() {
        return "Selecione o 'Tipo' de Prédio!";
    }
    
    public static String cadAreaSalvar() {
        return "Área salva com sucesso!";
    }
    
    /* Categoria: CÂMERAS */
    
    public static String cadCameraCameras() {
        return "Quantas câmeras estão instaladas?";
    }
    
    public static String cadCameraValor() {
        return "Valor inválido!";
    }
    
    public static String cadCameraNumero() {
        return "Digite apenas números inteiros!";
    }
  
    public static String cadCameraIdentificacaoVazia() {
        return "Campo 'Identificação' Vazio!";
    }
      
    public static String cadCameraSalvar() {
        return "Câmera salva com sucesso!";
    }
    
    public static String cadCameraQuantidade() {
        return "Quantidade de câmeras inválida!";
    }
    
    public static String cadCamerasOcupadas() {
        return "As câmeras estão ocupadas!";
    }
    
    /* Categoria: DISPOSITIVO ELÉTRICO */
    
    public static String cadDispositivoEletricoSaidasDisponiveis() {
        return "Módulo não possui saídas disponíveis!";
    }
    
    public static String cadDispositivoEletricoModulo() {
        return "Selecione uma Módulo!";
    }
    
    public static String cadDispositivoEletricoSaidaEletrica() {
        return "Selecione uma saída elétrica!";
    }
    
    public static String cadDispositivoEletricoSalvar() {
        return "Dispositivo elétrico salvo com sucesso!";
    }
    
    /* Categoria: MARCA */
    
    public static String cadMarcaSalvar() {
        return "Marca salva com sucesso!";
    }
    
    /* Categoria: MÓDULO DE ACIONAMENTO */
    
    public static String cadModuloAcionamentoIpVazio() {
        return "Campo 'IP' vazio!";
    }
    
    public static String cadModuloAcionamentoIpInvalido() {
        return "Campo 'IP' inválido!";
    }
    
    public static String cadModuloAcionamentoIpExiste() {
        return "IP já Existe!";
    }
    
    public static String cadModuloAcionamentoQtdeSaidaVazio() {
        return "Campo 'Qtde Saídas' vazio!";
    }
    
    public static String cadModuloAcionamentoQtdeSaidaNumero() {
        return "Insira no campo 'Qtde Saídas' somente números inteiros!";
    }
    
    public static String cadModuloAcionamentoQtdeSaidaInvalido() {
        return "Campo 'Qtde Saídas' inválido!";
    }
    
    public static String cadModuloAcionamentoPortaVazia() {
        return "Campo 'Porta' vazio!";
    }
    
    public static String cadModuloAcionamentoPortaNumero() {
        return "Insira no campo 'Porta' somente números inteiros!";
    }
    
    public static String cadModuloAcionamentoPortaInvalida() {
        return "Campo 'Porta' inválido!";
    }
    
    public static String cadModuloAcionamentoSalvar() {
        return "Módulo de acionamento salvo com sucesso!";
    }
    
    /* Categoria: PESSOA */
    
    public static String cadPessoaCpfVazio() {
        return "Campo 'CPF' vazio!";
    }
    
    public static String cadPessoaCpfInvalido() {
        return "Campo 'CPF' inválido!";
    }
    
    public static String cadPessoaCpfExiste() {
        return "CPF já existe!";
    }
    
    public static String cadPessoaRgVazio() {
        return "Campo 'RG' vazio!";
    }
    
    public static String cadPessoaRgInvalido() {
        return "Campo 'RG' inválido!";
    }
    
    public static String cadPessoaRgNegativo() {
        return "Campo 'RG' não pode ser negativo!";
    }
    
    public static String cadPessoaDataMaiorAtual() {
        return "Campo 'Data' não pode ser maior que data atual!";
    }
    
    public static String cadPessoaTipoPessoa() {
        return "Selecione o 'Tipo' de Pessoa!";
    }
    
    public static String cadPessoaDDDvazio() {
        return "Campo 'ddd' vazio!";
    }
    
    public static String cadPessoaCelularVazio() {
        return "Campo 'celular' vazio!";
    }
    
    public static String cadPessoaCelularExiste() {
        return "Celular já existe!";
    }
    
    public static String cadPessoaEmailInvalido() {
        return "Campo 'Email' inválido!";
    }
    
    public static String cadPessoaEmailExiste() {
        return "Email já existe!";
    }
    
    public static String cadPessoaSalvar() {
        return "Pessoa salva com sucesso!";
    }
    
    public static String cadPessoaPreencherNome() {
        return "Preencha primeiro o campo 'Nome'!";
    }
    
    /* Categoria: PRÉDIO */
    
    public static String cadPredioTipo() {
        return "Selecione um Tipo!";
    }
    
    public static String cadPredioSalvar() {
        return "Prédio salvo com sucesso!";
    }
    
    public static String cadPredioLongitude() {
        return "Longitude inválida!\nDigite a longitude em graus decimais.";
    }
    
    public static String cadPredioLatitude() {
        return "Latitude inválida!\nDigite a latitude em graus decimais.";
    }
    
    /* Categoria: USUÁRIO */
    
    public static String cadUsuarioTipo() {
        return "Selecione o 'Tipo' de Pessoa!";
    }
    
    public static String cadUsuarioLoginVazio() {
        return "Campo 'Login' vazio!";
    }
    
    public static String cadUsuarioLoginExiste() {
        return "Login já existe!";
    }
    
    public static String cadUsuarioSenhaVazia() {
        return "Campo 'Senha' vazio!";
    }
    
    public static String cadUsuarioSenhaNaoCorrespondem() {
        return "As senhas não correspondem!";
    }
    
    public static String cadUsuarioPermissao() {
        return "Selecione uma 'Autorização' ou Monte as permissões do usuário!";
    }
    
    public static String cadUsuarioSalvar() {
        return "Usuário salvo com sucesso!";
    }
    
/* -----------------------PESQUISAS-------------------------------------------*/
    
    /* Categoria: COMUNS */
    
    public static String pesqComumExcluir() {
        return "Deseja realmente excluir o(s) iten(s) selecionado(s)?";
    }
    
    /* Categoria: ÁREA */
    
    public static String pesqAreaExcluir() {
        return "Área excluída com sucesso!";
    }
    
    public static String pesqAreaSelecionar() {
        return "Selecione uma Área!";
    }
    
    /* Categoria: Câmera */
    
    public static String pesqCameraExcluir() {
        return "Câmera excluída com sucesso!";
    }
    
    public static String pesqCameraSelecionar() {
        return "Selecione uma Câmera!";
    }
    
    /* Categoria: DISPOSITIVO ELÉTRICO */
    
    public static String pesqDispositivoEletricoExcluir() {
        return "Dispositivo Elétrico excluído com sucesso!";
    }
    
    public static String pesqDispositivoEletricoSelecionar() {
        return "Selecione um Dispositivo Elétrico!";
    }
    
    /* Categoria: MARCA */
    
    public static String pesqMarcaExcluir() {
        return "Marca excluída com sucesso!";
    }
    
    public static String pesqMarcaSelecionar() {
        return "Selecione uma Marca!";
    }
    
    /* Categoria: MÓDULO DE ACIONAMENTO */
    
    public static String pesqModuloAcionamentoExcluir() {
        return "Módulo Acionamento excluído com sucesso!";
    }
    
    public static String pesqModuloAcionamentoSelecionar() {
        return "Selecione um Módulo Acionamento!";
    }
    
    /* Categoria: PESSOA */
    
    public static String pesqPessoaExcluir() {
        return "Pessoa excluída com sucesso!";
    }
    
    public static String pesqPessoaSelecionar() {
        return "Selecione uma Pessoa!";
    }
    
    /* Categoria: PRÉDIO */
    
    public static String pesqPredioExcluir() {
        return "Prédio excluído com sucesso!";
    }
    
    public static String pesqPredioSelecionar() {
        return "Selecione um Prédio!";
    }
    
    /* Categoria: USUÁRIO */
    
    public static String pesqUsuarioExcluir() {
        return "Usuário excluído com sucesso!";
    }
    
    public static String pesqUsuarioSelecionar() {
        return "Selecione um Usuário!";
    }
    
/* -----------------------FERRAMENTAS-----------------------------------------*/
    
    /* Categoria: DESENHAR */
    
    public static String ferrLimparTudo() {
        return "Deseja realmente limpar tudo?";
    }
    
    public static String ferrImagemSalvar() {
        return "Imagem salva com sucesso!";
    }
    
    public static String ferrMapaPergunta() {
        return "Qual o nome do mapa?";
    }
    
    public static String ferrMapa() {
        return "mapa";
    }
    
    /* Categoria: EDITAR IMAGEM */
    
    public static String ferrImagemPergunta() {
        return "Deseja salvar esta imagem?";
    }
    
    public static String ferrDestino() {
        return "Escolha o destino";
    }
    
    public static String ferrNomeImagem() {
        return "Informe o nome da imagem.";
    }
    
    public static String ferrDiretorio() {
        return "Escolha um diretório";
    }
    
    public static String ferrExcluirPerguntar() {
        return "Deseja realmente excluir";
    } 
    
    public static String ferrExcluirSucesso() {
        return "Arquivo excluído com sucesso!";
    }
    
    public static String ferrExcluirErro() {
        return "Arquivo ocupado, não foi possível excluí-lo!";
    }
    
    public static String ferrDefinirMapa(String nome) {
        return "Deseja relamente definir '" + nome + "' como mapa principal?";
    }
    
    public static String ferrMapaDefinido() {
        return "Mapa definido com sucesso!";
    }
    
    public static String ferrNomePasta() {
        return "Nome da pasta:";
    }
    
    public static String ferrPasta() {
        return "pasta";
    }
    
    public static String ferrImagemAlterada() {
        return "Deseja salvar a imagem alterada?";
    }
    
    /* Categoria: OPÇÕES */
    
    public static String ferrConexaoEstabelecida() {
        return "Conexão estabelecida!";
    }
    
    public static String ferrOpcoesPorta() {
        return "Preencha o campo 'Porta'!";
    }
    
    public static String ferrOpcoesLargura() {
        return "Campo 'LARGURA' inválido!";
    }
    
    public static String ferrOpcoesAltura() {
        return "Campo 'ALTURA' inválido!";
    }
    
    public static String ferrOpcoesIntervaloProcessamento() {
        return "Campo 'Inteampo rvalo de Processamento' inválido!";
    }
    
    public static String ferrOpcoesControleAutomatico() {
        return "'Tempo ocioso do controle automático' inválido!";
    }
    
    public static String ferrOpcoesCodec() {
        return "'Codec' inválido!";
    }
    
    public static String ferrOpcoesNome() {
        return "Preencha o campo 'NOME'!";
    }
    
    public static String ferrOpcoesHost() {
        return "Preencha o campo 'HOST'!";
    }
    
    public static String ferrOpcoesPortaInvalida() {
        return "Campo 'PORTA' inválido!";
    }
    
    public static String ferrOpcoesUsuario() {
        return "Preencha o campo 'USUÁRIO'!";
    }
    
    public static String ferrOpcoesSenha() {
        return "Preencha o campo 'SENHA'!";
    }
    
    public static String ferrOpcoesTempoCaptura() {
        return "Campo 'TEMPO DE CAPTURA' inválido!";
    }
    
    public static String ferrOpcoesSalvas() {
        return "Configurações salvas com sucesso!";
    }
    
    public static String ferrOpcoesReiniciar() {
        return "Essas configurações exigem a reinicialização do EletroVision \n"
                + "Deseja sair do EletroVision agora?";
    }
    
    /* Categoria: Reproduto de Vídeos */
    
    public static String ferrVideoSalvo() {
        return "Vídeo salvo com sucesso!";
    }
    
/* -----------------------GERAL-----------------------------------------------*/
    
    /* Categoria: AGENDAR TAREFAS */
    
    public static String gerAgendAtivarDesativar(String nome) {
        return "Deseja realmente "+nome+" esse agendamento?";
    }
    
    public static String gerAgendSelecionarAgendamento() {
        return "Selecione um agendamento!";
    }
    
    public static String gerAgendSelecionarItem() {
        return "Selecione um item!";
    }
    
    public static String gerAgendDescricao() {
        return "Campo 'Descrição' vazio!";
    }
    
    public static String gerAgendTipo() {
        return "Escolha um Tipo!";
    }
    
    public static String gerAgendAcao() {
        return "Escolha uma Ação!";
    }
    
    public static String gerAgendItemExcluido() {
        return "Item(s) excluído(s) com sucesso!";
    }
    
    public static String gerAgendMes() {
        return "Escolha um Mês!";
    }
    
    public static String gerAgendDia() {
        return "Escolha um Dia!";
    }
    
    public static String gerAgendHora() {
        return "Escolha um Hora!";
    }
    
    public static String gerAgendMinuto() {
        return "Escolha um Minuto!";
    }
    
    public static String gerAgendSegundo() {
        return "Escolha um Segundo!";
    }
    
    public static String gerAgendConfirmacao() {
        return "Confirma a configuração de agendamento?";
    }
    
    public static String gerAgendSalvar() {
        return "Agendamento salvo com sucesso!";
    }
    
    public static String gerAgendExcluirAgendamento() {
        return "Deseja realmente deletar o agendamento?";
    }
    
    public static String gerAgendTabelaVazia() {
        return "Tabela vazia!";
    }
    
    public static String gerSelecionarUsuarioGps() {
        return "Selecione um usuário conectado!";
    }
    
    /* Categoria: CENÁRIO */
    
    public static String gerCenarioExcluir() {
        return "Deseja realmente excluir esse cenário?";
    }
    
    public static String gerCenarioNome() {
        return "Informe o 'Nome'!";
    }
    
    public static String gerCenarioImagem() {
        return "Escolha uma imagem!";
    }
    
    public static String gerCenarioDispositivoEletrico() {
        return "Cenário sem nenhum dispositivo elétrico!";
    }
    
    public static String gerCenarioNomeExiste() {
        return "Já existe cenário com esse nome!";
    }
    
    public static String gerCenarioConfigAcionamento() {
        return "Acionamento configurado para não ligar.\n"
                + " 1) Verifique se existe um módulo de acionamento conectado.";
    }
    
    public static String gerCenarioPredio() {
        return "Selecione um prédio para o alarme!";
    }
    
    /* Categoria: DISPOSITIVOS */
    
    public static String gerDispositivosCameras() {
        return "As câmeras não foram iniciadas!";
    }
    
    public static String gerDispositivosConfiguracao() {
        return "Confirma a configuração de processamento da câmera?";
    }
    
    public static String gerDispositivosConfiguracaoSalvar() {
        return "Configuração salva com sucesso!";
    }
    
    public static String gerDispositivosErroAcionar() {
        return "Não foi possível acionar dispositivo!";
    }
    
    public static String gerDispositivosDesativado() {
        return "Dispositivo desativado!";
    }
    
    /* Categoria: GPS */
    
    public static String gerGpsSalvarPonto() {
        return "Ponto salvo!";
    }
    
    /* Categoria: LOG ACOES */
    
    public static String gerLogSelecionarMovimento() {
        return "Selecione um movimento!";
    }
    
    /* Categoria: MENSAGENS */
    
    public static String gerMsgPessoa() {
        return "Selecione uma 'Pessoa'!";
    }
    
    public static String gerMsgAssunto() {
        return "Preencha o campo 'Assunto'!";
    }
    
    public static String gerMsgMensagem() {
        return "Preencha o campo 'Mensagem'!";
    }
    
    public static String gerMsgExibicao() {
        return "Selecione uma 'Exibição'!";
    }
    
    public static String gerMsgSalvar() {
        return "Mensagem salva com sucesso!";
    }
    
    public static String gerMsgVincular() {
        return "Agendamento vinculado com sucesso!";
    }
    
    /* Categoria: VISUALIZAR CAMERAS */
    
    public static String gerVisualClienteDesconectado() {
        return "Cliente desconectado!";
    }
    
/* -----------------------COMUNS----------------------------------------------*/
    
    public static String comumEscolherCamera() {
        return "Escolha a câmera.";
    }
    
    public static String comumNenhumaCameraCadastrada() {
        return "Nenhuma câmera cadastrada!";
    }
    
    public static String comumAproximacao() {
        return "Aproximação";
    }
    
    public static String comumQtdeFaces() {
        return "A quantidade de faces deve ser no mínimo 3 e no máximo 5!";
    }
    
    public static String comumConfirmar() {
        return "Deseja realmente confirmar?";
    }
    
    public static String comumSalvar() {
        return "Faces cadastradas com sucesso!";
    }
    
    public static String comumPararCamera() {
        return "Deseja realmente parar essa câmera?";
    }
    
    public static String comumDesativarGravacao() {
        return "Gravação desativada!";
    }
    
    public static String comumFacesInvalidas() {
        return "Número de arquivos na base de dados de faces inválidos!";
    }
    
    public static String comumFoto() {
        return "Foto";
    }
    
    public static String comumGravacao() {
        return "Gravação";
    }
    
    public static String comumGravacaoConfirmar() {
       return "O que você quer salvar?";
    }
    
    public static String comumImagemSalvar() {
       return "Imagem salva com sucesso!";
    }
    
    public static String comumGravacaoSalvar() {
       return "Gravação salva com sucesso!";
    }
    
    public static String comumGravacaoParar() {
       return "A gravação deve ser parada!";
    }
    
    public static String comumFilterImagens() {
       return "Apenas Imagens";
    }
    
    public static String comumImagemInvalida() {
       return "Imagem inválida!";
    }
    
    public static String comumArquivoSalvar() {
       return "Arquivo salvo com sucesso!";
    }
    
    public static String comumHibernateCFG() {
       return "Não foi possível alterar o HibernateCFG!\nMotivo: Documento XML não carregado!";
    } 
    
    public static String comumIniciandoCameras() {
       return "Iniciando câmeras...";
    }
    
    public static String comumInicializando() {
       return "Inicializando...";
    }
    
    public static String comumProduzidoPor() {
       return "Produzido por: WESLLEN e HENDRIO";
    }
    
    public static String comumDireitos() {
       return "Todos os direitos reservados";
    }
    
/* -----------------------ELETROVISION PORTÁTIL-------------------------------*/
    
    public static String portatilFotoCapturada() {
       return "Imagem vazia!";
    }
    
    public static String portatilCamerasDesligadas() {
       return "As câmeras estão desligadas!";
    }
    
    public static String portatilCameraDesativada() {
       return "Câmera desativada!";
    }
    
    public static String portatilErroDispositivo() {
       return "Erro ao ativar o dispositivo!";
    }
    
    public static String portatilDispositivoSucesso() {
       return "Dispositivo ativo com sucesso!";
    }
    
    public static String portatilAcionamentoDesativado() {
       return "Acionamento desativado!";
    }
    
    public static String portatilMensagemEnviada() {
       return "Mensagem enviada com sucesso!";
    }
    
    public static String portatilDesconectado() {
       return "Você não está conectado!";
    }
    
    public static String portatilDesconectarConfirmar() {
       return "Deseja realmente desconectar?";
    }
    
    public static String portatilConfiguracaoCamera() {
       return "Confirma a configuração de processamento da câmera?";
    }
    
    public static String portatilConfiguracoesAlteradas() {
       return "Configurações alteradas com sucesso!";
    }
    
    public static String portatilConfiguracaoCenario() {
       return "Confirma a configuração do cenário?";
    }
    
    public static String portatilDesconectarContato(String nome) {
       return "Deseja realmente desconectar o(a) "+nome+"?";
    }
    
    public static String portatilSelecionarContato() {
       return "Selecione um contato!";
    }
    
    public static String portatilConexaoSucesso() {
       return "Conexão realizada com sucesso!";
    }
    
    public static String portatilUsuarioLogado() {
       return "O usuário solicitado já está logado no sistema!";
    }
    
    public static String portatilUltimaFoto() {
       return "Última foto indisponível!"; 
    }
    
    public static String portatilGpsDesligado() {
       return "GPS do usuário desligado!"; 
    }
     
 /*=============================================================================
 * =====================UTIL====================================================
 * ===========================================================================*/
        
    public static String diretorioSubstituir() {
        return "Diretório ou arquivo existente, Deseja substituir?";
    }
    
    public static String sistemaOperacionalIdentificar() {
        return "Não foi possível identificar o Sistema Operacional";
    }
    
}
