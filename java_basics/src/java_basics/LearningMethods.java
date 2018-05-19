package java_basics;

import someotherpackage.ExampleClass;

public class LearningMethods {

	public static void main(String[] args) {
		
//		System.out.println("jfkjsdal");
		String mystring = MyUtils.printSomeJunk("This is stringer");
//		MyUtils.sum2Numbers(10, 23);
		int myvar = MyUtils.add10(99);
		MyUtils.add10(90);
		
		System.out.println(myvar);
		System.out.println(mystring);
		
		ExampleClass.doSomething();
	}
}
