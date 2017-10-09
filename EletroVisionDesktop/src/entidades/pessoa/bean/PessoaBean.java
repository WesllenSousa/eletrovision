
package entidades.pessoa.bean;

import entidades.configPessoa.bean.ConfigPessoaBean;
import entidades.endereco.bean.EnderecoBean;
import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;

/**
 *
 * @author Wesllen Sousa Lima
 */
@Entity
@Table(name="pessoa")
public class PessoaBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "pessoa_codigo_seq")
    @GeneratedValue(generator = "seq_pessoa")
    private Integer codigo;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="rg")
    private String rg;
    
    @Column(name="foto")
    private String foto;
    
    @Column(name="data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar data;
    
    @Column(name="situacao")
    @Enumerated(EnumType.ORDINAL)
    private EnumSituacaoPessoa situacao;
    
    @Column(name="tipo")
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoPessoa tipo;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoPessoa deletado;
    
    @ManyToOne
    @JoinColumn(name="codendereco")
    private EnderecoBean endereco;
    
    @ManyToOne
    @JoinColumn(name="codconfigpessoa")
    private ConfigPessoaBean configPessoa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public EnderecoBean getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBean endereco) {
        this.endereco = endereco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EnumSituacaoPessoa getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacaoPessoa situacao) {
        this.situacao = situacao;
    }

    public EnumTipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoPessoa tipo) {
        this.tipo = tipo;
    }

    public EnumDeletadoPessoa getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoPessoa deletado) {
        this.deletado = deletado;
    }

    public ConfigPessoaBean getConfigPessoa() {
        return configPessoa;
    }

    public void setConfigPessoa(ConfigPessoaBean configPessoa) {
        this.configPessoa = configPessoa;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaBean other = (PessoaBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (this.situacao != other.situacao) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.configPessoa, other.configPessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.cpf);
        hash = 53 * hash + Objects.hashCode(this.rg);
        hash = 53 * hash + Objects.hashCode(this.foto);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + (this.situacao != null ? this.situacao.hashCode() : 0);
        hash = 53 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 53 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 53 * hash + Objects.hashCode(this.endereco);
        hash = 53 * hash + Objects.hashCode(this.configPessoa);
        return hash;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
    
}
