package practice_loops;

public class LoopsPractice {

	public static void main(String[] args) {
		
		int count = 0;
		
//		while(count <= 100) {
//			System.out.println((count + " igs").toString());
//			
//			count++;
//			
//			if( count == 30) {
//				break;
//			}
//		}
		
		
		String str = "We have a large inventory fo things in our warehouse falling in"
				+ "the category:apperal and the slightly "
				+ "more in demand category:makeup along with the category:furniture and ...";
		
		printCategories(str);

	}
	// extract all categories from string argument
	
	public static void printCategories(String str) {
		
		int count = 0;
		String categories = "";
				
		while(count != str.length()) {
			String restOfString = str.substring(count);
						
			int count2 = 0;
			
			if(restOfString.charAt(count2) == ':') {
				
				count2 = 1;
							
				while(restOfString.charAt(count2) != ' ') {

					categories += restOfString.substring(count2, (count2 + 1));
					
					count2++;
				
				}
				categories += " ";
			}	
			count++;
		}
		System.out.println("AAAAANNNdd these are the categories: " + categories);
		
		
		
		String name = "aejkfdslfkasfdslak";
		
		for(int i = name.length() - 1; i >= 0; i--) {
//			System.out.println("char: "+ name.charAt(i));
		}
		
		for(int i = 0; i <= 100; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		
	}

}
