package by.bsuir.lab2.dao;

import by.bsuir.lab2.entity.Appliance;

import java.util.ArrayList;

public interface ApplianceDAO {
    ArrayList<Appliance> findByApplianceType(Class applianceType);
    ArrayList<Appliance> findTheCheapestAppliance();
    ArrayList<Appliance> findTheMostExpensiveAppliance();
}
