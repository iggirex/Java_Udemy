package lesson6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {

	public static void main(String[] args) {
		// HashMap/dictionary => word points to definition - key points to value
		// identify data for key, and for value in HashMap definition as opposed to Lists
		// LinkedHashMap preserves order of inserted values
		
		
		
//		LinkedHashMap<String, String> dictionary = new LinkedHashMap<String, String>();
//		
//		dictionary.put("Brave", "ready to face danger or pain; showing courgage");
//		dictionary.put("SuchWow", "showing amazement in an internet kind of way");
//		dictionary.put("Brilliant", "Very intelligent");
//		
////		for(String word: dictionary.keySet()) {
////			System.out.println(word);
////		}
//		
//		for( Map.Entry<String, String> entry : dictionary.entrySet()) { // entry set will display both key and value
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//		}
		
		TreeMap<String, String> dictionary = new TreeMap<String, String>();
		
		dictionary.put("Brave", "ready to face danger or pain; showing courgage");
		dictionary.put("SuchWow", "showing amazement in an internet kind of way");
		dictionary.put("Brilliant", "Very intelligent");
		
//		for(String word: dictionary.keySet()) {
//			System.out.println(word);
//		}
		
		for( Map.Entry<String, String> entry : dictionary.entrySet()) { // entry set will display both key and value
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		
	}

}
