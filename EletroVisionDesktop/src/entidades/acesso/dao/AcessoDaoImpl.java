package entidades.acesso.dao;

import entidades.acesso.bean.AcessoBean;
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
public class AcessoDaoImpl extends BaseDaoImpl<AcessoBean> implements AcessoDao {

    public AcessoDaoImpl() {
        super(AcessoBean.class);
    }
    
    @Override     
    public ArrayList<AcessoBean> listarAcessosOrdenadoPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AcessoBean a order by a.dataHoraFim");
            return (ArrayList<AcessoBean>) q.list();
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
