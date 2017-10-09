package entidades.telefone.facade;

import entidades.pessoa.bean.PessoaBean;
import entidades.telefone.bean.TelefoneBean;
import entidades.telefone.dao.TelefoneDaoImpl;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class TelefoneFacadeImpl implements TelefoneFacade {

    private TelefoneDaoImpl telefoneDaoImpl;

    public TelefoneFacadeImpl() {
        if (telefoneDaoImpl == null) {
            telefoneDaoImpl = new TelefoneDaoImpl();
        }
    }

    @Override
    public TelefoneBean inserir(TelefoneBean obj) throws FacadeException {
        try {
            return telefoneDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public TelefoneBean alterar(TelefoneBean obj) throws FacadeException {
       try {
            return telefoneDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(TelefoneBean obj) throws FacadeException {
        try {
            return telefoneDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<TelefoneBean> listar() throws FacadeException {
        try {
            return telefoneDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public TelefoneBean selecionar(Integer id) throws FacadeException {
        try {
            return telefoneDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public TelefoneBean insereOuAltera(TelefoneBean obj) throws FacadeException {
        try {
            return telefoneDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public TelefoneBean selecionarTelefonePorPessoa(PessoaBean pessoa) throws FacadeException {
        try {
            return telefoneDaoImpl.selecionarTelefonePorPessoa(pessoa);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public TelefoneBean selecionarTelefonePorNumero(Integer numero) throws FacadeException {
        try {
            return telefoneDaoImpl.selecionarTelefonePorNumero(numero);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
