
package controle.mensagens.sistema;

import recursos.internacionalizacao.MensagensSoltas;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import recursos.instancias.InstanciasControle;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Mensagens {

    public void bug(String mensagem){
        if(InstanciasControle.getGerenciarAudio() != null) {
            InstanciasControle.getGerenciarAudio().exeErro();
        }
        JOptionPane.showMessageDialog(null, mensagem, MensagensSoltas.mensagemErro(), JOptionPane.ERROR_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_bug())));   
    }
    
    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, MensagensSoltas.mensagemSucesso(), JOptionPane.WARNING_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_sucesso())));
    }
    
    public void aviso(String mensagem){
        if(InstanciasControle.getGerenciarAudio() != null) {
            InstanciasControle.getGerenciarAudio().exeAviso();
        }
        JOptionPane.showMessageDialog(null, mensagem, MensagensSoltas.mensagemAviso(), JOptionPane.WARNING_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_aviso())));
    }

    public boolean confirmacao(String mensagem){
        if(InstanciasControle.getGerenciarAudio() != null) {
            InstanciasControle.getGerenciarAudio().exePergunta();
        }
        int conf = JOptionPane.showConfirmDialog(null, mensagem, MensagensSoltas.mensagemConfirmacao(),
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_confirmacao())));
        if(conf == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }

    public String multiplaEscolha(String mensagem, String escolha[]){
        String resp = (String)JOptionPane.showInputDialog(null,
            mensagem, MensagensSoltas.mensagemEscolha(), JOptionPane.QUESTION_MESSAGE,
            new ImageIcon(getClass().getResource(ArquivosImagens.msg_escolha())),
            escolha, escolha[0]);
        return resp;
    }

    public String inserirDados(String mensagem){
        return (String) JOptionPane.showInputDialog(null, mensagem, MensagensSoltas.mensagemInformeDado(), 
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource(ArquivosImagens.msg_entradaDados())), 
                null, null);
    }
    
    public String inserirDadosComValorInicial(String mensagem, String valorInicial){
        return (String) JOptionPane.showInputDialog(null, mensagem, MensagensSoltas.mensagemInformeDado(), 
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource(ArquivosImagens.msg_entradaDados())), 
                null, valorInicial);
    }

}
