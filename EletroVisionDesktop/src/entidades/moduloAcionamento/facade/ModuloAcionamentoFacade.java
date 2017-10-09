package entidades.moduloAcionamento.facade;

import entidades.marca.bean.MarcaBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface ModuloAcionamentoFacade extends BaseFacade<ModuloAcionamentoBean> {
    
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoNaoDeletado() throws FacadeException;
    public ArrayList<ModuloAcionamentoBean> selecionaModuloAcionamentoPorMarca(MarcaBean marca) throws FacadeException;
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoOrdenadaPorCodigo() throws FacadeException;
    
}
