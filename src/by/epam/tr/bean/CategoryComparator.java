package by.epam.tr.bean;

import java.util.Comparator;

public class CategoryComparator  implements Comparator<Item> {
	public int compare(Item it1, Item it2) {
		String cat1 = it1.getCategory();
		String cat2 = it2.getCategory();
		return cat1.compareTo(cat2);
	}

}
