package entidades.predio.bean;

/**
 *
 * @author hendrio
 */
public enum EnumTipoPredio {

    RESIDENCIA(0, "Residência"),
    COMERCIO(1, "Comércio"),
    INDUSTRIA(2, "Industria");
    private Integer ordem;
    private String descricao;

    private EnumTipoPredio(Integer ordem, String descricao) {
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

    public static EnumTipoPredio parse(int ordem) {
        EnumTipoPredio enumn = null;
        for (EnumTipoPredio item : EnumTipoPredio.values()) {
            if (item.getOrdem() == ordem) {
                enumn = item;
                break;
            }
        }
        return enumn;
    }
}
