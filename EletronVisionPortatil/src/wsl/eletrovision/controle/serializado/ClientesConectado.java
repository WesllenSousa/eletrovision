
package wsl.eletrovision.controle.serializado;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ClientesConectado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String contato;
    private String host;
    private String ip;
    private Integer porta;

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    } 
    
}
