
package entidades.acaoAgendamento.facade;

import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acaoAgendamento.bean.EnumTipoVinculoAcaoAgendamento;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author Wesllen
 */
public interface AcaoAgendamentoFacade extends BaseFacade<AcaoAgendamentoBean> {
    
    public ArrayList<AcaoAgendamentoBean> listarAcaoAgendamentoPorTipoVinculo(EnumTipoVinculoAcaoAgendamento tipoVinculo) throws FacadeException;
    
}
