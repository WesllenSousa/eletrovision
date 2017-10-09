package entidades.autorizacao.facade;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.autorizacao.dao.AutorizacaoDaoImpl;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class AutorizacaoFacadeImpl implements AutorizacaoFacade {

    private AutorizacaoDaoImpl autorizacaoDaoImpl;

    public AutorizacaoFacadeImpl() {
        if (autorizacaoDaoImpl == null) {
            autorizacaoDaoImpl = new AutorizacaoDaoImpl();
        }
    }

    @Override
    public AutorizacaoBean inserir(AutorizacaoBean obj) throws FacadeException {
        try {
            return autorizacaoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AutorizacaoBean alterar(AutorizacaoBean obj) throws FacadeException {
        try {
            return autorizacaoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(AutorizacaoBean obj) throws FacadeException {
        try {
            return autorizacaoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<AutorizacaoBean> listar() throws FacadeException {
        try {
            return autorizacaoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AutorizacaoBean selecionar(Integer id) throws FacadeException {
        try {
            return autorizacaoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AutorizacaoBean insereOuAltera(AutorizacaoBean obj) throws FacadeException {
        try {
            return autorizacaoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AutorizacaoBean> listarAutorizacaoOrdenadaPorNome() throws FacadeException {
        try {
            return autorizacaoDaoImpl.listarAutorizacaoOrdenadaPorNome();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
