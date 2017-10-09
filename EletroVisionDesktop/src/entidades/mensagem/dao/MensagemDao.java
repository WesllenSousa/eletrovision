package entidades.mensagem.dao;

import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import java.util.Calendar;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface MensagemDao extends BaseDao<MensagemBean> {
    
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorCodigo() throws DaoException;
    public ArrayList<MensagemBean> listarMensagensEmail() throws DaoException;
    public ArrayList<MensagemBean> listarMensagensCelular() throws DaoException;
    public ArrayList<MensagemBean> listarMensagensLocal() throws DaoException;
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorData() throws DaoException;
    public ArrayList<MensagemBean> listarMensagemCriteria(Integer codigo, EnumTipoMensagem tipo, 
                EnumExibirMensagem exibir, EnumLeituraMensagem leitura, Calendar dataInicio, Calendar dataFim, 
                PessoaBean origem, PessoaBean destino) throws DaoException;
    public ArrayList<MensagemBean> listarMensagensManual(String assunto) throws DaoException;
    
}
