package lesson3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Application {

	public static void main(String[] args) {

	LinkedHashSet<Integer> values = new LinkedHashSet<Integer>();
	values.add(3);
	values.add(30);
	values.add(89);
	values.add(3);
	values.add(30);
	values.add(57);
	values.add(45);
	
	for(int value : values) {
		System.out.println(value);
	}
	
	HashSet<Animal> animals = new HashSet<Animal>();
	
	Animal animal1 = new Animal("Dog", 12);
	Animal animal2 = new Animal("Cat", 4);
	Animal animal3 = new Animal("Ferret", 1);
	Animal animal4 = new Animal("Dog", 12);
	Animal animal5 = new Animal("Kitters", 100);
	
	animals.add(animal1);
	animals.add(animal2);
	animals.add(animal3);
	animals.add(animal4);
	animals.add(animal5);
	
	for(Animal value : animals) {
		System.out.println(value);
	}
	

	}

}
