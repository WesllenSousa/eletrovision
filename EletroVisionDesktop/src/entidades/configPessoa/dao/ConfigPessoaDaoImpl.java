
package entidades.configPessoa.dao;

import entidades.configPessoa.bean.ConfigPessoaBean;
import util.BaseDaoImpl;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigPessoaDaoImpl extends BaseDaoImpl<ConfigPessoaBean> implements ConfigPessoaDao {
    
    public ConfigPessoaDaoImpl() {
        super(ConfigPessoaBean.class);
    }
    
}
