package entidades.logAcoes.facade;

import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.logAcoes.dao.LogAcoesDaoImpl;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class LogAcoesFacadeImpl implements LogAcoesFacade {

    private LogAcoesDaoImpl logAcoesDaoImpl;

    public LogAcoesFacadeImpl() {
        if (logAcoesDaoImpl == null) {
            logAcoesDaoImpl = new LogAcoesDaoImpl();
        }
    }

    @Override
    public LogAcoesBean inserir(LogAcoesBean obj) throws FacadeException {
        try {
            return logAcoesDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public LogAcoesBean alterar(LogAcoesBean obj) throws FacadeException {
        try {
            return logAcoesDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(LogAcoesBean obj) throws FacadeException {
        try {
            return logAcoesDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<LogAcoesBean> listar() throws FacadeException {
        try {
            return logAcoesDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public LogAcoesBean selecionar(Integer id) throws FacadeException {
        try {
            return logAcoesDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public LogAcoesBean insereOuAltera(LogAcoesBean obj) throws FacadeException {
        try {
            return logAcoesDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<LogAcoesBean> listarlogAcoesOrdenadoPorData() throws FacadeException {
        try {
            return logAcoesDaoImpl.listarlogAcoesOrdenadoPorData();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<LogAcoesBean> listarlogAcoesAcionamentoOrdenadoPorData() throws FacadeException {
        try {
            return logAcoesDaoImpl.listarlogAcoesAcionamentoOrdenadoPorData();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<LogAcoesBean> listarlogAcoesDispositivoEletricoOrdenadoPorData() throws FacadeException {
        try {
            return logAcoesDaoImpl.listarlogAcoesDispositivoEletricoOrdenadoPorData();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<LogAcoesBean> listarlogAcoesAgendarTarefasOrdenadoPorData() throws FacadeException {
        try {
            return logAcoesDaoImpl.listarlogAcoesAgendarTarefasOrdenadoPorData();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<LogAcoesBean> listarLogAcoesCriteria(Integer codigo, EnumRedeLogAcoes rede, Calendar dataInicio, 
        Calendar dataFim, PessoaBean pessoa) throws FacadeException {
        try {
            return logAcoesDaoImpl.listarLogAcoesCriteria(codigo, rede, dataInicio, dataFim, pessoa);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
