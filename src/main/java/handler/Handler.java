package handler;

import state.State;
import action.Action;
import event.Event;
import upgrade.Upgrade;
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

public class Handler {
    /**
     * @param type  the type of data requested (Action, Event, Upgrade)
     * @param id : the id of the desired event, as an int
     * @param targetStates : the targeted states on which the event will be applied, as a list of State
     * @return the eventId if it was triggered correctly, 0 otherwise;
     */
    public static int trigger(String type, int id, List<State> targetStates) {
        //TODO
        try {
            Object object = getObject(type, id);
            return id;
        } catch (Exception e) { e.fillInStackTrace(); return 0; }
    }

    /**
     * @param type : the type of data requested (Action, Event, Upgrade)
     * @param id : the id of the desired action
     * @return the event as an instance of Action
     */
    public static Object getObject(String type, int id) throws NoSuchElementException, IOException, SAXException, ParserConfigurationException {
        // Source : https://www.javatpoint.com/how-to-read-xml-file-in-java
        //creating a constructor of file class and parsing an XML file
        File file = new File("src/main/resources/xml/" + type + "List.xml");
        //an instance of factory that gives a document builder
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //an instance of builder to parse the specified xml file
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName(type.toLowerCase());
        // nodeList is not iterable, so we are using for loop
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            Element eElement = (Element) node;
            if (Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == id) {
                switch(type) {
                    case "Action":
                        return getAction(eElement);
                    case "Event":
                        return getEvent(eElement);
                    case "Upgrade":
                        return getUpgrade(eElement);
                }
            }
        }
        throw new NoSuchElementException();
    }

    private static Action getAction(Element element) {
        return new Action(
                Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                element.getElementsByTagName("name").item(0).getTextContent(),
                element.getElementsByTagName("description").item(0).getTextContent(),
                Integer.parseInt(element.getElementsByTagName("cost").item(0).getTextContent()),
                Integer.parseInt(element.getElementsByTagName("impact").item(0).getTextContent())
        );
    }

    private static Event getEvent(Element element) {
        return new Event(
                Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                element.getElementsByTagName("name").item(0).getTextContent(),
                element.getElementsByTagName("description").item(0).getTextContent(),
                Integer.parseInt(element.getElementsByTagName("impact").item(0).getTextContent())
        );
    }

    private static Upgrade getUpgrade(Element element) {
        return new Upgrade(
                Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                element.getElementsByTagName("name").item(0).getTextContent(),
                element.getElementsByTagName("description").item(0).getTextContent(),
                Integer.parseInt(element.getElementsByTagName("cost").item(0).getTextContent()),
                Integer.parseInt(element.getElementsByTagName("impact").item(0).getTextContent())
        );

    }
}
