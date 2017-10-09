package entidades.modulo.dao;

import entidades.modulo.bean.ModuloBean;
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
public class ModuloDaoImpl extends BaseDaoImpl<ModuloBean> implements ModuloDao {
    
    public ModuloDaoImpl(){
        super(ModuloBean.class);
    }
    
    @Override
    public ArrayList<ModuloBean> listarModulosOrdenadosPorNome() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM ModuloBean m order by m.nome");
            return (ArrayList<ModuloBean>) q.list();
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
