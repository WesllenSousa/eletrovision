package entidades.marca.dao;

import entidades.marca.bean.MarcaBean;
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
public class MarcaDaoImpl extends BaseDaoImpl<MarcaBean> implements MarcaDao {

    public MarcaDaoImpl() {
        super(MarcaBean.class);
    }
    
    @Override
    public ArrayList<MarcaBean> listarMarcaOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MarcaBean m where m.deletado = 0 order by m.codigo");
            return (ArrayList<MarcaBean>) q.list();
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
