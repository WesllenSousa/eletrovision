
package entidades.pessoa.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoPessoa {
    
    NAO(0, "NAO"),
    SIM(1, "DELETADO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoPessoa(Integer ordem, String descricao){
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
    
    public static EnumDeletadoPessoa parse(int ordem) {  
         EnumDeletadoPessoa enumn = null;   
         for (EnumDeletadoPessoa item : EnumDeletadoPessoa.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
