package by.bsuir.lab2.service;

import by.bsuir.lab2.entity.Appliance;

import java.util.ArrayList;

public interface ApplianceService {

    ArrayList<Appliance> findByApplianceType(Class applianceType);
    ArrayList<Appliance> findTheCheapestAppliance();
    ArrayList<Appliance> findTheMostExpensiveAppliance();
}
