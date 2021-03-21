package map;

import java.util.stream.Stream;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.DrawTexture;

public class MapState extends MapComponent {
    Color oldColor;
    Color color;
    String pathname;
    Texture2D texture;

    public MapState(String pathname, Double percentageRepublican) {
        super(50, 50);
        this.pathname = pathname;
        this.oldColor = BLACK;
        this.color = blueOrRed(percentageRepublican);
        if(this.oldColor != this.color){
            System.out.println(this.pathname + " updated");
            this.oldColor = this.color;
            Image image = LoadImage(this.pathname);
            ImageResize(image,1400, 965);
            ImageColorBrightness(image, 255);
            ImageColorTint(image, this.color);
            this.texture = LoadTextureFromImage(image);
            UnloadImage(image);
        }


    }

    public static Color rgba(int var0, int var1, int var2, int var3) {
        return (new Color()).r((byte)var0).g((byte)var1).b((byte)var2).a((byte)var3);
    }

    private static Color blueOrRed(Double percentage){
        Color colori = new Color();
        if (percentage < 10) {
            colori = rgba(0, 0, 255, 255);
        } else if (percentage < 20) {
            colori = rgba(0, 128, 255, 255);
        }else if (percentage < 30) {
            colori = rgba(51, 153, 255, 255);
        }else if (percentage < 40) {
            colori = rgba(102, 178, 255, 255);
        }else if (percentage < 49.5) {
            colori = rgba(153, 204, 255, 255);
        } else if (percentage < 50.5) {
            colori = rgba(255, 255, 255, 255);
        } else if (percentage < 60) {
            colori = rgba(255, 204, 204, 255);
        }else if (percentage < 70) {
            colori = rgba(255, 153, 153, 255);
        }else if (percentage < 80) {
            colori = rgba(255, 102, 102, 255);
        }else if (percentage < 90) {
            colori = rgba(255, 51, 51, 255);
        }else if (percentage <= 100) {
            colori = rgba(255, 0, 0, 255);
        }
        return colori;
    }

    @Override
    public void draw(){
        DrawTexture(this.texture, 35, 50, WHITE);
    }
}
