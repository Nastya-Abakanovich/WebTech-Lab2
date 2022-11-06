package by.bsuir.lab2.entity;


public class Kettle extends Appliance {
    private double Volume;
    private double PowerConsumption;
    private double CordLength;
    private double Weight;

    public Kettle() {
        this.Volume = 0.0;
        this.PowerConsumption = 0.0;
        this.CordLength = 0.0;
        this.Weight = 0.0;
    }

    public Kettle(Kettle kettle) {
        super(kettle.getCompanyName(), kettle.getModelName(), kettle.getPrice(), kettle.getWarrantyTime());
        this.Volume = kettle.getVolume();
        this.PowerConsumption = kettle.getPowerConsumption();
        this.CordLength = kettle.getCordLength();
        this.Weight = kettle.getWeight();
    }

    public Kettle(Appliance appliance, double volume, double capacity, double cordLength, double weight) {
        super(appliance);
        this.Volume = volume;
        this.PowerConsumption = capacity;
        this.CordLength = cordLength;
        this.Weight = weight;
    }

    public Kettle(String companyName, String modelName, double price, double warrantyTime, double volume, double capacity, double cordLength, double weight) {
        super(companyName, modelName, price, warrantyTime);
        this.Volume = volume;
        this.PowerConsumption = capacity;
        this.CordLength = cordLength;
        this.Weight = weight;
    }

    public double getVolume() {
        return this.Volume;
    }

    public double getPowerConsumption() {
        return this.PowerConsumption;
    }

    public double getCordLength() {
        return this.CordLength;
    }

    public double getWeight() {
        return this.Weight;
    }
}

