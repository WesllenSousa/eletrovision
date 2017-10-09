
package entidades.telefone.bean;

import entidades.pessoa.bean.PessoaBean;
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
@Table(name = "telefone")
public class TelefoneBean implements Serializable {

    @Id
    @Column(name = "codigo")
    @SequenceGenerator(name = "seq_telefone", sequenceName = "telefone_codigo_seq")
    @GeneratedValue(generator = "seq_telefone")
    private Integer codigo;
    
    @Column(name = "ddd")
    private Integer ddd;
            
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "enviarautomatico")
    @Enumerated(EnumType.ORDINAL)
    private EnumEnviarAutomaticoTelefone enviarAutomatico;
    
    @ManyToOne
    @JoinColumn(name="codpessoa")
    private PessoaBean pessoa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public PessoaBean getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaBean pessoa) {
        this.pessoa = pessoa;
    }

    public EnumEnviarAutomaticoTelefone getEnviarAutomatico() {
        return enviarAutomatico;
    }

    public void setEnviarAutomatico(EnumEnviarAutomaticoTelefone enviarAutomatico) {
        this.enviarAutomatico = enviarAutomatico;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelefoneBean other = (TelefoneBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.enviarAutomatico, other.enviarAutomatico)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.ddd);
        hash = 19 * hash + Objects.hashCode(this.numero);
        hash = 19 * hash + Objects.hashCode(this.pessoa);
        hash = 19 * hash + Objects.hashCode(this.enviarAutomatico);
        return hash;
    }

    @Override
    public String toString() {
        return getDdd()+"-"+getNumero().toString();
    }
    
}
