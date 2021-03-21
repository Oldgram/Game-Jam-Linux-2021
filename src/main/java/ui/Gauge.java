package ui;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;

public class Gauge extends UIComponent {
    int value;

    public Gauge(int x, int y, int value){
        super(x, y);
        this.value = value;
    }
    @Override
    public void draw(){
        // Stats republicains
        DrawRectangle(x, y, 40, value * 2, BLUE);
        DrawText(String.valueOf(value), x + 4, y, 28, WHITE);


        // Stats democrates
        DrawRectangle(x, y + value * 2, 40, (100 - value) * 2, RED);
        DrawText(String.valueOf(100 - value), x + 4, y + 170, 28, WHITE);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
