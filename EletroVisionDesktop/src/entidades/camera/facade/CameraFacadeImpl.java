package entidades.camera.facade;

import entidades.camera.bean.CameraBean;
import entidades.camera.dao.CameraDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class CameraFacadeImpl implements CameraFacade {

    private CameraDaoImpl cameraDaoImpl;

    public CameraFacadeImpl() {
        if (cameraDaoImpl == null) {
            cameraDaoImpl = new CameraDaoImpl();
        }
    }

    @Override
    public CameraBean inserir(CameraBean obj) throws FacadeException {
         try {
            return cameraDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public CameraBean alterar(CameraBean obj) throws FacadeException {
        try {
            return cameraDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(CameraBean obj) throws FacadeException {
        try {
            return cameraDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<CameraBean> listar() throws FacadeException {
        try {
            return cameraDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public CameraBean selecionar(Integer id) throws FacadeException {
        try {
            return cameraDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public CameraBean insereOuAltera(CameraBean obj) throws FacadeException {
        try {
            return cameraDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<CameraBean> listarCameraNaoDeletada() throws FacadeException {
        try {
            return cameraDaoImpl.listarCameraNaoDeletada();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<CameraBean> listarCamerasAtivas() throws FacadeException {
        try {
            return cameraDaoImpl.listarCamerasAtivas();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<CameraBean> listarCameraOrdenadaPorCodigo() throws FacadeException {
        try {
            return cameraDaoImpl.listarCameraOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<CameraBean> listarCameraOrdenadaPorNome() throws FacadeException {
        try {
            return cameraDaoImpl.listarCameraOrdenadaPorNome();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
