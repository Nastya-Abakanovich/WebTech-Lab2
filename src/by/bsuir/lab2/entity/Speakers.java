package by.bsuir.lab2.entity;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Speakers extends Appliance {
    private double powerConsumption;
    private int numberOfSpeakers;
    private int maxFrequencyRange;
    private double cordLength;

    public Speakers() {
        this.powerConsumption = 0.0;
        this.numberOfSpeakers = 0;
        this.maxFrequencyRange = 0;
        this.cordLength = 0.0;
    }

    public Speakers(Speakers speakers) {
        super(speakers.getCompanyName(), speakers.getModelName(), speakers.getPrice(), speakers.getWarrantyTime());
        this.powerConsumption = speakers.getPowerConsumption();
        this.numberOfSpeakers = speakers.getNumberOfSpeakers();
        this.maxFrequencyRange = speakers.getMaxFrequencyRange();
        this.cordLength = speakers.getCordLength();
    }

    public Speakers(Appliance appliance, double powerConsumption, int numberOfSpeakers,
                    int maxFrequencyRange, double cordLength) {
        super(appliance);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.maxFrequencyRange = maxFrequencyRange;
        this.cordLength = cordLength;
    }

    public Speakers(String companyName, String modelName, double price, double warrantyTime, double powerConsumption,
                    int numberOfSpeakers, int maxFrequencyRange, double cordLength) {
        super(companyName, modelName, price, warrantyTime);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.maxFrequencyRange = maxFrequencyRange;
        this.cordLength = cordLength;
    }

    public Speakers(Node appliance) {
        super(appliance);
        NodeList nodes = appliance.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            String field = nodes.item(i).getNodeName();
            String value = nodes.item(i).getTextContent();

            switch (field) {
                case "powerConsumption" -> powerConsumption = Double.parseDouble(value);
                case "numberOfSpeakers" -> numberOfSpeakers = Integer.parseInt(value);
                case "maxFrequencyRange" -> maxFrequencyRange = Integer.parseInt(value);
                case "cordLength" -> cordLength = Double.parseDouble(value);
            }
        }
    }

    public double getPowerConsumption() {
        return this.powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return this.numberOfSpeakers;
    }

    public int getMaxFrequencyRange() {
        return this.maxFrequencyRange;
    }

    public double getCordLength() {
        return this.cordLength;
    }

    @Override
    public String toString() {
        return "Speakers: \n" + super.toString() +
                "powerConsumption=" + powerConsumption + "W\n" +
                "numberOfSpeakers=" + numberOfSpeakers + "\n" +
                "maxFrequencyRange=" + maxFrequencyRange + "Hz\n" +
                "cordLength=" + cordLength + "m\n";
    }
}
