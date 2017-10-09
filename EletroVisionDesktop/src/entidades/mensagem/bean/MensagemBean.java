
package entidades.mensagem.bean;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.movimento.bean.MovimentoBean;
import entidades.pessoa.bean.PessoaBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="mensagem")
public class MensagemBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_mensagem", sequenceName = "mensagem_codigo_seq")
    @GeneratedValue(generator = "seq_mensagem")
    private Integer codigo; 
    
    @Column(name="assunto") 
    private String assunto;
    
    @Column(name="mensagem") 
    private String mensagem;
    
    @ManyToOne
    @JoinColumn(name="codorigem")
    private PessoaBean origem;
    
    @ManyToOne
    @JoinColumn(name="coddestino")
    private PessoaBean destino;
    
    @Column(name="tipo")  
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoMensagem tipo; 
    
    @Column(name="exibir")  
    @Enumerated(EnumType.ORDINAL)
    private EnumExibirMensagem exibir;
    
    @Column(name="leitura")  
    @Enumerated(EnumType.ORDINAL)
    private EnumLeituraMensagem leitura;
    
    @Column(name="datahora")    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataHora;
    
    @ManyToOne
    @JoinColumn(name="codmovimento")
    private MovimentoBean movimento;
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "agendarmensagem",
    joinColumns = {
    @JoinColumn(name = "codmensagem")},
    inverseJoinColumns = {
    @JoinColumn(name = "codagendartarefas")})
    private Collection<AgendarTarefasBean> agendarTarefas;

    public Collection<AgendarTarefasBean> getAgendarTarefas() {
        return agendarTarefas;
    }

    public void setAgendarTarefas(Collection<AgendarTarefasBean> agendamentoTarefas) {
        this.agendarTarefas = agendamentoTarefas;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public PessoaBean getDestino() {
        return destino;
    }

    public void setDestino(PessoaBean destino) {
        this.destino = destino;
    }

    public EnumExibirMensagem getExibir() {
        return exibir;
    }

    public void setExibir(EnumExibirMensagem exibir) {
        this.exibir = exibir;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public MovimentoBean getMovimento() {
        return movimento;
    }

    public void setMovimento(MovimentoBean movimento) {
        this.movimento = movimento;
    }

    public PessoaBean getOrigem() {
        return origem;
    }

    public void setOrigem(PessoaBean origem) {
        this.origem = origem;
    }

    public EnumTipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoMensagem tipo) {
        this.tipo = tipo;
    }

    public EnumLeituraMensagem getLeitura() {
        return leitura;
    }

    public void setLeitura(EnumLeituraMensagem leitura) {
        this.leitura = leitura;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MensagemBean other = (MensagemBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.exibir != other.exibir) {
            return false;
        }
        if (this.leitura != other.leitura) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (!Objects.equals(this.movimento, other.movimento)) {
            return false;
        }
        if (!Objects.equals(this.agendarTarefas, other.agendarTarefas)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + Objects.hashCode(this.assunto);
        hash = 89 * hash + Objects.hashCode(this.mensagem);
        hash = 89 * hash + Objects.hashCode(this.origem);
        hash = 89 * hash + Objects.hashCode(this.destino);
        hash = 89 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 89 * hash + (this.exibir != null ? this.exibir.hashCode() : 0);
        hash = 89 * hash + (this.leitura != null ? this.leitura.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.dataHora);
        hash = 89 * hash + Objects.hashCode(this.movimento);
        hash = 89 * hash + Objects.hashCode(this.agendarTarefas);
        return hash;
    }

    @Override
    public String toString() {
        String toString = getAssunto();
        if(getMensagem().length() >= 15) {
            toString += ": "+getMensagem().substring(0, 15)+"...";
        } else {
            toString += ": "+getMensagem();
        }
        return toString;
    }
    
}
