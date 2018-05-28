package genericsbasics;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		
		// WARNING ArrayList is a raw type ---- this means WARNING --> you can stick
		// any type you want in here, but it won't be the type that you added
		// it will be object type
//		ArrayList myList = new ArrayList();
		
		ArrayList <String> myList = new ArrayList();

		
		myList.add("hello");
//		myList.add(8); ==> Once we "parameterize the ArrayList, we can no longer add
//		myList.add(false); different types
		
		// String myVal = myList.get(0); // HEY! What do you mean STRING??
		String myVal = (String) myList.get(0); // We can type cast the value
		
		String myVal2 = (String) myList.get(1);
		
	}

}
