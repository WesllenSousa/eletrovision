package entidades.modulo.facade;

import entidades.modulo.bean.ModuloBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface ModuloFacade extends BaseFacade<ModuloBean> {
    
    public ArrayList<ModuloBean> listarModulosOrdenadosPorNome() throws FacadeException;
    
}
