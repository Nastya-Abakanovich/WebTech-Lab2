package by.bsuir.lab2.entity;


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

    public Speakers(Appliance appliance, double powerConsumption, int numberOfSpeakers, int maxFrequencyRange, double cordLength) {
        super(appliance);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.maxFrequencyRange = maxFrequencyRange;
        this.cordLength = cordLength;
    }

    public Speakers(String companyName, String modelName, double price, double warrantyTime, double powerConsumption, int numberOfSpeakers, int maxFrequencyRange, double cordLength) {
        super(companyName, modelName, price, warrantyTime);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.maxFrequencyRange = maxFrequencyRange;
        this.cordLength = cordLength;
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
}
