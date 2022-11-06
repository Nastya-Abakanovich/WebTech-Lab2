package by.bsuir.lab2.entity;


public class Laptop extends Appliance {
    private double BatteryCapacity;
    private String OS;
    private int MemoryRom;
    private int SystemMemory;
    private double CPU;
    private double DisplayInchs;

    public Laptop() {
        this.BatteryCapacity = 0.0;
        this.OS = "";
        this.MemoryRom = 0;
        this.SystemMemory = 0;
        this.CPU = 0.0;
        this.DisplayInchs = 0.0;
    }

    public Laptop(Laptop laptop) {
        super(laptop.getCompanyName(), laptop.getModelName(), laptop.getPrice(), laptop.getWarrantyTime());
        this.BatteryCapacity = laptop.getBatteryCapacity();
        this.OS = laptop.getOS();
        this.MemoryRom = laptop.getMemoryRom();
        this.SystemMemory = laptop.getSystemMemory();
        this.CPU = laptop.getCPU();
        this.DisplayInchs = laptop.getDisplayInchs();
    }

    public Laptop(Appliance appliance, double batteryCapacity, String OS, int memoryRom, int systemMemory, double CPU, double displayInchs) {
        super(appliance);
        this.BatteryCapacity = batteryCapacity;
        this.OS = OS;
        this.MemoryRom = memoryRom;
        this.SystemMemory = systemMemory;
        this.CPU = CPU;
        this.DisplayInchs = displayInchs;
    }

    public Laptop(String companyName, String modelName, double price, double warrantyTime, double batteryCapacity, String OS, int memoryRom, int systemMemory, double CPU, double displayInchs) {
        super(companyName, modelName, price, warrantyTime);
        this.BatteryCapacity = batteryCapacity;
        this.OS = OS;
        this.MemoryRom = memoryRom;
        this.SystemMemory = systemMemory;
        this.CPU = CPU;
        this.DisplayInchs = displayInchs;
    }

    public double getBatteryCapacity() {
        return this.BatteryCapacity;
    }

    public String getOS() {
        return this.OS;
    }

    public int getMemoryRom() {
        return this.MemoryRom;
    }

    public int getSystemMemory() {
        return this.SystemMemory;
    }

    public double getCPU() {
        return this.CPU;
    }

    public double getDisplayInchs() {
        return this.DisplayInchs;
    }
}

