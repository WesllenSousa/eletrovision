package entidades.itemAcionamento.dao;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
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
public class ItemAcionamentoDaoImpl extends BaseDaoImpl<ItemAcionamentoBean> implements ItemAcionamentoDao {

    public ItemAcionamentoDaoImpl() {
        super(ItemAcionamentoBean.class);
    }
    
    @Override
    public ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT i FROM ItemAcionamentoBean i where i.acionamento = :acionamento");
            q.setParameter("acionamento", acionamento);
            return (ArrayList<ItemAcionamentoBean>) q.list();
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
    public Boolean deletarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("DELETE FROM ItemAcionamentoBean i where i.acionamento = :acionamento");
            q.setParameter("acionamento", acionamento);
            int resp = q.executeUpdate();
            if (resp >= 0) {
                return true;
            } else {
                return false;
            }
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
    
}
