
package entidades.acaoAgendamento.bean;

/**
 *
 * @author hendrio
 */
public enum EnumTipoVinculoAcaoAgendamento {
    
    MENSAGEM(0, "Mensagem"),
    ACIONAMENTO(1, "Acionamento"),
    CAMERA(2, "Câmera");
    
    private Integer ordem;
    private String descricao;
    
    private EnumTipoVinculoAcaoAgendamento(Integer ordem, String descricao){
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
    
    public static EnumTipoVinculoAcaoAgendamento parse(int ordem) {  
         EnumTipoVinculoAcaoAgendamento enumn = null;   
         for (EnumTipoVinculoAcaoAgendamento item : EnumTipoVinculoAcaoAgendamento.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
