package entidades.telefone.facade;

import entidades.pessoa.bean.PessoaBean;
import entidades.telefone.bean.TelefoneBean;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface TelefoneFacade extends BaseFacade<TelefoneBean> {
    
    public TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) throws FacadeException;
    public TelefoneBean selecionarTelefonePorNumero(Integer numero) throws FacadeException;
            
}
