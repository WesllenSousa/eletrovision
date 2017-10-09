package entidades.predio.facade;

import entidades.predio.bean.EnumDeletadoPredio;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import entidades.predio.dao.PredioDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class PredioFacadeImpl implements PredioFacade {

    private PredioDaoImpl predioDaoImpl;

    public PredioFacadeImpl() {
        if (predioDaoImpl == null) {
            predioDaoImpl = new PredioDaoImpl();
        }
    }

    @Override
    public PredioBean inserir(PredioBean obj) throws FacadeException {
        try {
            return predioDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public PredioBean alterar(PredioBean obj) throws FacadeException {
        try {
            return predioDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(PredioBean obj) throws FacadeException {
        try {
            return predioDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<PredioBean> listar() throws FacadeException {
        try {
            return predioDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public PredioBean selecionar(Integer id) throws FacadeException {
        try {
            return predioDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public PredioBean insereOuAltera(PredioBean obj) throws FacadeException {
        try {
            return predioDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PredioBean> listarPredioOrdenadaPorCodigo() throws FacadeException {
        try {
            return predioDaoImpl.listarPredioOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PredioBean> listarPredioNaoDeletado() throws FacadeException {
        try {
            return predioDaoImpl.listarPredioNaoDeletado();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PredioBean> listarPredioCriteria(Integer codigo, EnumTipoPredio tipo, EnumDeletadoPredio deletado) throws FacadeException {
        try {
            return predioDaoImpl.listarPredioCriteria(codigo, tipo, deletado);
        } catch (DaoException ex) { 
        }
        return null;
    }
    
}
