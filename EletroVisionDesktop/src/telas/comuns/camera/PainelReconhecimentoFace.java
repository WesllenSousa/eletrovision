package telas.comuns.camera;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacpp.Loader;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import recursos.configuracoes.diretorios.caminhos.ArquivosScripts;
import controle.facerecognition.javafaces.FaceRec;
import controle.facerecognition.javafaces.MatchResult;
import controle.facerecognition.javafaces2.ImageUtils;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasControle;
import recursos.internacionalizacao.MensagensSoltas;
import util.DiretorioUtil;
import util.ImagemUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class PainelReconhecimentoFace extends JPanel implements Runnable {

    // dimensões
    private static final int DELAY = 30;  // tempo para redesenhar no painel
    private static final int ESCALA = 4;
    private static final int DETECT_DELAY = 1000;
    private static final int MAXIMO_TAREFAS = 4; // tempo entre cada detecção de face
    private static final int TAMANHO_CIRCULO = 5;
    // cascade
    private static final String FACE_CASCADE = ArquivosScripts.cascadeFace();
    //OpenCV e Imagem
    private FrameFaceCamera frame;
    private BufferedImage image = null;  //Imagem atual da webcam
    private OpenCVFrameGrabber camera;
    private IplImage iplImage;
    private volatile boolean rodando;
    private int imageCount = 0;
    private Font msgFont;
    // JavaCV variaveis
    private CvHaarClassifierCascade classifier;
    private CvMemStorage storage;
    private ExecutorService executor;
    private AtomicInteger numeroTarefas;
    private long detectStartTime = 0;
    private Rectangle faceRectangulo;
    private volatile boolean recognizeFace = false;
    private FaceRec reconhecerFace;   // classe de reconhecimento de faces do javafaces
    private String nomeFace = null;
    private Boolean savarFace = false;
    private Boolean detectarFace = true;
    private Integer identificacaoCamera;
    private Integer altura, largura;

    public PainelReconhecimentoFace(FrameFaceCamera frame, Integer identificacaoCamera, Integer largura, Integer altura) {
        this.frame = frame;
        this.identificacaoCamera = identificacaoCamera;
        this.largura = largura;
        this.altura = altura;
        
        setBackground(Color.white);
        msgFont = new Font("SansSerif", Font.BOLD, 18);

        reconhecerFace = new FaceRec();

        executor = Executors.newSingleThreadExecutor();
        numeroTarefas = new AtomicInteger(0);

        iniciarOpenCV();
        faceRectangulo = new Rectangle();

        new Thread(this).start();
    }

    private void iniciarOpenCV() {
        System.out.print("iniciando OpenCV...");

        Loader.load(opencv_objdetect.class);

        classifier = new CvHaarClassifierCascade(cvLoad(FACE_CASCADE));
        if (classifier.isNull()) {
            System.out.println("\nNão foi possível carregar arquivo classifier: " + FACE_CASCADE);
        }

        storage = CvMemStorage.create();

        System.out.println("iniciado");
    }

    @Override
    public void run() {
        camera = new OpenCVFrameGrabber(identificacaoCamera);
        try {
            camera.start();
            iplImage = camera.grab();
        } catch (Exception ex) {
        }

        long duration;
        BufferedImage im = null;
        rodando = true;
        while (rodando) {
            long startTime = System.currentTimeMillis();
            try {
                iplImage = camera.grab();
            } catch (Exception ex) {
            }
            im = ImagemUtil.redimencionar(iplImage.getBufferedImage(), largura, altura);
            if (im == null) {
                System.out.println("problema ao carregar imagem " + (imageCount + 1));
                duration = System.currentTimeMillis() - startTime;
            } else {
                if (((System.currentTimeMillis() - detectStartTime) > DETECT_DELAY)
                        && (numeroTarefas.get() < MAXIMO_TAREFAS)) {
                    if (detectarFace) {
                        acompanharFace(im);
                    }
                }
                image = im;
                imageCount++;
                duration = System.currentTimeMillis() - startTime;
                repaint();
            }

            if (duration < DELAY) {
                try {
                    Thread.sleep(DELAY - duration);
                } catch (Exception ex) {
                }
            }
        }
        try {
            camera.stop();
            System.out.println("OpenCV parado.");
        } catch (Exception ex) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (image != null) {
            g2.drawImage(image, 0, 0, this);
        }

        desenharRetangulo(g2);
        escreverNomeTela(g2);
    }

    private void desenharRetangulo(Graphics2D g2) {
        synchronized (faceRectangulo) {
            if (faceRectangulo.width == 0) {
                return;
            }

            g2.setColor(Color.YELLOW);
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(faceRectangulo.x, faceRectangulo.y, faceRectangulo.width, faceRectangulo.height);

            int xCenter = faceRectangulo.x + faceRectangulo.width / 2;
            int yCenter = faceRectangulo.y + faceRectangulo.height / 2;
            desenharCentro(g2, xCenter, yCenter);
        }
    }

    private void desenharCentro(Graphics2D g2, int xCenter, int yCenter) {
        g2.setColor(Color.RED);
        g2.fillOval(xCenter - TAMANHO_CIRCULO / 2, yCenter - TAMANHO_CIRCULO / 2,
                TAMANHO_CIRCULO, TAMANHO_CIRCULO);
    }

    private void escreverNomeTela(Graphics2D g2) {
        g2.setColor(Color.YELLOW);
        g2.setFont(msgFont);
        if (nomeFace != null) {
            g2.drawString(nomeFace, getWidth() / 2, getHeight() - 10);  
        }
    }

    public void fechar() {
        rodando = false;
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
        }

    }

    // ------------------------- detecção de face ----------------------------
    private void acompanharFace(final BufferedImage img) {
        final BufferedImage grayIm = ImageUtils.toScaledGray(img, 1.0 / ESCALA);   // reduz o tamanho da imagem
        numeroTarefas.getAndIncrement();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                detectStartTime = System.currentTimeMillis();
                CvRect rect = encontrarFace(grayIm);
                if (rect != null) {
                    setRectangulo(rect);
                    if (recognizeFace) {
                        recortarFace(img);
                        recognizeFace = false;
                    }
                    if (savarFace) {
                        salvarImgagemCortada(img);
                        savarFace = false;
                    }
                }
                numeroTarefas.getAndDecrement();
            }
        });
    }

    private CvRect encontrarFace(BufferedImage grayIm) {
        IplImage cvImg = IplImage.createFrom(grayIm);

        IplImage equImg = IplImage.create(cvImg.width(), cvImg.height(), IPL_DEPTH_8U, 1);
        cvEqualizeHist(cvImg, equImg);

        CvSeq faces = cvHaarDetectObjects(equImg, classifier, storage, 1.1, 1, // 3
                CV_HAAR_DO_ROUGH_SEARCH | CV_HAAR_FIND_BIGGEST_OBJECT);

        int total = faces.total();
        if (total == 0) {

            return null;
        } else if (total > 1) {
            System.out.println("Várias faces detectadas (" + total + "); usando a primeira.");
        }

        CvRect rect = new CvRect(cvGetSeqElem(faces, 0));

        cvClearMemStorage(storage);
        return rect;
    }

    private void setRectangulo(CvRect r) {
        synchronized (faceRectangulo) {
            int xNew = r.x() * ESCALA;
            int yNew = r.y() * ESCALA;
            int widthNew = r.width() * ESCALA;
            int heightNew = r.height() * ESCALA;

            faceRectangulo.setRect(xNew, yNew, widthNew, heightNew); 
        }
    }

    public void naoDetectarFace() {
        detectarFace = false;
    }

    // ---------------- reconhecimento de face -------------------------
    public void setReconhecerFace() {
        recognizeFace = true;
    }

    private void recortarFace(BufferedImage img) { 
        BufferedImage recorte = null;
        synchronized (faceRectangulo) {
            if (faceRectangulo.width == 0) {
                System.out.println("Nenhuma face selecionada.");
                return;
            }
            recorte = ImageUtils.clipToRectangle(img,
                    faceRectangulo.x, faceRectangulo.y, faceRectangulo.width, faceRectangulo.height);
        }
        if (recorte != null) {
            analizarRecorte(recorte);
        }
    }

    private void analizarRecorte(BufferedImage recorte) { 
        System.out.println("Analizando recorte...");
        BufferedImage face = cortarFace(redimencionarImagem(recorte));
        
        String arquivo = ArquivosImagens.diretorio_temporario()+File.separator+"temp.png";
        Integer numeroArquivos = 0;
        if(DiretorioUtil.verificarDiretorioExiste(new File(ArquivosImagens.diretorio_faces()+File.separator+"mycache.cache"))) {
            numeroArquivos = (DiretorioUtil.contarArquivos(new File(ArquivosImagens.diretorio_faces()))-2);
        } else {
            numeroArquivos = (DiretorioUtil.contarArquivos(new File(ArquivosImagens.diretorio_faces()))-1);
        }         
        salvarImagem(face, arquivo);
        MatchResult result = reconhecerFace.processSelections(arquivo, ArquivosImagens.diretorio_faces(), numeroArquivos.toString(), "0.0");
        if (result == null) {
            System.out.println("Match não encontrado.");
        } else {
            nomeFace = "";
            String r = result.getMatchFileName();
            if(r != null) {
                String distStr = String.format("%.4f", result.getMatchDistance());
                if(Double.parseDouble(distStr.replace(',', '.')) < ConstantesSistema.VALOR_RECONHECIMENTO) {
                    File f = new File(r);
                    nomeFace = "Reconhecido: " + f.getName();
                    System.out.println("  Matches " + result.getMatchFileName() + "; distance = " + distStr);
                    System.out.println("  Nome do Match: " + nomeFace);
                    frame.setNomeReconhecido(nomeFace, distStr);
                } else {
                    nomeFace = "Face não reconhecida";
                    frame.setNomeReconhecido("Não reconhecido", distStr);
                }
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        InstanciasControle.getMensagens().aviso(MensagensSoltas.comumFacesInvalidas());
                    }
                }).start();
            }
        }
    }

    private BufferedImage redimencionarImagem(BufferedImage im) {
        double widthScale = ConstantesSistema.FACE_LARGURA / ((double) im.getWidth());
        double heightScale = ConstantesSistema.FACE_ALTURA / ((double) im.getHeight());
        double scale = (widthScale > heightScale) ? widthScale : heightScale;
        return ImageUtils.toScaledGray(im, scale);
    }

    private BufferedImage cortarFace(BufferedImage im) {
        int xOffset = (im.getWidth() - ConstantesSistema.FACE_LARGURA) / 2;
        int yOffset = (im.getHeight() - ConstantesSistema.FACE_ALTURA) / 2;
        return ImageUtils.clipToRectangle(im, xOffset, yOffset, ConstantesSistema.FACE_LARGURA, ConstantesSistema.FACE_ALTURA);
    }

    // ---------------- Salvar face -------------------------
    public void salvarFace() {
        savarFace = true;
    }

    private void salvarImgagemCortada(BufferedImage img) {
        BufferedImage recorte = null;
        synchronized (faceRectangulo) {
            if (faceRectangulo.width == 0) {
                System.out.println("Face não detectada!");
                return;
            }
            try {
                recorte = img.getSubimage(faceRectangulo.x, faceRectangulo.y, faceRectangulo.width, faceRectangulo.height);
            } catch (RasterFormatException e) {
                System.out.println("Erro ao recortar imagem: "+e);
            }
        }
        if (recorte != null) {
            salvarCorte(recorte);
        }
    }

    private void salvarCorte(BufferedImage clipIm) {
        long startTime = System.currentTimeMillis();

        System.out.println("Salvando recorte...");
        BufferedImage grayIm = redimencionarImagem(clipIm);
        BufferedImage faceIm = cortarFace(grayIm);
        String diretorio = ArquivosImagens.diretorio_temporario() +File.separator+frame.lb_nome.getText()+"-"+frame.obtemQuantidadeImagensSalvas()+".png";
        salvarImagem(faceIm, diretorio);
        frame.exibirImagem(faceIm, diretorio);

        System.out.println("  tempo de salvamento: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private void salvarImagem(BufferedImage im, String caminho) { 
        try {
            ImageIO.write(im, "png", new File(caminho));
            System.out.println("Imagem salva em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar imagem: " + e);
        }
    }
    
}
