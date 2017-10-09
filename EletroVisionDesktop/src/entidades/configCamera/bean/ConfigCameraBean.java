
package entidades.configCamera.bean;

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
 * @author hendrio
 */
@Entity
@Table(name="configcamera")
public class ConfigCameraBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_configcamera", sequenceName = "configcamera_codigo_seq")
    @GeneratedValue(generator = "seq_configcamera")
    private Integer codigo;
    
    @Column(name = "tipoprocessamento")
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoProcessamentoConfigCamera tipoProcessamento;
    
    @Column(name = "movimento")
    @Enumerated(EnumType.ORDINAL)
    private EnumMovimentoConfigCamera movimento;
    
    @Column(name = "ambientestatico")
    @Enumerated(EnumType.ORDINAL)
    private EnumAmbienteStaticoConfigCamera ambienteStatico;
    
    @Column(name = "face")
    @Enumerated(EnumType.ORDINAL)
    private EnumFaceConfigCamera face;
    
    @Column(name = "olhos")
    @Enumerated(EnumType.ORDINAL)
    private EnumOlhosConfigCamera olhos;
    
    @Column(name = "corpo")
    @Enumerated(EnumType.ORDINAL)
    private EnumCorpoConfigCamera corpo;
    
    @Column(name = "reconhecerface")
    @Enumerated(EnumType.ORDINAL)
    private EnumReconhecerFaceConfigCamera reconhecerFace;
    
    @Column(name = "gravar")
    @Enumerated(EnumType.ORDINAL)
    private EnumGravarConfigCamera gravar;
    
    @Column(name = "objeto")
    @Enumerated(EnumType.ORDINAL)
    private EnumObjetoConfigCamera objeto;
    
    @Column(name = "campanhia")
    @Enumerated(EnumType.ORDINAL)
    private EnumCampanhiaConfigCamera campanhia;
    
    @Column(name = "dispositivo")
    @Enumerated(EnumType.ORDINAL)
    private EnumDispositivoConfigCamera dispositivo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumTipoProcessamentoConfigCamera getTipoProcessamento() {
        return tipoProcessamento;
    }

    public void setTipoProcessamento(EnumTipoProcessamentoConfigCamera tipoProcessamento) {
        this.tipoProcessamento = tipoProcessamento;
    }

    public EnumMovimentoConfigCamera getMovimento() {
        return movimento;
    }

    public void setMovimento(EnumMovimentoConfigCamera movimento) {
        this.movimento = movimento;
    }

    public EnumAmbienteStaticoConfigCamera getAmbienteStatico() {
        return ambienteStatico;
    }

    public void setAmbienteStatico(EnumAmbienteStaticoConfigCamera ambienteStatico) {
        this.ambienteStatico = ambienteStatico;
    }

    public EnumFaceConfigCamera getFace() {
        return face;
    }

    public void setFace(EnumFaceConfigCamera face) {
        this.face = face;
    }

    public EnumOlhosConfigCamera getOlhos() {
        return olhos;
    }

    public void setOlhos(EnumOlhosConfigCamera olhos) {
        this.olhos = olhos;
    }

    public EnumCorpoConfigCamera getCorpo() {
        return corpo;
    }

    public void setCorpo(EnumCorpoConfigCamera corpo) {
        this.corpo = corpo;
    }

    public EnumReconhecerFaceConfigCamera getReconhecerFace() {
        return reconhecerFace;
    }

    public void setReconhecerFace(EnumReconhecerFaceConfigCamera reconhecerFace) {
        this.reconhecerFace = reconhecerFace;
    }

    public EnumGravarConfigCamera getGravar() {
        return gravar;
    }

    public void setGravar(EnumGravarConfigCamera gravar) {
        this.gravar = gravar;
    }

    public EnumObjetoConfigCamera getObjeto() {
        return objeto;
    }

    public void setObjeto(EnumObjetoConfigCamera objeto) {
        this.objeto = objeto;
    }

    public EnumCampanhiaConfigCamera getCampanhia() {
        return campanhia;
    }

    public void setCampanhia(EnumCampanhiaConfigCamera campanhia) {
        this.campanhia = campanhia;
    }

    public EnumDispositivoConfigCamera getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(EnumDispositivoConfigCamera dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + (this.tipoProcessamento != null ? this.tipoProcessamento.hashCode() : 0);
        hash = 67 * hash + (this.movimento != null ? this.movimento.hashCode() : 0);
        hash = 67 * hash + (this.ambienteStatico != null ? this.ambienteStatico.hashCode() : 0);
        hash = 67 * hash + (this.face != null ? this.face.hashCode() : 0);
        hash = 67 * hash + (this.olhos != null ? this.olhos.hashCode() : 0);
        hash = 67 * hash + (this.corpo != null ? this.corpo.hashCode() : 0);
        hash = 67 * hash + (this.reconhecerFace != null ? this.reconhecerFace.hashCode() : 0);
        hash = 67 * hash + (this.gravar != null ? this.gravar.hashCode() : 0);
        hash = 67 * hash + (this.objeto != null ? this.objeto.hashCode() : 0);
        hash = 67 * hash + (this.campanhia != null ? this.campanhia.hashCode() : 0);
        hash = 67 * hash + (this.dispositivo != null ? this.dispositivo.hashCode() : 0);
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
        final ConfigCameraBean other = (ConfigCameraBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (this.tipoProcessamento != other.tipoProcessamento) {
            return false;
        }
        if (this.movimento != other.movimento) {
            return false;
        }
        if (this.ambienteStatico != other.ambienteStatico) {
            return false;
        }
        if (this.face != other.face) {
            return false;
        }
        if (this.olhos != other.olhos) {
            return false;
        }
        if (this.corpo != other.corpo) {
            return false;
        }
        if (this.reconhecerFace != other.reconhecerFace) {
            return false;
        }
        if (this.gravar != other.gravar) {
            return false;
        }
        if (this.objeto != other.objeto) {
            return false;
        }
        if (this.campanhia != other.campanhia) {
            return false;
        }
        if (this.dispositivo != other.dispositivo) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return getCodigo().toString();
    }
    
}
