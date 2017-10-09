/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.dispositivo.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoDispositivo {
    
    NAO(0, "Não"),
    SIM(1, "Sim");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoDispositivo(Integer ordem, String descricao){
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
    
    public static EnumDeletadoDispositivo parse(int ordem) {  
         EnumDeletadoDispositivo enumn = null;   
         for (EnumDeletadoDispositivo item : EnumDeletadoDispositivo.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
