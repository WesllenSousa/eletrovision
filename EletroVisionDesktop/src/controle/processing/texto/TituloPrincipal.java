package controle.processing.texto;

import processing.core.PApplet;
import processing.core.PFont;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class TituloPrincipal extends PApplet {

    PFont f;
    String message = "Sistema";
    Letter[] letters;

    @Override
    public void setup() {
        size(300, 115);
        f = createFont("Verdana", 20, true);
        textFont(f);
        letters = new Letter[message.length()];

        int x = 50;
        for (int i = 0; i < message.length(); i++) {
            letters[i] = new Letter(x, 70, message.charAt(i));
            x += textWidth(message.charAt(i));
        }
    }

    @Override
    public void draw() {
        background(255);
        for (int i = 0; i < letters.length; i++) {
            letters[i].display();
            if (mousePressed) {
                letters[i].shake();
            } else {
                letters[i].home();
            }
        }
    }
     
    private class Letter {

        char letter;
        float homex, homey;
        float x, y;

        Letter(float x_, float y_, char letter_) {
            homex = x = x_;
            homey = y = y_;
            letter = letter_;
        }

        void display() {
            fill(0);
            textAlign(LEFT);
            text(letter, x, y);
        }
        
        void shake() {
            x += random(-5, 5);
            y += random(-5, 5);
        }
        
        void home() {
            x = homex;
            y = homey;
        }
    }
    
}
