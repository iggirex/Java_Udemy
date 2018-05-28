package moreCollectionsPractice;

import java.util.LinkedList;

public class LinkedListUtil {
	
	public static LinkedList makeLinkedList(String str1, boolean isIt, int num) {
		
		LinkedList result = new LinkedList();
//		
//		result[1] = str1;
//		boolean result[2] = isIt;
		
//		result.linkFirst("hey");
		
		result.add(1);
		result.add("2");
		result.add(true);
		result.add(2.2);
		result.add(new LinkedList());
		
		return result;
		
	}

}
