package by.epam.tr.bean;

import java.util.Comparator;

public class NameComparator implements Comparator<Item> {
	public int compare(Item it1, Item it2) {
		String name1 = it1.getName();
		String name2 = it2.getName();
		return name1.compareTo(name2);
	}

}
