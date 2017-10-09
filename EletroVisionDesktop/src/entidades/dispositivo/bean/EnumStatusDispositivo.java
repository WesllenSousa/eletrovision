
package entidades.dispositivo.bean;

/**
 *
 * @author Wesllen Sousa Lima
 */
public enum EnumStatusDispositivo {
    
    ATIVO(0, "Ativo"),
    INATIVO(1, "Inativo");
    
    private Integer ordem;
    private String descricao;
    
    private EnumStatusDispositivo(Integer ordem, String descricao){
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
    
    public static EnumStatusDispositivo parse(int ordem) {  
         EnumStatusDispositivo enumn = null;   
         for (EnumStatusDispositivo item : EnumStatusDispositivo.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
