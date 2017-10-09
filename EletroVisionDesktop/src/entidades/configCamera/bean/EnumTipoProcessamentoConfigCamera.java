
package entidades.configCamera.bean;

/**
 *
 * @author hendrio
 */
public enum EnumTipoProcessamentoConfigCamera {
    
    ADAPTAR_AMBIENTE(0, "Adaptar ao ambiente"),
    AMBIENTE_STATICO(1, "Ambiente stático");
    
    private Integer ordem;
    private String descricao;
    
    private EnumTipoProcessamentoConfigCamera(Integer ordem, String descricao){
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
    
    public static EnumTipoProcessamentoConfigCamera parse(int ordem) {  
         EnumTipoProcessamentoConfigCamera enumn = null;   
         for (EnumTipoProcessamentoConfigCamera item : EnumTipoProcessamentoConfigCamera.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
