package ui;

import static com.raylib.Jaylib.BLUE;
import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;

public class BarGraph extends UIComponent {
    final int barWidth;
    int value;

    public BarGraph(int x, int y, int barWidth, int value){
        super(x, y);
        this.barWidth = barWidth;
        this.value = value;
    }
    @Override
    public void draw(){
        // Stats republicains
        DrawRectangle(x, y, barWidth, value, RED);
        DrawText(String.valueOf(value), x + 10, y + value, 28, RED);


        // Stats democrates
        DrawRectangle(x + 40, y, 40, 100 - value, BLUE);
        DrawText(String.valueOf(100 - value), x + barWidth + 10, y + 100 - value, 28, BLUE);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
