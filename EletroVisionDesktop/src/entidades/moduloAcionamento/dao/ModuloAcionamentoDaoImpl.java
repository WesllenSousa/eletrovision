package entidades.moduloAcionamento.dao;

import entidades.marca.bean.MarcaBean;
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
public class ModuloAcionamentoDaoImpl extends BaseDaoImpl<ModuloAcionamentoBean> implements ModuloAcionamentoDao {

    public ModuloAcionamentoDaoImpl() {
        super(ModuloAcionamentoBean.class);
    }
          
    @Override
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoNaoDeletado() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM ModuloAcionamentoBean m where m.deletado = 0 order by m.nome");
            return (ArrayList<ModuloAcionamentoBean>) q.list();
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
    public ArrayList<ModuloAcionamentoBean> selecionaModuloAcionamentoPorMarca(MarcaBean marca) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM ModuloAcionamentoBean m where m.deletado = 0 and m.marca = :marca order by m.nome");
            q.setParameter("codmarca", marca);
            return  (ArrayList<ModuloAcionamentoBean>) q.list();
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
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM ModuloAcionamentoBean m where m.deletado = 0 order by m.codigo");
            return (ArrayList<ModuloAcionamentoBean>) q.list();
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
