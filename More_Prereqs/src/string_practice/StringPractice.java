package string_practice;

public class StringPractice {
	
	public static void main(String[] args) {
		
		String a = "hello";
		String b = "there";
		
		String str = "ABCDEFG";
		
		System.out.println(a.length());
		
		System.out.println(str.substring(2, 5));
		
		if(a.equals("hello")) {
			//USE THING
		}
		
		if(a == "hello") {
			// THIS IS A TRAP!!! DONT DO THIS!!!
		}
		
		if(b.equalsIgnoreCase("There")) {
			System.out.println("Printed there");
		}
		
		System.out.println(a.charAt(1));
		
		String str2 = "Hello there yogi there";
		
		System.out.println(str2.indexOf("there", 0));
		
		int c = str2.lastIndexOf("there");
		
		System.out.println(c);
		
		
	}

}
