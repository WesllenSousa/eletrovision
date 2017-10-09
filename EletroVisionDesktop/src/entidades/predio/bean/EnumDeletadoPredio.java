
package entidades.predio.bean;

import entidades.pessoa.bean.*;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoPredio {
    
    NAO(0, "NAO"),
    DELETADO(1, "DELETADO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoPredio(Integer ordem, String descricao){
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
    
    public static EnumDeletadoPredio parse(int ordem) {  
         EnumDeletadoPredio enumn = null;   
         for (EnumDeletadoPredio item : EnumDeletadoPredio.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
