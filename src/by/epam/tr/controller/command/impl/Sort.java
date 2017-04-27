package by.epam.tr.controller.command.impl;

import java.util.List;

import by.epam.tr.bean.Item;
import by.epam.tr.bean.SearchCategory;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.StoreService;
import by.epam.tr.service.exception.ServiceException;
import by.epam.tr.service.factory.ServiceFactory;

public class Sort implements Command {
	private List<Item> result;
	
	public List<Item> getResult(){
		return result;
	}
	
	public void setResult(List<Item> result){
		this.result = result;
	}
	@Override
	public String execute(String request) {
		String response = null;
		SearchCategory category = null;
		try {
			category = SearchCategory.valueOf(request);
		} catch(IllegalArgumentException e) {
			response = "Unknown sort category";
		}
				
		ServiceFactory serviceFactory = ServiceFactory.getIstance();
		StoreService storeService = serviceFactory.getStoreService();
		try {
			storeService.sortResult(result,category);
			for (Item item : result){
				response += item.toString();
			}
		} catch(ServiceException e) {
			System.out.println(e.getMessage());
			response = "Error during sorting result set";
		}	
		return response;
	}

}

