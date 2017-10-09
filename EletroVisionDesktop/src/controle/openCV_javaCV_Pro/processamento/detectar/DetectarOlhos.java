
package controle.openCV_javaCV_Pro.processamento.detectar;

import recursos.configuracoes.diretorios.caminhos.ArquivosScripts;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import recursos.constantes.ConstantesSeguranca;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DetectarOlhos implements Runnable{
    
    private Integer scala = 2, totalOlhos;
    private IplImage img;
    
    private ServidorCamera c_camera;
    
    public DetectarOlhos(IplImage img, ServidorCamera c_camera){
        this.img = img;
        this.c_camera = c_camera;
    }
    
    public Integer getTotalOlhos() {
        return totalOlhos;
    }   
    
    @Override
    public void run() {
        try {
            detectar();
        } catch (Exception ex) {
            MensagensErro.detectarOlhos(ex);
        } 
    }
    
    public void detectar() throws Exception{
        //Converte para escala de cinza
        IplImage grayImg = IplImage.create(img.width(),
                img.height(), IPL_DEPTH_8U, 1);
        cvCvtColor(img, grayImg, CV_BGR2GRAY);
        
        // scale the grayscale (to speed up face detection)
        IplImage smallImg = IplImage.create(grayImg.width() / scala,
                grayImg.height() / scala, IPL_DEPTH_8U, 1);
        cvResize(grayImg, smallImg, CV_INTER_LINEAR);
        
        // equalize the small grayscale
        IplImage equImg = IplImage.create(smallImg.width(),
                smallImg.height(), IPL_DEPTH_8U, 1);
        cvEqualizeHist(smallImg, equImg);
        
        //Aloca memoria para ser usado object detection.
        CvMemStorage storage = CvMemStorage.create();
        
        //instacia arquivo para deteccao de faces
        CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad(ArquivosScripts.cascadeFaceOculos()));
        if (cascade.isNull()) {
            System.out.println("Não foi possível carregar o cascade: haarcascade_eye_tree_eyeglasses.xml");
        }
        CvSeq faces = cvHaarDetectObjects(equImg, cascade, storage, 1.1, 3,
                CV_HAAR_DO_ROUGH_SEARCH | CV_HAAR_FIND_BIGGEST_OBJECT);

        IplImage imagem = IplImage.createCompatible(img);
        cvCopy(img, imagem);
        //desenha um retangulo ao redor da face
        totalOlhos = faces.total();
        for (int i = 0; i < totalOlhos; i++) {
            CvRect r = new CvRect(cvGetSeqElem(faces, i));
            cvRectangle(imagem, cvPoint(r.x() * scala, r.y() * scala), 
                    cvPoint((r.x() + r.width()) * scala, (r.y() + r.height()) * scala),
                    CvScalar.YELLOW, 1, CV_AA, 0);
        }
        if(totalOlhos > 0) {
            reportarOlhos();
        }
        cvClearMemStorage(storage);
    }

    private void reportarOlhos() {
        System.out.println("Total de Olhos: "+totalOlhos);
        c_camera.getStatusDeteccao().setObjetoCorpo(ConstantesSeguranca.OLHOS);
        c_camera.getStatusDeteccao().setImagemSalvar(img.getBufferedImage());
        c_camera.getStatusDeteccao().setQtdePessoas(-1);
    }

}
