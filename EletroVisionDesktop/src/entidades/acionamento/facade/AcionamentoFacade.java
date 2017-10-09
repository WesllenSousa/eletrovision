package entidades.acionamento.facade;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import util.BaseFacade;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public interface AcionamentoFacade extends BaseFacade<AcionamentoBean> {
    
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorCodigo() throws FacadeException; 
    public ArrayList<AcionamentoBean> listarAcionamentoNaoDeletado() throws FacadeException;
    public AcionamentoBean selecionaAcionamentoPorNome(String nome) throws FacadeException;
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorNome() throws FacadeException;
    public ArrayList<AcionamentoBean> listarAcionamentoCriteria(Integer codigo, EnumStatusAcionamento status, 
            EnumLigarDesligarAcionamento ligarDesligar, EnumDeletadoAcionamento deletado, EnumTipoAcionamento tipo,
            PredioBean predio) throws FacadeException;
    
}
