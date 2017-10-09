package entidades.marca.bean;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="marca")
public class MarcaBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_marca", sequenceName = "marca_codigo_seq")
    @GeneratedValue(generator = "seq_marca")
    private Integer codigo;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoMarca deletado;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumDeletadoMarca getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoMarca deletado) {
        this.deletado = deletado;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcaBean other = (MarcaBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        return hash;
    }

    public String toString() {
        return getNome();
    }
    
}
