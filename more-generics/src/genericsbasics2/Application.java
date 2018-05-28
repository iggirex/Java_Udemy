package genericsbasics2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		Container<Integer, String> container = new Container<>(12, "Hello");  // Everything is an object in Java
		
//		String myStr = container.getItem1(); -- Can't pull String out of Generic Collection like this
//		String myStr = (String) container.getItem1();  // Can cast String type to do this
		
		int val1 = container.getItem1();
		String val2 = container.getItem2();
		
		Set<String> mySet1 = new HashSet<String>();
		mySet1.add("first");
		mySet1.add("second");
		mySet1.add("whatever");
		
		Set<String> mySet2 = new HashSet<String>();
		mySet2.add("first");
		mySet2.add("first");
		mySet2.add("Computer");
		
		Set resultSet = union(mySet1, mySet2);
		
		Iterator itr = resultSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
	public static <E> Set<E> union(Set<E> set1, Set<E> set2) { // generic method <E>
		Set<E> result = new HashSet<>(set1);
		result.addAll(set2);
		return result;
	}

}
