package entidades.area.dao;

import entidades.area.bean.AreaBean;
import entidades.predio.bean.PredioBean;
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
public class AreaDaoImpl extends BaseDaoImpl<AreaBean> implements AreaDao {

    public AreaDaoImpl() {
        super(AreaBean.class);
    }  
    
    @Override
    public ArrayList<AreaBean> listarAreaOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AreaBean a where a.deletado = 0 order by a.codigo");
            return (ArrayList<AreaBean>) q.list();
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
    public ArrayList<AreaBean> pesquisarAreaPorPredio(PredioBean predio) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM AreaBean p where p.deletado = 0 and p.predio = :predio ");
            q.setParameter("predio", predio);
            return (ArrayList<AreaBean>) q.list();
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
