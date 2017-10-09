
package entidades.acionamento.bean;

import java.io.Serializable;

/**
 *
 * @author Wesllen Sousa Lima
 */
public enum EnumTipoAcionamento implements Serializable{
    
    NENHUM_ACIONAMENTO(0, "Nenhum Acionamento"),
    CONTROLE_AUTOMATICO(1, "Controle Automático"),
    DETECTAR_PESSOAS(2, "Detectar Pessoas"),
    RECONHECER_FACES(3, "Reconhecer Faces"),
    ALARME(4, "Alarme"),
    MOVIMENTO(5, "Movimento"); 
    
    private Integer ordem;
    private String descricao;
    
    private EnumTipoAcionamento(Integer ordem, String descricao){
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
    
    public static EnumTipoAcionamento parse(int ordem) {  
         EnumTipoAcionamento enumn = null;   
         for (EnumTipoAcionamento item : EnumTipoAcionamento.values()) {  
             if (item.getOrdem() == ordem) {  
                 enumn = item;  
                 break;  
             }  
         }  
         return enumn;  
     }
    
}
