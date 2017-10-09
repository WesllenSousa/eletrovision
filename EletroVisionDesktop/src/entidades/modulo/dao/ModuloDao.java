package entidades.modulo.dao;

import entidades.modulo.bean.ModuloBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface ModuloDao extends BaseDao<ModuloBean> {
    
    public ArrayList<ModuloBean> listarModulosOrdenadosPorNome() throws DaoException;
    
}
