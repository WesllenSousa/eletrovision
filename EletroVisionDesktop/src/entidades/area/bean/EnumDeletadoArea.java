
package entidades.area.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoArea {
    
    NAO(0, "NAO"),
    SIM(1, "DELETADO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoArea(Integer ordem, String descricao){
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
    
    public static EnumDeletadoArea parse(int ordem) {  
         EnumDeletadoArea enumn = null;   
         for (EnumDeletadoArea item : EnumDeletadoArea.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
