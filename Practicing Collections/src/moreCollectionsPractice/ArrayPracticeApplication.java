package moreCollectionsPractice;

import java.util.Arrays;

public class ArrayPracticeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] myNewArr = ArrayUtil.makeStringArray("hey", "may", "array");
		System.out.println(Arrays.toString(myNewArr));
		
		
		PureArrayFromObj myObj = new PureArrayFromObj();
		
		String[] madeFromObj = myObj.makeStringArray("dis", "array", "from obj");
		
		System.out.println(Arrays.toString(madeFromObj));
		

	}

}
