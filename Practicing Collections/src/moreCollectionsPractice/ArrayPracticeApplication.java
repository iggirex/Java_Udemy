package moreCollectionsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class ArrayPracticeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] myNewArr = ArrayUtil.makeStringArray("hey", "may", "array");
		System.out.println(Arrays.toString(myNewArr));
		
		
		PureArrayFromObj myObj = new PureArrayFromObj();
		String[] madeFromObj = myObj.makeStringArray("dis", "array", "from obj");
		System.out.println(Arrays.toString(madeFromObj));
		
		LinkedList myNewLL = LinkedListUtil.makeLLFromScratch(5);  // Will return all objects instead of actual data types BAD
		System.out.println(myNewLL);
		
		
		LinkedList<String> myGoodLL = LinkedListUtil.makeGoodLL("yo", "this is ll", "in the house");
		System.out.println(myGoodLL);
		
//		LinkedList<e1, e2> myGoodGenericLL = LinkedListUtil.makeGoodGenericLL("hey", 3);   ---Why does this not work ??
		
		HashSet<Integer> myHashSet = HashSetUtil.makeHashSet(49);
		
		System.out.println(myHashSet);
		
		
		ArrayList<Integer> myNumberArrayList = ArrayListUtil.makeNumberArrayList(3, 3, 44, 4);
		System.out.println("number array list: " +  myNumberArrayList);
		
		
		ArrayList<String> myGenericArrayList = ArrayListUtil.makeGenericArrayList("3", "3", "true");
		System.out.println("generic array list: " +  myGenericArrayList);
		
		
		
	}

}
