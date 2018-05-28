package moreCollectionsPractice;

import java.util.HashSet;

public class HashSetUtil {
	
	public static HashSet<Integer> makeHashSet(int val) {
		
		HashSet<Integer> result = new HashSet<Integer>();
		
		result.add(val);
		result.add(5);
		result.add(39);

		result.add(3);
		result.add(39);
		
		return result;
	}

}
