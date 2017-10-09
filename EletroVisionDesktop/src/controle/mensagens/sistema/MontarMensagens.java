
package controle.mensagens.sistema;

import controle.openCV_javaCV_Pro.processamento.dependencias.StatusDeteccao;
import entidades.acionamento.bean.AcionamentoBean;
import entidades.agendarTarefas.bean.AgendarTarefasBean;
import entidades.dispositivoEletrico.bean.DispositivoEletricoBean;
import entidades.movimento.bean.MovimentoBean;
import entidades.pessoa.bean.PessoaBean;
import util.DataUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class MontarMensagens {
    
    public static String deteccao(MovimentoBean movimento) {
        return "Movimento Detectado em: "+DataUtil.formataDataHora(movimento.getData_hms()) + " \n"
                + "N. pessoas: "+movimento.getQtdePessoas() + " \n"
                + "N. objetos: "+movimento.getQtdeObjetos() + " \n"
                + "Localizacao: "+movimento.getCamera().getArea().getPredio()+" - "+movimento.getCamera().getArea() + " \n"
                + "Camera: "+movimento.getCamera();
    }
    
    public static String movimento(MovimentoBean movimento) {
        return "Movimento Detectado em: "+DataUtil.formataDataHora(movimento.getData_hms()) + " \n"
                + "Localizacao: "+movimento.getCamera().getArea().getPredio()+" - "+movimento.getCamera().getArea() + " \n"
                + "Camera: "+movimento.getCamera();
    }
    
    public static String ambienteAlterado(MovimentoBean movimento) {
        return "Ambiente alterado em: "+DataUtil.formataDataHora(movimento.getData_hms()) + " \n"
                + "Localizacao: "+movimento.getCamera().getArea().getPredio()+" - "+movimento.getCamera().getArea() + " \n"
                + "Camera: "+movimento.getCamera();
    }
    
    public static String faceReconhecida(StatusDeteccao statusDeteccao) {
        return "Face reconhecida: "+statusDeteccao.getFaceReconhecida();
    }
    
    public static String visita() {
        return "Você tem visita!";
    }
    
    public static String dispositivoFalha(PessoaBean pessoa, DispositivoEletricoBean dispositivoEletrico) {
        return pessoa+" tentou ligar o dispositivo elétrico "+dispositivoEletrico+", mas ocorreu uma falha.";
    }
    
    public static String dispositivoConfiguracao(PessoaBean pessoa, DispositivoEletricoBean dispositivoEletrico) {
        return pessoa+" tentou ligar o dispositivo eletrico "+dispositivoEletrico+
                ", mas o modulo de acionamento estar desativado.";
    }
    
    public static String dispositivoLigado(PessoaBean pessoa, DispositivoEletricoBean dispositivoEletrico) {
        return pessoa+" ligou o dispositico eletrico "+dispositivoEletrico+".";
    }
    
    public static String dispositivoDesligado(PessoaBean pessoa, DispositivoEletricoBean dispositivoEletrico) {
        return pessoa+" desligou o dispositico eletrico "+dispositivoEletrico+".";
    }
    
    public static String acionamentoFalha(PessoaBean pessoa, AcionamentoBean acionamento) {
        return pessoa+" tentou ligar os dispositivos do cenário " + acionamento + ", mas ocorreu uma falha.";
    }
    
    public static String acionamentoConfiguracao(PessoaBean pessoa, AcionamentoBean acionamento) {
        return pessoa+" tentou ligar os dispositivos do cenário " + acionamento +", mas o acionamento estar desativado.";
    }
    
    public static String acionamentoLigado(PessoaBean pessoa, AcionamentoBean acionamento) {
        return pessoa+" ligou os dispositivos do cenário " + acionamento + ".";
    }
    
    public static String acionamentoDesligado(PessoaBean pessoa, AcionamentoBean acionamento) {
        return pessoa+" desligou os dispositivos do cenário " + acionamento + ".";
    }
    
    public static String agendamentoTarefas(AgendarTarefasBean agendarTarefas, PessoaBean pessoa) {
        return "O agendamento "+agendarTarefas.getDescricao()+" foi disparado. Usuário: "+pessoa+".";
    }
    
    public static String urlCameraConexao(String ip, Integer porta, String usuario, String senha) {
        return "http://"+ip+":"+porta+"/videostream.asf?user="+usuario+"&pwd="+senha+"&resolution=32"; 
    }
    
    public static String urlCameraMovimentacao(String ip, Integer porta, String usuario, String senha, Integer comando) {
        return "http://"+ip+":"+porta+"/decoder_control.cgi?user="+usuario+"&pwd="+senha+"&command="+comando;
    }
    
}
