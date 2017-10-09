package entidades.itemAcionamento.dao;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface  ItemAcionamentoDao extends BaseDao<ItemAcionamentoBean> {
    
    public ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws DaoException;
    public Boolean deletarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws DaoException;
    
}
