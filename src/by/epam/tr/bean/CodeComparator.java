package by.epam.tr.bean;

import java.util.Comparator;

public class CodeComparator implements Comparator<Item> {
	public int compare(Item it1, Item it2) {
		String code1 = it1.getManufacturerCode();
		String code2 = it2.getManufacturerCode();
		return code1.compareTo(code2);
	}


}
