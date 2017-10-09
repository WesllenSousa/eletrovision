package entidades.pessoa.bean;

/**
 *
 * @author hendrio
 */
public enum EnumSituacaoPessoa {

    ATIVO(0, "ATIVO"),
    INATIVO(1, "INATIVO");
    private Integer ordem;
    private String descricao;

    private EnumSituacaoPessoa(Integer ordem, String descricao) {
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

    public static EnumSituacaoPessoa parse(int ordem) {
        EnumSituacaoPessoa enumn = null;
        for (EnumSituacaoPessoa item : EnumSituacaoPessoa.values()) {
            if (item.getOrdem() == ordem) {
                enumn = item;
                break;
            }
        }
        return enumn;
    }
}
