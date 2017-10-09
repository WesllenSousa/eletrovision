
package controle.mensagens.email;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class CorpoMensagens {
    
    public String empresa(String mensagem){
        String msg = ""
  + "<html>"
  + "   <img src = \"icon.PNG\" > "
  + "   <h3>EletroVision</h3>"
  + "   </br>"
  + "   "+mensagem+""
  + "   </br>"
  + "   <h5>Empresa: </h5>"
  + "   <h5>Endereço: </h5>"
  + "</html>";
        return msg;
    }
    
}
