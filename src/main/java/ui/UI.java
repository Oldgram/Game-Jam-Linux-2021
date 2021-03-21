package ui;

import java.util.ArrayList;
import java.util.List;
import static com.raylib.Jaylib.*;

import static com.raylib.Raylib.DrawRectangle;

public class UI {
    List<UIComponentInterface> topRightPannelComponents;
    List<UIComponentInterface> bottomRightPannelComponents;
    List<UIComponentInterface> bottomPannelComponents;

    public UI(){
        this.topRightPannelComponents = new ArrayList<>();
        this.bottomRightPannelComponents = new ArrayList<>();
        this.bottomPannelComponents = new ArrayList<>();

        initializeTopRightPanel();
    }

    public UI(List<UIComponentInterface> topRight, List<UIComponentInterface> bottomRight, List<UIComponentInterface> bottom){
        this.topRightPannelComponents = topRight;
        this.bottomRightPannelComponents = bottomRight;
        this.bottomPannelComponents = bottom;

        initializeTopRightPanel();
    }

    private void drawBaseLayout(){
        DrawRectangle(1920 - 490, 0, 490, 1080, DARKGRAY);
        DrawRectangle(1920 - 480, 0, 480, 310, GRAY); // Top right pannel
        DrawRectangle(1920 - 480, 320, 480, 1080 - 300, GRAY); // Bottom right pannel
        DrawRectangle(0, 1080 - 40, 1920, 40, DARKGRAY); // Bottom pannel
    }

    private void initializeTopRightPanel(){
        this.topRightPannelComponents.add(new Label(1920 - 470, 20, "Minesotta", 28));
        this.topRightPannelComponents.add(new Gauge(1860, 80, 23));
    }

    public void update(){
        drawBaseLayout();

        for (UIComponentInterface component: topRightPannelComponents) {
            component.draw();
        }

        for (UIComponentInterface component: bottomRightPannelComponents) {
            component.draw();
        }

        for (UIComponentInterface component: bottomPannelComponents) {
            component.draw();
        }
    }

    public List<UIComponentInterface> getTopRightPannelComponents() {
        return topRightPannelComponents;
    }

    public void addTopRightPannelComponents(UIComponentInterface uiComponent) {
        this.topRightPannelComponents.add(uiComponent);
    }

    public void removeTopRightPannelComponents(UIComponentInterface uiComponent) {
        this.topRightPannelComponents.remove(uiComponent);
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

    public List<UIComponentInterface> getBottomPannelComponents() {
        return bottomPannelComponents;
    }

    public void addBottomPannelComponents(UIComponentInterface uiComponent) {
        this.bottomPannelComponents.add(uiComponent);
    }

    public void removeBottomPannelComponents(UIComponentInterface uiComponent) {
        this.bottomPannelComponents.remove(uiComponent);
    }
}
