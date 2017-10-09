package entidades.moduloAcionamento.facade;

import entidades.marca.bean.MarcaBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import entidades.moduloAcionamento.dao.ModuloAcionamentoDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class ModuloAcionamentoFacadeImpl implements ModuloAcionamentoFacade {

    private ModuloAcionamentoDaoImpl moduloAcionamentoDaoImpl;

    public ModuloAcionamentoFacadeImpl() {
        if (moduloAcionamentoDaoImpl == null) {
            moduloAcionamentoDaoImpl = new ModuloAcionamentoDaoImpl();
        }
    }

    @Override
    public ModuloAcionamentoBean inserir(ModuloAcionamentoBean obj) throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ModuloAcionamentoBean alterar(ModuloAcionamentoBean obj) throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(ModuloAcionamentoBean obj) throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<ModuloAcionamentoBean> listar() throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ModuloAcionamentoBean selecionar(Integer id) throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ModuloAcionamentoBean insereOuAltera(ModuloAcionamentoBean obj) throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }
    
    @Override
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoNaoDeletado() throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.listarModuloAcionamentoNaoDeletado();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<ModuloAcionamentoBean> selecionaModuloAcionamentoPorMarca(MarcaBean marca) throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.selecionaModuloAcionamentoPorMarca(marca);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<ModuloAcionamentoBean> listarModuloAcionamentoOrdenadaPorCodigo() throws FacadeException {
        try {
            return moduloAcionamentoDaoImpl.listarModuloAcionamentoOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
