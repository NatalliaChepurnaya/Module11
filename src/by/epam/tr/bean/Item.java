package by.epam.tr.bean;

public class Item {
	private String name;
	private String category;
	private String manufacturerCode;
	private String issueDate;
	private String annotation;
	
	public Item(String[] arr){
		this.name = arr[0];
		this.category = arr[1];
		this.manufacturerCode = arr[2];
		this.issueDate = arr[3];
		this.annotation = arr[4];
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public String getManufacturerCode(){
		return this.manufacturerCode;
	}
	
	public String getIssueDate(){
		return this.issueDate;
	}
	
	public String getAnnotation(){
		return this.annotation;
	}
	
	public String toString(){
		return getName() + "\t" + getCategory() + "\t" + getManufacturerCode() + "\t" + getIssueDate() + "\t" + getAnnotation() + "\n";
	}
	 

}

