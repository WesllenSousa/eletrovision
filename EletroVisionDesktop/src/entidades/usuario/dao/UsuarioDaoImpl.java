
package entidades.usuario.dao;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class UsuarioDaoImpl extends BaseDaoImpl<UsuarioBean> implements UsuarioDao{
    
    public UsuarioDaoImpl(){
        super(UsuarioBean.class);
    }

    @Override
    public UsuarioBean selecionaUsuarioPorLogin(String login) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM UsuarioBean p where p.login = :login and deletado = 0 order by p.login");
            q.setParameter("login", login);
            return (UsuarioBean) q.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override
    public ArrayList<UsuarioBean> listarUsuarioNaoDeletado() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT u FROM UsuarioBean u where u.deletado = 0 order by u.login");
            return (ArrayList<UsuarioBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override
    public ArrayList<UsuarioBean> listarUsuarioOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT u FROM UsuarioBean u where u.deletado = 0 order by u.codigo");
            return (ArrayList<UsuarioBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {     
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override 
    public UsuarioBean selecionarUsuarioPorAutorizacao(AutorizacaoBean autorizacao) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM UsuarioBean p where p.autorizacao = :autorizacao");
            q.setParameter("autorizacao", autorizacao);
            return (UsuarioBean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
}
