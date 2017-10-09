package entidades.agendarTarefas.dao;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.agendarTarefas.bean.EnumDeletadoAgendarTarefas;
import entidades.agendarTarefas.bean.EnumStatusAgendarTarefas;
import entidades.agendarTarefas.bean.EnumTipoVinculoAgendarTarefas;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface AgendarTarefasDao extends BaseDao<AgendarTarefasBean> {
    
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasNaoDeletado() throws DaoException;
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorDisparoETipo(String disparo, EnumTipoVinculoAgendarTarefas tipoVinculo) throws DaoException;
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasPorTipo(EnumTipoVinculoAgendarTarefas tipoVinculo) throws DaoException;
    public AgendarTarefasBean selecionarLazy(Integer codigo) throws DaoException;
    public ArrayList<AgendarTarefasBean> listarAgendarTarefasCriteria(Integer codigo,
            EnumStatusAgendarTarefas status, EnumTipoVinculoAgendarTarefas tipo,
            EnumDeletadoAgendarTarefas deletado) throws DaoException;
    
}
