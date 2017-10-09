
package entidades.configPessoa.bean;

import entidades.configCamera.bean.*;

/**
 *
 * @author hendrio
 */
public enum EnumAlarmeGpsConfigPessoa {
    
    DESATIVAR(0, "Desativar"),
    ATIVAR(1, "Ativar");
    
    private Integer ordem;
    private String descricao;
    
    private EnumAlarmeGpsConfigPessoa(Integer ordem, String descricao){
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
