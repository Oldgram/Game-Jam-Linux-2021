package ui;

import com.raylib.Raylib;
import handler.Handler;
import object.Object;
import player.Player;
import state.Country;
import state.State;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawText;

public class Button extends Label {
    String tooltip;
    Color toolTipColor;
    Color toolTipBackgroundColor;
    Texture2D icon;
    State state;
    String actionType;
    int actionId;
    boolean isHidden = false;
    boolean isButtonBlocked;

    public Button(int x, int y, String text, int fontSize, String tooltip, Texture2D icon) {
        super(x, y, text, fontSize);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = RAYWHITE;
        this.icon = icon;
        this.state = null;
        this.actionType = null;
        this.actionId = -1;
    }

    public Button(int x, int y, String text, String tooltip, int fontSize, Color textColor, Color toolTipColor, Texture2D icon) {
        super(x, y, text, fontSize, textColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
        this.state = null;
        this.actionType = null;
        this.actionId = -1;
    }

    public Button(int x, int y, String text, String tooltip, int fontSize, Color textColor, Color backgroundColor, Color toolTipColor,
                  Color toolTipBackgroundColor, Texture2D icon) {
        super(x, y, text, fontSize, textColor, backgroundColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = toolTipBackgroundColor;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
        this.state = null;
        this.actionType = null;
        this.actionId = -1;
    }

    public Button(int x, int y, String text, int fontSize, String tooltip, Texture2D icon, State state, String actionType, int actionId) {
        super(x, y, text, fontSize);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = RAYWHITE;
        this.icon = icon;
        this.state = state;
        this.actionType = actionType;
        this.actionId = actionId;
    }

    public Button(int x, int y, String text, String tooltip, int fontSize, Color textColor, Color toolTipColor, Texture2D icon
                , State state, String actionType, int actionId) {
        super(x, y, text, fontSize, textColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
        this.state = state;
        this.actionType = actionType;
        this.actionId = actionId;
    }

    public Button(int x, int y, String text, String tooltip, int fontSize, Color textColor, Color backgroundColor, Color toolTipColor,
                  Color toolTipBackgroundColor, Texture2D icon, State state, String actionType, int actionId) {
        super(x, y, text, fontSize, textColor, backgroundColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = toolTipBackgroundColor;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
        this.state = state;
        this.actionType = actionType;
        this.actionId = actionId;
    }

    @Override
    public void draw() {
        if (isHidden) {
            return;
        }

        if (state != null){
            if(state.isDestroyed()) {
                isHidden = true;
            }
        }

        int width = 180;
        int offset;
        Raylib.Rectangle hitBox = new Raylib.Rectangle();
        hitBox.x(x);
        hitBox.y(y);

        if (this.icon != null){
            DrawRectangle(x + 64, y, width, 64, backgroundColor);
            DrawText(text, x + 64 + 10, y + 16, fontSize, textColor);
            DrawTexture(icon, x, y, WHITE);
            hitBox.width(width + 64);
            hitBox.height(64);
            offset = 64;
        } else {
            DrawRectangle(x, y, width, 30, backgroundColor);
            DrawText(text, x + 10, y + 7, fontSize, textColor);
            hitBox.width(width);
            hitBox.height(30);
            offset = 30;
        }

        if (CheckCollisionPointRec(GetMousePosition(), hitBox))
        {
            if (IsMouseButtonDown(MOUSE_LEFT_BUTTON) && !isButtonBlocked){
                click();
                isButtonBlocked = true;
            }

            if (IsMouseButtonUp(MOUSE_LEFT_BUTTON)){
                isButtonBlocked = false;
            }

            if (this.icon != null){
                DrawRectangle(x, y + offset, width + 64, 24, toolTipBackgroundColor);
            } else {
                DrawRectangle(x, y + offset, width, 24, toolTipBackgroundColor);
            }
            DrawText(tooltip, x + 10, y + offset + 4, fontSize > 4 ? fontSize - 4 : 1, toolTipColor);
        }
    }

    private void click(){
        //TODO: Une méthode pour afficher le nom et la description de l'événement déclenché
        System.out.println("Coucou");
        if (this.state != null) {
            Country country = Country.getInstance();
            Object object = new Object();

            try {
                object = Handler.getObject(actionType, actionId);
            } catch (Exception e) { e.printStackTrace(); }
            Handler.trigger(object, state, Player.getInstance());
        }
    }
}
