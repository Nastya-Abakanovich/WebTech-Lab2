package by.bsuir.lab2.entity;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Kettle extends Appliance {
    private double volume;
    private double powerConsumption;
    private double cordLength;
    private double weight;

    public Kettle() {
        this.volume = 0.0;
        this.powerConsumption = 0.0;
        this.cordLength = 0.0;
        this.weight = 0.0;
    }

    public Kettle(Kettle kettle) {
        super(kettle.getCompanyName(), kettle.getModelName(), kettle.getPrice(), kettle.getWarrantyTime());
        this.volume = kettle.getVolume();
        this.powerConsumption = kettle.getPowerConsumption();
        this.cordLength = kettle.getCordLength();
        this.weight = kettle.getWeight();
    }

    public Kettle(Appliance appliance, double volume, double powerConsumption, double cordLength, double weight) {
        super(appliance);
        this.volume = volume;
        this.powerConsumption = powerConsumption;
        this.cordLength = cordLength;
        this.weight = weight;
    }

    public Kettle(String companyName, String modelName, double price, double warrantyTime, double volume,
                  double powerConsumption, double cordLength, double weight) {
        super(companyName, modelName, price, warrantyTime);
        this.volume = volume;
        this.powerConsumption = powerConsumption;
        this.cordLength = cordLength;
        this.weight = weight;
    }

    public Kettle(Node appliance) {
        super(appliance);
        NodeList nodes = appliance.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            String field = nodes.item(i).getNodeName();
            String value = nodes.item(i).getTextContent();

            switch (field) {
                case "volume" -> volume = Double.parseDouble(value);
                case "powerConsumption" -> powerConsumption = Double.parseDouble(value);
                case "cordLength" -> cordLength = Double.parseDouble(value);
                case "weight" -> weight = Double.parseDouble(value);
            }
        }
    }

    public double getVolume() {
        return this.volume;
    }

    public double getPowerConsumption() {
        return this.powerConsumption;
    }

    public double getCordLength() {
        return this.cordLength;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Kettle:\n" + super.toString() +
                "volume=" + volume + "l\n" +
                "powerConsumption=" + powerConsumption +  "W\n" +
                "cordLength=" + cordLength +  "m\n" +
                "weight=" + weight + "g\n";
    }
}

