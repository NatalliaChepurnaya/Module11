package by.epam.tr.dao;

import java.util.List;

import by.epam.tr.bean.Item;
import by.epam.tr.bean.SearchCondition;
import by.epam.tr.dao.exception.DAOException;

public interface ItemDAO {
	void addItem(Item item) throws DAOException;
	List<Item> findItem(List<SearchCondition> list) throws DAOException;
	List<Item> findItem(String searchStr) throws DAOException;

}
