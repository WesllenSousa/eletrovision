package entidades.pessoa.facade;

import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface PessoaFacade extends BaseFacade<PessoaBean> {
    
    public ArrayList<PessoaBean> listarCameraNaoDeletada() throws FacadeException;
    public ArrayList<PessoaBean> pesquisarPessoaPorTipo(EnumTipoPessoa tipo) throws FacadeException;
    public ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo() throws FacadeException;
    public ArrayList<PessoaBean> listarPessoasCriteria(Integer codigo, EnumTipoPessoa tipo, EnumSituacaoPessoa situacao) throws FacadeException;
    
}
