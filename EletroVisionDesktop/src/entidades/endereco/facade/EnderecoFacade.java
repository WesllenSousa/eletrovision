package entidades.endereco.facade;

import entidades.endereco.bean.EnderecoBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface EnderecoFacade extends BaseFacade<EnderecoBean> {
    
    public ArrayList<String> listarEnderecoOrdenadaPorLogradouro() throws FacadeException;
    public EnderecoBean pesquisarEnderecoPorLogradouro(String logradouro) throws FacadeException;
    
}
