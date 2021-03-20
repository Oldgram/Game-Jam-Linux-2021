package upgrade;

import object.Object;

public class Upgrade extends Object {
    private boolean unlocked;
    private final int cost;
    private final int impact;

    public Upgrade(int id, String name, String description, int cost, int impact) {
        super(id, name, description);
        this.unlocked = false;
        this.cost = cost;
        this.impact = impact;
    }

    public boolean getState() { return this.unlocked; }

    public void setState(boolean unlocked) { this.unlocked = unlocked; }

    public int getImpact() { return this.impact; }

    public int getCost() { return this.cost; }
}
