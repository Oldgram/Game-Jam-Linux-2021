import gametime.GameTime;
import state.Country;
import ui.Button;
import ui.UI;
import map.Map;

import java.io.File;

import static com.raylib.Jaylib.*;
import static map.MapState.rgba;

public class Main {
    public static void main(String args[]) {
        InitWindow( 1920, 1000, "Trump Inc.");
        SetTargetFPS(60);
        state.Country country = Country.getInstance();
        UI ui = new UI();
        Map map = new Map(country);
        Color backgroundColor = rgba(49, 51, 53, 255);
        GameTime gt = new GameTime(17);

        while (!WindowShouldClose()){ // MainLoop
            while (!gt.isOver()) { // Game loop
                BeginDrawing();
                DrawFPS(20, 20);
                ClearBackground(backgroundColor);
                gt.testsec(map);
                map.update();
                ui.update();
                ClearBackground(backgroundColor);
                EndDrawing();
            }
            // End Game
            ClearBackground(backgroundColor);
            BeginDrawing();
            double score = gt.getScore();
            Image theEnd = LoadImage("./src/main/resources/assets/default.png");
            if (score >= 50.0) {
                theEnd = LoadImage("./src/main/resources/assets/win.png");
            } else {
                theEnd = LoadImage("./src/main/resources/assets/lose.png");
            }
            Texture2D LoadImage = LoadTextureFromImage(theEnd);
            DrawText("Votre score est de : " + Math.round(score), 500, 550, 20, WHITE);
            ClearBackground(backgroundColor);
            UnloadImage(theEnd);
            EndDrawing();
        }

        CloseWindow();
    }
}