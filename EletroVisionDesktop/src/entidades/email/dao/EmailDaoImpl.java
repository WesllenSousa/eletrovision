package entidades.email.dao;

import entidades.email.bean.EmailBean;
import entidades.pessoa.bean.PessoaBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/** 
 *
 * @author hendrio
 */
public class EmailDaoImpl extends BaseDaoImpl<EmailBean> implements EmailDao {
    
    public EmailDaoImpl(){
        super(EmailBean.class);
    }
    
    @Override
    public EmailBean selecionarEmailPorPessoa(PessoaBean pessoa) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT e FROM EmailBean e where e.pessoa = :pessoa order by e.email");
            q.setParameter("pessoa", pessoa);
            return (EmailBean) q.uniqueResult();
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
    public EmailBean selecionarEmailPorEmail(String email) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT e FROM EmailBean e where e.email = :email order by e.email");
            q.setParameter("email", email);
            return (EmailBean) q.uniqueResult();
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
