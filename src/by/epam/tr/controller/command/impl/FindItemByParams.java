package by.epam.tr.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.tr.bean.Item;
import by.epam.tr.bean.SearchCategory;
import by.epam.tr.bean.SearchCondition;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.StoreService;
import by.epam.tr.service.exception.ServiceException;
import by.epam.tr.service.factory.ServiceFactory;

public class FindItemByParams implements Command {
	@Override
	public String execute(String request) {
		String response = null;
		List<Item> resultSet;
		//Request delimeters
		String delimeter1 = ";";
		String delimeter2 = ":";
		
		//Conditions list
		List<SearchCondition> list = new ArrayList<SearchCondition>();
		
		//Condition string
		String[] searchArr = request.split(delimeter1);
		String[] condArr = new String[2];
		SearchCategory searchCategory = null;
		String paramValue = null;
		SearchCondition searchCondition = null;
		try{			
			for (int i = 0; i < searchArr.length; i++) {
				condArr = searchArr[i].split(delimeter2);
				searchCategory = SearchCategory.valueOf(condArr[0]);
				paramValue = condArr[1];
				searchCondition = new SearchCondition(searchCategory,paramValue);
				list.add(searchCondition);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			response = "Search conditions contain mistake";
		}
		
		ServiceFactory serviceFactory = ServiceFactory.getIstance();
		StoreService storeService = serviceFactory.getStoreService();
		try {
			resultSet = storeService.findItem(list);
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
