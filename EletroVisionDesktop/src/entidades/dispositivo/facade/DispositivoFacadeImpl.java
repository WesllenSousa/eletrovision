package entidades.dispositivo.facade;

import entidades.dispositivo.bean.DispositivoBean;
import entidades.dispositivo.dao.DispositivoDaoImpl;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class DispositivoFacadeImpl implements DispositivoFacade {

    private DispositivoDaoImpl dispositivoDaoImpl;

    public DispositivoFacadeImpl() {

        if (dispositivoDaoImpl == null) {

            dispositivoDaoImpl = new DispositivoDaoImpl();
        }
    }

    @Override
    public DispositivoBean inserir(DispositivoBean obj) throws FacadeException {
        try {
            return dispositivoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoBean alterar(DispositivoBean obj) throws FacadeException {
        try {
            return dispositivoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(DispositivoBean obj) throws FacadeException {
        try {
            return dispositivoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<DispositivoBean> listar() throws FacadeException {
        try {
            return dispositivoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoBean selecionar(Integer id) throws FacadeException {
        try {
            return dispositivoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoBean insereOuAltera(DispositivoBean obj) throws FacadeException {
        try {
            return dispositivoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }
}
