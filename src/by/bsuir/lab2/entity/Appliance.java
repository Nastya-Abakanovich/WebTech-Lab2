package by.bsuir.lab2.entity;


import java.io.Serializable;

public class Appliance implements Serializable {
    private String CompanyName;
    private String ModelName;
    private double Price;
    private double WarrantyTime;

    public Appliance() {
        this.CompanyName = "";
        this.ModelName = "";
        this.Price = 0.0;
        this.WarrantyTime = 0.0;
    }

    public Appliance(Appliance appliance) {
        this.CompanyName = appliance.getCompanyName();
        this.ModelName = appliance.getModelName();
        this.Price = appliance.getPrice();
        this.WarrantyTime = appliance.getWarrantyTime();
    }

    public Appliance(String companyName, String modelName, double price, double warrantyTime) {
        this.CompanyName = companyName;
        this.ModelName = modelName;
        this.Price = price;
        this.WarrantyTime = warrantyTime;
    }

    public String getCompanyName() {
        return this.CompanyName;
    }

    public String getModelName() {
        return this.ModelName;
    }

    public double getPrice() {
        return this.Price;
    }

    public double getWarrantyTime() {
        return this.WarrantyTime;
    }
}

