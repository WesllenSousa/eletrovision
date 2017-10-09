
package controle.openCV_javaCV_Pro.processamento.detectar;

import recursos.configuracoes.diretorios.caminhos.ArquivosScripts;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import recursos.configuracoes.sistema.ConfigDispositivos;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import entidades.configCamera.bean.EnumReconhecerFaceConfigCamera;
import recursos.constantes.ConstantesSeguranca;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class DetectarFaces implements Runnable{
    
    private Integer ESCALA = 4, totalFaces;
    private IplImage img;
    private Boolean reconhecer = false;
    
    private ServidorCamera c_camera;
    
    public DetectarFaces(IplImage img, ServidorCamera c_camera){
        this.img = img;
        this.c_camera = c_camera;
    }
    
    public Integer getTotalFaces() {
        return totalFaces;
    }   
    
    @Override
    public void run() {
        try {
            detectar();
        } catch (Exception ex) {
            MensagensErro.detectarFace(ex);
        }
    }
    
    public void detectar() throws Exception{
        //Converte para escala de cinza
        IplImage grayImg = IplImage.create(img.width(),
                img.height(), IPL_DEPTH_8U, 1);
        cvCvtColor(img, grayImg, CV_BGR2GRAY);
        
        // scale the grayscale (to speed up face detection)
        IplImage smallImg = IplImage.create(grayImg.width() / ESCALA,
                grayImg.height() / ESCALA, IPL_DEPTH_8U, 1);
        cvResize(grayImg, smallImg, CV_INTER_LINEAR);
        
        // equalize the small grayscale
        IplImage equImg = IplImage.create(smallImg.width(),
                smallImg.height(), IPL_DEPTH_8U, 1);
        cvEqualizeHist(smallImg, equImg);
        
        //Aloca memoria para ser usado object detection.
        CvMemStorage storage = CvMemStorage.create();

        //instacia arquivo para deteccao de faces
        CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad(ArquivosScripts.cascadeFace()));
        if (cascade.isNull()) {
            System.out.println("Não foi possível carregar o cascade: haarcascade_frontalface_alt2.xml");
        }
        CvSeq faces = cvHaarDetectObjects(equImg, cascade, storage, 1.1, 3,
                 CV_HAAR_DO_ROUGH_SEARCH | CV_HAAR_FIND_BIGGEST_OBJECT);
        IplImage imagem = IplImage.createCompatible(img);
        cvCopy(img, imagem);
        //desenha um retangulo ao redor da face
        totalFaces = faces.total();
        for (int i = 0; i < totalFaces; i++) {        
            if(ConfigDispositivos.getReconhecerFaces() && c_camera.getCamera().getConfigCamera().getReconhecerFace() == EnumReconhecerFaceConfigCamera.SIM) {
                CvRect r = new CvRect(cvGetSeqElem(faces, i));
                //Não apagar: desenha retangulo na face, foi comentado para melhorar o reconhecimento de face
                //cvRectangle(imagem, cvPoint(r.x() * ESCALA, r.y() * ESCALA), 
                //        cvPoint((r.x() + r.width()) * ESCALA, (r.y() + r.height()) * ESCALA),
                //        CvScalar.YELLOW, 1, CV_AA, 0);
                int x = r.x() * ESCALA;
                int y = r.y() * ESCALA;
                int width = r.width() * ESCALA;
                int height = r.height() * ESCALA;
                ReconhecerFace reconhecerFace = new ReconhecerFace(c_camera, imagem.getBufferedImage());
                reconhecerFace.coordenadasFace(x, y, width, height);
                reconhecerFace.iniciar(DetectarFaces.this);
                break;
            } 
        }       
        if(!reconhecer && totalFaces > 0) {
            reportarFaces();
        }
        cvClearMemStorage(storage);
    }

    private void reportarFaces() {
        System.out.println("Total de Faces: "+totalFaces);
        c_camera.getStatusDeteccao().setObjetoCorpo(ConstantesSeguranca.FACE);
        c_camera.getStatusDeteccao().setImagemSalvar(img.getBufferedImage());
        c_camera.getStatusDeteccao().setQtdePessoas(totalFaces);
    }

    public void setReconhecer(Boolean reconhecer) {
        this.reconhecer = reconhecer;
    }

}
