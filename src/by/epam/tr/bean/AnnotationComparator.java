package by.epam.tr.bean;

import java.util.Comparator;

public class AnnotationComparator implements Comparator<Item> {
	public int compare(Item it1, Item it2) {
		String annot1 = it1.getAnnotation();
		String annot2 = it2.getAnnotation();
		return annot1.compareTo(annot2);
	}

}
