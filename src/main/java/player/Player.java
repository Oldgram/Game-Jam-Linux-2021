package player;

public class Player {
    private int actionPoints;

    public Player() {
        this.actionPoints = 0;
    }

    public int getActionPoints() { return this.actionPoints; }

    public void setActionPoints(int amount) { this.actionPoints = amount; }
}
