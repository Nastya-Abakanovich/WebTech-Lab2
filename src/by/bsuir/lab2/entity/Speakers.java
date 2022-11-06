package by.bsuir.lab2.entity;


public class Speakers extends Appliance {
    private double PowerConsumption;
    private int NumberOfSpeakers;
    private int MaxFrequencyRange;
    private double CordLength;

    public Speakers() {
        this.PowerConsumption = 0.0;
        this.NumberOfSpeakers = 0;
        this.MaxFrequencyRange = 0;
        this.CordLength = 0.0;
    }

    public Speakers(Speakers speakers) {
        super(speakers.getCompanyName(), speakers.getModelName(), speakers.getPrice(), speakers.getWarrantyTime());
        this.PowerConsumption = speakers.getPowerConsumption();
        this.NumberOfSpeakers = speakers.getNumberOfSpeakers();
        this.MaxFrequencyRange = speakers.getMaxFrequencyRange();
        this.CordLength = speakers.getCordLength();
    }

    public Speakers(Appliance appliance, double powerConsumption, int numberOfSpeakers, int maxFrequencyRange, double cordLength) {
        super(appliance);
        this.PowerConsumption = powerConsumption;
        this.NumberOfSpeakers = numberOfSpeakers;
        this.MaxFrequencyRange = maxFrequencyRange;
        this.CordLength = cordLength;
    }

    public Speakers(String companyName, String modelName, double price, double warrantyTime, double powerConsumption, int numberOfSpeakers, int maxFrequencyRange, double cordLength) {
        super(companyName, modelName, price, warrantyTime);
        this.PowerConsumption = powerConsumption;
        this.NumberOfSpeakers = numberOfSpeakers;
        this.MaxFrequencyRange = maxFrequencyRange;
        this.CordLength = cordLength;
    }

    public double getPowerConsumption() {
        return this.PowerConsumption;
    }

    public int getNumberOfSpeakers() {
        return this.NumberOfSpeakers;
    }

    public int getMaxFrequencyRange() {
        return this.MaxFrequencyRange;
    }

    public double getCordLength() {
        return this.CordLength;
    }
}
