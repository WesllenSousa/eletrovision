package util;

import entidades.acaoAgendamento.facade.AcaoAgendamentoFacade;
import entidades.acaoAgendamento.facade.AcaoAgendamentoFacadeImpl;
import entidades.acesso.facade.AcessoFacade;
import entidades.acesso.facade.AcessoFacadeImpl;
import entidades.acionamento.facade.AcionamentoFacade;
import entidades.acionamento.facade.AcionamentoFacadeImpl;
import entidades.agendarTarefas.facade.AgendarTarefasFacade;
import entidades.agendarTarefas.facade.AgendarTarefasFacadeImpl;
import entidades.autorizacao.facade.AutorizacaoFacade;
import entidades.autorizacao.facade.AutorizacaoFacadeImpl;
import entidades.camera.facade.CameraFacade;
import entidades.camera.facade.CameraFacadeImpl;
import entidades.configCamera.facade.ConfigCameraFacade;
import entidades.configCamera.facade.ConfigCameraFacadeImpl;
import entidades.dispositivo.facade.DispositivoFacade;
import entidades.dispositivo.facade.DispositivoFacadeImpl;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacade;
import entidades.dispositivoEletrico.facade.DispositivoEletricoFacadeImpl;
import entidades.email.facade.EmailFacade;
import entidades.email.facade.EmailFacadeImpl;
import entidades.endereco.facade.EnderecoFacade;
import entidades.endereco.facade.EnderecoFacadeImpl;
import entidades.itemAcionamento.facade.ItemAcionamentoFacade;
import entidades.itemAcionamento.facade.ItemAcionamentoFacadeImpl;
import entidades.area.facade.AreaFacade;
import entidades.area.facade.AreaFacadeImpl;
import entidades.configPessoa.facade.ConfigPessoaFacade;
import entidades.configPessoa.facade.ConfigPessoaFacadeImpl;
import entidades.configPredio.facade.ConfigPredioFacade;
import entidades.configPredio.facade.ConfigPredioFacadeImpl;
import entidades.logAcoes.facade.LogAcoesFacade;
import entidades.logAcoes.facade.LogAcoesFacadeImpl;
import entidades.marca.facade.MarcaFacade;
import entidades.marca.facade.MarcaFacadeImpl;
import entidades.mensagem.facade.MensagemFacade;
import entidades.mensagem.facade.MensagemFacadeImpl;
import entidades.modulo.facade.ModuloFacade;
import entidades.modulo.facade.ModuloFacadeImpl;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacade;
import entidades.moduloAcionamento.facade.ModuloAcionamentoFacadeImpl;
import entidades.movimento.facade.MovimentoFacade;
import entidades.movimento.facade.MovimentoFacadeImpl;
import entidades.pessoa.facade.PessoaFacade;
import entidades.pessoa.facade.PessoaFacadeImpl;
import entidades.predio.facade.PredioFacade;
import entidades.predio.facade.PredioFacadeImpl;
import entidades.telefone.facade.TelefoneFacade;
import entidades.telefone.facade.TelefoneFacadeImpl;
import entidades.usuario.facade.UsuarioFacade;
import entidades.usuario.facade.UsuarioFacadeImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class FactoryFacade {

    //ORDENADOS EM ORDEM ALFABETICA
    public static AcessoFacade getAcessoFacadeImpl() {
        return new AcessoFacadeImpl();
    }

    public static AcionamentoFacade getAcionamentoImpl() {
        return new AcionamentoFacadeImpl();
    }

    public static AgendarTarefasFacade getAgendarTarefasFacadeImpl() {
        return new AgendarTarefasFacadeImpl();
    }

    public static AutorizacaoFacade getAutorizacaoImpl() {
        return new AutorizacaoFacadeImpl();
    }

    public static CameraFacade getCameraImpl() {
        return new CameraFacadeImpl();
    }

    public static ConfigCameraFacade getConfigCameraImpl() {
        return new ConfigCameraFacadeImpl();
    }

    public static DispositivoFacade getDispositivoImpl() {
        return new DispositivoFacadeImpl();
    }

    public static DispositivoEletricoFacade getDispositivoEletricoImpl() {
        return new DispositivoEletricoFacadeImpl();
    }

    public static EmailFacade getEmailImpl() {
        return new EmailFacadeImpl();
    }

    public static EnderecoFacade getEnderecoImpl() {
        return new EnderecoFacadeImpl();
    }

    public static ItemAcionamentoFacade getItemAcionamentoImpl() {
        return new ItemAcionamentoFacadeImpl();
    }

    public static AreaFacade getAreaImpl() {
        return new AreaFacadeImpl();
    }

    public static LogAcoesFacade getLogAcoesImpl() {
        return new LogAcoesFacadeImpl();
    }

    public static MarcaFacade getMarcaImpl() {
        return new MarcaFacadeImpl();
    }

    public static MensagemFacade getMensagemImpl() {
        return new MensagemFacadeImpl();
    }

    public static ModuloFacade getModuloImpl() {
        return new ModuloFacadeImpl();
    }

    public static ModuloAcionamentoFacade getModuloAcionamentoImpl() {
        return new ModuloAcionamentoFacadeImpl();
    }

    public static MovimentoFacade getMovimentoImpl() {
        return new MovimentoFacadeImpl();
    }

    public static PessoaFacade getPessoaImpl() {
        return new PessoaFacadeImpl();
    }

    public static PredioFacade getPredioImpl() {
        return new PredioFacadeImpl();
    }

    public static TelefoneFacade getTelefoneFacadeImpl() {
        return new TelefoneFacadeImpl();
    }

    public static UsuarioFacade getUsuarioImpl() {
        return new UsuarioFacadeImpl();
    }
    
    public static AcaoAgendamentoFacade getAcaoAgendamentoFacadeImpl() {
        return new AcaoAgendamentoFacadeImpl();
    }
    
    public static ConfigPessoaFacade getConfigPessoaFacadeImpl() {
        return new ConfigPessoaFacadeImpl();
    }
    
    public static ConfigPredioFacade getConfigPredioFacadeImpl() {
        return new ConfigPredioFacadeImpl();
    }
    
}
