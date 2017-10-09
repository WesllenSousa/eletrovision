package entidades.pessoa.dao;

import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface  PessoaDao extends BaseDao<PessoaBean> {
    
    public ArrayList<PessoaBean> listarCameraNaoDeletada() throws DaoException;
    public ArrayList<PessoaBean> pesquisarPessoaPorTipo(EnumTipoPessoa tipo) throws DaoException;
    public ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo() throws DaoException;
    public ArrayList<PessoaBean> listarPessoasCriteria(Integer codigo, EnumTipoPessoa tipo, EnumSituacaoPessoa situacao) throws DaoException;
    
}
