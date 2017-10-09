
package entidades.acionamento.bean;

import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.camera.bean.CameraBean;
import entidades.predio.bean.PredioBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author hendrio
 */
@Entity
@Table(name="acionamento")
public class AcionamentoBean implements Serializable {

    @Id
    @Column(name="codigo")
    @SequenceGenerator(name = "seq_acionamento", sequenceName = "acionamento_codigo_seq")
    @GeneratedValue(generator = "seq_acionamento")
    private Integer codigo;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "foto")
    private String foto;
    
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private EnumStatusAcionamento status;
    
    @Column(name = "ligardesligar")
    @Enumerated(EnumType.ORDINAL)
    private EnumLigarDesligarAcionamento ligarDesligar;
    
    @Column(name = "deletado")
    @Enumerated(EnumType.ORDINAL)
    private EnumDeletadoAcionamento deletado;
    
    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoAcionamento tipo;
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "agendaracionamento",
    joinColumns = {
    @JoinColumn(name = "codacionamento")},
    inverseJoinColumns = {
    @JoinColumn(name = "codagendartarefas")})
    private Collection<AgendarTarefasBean> agendarTarefas;
    
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "acionamentodispositivo",
    joinColumns = {
    @JoinColumn(name = "codacionamento")},
    inverseJoinColumns = {
    @JoinColumn(name = "coddispositivo")})
    private Collection<CameraBean> cameras;
    
    @ManyToOne
    @JoinColumn(name="codpredio")
    private PredioBean predio;

    public Collection<AgendarTarefasBean> getAgendarTarefas() {
        return agendarTarefas;
    }

    public void setAgendarTarefas(Collection<AgendarTarefasBean> agendarTarefas) {
        this.agendarTarefas = agendarTarefas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public EnumDeletadoAcionamento getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumDeletadoAcionamento delegado) {
        this.deletado = delegado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public EnumStatusAcionamento getStatus() {
        return status;
    }

    public void setStatus(EnumStatusAcionamento status) {
        this.status = status;
    }

    public Collection<CameraBean> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<CameraBean> cameras) {
        this.cameras = cameras;
    }

    public EnumLigarDesligarAcionamento getLigarDesligar() {
        return ligarDesligar;
    }

    public void setLigarDesligar(EnumLigarDesligarAcionamento ligarDesligar) {
        this.ligarDesligar = ligarDesligar;
    }

    public EnumTipoAcionamento getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoAcionamento tipo) {
        this.tipo = tipo;
    }

    public PredioBean getPredio() {
        return predio;
    }

    public void setPredio(PredioBean predio) {
        this.predio = predio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AcionamentoBean other = (AcionamentoBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.deletado != other.deletado) {
            return false;
        }
        if (!Objects.equals(this.agendarTarefas, other.agendarTarefas)) {
            return false;
        }
        if (!Objects.equals(this.cameras, other.cameras)) {
            return false;
        }
        if (!Objects.equals(this.ligarDesligar, other.ligarDesligar)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.predio, other.predio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.foto);
        hash = 97 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 97 * hash + (this.deletado != null ? this.deletado.hashCode() : 0);
        hash = 97 * hash + Objects.hashCode(this.agendarTarefas);
        hash = 97 * hash + Objects.hashCode(this.cameras);
        hash = 97 * hash + Objects.hashCode(this.ligarDesligar);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.predio);
        return hash;
    }   

    @Override
    public String toString() {
        return getNome();
    }
    
}
