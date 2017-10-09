package entidades.email.facade;

import entidades.email.bean.EmailBean;
import entidades.email.dao.EmailDaoImpl;
import entidades.pessoa.bean.PessoaBean;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class EmailFacadeImpl implements EmailFacade {

    private EmailDaoImpl emailDaoImpl;

    public EmailFacadeImpl() {
        if (emailDaoImpl == null) {
            emailDaoImpl = new EmailDaoImpl();
        }
    }

    @Override
    public EmailBean inserir(EmailBean obj) throws FacadeException {
        try {
            return emailDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EmailBean alterar(EmailBean obj) throws FacadeException {
        try {
            return emailDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(EmailBean obj) throws FacadeException {
        try {
            return emailDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<EmailBean> listar() throws FacadeException {
        try {
            return emailDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EmailBean selecionar(Integer id) throws FacadeException {
        try {
            return emailDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EmailBean insereOuAltera(EmailBean obj) throws FacadeException {
        try {
            return emailDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EmailBean selecionarEmailPorPessoa(PessoaBean pessoa) throws FacadeException {
        try {
            return emailDaoImpl.selecionarEmailPorPessoa(pessoa);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EmailBean selecionarEmailPorEmail(String email) throws FacadeException {
        try {
            return emailDaoImpl.selecionarEmailPorEmail(email);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
