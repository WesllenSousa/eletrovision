package entidades.configCamera.facade;

import entidades.configCamera.bean.ConfigCameraBean;
import entidades.configCamera.dao.ConfigCameraDaoImpl;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class ConfigCameraFacadeImpl implements ConfigCameraFacade {

    private ConfigCameraDaoImpl configCameraDaoImpl;

    public ConfigCameraFacadeImpl() {
        if (configCameraDaoImpl == null) {
            configCameraDaoImpl = new ConfigCameraDaoImpl();
        }
    }

    @Override
    public ConfigCameraBean inserir(ConfigCameraBean obj) throws FacadeException {
        try {
            return configCameraDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigCameraBean alterar(ConfigCameraBean obj) throws FacadeException {
       try {
            return configCameraDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(ConfigCameraBean obj) throws FacadeException {
        try {
            return configCameraDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<ConfigCameraBean> listar() throws FacadeException {
        try {
            return configCameraDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigCameraBean selecionar(Integer id) throws FacadeException {
        try {
            return configCameraDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ConfigCameraBean insereOuAltera(ConfigCameraBean obj) throws FacadeException {
        try {
            return configCameraDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
