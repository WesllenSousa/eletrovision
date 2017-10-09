package entidades.logAcoes.dao;

import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import java.util.Calendar;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface  LogAcoesDao extends BaseDao<LogAcoesBean> {
    
    public ArrayList<LogAcoesBean> listarlogAcoesOrdenadoPorData() throws DaoException;
    public ArrayList<LogAcoesBean> listarlogAcoesAcionamentoOrdenadoPorData() throws DaoException;
    public ArrayList<LogAcoesBean> listarlogAcoesDispositivoEletricoOrdenadoPorData() throws DaoException;
    public ArrayList<LogAcoesBean> listarlogAcoesAgendarTarefasOrdenadoPorData() throws DaoException;
    public ArrayList<LogAcoesBean> listarLogAcoesCriteria(Integer codigo,
            EnumRedeLogAcoes rede, Calendar dataInicio, Calendar dataFim,
            PessoaBean pessoa) throws DaoException;
    
}
