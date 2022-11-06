package by.bsuir.lab2.dao;

import by.bsuir.lab2.entity.Appliance;
import by.bsuir.lab2.entity.criteria.Criteria;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String XML_PATH = "src/by/bsuir/lab2/resources/appliance.xml";
    private Document xmlDocument;

    public ApplianceDAOImpl() {
        xmlDocument = getDocument();
    }

    public ArrayList<Appliance> find(Criteria criteria) {
        return null;
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
                    currAppliance = applianceType.getConstructor(Node.class).newInstance(new Object[] { appliance });
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }

                findAppliances.add((Appliance) currAppliance);
            }

        }
        return findAppliances;
    }
}
