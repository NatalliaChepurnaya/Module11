package by.epam.tr.service.factory;

import by.epam.tr.service.StoreService;
import by.epam.tr.service.impl.StoreServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final StoreService storeService = new StoreServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getIstance() {
		return instance;
	}
	
	public StoreService getStoreService() {
		return storeService;
	}
	
}
