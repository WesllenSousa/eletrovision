
package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import recursos.InstanciasPortatil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RedeUtil {
    
    public static String obtemIpLocal() {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (UnknownHostException e) {
            InstanciasPortatil.getMensagens().bug("RedeUtil: Não foi possível obter o endereço local");
        }
        return ip;
    }
    
}
