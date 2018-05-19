
public abstract class Animal {
	
	// abstract class can have abstract methods
	// move method will have to be defined by instance
	// ABSTRACT CLASSES SHOULD BE PARENTS --> no instances
	
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
		System.out.println(name + " is walking...");
	}
	
	public abstract void move();
}
