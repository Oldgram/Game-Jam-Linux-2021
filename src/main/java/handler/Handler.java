package handler;

import player.Player;
import state.State;
import state.Country;
import object.Object;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Handler {
    private static final Random r = new Random();
    private static Country country ;

    /**
     * @param object : the object (Action, Event, Upgrade) to be triggered
     * @param state : the targeted states on which the event will be applied, as a list of State
     * @param player : the player as an instance of Player
     */
    public static void trigger(Object object, State state, Player player) {
        try {
            if (player.getActionPoints() >= object.getCost()) {
                state.setRepublicanScore(state.getRepublicanScore() + object.getImpact());
                switch (object.getType()) {
                    case "Action":
                        triggerAction(object, state, player);
                        break;
                    case "Event":
                        triggerEvent(object, state, player);
                        break;
                    case "Upgrade":
                        triggerUpgrade(object, state, player);
                        break;
                }
            }
        } catch (Exception e) { e.fillInStackTrace();}
    }

    private static void triggerAction(Object action, State state, Player player) throws ParserConfigurationException, SAXException, IOException {
        switch (action.getId()) {
            case 1:
            case 7:
            case 8:
                break;
            case 2: // Tweeter
                if (player.asUpgrade(getObject("Upgrade", 1))) {
                    int result = r.nextInt(100), effect = r.nextInt(100);
                    if (result <= 25) { state.addRepublicanScore(effect); }
                    if (25 < result && result <= 50) { state.addRepublicanScore(-effect); }
                    if (50 < result && result <= 90) { triggerEvent(getObject("Event", 9), state, player); }
                    if (90 < result) { triggerEvent(getObject("Event", 10), state, player); }
                } else {
                    triggerEvent(getObject("Event", 98), state, player);
                }
                break;
            case 3: // Bloquer un bureau de vote
                state.setPopulation((int) (state.getPopulation() * 0.99));
                break;
            case 4: // Brûler les bureaux de vote
                state.setPopulation((int) (state.getPopulation() * 0.95));
                break;
            case 5: // Ouvrir une usine à charbon
                state.buildCoalFactory();
                int result = r.nextInt(100);
                if (result < 25) {
                    triggerEvent(getObject("Event", 2), state, player); // Tweete climatosceptique
                }
                if (result < 75) {
                    triggerEvent(getObject("Event", 12), state, player); // Votes bonus
                } else {
                    triggerEvent(getObject("Event", 11), state, player); // PA bonus
                }
                break;
            case 6: // Gros bouton rouge
                state.destroy();
                break;
            case 9:
                triggerAction(getObject("Action", r.nextInt(8)), state, player);

        }
    }

    private static void triggerEvent(Object event, State state, Player player) {
        System.out.println(event.getName() + " : Triggered on state : " + state.getName());
        state.addEvent(event);

        switch (event.getId()) {
            case 1:
                player.addActionPoints(5);
                break;
            case 2:
                player.addActionPoints(-5);
                break;
            case 3:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(-5,5));
                break;
            case 4:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(-15,15));
                break;
            case 5:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(0,5));
                break;
            case 6:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(-5,0));
                break;
            case 7:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(0,5));
                break;
            case 8:
                state.republicanrandomchange(-10,0);
                break;
            case 9:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(-10,0));
                break;
            case 10:
                state.destroy();
                break;
            case 11:
                player.addActionPoints(5);
                break;
            case 12:
                state.republicanrandomchange(0,5);
            case 13:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(-10,10));
                break;
            case 14:
                state.republicanrandomchange(-10,0);
                break;
            case 15:
                state.republicanrandomchange(-5,0);
                break;
            case 16:
                state.republicanrandomchange(0,5);
                break;
            case 17:
                country.getStateList().stream().forEach(x -> x.republicanrandomchange(10,15));
                break;
        }
    }

    private static void triggerUpgrade(Object upgrade, State state, Player player) throws ParserConfigurationException, SAXException, IOException {
        switch (upgrade.getId()) {
            case 1:
            case 2:
                player.addActionPoints(upgrade.getImpact());
                player.addUpgrade(upgrade);
                break;
            case 3:
                if (player.asUpgrade(getObject("Upgrade", 2))) {
                    player.addActionPoints(upgrade.getImpact());
                    player.addUpgrade(upgrade);
                } else {
                    triggerEvent(getObject("Event", 97), state, player);
                }
                break;
        }
    }

    /**
     * @param type : the type of object requested (Action, Event, Upgrade)
     * @param id : the id of the desired object
     * @return the event as an instance of object
     */
    public static Object getObject(String type, int id) throws NoSuchElementException, IOException, SAXException, ParserConfigurationException {
        File file = new File("src/main/resources/xml/" + type + "List.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName(type.toLowerCase());

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            if (Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()) == id) {
                return new Object(
                        type,
                        Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                        element.getElementsByTagName("name").item(0).getTextContent(),
                        element.getElementsByTagName("description").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("cost").item(0).getTextContent()),
                        Integer.parseInt(element.getElementsByTagName("impact").item(0).getTextContent())
                );
            }
        }
        throw new NoSuchElementException();
    }
}
