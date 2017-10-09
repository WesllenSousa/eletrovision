package entidades.predio.bean;

import entidades.configPredio.bean.ConfigPredioBean;
import entidades.endereco.bean.EnderecoBean;
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
@Table(name="predio")
public class PredioBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_predio", sequenceName = "predio_codigo_seq")
    @GeneratedValue(generator = "seq_predio")
    private Integer codigo;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="foto")
    private String foto;
    
    @Column(name="tipo")
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoPredio tipo;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoPredio deletado;
    
    @ManyToOne
    @JoinColumn(name="codendereco")
    private EnderecoBean endereco;
    
    @ManyToOne
    @JoinColumn(name="codconfigpredio")
    private ConfigPredioBean configPredio;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnderecoBean getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBean endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumTipoPredio getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoPredio tipo) {
        this.tipo = tipo;
    }

    public EnumDeletadoPredio getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoPredio deletado) {
        this.deletado = deletado;
    }

    public ConfigPredioBean getConfigPredio() {
        return configPredio;
    }

    public void setConfigPredio(ConfigPredioBean configPredio) {
        this.configPredio = configPredio;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PredioBean other = (PredioBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
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
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.codigo);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.foto);
        hash = 71 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 71 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 71 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
