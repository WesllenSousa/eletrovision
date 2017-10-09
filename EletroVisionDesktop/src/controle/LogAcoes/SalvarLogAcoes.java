
package controle.LogAcoes;

import EletroVisionPortatil.dependencias.InstanciasPortatil;
import recursos.configuracoes.sistema.ConfigMensagens;
import controle.mensagens.sistema.MontarMensagens;
import recursos.constantes.ConstantesRedes;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.bean.EnumLigarDesligarDispositivoEletrico;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.logAcoes.facade.LogAcoesFacade;
import entidades.pessoa.bean.PessoaBean;
import java.util.Calendar;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class SalvarLogAcoes {
    
    public SalvarLogAcoes() {
    }
    
    public void salvarAcionamento(AcionamentoBean acionamento, PessoaBean pessoa, EnumRedeLogAcoes enumRede) {
        String mensagem = montarMensagemAcionamento(acionamento, pessoa);
        salvarLog(populaLogAcoesBean(acionamento, enumRede, pessoa, mensagem));
        enviarMensagemRede(mensagem, ConstantesRedes.TP_CENARIO_ACIONADO);
    }
    
    private String montarMensagemAcionamento(AcionamentoBean acionamento, PessoaBean pessoa) {
        String msg;
        if (acionamento.getLigarDesligar() == EnumLigarDesligarAcionamento.LIGADO) {
            msg = MontarMensagens.acionamentoLigado(pessoa, acionamento);
        } else {
            msg = MontarMensagens.acionamentoDesligado(pessoa, acionamento);
        }
        return msg;
    }
    
    private LogAcoesBean populaLogAcoesBean(AcionamentoBean acionamento, EnumRedeLogAcoes enumRede,
            PessoaBean pessoa, String mensagem) {
        LogAcoesBean logAcoes = new LogAcoesBean();
        
        logAcoes.setAcionamento(acionamento);
        logAcoes.setDataHora(Calendar.getInstance());
        logAcoes.setDescricao(mensagem);
        logAcoes.setRede(enumRede);
        logAcoes.setResponsavel(pessoa);
        
        return logAcoes;
    }
    
    public void salvarDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico, PessoaBean pessoa, EnumRedeLogAcoes enumRede) {
        String mensagem = montarMensagemDispositivoEletrico(dispositivoEletrico, pessoa);
        salvarLog(populaLogAcoesBean(dispositivoEletrico, enumRede, pessoa, mensagem));
        enviarMensagemRede(mensagem, ConstantesRedes.TP_DISPOSITIVO_LIGADO);
    }
    
    private String montarMensagemDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico, PessoaBean pessoa) {
        String msg;
        if (dispositivoEletrico.getLigarDesligar() == EnumLigarDesligarDispositivoEletrico.LIGADO) {
            msg = MontarMensagens.dispositivoLigado(pessoa, dispositivoEletrico);
        } else {
            msg = MontarMensagens.dispositivoDesligado(pessoa, dispositivoEletrico);
        }
        return msg;
    }
    
    private LogAcoesBean populaLogAcoesBean(DispositivoEletricoBean dispositivoEletrico, EnumRedeLogAcoes enumRede, 
            PessoaBean pessoa, String mensagem) {
        LogAcoesBean logAcoes = new LogAcoesBean();
        
        logAcoes.setDispositivoEletrico(dispositivoEletrico);
        logAcoes.setDataHora(Calendar.getInstance());
        logAcoes.setDescricao(mensagem);
        logAcoes.setRede(enumRede);
        logAcoes.setResponsavel(pessoa);
        
        return logAcoes;
    }
    
    public void salvarAgendarTarefas(AgendarTarefasBean agendarTarefas, PessoaBean pessoa) {
        String mensagem = montarMensagemAgendarTarefas(agendarTarefas, pessoa);
        salvarLog(populaLogAcoesBean(agendarTarefas, null, pessoa, mensagem));
        enviarMensagemRede(mensagem, ConstantesRedes.TP_AGENDAMENTO_DISPARADO);
    }
    
    private String montarMensagemAgendarTarefas(AgendarTarefasBean agendarTarefas, PessoaBean pessoa) {
        return MontarMensagens.agendamentoTarefas(agendarTarefas, pessoa);
    }
    
    private LogAcoesBean populaLogAcoesBean(AgendarTarefasBean agendarTarefas, EnumRedeLogAcoes enumRede,
            PessoaBean pessoa, String mensagem) {
        LogAcoesBean logAcoes = new LogAcoesBean();
        
        logAcoes.setAgendarTarefas(agendarTarefas);
        logAcoes.setDataHora(Calendar.getInstance());
        logAcoes.setDescricao(mensagem);
        if(enumRede != null) {
            logAcoes.setRede(enumRede);
        }
        logAcoes.setResponsavel(pessoa);
        
        return logAcoes;
    }
    
    private void salvarLog(LogAcoesBean log) {
        LogAcoesFacade logAcoesFacade = FactoryFacade.getLogAcoesImpl();
        try {
            logAcoesFacade.inserir(log);
        } catch (FacadeException ex) {
        }
    }
    
    private void enviarMensagemRede(String mensagem, String tipo) {
        if(InstanciasPortatil.getCliente() != null && ConfigMensagens.getAtivarEnvioRede()) {
            InstanciasPortatil.getCliente().enviarDados(ConstantesRedes.CS_MENSAGEM);
            InstanciasPortatil.getCliente().enviarDados(mensagem);
            InstanciasPortatil.getCliente().enviarDados(tipo);
        }
    }
    
}
