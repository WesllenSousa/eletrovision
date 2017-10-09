package entidades.acesso.dao;

import entidades.acesso.bean.AcessoBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface AcessoDao extends BaseDao<AcessoBean> {
    
    public ArrayList<AcessoBean> listarAcessosOrdenadoPorData() throws DaoException;
    
}
