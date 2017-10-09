package entidades.acionamento.facade;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.acionamento.bean.EnumDeletadoAcionamento;
import entidades.acionamento.bean.EnumLigarDesligarAcionamento;
import entidades.acionamento.bean.EnumStatusAcionamento;
import entidades.acionamento.bean.EnumTipoAcionamento;
import entidades.acionamento.dao.AcionamentoDaoImpl;
import entidades.predio.bean.PredioBean;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class AcionamentoFacadeImpl implements AcionamentoFacade {

    private AcionamentoDaoImpl acionamentoDaoImpl;

    public AcionamentoFacadeImpl() {
        if (acionamentoDaoImpl == null) {
            acionamentoDaoImpl = new AcionamentoDaoImpl();
        }
    }

    @Override
    public AcionamentoBean inserir(AcionamentoBean obj) throws FacadeException {
        try {
            return acionamentoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcionamentoBean alterar(AcionamentoBean obj) throws FacadeException {
        try {
            return acionamentoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(AcionamentoBean obj) throws FacadeException {
       try {
            return acionamentoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<AcionamentoBean> listar() throws FacadeException {
       try {
            return acionamentoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcionamentoBean selecionar(Integer id) throws FacadeException {
        try {
            return acionamentoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcionamentoBean insereOuAltera(AcionamentoBean obj) throws FacadeException {
        try {
            return acionamentoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AcionamentoBean> listarAcionamentoNaoDeletado() throws FacadeException {
        try {
            return acionamentoDaoImpl.listarAcionamentoNaoDeletado();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public AcionamentoBean selecionaAcionamentoPorNome(String nome) throws FacadeException {
        try {
            return acionamentoDaoImpl.selecionaAcionamentoPorNome(nome);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorCodigo() throws FacadeException {
        try {
            return acionamentoDaoImpl.listarAcionamentoOrdenadoPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }
    
    @Override
    public ArrayList<AcionamentoBean> listarAcionamentoOrdenadoPorNome() throws FacadeException {
        try {
            return acionamentoDaoImpl.listarAcionamentoOrdenadoPorNome();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<AcionamentoBean> listarAcionamentoCriteria(Integer codigo, EnumStatusAcionamento status, 
        EnumLigarDesligarAcionamento ligarDesligar, EnumDeletadoAcionamento deletado, EnumTipoAcionamento tipo, 
        PredioBean predio) throws FacadeException {
        try {
            return acionamentoDaoImpl.listarAcionamentoCriteria(codigo, status, ligarDesligar, deletado, tipo, predio);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
