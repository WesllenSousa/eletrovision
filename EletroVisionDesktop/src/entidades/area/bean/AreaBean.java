
package entidades.area.bean;

import entidades.predio.bean.PredioBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="area")
public class AreaBean implements Serializable {
          
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_area", sequenceName = "area_codigo_seq")
    @GeneratedValue(generator = "seq_area")
    private Integer codigo;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoArea deletado;
    
    @ManyToOne
    @JoinColumn(name="codpredio")
    private PredioBean predio;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumDeletadoArea getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoArea deletado) {
        this.deletado = deletado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PredioBean getPredio() {
        return predio;
    }

    public void setPredio(PredioBean predio) {
        this.predio = predio;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AreaBean other = (AreaBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (!Objects.equals(this.predio, other.predio)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 47 * hash + Objects.hashCode(this.predio);
        return hash;
    }

    public String toString() {
        return getNome();
    }

}
