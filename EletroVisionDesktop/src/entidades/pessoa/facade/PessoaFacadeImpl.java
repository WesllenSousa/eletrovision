package entidades.pessoa.facade;

import entidades.pessoa.bean.EnumSituacaoPessoa;
import entidades.pessoa.bean.EnumTipoPessoa;
import entidades.pessoa.bean.PessoaBean;
import entidades.pessoa.dao.PessoaDaoImpl;
import java.util.ArrayList;
import java.util.Collection;
import util.DaoException;
import util.FacadeException;

/**
 *
 * @author hendrio
 */
public class PessoaFacadeImpl implements PessoaFacade {

    private PessoaDaoImpl pessoaDaoImpl;

    public PessoaFacadeImpl() {
        if (pessoaDaoImpl == null) {
            pessoaDaoImpl = new PessoaDaoImpl();
        }
    }

    @Override
    public PessoaBean inserir(PessoaBean obj) throws FacadeException {
        try {
            return pessoaDaoImpl.inserir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public PessoaBean alterar(PessoaBean obj) throws FacadeException {
        try {
            return pessoaDaoImpl.alterar(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Boolean excluir(PessoaBean obj) throws FacadeException {
        try {
            return pessoaDaoImpl.excluir(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public Collection<PessoaBean> listar() throws FacadeException {
        try {
            return pessoaDaoImpl.listar();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public PessoaBean selecionar(Integer id) throws FacadeException {
        try {
            return pessoaDaoImpl.selecionar(id);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public PessoaBean insereOuAltera(PessoaBean obj) throws FacadeException {
        try {
            return pessoaDaoImpl.insereOuAltera(obj);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PessoaBean> pesquisarPessoaPorTipo(EnumTipoPessoa tipo) throws FacadeException {
        try {
            return pessoaDaoImpl.pesquisarPessoaPorTipo(tipo);
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PessoaBean> listarCameraNaoDeletada() throws FacadeException {
        try {
            return pessoaDaoImpl.listarCameraNaoDeletada();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PessoaBean> listarPessoaOrdenadaPorCodigo() throws FacadeException {
        try {
            return pessoaDaoImpl.listarPessoaOrdenadaPorCodigo();
        } catch (DaoException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<PessoaBean> listarPessoasCriteria(Integer codigo, EnumTipoPessoa tipo, EnumSituacaoPessoa situacao) throws FacadeException {
        try {
            return pessoaDaoImpl.listarPessoasCriteria(codigo, tipo, situacao);
        } catch (DaoException ex) {
        }
        return null;
    }
    
}
