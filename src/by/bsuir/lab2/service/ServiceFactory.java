package by.bsuir.lab2.service;

import by.bsuir.lab2.dao.ApplianceDAO;
import by.bsuir.lab2.dao.DAOFactory;

/**
 * The class returns references to an object whose class implements {@link ApplianceService}.
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {
    }

    /**
     * Gets the value of a reference to an object that implements {@link ApplianceService}.
     * @return an object whose class implements {@link ApplianceService}.
     */
    public ApplianceService getApplianceService() {
        return this.applianceService;
    }

    /**
     * Gets object {@link ServiceFactory}.
     * @return the only instance of class {@link ServiceFactory}.
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

}
