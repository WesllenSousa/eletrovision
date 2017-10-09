
package entidades.telefone.bean;

/**
 *
 * @author hendrio
 */
public enum EnumEnviarAutomaticoTelefone {
    
    ENVIAR(0, "Enviar Mensagem"),
    NAOENVIAR(1, "Não Enviar Mensagem");
    
    private Integer ordem;
    private String descricao;
    
    private EnumEnviarAutomaticoTelefone(Integer ordem, String descricao){
        this.ordem = ordem;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }
    
    public static EnumEnviarAutomaticoTelefone parse(int ordem) {  
         EnumEnviarAutomaticoTelefone enumn = null;   
         for (EnumEnviarAutomaticoTelefone item : EnumEnviarAutomaticoTelefone.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
