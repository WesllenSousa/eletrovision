package entidades.movimento.facade;

import entidades.movimento.bean.MovimentoBean;
import entidades.movimento.dao.MovimentoDaoImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class MovimentoFacadeImpl implements MovimentoFacade {

    private MovimentoDaoImpl movimentoDaoImpl;

    public MovimentoFacadeImpl() {
        if (movimentoDaoImpl == null) {
            movimentoDaoImpl = new MovimentoDaoImpl();
        }
    }

    @Override
    public MovimentoBean inserir(MovimentoBean obj) throws FacadeException {
         try {
            return movimentoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MovimentoBean alterar(MovimentoBean obj) throws FacadeException {
        try {
            return movimentoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(MovimentoBean obj) throws FacadeException {
        try {
            return movimentoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<MovimentoBean> listar() throws FacadeException {
        try {
            return movimentoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MovimentoBean selecionar(Integer id) throws FacadeException {
        try {
            return movimentoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MovimentoBean insereOuAltera(MovimentoBean obj) throws FacadeException {
        try {
            return movimentoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MovimentoBean> listarMovimentoOrdenadoPorData() throws FacadeException {
        try {
            return movimentoDaoImpl.listarMovimentoOrdenadoPorData();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MovimentoBean listarUltimoRegistro() throws FacadeException {
        try {
            return movimentoDaoImpl.listarUltimoRegistro();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MovimentoBean> listarMovimentoCriteria(Integer codigo, Calendar dataInicio, 
            Calendar dataFim) throws FacadeException {
        try {
            return movimentoDaoImpl.listarMovimentoCriteria(codigo, dataInicio, dataFim);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
