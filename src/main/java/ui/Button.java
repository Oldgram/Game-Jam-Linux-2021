package ui;

import com.raylib.Raylib;
import handler.Handler;
import object.Object;
import org.xml.sax.SAXException;
import player.Player;
import state.Country;
import state.State;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawText;

public class Button extends Label {
    String tooltip;
    Color toolTipColor;
    Color toolTipBackgroundColor;
    Texture2D icon;

    public Button(int x, int y, String text, int fontSize, String tooltip, Texture2D icon) {
        super(x, y, text, fontSize);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = RAYWHITE;
        this.icon = icon;
    }

    public Button(int x, int y, String text, String tooltip, int fontSize, Color textColor, Color toolTipColor, Texture2D icon) {
        super(x, y, text, fontSize, textColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = DARKGRAY;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
    }

    public Button(int x, int y, String text, String tooltip, int fontSize, Color textColor, Color backgroundColor, Color toolTipColor,
                  Color toolTipBackgroundColor, Texture2D icon) {
        super(x, y, text, fontSize, textColor, backgroundColor);
        this.tooltip = tooltip;
        this.toolTipBackgroundColor = toolTipBackgroundColor;
        this.toolTipColor = toolTipColor;
        this.icon = icon;
    }

    @Override
    public void draw() {
        int width = 180;
        DrawRectangle(x + 64, y, width, 64, backgroundColor);
        DrawText(text, x + 64 + 10, y + 16, fontSize, textColor);

        Raylib.Rectangle hitBox = new Raylib.Rectangle();
        DrawTexture(icon, x, y, WHITE);
        hitBox.x(x);
        hitBox.y(y);
        hitBox.width(width + 64);
        hitBox.height(64);

        if (CheckCollisionPointRec(GetMousePosition(), hitBox))
        {
            if (IsMouseButtonDown(MOUSE_LEFT_BUTTON)){
                click();
            }
            int offset=64;
            DrawRectangle(x, y + offset, width + 64, 24, toolTipBackgroundColor);
            DrawText(tooltip, x + 10, y + offset + 4, fontSize > 8 ? fontSize - 8 : 1, toolTipColor);
        }
    }

    private void click(){
        //TODO: Donner un type aux boutons (action ou upgrade) + Savoir quel est l'état sélectionné
        //TODO: Une méthode pour afficher le nom et la description de l'événement déclenché
        //TODO: Désactiver le bouton si l'état est détruit (state.isDestroyed() == true)

        Country country = new Country();
        State state = country.getStateList().get(0); // TODO:Remplacer ici l'index du get par l'index de l'état sélectionné
        Object object = new Object();
        String type = "Action"; // TODO:Remplacer ici par le type du button
        int id = 0; // TODO:Remplacer ici par l'id de l'action/update désirée

        try {
            object = Handler.getObject(type, id);
        } catch (Exception e) { e.printStackTrace(); }
        Handler.trigger(object, state, Player.getInstance());
    }
}
