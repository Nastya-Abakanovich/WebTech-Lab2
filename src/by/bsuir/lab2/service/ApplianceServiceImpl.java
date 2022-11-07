package by.bsuir.lab2.service;

import by.bsuir.lab2.dao.ApplianceDAO;
import by.bsuir.lab2.dao.DAOFactory;
import by.bsuir.lab2.entity.Appliance;

import java.util.ArrayList;

/**
 * Implementing an interface {@link ApplianceService} for accessing data in the DAO.
 */
public class ApplianceServiceImpl implements ApplianceService {
    public ApplianceServiceImpl() {
    }

    /**
     * Finds all appliances of the selected type in the DAO.
     * @param applianceType Appliance type to search.
     * @return List of found appliances.
     */
    public ArrayList<Appliance> findByApplianceType(Class applianceType) {
        if (applianceType.getSuperclass() == Appliance.class) {
            ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
            return applianceDAO.findByApplianceType(applianceType);
        }
        else {
            return null;
        }
    }

    /**
     * Finds the cheapest appliances of any type in the DAO.
     * @return List of found appliances.
     */
    public ArrayList<Appliance> findTheCheapestAppliance() {
        ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
        return applianceDAO.findTheCheapestAppliance();
    }

    /**
     * Finds the most expensive appliances of any type in the DAO.
     * @return List of found appliances.
     */
    public ArrayList<Appliance> findTheMostExpensiveAppliance() {
        ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
        return applianceDAO.findTheMostExpensiveAppliance();
    }
}
