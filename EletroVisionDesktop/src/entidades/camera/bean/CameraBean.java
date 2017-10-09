
package entidades.camera.bean;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.configCamera.bean.ConfigCameraBean;
import entidades.dispositivo.bean.DispositivoBean;
import entidades.area.bean.AreaBean;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author hendrio
 */
@Entity
@DiscriminatorValue("Camera")
public class CameraBean extends DispositivoBean {
    
    @ManyToOne
    @JoinColumn(name="codarea")
    private AreaBean area;
    
    @ManyToOne
    @JoinColumn(name="codconfigcamera")
    private ConfigCameraBean configCamera;
    
    @Column(name="usuario")
    private String usuario;
    
    @Column(name="senha")
    private String senha;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "agendarcamera",
    joinColumns = {
    @JoinColumn(name = "codcamera")},
    inverseJoinColumns = {
    @JoinColumn(name = "codagendartarefas")})
    private Collection<AgendarTarefasBean> agendarTarefas;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "acionamentodispositivo",
    joinColumns = {
    @JoinColumn(name = "coddispositivo")},
    inverseJoinColumns = {
    @JoinColumn(name = "codacionamento")})
    private Collection<AcionamentoBean> acionamentos;

    public AreaBean getArea() {
        return area;
    }

    public void setArea(AreaBean local) {
        this.area = local;
    }

    public ConfigCameraBean getConfigCamera() {
        return configCamera;
    }

    public void setConfigCamera(ConfigCameraBean configCamera) {
        this.configCamera = configCamera;
    }

    public Collection<AgendarTarefasBean> getAgendarTarefas() {
        return agendarTarefas;
    }

    public void setAgendarTarefas(Collection<AgendarTarefasBean> agendarTarefas) {
        this.agendarTarefas = agendarTarefas;
    }

    public void setAcionamentos(Collection<AcionamentoBean> acionamentos) {
        this.acionamentos = acionamentos;
    }
    
    public Collection<AcionamentoBean> getAcionamentos() {
        return acionamentos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    } 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CameraBean other = (CameraBean) obj;
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.configCamera, other.configCamera)) {
            return false;
        }
        if (!Objects.equals(this.acionamentos, other.acionamentos)) {
            return false;
        }
        if (!Objects.equals(this.agendarTarefas, other.agendarTarefas)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.area);
        hash = 89 * hash + Objects.hashCode(this.configCamera);
        hash = 89 * hash + Objects.hashCode(this.acionamentos);
        hash = 89 * hash + Objects.hashCode(this.agendarTarefas);
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.senha);
        return hash;
    }
    
    @Override
    public String toString() {
        return getNome();
    }

}
