package entidades.dispositivoEletrico.dao;

import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
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
public class DispositivoEletricoDaoImpl extends BaseDaoImpl<DispositivoEletricoBean> implements DispositivoEletricoDao {

    public DispositivoEletricoDaoImpl() {
        super(DispositivoEletricoBean.class);
    }
    
    @Override
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoNaoDeletado() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT dp FROM DispositivoEletricoBean dp where dp.deletado = 0 order by dp.nome");
            return (ArrayList<DispositivoEletricoBean>) q.list();
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
    public DispositivoEletricoBean selecionarDispositivoEletricoPorNome(String nome) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT dp FROM DispositivoEletricoBean dp where dp.nome = :nome");
            q.setParameter("nome", nome);
            return (DispositivoEletricoBean) q.uniqueResult();
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
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT d FROM DispositivoEletricoBean d where d.deletado = 0 order by d.codigo");
            return (ArrayList<DispositivoEletricoBean>) q.list();
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
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoPorModulo(ModuloAcionamentoBean moduloAcionamento) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT de FROM DispositivoEletricoBean de where de.moduloAcionamento = :moduloAcionamento");
            q.setParameter("moduloAcionamento", moduloAcionamento);
            return (ArrayList<DispositivoEletricoBean>) q.list();
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
