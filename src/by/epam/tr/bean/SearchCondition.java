package by.epam.tr.bean;

public class SearchCondition {
	private SearchCategory category;
	private String value;
	
	public SearchCondition(SearchCategory category,String value){
		this.category = category;
		this.value = value;		
	}
	
	public SearchCategory getCategory(){
		return category;
	}
	
	public String getValue(){
		return value;
	}

}
