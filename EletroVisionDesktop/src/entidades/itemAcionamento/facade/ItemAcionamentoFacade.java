package entidades.itemAcionamento.facade;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface ItemAcionamentoFacade extends BaseFacade<ItemAcionamentoBean> {
    
    public ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws FacadeException;
    public Boolean deletarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws FacadeException;
    
}
