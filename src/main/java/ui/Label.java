package ui;

import java.time.LocalDate;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;

public class Label extends UIComponent {
    String text;
    final int fontSize;
    Color textColor;
    Color backgroundColor;

    public Label(int x, int y, String text, int fontSize) {
        super(x, y);
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = RAYWHITE;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, String text, int fontSize, Color textColor) {
        super(x, y);
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, String text, int fontSize, Color textColor, Color backgroundColor) {
        super(x, y);
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public Label(int x, int y, LocalDate localDate, int fontSize) {
        super(x, y);
        this.text = localDate.toString();
        this.fontSize = fontSize;
        this.textColor = RAYWHITE;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, LocalDate localDate, int fontSize, Color textColor) {
        super(x, y);
        this.text = localDate.toString();
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, LocalDate localDate, int fontSize, Color textColor, Color backgroundColor) {
        super(x, y);
        this.text = localDate.toString();
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setText(LocalDate localDate) {
        this.text = localDate.toString();
    }

    @Override
    public void draw(){
        DrawRectangle(x, y, 180, 30, backgroundColor);
        DrawText(text, x + 10, y, fontSize, textColor);
    }
}
