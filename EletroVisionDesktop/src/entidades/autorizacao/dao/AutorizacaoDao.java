package entidades.autorizacao.dao;

import entidades.autorizacao.bean.AutorizacaoBean;
import entidades.usuario.bean.UsuarioBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface AutorizacaoDao extends BaseDao<AutorizacaoBean> {
    
    public ArrayList<AutorizacaoBean> listarAutorizacaoOrdenadaPorNome() throws DaoException;
    
}
