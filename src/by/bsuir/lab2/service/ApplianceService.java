package by.bsuir.lab2.service;

import by.bsuir.lab2.entity.Appliance;
import by.bsuir.lab2.entity.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceService {
    ArrayList<Appliance> find(Criteria var1);
}
