package entidades.endereco.facade;

import entidades.endereco.bean.EnderecoBean;
import entidades.endereco.dao.EnderecoDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class EnderecoFacadeImpl implements EnderecoFacade {

    private EnderecoDaoImpl enderecoDaoImpl;

    public EnderecoFacadeImpl() {
        if (enderecoDaoImpl == null) {
            enderecoDaoImpl = new EnderecoDaoImpl();
        }
    }

    @Override
    public EnderecoBean inserir(EnderecoBean obj) throws FacadeException {
        try {
            return enderecoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EnderecoBean alterar(EnderecoBean obj) throws FacadeException {
        try {
            return enderecoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(EnderecoBean obj) throws FacadeException {
        try {
            return enderecoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<EnderecoBean> listar() throws FacadeException {
        try {
            return enderecoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EnderecoBean selecionar(Integer id) throws FacadeException {
        try {
            return enderecoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EnderecoBean insereOuAltera(EnderecoBean obj) throws FacadeException {
        try {
            return enderecoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<String> listarEnderecoOrdenadaPorLogradouro() throws FacadeException {
        try {
            return enderecoDaoImpl.listarEnderecoOrdenadaPorLogradouro();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public EnderecoBean pesquisarEnderecoPorLogradouro(String logradouro) throws FacadeException {
        try {
            return enderecoDaoImpl.pesquisarEnderecoPorLogradouro(logradouro);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
