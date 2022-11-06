package by.bsuir.lab2.entity;


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

