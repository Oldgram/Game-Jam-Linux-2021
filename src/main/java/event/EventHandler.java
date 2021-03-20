package event;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import State.State;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class EventHandler {
    /**
     * @param id : the id of the desired event
     * @return the event as an instance of Event
     */
    private static Event getEvent(int id) throws NoSuchElementException, IOException, SAXException, ParserConfigurationException {
        // Source : https://www.javatpoint.com/how-to-read-xml-file-in-java
        //creating a constructor of file class and parsing an XML file
        File file = new File("./EventLists.xml");
        //an instance of factory that gives a document builder
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //an instance of builder to parse the specified xml file
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("event");
        // nodeList is not iterable, so we are using for loop
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            Element eElement = (Element) node;
            if (Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == id) {
                return new Event(
                        Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()),
                        eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("description").item(0).getTextContent(),
                        Integer.parseInt(eElement.getElementsByTagName("impact").item(0).getTextContent())
                );
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * @param eventId the id of the desired event, as an int
     * @param targetStates the targeted states on which the event will be applied, as a list of State
     * @return the eventId if it was triggered correctly, 0 otherwise;
     */
    public static int triggerEvent(int eventId, List<State> targetStates) {
        //TODO
        try {
            Event event = getEvent(eventId);

            event.setTargets(targetStates);

            return eventId;
        } catch (Exception e) { e.fillInStackTrace(); return 0; }
    }
}
