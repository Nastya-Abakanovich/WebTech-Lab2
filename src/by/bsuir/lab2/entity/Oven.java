package by.bsuir.lab2.entity;


public class Oven extends Appliance {
    private double PowerConsumption;
    private double Weight;
    private double Capacity;
    private double Depth;
    private double Height;
    private double Width;

    public Oven() {
        this.PowerConsumption = 0.0;
        this.Weight = 0.0;
        this.Capacity = 0.0;
        this.Depth = 0.0;
        this.Height = 0.0;
        this.Width = 0.0;
    }

    public Oven(Oven oven) {
        super(oven.getCompanyName(), oven.getModelName(), oven.getPrice(), oven.getWarrantyTime());
        this.PowerConsumption = oven.getPowerConsumption();
        this.Weight = oven.getWeight();
        this.Capacity = oven.getCapacity();
        this.Depth = oven.getDepth();
        this.Height = oven.getHeight();
        this.Width = oven.getWidth();
    }

    public Oven(Appliance appliance, double powerConsumption, double weight, double capacity, double depth, double height, double width) {
        super(appliance);
        this.PowerConsumption = powerConsumption;
        this.Weight = weight;
        this.Capacity = capacity;
        this.Depth = depth;
        this.Height = height;
        this.Width = width;
    }

    public Oven(String companyName, String modelName, double price, double warrantyTime, double powerConsumption, double weight, double capacity, double depth, double height, double width) {
        super(companyName, modelName, price, warrantyTime);
        this.PowerConsumption = powerConsumption;
        this.Weight = weight;
        this.Capacity = capacity;
        this.Depth = depth;
        this.Height = height;
        this.Width = width;
    }

    public double getPowerConsumption() {
        return this.PowerConsumption;
    }

    public double getWeight() {
        return this.Weight;
    }

    public double getCapacity() {
        return this.Capacity;
    }

    public double getDepth() {
        return this.Depth;
    }

    public double getHeight() {
        return this.Height;
    }

    public double getWidth() {
        return this.Width;
    }
}
