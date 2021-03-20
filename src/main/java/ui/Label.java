package ui;

import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;

public class Label extends UIComponent {
    final String text;
    Color textColor;
    Color backgroundColor;

    public Label(int x, int y, String text) {
        super(x, y);
        this.text = text;
        this.textColor = RAYWHITE;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, String text, Color textColor) {
        super(x, y);
        this.text = text;
        this.textColor = textColor;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, String text, Color textColor, Color backgroundColor) {
        super(x, y);
        this.text = text;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void draw(){
        DrawRectangle(x, y, 180, 30, GRAY);
        DrawText(text, x + 10, y, 28, RAYWHITE);
    }
}
