
package entidades.configCamera.bean;

/**
 *
 * @author hendrio
 */
public enum EnumCorpoConfigCamera {
    
    NAO(0, "Não"),
    SIM(1, "Sim");
    
    private Integer ordem;
    private String descricao;
    
    private EnumCorpoConfigCamera(Integer ordem, String descricao){
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
    
    public static EnumCorpoConfigCamera parse(int ordem) {  
         EnumCorpoConfigCamera enumn = null;   
         for (EnumCorpoConfigCamera item : EnumCorpoConfigCamera.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
