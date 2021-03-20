import static com.raylib.Jaylib.*;

public class Main {
    public static void main(String args[]) {
        InitWindow(1920, 1080, "Trump Inc.");
        SetTargetFPS(60);

        while (!WindowShouldClose()){
            BeginDrawing();
            DrawText("Hello world", 190, 200, 20, VIOLET);
            DrawFPS(20, 20);
            ClearBackground(RAYWHITE);
            EndDrawing();
        }

        CloseWindow();
    }
}