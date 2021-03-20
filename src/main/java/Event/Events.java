package Event;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class Events {
    public static Event getEvent(int id) throws ParserConfigurationException, IOException, SAXException {
        // Source : https://www.javatpoint.com/how-to-read-xml-file-in-java
        try {
            //creating a constructor of file class and parsing an XML file
            File file = new File("F:\\XMLFile.xml");
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
        } catch (Exception e) { e.printStackTrace(); }
        return new Event(-1, "Error", "You should not be seing this", 0);
    }
}
