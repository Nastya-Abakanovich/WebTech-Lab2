package by.bsuir.lab2.service;

import by.bsuir.lab2.dao.ApplianceDAO;
import by.bsuir.lab2.dao.DAOFactory;
import by.bsuir.lab2.entity.Appliance;
import by.bsuir.lab2.entity.criteria.Criteria;

import java.util.ArrayList;

public class ApplianceServiceImpl implements ApplianceService {
    public ApplianceServiceImpl() {
    }

    public ArrayList<Appliance> find(Criteria criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        } else {
            DAOFactory factory = DAOFactory.getInstance();
            ApplianceDAO applianceDAO = factory.getApplianceDAO();
            ArrayList<Appliance> listAppliance = applianceDAO.find(criteria);
            return listAppliance;
        }
    }
}
