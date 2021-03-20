package event;

import state.State;
import object.Object;
import java.util.List;

public class Event extends Object {
    private int impact;
    private List<State> targets;

    public Event(int id, String name, String description, int impact) {
        super(id, name, description);
        this.impact = impact;
    }

    public int getImpact() {
        return this.impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }
}