package by.bsuir.lab2.entity;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;

public class Appliance implements Serializable {
    private String companyName;
    private String modelName;
    private double price;
    private double warrantyTime;

    public Appliance() {
        this.companyName = "";
        this.modelName = "";
        this.price = 0.0;
        this.warrantyTime = 0.0;
    }

    public Appliance(Appliance appliance) {
        this.companyName = appliance.getCompanyName();
        this.modelName = appliance.getModelName();
        this.price = appliance.getPrice();
        this.warrantyTime = appliance.getWarrantyTime();
    }

    public Appliance(String companyName, String modelName, double price, double warrantyTime) {
        this.companyName = companyName;
        this.modelName = modelName;
        this.price = price;
        this.warrantyTime = warrantyTime;
    }

    public Appliance(Node appliance) {
        NodeList nodes = appliance.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            String field = nodes.item(i).getNodeName();
            String value = nodes.item(i).getTextContent();

            switch (field) {
                case "companyName":
                    companyName = value;
                    break;
                case "modelName":
                    modelName = value;
                    break;
                case "price":
                    price = Double.parseDouble(value);
                    break;
                case "warrantyTime":
                    warrantyTime = Double.parseDouble(value);
                    break;
            }
        }

//        Document doc = appliance.getOwnerDocument();
//        companyName = doc.getElementsByTagName("companyName").item(0).getTextContent();
//        modelName = doc.getElementsByTagName("modelName").item(0).getFirstChild().getNodeValue();
//        price = Double.parseDouble(doc.getElementsByTagName("price").item(0).getFirstChild().getNodeValue());
//        warrantyTime = Double.parseDouble(doc.getElementsByTagName("warrantyTime").item(0).getFirstChild().getNodeValue());
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getModelName() {
        return this.modelName;
    }

    public double getPrice() {
        return this.price;
    }

    public double getWarrantyTime() {
        return this.warrantyTime;
    }

}

