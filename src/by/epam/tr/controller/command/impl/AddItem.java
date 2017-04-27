package by.epam.tr.controller.command.impl;

import by.epam.tr.bean.Item;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.StoreService;
import by.epam.tr.service.exception.ServiceException;
import by.epam.tr.service.factory.ServiceFactory;

public class AddItem implements Command {
	@Override
	public String execute(String request) {
		String response = null;
		//Request delimeter
		String delimeter = ";";
		
		//Item params
		String[] itemArr = new String[5];
		itemArr = request.split(delimeter);
		Item newItem = new Item(itemArr);
		
		ServiceFactory serviceFactory = ServiceFactory.getIstance();
		StoreService storeService = serviceFactory.getStoreService();
		try {
			storeService.addItem(newItem);
			response = "New item was added successfully";
		} catch(ServiceException e) {
			System.out.println(e.getMessage());
			response = "Error during adding new element";
		}	
		return response;
	}

}
