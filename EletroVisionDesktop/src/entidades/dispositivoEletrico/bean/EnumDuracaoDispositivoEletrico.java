
package entidades.dispositivoEletrico.bean;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public enum EnumDuracaoDispositivoEletrico implements Serializable{
    
    PERMANENTE(0, "Permanente"),
    CURTO(1, "Curto");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDuracaoDispositivoEletrico(Integer ordem, String descricao){
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
    
    public static EnumDuracaoDispositivoEletrico parse(int ordem) {  
         EnumDuracaoDispositivoEletrico enumn = null;   
         for (EnumDuracaoDispositivoEletrico item : EnumDuracaoDispositivoEletrico.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
