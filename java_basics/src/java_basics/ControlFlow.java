package java_basics;

public class ControlFlow {

	public static void main(String[] args) {
		
		boolean hungry = true;
		
		if(hungry) {
			System.out.println("I'm starving");
		} else {
			System.out.println("I'm not hungry");
		}
		
		
		// Swich case statements better to read than ifs
		int month = 4;
		String monthString;
		
		switch(month) {
		
			case 1: monthString = "Jan";
				break;
			case 2: monthString = "Feb";
				break;
			case 3: monthString = "March";
				break;
			case 4: monthString = "April";
				break;
			default: monthString = "Unknown Month";
				break;
		}
		
		
		System.out.println(monthString);

	}

}
