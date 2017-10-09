package entidades.mensagem.facade;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.mensagem.bean.EnumExibirMensagem;
import entidades.mensagem.bean.EnumLeituraMensagem;
import entidades.mensagem.bean.EnumTipoMensagem;
import entidades.mensagem.bean.MensagemBean;
import entidades.mensagem.dao.MensagemDaoImpl;
import entidades.pessoa.bean.PessoaBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class MensagemFacadeImpl implements MensagemFacade {

    private MensagemDaoImpl mensagemDaoImpl;

    public MensagemFacadeImpl() {
        if (mensagemDaoImpl == null) {
            mensagemDaoImpl = new MensagemDaoImpl();
        }
    }

    @Override
    public MensagemBean inserir(MensagemBean obj) throws FacadeException {
        try {
            return mensagemDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MensagemBean alterar(MensagemBean obj) throws FacadeException {
        try {
            return mensagemDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(MensagemBean obj) throws FacadeException {
        try {
            return mensagemDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<MensagemBean> listar() throws FacadeException {
        try {
            return mensagemDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MensagemBean selecionar(Integer id) throws FacadeException {
        try {
            return mensagemDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public MensagemBean insereOuAltera(MensagemBean obj) throws FacadeException {
        try {
            return mensagemDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagensEmail() throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagensEmail();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagensCelular() throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagensCelular();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagensLocal() throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagensLocal();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorData() throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagemOrdenadaPorData();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagemCriteria(Integer codigo, EnumTipoMensagem tipo, 
        EnumExibirMensagem exibir, EnumLeituraMensagem leitura, Calendar dataInicio, 
        Calendar dataFim, PessoaBean origem, PessoaBean destino) throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagemCriteria(codigo, tipo, exibir, leitura, 
                    dataInicio, dataFim, origem, destino);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagemOrdenadaPorCodigo() throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagemOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<MensagemBean> listarMensagensManual(String assunto) throws FacadeException {
        try {
            return mensagemDaoImpl.listarMensagensManual(assunto);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
