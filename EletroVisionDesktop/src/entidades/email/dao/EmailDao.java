package entidades.email.dao;

import entidades.email.bean.EmailBean;
import entidades.pessoa.bean.PessoaBean;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface  EmailDao extends BaseDao<EmailBean> {
    
    public EmailBean selecionarEmailPorPessoa(PessoaBean pessoa) throws DaoException;
    public EmailBean selecionarEmailPorEmail(String email) throws DaoException;
    
}
