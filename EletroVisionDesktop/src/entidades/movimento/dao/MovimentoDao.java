package entidades.movimento.dao;

import entidades.movimento.bean.MovimentoBean;
import java.util.ArrayList;
import java.util.Calendar;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface MovimentoDao extends BaseDao<MovimentoBean> {
    
    public ArrayList<MovimentoBean> listarMovimentoOrdenadoPorData() throws DaoException;
    public MovimentoBean listarUltimoRegistro() throws DaoException;
    public ArrayList<MovimentoBean> listarMovimentoCriteria(Integer codigo,
            Calendar dataInicio, Calendar dataFim) throws DaoException;
    
}
