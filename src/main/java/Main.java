
import state.Country;
import ui.BarGraph;

import java.awt.*;

import static com.raylib.Jaylib.*;

public class Main {
    public static void main(String args[]) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        InitWindow((int) screenSize.getWidth(), (int) screenSize.getHeight(), "Trump Inc.");
        SetTargetFPS(60);
        Country country = new Country();

        while (!WindowShouldClose()){
            BeginDrawing();
            DrawFPS(20, 20);
            ClearBackground(RAYWHITE);
            EndDrawing();
        }

        CloseWindow();
    }
}