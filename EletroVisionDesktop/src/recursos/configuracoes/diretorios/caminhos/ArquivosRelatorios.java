package recursos.configuracoes.diretorios.caminhos;

import java.io.File;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosRelatorios {

    public static String pessoa() {
        return pasta() + "pessoa" + File.separator + "Pessoa.jasper";
    }

    public static String acionamento() {
        return pasta() + "acionamento" + File.separator + "Acionamento.jasper";
    }

    public static String dispositivo() {
        return pasta() + "dispositivo" + File.separator + "Dispositivo.jasper";
    }

    public static String mensagem() {
        return pasta() + "mensagem" + File.separator + "Mensagem.jasper";
    }

    public static String predio() {
        return pasta() + "predio" + File.separator + "predio.jasper";
    }

    public static String movimento() {
        return pasta() + "movimento" + File.separator + "Movimento.jasper";
    }

    public static String agendarTarefas() {
        return pasta() + "agendarTarefas" + File.separator + "AgendarTarefas.jasper"; //corrigir
    }

    public static String logAcoes() {
        return pasta() + "logAcoes" + File.separator + "LogAcoes.jasper"; //corrigir
    }

    public static String pasta() {
        //return Raiz.getRaiz()+File.separator+"relatorios"+File.separator;
        return "relatorios" + File.separator;
    }
    
}
