
public class Zoo {
	
	public static void main(String[] args) {
		
		Animal bill = new Animal("Bill", 12, "heeeeeyyeee", true);
		Animal ted = new Animal("Ted", 5, "eeeyyhhaaww", true);
		Animal jen = new Animal("Jen", 7, "chirp chirp", true);
		
		bill.walk();
		jen.makeSound();
	}
}
