
package entidades.acionamento.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoAcionamento {
    
    NAO(0, "Não deletado"),
    SIM(1, "Deletado");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoAcionamento(Integer ordem, String descricao){
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
    
    public static EnumDeletadoAcionamento parse(int ordem) {  
         EnumDeletadoAcionamento enumn = null;   
         for (EnumDeletadoAcionamento item : EnumDeletadoAcionamento.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
