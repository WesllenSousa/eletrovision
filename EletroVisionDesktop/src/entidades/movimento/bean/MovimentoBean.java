package entidades.movimento.bean;

import entidades.camera.bean.CameraBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="movimento")
public class MovimentoBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_movimento", sequenceName = "movimento_codigo_seq")
    @GeneratedValue(generator = "seq_movimento")
    private Integer codigo;
    
    @Column(name="data_hms")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar data_hms;
            
    @Column(name="diretorio")        
    private String diretorio;
    
    @Column(name="qtdepessoas")
    private Integer qtdePessoas;
    
    @Column(name="qtdeobjetos")
    private Integer qtdeObjetos;
    
    @ManyToOne
    @JoinColumn(name="codcamera")
    private CameraBean camera;

    public CameraBean getCamera() {
        return camera;
    }

    public void setCamera(CameraBean camera) {
        this.camera = camera;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Calendar getData_hms() {
        return data_hms;
    }

    public void setData_hms(Calendar data_HMS) {
        this.data_hms = data_HMS;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public Integer getQtdeObjetos() {
        return qtdeObjetos;
    }

    public void setQtdeObjetos(Integer qtdeObjetos) {
        this.qtdeObjetos = qtdeObjetos;
    }

    public Integer getQtdePessoas() {
        return qtdePessoas;
    }

    public void setQtdePessoas(Integer qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovimentoBean other = (MovimentoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.data_hms, other.data_hms)) {
            return false;
        }
        if (!Objects.equals(this.diretorio, other.diretorio)) {
            return false;
        }
        if (!Objects.equals(this.qtdePessoas, other.qtdePessoas)) {
            return false;
        }
        if (!Objects.equals(this.qtdeObjetos, other.qtdeObjetos)) {
            return false;
        }
        if (!Objects.equals(this.camera, other.camera)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codigo);
        hash = 73 * hash + Objects.hashCode(this.data_hms);
        hash = 73 * hash + Objects.hashCode(this.diretorio);
        hash = 73 * hash + Objects.hashCode(this.qtdePessoas);
        hash = 73 * hash + Objects.hashCode(this.qtdeObjetos);
        hash = 73 * hash + Objects.hashCode(this.camera);
        return hash;
    }

    @Override
    public String toString() {
        return "Movimento: " + getCodigo()+ ", Câmera: " + getCamera().getNome();
    } 
    
}
