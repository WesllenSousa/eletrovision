package entidades.modulo.facade;

import entidades.modulo.bean.ModuloBean;
import entidades.modulo.dao.ModuloDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class ModuloFacadeImpl implements ModuloFacade {

    private ModuloDaoImpl moduloDaoImpl;

    public ModuloFacadeImpl() {
        if (moduloDaoImpl == null) {
            moduloDaoImpl = new ModuloDaoImpl();
        }
    }

    @Override
    public ModuloBean inserir(ModuloBean obj) throws FacadeException {
        try {
            return moduloDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ModuloBean alterar(ModuloBean obj) throws FacadeException {
        try {
            return moduloDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(ModuloBean obj) throws FacadeException {
        try {
            return moduloDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<ModuloBean> listar() throws FacadeException {
        try {
            return moduloDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ModuloBean selecionar(Integer id) throws FacadeException {
        try {
            return moduloDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ModuloBean insereOuAltera(ModuloBean obj) throws FacadeException {
        try {
            return moduloDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<ModuloBean> listarModulosOrdenadosPorNome() throws FacadeException {
        try {
            return moduloDaoImpl.listarModulosOrdenadosPorNome();
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
