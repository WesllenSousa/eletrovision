package entidades.logAcoes.bean;

/**
 *
 * @author hendrio
 */
public enum EnumRedeLogAcoes {

    NAO(0, "NÃO"),
    SIM(1, "SIM");
    
    private Integer ordem;
    private String descricao;

    private EnumRedeLogAcoes(Integer ordem, String descricao) {
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

    public static EnumRedeLogAcoes parse(int ordem) {
        EnumRedeLogAcoes enumn = null;
        for (EnumRedeLogAcoes item : EnumRedeLogAcoes.values()) {
            if (item.getOrdem() == ordem) {
                enumn = item;
                break;
            }
        }
        return enumn;
    }
}
