package event;

import State.State;
import java.util.List;

public class Event {
    private final int id;
    private final String name;
    private String description;
    private int impact;
    private List<State> targets;

    public Event (int id, String name,  String description, int impact) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.impact = impact;
    }

    @Override
    public String toString() { return "name=" + name + ", description=" + description; }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public int getImpact() { return this.impact; }

    public void setImpact(int impact) { this.impact = impact; }

    public List<State> getTargets(List<State> targets) { return this.targets; }

    public void setTargets(List<State> targets) { this.targets = targets; }
}
