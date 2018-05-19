
public class Animal {
	
	String name;
	int age;
	String sound;
	boolean fuzzy;
	
	public Animal(String name, int age, String sound, boolean fuzzy) {
		this.age = age;
		this.name = name;
		this.sound = sound;
		this.fuzzy = fuzzy;
	}
	
	public void makeSound() {
		System.out.println(sound);
	}
	
	public void walk() {
		System.out.println("Walking...");
	}
}
