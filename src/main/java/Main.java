import gametime.GameTime;
import state.Country;
import ui.UI;
import map.Map;

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

        while (!WindowShouldClose()){
            BeginDrawing();
            DrawFPS(20, 20);
            ClearBackground(backgroundColor);
            gt.testsec(map);
            map.update();
            ui.update();
            EndDrawing();
        }

        CloseWindow();
    }
}