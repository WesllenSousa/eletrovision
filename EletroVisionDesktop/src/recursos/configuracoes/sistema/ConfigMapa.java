
package recursos.configuracoes.sistema;

import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigMapa {
    
    private static Boolean status; //verifica se os arquivos foram lidos;
    
    private static String mapaDispositivos;
    private static String mapaCenarios;
    private static ArrayList<String> coordDispositivosEletricos;
    private static ArrayList<String> coordCameras;

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        ConfigMapa.status = status;
    }

    public static ArrayList<String> getCoordCameras() {
        return coordCameras;
    }

    public static void setCoordCameras(ArrayList<String> coordCameras) {
        ConfigMapa.coordCameras = coordCameras;
    }

    public static ArrayList<String> getCoordDispositivosEletricos() {
        return coordDispositivosEletricos;
    }

    public static void setCoordDispositivosEletricos(ArrayList<String> coordDispositivosEletricos) {
        ConfigMapa.coordDispositivosEletricos = coordDispositivosEletricos;
    }

    public static String getMapaDispositivos() {
        return mapaDispositivos;
    }

    public static void setMapaDispositivos(String mapaDispositivos) {
        ConfigMapa.mapaDispositivos = mapaDispositivos;
    }

    public static String getMapaCenarios() {
        return mapaCenarios;
    }

    public static void setMapaCenarios(String mapaCenarios) {
        ConfigMapa.mapaCenarios = mapaCenarios;
    }  
    
}
