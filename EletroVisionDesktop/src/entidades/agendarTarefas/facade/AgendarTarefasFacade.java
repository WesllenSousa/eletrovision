package entidades.agendarTarefas.facade;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface AgendarTarefasFacade extends BaseFacade<AgendarTarefasBean> {
    
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletado() throws FacadeException;
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorDisparoETipo(String disparo, EnumTipoVinculoAgendarTarefas tipoVinculo) throws FacadeException;
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas tipoVinculo) throws FacadeException;
    public AgendarTarefasBean selecionarLazy(Integer codigo) throws FacadeException;
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasCriteria(Integer codigo,
            EnumStatusAgendarTarefas status, EnumTipoVinculoAgendarTarefas tipo,
            EnumDeletadoAgendarTarefas deletado) throws FacadeException;
    
}
