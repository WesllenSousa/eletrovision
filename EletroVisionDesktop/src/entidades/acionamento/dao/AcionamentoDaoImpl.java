package entidades.acionamento.dao;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.mensagem.bean.MensagemBean;
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
public class AcionamentoDaoImpl extends BaseDaoImpl<AcionamentoBean> implements AcionamentoDao {

    public AcionamentoDaoImpl() {
        super(AcionamentoBean.class);
    }
    
    @Override
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AcionamentoBean a where a.deletado = 0 order by a.codigo");
            return (ArrayList<AcionamentoBean>) q.list();
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
    public ArrayList<AcionamentoBean> listarAcionamentoNaoDeletado() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AcionamentoBean a where a.deletado = 0 order by a.codigo");
            return (ArrayList<AcionamentoBean>) q.list();
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
    public AcionamentoBean selecionaAcionamentoPorNome(String nome) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AcionamentoBean a where a.nome = :nome order by a.codigo");
            q.setParameter("nome", nome);
            return (AcionamentoBean) q.uniqueResult();
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
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorNome() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AcionamentoBean a where a.deletado = 0 order by a.nome");
            return (ArrayList<AcionamentoBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } 
    }
    
    @Override
    public ArrayList<AcionamentoBean> listarAcionamentoCriteria(Integer codigo, EnumStatusAcionamento status, 
            EnumLigarDesligarAcionamento ligarDesligar, EnumDeletadoAcionamento deletado, EnumTipoAcionamento tipo,
            PredioBean predio) throws DaoException {
        
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(AcionamentoBean.class);
            
            if(codigo != null) {
                criteria.add(Restrictions.eq("codigo", codigo));
            }
            if(status != null) {
                criteria.add(Restrictions.eq("status", status));
            }
            if(ligarDesligar != null) {
                criteria.add(Restrictions.eq("ligarDesligar", ligarDesligar));
            }
            if(deletado != null) {
                criteria.add(Restrictions.eq("deletado", deletado));
            }
            if(tipo != null) {
                criteria.add(Restrictions.eq("tipo", tipo));
            }
            if(predio != null) {
                criteria.add(Restrictions.eq("predio", predio));
            }
            
            return (ArrayList<AcionamentoBean>) criteria.list();
            
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
