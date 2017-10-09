package controle.expiao;

import recursos.configuracoes.diretorios.caminhos.ArquivosDiversos;
import recursos.configuracoes.sistema.ConfigGerais;
import recursos.internacionalizacao.MensagensErro;
import controle.openCV_javaCV_Pro.processamento.dependencias.SalvarImgDetectada;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Expiar implements Runnable{
    
    private SalvarImgDetectada salvarImgDetectada = new SalvarImgDetectada();
    
    private Boolean status = false;
    private Robot robot;
    private Dimension dimension;

    public Expiar() {
        try {
            robot = new Robot();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            dimension = toolkit.getScreenSize();
        } catch (AWTException ex) {
            MensagensErro.expiaoIniciar(ex);
        }
    }
    
    private void iniciar(){
        while (status) {
            Integer segundo = Integer.parseInt(ConfigGerais.getTempoExpiao() + "000");
            robot.delay(segundo); 
            BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(0, 0, dimension.width, dimension.height));
            salvarImgDetectada.salvarImagem(bufferedImage, ArquivosDiversos.espiao());
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void run() {
        iniciar();
    }
    
}