package by.bsuir.lab2.entity;


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

    public Kettle(Appliance appliance, double volume, double capacity, double cordLength, double weight) {
        super(appliance);
        this.volume = volume;
        this.powerConsumption = capacity;
        this.cordLength = cordLength;
        this.weight = weight;
    }

    public Kettle(String companyName, String modelName, double price, double warrantyTime, double volume, double capacity, double cordLength, double weight) {
        super(companyName, modelName, price, warrantyTime);
        this.volume = volume;
        this.powerConsumption = capacity;
        this.cordLength = cordLength;
        this.weight = weight;
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
}

