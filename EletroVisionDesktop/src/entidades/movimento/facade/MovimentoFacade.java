package entidades.movimento.facade;

import entidades.movimento.bean.MovimentoBean;
import java.util.ArrayList;
import java.util.Calendar;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface MovimentoFacade extends BaseFacade<MovimentoBean> {
    
    public ArrayList<MovimentoBean> listarMovimentoOrdenadoPorData() throws FacadeException;
    public MovimentoBean listarUltimoRegistro() throws FacadeException;
    public ArrayList<MovimentoBean> listarMovimentoCriteria(Integer codigo,
            Calendar dataInicio, Calendar dataFim) throws FacadeException;
    
}
