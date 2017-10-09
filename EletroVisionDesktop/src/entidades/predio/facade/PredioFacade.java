package entidades.predio.facade;

import entidades.predio.bean.EnumDeletadoPredio;
import entidades.predio.bean.EnumTipoPredio;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface PredioFacade extends BaseFacade<PredioBean> {
    
    public ArrayList<PredioBean> listarPredioOrdenadaPorCodigo() throws FacadeException;
    public ArrayList<PredioBean> listarPredioNaoDeletado() throws FacadeException;
    public ArrayList<PredioBean> listarPredioCriteria(Integer codigo, EnumTipoPredio tipo, EnumDeletadoPredio deletado) throws FacadeException;
    
}
