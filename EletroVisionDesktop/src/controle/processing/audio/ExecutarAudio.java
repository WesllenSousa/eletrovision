package controle.processing.audio;

import ddf.minim.*;
import processing.core.PApplet;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ExecutarAudio extends PApplet {

    private Minim minim;
    private AudioPlayer song;
    
    private String arquivo;
    
    public ExecutarAudio(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public void setup() {
        size(10, 10);
        minim = new Minim(this);
        song = minim.loadFile(arquivo);
        song.play();
    }

    @Override
    public void draw() {
        background(0);
    }

    @Override
    public void stop() {
        song.close();
        minim.stop();
        super.stop();
    }

}
