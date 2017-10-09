package entidades.dispositivoEletrico.facade;

import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface DispositivoEletricoFacade extends BaseFacade<DispositivoEletricoBean> {
    
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoNaoDeletado() throws FacadeException;
    public DispositivoEletricoBean selecionarDispositivoEletricoPorNome(String nome) throws FacadeException;
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoOrdenadaPorCodigo() throws FacadeException;
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoPorModulo(ModuloAcionamentoBean moduloAcionamento) throws FacadeException;
    
}
