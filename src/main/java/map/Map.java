package map;

import java.io.File;
import java.util.*;

import state.Country;

import static com.raylib.Jaylib.*;

public class Map {
    private final Country country;
    List<State> states;

    public Map(Country country) {
        this.states = new ArrayList<>();
        this.country = country;

        initializeStates();
    }

    private void initializeStates() {
        Random rand = new Random();
        File directory = new File("./src/main/resources/assets/states/");
        for (File file : Objects.requireNonNull(directory.listFiles())
        ) {
            double dblRandom = rand.nextDouble();
            for (state.State state: this.country.getStateList()
                 ) {
                if(state.getName().equals(file.getName().replace(".png", ""))){
                    this.states.add(new State(file.getPath(), (double) state.getRepublicanScore()));
                    break;
                }else{
                    System.out.println(state.getName());
                    System.out.println(file.getName().replace(".png", ""));
                } // TODO some states aren't rendering for some reasons...
            }

        }

    }

    public void update() {

        for (State component : states) {
            component.draw();
        }
    }
}
