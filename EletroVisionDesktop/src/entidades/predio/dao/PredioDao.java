package entidades.predio.dao;

import entidades.predio.bean.EnumDeletadoPredio;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface PredioDao extends BaseDao<PredioBean> {
    
    public ArrayList<PredioBean> listarPredioOrdenadaPorCodigo() throws DaoException;
    public ArrayList<PredioBean> listarPredioNaoDeletado() throws DaoException;
    public ArrayList<PredioBean> listarPredioCriteria(Integer codigo, EnumTipoPredio tipo, EnumDeletadoPredio deletado) throws DaoException;
    
}
