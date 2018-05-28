package moreCollectionsPractice;

import java.util.ArrayList;

public class ArrayListUtil {
	
	public static ArrayList<Integer> makeNumberArrayList(int val1, int val2, int val3, int val4){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		result.add(val1);
		result.add(val2);
		result.add(val3);
		result.add(val4);
		
		return result;
	}
	
	public static <E> ArrayList<E> makeGenericArrayList(E val1, E val2, E val3){
		
		ArrayList<E> result = new ArrayList<>();
		
//		result[0] = "something";   --> NOT ALLOWED IN ARRAYLIST
		
		PureArrayFromObj anObj = new PureArrayFromObj();
		
		result.add((E) anObj);  // can accept object but type cast to <E>
		
		result.add((E) "hello there");  // can accept primitive but type cast to <E>
		result.add(val1);
		result.add(val2);
		result.add(val3);
		
		return result;
	}
	


}
