package player;

import object.Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private int actionPoints;
    private int pointsGeneration;
    private List<Object> upgradeList;

    private Player() {
        this.actionPoints = 0;
        this.pointsGeneration = 1;
        this.upgradeList = new ArrayList<>(Collections.emptyList());
    }

    private static Player INSTANCE = new Player();

    public static Player getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Player();
        }
        return INSTANCE;
    }

    public int getActionPoints() { return this.actionPoints; }

    public void setActionPoints(int amount) { this.actionPoints = amount; }

    public void addActionPoints(int amount) { this.actionPoints += amount; }

    private int getPointsGeneration() { return this.pointsGeneration; }

    private void setPointsGeneration(int value) { this.pointsGeneration = value; }

    private void addPointGeneration(int value) { this.pointsGeneration += value; }

    public List<Object> getUpgradeList() { return this.upgradeList; }

    public void addUpgrade(Object upgrade) { this.upgradeList.add(upgrade); }

    public boolean asUpgrade(Object upgrade) { return this.upgradeList.contains(upgrade); }
}
