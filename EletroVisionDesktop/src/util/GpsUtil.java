
package util;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class GpsUtil {
    
    public static double getDistanciaKilometros(double lat1, double lon1, double lat2, double lon2){  
        Integer R = 6371; // km
        Double dLat = Math.toRadians(lat2-lat1);
        Double dLon = Math.toRadians(lon2-lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        Double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        Double d = R * c;
        return d;
    }
    
    public static double getDistanciaMetros(double lat1, double lon1, double lat2, double lon2){  
        return getDistanciaKilometros(lat1, lon1, lat2, lon2) * 1000;
    }
    
}
