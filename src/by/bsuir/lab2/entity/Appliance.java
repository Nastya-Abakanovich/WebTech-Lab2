package by.bsuir.lab2.entity;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Appliance{
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
                case "companyName" -> companyName = value;
                case "modelName" -> modelName = value;
                case "price" -> price = Double.parseDouble(value);
                case "warrantyTime" -> warrantyTime = Double.parseDouble(value);
            }
        }
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

    @Override
    public String toString() {
        return companyName + " " + modelName + '\n' +
                "price=" + price +  " BYN\n" +
                "warrantyTime=" + warrantyTime + " months\n";
    }
}

