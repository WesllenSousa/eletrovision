package entidades.marca.facade;

import entidades.marca.bean.MarcaBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface MarcaFacade extends BaseFacade<MarcaBean> {
    
    public ArrayList<MarcaBean> listarMarcaOrdenadaPorCodigo() throws FacadeException;
    
}
