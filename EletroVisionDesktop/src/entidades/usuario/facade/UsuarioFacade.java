
package entidades.usuario.facade;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface UsuarioFacade extends BaseFacade<UsuarioBean> {
    
    public UsuarioBean selecionaUsuarioPorLogin(String login) throws FacadeException;
    public ArrayList<UsuarioBean> listarUsuarioNaoDeletado() throws FacadeException;
    public ArrayList<UsuarioBean> listarUsuarioOrdenadaPorCodigo() throws FacadeException;
    public UsuarioBean selecionarUsuarioPorAutorizacao(AutorizacaoBean autorizacao) throws FacadeException;
    
}
