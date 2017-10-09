
package telas.geral.dependencias;

import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.camera.bean.CameraBean;
import entidades.mensagem.bean.MensagemBean;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ItemAgendarTarefas {
    
    private AgendarTarefasBean agendarTarefas;
    private MensagemBean mensagem;
    private AcionamentoBean acionamento;
    private CameraBean camera;

    public AgendarTarefasBean getAgendarTarefas() {
        return agendarTarefas;
    }

    public void setAgendarTarefas(AgendarTarefasBean agendarTarefas) {
        this.agendarTarefas = agendarTarefas;
    }

    public AcionamentoBean getAcionamento() {
        return acionamento;
    }

    public void setAcionamento(AcionamentoBean acionamento) {
        this.acionamento = acionamento;
    }

    public CameraBean getCamera() {
        return camera;
    }

    public void setCamera(CameraBean camera) {
        this.camera = camera;
    }

    public MensagemBean getMensagem() {
        return mensagem;
    }

    public void setMensagem(MensagemBean mensagem) {
        this.mensagem = mensagem;
    }

}
