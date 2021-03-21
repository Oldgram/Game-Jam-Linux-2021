package map;

import java.util.stream.Stream;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawTexture;

public class MapState extends MapComponent {
    private static Color color;
    String pathname;
    Texture2D texture;

    public MapState(String pathname, Double percentageRepublican) {
        super(50, 50);
        this.pathname = pathname;
        Image image = LoadImage(this.pathname);
        ImageResize(image,1280, 882);
        ImageColorBrightness(image, 255);
        ImageColorTint(image, blueOrRed(percentageRepublican));
        this.texture = LoadTextureFromImage(image);
        UnloadImage(image);

    }

    private static Color rgba(int var0, int var1, int var2, int var3) {
        return (new Color()).r((byte)var0).g((byte)var1).b((byte)var2).a((byte)var3);
    }

    private static Color blueOrRed(Double percentage){
        if (percentage < 10) {
            color = rgba(0, 0, 255, 255);
        } else if (percentage < 20) {
            color = rgba(0, 128, 255, 255);
        }else if (percentage < 30) {
            color = rgba(51, 153, 255, 255);
        }else if (percentage < 40) {
            color = rgba(102, 178, 255, 255);
        }else if (percentage < 48) {
            color = rgba(153, 204, 255, 255);
        } else if (percentage < 52) {
            color = rgba(255, 255, 255, 255);
        } else if (percentage < 60) {
            color = rgba(255, 204, 204, 255);
        }else if (percentage < 70) {
            color = rgba(255, 153, 153, 255);
        }else if (percentage < 80) {
            color = rgba(255, 102, 102, 255);
        }else if (percentage < 90) {
            color = rgba(255, 51, 51, 255);
        }else if (percentage <= 100) {
            color = rgba(255, 0, 0, 255);
        }
        return color;
    }

    @Override
    public void draw(){
        DrawTexture(this.texture, 75, 50, WHITE);
    }
}
