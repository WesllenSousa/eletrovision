
package entidades.agendarTarefas.facade;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import entidades.agendarTarefas.dao.AgendarTarefasDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class AgendarTarefasFacadeImpl implements AgendarTarefasFacade{
    
    private AgendarTarefasDaoImpl agendaTarefasDaoImpl;
    
    public AgendarTarefasFacadeImpl(){
        if(agendaTarefasDaoImpl == null){    
            agendaTarefasDaoImpl = new AgendarTarefasDaoImpl();
        }
    }

    @Override
    public AgendarTarefasBean inserir(AgendarTarefasBean obj) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AgendarTarefasBean alterar(AgendarTarefasBean obj) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(AgendarTarefasBean obj) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<AgendarTarefasBean> listar() throws FacadeException {
        try {
            return agendaTarefasDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AgendarTarefasBean selecionar(Integer id) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AgendarTarefasBean insereOuAltera(AgendarTarefasBean obj) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletado() throws FacadeException {
        try {
            return agendaTarefasDaoImpl.listarAgendarTarefasNaoDeletado();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorDisparoETipo(String disparo, EnumTipoVinculoAgendarTarefas tipoVinculo) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.listarAgendarTarefasPorDisparoETipo(disparo, tipoVinculo);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas tipoVinculo) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.listarAgendarTarefasPorTipo(tipoVinculo);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AgendarTarefasBean selecionarLazy(Integer codigo) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.selecionarLazy(codigo);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasCriteria(Integer codigo, EnumStatusAgendarTarefas status, 
        EnumTipoVinculoAgendarTarefas tipo, EnumDeletadoAgendarTarefas deletado) throws FacadeException {
        try {
            return agendaTarefasDaoImpl.listarAgendarTarefasCriteria(codigo, status, tipo, deletado);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
