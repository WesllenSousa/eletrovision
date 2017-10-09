
package entidades.acaoAgendamento.facade;

import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acaoAgendamento.bean.EnumTipoVinculoAcaoAgendamento;
import entidades.acaoAgendamento.dao.AcaoAgendamentoDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author Wesllen
 */
public class AcaoAgendamentoFacadeImpl implements AcaoAgendamentoFacade {
    
    private AcaoAgendamentoDaoImpl acaoAgendamentoDaoImpl;
    
    public AcaoAgendamentoFacadeImpl() {
        if(acaoAgendamentoDaoImpl == null) {
            acaoAgendamentoDaoImpl = new AcaoAgendamentoDaoImpl();
        }
    }

    @Override
    public AcaoAgendamentoBean inserir(AcaoAgendamentoBean obj) throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcaoAgendamentoBean alterar(AcaoAgendamentoBean obj) throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(AcaoAgendamentoBean obj) throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<AcaoAgendamentoBean> listar() throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcaoAgendamentoBean selecionar(Integer id) throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcaoAgendamentoBean insereOuAltera(AcaoAgendamentoBean obj) throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AcaoAgendamentoBean> listarAcaoAgendamentoPorTipoVinculo(EnumTipoVinculoAcaoAgendamento tipoVinculo) throws FacadeException {
        try {
            return acaoAgendamentoDaoImpl.listarAcaoAgendamentoPorTipoVinculo(tipoVinculo);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
