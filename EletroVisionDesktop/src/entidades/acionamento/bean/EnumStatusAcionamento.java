/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.acionamento.bean;

/**
 *
 * @author wesllen
 */
public enum EnumStatusAcionamento {
    
    ATIVO(0, "Ativo"),
    INATIVO(1, "Inativo");
    
    private Integer ordem;
    private String descricao;
    
    private EnumStatusAcionamento(Integer ordem, String descricao){
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
    
    public static EnumStatusAcionamento parse(int ordem) {  
         EnumStatusAcionamento enumn = null;   
         for (EnumStatusAcionamento item : EnumStatusAcionamento.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
