
package entidades.configPessoa.facade;

import entidades.configPessoa.bean.ConfigPessoaBean;
import entidades.configPessoa.dao.ConfigPessoaDaoImpl;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigPessoaFacadeImpl implements ConfigPessoaFacade {
    
    private ConfigPessoaDaoImpl configPessoaDaoImpl;
    
    public ConfigPessoaFacadeImpl() {
        if(configPessoaDaoImpl == null) {
            configPessoaDaoImpl = new ConfigPessoaDaoImpl();
        }
    }

    @Override
    public ConfigPessoaBean inserir(ConfigPessoaBean obj) throws FacadeException {
        try {
            return configPessoaDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigPessoaBean alterar(ConfigPessoaBean obj) throws FacadeException {
        try {
            return configPessoaDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(ConfigPessoaBean obj) throws FacadeException {
        try {
            return configPessoaDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<ConfigPessoaBean> listar() throws FacadeException {
        try {
            return configPessoaDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigPessoaBean selecionar(Integer id) throws FacadeException {
        try {
            return configPessoaDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigPessoaBean insereOuAltera(ConfigPessoaBean obj) throws FacadeException {
        try {
            return configPessoaDaoImpl.insereOuAltera(obj); 
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
