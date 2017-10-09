
package entidades.configPredio.facade;

import entidades.configPredio.bean.ConfigPredioBean;
import entidades.configPredio.dao.ConfigPredioDaoImpl;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigPredioFacadeImpl implements ConfigPredioFacade {
    
    private ConfigPredioDaoImpl configPredioDaoImpl;
    
    public ConfigPredioFacadeImpl() {
        if(configPredioDaoImpl == null) {
            configPredioDaoImpl = new ConfigPredioDaoImpl();
        }
    }

    @Override
    public ConfigPredioBean inserir(ConfigPredioBean obj) throws FacadeException {
        try {
            return configPredioDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigPredioBean alterar(ConfigPredioBean obj) throws FacadeException {
        try {
            return configPredioDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(ConfigPredioBean obj) throws FacadeException {
        try {
            return configPredioDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<ConfigPredioBean> listar() throws FacadeException {
        try {
            return configPredioDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigPredioBean selecionar(Integer id) throws FacadeException {
        try {
            return configPredioDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigPredioBean insereOuAltera(ConfigPredioBean obj) throws FacadeException {
        try {
            return configPredioDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
