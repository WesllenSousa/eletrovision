package entidades.dispositivoEletrico.dao;

import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface DispositivoEletricoDao extends BaseDao<DispositivoEletricoBean> {
    
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoNaoDeletado() throws DaoException;
    public DispositivoEletricoBean selecionarDispositivoEletricoPorNome(String nome) throws DaoException;
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoOrdenadaPorCodigo() throws DaoException;
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoPorModulo(ModuloAcionamentoBean moduloAcionamento) throws DaoException;
    
}
