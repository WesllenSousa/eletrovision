package entidades.camera.dao;

import entidades.camera.bean.CameraBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface CameraDao extends BaseDao<CameraBean> {
    
    public ArrayList<CameraBean> listarCameraNaoDeletada() throws DaoException;
    public ArrayList<CameraBean> listarCamerasAtivas() throws DaoException;
    public ArrayList<CameraBean> listarCameraOrdenadaPorCodigo() throws DaoException;
    public ArrayList<CameraBean> listarCameraOrdenadaPorNome() throws DaoException;
    
}
