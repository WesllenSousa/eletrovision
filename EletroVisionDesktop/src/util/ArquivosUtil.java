
package util;

import java.awt.Point;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ArquivosUtil {
    
    public static Point retornaLocalizacaoPixels(String coordenadas) {
        Point point = new Point();
        if (coordenadas != null) {
            Integer largura = null, altura = null;
            String add = "";
            for (int i = 0; i < coordenadas.length(); i++) {
                char c = coordenadas.charAt(i);
                try {
                    Integer.parseInt(c + "");
                    add += c;
                } catch (NumberFormatException ex) {
                    if (add.length() > 0) {
                        if (largura == null) {
                            largura = Integer.parseInt(add);
                        } else if (altura == null) {
                            altura = Integer.parseInt(add);
                        }
                    }
                    add = "";
                    continue;
                }
            }
            point.setLocation(largura, altura);
        } else {
            point.setLocation(0, 0);
        }
        return point;
    }
    
}
