package entidades.mensagem.dao;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
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
public class MensagemDaoImpl extends BaseDaoImpl<MensagemBean> implements MensagemDao {

    public MensagemDaoImpl() {
        super(MensagemBean.class);
    }
    
    @Override
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorCodigo() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MensagemBean m order by m.codigo");
            return (ArrayList<MensagemBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } 
    }
    
    @Override
    public ArrayList<MensagemBean> listarMensagensEmail() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MensagemBean m where m.tipo = 0 order by m.assunto");
            return (ArrayList<MensagemBean>) q.list();
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
    public ArrayList<MensagemBean> listarMensagensCelular() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MensagemBean m where m.tipo = 1 order by m.assunto");
            return (ArrayList<MensagemBean>) q.list();
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
    public ArrayList<MensagemBean> listarMensagensLocal() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MensagemBean m where m.tipo = 2 order by m.assunto");
            return (ArrayList<MensagemBean>) q.list();
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
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorData() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MensagemBean m order by m.dataHora");
            return (ArrayList<MensagemBean>) q.list();
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
    public ArrayList<MensagemBean> listarMensagensManual(String assunto) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM MensagemBean m where m.assunto != :assunto order by m.assunto");
            q.setParameter("assunto", assunto);
            return (ArrayList<MensagemBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } 
    }
    
    @Override   
    public ArrayList<MensagemBean> listarMensagemCriteria(Integer codigo, EnumTipoMensagem tipo, 
                EnumExibirMensagem exibir, EnumLeituraMensagem leitura, Calendar dataInicio, Calendar dataFim, 
                PessoaBean origem, PessoaBean destino) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Criteria criteria = this.session.createCriteria(MensagemBean.class);
            
            if(codigo != null) {
                criteria.add(Restrictions.eq("codigo", codigo));
            }
            if(tipo != null) {
                criteria.add(Restrictions.eq("tipo", tipo));
            }
            if(exibir != null) {
                criteria.add(Restrictions.eq("exibir", exibir));
            }
            if(leitura != null) {
                criteria.add(Restrictions.eq("leitura", leitura));
            }
            if(dataInicio != null && dataFim != null) {
                criteria.add(Restrictions.between("dataHora", dataInicio, dataFim));
            }
            if(origem != null) {
                criteria.add(Restrictions.eq("origem", origem));
            }
            if(destino != null) {
                criteria.add(Restrictions.eq("destino", destino));
            }
            
            return (ArrayList<MensagemBean>) criteria.list();
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
