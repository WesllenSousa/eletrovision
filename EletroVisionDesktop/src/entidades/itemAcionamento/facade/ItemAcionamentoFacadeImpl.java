package entidades.itemAcionamento.facade;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.itemAcionamento.bean.ItemAcionamentoBean;
import entidades.itemAcionamento.dao.ItemAcionamentoDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class ItemAcionamentoFacadeImpl implements ItemAcionamentoFacade {

    private ItemAcionamentoDaoImpl itemAcionamentoDaoImpl;

    public ItemAcionamentoFacadeImpl() {
        if (itemAcionamentoDaoImpl == null) {
            itemAcionamentoDaoImpl = new ItemAcionamentoDaoImpl();
        }
    }

    @Override
    public ItemAcionamentoBean inserir(ItemAcionamentoBean obj) throws FacadeException {
         try {
            return itemAcionamentoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ItemAcionamentoBean alterar(ItemAcionamentoBean obj) throws FacadeException {
        try {
            return itemAcionamentoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(ItemAcionamentoBean obj) throws FacadeException {
        try {
            return itemAcionamentoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<ItemAcionamentoBean> listar() throws FacadeException {
       try {
            return itemAcionamentoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ItemAcionamentoBean selecionar(Integer id) throws FacadeException {
        try {
            return itemAcionamentoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ItemAcionamentoBean insereOuAltera(ItemAcionamentoBean obj) throws FacadeException {
        try {
            return itemAcionamentoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<ItemAcionamentoBean> listarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws FacadeException {
        try {
            return itemAcionamentoDaoImpl.listarItemAcionamentoPorAcionamento(acionamento);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean deletarItemAcionamentoPorAcionamento(AcionamentoBean acionamento) throws FacadeException {
        try {
            return itemAcionamentoDaoImpl.deletarItemAcionamentoPorAcionamento(acionamento);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
