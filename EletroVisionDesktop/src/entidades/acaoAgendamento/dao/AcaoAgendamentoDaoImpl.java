
package entidades.acaoAgendamento.dao;

import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acaoAgendamento.bean.EnumTipoVinculoAcaoAgendamento;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen
 */
public class AcaoAgendamentoDaoImpl extends BaseDaoImpl<AcaoAgendamentoBean> implements AcaoAgendamentoDao{
    
    public AcaoAgendamentoDaoImpl() {
        super(AcaoAgendamentoBean.class);
    }
    
    @Override
    public ArrayList<AcaoAgendamentoBean> listarAcaoAgendamentoPorTipoVinculo(EnumTipoVinculoAcaoAgendamento tipoVinculo) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM AcaoAgendamentoBean a where a.tipoVinculo = :tipoVinculo order by a.codigo");
            q.setParameter("tipoVinculo", tipoVinculo);
            return (ArrayList<AcaoAgendamentoBean>) q.list();
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
