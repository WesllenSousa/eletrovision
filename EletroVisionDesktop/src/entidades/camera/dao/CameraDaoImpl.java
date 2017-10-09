/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.camera.dao;

import entidades.camera.bean.CameraBean;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public class CameraDaoImpl extends BaseDaoImpl<CameraBean> implements CameraDao {

    public CameraDaoImpl() {
        super(CameraBean.class);
    }
    
    @Override
    public ArrayList<CameraBean> listarCameraNaoDeletada() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT c FROM CameraBean c where c.deletado = 0 order by c.nome");
            return (ArrayList<CameraBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override
    public ArrayList<CameraBean> listarCamerasAtivas() throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT c FROM CameraBean c where c.deletado = 0 and c.status = 0 order by c.nome");
            return (ArrayList<CameraBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override
    public ArrayList<CameraBean> listarCameraOrdenadaPorCodigo() throws DaoException {
         try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT c FROM CameraBean c where c.deletado = 0 order by c.codigo");
            return (ArrayList<CameraBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override
    public ArrayList<CameraBean> listarCameraOrdenadaPorNome() throws DaoException {
         try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT c FROM CameraBean c where c.deletado = 0 order by c.nome");
            return (ArrayList<CameraBean>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } 
    }
    
}
