
package entidades.usuario.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoUsuario {
    
    NAO(0, "NAO"),
    DELETADO(1, "DELETADO");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoUsuario(Integer ordem, String descricao){
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
    
    public static EnumDeletadoUsuario parse(int ordem) {  
         EnumDeletadoUsuario enumn = null;   
         for (EnumDeletadoUsuario item : EnumDeletadoUsuario.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
