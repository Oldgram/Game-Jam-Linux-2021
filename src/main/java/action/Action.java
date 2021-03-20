package action;

import state.State;
import object.Object;

import java.util.List;

public class Action extends Object {
    private final int cost;
    private int impact;
    private List<State> targets;

    public Action (int id, String name,  String description, int cost, int impact) {
        super(id, name, description);
        this.cost = cost;
        this.impact = impact;
    }

    public int getCost() { return this.cost; }

    public int getImpact() { return this.impact; }

    public void setImpact(int impact) { this.impact = impact; }

    public List<State> getTargets(List<State> targets) { return this.targets; }

    public void setTargets(List<State> targets) { this.targets = targets; }
}
