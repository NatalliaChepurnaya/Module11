package by.epam.tr.controller.command.impl;

import java.util.List;

import by.epam.tr.bean.Item;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.StoreService;
import by.epam.tr.service.exception.ServiceException;
import by.epam.tr.service.factory.ServiceFactory;

public class FindItemByString  implements Command {
	@Override
	public String execute(String request) {
		String response = null;
		List<Item> resultSet;
		
		ServiceFactory serviceFactory = ServiceFactory.getIstance();
		StoreService storeService = serviceFactory.getStoreService();
		try {
			resultSet = storeService.findItem(request);
			for (Item item : resultSet){
				response += item.toString();
			}
			
		} catch(ServiceException e) {
			System.out.println(e.getMessage());
			response = "Error while finding an element";
		}	
		return response;
	}
}

