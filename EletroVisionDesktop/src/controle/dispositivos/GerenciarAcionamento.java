package controle.dispositivos;

import controle.dispositivos.comm5.GerenciarComm5;
import controle.dispositivos.iorobotics.GerenciarIOrobotics;
import entidades.moduloAcionamento.bean.ModuloAcionamentoBean;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GerenciarAcionamento {

    private GerenciarComm5 gerenciarComm5;
    private GerenciarIOrobotics gerenciarIOrobotics;

    public GerenciarAcionamento(ModuloAcionamentoBean moduloAcionamento) {
        if (moduloAcionamento.getNome().equals("COMM5")) {
            gerenciarComm5 = new GerenciarComm5(moduloAcionamento);
        } else {
            gerenciarIOrobotics = new GerenciarIOrobotics(moduloAcionamento);
        }
    }

    public ManageDevice getGerente() {
        if (gerenciarComm5 != null) {
            return gerenciarComm5;
        } else if (gerenciarIOrobotics != null) {
            return gerenciarIOrobotics;
        } else {
            return null;
        }
    }

    public boolean isConnected() {
        if (gerenciarComm5 != null) {
            return true;
        } else if (gerenciarIOrobotics != null) {
            return true;
        } else {
            return false;
        }
    }

}
