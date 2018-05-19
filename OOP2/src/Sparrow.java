
public class Sparrow extends Bird implements Flyable{

	public Sparrow(String name, int age, String sound, boolean fuzzy) {
		super(name, age, sound, fuzzy);
	}

	public void fly() {
		System.out.println(name + " is  flying high"); // using interface, interface is contract
		// class can only have one parent, but many contracts/interfaces
	}

}
