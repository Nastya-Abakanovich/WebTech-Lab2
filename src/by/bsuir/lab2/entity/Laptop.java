package by.bsuir.lab2.entity;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Laptop extends Appliance {
    private double batteryCapacity;
    private String os;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private double displayInchs;

    public Laptop() {
        this.batteryCapacity = 0.0;
        this.os = "";
        this.memoryRom = 0;
        this.systemMemory = 0;
        this.cpu = 0.0;
        this.displayInchs = 0.0;
    }

    public Laptop(Laptop laptop) {
        super(laptop.getCompanyName(), laptop.getModelName(), laptop.getPrice(), laptop.getWarrantyTime());
        this.batteryCapacity = laptop.getBatteryCapacity();
        this.os = laptop.getOs();
        this.memoryRom = laptop.getMemoryRom();
        this.systemMemory = laptop.getSystemMemory();
        this.cpu = laptop.getCpu();
        this.displayInchs = laptop.getDisplayInchs();
    }

    public Laptop(Appliance appliance, double batteryCapacity, String OS, int memoryRom, int systemMemory,
                  double CPU, double displayInchs) {
        super(appliance);
        this.batteryCapacity = batteryCapacity;
        this.os = OS;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = CPU;
        this.displayInchs = displayInchs;
    }

    public Laptop(String companyName, String modelName, double price, double warrantyTime, double batteryCapacity,
                  String OS, int memoryRom, int systemMemory, double CPU, double displayInchs) {
        super(companyName, modelName, price, warrantyTime);
        this.batteryCapacity = batteryCapacity;
        this.os = OS;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = CPU;
        this.displayInchs = displayInchs;
    }

    public Laptop(Node appliance) {
        super(appliance);
        NodeList nodes = appliance.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            String field = nodes.item(i).getNodeName();
            String value = nodes.item(i).getTextContent();

            switch (field) {
                case "batteryCapacity" -> batteryCapacity = Double.parseDouble(value);
                case "os" -> os = value;
                case "memoryRom" -> memoryRom = Integer.parseInt(value);
                case "systemMemory" -> systemMemory = Integer.parseInt(value);
                case "cpu" -> cpu = Double.parseDouble(value);
                case "displayInchs" -> displayInchs = Double.parseDouble(value);
            }
        }
    }

    public double getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public String getOs() {
        return this.os;
    }

    public int getMemoryRom() {
        return this.memoryRom;
    }

    public int getSystemMemory() {
        return this.systemMemory;
    }

    public double getCpu() {
        return this.cpu;
    }

    public double getDisplayInchs() {
        return this.displayInchs;
    }

    @Override
    public String toString() {
        return "Laptop: \n" + super.toString() +
                "batteryCapacity=" + batteryCapacity + "\n" +
                "os=" + os + "\n" +
                "memoryRom=" + memoryRom + "\n" +
                "systemMemory=" + systemMemory + "\n" +
                "cpu=" + cpu + "\n" +
                "displayInchs=" + displayInchs + "\n";
    }
}

