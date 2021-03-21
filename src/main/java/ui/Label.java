package ui;

import com.raylib.Raylib;

import java.time.LocalDate;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;

public class Label extends UIComponent {
    String text;
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

    public Label(int x, int y, LocalDate localDate) {
        super(x, y);
        this.text = localDate.toString();
        this.textColor = RAYWHITE;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, LocalDate localDate, Color textColor) {
        super(x, y);
        this.text = localDate.toString();
        this.textColor = textColor;
        this.backgroundColor = GRAY;
    }

    public Label(int x, int y, LocalDate localDate, Color textColor, Color backgroundColor) {
        super(x, y);
        this.text = localDate.toString();
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
        DrawText(text, x + 10, y, 28, textColor);
    }
}
