
package entidades.configPredio.dao;

import entidades.configPredio.bean.ConfigPredioBean;
import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigPredioDaoImpl extends BaseDaoImpl<ConfigPredioBean> implements ConfigPredioDao {
    
    public ConfigPredioDaoImpl() {
        super(ConfigPredioBean.class);
    }
    
}
