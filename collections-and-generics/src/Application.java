import java.util.ArrayList;
import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
		
		// Old way of doing Arrays (before Java 5)
//		ArrayList words = new ArrayList();
//		words.add("hello");
//		words.add("there");
//		words.remove(0);
//		words.add(10);
//		words.add(12.00);
//		words.add("H");
//		
//		int item = (int) words.get(2);
//		int item2 = (int) words.get(3);
//		
//		System.out.println(item + item2);
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("there");
		words.add("10");
		
		String item = words.get(2);
//		int item2 = (int) words.get(3);
		
		System.out.println(item);
		
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(4);
		numbers.add(40);
		numbers.add(444);
		numbers.add(4);
		
		for(int number: numbers) {
			System.out.println(number);
		}
		
	}

}
