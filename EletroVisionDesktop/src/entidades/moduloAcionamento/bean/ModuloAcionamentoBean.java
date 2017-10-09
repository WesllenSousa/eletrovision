
package entidades.moduloAcionamento.bean;

import entidades.dispositivo.bean.DispositivoBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author hendrio
 */
@Entity
@DiscriminatorValue("ModuloAcionamento")
public class ModuloAcionamentoBean extends DispositivoBean implements Serializable{

    @Column(name="qtdesaida")
    private Integer qtdeSaida;
    
    public Integer getQtdeSaida() {
        return qtdeSaida;
    }

    public void setQtdeSaida(Integer qtdeSaida) {
        this.qtdeSaida = qtdeSaida;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModuloAcionamentoBean other = (ModuloAcionamentoBean) obj;
        if (!Objects.equals(this.qtdeSaida, other.qtdeSaida)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.qtdeSaida);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
