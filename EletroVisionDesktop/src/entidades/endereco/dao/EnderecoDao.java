package entidades.endereco.dao;

import entidades.endereco.bean.EnderecoBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface EnderecoDao extends BaseDao<EnderecoBean> {
    
    public ArrayList<String> listarEnderecoOrdenadaPorLogradouro() throws DaoException;
    public EnderecoBean pesquisarEnderecoPorLogradouro(String logradouro) throws DaoException;
    
}
