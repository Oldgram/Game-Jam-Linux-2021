package object;

public class Object {
    private final int id;
    private final String name;
    private final String description;

    public Object(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() { return "name=" + this.name + ", description=" + this.description; }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public String getDescription() { return this.description; }
}
