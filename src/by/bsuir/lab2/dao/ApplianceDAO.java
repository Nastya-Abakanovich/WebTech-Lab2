package by.bsuir.lab2.dao;

import by.bsuir.lab2.entity.Appliance;
import by.bsuir.lab2.entity.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceDAO {
    ArrayList<Appliance> find(Criteria var1);
}
