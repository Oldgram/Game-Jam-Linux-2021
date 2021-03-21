package player;

import object.Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private int actionPoints;
    private int actionPool;
    private List<Object> upgradeList;

    private Player() {
        this.actionPoints = 0;
        this.actionPool = 10;
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

    public int getActionPool() { return this.actionPool; }

    public void increaseActionPool(int amount) { this.actionPool += amount; }

    public List<Object> getUpgradeList() { return this.upgradeList; }

    public void addUpgrade(Object upgrade) { this.upgradeList.add(upgrade); this.addActionPoints(upgrade.getImpact()); }

    public boolean asUpgrade(Object upgrade) { return this.upgradeList.contains(upgrade); }
}
