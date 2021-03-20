package state;

public class State {
    private final String name;
    private int republicanScore;
    private int population;
    private final int weight;

    public State (String name, int population, int weight){
        this.name = name;
        this.population = population;
        this.weight = weight;
        this.republicanScore = 50;
    }

    public State (String name, int population, int weight, int republicanScore){
        this.name = name;
        this.population = population;
        this.weight = weight;
        this.republicanScore = republicanScore;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

    public int getRepublicanScore() {
        return republicanScore;
    }

    public void setRepublicanScore(int republicanScore) {
        this.republicanScore = republicanScore;
    }

    public int getDemocratScore() {
        return population - republicanScore;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
