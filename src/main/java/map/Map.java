package map;

import java.io.File;
import java.util.*;

import state.Country;

public class Map {
    private final Country country;
    List<MapState> states;

    public Map(Country country) {
        this.states = new ArrayList<>();
        this.country = country;

        initializeStates();
    }

    private void initializeStates() {
        File directory = new File("./src/main/resources/assets/states/");
        for (File file : Objects.requireNonNull(directory.listFiles())
        ) {
            for (state.State state: this.country.getStateList()
                 ) {
                if(state.getName().equalsIgnoreCase(file.getName().replace(".png", ""))){
                    this.states.add(new MapState(file.getPath(), (double) state.getRepublicanScore()));
                    break;
                }
            }
        }
    }

    public void update() {

        for (MapState component : states) {
            component.draw();
        }
    }
}
