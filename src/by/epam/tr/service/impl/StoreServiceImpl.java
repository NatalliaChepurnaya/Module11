package by.epam.tr.service.impl;

//import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import by.epam.tr.bean.AnnotationComparator;
import by.epam.tr.bean.CategoryComparator;
import by.epam.tr.bean.CodeComparator;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.NameComparator;
import by.epam.tr.bean.SearchCategory;
import by.epam.tr.bean.SearchCondition;
import by.epam.tr.dao.DAOFactory;
import by.epam.tr.dao.ItemDAO;
import by.epam.tr.dao.exception.DAOException;
//import by.epam.tr.dao.impl.FileItemDAO;
import by.epam.tr.service.StoreService;
import by.epam.tr.service.exception.ServiceException;

public class StoreServiceImpl implements StoreService{
	
	@Override
	public void addItem(Item item) throws ServiceException {		
		//Check params
		if (item == null) {
			throw new ServiceException("Empty params");
		} else {
			try {
				DAOFactory daoObjectFactory = DAOFactory.getInstance();
				ItemDAO itemDAO = daoObjectFactory.getItemDAO();
				itemDAO.addItem(item);
				
			} catch (DAOException e) {
				System.out.println(e.getMessage());
				throw new ServiceException(e.getMessage());
			}
		}
	};
	@Override
	public List<Item> findItem(List<SearchCondition> list) throws ServiceException {
		//Check params
		if (list == null) {
			throw new ServiceException("Empty params");
		} else {
			try {
				DAOFactory daoObjectFactory = DAOFactory.getInstance();
				ItemDAO itemDAO = daoObjectFactory.getItemDAO();
				return itemDAO.findItem(list);
		
			} catch (DAOException e) {
				System.out.println(e.getMessage());
				throw new ServiceException(e.getMessage());
			}
		}
	};
	@Override
	public List<Item> findItem(String searchStr) throws ServiceException {
		//Check params
		if (searchStr == null) {
			throw new ServiceException("Empty params");
		} else {
			try {
				DAOFactory daoObjectFactory = DAOFactory.getInstance();
				ItemDAO itemDAO = daoObjectFactory.getItemDAO();
				return itemDAO.findItem(searchStr);
			} catch (DAOException e) {
				System.out.println(e.getMessage());
				throw new ServiceException(e.getMessage());
			}	
		}
	}; 
	@Override
	public void sortResult(List<Item> list,SearchCategory cat) throws ServiceException {
		if (list == null || cat == null || cat == SearchCategory.ISSUE_DATE) {
			throw new ServiceException("Not valid params");
		} else {
			Comparator<Item> compar;
			switch(cat){
			case NAME:
				compar = new NameComparator();
			case CATEGORY:
				compar = new CategoryComparator();
			case CODE:
				compar = new CodeComparator();
			case ANNOTATION:
				compar = new AnnotationComparator();
			default:
				compar = new NameComparator();
			}
			list.sort(compar);		
		}
	};

}
