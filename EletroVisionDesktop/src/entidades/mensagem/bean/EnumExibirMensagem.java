
package entidades.mensagem.bean;

/**
 *
 * @author hendrio
 */
public enum EnumExibirMensagem {
    
    INICIAR_SISTEMA(0, "Iniciar Sistema"),
    SAIR_SISTEMA(1, "Sair Sistema"),
    AGENDAMENTO(2, "Agendamento");
    
    private Integer ordem;
    private String descricao;
    
    private EnumExibirMensagem(Integer ordem, String descricao){
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
    
    public static EnumExibirMensagem parse(int ordem) {  
         EnumExibirMensagem enumn = null;   
         for (EnumExibirMensagem item : EnumExibirMensagem.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
