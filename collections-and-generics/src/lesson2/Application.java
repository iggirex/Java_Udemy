package lesson2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<String>();

		animals.add("Lion");
		animals.add("cat");
		animals.add("Dog");

//		for(int i = 0; i < animals.size(); i++ ) {
//			System.out.println(animals.get(i));;
//		}
//		
//		for(String animal : animals) {
//			System.out.println(animal);
//		}
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle vehicle2 = new Vehicle("Toyota", "Camry", 1200, false);
		
		vehicles.add(new Vehicle("Honda", "accord", 1200, false));
		vehicles.add(vehicle2);
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
//		for(Vehicle vehicle : vehicles) {
//			System.out.println(vehicle);
//		}
		
		printElements(vehicles);
		printElements(animals);
		
	}
	
	public static void printElements(List somelist) { // reference super type 'list' to add LinkedLists and ArrayLists
		for(int i = 0; i < somelist.size(); i++) {
			System.out.println(somelist.get(i));
		}
	}

}
