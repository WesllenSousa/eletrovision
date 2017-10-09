
package controle.mensagens;

import controle.configuracoes.diretorios.caminhos.ArquivosImagens;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Mensagens {

    public void bug(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_bug())));   
    }

    public boolean confirmacao(String mensagem){
        int conf = JOptionPane.showConfirmDialog(null, mensagem, "Aviso de Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_confirmacao())));
        if(conf == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }

    public void sucesso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.WARNING_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_sucesso())));
    }

    public void aviso(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE,
                new ImageIcon(getClass().getResource(ArquivosImagens.msg_aviso())));
    }

    public String multiplaEscolha(String mensagem, String escolha[]){
        String resp = (String)JOptionPane.showInputDialog(null,
            mensagem, "Escolha", JOptionPane.QUESTION_MESSAGE,
            new ImageIcon(getClass().getResource(ArquivosImagens.msg_escolha())),
            escolha, escolha[0]);
        return resp;
    }

    public String inserirDados(String mensagem){
        return (String) JOptionPane.showInputDialog(null, mensagem, "Informe o dado", 
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource(ArquivosImagens.msg_entradaDados())), 
                null, null);
    }
    
    public String inserirDadosComValorInicial(String mensagem, String valorInicial){
        return (String) JOptionPane.showInputDialog(null, mensagem, "Informe o dado", 
                JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource(ArquivosImagens.msg_entradaDados())), 
                null, valorInicial);
    }

}
