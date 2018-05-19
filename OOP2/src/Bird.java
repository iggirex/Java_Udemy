
public class Bird extends Animal {
	
	public Bird(String name, int age, String sound, boolean fuzzy) {
		super(name, age, sound, fuzzy);
	}
	
	public void move() {
		System.out.println(name + " is flappin' wings!");
	}

}
