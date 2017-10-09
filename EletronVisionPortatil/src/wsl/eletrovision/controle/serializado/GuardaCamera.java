
package wsl.eletrovision.controle.serializado;

import java.io.Serializable;

/**
 *
 * @author Wesllen
 */
public class GuardaCamera implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String camera;
    private String acao;
    private String configuracao;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

}
