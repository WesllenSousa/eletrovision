package entidades.pessoa.dao;

import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
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
public class PessoaDaoImpl extends BaseDaoImpl<PessoaBean> implements PessoaDao {

    public PessoaDaoImpl() {
        super(PessoaBean.class);
    }
    
    @Override
    public ArrayList<PessoaBean> listarCameraNaoDeletada() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM PessoaBean p where p.deletado = 0 order by p.nome");
            return (ArrayList<PessoaBean>) q.list();
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
    public ArrayList<PessoaBean> pesquisarPessoaPorTipo(EnumTipoPessoa tipo) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM PessoaBean p where p.tipo = :tipo order by p.nome");
            q.setParameter("tipo", tipo);
            return (ArrayList<PessoaBean>) q.list();
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
    public ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT p FROM PessoaBean p where p.deletado = 0 order by p.codigo");
            return (ArrayList<PessoaBean>) q.list();
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
    public ArrayList<PessoaBean> listarPessoasCriteria(Integer codigo, EnumTipoPessoa tipo, 
            EnumSituacaoPessoa situacao) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(PessoaBean.class);
            if (codigo != null) {
                criteria.add(Restrictions.eq("codigo", codigo));
            }
            if (tipo != null) {
                criteria.add(Restrictions.eq("tipo", tipo));
            }
            if (situacao != null) {
                criteria.add(Restrictions.eq("situacao", situacao));
            }
            return (ArrayList<PessoaBean>) criteria.list();
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

