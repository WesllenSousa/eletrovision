package entidades.autorizacao.facade;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface AutorizacaoFacade extends BaseFacade<AutorizacaoBean> {
    
    public ArrayList<AutorizacaoBean> listarAutorizacaoOrdenadaPorNome() throws FacadeException;
    
}
