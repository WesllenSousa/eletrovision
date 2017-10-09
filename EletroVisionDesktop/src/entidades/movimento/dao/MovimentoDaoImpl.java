package entidades.movimento.dao;

import entidades.mensagem.bean.MensagemBean;
import entidades.movimento.bean.MovimentoBean;
import java.util.ArrayList;
import java.util.Calendar;
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
public class MovimentoDaoImpl extends BaseDaoImpl<MovimentoBean> implements MovimentoDao {

    public MovimentoDaoImpl() {
        super(MovimentoBean.class);
    }

    @Override
    public MovimentoBean listarUltimoRegistro() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MovimentoBean m WHERE m.codigo = (SELECT MAX(m.codigo) FROM MovimentoBean m)");
            return (MovimentoBean) q.uniqueResult();
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
    public ArrayList<MovimentoBean> listarMovimentoOrdenadoPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MovimentoBean m order by m.data_hms");
            return (ArrayList<MovimentoBean>) q.list();
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
    public ArrayList<MovimentoBean> listarMovimentoCriteria(Integer codigo,
            Calendar dataInicio, Calendar dataFim) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(MensagemBean.class);

            if (codigo != null) {
                criteria.add(Restrictions.eq("codigo", codigo));
            }

            if (dataInicio != null && dataFim != null) {
                criteria.add(Restrictions.between("dataHora", dataInicio, dataFim));
            }

            return (ArrayList<MovimentoBean>) criteria.list();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
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
