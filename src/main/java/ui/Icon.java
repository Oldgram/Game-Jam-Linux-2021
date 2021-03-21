package ui;

import com.raylib.Raylib.*;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTexture;

public class Icon extends UIComponent {
    Texture2D icon;

    public Icon(int x, int y, Texture2D icon) {
        super(x, y);
        this.icon = icon;
    }

    @Override
    public void draw() {
        DrawTexture(icon, x, y, WHITE);
    }

    public void setIcon(Texture2D icon) {
        this.icon = icon;
    }
}
