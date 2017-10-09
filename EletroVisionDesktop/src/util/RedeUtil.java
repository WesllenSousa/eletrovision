package util;

import recursos.internacionalizacao.MensagensErro;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class RedeUtil {

    public static String getIp() {
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (UnknownHostException ex) {
            MensagensErro.redeUtilErro(ex);
        }
        return ip;
    }

    public static String getMac() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            NetworkInterface netInter = NetworkInterface.getByInetAddress(localHost);
            byte[] macAddressBytes = netInter.getHardwareAddress();

            String macAddress = String.format("%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x",
                    macAddressBytes[0], macAddressBytes[1],
                    macAddressBytes[2], macAddressBytes[3],
                    macAddressBytes[4], macAddressBytes[5]).toUpperCase();

            return macAddress;
        } catch (ArrayIndexOutOfBoundsException | UnknownHostException | SocketException ex) {
            MensagensErro.redeMac(ex); 
        }
        return null;
    }
    
}
