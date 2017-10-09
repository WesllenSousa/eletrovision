package entidades.telefone.dao;

import entidades.pessoa.bean.PessoaBean;
import entidades.telefone.bean.TelefoneBean;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface TelefoneDao extends BaseDao<TelefoneBean> {
    
    public TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) throws DaoException;
    public TelefoneBean selecionarTelefonePorNumero(Integer numero) throws DaoException;
    
}
