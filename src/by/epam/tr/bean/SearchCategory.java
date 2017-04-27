package by.epam.tr.bean;

public enum SearchCategory {
	NAME(0), CATEGORY(1), CODE(2), ISSUE_DATE(3),ANNOTATION(4);
	
	private int index;
	
	SearchCategory(int index){
		this.index = index;
	}
	
	public int getIndex(){
		return index;
	}
}
