
package entidades.acesso.bean;

import entidades.usuario.bean.UsuarioBean;
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
@Table(name = "acesso")
public class AcessoBean implements Serializable {

    @Id
    @Column(name = "codigo")
    @SequenceGenerator(name = "seq_acesso", sequenceName = "acesso_codigo_seq")
    @GeneratedValue(generator = "seq_acesso")
    private Integer codigo;
    
    @Column(name = "datahorainicio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataHoraInicio;
    
    @Column(name = "datahorafim")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataHoraFim;
    
    @ManyToOne
    @JoinColumn(name = "codusuario")
    private UsuarioBean usuario;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Calendar dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Calendar getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Calendar dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AcessoBean other = (AcessoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.dataHoraInicio, other.dataHoraInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataHoraFim, other.dataHoraFim)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.dataHoraInicio);
        hash = 79 * hash + Objects.hashCode(this.dataHoraFim);
        hash = 79 * hash + Objects.hashCode(this.usuario);
        return hash;
    }
    
}
