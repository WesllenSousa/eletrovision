
package entidades.marca.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoMarca {
    
    NAO(0, "NAO"),
    DELETADO(1, "DELETADO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoMarca(Integer ordem, String descricao){
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
    
    public static EnumDeletadoMarca parse(int ordem) {  
         EnumDeletadoMarca enumn = null;   
         for (EnumDeletadoMarca item : EnumDeletadoMarca.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
