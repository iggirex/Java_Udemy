package java_basics;

public class MyUtils {
	public static String printSomeJunk(String argument) { // first line is called method signature
		return("bla bla bla " + argument);
	}
	
	public static void printSomeJunk(int argument) {  // public is "access modifier"
		System.out.println("bla bla bla " + argument);
	}
	
	public static void sum2Numbers(int firstArg, int secondArg) { // void doesn't return anything
		System.out.println(firstArg + secondArg);
	}
	
	public static int add10(int someArgument) {  // int is the return type
		int result = someArgument + 10;
		return result;
	}
}
