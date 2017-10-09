
package entidades.modulo.bean;

import entidades.autorizacao.bean.AutorizacaoBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Wesllen Sousa Lima
 */
@Entity
@Table(name="modulo")
public class ModuloBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_modulo", sequenceName = "modulo_codigo_seq")
    @GeneratedValue(generator = "seq_modulo")
    private Integer codigo;
    
    @Column(name="nome")
    private String nome;
   
    @ManyToMany
    @JoinTable(name = "moduloautorizacao",
    joinColumns = {
    @JoinColumn(name = "codmodulo")},
    inverseJoinColumns = {
    @JoinColumn(name = "codautorizacao")})
    private Collection<AutorizacaoBean> autorizacoes;

    public Collection<AutorizacaoBean> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Collection<AutorizacaoBean> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

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

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModuloBean other = (ModuloBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.autorizacoes, other.autorizacoes)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.codigo);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.autorizacoes);
        return hash;
    }

    public String toString() {
        return getNome();
    }    
    
}
