
package entidades.dispositivoEletrico.bean;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public enum EnumLigarDesligarDispositivoEletrico implements Serializable{
    
    LIGADO(0, "Ligado"),
    DESLIGADO(1, "Desligado");
    
    private Integer ordem;
    private String descricao;
    
    private EnumLigarDesligarDispositivoEletrico(Integer ordem, String descricao){
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
    
    public static EnumLigarDesligarDispositivoEletrico parse(int ordem) {  
         EnumLigarDesligarDispositivoEletrico enumn = null;   
         for (EnumLigarDesligarDispositivoEletrico item : EnumLigarDesligarDispositivoEletrico.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
