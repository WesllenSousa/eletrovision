package entidades.configCamera.dao;

import entidades.configCamera.bean.ConfigCameraBean;
import util.BaseDaoImpl;

/**
 *
 * @author hendrio
 */
public class ConfigCameraDaoImpl extends BaseDaoImpl<ConfigCameraBean> implements ConfigCameraDao {

    public ConfigCameraDaoImpl() {
        super(ConfigCameraBean.class);
    }
    
}
