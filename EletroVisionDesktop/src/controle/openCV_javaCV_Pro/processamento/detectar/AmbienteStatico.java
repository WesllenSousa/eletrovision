
package controle.openCV_javaCV_Pro.processamento.detectar;

import monclubelec.javacvPro.Blob;
import monclubelec.javacvPro.OpenCV;
import processing.core.PApplet;
    
import static com.googlecode.javacv.cpp.opencv_core.*;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AmbienteStatico {
    
    private OpenCV opencv;
    private Integer qtdeObjetos;
    
    public AmbienteStatico(IplImage imgAnterior){    
        capturarAmbiente(imgAnterior);
    }
    
    private void capturarAmbiente(IplImage imgAnterior) {
        PApplet p = new PApplet();
        opencv = new OpenCV(p);
        opencv.allocate(imgAnterior.width(), imgAnterior.height());
        opencv.copy(imgAnterior);    
        opencv.remember(); //guardo a imagem nesse remember
    }
    
    public void detectar(IplImage img) {
        opencv.copy(img);       
        opencv.absDiff();
        opencv.threshold(0.6f, "BINARY");
        Blob[] blobsArray = opencv.blobs(opencv.area() / 512, opencv.area() / 2, 20, true, 100, false);      
        qtdeObjetos = blobsArray.length;  
    }
    
    public Boolean reportarObjetos() {
        if(qtdeObjetos > 0) {
            System.out.println("Quantidade de objetos alterados no ambiente: "+qtdeObjetos);
            return true;
        } else {
            return false;
        }
    }   
    
}
