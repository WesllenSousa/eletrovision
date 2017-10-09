package entidades.endereco.dao;

import entidades.endereco.bean.EnderecoBean;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public class EnderecoDaoImpl extends BaseDaoImpl<EnderecoBean> implements EnderecoDao {

    public EnderecoDaoImpl() {
        super(EnderecoBean.class);
    }
    
    @Override
    public ArrayList<String> listarEnderecoOrdenadaPorLogradouro() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT DISTINCT b.logradouro FROM EnderecoBean b ORDER BY b.logradouro");
            return (ArrayList<String>) q.list();
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
    public EnderecoBean pesquisarEnderecoPorLogradouro(String logradouro) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT b FROM EnderecoBean b WHERE b.logradouro = :logradouro ORDER BY b.logradouro");
            q.setParameter("logradouro", logradouro);
            q.setMaxResults(1);
            return (EnderecoBean) q.uniqueResult();
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
