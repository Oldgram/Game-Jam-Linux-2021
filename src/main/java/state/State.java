package state;

import event.Event;

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
    private boolean canVote;
    private List<Event> occurredEvents;

    public State (String name, int population, int weight){
        Random random = new Random();

        this.name = name;
        this.population = population;
        this.weight = weight;
        this.republicanScore = 35 + random.nextInt(31);
        this.destroyed = false;
        this.canVote = true;
        this.occurredEvents = new ArrayList<>(Collections.emptyList());
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

    public boolean canVote() { return this.canVote;}

    public void setVoteAbility(boolean ability) { this.canVote = ability; }

    public List<Event> getOccurredEvents() { return this.occurredEvents; }

    public void addEvent(Event event) { this.occurredEvents.add(event); }
}
