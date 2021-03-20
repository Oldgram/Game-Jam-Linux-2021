package Event;

import java.io.File;

public class Events {
    public static Event getEvent(int id) {
        File file = new File("./EventsLists.xml");
        return new Event(0, "0", "placeholder", 0);
    }
}
