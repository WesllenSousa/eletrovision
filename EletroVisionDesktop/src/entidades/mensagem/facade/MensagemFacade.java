package entidades.mensagem.facade;

import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import java.util.Calendar;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface MensagemFacade extends BaseFacade<MensagemBean> {
    
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorCodigo() throws FacadeException; 
    public ArrayList<MensagemBean> listarMensagensEmail() throws FacadeException;
    public ArrayList<MensagemBean> listarMensagensCelular() throws FacadeException;
    public ArrayList<MensagemBean> listarMensagensLocal() throws FacadeException;
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorData() throws FacadeException;
    public ArrayList<MensagemBean> listarMensagemCriteria(Integer codigo, EnumTipoMensagem tipo, 
                EnumExibirMensagem exibir, EnumLeituraMensagem leitura, Calendar dataInicio, Calendar dataFim, 
                PessoaBean origem, PessoaBean destino) throws FacadeException;
    public ArrayList<MensagemBean> listarMensagensManual(String assunto) throws FacadeException;
    
}
