package entidades.area.facade;

import entidades.area.bean.AreaBean;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface AreaFacade extends BaseFacade<AreaBean> {
    
    public ArrayList<AreaBean> listarAreaOrdenadaPorCodigo() throws FacadeException;
    public ArrayList<AreaBean> pesquisarAreaPorPredio(PredioBean predio) throws FacadeException;
    
}
