package ui;

import com.raylib.Raylib;

import static com.raylib.Jaylib.GRAY;
import static com.raylib.Raylib.DrawText;

public class ScrollingText extends UIComponent{
    private final int speed;
    String text;
    final Raylib.Color textColor;

    public ScrollingText(int x, int y, int speed, String text){
        super(x, y);
        this.speed = speed;
        this.text = text;
        this.textColor = GRAY;
    }

    public ScrollingText(int x, int y, int speed, String text, Raylib.Color textColor){
        super(x, y);
        this.speed = speed;
        this.text = text;
        this.textColor = textColor;
    }

    public void getText(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        increment();
        DrawText(text, x, y, 28, textColor);
    }

    public void increment() {
        x += speed;
        if (x > 1920 + 300) { // TODO: Le faire en fonction de la taille de la fenetre hihi
            x = -300;
        } else if (x < -300) {
            x = 1920 + 300;
        }
    }
}
