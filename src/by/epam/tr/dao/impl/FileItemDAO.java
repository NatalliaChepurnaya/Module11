package by.epam.tr.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import by.epam.tr.bean.Item;
//import by.epam.tr.bean.SearchCategory;
import by.epam.tr.bean.SearchCondition;
import by.epam.tr.dao.ItemDAO;
import by.epam.tr.dao.exception.DAOException;

public class FileItemDAO implements ItemDAO {
	private String filePath = "Example.txt";
	/*
	public static void main(String[] args){
		try{
			FileItemDAO dao = new FileItemDAO();
			SearchCondition cond = new SearchCondition(SearchCategory.CATEGORY,"Food");
			List<SearchCondition> list = new ArrayList<SearchCondition>();
			list.add(cond);
			//List<Item> result = dao.findItem(list);
			List<Item> result = dao.findItem("New");
			for(Item i : result){
				System.out.println(i);
			}
			String[] arr = {"Fish","Food","101","1/1/2017","Fresh Fish"};
			Item newItem = new Item(arr);
			dao.addItem(newItem);
			
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	*/
	@Override
	public void addItem(Item item) throws DAOException{
		try(Writer out = new BufferedWriter(new FileWriter(filePath, true))) {
			//new Item
			String str = item.toString();
			out.append(str);		
		} catch(IOException e){
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}
	
	
	@Override
	public List<Item> findItem(List<SearchCondition> list) throws DAOException{
		
		try(FileReader fr = new FileReader(filePath)) {
			BufferedReader br = new BufferedReader(fr);
			//Row from file
			String str;
			//Separated values from row
			String[] items;	
			//Result set
			List<Item> result = new ArrayList<Item>();
			//Flag that show if the item should be included into result set
			int flag;
			while ((br.ready()) == true) {
				flag = 1;
				str = br.readLine();
				items = str.split("	");			
				for(SearchCondition cond: list){
					if (cond.getValue().equals(items[cond.getCategory().getIndex()])){
							flag *= 1;
						} else {
							flag *= 0;
						}
				}				
				if (flag == 1){
					Item item = new Item(items);
					result.add(item);
				}				
			}
			return result;
			} catch(IOException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<Item> findItem(String searchStr) throws DAOException{
		
		try(FileReader fr = new FileReader(filePath)) {
			BufferedReader br = new BufferedReader(fr);
			//Row from file
			String str;
			//Separated values from row
			String[] items;
			//Result set
			List<Item> result = new ArrayList<Item>();
			//Flag that show if the item should be included into result set
			while ((br.ready()) == true) {
				str = br.readLine();
				if (str.indexOf(searchStr) > 0){
					items = str.split("	");
					Item item = new Item(items);
					result.add(item);
				}				
			}
			return result;
			} catch(IOException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
