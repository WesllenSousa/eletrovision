package entidades.acesso.facade;

import entidades.acesso.bean.AcessoBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface AcessoFacade extends BaseFacade<AcessoBean> {
    
    public ArrayList<AcessoBean> listarAcessosOrdenadoPorData() throws FacadeException;
    
}
