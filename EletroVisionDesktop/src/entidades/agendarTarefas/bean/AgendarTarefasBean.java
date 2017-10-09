
package entidades.agendarTarefas.bean;

import entidades.acaoAgendamento.bean.AcaoAgendamentoBean;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.camera.bean.CameraBean;
import entidades.mensagem.bean.MensagemBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name = "agendartarefas")
public class AgendarTarefasBean implements Serializable {

    @Id
    @Column(name = "codigo")
    @SequenceGenerator(name = "seq_agendartarefas", sequenceName = "agendartarefas_codigo_seq")
    @GeneratedValue(generator = "seq_agendartarefas")
    private Integer codigo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "disparolegivel")
    private String disparoLegivel;
    
    @Column(name = "disparo")
    private String disparo;
    
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private EnumStatusAgendarTarefas status;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoAgendarTarefas deletado;
    
    @Column(name = "tipovinculo")
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoVinculoAgendarTarefas tipoVinculo;

    @ManyToOne
    @JoinColumn(name = "codacaoagendamento")
    private AcaoAgendamentoBean acaoAgendamento;
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "agendarmensagem",
    joinColumns = {
    @JoinColumn(name = "codagendartarefas")},
    inverseJoinColumns = {
    @JoinColumn(name = "codmensagem")})
    private Collection<MensagemBean> mensagens;
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "agendaracionamento",
    joinColumns = {
    @JoinColumn(name = "codagendartarefas")},
    inverseJoinColumns = {
    @JoinColumn(name = "codacionamento")})
    private Collection<AcionamentoBean> acionamentos;
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "agendarcamera",
    joinColumns = {
    @JoinColumn(name = "codagendartarefas")},
    inverseJoinColumns = {
    @JoinColumn(name = "codcamera")})
    private Collection<CameraBean> cameras;

    public AcaoAgendamentoBean getAcaoAgendamento() {
        return acaoAgendamento;
    }

    public void setAcaoAgendamento(AcaoAgendamentoBean acaoAgendamento) {
        this.acaoAgendamento = acaoAgendamento;
    }

    public Collection<AcionamentoBean> getAcionamentos() {
        return acionamentos;
    }

    public void setAcionamentos(Collection<AcionamentoBean> acionamentos) {
        this.acionamentos = acionamentos;
    }

    public Collection<CameraBean> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<CameraBean> cameras) {
        this.cameras = cameras;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumDeletadoAgendarTarefas getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoAgendarTarefas deletado) {
        this.deletado = deletado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDisparo() {
        return disparo;
    }

    public void setDisparo(String disparo) {
        this.disparo = disparo;
    }

    public String getDisparoLegivel() {
        return disparoLegivel;
    }

    public void setDisparoLegivel(String disparoLegivel) {
        this.disparoLegivel = disparoLegivel;
    }

    public Collection<MensagemBean> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Collection<MensagemBean> mensagens) {
        this.mensagens = mensagens;
    }

    public EnumStatusAgendarTarefas getStatus() {
        return status;
    }

    public void setStatus(EnumStatusAgendarTarefas status) {
        this.status = status;
    }

    public EnumTipoVinculoAgendarTarefas getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(EnumTipoVinculoAgendarTarefas tipoVinculo) {
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
        final AgendarTarefasBean other = (AgendarTarefasBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.disparoLegivel, other.disparoLegivel)) {
            return false;
        }
        if (!Objects.equals(this.disparo, other.disparo)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (this.tipoVinculo != other.tipoVinculo) {
            return false;
        }
        if (!Objects.equals(this.acaoAgendamento, other.acaoAgendamento)) {
            return false;
        }
        if (!Objects.equals(this.mensagens, other.mensagens)) {
            return false;
        }
        if (!Objects.equals(this.acionamentos, other.acionamentos)) {
            return false;
        }
        if (!Objects.equals(this.cameras, other.cameras)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.disparoLegivel);
        hash = 89 * hash + Objects.hashCode(this.disparo);
        hash = 89 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 89 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 89 * hash + (this.tipoVinculo != null ? this.tipoVinculo.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.acaoAgendamento);
        hash = 89 * hash + Objects.hashCode(this.mensagens);
        hash = 89 * hash + Objects.hashCode(this.acionamentos);
        hash = 89 * hash + Objects.hashCode(this.cameras);
        return hash;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }

}
