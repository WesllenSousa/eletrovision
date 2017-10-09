
package entidades.logAcoes.bean;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.pessoa.bean.PessoaBean;
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
 * @author hendrio
 */
@Entity
@Table (name="logacoes")
public class LogAcoesBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_logacoes", sequenceName = "logacoes_codigo_seq")
    @GeneratedValue(generator = "seq_logacoes")
    private Integer codigo;
    
    @Column (name="descricao")
    private String descricao;
    
    @Column (name="datahora")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataHora;
    
    @Column(name = "rede")
    @Enumerated(EnumType.ORDINAL)
    private EnumRedeLogAcoes rede;
    
    @ManyToOne
    @JoinColumn(name="codresponsavel")
    private PessoaBean responsavel;
    
    @ManyToOne
    @JoinColumn(name="codacionamento")
    private AcionamentoBean acionamento;
    
    @ManyToOne
    @JoinColumn(name="coddispositivo")
    private DispositivoEletricoBean dispositivoEletrico;
    
    @ManyToOne
    @JoinColumn(name="codagendartarefas")
    private AgendarTarefasBean agendarTarefas;

    public AcionamentoBean getAcionamento() {
        return acionamento;
    }

    public void setAcionamento(AcionamentoBean acionamento) {
        this.acionamento = acionamento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer cogigo) {
        this.codigo = cogigo;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHoraCalendar) {
        this.dataHora = dataHoraCalendar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public PessoaBean getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(PessoaBean responsavel) {
        this.responsavel = responsavel;
    }

    public EnumRedeLogAcoes getRede() {
        return rede;
    }

    public void setRede(EnumRedeLogAcoes status) {
        this.rede = status;
    }

    public AgendarTarefasBean getAgendarTarefas() {
        return agendarTarefas;
    }

    public void setAgendarTarefas(AgendarTarefasBean agendarTarefas) {
        this.agendarTarefas = agendarTarefas;
    }

    public DispositivoEletricoBean getDispositivoEletrico() {
        return dispositivoEletrico;
    }

    public void setDispositivoEletrico(DispositivoEletricoBean dispositivoEletrico) {
        this.dispositivoEletrico = dispositivoEletrico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LogAcoesBean other = (LogAcoesBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (this.rede != other.rede) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        if (!Objects.equals(this.acionamento, other.acionamento)) {
            return false;
        }
        if (!Objects.equals(this.dispositivoEletrico, other.dispositivoEletrico)) {
            return false;
        }
        if (!Objects.equals(this.agendarTarefas, other.agendarTarefas)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.dataHora);
        hash = 29 * hash + (this.rede != null ? this.rede.hashCode() : 0);
        hash = 29 * hash + Objects.hashCode(this.responsavel);
        hash = 29 * hash + Objects.hashCode(this.acionamento);
        hash = 29 * hash + Objects.hashCode(this.dispositivoEletrico);
        hash = 29 * hash + Objects.hashCode(this.agendarTarefas);
        return hash;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
    
}
