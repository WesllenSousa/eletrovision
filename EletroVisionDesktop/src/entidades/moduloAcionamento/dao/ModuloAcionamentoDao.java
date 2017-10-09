package entidades.moduloAcionamento.dao;

import entidades.marca.bean.MarcaBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface ModuloAcionamentoDao extends BaseDao<ModuloAcionamentoBean> {
    
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoNaoDeletado() throws DaoException;
    public ArrayList<ModuloAcionamentoBean> selecionaModuloAcionamentoPorMarca(MarcaBean marca) throws DaoException;
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoOrdenadaPorCodigo() throws DaoException;
    
}
