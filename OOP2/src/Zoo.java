
public class Zoo {
	
	public static void main(String[] args) {
		
//		Animal bill = new Animal("Bill", 12, "heeeeeyyeee", true);
//		Animal ted = new Animal("Ted", 5, "eeeyyhhaaww", true);
//		Animal jen = new Animal("Jen", 7, "chirp chirp", true);
		
//		bill.walk();
//		jen.makeSound();
		
		Bird bird1 = new Bird("booey", 4, "woot woot", true);
		
//		bird1.fly();
		bird1.walk();
		
		Chicken chick1 = new Chicken("Chicaboo", 1, "tweet tweet", true);
		
//		chick1.fly();
		
		Sparrow bird2 = new Sparrow("Swoosh", 4, "KAAWWW", true);
		
		bird2.fly();
		
		Animal sparrow1 = new Sparrow("MeG", 1, "KAAWW", true);
		
		sparrow1.walk();
		
		Flyable flyingBird = new Sparrow("moo", 4, "4", true);
		flyingBird.fly();
	}
}
