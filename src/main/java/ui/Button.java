package ui;

import com.raylib.Raylib;
import handler.Handler;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.DrawText;

public class Button extends Label {
    String tooltip;
    Color toolTipColor;
    Color toolTipBackgroundColor;
    Texture2D icon;

    public Button(int x, int y, String text, String tooltip, Texture2D icon) {
        super(x, y, text);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = RAYWHITE;
        this.icon = icon;
    }

    public Button(int x, int y, String text, String tooltip, Color textColor, Color toolTipColor, Texture2D icon) {
        super(x, y, text, textColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
    }

    public Button(int x, int y, String text, String tooltip, Color textColor, Color backgroundColor, Color toolTipColor,
                  Color toolTipBackgroundColor, Texture2D icon) {
        super(x, y, text, textColor, backgroundColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = toolTipBackgroundColor;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
    }

    @Override
    public void draw() {
        super.draw();

        Raylib.Rectangle hitBox = new Raylib.Rectangle();
        hitBox.x(x);
        hitBox.y(y);
        hitBox.width(180);
        hitBox.height(30);

        if (CheckCollisionPointRec(GetMousePosition(), hitBox))
        {
            if (IsMouseButtonDown(MOUSE_LEFT_BUTTON)){
                //TODO Handler.trigger();
            }
            int offset = 40;
            if(!icon.isNull()){
                DrawTexture(icon, x, y, WHITE);
            }
            DrawRectangle(x, y + offset, 180, 24, toolTipBackgroundColor);
            DrawText(tooltip, x + 10, y + offset + 4, 16, toolTipColor);
        }
    }
}
