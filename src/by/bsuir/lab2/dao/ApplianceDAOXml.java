package by.bsuir.lab2.dao;

import by.bsuir.lab2.entity.Appliance;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Implementing an interface {@link ApplianceDAO} for accessing data in XML file.
 */
public class ApplianceDAOXml implements ApplianceDAO {

    private static final String XML_PATH = "src/by/bsuir/lab2/resources/appliance.xml";
    private Document xmlDocument;

    public ApplianceDAOXml() {
        xmlDocument = getDocument();
    }

    /**
     * Finds all appliances of the selected type in the XML.
     * @param applianceType Appliance type to search.
     * @return List of found appliances.
     */
    public ArrayList<Appliance> findByApplianceType(Class applianceType) {
        ArrayList<Appliance> findAppliances = new ArrayList<>();
        NodeList types = xmlDocument.getDocumentElement().getElementsByTagName("type");
        Node appliance;

        for (int i = 0; i < types.getLength(); i++) {
            if (types.item(i).getFirstChild().getNodeValue().equals(applianceType.getSimpleName())) {

                appliance = types.item(i).getParentNode();
                Object currAppliance = null;

                try {
                    currAppliance = applianceType.getConstructor(Node.class).newInstance(appliance);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
                findAppliances.add((Appliance) currAppliance);
            }
        }
        return findAppliances;
    }

    /**
     * Finds the cheapest appliances of any type in the XML.
     * @return List of found appliances.
     */
    public ArrayList<Appliance> findTheCheapestAppliance() {
        return findMaxOrMinPrice((x, y) -> x < y);
    }

    /**
     * Finds the most expensive appliances of any type in the XML.
     * @return List of found appliances.
     */
    public ArrayList<Appliance> findTheMostExpensiveAppliance() {
        return findMaxOrMinPrice((x, y) -> x > y);
    }

    /**
     * Interface for passing a lambda expression to a method.
     */
    private interface Expressions {
        boolean compare(double a, double b);
    }

    /**
     * Finds the appliances with min ar max price of any type in the XML.
     * @param expressions lambda expression for compare.
     * @return List of found appliances.
     */
    private ArrayList<Appliance> findMaxOrMinPrice(Expressions expressions) {
        ArrayList<Appliance> findAppliances = new ArrayList<>();
        NodeList prices = xmlDocument.getDocumentElement().getElementsByTagName("price");
        Node appliance;

        double minPrice = Double.parseDouble(prices.item(0).getTextContent());
        double currPrice;
        for (int i = 1; i < prices.getLength(); i++) {
            try {
                currPrice = Double.parseDouble(prices.item(i).getTextContent());
                if (expressions.compare(currPrice, minPrice)) {
                    minPrice = currPrice;
                }
            } catch (Exception e) { }
        }

        for (int i = 0; i < prices.getLength(); i++) {
            try {
                currPrice = Double.parseDouble(prices.item(i).getTextContent());
            } catch (Exception e) {
                continue;
            }

            if (minPrice == currPrice) {
                appliance = prices.item(i).getParentNode();
                NodeList nodes = appliance.getChildNodes();

                int j = 0;
                String field;
                do {
                    field = nodes.item(j).getNodeName();
                    j++;
                } while (j < nodes.getLength() && !field.equals("type"));
                String className = "by.bsuir.lab2.entity." + nodes.item(j - 1).getTextContent();

                Object currAppliance = null;
                try {
                    currAppliance = Class.forName(className).getConstructor(Node.class).newInstance(appliance);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                findAppliances.add((Appliance) currAppliance);
            }
        }
        return findAppliances;
    }

    /**
     * Reads data from a XML-file into a Document.
     * @return document with read data.
     */
    private Document getDocument() {
        Document document = null;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(XML_PATH);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        return document;
    }
}
