
package util;

import java.util.Collection;

/**
 *
 * @author Wesllen Sousa Lima
 */
public interface BaseFacade<T> {
    public T inserir(T obj) throws FacadeException;
    public T alterar(T obj) throws FacadeException;
    public Boolean excluir(T obj) throws FacadeException;
    public Collection<T> listar() throws FacadeException;
    public T selecionar(Integer id) throws FacadeException;
    public T insereOuAltera(T obj) throws FacadeException;
}
