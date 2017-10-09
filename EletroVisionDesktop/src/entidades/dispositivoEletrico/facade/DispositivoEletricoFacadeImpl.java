package entidades.dispositivoEletrico.facade;

import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.dispositivoEletrico.dao.DispositivoEletricoDaoImpl;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class DispositivoEletricoFacadeImpl implements DispositivoEletricoFacade {

    private DispositivoEletricoDaoImpl dispositivoEletricoDaoImpl;

    public DispositivoEletricoFacadeImpl() {
        if (dispositivoEletricoDaoImpl == null) {
            dispositivoEletricoDaoImpl = new DispositivoEletricoDaoImpl();
        }
    }

    @Override
    public DispositivoEletricoBean inserir(DispositivoEletricoBean obj) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoEletricoBean alterar(DispositivoEletricoBean obj) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(DispositivoEletricoBean obj) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<DispositivoEletricoBean> listar() throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoEletricoBean selecionar(Integer id) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoEletricoBean insereOuAltera(DispositivoEletricoBean obj) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoNaoDeletado() throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.listarDispositivoEletricoNaoDeletado();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public DispositivoEletricoBean selecionarDispositivoEletricoPorNome(String nome) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.selecionarDispositivoEletricoPorNome(nome);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoOrdenadaPorCodigo() throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.listarDispositivoEletricoOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<DispositivoEletricoBean> listarDispositivoEletricoPorModulo(ModuloAcionamentoBean moduloAcionamento) throws FacadeException {
        try {
            return dispositivoEletricoDaoImpl.listarDispositivoEletricoPorModulo(moduloAcionamento);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
