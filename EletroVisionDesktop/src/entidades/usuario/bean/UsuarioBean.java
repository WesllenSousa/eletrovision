
package entidades.usuario.bean;

import entidades.autorizacao.bean.AutorizacaoBean;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hendrio Luis
 */
@Entity
@Table(name="usuario")
public class UsuarioBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "usuario_codigo_seq")
    @GeneratedValue(generator = "seq_usuario")
    private Integer codigo;
    
    @Column(name="login")
    private String login;
    
    @Column(name="senha")
    private String senha;
    
    @OneToOne
    @JoinColumn(name="codpessoa")
    private PessoaBean pessoa;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoUsuario deletado;
    
    @ManyToOne
    @JoinColumn(name="codautorizacao")
    private AutorizacaoBean autorizacao;

    public AutorizacaoBean getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(AutorizacaoBean autorizacao) {
        this.autorizacao = autorizacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public EnumDeletadoUsuario getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoUsuario deletado) {
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
        final UsuarioBean other = (UsuarioBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (!Objects.equals(this.autorizacao, other.autorizacao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.pessoa);
        hash = 67 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 67 * hash + Objects.hashCode(this.autorizacao);
        return hash;
    }

    @Override
    public String toString() {
        return getLogin();
    }
    
}
