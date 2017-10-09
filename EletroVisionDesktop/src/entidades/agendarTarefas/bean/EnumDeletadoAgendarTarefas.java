
package entidades.agendarTarefas.bean;

/**
 *
 * @author wesllen
 */
public enum EnumDeletadoAgendarTarefas {
    
    NAO(0, "NAO"),
    SIM(1, "SIM");
    
    private Integer ordem;
    private String descricao;
    
    private EnumDeletadoAgendarTarefas(Integer ordem, String descricao){
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
    
    public static EnumDeletadoAgendarTarefas parse(int ordem) {  
         EnumDeletadoAgendarTarefas enumn = null;   
         for (EnumDeletadoAgendarTarefas item : EnumDeletadoAgendarTarefas.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
