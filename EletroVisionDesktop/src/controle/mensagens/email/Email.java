
package controle.mensagens.email;
import recursos.internacionalizacao.MensagensErro;
import java.io.File;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Wesllen Sousa Lima
 */

//Gmail: smtp.gmail.com, Porta: 465
public class Email {
    
    private CorpoMensagens corpoMensagens = new CorpoMensagens();

    private HtmlEmail htmlEmail;   
     
    public Email(String host, Integer porta){
        htmlEmail = new HtmlEmail();
        htmlEmail.setHostName(host); // o servidor SMTP para envio do e-mail
        htmlEmail.setSmtpPort(porta);
    }
    
    public void origem(String email, String nome){
        try {
            htmlEmail.setFrom(email, nome);
        } catch (EmailException ex) {
            MensagensErro.emailOrigem(ex);
        }
    }
    
    public void destino(String email, String nome){
        try {
            htmlEmail.addTo(email, nome);
        } catch (EmailException ex) {
            MensagensErro.emailDestino(ex);
        }
    }

    public void autenticacao(String usuario, String senha){
        htmlEmail.setAuthentication(usuario, senha);
        htmlEmail.setSSL(true);
        htmlEmail.setTLS(true);
    }
    
    public void anexo(File arquivo, String nome){
        try {
            htmlEmail.embed(arquivo, nome);
        } catch (EmailException ex) {
            MensagensErro.emailAnexo(ex);
        }
    }
    
    public void corpo(String assunto, String mensagem){  
        htmlEmail.setSubject(assunto);  
        try {
            htmlEmail.setHtmlMsg(corpoMensagens.empresa(mensagem));
        } catch (EmailException ex) {
            MensagensErro.emailHtml(ex);
        }
    }
    
    public Boolean enviar(){
        try {
            htmlEmail.send(); 
            return true;
        } catch (EmailException ex) {
            return false;
        }
    }
    
}
