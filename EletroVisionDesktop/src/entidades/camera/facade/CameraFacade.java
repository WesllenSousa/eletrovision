package entidades.camera.facade;

import entidades.camera.bean.CameraBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface CameraFacade extends BaseFacade<CameraBean> {
    
    public ArrayList<CameraBean> listarCameraNaoDeletada() throws FacadeException;
    public ArrayList<CameraBean> listarCamerasAtivas() throws FacadeException;
    public ArrayList<CameraBean> listarCameraOrdenadaPorCodigo() throws FacadeException;
    public ArrayList<CameraBean> listarCameraOrdenadaPorNome() throws FacadeException;
    
}
