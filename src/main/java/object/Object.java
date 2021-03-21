package object;

import java.util.Objects;

public class Object {
    private final String type;
    private final int id;
    private final String name;
    private final String description;
    private final int cost;
    private final int impact;

    public Object() {
        this.type = "Action";
        this.id = 0;
        this.name = null;
        this.description = null;
        this.cost = 0;
        this.impact = 0;
    }

    public Object(String type, int id, String name, String description, int cost, int impact) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.impact = impact;
    }

    @Override
    public String toString() { return "name=" + this.name + ", description=" + this.description; }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(type, o.type) && id == o.id && Objects.equals(name, o.name);
    }

    public String getType() { return this.type; }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public String getDescription() { return this.description; }
    
    public int getCost() { return this.cost; }

    public int getImpact() {
        return this.impact;
    }
}
