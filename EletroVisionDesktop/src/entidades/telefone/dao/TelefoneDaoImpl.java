package entidades.telefone.dao;

import entidades.pessoa.bean.PessoaBean;
import entidades.telefone.bean.TelefoneBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public class TelefoneDaoImpl extends BaseDaoImpl<TelefoneBean> implements TelefoneDao {

    public TelefoneDaoImpl() {
        super(TelefoneBean.class);
    }
    
    @Override
    public TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT t FROM TelefoneBean t where t.pessoa = :pessoa order by t.numero");
            q.setParameter("pessoa", pessoa);
            return (TelefoneBean) q.uniqueResult();
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
    public TelefoneBean selecionarTelefonePorNumero(Integer numero) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT t FROM TelefoneBean t where t.numero = :numero order by t.numero");
            q.setParameter("numero", numero);
            return (TelefoneBean) q.uniqueResult();
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
