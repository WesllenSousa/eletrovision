package entidades.marca.dao;

import entidades.marca.bean.MarcaBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface MarcaDao extends BaseDao<MarcaBean> {
    
    public ArrayList<MarcaBean> listarMarcaOrdenadaPorCodigo() throws DaoException;
    
}
