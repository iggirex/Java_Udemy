package lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		HashSet<Integer> hashSet = new HashSet<Integer>();
//		
//		hashSet.add(12);
//		hashSet.add(43);
//		hashSet.add(15);
//		hashSet.add(37);
//		hashSet.add(6734);
//		hashSet.add(5);
//		hashSet.add(10);
//		hashSet.add(10);
//		hashSet.add(10);
		
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("hey");
		hashSet.add("tjere");
		hashSet.add("neighborino");
		hashSet.add("hows");
		hashSet.add("summer");
		hashSet.add("going?");
		
		ArrayList<String> myList = new ArrayList<String>(hashSet); // makes a copy of hashSet into a List
		
		//Collections.sort(myList); // .sort only accepts List
		
		System.out.println(myList);

	}

}
