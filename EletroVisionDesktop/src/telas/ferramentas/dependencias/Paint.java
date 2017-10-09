package telas.ferramentas.dependencias;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.lang.Math.*;
import java.awt.Scrollbar.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class Paint extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage bufferedImage;
    private Graphics2D g2d;
    
    public final int LAPIS = 1;
    public final int LINHA = 2;
    public final int BORRACHA = 3;
    public final int LIMPAR = 4;
    public final int RETANGULO = 5;
    public final int CIRCULO = 6;
    public final int RETTANGULOF = 7;
    public final int CIRCULOF = 8;
    
    private int mousex = 0;
    private int mousey = 0;
    private int prevx = 0;
    private int prevy = 0;
    
    private boolean inicializaLapis = true;
    private boolean inicializaLinha = true;
    private boolean inicializaBorracha = true;
    private boolean inicializaRetangulo = true;
    private boolean inicializaCirculo = true;
    private boolean inicializaRetanguloF = true;
    private boolean inicializaCirculoF = true;
    
    private int cordx = 0;
    private int cordy = 0;
    private int cordWidth = 0;
    private int cordHeight = 0;
    
    private int drawX = 0;
    private int drawY = 0;
    private int borrachaLength = 5;
    private int redValue = 255;
    private int greenValue = 255;
    private int blueValue = 255;
    public int status = LAPIS;
    private Color xorColor = new Color(255, 255, 255);
    private Color corDefinida = new Color(redValue, greenValue, blueValue);

    public Paint(Integer largura, Integer altura) {
        setSize(largura, altura);
        this.addMouseListener(Paint.this);
        this.addMouseMotionListener(Paint.this);
        setBackground(Color.white);
        atualizarCores(0, 0, 0);  
    }
    
    public void criarBuffereImage(){
        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
    public void setBufferedImage(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
        g2d = this.bufferedImage.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }

    public void desenhaBufferImage() {
        Graphics2D g = (Graphics2D) getGraphics();
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void limparPainel() {
        criarBuffereImage();
    }

    private void lapis(MouseEvent e) {

        g2d.setColor(corDefinida);

        if (inicializaLapis) {
            setGraphicalDefaults(e);
            inicializaLapis = false;
            g2d.drawLine(prevx, prevy, mousex, mousey);
        }

        if (mouseMoveu(e)) {
            mousex = e.getX();
            mousey = e.getY();

            g2d.drawLine(prevx, prevy, mousex, mousey);

            prevx = mousex;
            prevy = mousey;
        }
    }

    private void linha(MouseEvent e) {

        g2d.setColor(corDefinida);

        if (inicializaLinha) {
            setGraphicalDefaults(e);
            g2d.setXORMode(xorColor);
            g2d.drawLine(cordx, cordy, mousex, mousey);
            inicializaLinha = false;
        }

        if (mouseMoveu(e)) {

            g2d.setXORMode(xorColor);
            g2d.drawLine(cordx, cordy, mousex, mousey);

            mousex = e.getX();
            mousey = e.getY();

            g2d.drawLine(cordx, cordy, mousex, mousey);
        }
    }

    private void retangulo(MouseEvent e) {

        g2d.setColor(corDefinida);

        if (inicializaRetangulo) {
            setGraphicalDefaults(e);
            inicializaRetangulo = false;
        }

        if (mouseMoveu(e)) {

            g2d.setXORMode(getBackground());
            g2d.drawRect(drawX, drawY, cordWidth, cordHeight);

            mousex = e.getX();
            mousey = e.getY();

            setActualBoundry();

            g2d.drawRect(drawX, drawY, cordWidth, cordHeight);
        }

    }

    private void circulo(MouseEvent e) {

        g2d.setColor(corDefinida);

        if (inicializaCirculo) {
            setGraphicalDefaults(e);
            inicializaCirculo = false;
        }

        if (mouseMoveu(e)) {
            g2d.setXORMode(xorColor);
            g2d.drawOval(drawX, drawY, cordWidth, cordHeight);

            mousex = e.getX();
            mousey = e.getY();

            setActualBoundry();

            g2d.drawOval(drawX, drawY, cordWidth, cordHeight);
        }
    }

    private void retanguloPreenchido(MouseEvent e) {

        g2d.setColor(corDefinida);

        if (inicializaRetanguloF) {
            setGraphicalDefaults(e);
            inicializaRetanguloF = false;
        }

        if (mouseMoveu(e)) {
            g2d.setXORMode(xorColor);
            g2d.drawRect(drawX, drawY, cordWidth - 1, cordHeight - 1);

            mousex = e.getX();
            mousey = e.getY();

            setActualBoundry();

            g2d.drawRect(drawX, drawY, cordWidth - 1, cordHeight - 1);
        }

    }

    private void circuloPreenchido(MouseEvent e) {

        g2d.setColor(corDefinida);

        if (inicializaCirculoF) {
            setGraphicalDefaults(e);
            inicializaCirculoF = false;
        }

        if (mouseMoveu(e)) {
            g2d.setXORMode(xorColor);
            g2d.drawOval(drawX, drawY, cordWidth, cordHeight);

            mousex = e.getX();
            mousey = e.getY();

            setActualBoundry();

            g2d.drawOval(drawX, drawY, cordWidth, cordHeight);
        }

    }

    private void borracha(MouseEvent e) {

        if (inicializaBorracha) {
            setGraphicalDefaults(e);
            inicializaBorracha = false;
            g2d.setColor(corDefinida.white);
            g2d.fillRect(mousex - borrachaLength, mousey - borrachaLength, borrachaLength * 2, borrachaLength * 2);
            g2d.setColor(Color.black);
            g2d.drawRect(mousex - borrachaLength, mousey - borrachaLength, borrachaLength * 2, borrachaLength * 2);
            prevx = mousex;
            prevy = mousey;
        }

        if (mouseMoveu(e)) {
            g2d.setColor(corDefinida.white);
            g2d.drawRect(prevx - borrachaLength, prevy - borrachaLength, borrachaLength * 2, borrachaLength * 2);

            mousex = e.getX();
            mousey = e.getY();

            g2d.setColor(corDefinida.white);
            g2d.fillRect(mousex - borrachaLength, mousey - borrachaLength, borrachaLength * 2, borrachaLength * 2);
            g2d.setColor(Color.black);
            g2d.drawRect(mousex - borrachaLength, mousey - borrachaLength, borrachaLength * 2, borrachaLength * 2);
            prevx = mousex;
            prevy = mousey;
        }
    }

    private boolean mouseMoveu(MouseEvent e) {
        return (mousex != e.getX() || mousey != e.getY());
    }

    public void setActualBoundry() {
        if (mousex < cordx || mousey < cordy) {

            if (mousex < cordx) {
                cordWidth = cordx - mousex;
                drawX = cordx - cordWidth;
            } else {
                drawX = cordx;
                cordWidth = mousex - cordx;
            }
            if (mousey < cordy) {
                cordHeight = cordy - mousey;
                drawY = cordy - cordHeight;
            } else {
                drawY = cordy;
                cordHeight = mousey - cordy;
            }
        } else {
            drawX = cordx;
            drawY = cordy;
            cordWidth = mousex - cordx;
            cordHeight = mousey - cordy;
        }
    }

    public void setGraphicalDefaults(MouseEvent e) {
        mousex = e.getX();
        mousey = e.getY();
        prevx = e.getX();
        prevy = e.getY();
        cordx = e.getX();
        cordy = e.getY();
        drawX = e.getX();
        drawY = e.getY();
        cordWidth = 0;
        cordHeight = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (status) {

            case LAPIS:
                lapis(e);
                break;
            case LINHA:
                linha(e);
                break;
            case RETANGULO:
                retangulo(e);
                break;
            case CIRCULO:
                circulo(e);
                break;
            case RETTANGULOF:
                retanguloPreenchido(e);
                break;
            case CIRCULOF:
                circuloPreenchido(e);
                break;

            case BORRACHA:
                borracha(e);
                borracha(e);
                break;
        }
        desenhaBufferImage();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (status) {
            case LAPIS:
                soltarLapis();
                soltarLapis();
                break;
            case LINHA:
                soltarLinha();
                soltarLinha();
                break;
            case RETANGULO:
                soltarRetangulo();
                soltarRetangulo();
                break;
            case CIRCULO:
                soltarCirculo();
                soltarCirculo();
                break;
            case RETTANGULOF:
                soltarRetanguloPreenchido();
                break;
            case CIRCULOF:
                soltarCirculoPreenchido();
                break;
            case BORRACHA:
                soltarBorracha();
                break;
        }
        desenhaBufferImage();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        desenhaBufferImage();
    }

    public void atualizarCores(int red, int green, int blue) {
        redValue = red;
        greenValue = green;
        blueValue = blue;
        if (redValue > 255) {
            redValue = 255;
        }

        if (redValue < 0) {
            redValue = 0;
        }

        if (greenValue > 255) {
            greenValue = 255;
        }

        if (greenValue < 0) {
            greenValue = 0;
        }

        if (blueValue > 255) {
            blueValue = 255;
        }

        if (blueValue < 0) {
            blueValue = 0;
        }

        corDefinida = new Color(redValue, greenValue, blueValue);
    }

    private void soltarLapis() {
        inicializaLapis = true;
    }

    private void soltarLinha() {
        if ((Math.abs(cordx - mousex) + Math.abs(cordy - mousey)) != 0) {
            inicializaLinha = true;
            g2d.setColor(corDefinida);
            g2d.drawLine(cordx, cordy, mousex, mousey);
        }
    }

    private void soltarBorracha() {
        inicializaBorracha = true;
        g2d.setColor(corDefinida.white);
        g2d.drawRect(mousex - borrachaLength, mousey - borrachaLength, borrachaLength * 2, borrachaLength * 2);
    }

    private void soltarRetangulo() {
        inicializaRetangulo = true;
        Graphics g = getGraphics();
        g2d.setColor(corDefinida);
        g2d.drawRect(drawX, drawY, cordWidth, cordHeight);
    }

    private void soltarCirculo() {
        inicializaCirculo = true;
        g2d.setColor(corDefinida);
        g2d.drawOval(drawX, drawY, cordWidth, cordHeight);
    }

    private void soltarRetanguloPreenchido() {
        inicializaRetanguloF = true;
        g2d.setColor(corDefinida);
        g2d.fillRect(drawX, drawY, cordWidth, cordHeight);
    }

    private void soltarCirculoPreenchido() {
        inicializaCirculoF = true;
        g2d.setColor(corDefinida);
        g2d.fillOval(drawX - 1, drawY - 1, cordWidth + 2, cordHeight + 2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        desenhaBufferImage();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    public BufferedImage obtemImagem(){
        return bufferedImage;
    }
    
}
