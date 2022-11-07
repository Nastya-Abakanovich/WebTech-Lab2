package by.bsuir.lab2.main;

import by.bsuir.lab2.entity.*;
import by.bsuir.lab2.service.ApplianceService;
import by.bsuir.lab2.service.ServiceFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplianceService service = ServiceFactory.getInstance().getApplianceService();

        List<Appliance> kettles = service.findByApplianceType(Kettle.class);
        List<Appliance> cheapest = service.findTheCheapestAppliance();

        System.out.println("\n           ALL KETTLES:");
        kettles.forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println("\n        THE CHEAPEST ITEM:");
        cheapest.forEach(System.out::println);

    }
}
