package ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import static com.raylib.Jaylib.*;

import static com.raylib.Raylib.DrawRectangle;

public class UI {
    HashMap<staticComponents, UIComponentInterface> topRightPannelComponents;
    List<UIComponentInterface> bottomRightPannelComponents;
    ScrollingText scrollingText;

    public enum staticComponents {
        STATE,
        POPULATION,
        REPUBLICANS,
        GAUGE,
        ICON_1,
        ICON_2,
        ICON_3,
        ICON_4
    }

    public UI(){
        this.topRightPannelComponents = new HashMap<>();
        this.bottomRightPannelComponents = new ArrayList<>();
        this.scrollingText = new ScrollingText(0, 1080 - 40, 1, "");

        initializeTopRightPanel();
    }

    public UI(HashMap<staticComponents, UIComponentInterface> topRight, List<UIComponentInterface> bottomRight, ScrollingText bottom){
        this.topRightPannelComponents = topRight;
        this.bottomRightPannelComponents = bottomRight;
        this.scrollingText = bottom;

        initializeTopRightPanel();
    }

    private void drawBaseLayout(){
        DrawRectangle(1920 - 490, 0, 490, 1080, DARKGRAY);
        DrawRectangle(1920 - 480, 0, 480, 310, GRAY); // Top right pannel
        DrawRectangle(1920 - 480, 320, 480, 1080 - 300, GRAY); // Bottom right pannel
        DrawRectangle(0, 1080 - 40, 1920, 40, DARKGRAY); // Bottom pannel
    }

    private void initializeTopRightPanel(){
        this.topRightPannelComponents.put(staticComponents.STATE,
                new Label(1920 - 470, 20, "Minesotta", 28));
        this.topRightPannelComponents.put(staticComponents.POPULATION,
                new Label(1920 - 470, 80, "- Nombre habitants hihi", 22));
        this.topRightPannelComponents.put(staticComponents.REPUBLICANS,
                new Label(1920 - 470, 120, "- Nombre de supporters hehe", 22));
        this.topRightPannelComponents.put(staticComponents.GAUGE,
                new Gauge(1860, 80, 23));

        Image defaultIconImage = LoadImage("./src/main/resources/assets/default.png");
        Texture2D defaultIconTexture = LoadTextureFromImage(defaultIconImage);
        UnloadImage(defaultIconImage);
        this.topRightPannelComponents.put(staticComponents.ICON_1, new Icon(1920 - 460, 230, defaultIconTexture));
        this.topRightPannelComponents.put(staticComponents.ICON_2, new Icon(1920 - 390, 230, defaultIconTexture));
        this.topRightPannelComponents.put(staticComponents.ICON_3, new Icon(1920 - 320, 230, defaultIconTexture));
        this.topRightPannelComponents.put(staticComponents.ICON_4, new Icon(1920 - 250, 230, defaultIconTexture));
    }

    public void update(){
        drawBaseLayout();

        for (UIComponentInterface component: topRightPannelComponents.values()) {
            component.draw();
        }

        for (UIComponentInterface component: bottomRightPannelComponents) {
            component.draw();
        }

        scrollingText.draw();
    }

    public Collection<UIComponentInterface> getTopRightPannelComponents() {
        return topRightPannelComponents.values();
    }

    public void addTopRightPannelComponents(staticComponents staticComponents, UIComponentInterface uiComponent) {
        this.topRightPannelComponents.put(staticComponents, uiComponent);
    }

    public void removeTopRightPannelComponents(staticComponents staticComponents) {
        this.topRightPannelComponents.remove(staticComponents);
    }

    public List<UIComponentInterface> getBottomRightPannelComponents() {
        return bottomRightPannelComponents;
    }

    public void addBottomRightPannelComponents(UIComponentInterface uiComponent) {
        this.bottomRightPannelComponents.add(uiComponent);
    }

    public void removeBottomRightPannelComponents(UIComponentInterface uiComponent) {
        this.bottomRightPannelComponents.remove(uiComponent);
    }

    public void setScrollingText(String message) {
        scrollingText.setText(message);
    }


}
