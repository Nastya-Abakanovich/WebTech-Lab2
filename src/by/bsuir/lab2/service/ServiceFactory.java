package by.bsuir.lab2.service;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {
    }

    public ApplianceService getApplianceService() {
        return this.applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
