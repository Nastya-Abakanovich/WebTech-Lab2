package by.bsuir.lab2.service;

import by.bsuir.lab2.dao.ApplianceDAO;
import by.bsuir.lab2.dao.DAOFactory;
import by.bsuir.lab2.entity.Appliance;

import java.util.ArrayList;

public class ApplianceServiceImpl implements ApplianceService {
    public ApplianceServiceImpl() {
    }

    public ArrayList<Appliance> findByApplianceType(Class applianceType) {
        ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
        return applianceDAO.findByApplianceType(applianceType);
    }
    public ArrayList<Appliance> findTheCheapestAppliance() {
        ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
        return applianceDAO.findTheCheapestAppliance();
    }
    public ArrayList<Appliance> findTheMostExpensiveAppliance() {
        ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
        return applianceDAO.findTheMostExpensiveAppliance();
    }
}
