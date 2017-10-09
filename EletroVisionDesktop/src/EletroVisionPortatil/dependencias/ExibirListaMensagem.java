
package EletroVisionPortatil.dependencias;

import EletroVisionPortatil.TelaMensagens;
import java.awt.Dimension;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ExibirListaMensagem{
    
    private TelaMensagens tela;
    private Integer y, altura;  
    
    public ExibirListaMensagem(TelaMensagens tela) {
        this.tela = tela;
        y = 1;
    }
    
    public void exibir(String usuario, String mensagem) {
        altura = tamanhoMensagem(mensagem)+15; 
        
        Dimension dimension = tela.pn_mensagem.getPreferredSize();
        Integer width = dimension.width;
        dimension.setSize(width, y+altura);
        
        ListaMensagem panelMensagem = new ListaMensagem(altura, y);
        panelMensagem.setMensagem(mensagem);
        panelMensagem.setNome(usuario);
        
        tela.pn_mensagem.add(panelMensagem);
        tela.pn_mensagem.setPreferredSize(dimension);
        tela.pn_mensagem.revalidate();
        
        y += altura;
    }

    private Integer tamanhoMensagem(String mensagem) {
        Integer tamanho = 50;
        for(int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);
            if(c == '\n') tamanho += 18;
        }
        if(tamanho < 3) tamanho += 10;
        return tamanho;
    }
    
    public void zerarY() {
        y = 1;
    }
    
}
