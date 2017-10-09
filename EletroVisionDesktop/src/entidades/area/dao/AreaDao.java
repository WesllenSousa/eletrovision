package entidades.area.dao;

import entidades.area.bean.AreaBean;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface AreaDao extends BaseDao<AreaBean> {
    
    public ArrayList<AreaBean> listarAreaOrdenadaPorCodigo() throws DaoException;
    public ArrayList<AreaBean> pesquisarAreaPorPredio(PredioBean predio) throws DaoException;
    
}
