package lesson4;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(12);
		list1.add(43);
		list1.add(15);
		list1.add(37);
		list1.add(6734);
		list1.add(5);
		list1.add(10);
		list1.add(10);
		list1.add(10);
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		
		newList.add(10);
		newList.add(15);
//		newList.add(37);
		
		list1.addAll(newList);
//		list1.removeAll(newList);
		
//		list1.clear();
		boolean hasValue = list1.contains(37);
//		boolean hasValue2 = list1.isEmpty();
		
		list1.retainAll(newList);
		
		System.out.println(list1);

	}

}
