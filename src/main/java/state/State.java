package state;

import object.Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class State {
    private final String name;
    private int republicanScore;
    private int population;
    private final int weight;
    private boolean destroyed;
    private List<Object> occurredEvents;
    private boolean hasCoalFactory;
    private final Random random = new Random();

    public State (String name, int population, int weight){

        this.name = name;
        this.population = population;
        this.weight = weight;
        this.republicanScore = 35 + random.nextInt(31);
        this.destroyed = false;
        this.occurredEvents = new ArrayList<>(Collections.emptyList());
        this.hasCoalFactory = false;
    }

    public State (String name, int population, int weight, int republicanScore){
        this.name = name;
        this.population = population;
        this.weight = weight;
        this.republicanScore = republicanScore;
    }

    @Override
    public String toString() {
        return "name=" + this.name;
    }

    public int getRepublicanScore() {
        return this.republicanScore;
    }

    public void setRepublicanScore(int republicanScore) {
        this.republicanScore = republicanScore;
    }

    public void addRepublicanScore(int amount) {
        this.republicanScore += amount;
        if (this.republicanScore > 100) { this.republicanScore = 100; }
    }

    public int getDemocratScore() {
        return this.population - this.republicanScore;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isDestroyed() { return this.destroyed; }

    public void destroy() { this.destroyed = true; }

    public List<Object> getOccurredEvents() { return this.occurredEvents; }

    public void addEvent(Object event) { this.occurredEvents.add(event); }

    public boolean hasCoalFactory() { return this.hasCoalFactory; }

    public void buildCoalFactory() { this.hasCoalFactory = true; }

    public void republicanrandomchange(int min ,int max){
        if (!this.hasCoalFactory) addRepublicanScore(random.nextInt(max - min + 1) + min);
        else addRepublicanScore(random.nextInt(max - (min+3) + 1) + (min+3));
    }
}
