
package entidades.usuario.dao;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface UsuarioDao extends BaseDao<UsuarioBean> {
     
    public UsuarioBean selecionaUsuarioPorLogin(String login) throws DaoException;
    public ArrayList<UsuarioBean> listarUsuarioNaoDeletado() throws DaoException;
    public ArrayList<UsuarioBean> listarUsuarioOrdenadaPorCodigo() throws DaoException;
    public UsuarioBean selecionarUsuarioPorAutorizacao(AutorizacaoBean autorizacao) throws DaoException;
    
}
