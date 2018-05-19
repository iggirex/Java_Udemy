
public class Fish extends Animal{
	
	public Fish(String name, int age, String sound, boolean fuzzy) {
		super(name, age, sound, fuzzy);
		// TODO Auto-generated constructor stub
	}

	public void swim() {
		System.out.println("Swimming...");
	}
	
	public void move() {
		System.out.println(name + " is swimming");
	}

}
