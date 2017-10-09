package entidades.email.facade;

import entidades.email.bean.EmailBean;
import entidades.pessoa.bean.PessoaBean;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface EmailFacade extends BaseFacade<EmailBean> {
    
    public EmailBean selecionarEmailPorPessoa(PessoaBean pessoa) throws FacadeException;
    public EmailBean selecionarEmailPorEmail(String email) throws FacadeException;
    
}
