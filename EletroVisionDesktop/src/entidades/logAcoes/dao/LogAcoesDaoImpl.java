package entidades.logAcoes.dao;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.logAcoes.bean.EnumRedeLogAcoes;
import entidades.logAcoes.bean.LogAcoesBean;
import entidades.pessoa.bean.PessoaBean;
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
public class LogAcoesDaoImpl extends BaseDaoImpl<LogAcoesBean> implements LogAcoesDao {

    public LogAcoesDaoImpl() {
        super(LogAcoesBean.class);
    }

    @Override
    public ArrayList<LogAcoesBean> listarlogAcoesOrdenadoPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT l FROM LogAcoesBean l order by l.dataHora");
            return (ArrayList<LogAcoesBean>) q.list();
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
    public ArrayList<LogAcoesBean> listarlogAcoesAcionamentoOrdenadoPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT l FROM LogAcoesBean l where l.acionamento != null order by l.dataHora");
            return (ArrayList<LogAcoesBean>) q.list();
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
    public ArrayList<LogAcoesBean> listarlogAcoesDispositivoEletricoOrdenadoPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT l FROM LogAcoesBean l where l.dispositivoEletrico != null order by l.dataHora");
            return (ArrayList<LogAcoesBean>) q.list();
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
    public ArrayList<LogAcoesBean> listarlogAcoesAgendarTarefasOrdenadoPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT l FROM LogAcoesBean l where l.agendarTarefas != null order by l.dataHora");
            return (ArrayList<LogAcoesBean>) q.list();
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
    public ArrayList<LogAcoesBean> listarLogAcoesCriteria(Integer codigo,
            EnumRedeLogAcoes rede, Calendar dataInicio, Calendar dataFim,
            PessoaBean pessoa) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(AcionamentoBean.class);
            if (codigo != null) {
                criteria.add(Restrictions.eq("codigo", codigo));
            }
            if (rede != null) {
                criteria.add(Restrictions.eq("rede", rede));
            }
            if (dataInicio != null && dataFim != null) {
                criteria.add(Restrictions.between("dataHora", dataInicio, dataFim));
            }
            if (pessoa != null) {
                criteria.add(Restrictions.eq("pessoa", pessoa));
            }
            return (ArrayList<LogAcoesBean>) criteria.list();
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
