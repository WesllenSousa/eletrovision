package entidades.dispositivo.dao;

import entidades.dispositivo.bean.DispositivoBean;
import util.BaseDaoImpl;

/**
 *
 * @author hendrio
 */
public class DispositivoDaoImpl extends BaseDaoImpl<DispositivoBean> implements DispositivoDao {
    
    public DispositivoDaoImpl(){
    
        super (DispositivoBean.class);
    }
    
}
