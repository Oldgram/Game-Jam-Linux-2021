package ui;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawRectangle;
import static com.raylib.Raylib.DrawText;

public abstract class UIComponent implements UIComponentInterface {
    int x;
    int y;

    public UIComponent(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
