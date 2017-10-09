
package controle.openCV_javaCV_Pro.processamento.detectar;

import java.awt.Point;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import recursos.configuracoes.sistema.ConfigDispositivos;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DetectarMovimento {
    
    private static final int VALOR_SENSILIDADE = 50; // VALOR_SENSILIDADE >= 50 e VALOR_SENSILIDADE <= 100 (Recomendado)   
    private static final int BAIXO_THRESHOLD = 64;
    
    private IplImage imgAnterior, imgAtual, imgDiferenca;
    private Point centroide = null, centroideAnterior = null;
     
    public DetectarMovimento(){
    } 
    
    public void iniciar(IplImage primeiraImagem){
        imgAnterior = prepararImagem(primeiraImagem);
        imgAtual = null;
        imgDiferenca = IplImage.create(imgAnterior.width(), imgAnterior.height(), IPL_DEPTH_8U, 1);
    }
    
    private IplImage prepararImagem(IplImage img) {
        cvSmooth(img, img, CV_BLUR, 3);
        IplImage grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
        cvCvtColor(img, grayImg, CV_BGR2GRAY);
        cvEqualizeHist(grayImg, grayImg);  
        return grayImg;
    }  
    
    public void calcularMovimento(IplImage img){
        if(imgAtual != null) {
            imgAnterior = imgAtual;
            centroideAnterior = centroide;
        }
        imgAtual = prepararImagem(img);
        cvAbsDiff(imgAtual, imgAnterior, imgDiferenca);
        cvThreshold(imgDiferenca, imgDiferenca, BAIXO_THRESHOLD, 255, CV_THRESH_BINARY);
        Point pt = encontrarCentroide(imgDiferenca);
        if (pt != null) {
            centroide = pt;
        }
    }
    
    private Point encontrarCentroide(IplImage img) {
        Point pt = null;
        int numPixels = cvCountNonZero(img); 
        if (numPixels > (VALOR_SENSILIDADE*ConfigDispositivos.getSensibilidadeMovimento())) {
            CvMoments moments = new CvMoments();
            cvMoments(img, moments, 1);   
            double m00 = cvGetSpatialMoment(moments, 0, 0);
            double m10 = cvGetSpatialMoment(moments, 1, 0);
            double m01 = cvGetSpatialMoment(moments, 0, 1);
            if (m00 != 0) { 
                int xCenter = (int) Math.round(m10 / m00);
                int yCenter = (int) Math.round(m01 / m00);
                pt = new Point(xCenter, yCenter);
            }
        }
        return pt;
    }
    
    public Boolean reportarCentroid() {
        if (centroideAnterior == null) {
            return false;
        }
        int xStep = centroide.x - centroideAnterior.x;
        int yStep = -1 * (centroide.y - centroideAnterior.y);
        int distMoved = (int) Math.round(
                Math.sqrt((xStep * xStep) + (yStep * yStep)));
        int angle = (int) Math.round(Math.toDegrees(
                Math.atan2(yStep, xStep)));
        if (distMoved > VALOR_SENSILIDADE) {//3: MIN_MOVE_REPORT
            System.out.println("Centróide: (" + centroide.x + ", "
                    + centroide.y + ")");
            System.out.println(" Distância: " + distMoved
                    + "; Ângulo: " + angle);
            return true;
        }
        return false;
    }

    public IplImage getImgAtual() {
        return imgAtual;
    } 

    public Point getCentroide() {
        return centroide;
    }

    public Point getCentrodeAnterior() {
        return centroideAnterior;
    }
    
}
