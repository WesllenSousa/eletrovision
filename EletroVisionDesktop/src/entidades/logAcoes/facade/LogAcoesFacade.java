package entidades.logAcoes.facade;

import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import java.util.Calendar;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface LogAcoesFacade extends BaseFacade<LogAcoesBean> {
    
    public ArrayList<LogAcoesBean> listarlogAcoesOrdenadoPorData() throws FacadeException;
    public ArrayList<LogAcoesBean> listarlogAcoesAcionamentoOrdenadoPorData() throws FacadeException;
    public ArrayList<LogAcoesBean> listarlogAcoesDispositivoEletricoOrdenadoPorData() throws FacadeException;
    public ArrayList<LogAcoesBean> listarlogAcoesAgendarTarefasOrdenadoPorData() throws FacadeException;
    public ArrayList<LogAcoesBean> listarLogAcoesCriteria(Integer codigo,
            EnumRedeLogAcoes rede, Calendar dataInicio, Calendar dataFim,
            PessoaBean pessoa) throws FacadeException;
    
}
