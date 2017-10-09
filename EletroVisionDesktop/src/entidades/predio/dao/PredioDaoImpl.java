package entidades.predio.dao;

import entidades.predio.bean.EnumDeletadoPredio;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public class PredioDaoImpl extends BaseDaoImpl<PredioBean> implements PredioDao {

    public PredioDaoImpl() {
        super(PredioBean.class);
    }
    
    @Override
    public ArrayList<PredioBean> listarPredioNaoDeletado() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM PredioBean p where p.deletado = 0 order by p.nome");
            return (ArrayList<PredioBean>) q.list();
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
    public ArrayList<PredioBean> listarPredioOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM PredioBean p where p.deletado = 0 order by p.codigo");
            return (ArrayList<PredioBean>) q.list();
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
    public ArrayList<PredioBean> listarPredioCriteria(Integer codigo, EnumTipoPredio tipo, EnumDeletadoPredio deletado) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(PredioBean.class);
            
            if(codigo!= null){
                criteria.add(Restrictions.eq("codigo", codigo));
            }
            
            if(tipo != null){
                criteria.add (Restrictions.eq("tipo", tipo));
            }
            
            if(deletado!= null){
                criteria.add(Restrictions.eq("deletado", deletado));
            }
            
            return (ArrayList<PredioBean>) criteria.list();
        } catch (Exception e) {
            throw new DaoException(e);
        }finally {
            if (this.session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
}
