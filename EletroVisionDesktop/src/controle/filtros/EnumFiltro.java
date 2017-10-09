
package controle.filtros;

/**
 *
 * @author hendrio
 */
public enum EnumFiltro {
    
    CONTRASTE(0),
    DOBRAR(1),
    EXPOSICAO_LUZ(2),
    ADICAO(3),
    GAMMA(4),
    ESCALA_CINZA(5),
    HSBA(6),
    INVERTER(7),
    NIVEIS(8),
    POSTERIZAR(9),
    RESCALAR(10),
    RGB(11),
    SOLARIZAR(12),
    THRESHOLDING(13),
    MISTURAR(14),
    VIDRO(15),
    ROTACAO(16),
    MARMORE(17),
    CROMAR(18),
    RELEVO(19),
    SOBEL(20);
   
    private Integer ordem;
    
    private EnumFiltro(Integer ordem){
        this.ordem = ordem;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
    
    @Override
    public String toString() {
        return this.getOrdem().toString();
    }
    
}
