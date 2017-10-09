package entidades.autorizacao.dao;

import entidades.autorizacao.bean.AutorizacaoBean;
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
public class AutorizacaoDaoImpl extends BaseDaoImpl<AutorizacaoBean> implements AutorizacaoDao {

    public AutorizacaoDaoImpl() {
        super(AutorizacaoBean.class);
    }

    @Override
    public ArrayList<AutorizacaoBean> listarAutorizacaoOrdenadaPorNome() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AutorizacaoBean a where a.deletado = 0 ORDER BY a.descricao");
            return (ArrayList<AutorizacaoBean>) q.list();
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
