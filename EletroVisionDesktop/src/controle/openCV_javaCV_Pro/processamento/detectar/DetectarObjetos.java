
package controle.openCV_javaCV_Pro.processamento.detectar;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import monclubelec.javacvPro.Blob;
import monclubelec.javacvPro.OpenCV;
import processing.core.PApplet;
import recursos.constantes.ConstantesSeguranca;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DetectarObjetos implements Runnable{
    
    private Integer qtdeObjetos;
    private IplImage img;
    
    private ServidorCamera c_camera;
    
    public DetectarObjetos(IplImage img, ServidorCamera c_camera) {
        this.img = img;
        this.c_camera = c_camera;
    }
    
    @Override
    public void run() {
        try {
            detectar();
        } catch (Exception ex) {
            MensagensErro.detectarObjeto(ex);
        }
    }
    
    public void detectar() throws Exception{
        PApplet p = new PApplet();
        OpenCV opencv = new OpenCV(p);
        
        opencv.allocate(img.width(), img.height());
        opencv.copy(img);                                                 
        
        opencv.mixerRGBGray(1.0f, 1.5f, -2.0f);
        opencv.threshold(0.6f, "BINARY");
        
        Blob[] blobsArray = opencv.blobs(opencv.area() / 512, opencv.area() / 2, 20, true, 1000, false);
        
        qtdeObjetos = blobsArray.length;
        if(qtdeObjetos > 0) {
            reportarObjetos();
        }    
    }

    private void reportarObjetos() {
        System.out.println("Quantidade de Objetos: "+qtdeObjetos);
        c_camera.getStatusDeteccao().setObjetoCorpo(ConstantesSeguranca.OBJETO);
        c_camera.getStatusDeteccao().setImagemSalvar(img.getBufferedImage());
        c_camera.getStatusDeteccao().setQtdeObjetos(qtdeObjetos);
    }   
    
}
