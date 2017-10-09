
package controle.configuracoes.sistema;

import java.util.ArrayList;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConfigMapaDispositivos {
    
    private static Boolean status; //verifica a leitura dos arquivos;
    
    private static String mapaPrincipal;
    private static ArrayList<String> coordDispositivosEletricos;
    private static ArrayList<String> coordCameras;

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        ConfigMapaDispositivos.status = status;
    }

    public static String getMapaPrincipal() {
        return mapaPrincipal;
    }

    public static void setMapaPrincipal(String mapaPrincipal) {
        ConfigMapaDispositivos.mapaPrincipal = mapaPrincipal;
    }

    public static ArrayList<String> getCoordCameras() {
        return coordCameras;
    }

    public static void setCoordCameras(ArrayList<String> coordCameras) {
        ConfigMapaDispositivos.coordCameras = coordCameras;
    }

    public static ArrayList<String> getCoordDispositivosEletricos() {
        return coordDispositivosEletricos;
    }

    public static void setCoordDispositivosEletricos(ArrayList<String> coordDispositivosEletricos) {
        ConfigMapaDispositivos.coordDispositivosEletricos = coordDispositivosEletricos;
    }
    
}
