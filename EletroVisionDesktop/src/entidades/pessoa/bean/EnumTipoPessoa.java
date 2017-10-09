package entidades.pessoa.bean;

/**
 *
 * @author hendrio
 */
public enum EnumTipoPessoa {
    
    DONO(0, "Dono"),
    FAMILIA(1, "Família"),
    VIGIA(2, "Vigia"),
    FUNCIONARIO(3, "Funcionário"),
    OUTROS(4, "Outros");
    
    private Integer ordem;
    private String descricao;

    private EnumTipoPessoa(Integer ordem, String descricao) {
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

    public static EnumTipoPessoa parse(int ordem) {
        EnumTipoPessoa enumn = null;
        for (EnumTipoPessoa item : EnumTipoPessoa.values()) {
            if (item.getOrdem() == ordem) {
                enumn = item;
                break;
            }
        }
        return enumn;
    }
}
