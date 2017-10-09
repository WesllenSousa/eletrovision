
package entidades.configPessoa.bean;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Wesllen Sousa Lima
 */
@Entity
@Table(name="configpessoa")
public class ConfigPessoaBean implements Serializable {
    
    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_configpessoa", sequenceName = "configpessoa_codigo_seq")
    @GeneratedValue(generator = "seq_configpessoa")
    private Integer codigo;
    
    @Column(name = "ativaralarmegps")
    @Enumerated(EnumType.ORDINAL)
    private EnumAlarmeGpsConfigPessoa alarmeGps;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumAlarmeGpsConfigPessoa getAlarmeGps() {
        return alarmeGps;
    }

    public void setAlarmeGps(EnumAlarmeGpsConfigPessoa alarmeGps) {
        this.alarmeGps = alarmeGps;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codigo);
        hash = 83 * hash + (this.alarmeGps != null ? this.alarmeGps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConfigPessoaBean other = (ConfigPessoaBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (this.alarmeGps != other.alarmeGps) {
            return false;
        }
        return true;
    }
    
}
