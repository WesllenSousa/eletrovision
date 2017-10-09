/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.acionamento.bean;

/**
 *
 * @author wesllen
 */
public enum EnumLigarDesligarAcionamento {
    
    LIGADO(0, "Ligado"),
    DESLIGADO(1, "Desligado");
    
    private Integer ordem;
    private String descricao;
    
    private EnumLigarDesligarAcionamento(Integer ordem, String descricao){
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
    
    public static EnumLigarDesligarAcionamento parse(int ordem) {  
         EnumLigarDesligarAcionamento enumn = null;   
         for (EnumLigarDesligarAcionamento item : EnumLigarDesligarAcionamento.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
