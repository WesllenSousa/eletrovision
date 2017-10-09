package controle.mensagens.email;

import recursos.configuracoes.sistema.ConfigMensagens;
import entidades.email.bean.EmailBean;
import entidades.email.bean.EnumEnviarAutomaticoEmail;
import entidades.email.facade.EmailFacade;
import entidades.pessoa.bean.PessoaBean;
import java.io.File;
import java.util.HashMap;
import util.FacadeException;
import util.FactoryFacade;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class EnviarEmail {

    private Email email;
    private HashMap<String, File> anexos;
    private EmailBean emailBean;

    public EnviarEmail() {
        email = new Email(ConfigMensagens.getServidor(), ConfigMensagens.getPorta());
        email.origem(ConfigMensagens.getEmail(), ConfigMensagens.getNomeExibicao());
        email.autenticacao(usuarioEmail(ConfigMensagens.getEmail()), ConfigMensagens.getSenha());
    }

    public Boolean enviar(PessoaBean pessoa, String assunto, String mensagem) {
        emailBean = selecionarEmailPorPessoa(pessoa);
        if (emailBean.getEnviarAutomatico() == EnumEnviarAutomaticoEmail.ENVIAR) {
            email.destino(emailBean.getEmail(), pessoa.getNome());
            email.corpo(assunto, mensagem);
            if (anexos != null && !anexos.isEmpty()) {
                for (String chave : anexos.keySet()) {
                    email.anexo(anexos.get(chave), chave);
                }
            }
            return email.enviar();
        }
        return false;
    }

    private String usuarioEmail(String email) {
        String usuario = "";
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                break;
            }
            usuario += email.charAt(i);
        }
        return usuario;
    }

    public void setAnexos(HashMap<String, File> anexos) {
        this.anexos = anexos;
    }

    /*
     * BANCO DE DADOS
     */
    
    private EmailBean selecionarEmailPorPessoa(PessoaBean pessoa) {
        EmailFacade emailFacade = FactoryFacade.getEmailImpl();
        try {
            return emailFacade.selecionarEmailPorPessoa(pessoa);
        } catch (FacadeException ex) {
        }
        return null;
    }
    
}
