package controle.openCV_javaCV_Pro.processamento.detectar;

import recursos.configuracoes.diretorios.caminhos.ArquivosImagens;
import controle.openCV_javaCV_Pro.camera.ServidorCamera;
import controle.facerecognition.javafaces.FaceRec;
import controle.facerecognition.javafaces.MatchResult;
import controle.facerecognition.javafaces2.ImageUtils;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import recursos.constantes.ConstantesSeguranca;
import recursos.constantes.ConstantesSistema;
import recursos.instancias.InstanciasControle;
import util.DiretorioUtil;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ReconhecerFace {

    private Rectangle faceRectangulo;
    private BufferedImage bufferedImage;
    private ServidorCamera c_camera;
    private DetectarFaces detectarFaces;

    public ReconhecerFace(ServidorCamera c_camera, BufferedImage bufferedImage) {
        faceRectangulo = new Rectangle();
        this.bufferedImage = bufferedImage;
        this.c_camera = c_camera;
    }

    public void coordenadasFace(Integer x, Integer y, Integer width, Integer height) {
        faceRectangulo.setRect(x, y, width, height);
    }

    public void iniciar(DetectarFaces detectarFaces) {
        this.detectarFaces = detectarFaces;
        recortarFace();
    }

    private void recortarFace() {
        BufferedImage recorte;
        recorte = ImageUtils.clipToRectangle(bufferedImage,
                faceRectangulo.x, faceRectangulo.y, faceRectangulo.width, faceRectangulo.height);
        if (recorte != null) {
            analizarRecorte(recorte);
        }
    }

    private void analizarRecorte(BufferedImage recorte) {
        System.out.println("Analizando face...");
        BufferedImage face = cortarFace(redimencionarImagem(recorte));

        String arquivo = ArquivosImagens.diretorio_temporario() + File.separator + "tempAutomatico.png";
        Integer numeroArquivos = 0;
        if (DiretorioUtil.verificarDiretorioExiste(new File(ArquivosImagens.diretorio_faces() + File.separator + "mycache.cache"))) {
            numeroArquivos = (DiretorioUtil.contarArquivos(new File(ArquivosImagens.diretorio_faces())) - 2);
        } else {
            numeroArquivos = (DiretorioUtil.contarArquivos(new File(ArquivosImagens.diretorio_faces())) - 1);
        }
        salvarImagem(face, arquivo);
        FaceRec reconhecerFace = new FaceRec();
        MatchResult result = reconhecerFace.processSelections(arquivo, ArquivosImagens.diretorio_faces(), numeroArquivos.toString(), "0.0");
        if (result == null) {
            System.out.println("Match não encontrado.");
        } else {
            String r = result.getMatchFileName();
            if (r != null) {
                String distStr = String.format("%.4f", result.getMatchDistance());
                if (Double.parseDouble(distStr.replace(',', '.')) < ConstantesSistema.VALOR_RECONHECIMENTO) {
                    File f = new File(r);
                    System.out.println("  Face reconhecida - " + f.getName() + ",  distância = (" + distStr + ")");
                    c_camera.getStatusDeteccao().setObjetoCorpo(ConstantesSeguranca.RECONHECER_FACE);
                    c_camera.getStatusDeteccao().setFaceReconhecida(f.getName()); 
                    c_camera.getStatusDeteccao().setImagemSalvar(bufferedImage);
                    c_camera.getStatusDeteccao().setQtdePessoas(1);
                    detectarFaces.setReconhecer(true); 
                } else { 
                    System.out.println("Face não reconhecida, distância = ("+distStr+")");
                } 
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        InstanciasControle.getMensagens().aviso("Número de arquivos na base de dados de faces inválidos!");
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

    private void salvarImagem(BufferedImage im, String caminho) {
        try {
            ImageIO.write(im, "png", new File(caminho));
        } catch (IOException e) {
            System.out.println("Erro ao salvar imagem: " + e);
        }
    }
    
}
