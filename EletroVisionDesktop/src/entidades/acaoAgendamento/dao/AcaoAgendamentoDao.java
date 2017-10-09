
package entidades.acaoAgendamento.dao;

import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acaoAgendamento.bean.EnumTipoVinculoAcaoAgendamento;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen
 */
public interface AcaoAgendamentoDao extends BaseDao<AcaoAgendamentoBean> {
    
    public ArrayList<AcaoAgendamentoBean> listarAcaoAgendamentoPorTipoVinculo(EnumTipoVinculoAcaoAgendamento tipoVinculo) throws DaoException;
    
}
