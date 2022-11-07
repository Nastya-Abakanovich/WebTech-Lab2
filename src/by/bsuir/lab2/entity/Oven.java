package by.bsuir.lab2.entity;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Oven extends Appliance {
    private double powerConsumption;
    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;

    public Oven() {
        this.powerConsumption = 0.0;
        this.weight = 0.0;
        this.capacity = 0.0;
        this.depth = 0.0;
        this.height = 0.0;
        this.width = 0.0;
    }

    public Oven(Oven oven) {
        super(oven.getCompanyName(), oven.getModelName(), oven.getPrice(), oven.getWarrantyTime());
        this.powerConsumption = oven.getPowerConsumption();
        this.weight = oven.getWeight();
        this.capacity = oven.getCapacity();
        this.depth = oven.getDepth();
        this.height = oven.getHeight();
        this.width = oven.getWidth();
    }

    public Oven(Appliance appliance, double powerConsumption, double weight, double capacity,
                double depth, double height, double width) {
        super(appliance);
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public Oven(String companyName, String modelName, double price, double warrantyTime, double powerConsumption,
                double weight, double capacity, double depth, double height, double width) {
        super(companyName, modelName, price, warrantyTime);
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public Oven(Node appliance) {
        super(appliance);
        NodeList nodes = appliance.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            String field = nodes.item(i).getNodeName();
            String value = nodes.item(i).getTextContent();

            switch (field) {
                case "powerConsumption" -> powerConsumption = Double.parseDouble(value);
                case "weight" -> weight = Double.parseDouble(value);
                case "capacity" -> capacity = Double.parseDouble(value);
                case "depth" -> depth = Double.parseDouble(value);
                case "height" -> height = Double.parseDouble(value);
                case "width" -> width = Double.parseDouble(value);
            }
        }
    }

    public double getPowerConsumption() {
        return this.powerConsumption;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getDepth() {
        return this.depth;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    public String toString() {
        return "Oven: \n" + super.toString() +
                "powerConsumption=" + powerConsumption + "W\n" +
                "weight=" + weight + "kg\n" +
                "capacity=" + capacity + "l\n" +
                "depth=" + depth + "sm\n" +
                "height=" + height + "sm\n" +
                "width=" + width + "sm\n";
    }
}
