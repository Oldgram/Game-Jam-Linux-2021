import state.Country;

import static com.raylib.Jaylib.*;

public class Main {
    public static void main(String args[]) {
        InitWindow(1920, 1080, "Trump Inc.");
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