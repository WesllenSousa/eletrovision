package entidades.marca.facade;

import entidades.marca.bean.MarcaBean;
import entidades.marca.dao.MarcaDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class MarcaFacadeImpl implements MarcaFacade {

    private MarcaDaoImpl marcaDaoImpl;

    public MarcaFacadeImpl() {

        if (marcaDaoImpl == null) {
            marcaDaoImpl = new MarcaDaoImpl();
        }
    }

    @Override
    public MarcaBean inserir(MarcaBean obj) throws FacadeException {
        try {
            return marcaDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MarcaBean alterar(MarcaBean obj) throws FacadeException {
        try {
            return marcaDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(MarcaBean obj) throws FacadeException {
        try {
            return marcaDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<MarcaBean> listar() throws FacadeException {
        try {
            return marcaDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MarcaBean selecionar(Integer id) throws FacadeException {
        try {
            return marcaDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MarcaBean insereOuAltera(MarcaBean obj) throws FacadeException {
        try {
            return marcaDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MarcaBean> listarMarcaOrdenadaPorCodigo() throws FacadeException {
        try {
            return marcaDaoImpl.listarMarcaOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
