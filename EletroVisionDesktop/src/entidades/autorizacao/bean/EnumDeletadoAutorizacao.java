
package entidades.autorizacao.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoAutorizacao {
    
    NAO(0, "NAO"),
    DELETADO(1, "DELETAO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoAutorizacao(Integer ordem, String descricao){
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
    
    public static EnumDeletadoAutorizacao parse(int ordem) {  
         EnumDeletadoAutorizacao enumn = null;   
         for (EnumDeletadoAutorizacao item : EnumDeletadoAutorizacao.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
