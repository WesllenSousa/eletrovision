package entidades.agendarTarefas.dao;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
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
public class AgendarTarefasDaoImpl extends BaseDaoImpl<AgendarTarefasBean> implements AgendarTarefasDao {

    public AgendarTarefasDaoImpl() {
        super(AgendarTarefasBean.class);
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletado() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AgendarTarefasBean a where a.deletado = 0 order by a.codigo");
            return (ArrayList<AgendarTarefasBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorDisparoETipo(String disparo, EnumTipoVinculoAgendarTarefas tipoVinculo) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AgendarTarefasBean a where a.deletado = 0 and a.disparo = :disparo and tipoVinculo = :tipoVinculo order by a.codigo");
            q.setParameter("disparo", disparo);
            q.setParameter("tipoVinculo", tipoVinculo);
            return (ArrayList<AgendarTarefasBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas tipoVinculo) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AgendarTarefasBean a where a.deletado = 0 and a.tipoVinculo = :tipoVinculo order by a.codigo");
            q.setParameter("tipoVinculo", tipoVinculo);
            return (ArrayList<AgendarTarefasBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public AgendarTarefasBean selecionarLazy(Integer codigo) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AgendarTarefasBean a where a.codigo = :codigo");
            q.setParameter("codigo", codigo);
            return (AgendarTarefasBean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasCriteria(Integer codigo,
            EnumStatusAgendarTarefas status, EnumTipoVinculoAgendarTarefas tipo,
            EnumDeletadoAgendarTarefas deletado) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(AgendarTarefasBean.class);

            if (codigo != null) {
                criteria.add(Restrictions.eq("codigo", codigo));
            }
            if (status != null) {
                criteria.add(Restrictions.eq("status", status));
            }

            if (tipo != null) {
                criteria.add(Restrictions.eq("tipo", tipo));
            }

            if (deletado != null) {
                criteria.add(Restrictions.eq("deletado", deletado));
            }
            return (ArrayList<AgendarTarefasBean>) criteria.list();

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
