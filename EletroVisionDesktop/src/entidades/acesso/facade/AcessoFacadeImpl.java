package entidades.acesso.facade;

import entidades.acesso.bean.AcessoBean;
import entidades.acesso.dao.AcessoDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class AcessoFacadeImpl implements AcessoFacade {

    private AcessoDaoImpl acessoDaoImpl;

    public AcessoFacadeImpl() {
        if (acessoDaoImpl == null) {
            acessoDaoImpl = new AcessoDaoImpl();
        }
    }

    @Override
    public AcessoBean inserir(AcessoBean obj) throws FacadeException {
        try {
            return acessoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcessoBean alterar(AcessoBean obj) throws FacadeException {
        try {
            return acessoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(AcessoBean obj) throws FacadeException {
        try {
            return acessoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<AcessoBean> listar() throws FacadeException {
       try {
            return acessoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcessoBean selecionar(Integer id) throws FacadeException {
       try {
            return acessoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcessoBean insereOuAltera(AcessoBean obj) throws FacadeException {
        try {
            return acessoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AcessoBean> listarAcessosOrdenadoPorData() throws FacadeException {
        try {
            return acessoDaoImpl.listarAcessosOrdenadoPorData();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
