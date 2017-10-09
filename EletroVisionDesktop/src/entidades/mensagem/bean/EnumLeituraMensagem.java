
package entidades.mensagem.bean;

/**
 *
 * @author hendrio
 */
public enum EnumLeituraMensagem {
    
    SIM(0, "SIM"),
    NAO(1, "NAO");

    private Integer ordem;
    private String descricao;
    
    private EnumLeituraMensagem(Integer ordem, String descricao){
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
    
    public static EnumLeituraMensagem parse(int ordem) {  
         EnumLeituraMensagem enumn = null;   
         for (EnumLeituraMensagem item : EnumLeituraMensagem.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
