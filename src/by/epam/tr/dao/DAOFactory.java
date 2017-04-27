package by.epam.tr.dao;

import by.epam.tr.dao.impl.FileItemDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final ItemDAO fileItemDAO = new FileItemDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public ItemDAO getItemDAO(){
		return fileItemDAO;
	}

}
