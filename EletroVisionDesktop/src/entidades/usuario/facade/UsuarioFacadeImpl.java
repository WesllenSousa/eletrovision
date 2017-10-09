package entidades.usuario.facade;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.usuario.bean.UsuarioBean;
import entidades.usuario.dao.UsuarioDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class UsuarioFacadeImpl implements UsuarioFacade {

    private UsuarioDaoImpl usuarioDaoImpl;

    public UsuarioFacadeImpl() {
        if (usuarioDaoImpl == null) {
            usuarioDaoImpl = new UsuarioDaoImpl();
        }
    }

    @Override
    public UsuarioBean inserir(UsuarioBean obj) throws FacadeException {
        try {
            return usuarioDaoImpl.inserir(obj);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public UsuarioBean alterar(UsuarioBean obj) throws FacadeException {
        try {
            return usuarioDaoImpl.alterar(obj);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean excluir(UsuarioBean obj) throws FacadeException {
        try {
            return usuarioDaoImpl.excluir(obj);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Collection<UsuarioBean> listar() throws FacadeException {
        try {
            return usuarioDaoImpl.listar();
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public UsuarioBean selecionar(Integer id) throws FacadeException {
        try {
            return usuarioDaoImpl.selecionar(id);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public UsuarioBean insereOuAltera(UsuarioBean obj) throws FacadeException {
        try {
            return usuarioDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public UsuarioBean selecionaUsuarioPorLogin(String login) throws FacadeException {
        try {
            return usuarioDaoImpl.selecionaUsuarioPorLogin(login);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<UsuarioBean> listarUsuarioNaoDeletado() throws FacadeException {
        try {
            return usuarioDaoImpl.listarUsuarioNaoDeletado();
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<UsuarioBean> listarUsuarioOrdenadaPorCodigo() throws FacadeException {
        try {
            return usuarioDaoImpl.listarUsuarioOrdenadaPorCodigo();
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public UsuarioBean selecionarUsuarioPorAutorizacao(AutorizacaoBean autorizacao) throws FacadeException {
        try {
            return usuarioDaoImpl.selecionarUsuarioPorAutorizacao(autorizacao);
        } catch (DaoException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
