
package entidades.dispositivo.bean;

import entidades.marca.bean.MarcaBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hendrio
 */

@Entity
@Table(name = "dispositivo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class DispositivoBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_dispositivo", sequenceName = "dispositivo_codigo_seq")
    @GeneratedValue(generator = "seq_dispositivo")
    private Integer codigo;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="foto")
    private String foto;
    
    @Column(name="identificacao")
    private String identificacao;
    
    @Column(name = "porta")
    private Integer porta;
    
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private EnumStatusDispositivo status;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoDispositivo deletado;
    
    @ManyToOne
    @JoinColumn(name="codmarca")
    private MarcaBean marcaBean;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumDeletadoDispositivo getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoDispositivo delegado) {
        this.deletado = delegado;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public MarcaBean getMarcaBean() {
        return marcaBean;
    }

    public void setMarcaBean(MarcaBean marcaBean) {
        this.marcaBean = marcaBean;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumStatusDispositivo getStatus() {
        return status;
    }

    public void setStatus(EnumStatusDispositivo status) {
        this.status = status;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DispositivoBean other = (DispositivoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.identificacao, other.identificacao)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (!Objects.equals(this.marcaBean, other.marcaBean)) {
            return false;
        }
        if (!Objects.equals(this.porta, other.porta)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3; 
        hash = 83 * hash + Objects.hashCode(this.codigo);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.foto);
        hash = 83 * hash + Objects.hashCode(this.identificacao);
        hash = 83 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 83 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 83 * hash + Objects.hashCode(this.marcaBean);
        hash = 83 * hash + Objects.hashCode(this.porta);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
