
package controle.mapa;

/**
 *
 * @author Wesllen
 */
public class GuardaLocalizacaoGPS {
    
    private String usario;
    private Double longitude;
    private Double latitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getUsario() {
        return usario;
    }

    public void setUsario(String usario) {
        this.usario = usario;
    }

    @Override
    public String toString() {
        return getUsario();
    }
    
}
