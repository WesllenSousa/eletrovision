
package entidades.dispositivoEletrico.bean;

import entidades.dispositivo.bean.DispositivoBean;
import entidades.area.bean.AreaBean;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author hendrio
 */
@Entity
@DiscriminatorValue("DispositivoEletrico")
public class DispositivoEletricoBean extends DispositivoBean implements Serializable{
     
    @Column(name="ligardesligar")
    @Enumerated(EnumType.ORDINAL)
    private EnumLigarDesligarDispositivoEletrico ligarDesligar;
    
    @ManyToOne
    @JoinColumn(name="codarea")
    private AreaBean area;
    
    @ManyToOne
    @JoinColumn(name="codmoduloacionamento")
    private ModuloAcionamentoBean moduloAcionamento;
    
    @Column(name="duracao")
    @Enumerated(EnumType.ORDINAL)
    private EnumDuracaoDispositivoEletrico duracao;
    
    public ModuloAcionamentoBean getModuloAcionamento() {
        return moduloAcionamento;
    }

    public void setModuloAcionamento(ModuloAcionamentoBean moduloAcionamento) {
        this.moduloAcionamento = moduloAcionamento;
    }

    public EnumLigarDesligarDispositivoEletrico getLigarDesligar() {
        return ligarDesligar;
    }

    public void setLigarDesligar(EnumLigarDesligarDispositivoEletrico ligarDesligar) {
        this.ligarDesligar = ligarDesligar;
    }

    public AreaBean getArea() {
        return area;
    }

    public void setArea(AreaBean area) {
        this.area = area;
    }

    public EnumDuracaoDispositivoEletrico getDuracao() {
        return duracao;
    }

    public void setDuracao(EnumDuracaoDispositivoEletrico duracao) {
        this.duracao = duracao;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DispositivoEletricoBean other = (DispositivoEletricoBean) obj;
        if (!Objects.equals(this.ligarDesligar, other.ligarDesligar)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.moduloAcionamento, other.moduloAcionamento)) {
            return false;
        }
        if (!Objects.equals(this.duracao, other.duracao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.ligarDesligar);
        hash = 17 * hash + Objects.hashCode(this.area);
        hash = 17 * hash + Objects.hashCode(this.moduloAcionamento);
        hash = 17 * hash + Objects.hashCode(this.duracao);
        return hash;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
    
}
