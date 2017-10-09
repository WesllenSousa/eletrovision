
package entidades.itemAcionamento.bean;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="itensacionamento")
public class ItemAcionamentoBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_itensacionamento", sequenceName = "itensacionamento_codigo_seq")
    @GeneratedValue(generator = "seq_itensacionamento")
    private Integer codigo;
    
    @ManyToOne
    @JoinColumn(name="codacionamento")
    private AcionamentoBean acionamento;
    
    @ManyToOne
    @JoinColumn(name="coddispositivoeletrico")
    private DispositivoEletricoBean dispositivoEletrico;

    public AcionamentoBean getAcionamento() {
        return acionamento;
    }

    public void setAcionamento(AcionamentoBean acionamento) {
        this.acionamento = acionamento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public DispositivoEletricoBean getDispositivoEletrico() {
        return dispositivoEletrico;
    }

    public void setDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico) {
        this.dispositivoEletrico = dispositivoEletrico;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemAcionamentoBean other = (ItemAcionamentoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.acionamento, other.acionamento)) {
            return false;
        }
        if (!Objects.equals(this.dispositivoEletrico, other.dispositivoEletrico)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.acionamento);
        hash = 79 * hash + Objects.hashCode(this.dispositivoEletrico);
        return hash;
    }
    
}
