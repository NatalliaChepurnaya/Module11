package by.epam.tr.service;

import java.util.List;

import by.epam.tr.bean.Item;
import by.epam.tr.bean.SearchCategory;
import by.epam.tr.bean.SearchCondition;
import by.epam.tr.service.exception.ServiceException;

public interface StoreService {
	void addItem(Item item) throws ServiceException;
	List<Item> findItem(List<SearchCondition> list) throws ServiceException;
	List<Item> findItem(String serachStr) throws ServiceException;
	void sortResult(List<Item> result,SearchCategory cat) throws ServiceException;

}
