package by.epam.tr.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import by.epam.tr.controller.command.Controller;

public class View {
	@SuppressWarnings("resource")
	public static final String mainDelimeter = ";";
	public static final String optionalDelimeter = ":";
	
	public static final Map<Integer, String> findMap = new HashMap<>();
	View(){
		findMap.put(1, "NAME");
		findMap.put(2, "CATEGORY");
		findMap.put(3, "CODE");
		findMap.put(4, "ISSUE_DATE");
		findMap.put(5, "ANNOTATION");
	}
	public static void main(String[] args){
		View view = new View();
		Scanner sc = new Scanner(System.in);
		
		mainMenu(sc);
	}
	
	public static void mainMenu(Scanner sc){
		int option = 0;
		String request = null;
		String response = null;
		Controller controller = new Controller();
		while (option != 3) {
			System.out.println("Please select the action:\n1 - Add new item\n2 - Find items\n3 - Exit");
			try{
				option = sc.nextInt();
				if (option == 1) {					
					request = "ADD-";
					System.out.println("Please enter item name:");
					request += sc.next() + mainDelimeter;
					System.out.println("Please enter item category:");
					request += sc.next() + mainDelimeter;
					System.out.println("Please enter manufacturer code:");
					request += sc.next() + mainDelimeter;
					System.out.println("Please enter issue date:");
					request += sc.next() + mainDelimeter;
					System.out.println("Please enter annotation information:");
					request += sc.next() + mainDelimeter;				
				} else if(option == 2) {
					request = findMenu(sc);
				} else if (option == 3) {			
					System.out.println("The End");
					return;
				} else {
					System.out.println("Please enter valid option");
				}
				response = controller.executeTask(request);
				System.out.println(response);
			} catch (Exception e) {
				System.out.println("Please enter valid option");
				sc.next();
			}
		}
	}
	
	public static String findMenu(Scanner sc){
		String request = null;
		int findOption = 0;
		while(1 == 1){
			System.out.println("Find item by:\n1 - Parameters\n2 - String\n3 - Return to the main menu");
			try{
				findOption = sc.nextInt();
				if (findOption == 1) {
					request = findByParameters(sc);
					break;
				} else if (findOption == 2) {
					request = findByString(sc);
					break;
				} else if (findOption == 3) {
					break;
				} else {
					System.out.println("Please enter valid option");
				}
			} catch (Exception e) {
				System.out.println("Please enter valid option");
			}			
		}
		return request;
		
	}
	
	public static String findByParameters(Scanner sc){
		String request = "FIND_BY_PARAM-";
		int option;
		while(1 == 1){
			System.out.println("Choose parameter:\n1 - Name\n2 - Category\n3 - Manufacturer Code\n4 - Issue Date\n5 - Annotation\n6 - That's it");
			try {
				option = sc.nextInt();
				if (option == 6) {
					break;
				} else if (option > 6 || option < 1) {
					System.out.println("Please enter valid option");
				} else {
					request += findMap.get(option) + optionalDelimeter + sc.next() + mainDelimeter;
				}					
			} catch(Exception e) {
				System.out.println("Please enter valid option");
			}
		}
		return request;
	}
	
	public static String findByString(Scanner sc){
		String request = "FIND_BY_STRING-";
		System.out.println("Enter the search string:");
		request += sc.next();
		return request;
	}
}


