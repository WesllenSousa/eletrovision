package entidades.area.facade;

import entidades.area.bean.AreaBean;
import entidades.area.dao.AreaDaoImpl;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class AreaFacadeImpl implements AreaFacade {

    private AreaDaoImpl localDaoImpl;

    public AreaFacadeImpl() {
        if (localDaoImpl == null) {
            localDaoImpl = new AreaDaoImpl();
        }
    }

    @Override
    public AreaBean inserir(AreaBean obj) throws FacadeException {
        try {
            return localDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AreaBean alterar(AreaBean obj) throws FacadeException {
        try {
            return localDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(AreaBean obj) throws FacadeException {
        try {
            return localDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<AreaBean> listar() throws FacadeException {
        try {
            return localDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AreaBean selecionar(Integer id) throws FacadeException {
        try {
            return localDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AreaBean insereOuAltera(AreaBean obj) throws FacadeException {
        try {
            return localDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AreaBean> listarAreaOrdenadaPorCodigo() throws FacadeException {
        try {
            return localDaoImpl.listarAreaOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AreaBean> pesquisarAreaPorPredio(PredioBean predio) throws FacadeException {
        try {
            return localDaoImpl.pesquisarAreaPorPredio(predio);
        } catch (DaoException ex) {
        }
        return null;
    }
    
} 
