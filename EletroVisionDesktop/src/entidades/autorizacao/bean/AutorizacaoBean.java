
package entidades.autorizacao.bean;

import entidades.modulo.bean.ModuloBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="autorizacao")
public class AutorizacaoBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_autorizacao", sequenceName = "autorizacao_codigo_seq")
    @GeneratedValue(generator = "seq_autorizacao")
    private Integer codigo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoAutorizacao deletado;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "moduloautorizacao",
    joinColumns = {
    @JoinColumn(name = "codautorizacao")},
    inverseJoinColumns = {
    @JoinColumn(name = "codmodulo")})
    private Collection<ModuloBean> modulos;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<ModuloBean> getModulos() {
        return modulos;
    }

    public void setModulos(Collection<ModuloBean> modulos) {
        this.modulos = modulos;
    }

    public EnumDeletadoAutorizacao getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoAutorizacao deletado) {
        this.deletado = deletado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AutorizacaoBean other = (AutorizacaoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (!Objects.equals(this.modulos, other.modulos)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 29 * hash + Objects.hashCode(this.modulos);
        return hash;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
    
}
