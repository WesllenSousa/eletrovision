
package wsl.eletrovision.controle.serializado;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GuardaDispositivo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String dispositivo;
    private String acao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
}
