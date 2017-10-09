
package entidades.mensagem.bean;

/**
 *
 * @author hendrio
 */
public enum EnumTipoMensagem {
    
    EMAIL(0, "EMAIL"),
    CELULAR(1, "CELULAR"),
    LOCAL(2, "LOCAL"),
    REDE(3, "REDE");
    
    private Integer ordem;
    private String descricao;
    
    private EnumTipoMensagem(Integer ordem, String descricao){
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
    
    public static EnumTipoMensagem parse(int ordem) {  
         EnumTipoMensagem enumn = null;   
         for (EnumTipoMensagem item : EnumTipoMensagem.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
