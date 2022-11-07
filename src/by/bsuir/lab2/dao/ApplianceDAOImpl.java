package by.bsuir.lab2.dao;

import by.bsuir.lab2.entity.Appliance;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.Expression;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String XML_PATH = "src/by/bsuir/lab2/resources/appliance.xml";
    private Document xmlDocument;

    public ApplianceDAOImpl() {
        xmlDocument = getDocument();
    }

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

    interface Comparison{
        boolean comp(double a, double b);
    }
    public ArrayList<Appliance> findTheCheapestAppliance() {
        return findMaxOrMinPrice((x, y) -> x < y);
    }

    public ArrayList<Appliance> findTheMostExpensiveAppliance() {
        return findMaxOrMinPrice((x, y) -> x > y);
    }

    private ArrayList<Appliance> findMaxOrMinPrice(Comparison comparison) {
        ArrayList<Appliance> findAppliances = new ArrayList<>();
        NodeList prices = xmlDocument.getDocumentElement().getElementsByTagName("price");
        Node appliance;

        double minPrice = Double.parseDouble(prices.item(0).getTextContent());
        double currPrice;
        for (int i = 1; i < prices.getLength(); i++) {
            try {
                currPrice = Double.parseDouble(prices.item(i).getTextContent());
                if (comparison.comp(currPrice, minPrice)) {
                    minPrice = currPrice;
                }
            } catch (Exception e) {
            }
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
}
