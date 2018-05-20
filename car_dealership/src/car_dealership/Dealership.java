package car_dealership;

import java.util.Arrays;
import java.util.Random;

public class Dealership {

	public static void main(String[] args) {
		// write a program to simulate car dealership -- employees, vehicles, customers
		
//		Customer cust1 = new Customer("Tom", "123 Anything St.", 12000);
		
		Customer cust1 = new Customer();

		cust1.setName("Tom");
		cust1.setAddress("123 Anything St.");
		cust1.setCashOnHand(12000);
		
		
		// This is for public vars in a class
//		cust1.name = "Tom";
//		cust1.address = "123 Anything St.";
//		cust1.cashOnHand = 12000;
		
		System.out.println(cust1);
		
//		cust1.purchaseCar(vehicle, emp, false);
		
		generateDaysCustomers();
		

	}
	
	static Random rand = new Random();
	

	
	public void generateDailyReport() {
		
		int totalCarsSold;
		int totalInteractions = rand.nextInt(20) + 1;
		
		/**
		 * 1) generate rando customers
		 * 2) create pool of employees
		 * 3) make promotion
		 * 4) make interaction customer employee
		 * 5) decision making process customer
		 * 6) purchase car method
		 * 7) make random amount of interactions for day
		 */
		
		String[] todaysCustomers = generateDaysCustomers();
		
		
		
		
		System.out.println("daily report");
	}
	
	public static String[] generateDaysCustomers() {
		String[] customerNamePool = {"Bruno Copeland","Mira Marsh","Camden Hester","Sean Alvarado","Madison Thomas","Forrest Cash","Liberty Johns",
		                "Molly Blackburn","Ramona Pollard","Rina Rowland","Martena Reid","Beverly Cooper","Reese Bonner","Hilel Roberts","Nell Munoz",
		                "Aimee Barton","Hilary Jacobson","Akeem Blackwell","Dean Pace","Palmer Patel","Miriam Grimes",
		                "Chancellor Branch","Rowan Bullock","Aphrodite Miranda","Oliver Knox","Dawn Santiago","Holmes Avila","Gavin Shannon",
		                "Macey Hahn","Carol Townsend","Aurora Pennington","Erasmus Rodgers","Vladimir Santos","Upton Richard","Kim Nolan",
		                "Frances William","Willow Kim","Connor Phelps","James Bolton","Lionel Shaffer","Lydia Holloway","Basil Schultz",
		                "Ebony Lancaster","Dylan Huffman","Gloria Hodge","Naomi Townsend","Karyn Bradshaw","Madaline Guerrero","Ursa Richmond",
		                "Stone Cherry","Theodore Oneill","Christian Beach","Macaulay Dawson","Elvis Walter","Kirestin Brewer","Shad Howe","Dana Strickland",
		                "Anthony Baldwin","Logan Black","Olga Blackwell","Kareem Clark","Galvin Farrell","Mia Hernandez","Bert Davidson","Briar Goff",
		                "Carter Mullen","Teegan Boyle","Shay Conrad","Ingrid Guerra","Xaviera Beasley","Jayme Gould","Phillip Cantu","Luke Daniel",
		                "Armando Sargent","Wylie Booker","Barry Leonard","Neve Black","Maxwell Rich","Vance Sweet","Hillary Salas","Blythe Parker",
		                "Odysseus Decker","Hamilton Love","Jade Shelton","Elijah Sargent","Renee Ferrell","Maia Booth","Russell Puckett","Craig Spencer",
		                "Elmo Thomas","Dane Lang","Abra Austin","Rhona Johnson","Linus Valdez","Shoshana Moses","Abbot Love","Jarrod Sutton","Carter Reed","Christian Knapp","Ifeoma Luna"};
		

		int numberOfCustomersToday = rand.nextInt(25) + 1;
		
		String[] customersToday = new String[numberOfCustomersToday];
		
		for( int i = 0; i < numberOfCustomersToday; i++) {
			int pickCustomer = rand.nextInt(100) + 1;
			System.out.println(pickCustomer);
			customersToday[i] = customerNamePool[pickCustomer];
		}
		System.out.println(Arrays.toString(customersToday));
		return customersToday;
	}
	
	public void generateEmployeePool() {
		
	}
	
	public void interaction(Employee emp, Customer cust, Vehicle car) {
		
	}
	
	

}
