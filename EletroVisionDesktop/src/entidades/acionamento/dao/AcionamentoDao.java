package entidades.acionamento.dao;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface AcionamentoDao extends BaseDao<AcionamentoBean> {
    
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorCodigo() throws DaoException;
    public ArrayList<AcionamentoBean> listarAcionamentoNaoDeletado() throws DaoException;
    public AcionamentoBean selecionaAcionamentoPorNome(String nome) throws DaoException;
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorNome() throws DaoException;
    public ArrayList<AcionamentoBean> listarAcionamentoCriteria(Integer codigo, EnumStatusAcionamento status, 
            EnumLigarDesligarAcionamento ligarDesligar, EnumDeletadoAcionamento deletado, EnumTipoAcionamento tipo,
            PredioBean predio) throws DaoException;
    
}
