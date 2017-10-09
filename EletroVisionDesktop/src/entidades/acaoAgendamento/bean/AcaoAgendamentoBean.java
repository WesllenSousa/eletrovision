
package entidades.acaoAgendamento.bean;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import util.Validacao;

/**
 *
 * @author Wesllen
 */
@Entity
@Table(name="acaoagendamento")
public class AcaoAgendamentoBean implements Serializable{
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_acaoagendamento", sequenceName = "acaoagendamento_codigo_seq")
    @GeneratedValue(generator = "seq_acaoagendamento")
    private Integer codigo;
    
    @Column(name="acao")
    private String acao;
    
    @Column(name = "tipovinculo")
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoVinculoAcaoAgendamento tipoVinculo;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumTipoVinculoAcaoAgendamento getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(EnumTipoVinculoAcaoAgendamento tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AcaoAgendamentoBean other = (AcaoAgendamentoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.acao, other.acao)) {
            return false;
        }
        if (this.tipoVinculo != other.tipoVinculo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.acao);
        hash = 97 * hash + (this.tipoVinculo != null ? this.tipoVinculo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        if(Validacao.verificaNumeroInteger(getAcao()))
            return "Personalizado "+getAcao();
        else
            return getAcao();
    }  
    
}
