
package entidades.email.bean;

import entidades.pessoa.bean.PessoaBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="email")
public class EmailBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_email", sequenceName = "email_codigo_seq")
    @GeneratedValue(generator = "seq_email")
    private Integer codigo;
    
    @Column(name="email")
    private String email;
    
    @Column(name="senha")
    private String senha;
    
    @Column(name = "enviarautomatico")
    @Enumerated(EnumType.ORDINAL)
    private EnumEnviarAutomaticoEmail enviarAutomatico;
    
    @ManyToOne
    @JoinColumn(name = "codpessoa")
    private PessoaBean pessoa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PessoaBean getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaBean pessoa) {
        this.pessoa = pessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EnumEnviarAutomaticoEmail getEnviarAutomatico() {
        return enviarAutomatico;
    }

    public void setEnviarAutomatico(EnumEnviarAutomaticoEmail enviarAutomatico) {
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
        final EmailBean other = (EmailBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public String toString() {
        return getEmail();
    }
    
}
