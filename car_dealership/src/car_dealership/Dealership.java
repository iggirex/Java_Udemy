package car_dealership;

import java.util.Arrays;
import java.util.Random;

public class Dealership {

	public static void main(String[] args) {
		Customer[] todaysCustomers = generateDaysCustomers();
		Vehicle[] inventory = generateInventory();
		Employee[] employees = generateEmployees();
		
		System.out.println("AMOUNT OF CUSTOMERS TODAY: " + Integer.toString(todaysCustomers.length));
		
		for(int i=0; i < todaysCustomers.length; i++) {
			int chooseEmployee = rand.nextInt(15);
			int chooseVehicle = rand.nextInt(numberOfVehicles);
			int financeChance = rand.nextInt(10) + 1;
			
			//System.out.println(Arrays.toString(employees));
			
			Employee emp = employees[chooseEmployee];
			Vehicle vehicle = inventory[chooseVehicle];
			boolean finance;
			if(financeChance > 3) {
				finance = true;
			} else { 
				finance = false; 
			}
			
			emp.handleCustomer(todaysCustomers[i], finance, vehicle);
		}
	}
	
	static Random rand = new Random();
	
	static String[] namePool = {"Bruno Copeland","Mira Marsh","Camden Hester","Sean Alvarado","Madison Thomas","Forrest Cash","Liberty Johns",
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
	
	static String[] addressPool = {"P.O. Box 150, 3520 Morbi Rd.","492-7572 Felis, Rd.","4755 Pede Ave","P.O. Box 861, 7385 Augue. Road","4942 Imperdiet Avenue","3935 Parturient Rd.",
			"P.O. Box 147, 762 Pede. Avenue","102-281 Amet, Rd.","8566 Pretium St.","543-9267 Dictum Street","P.O. Box 765, 7871 Euismod Avenue","486-6769 Vel Road",
			"860-1267 Pellentesque Ave","P.O. Box 647, 5067 Orci Rd.","725-5287 Cum Avenue","8727 Consequat St.","Ap #202-9349 Donec St.","Ap #865-2922 Mattis St.",
			"P.O. Box 692, 9776 Magna. Avenue","Ap #250-766 Eget Rd.","3016 Et St.","686-9844 Integer St.","P.O. Box 524, 5623 Scelerisque St.","522-8138 Eu Avenue",
			"Ap #902-5748 Ullamcorper St.","3328 Sem. St.","P.O. Box 193, 273 Donec Rd.","9264 Suscipit, Street","P.O. Box 408, 9988 Praesent Avenue","P.O. Box 678, 8813 Pharetra, Ave",
			"P.O. Box 971, 1748 A St.","P.O. Box 706, 4406 Lectus, Rd.","9815 Nec Av.","P.O. Box 871, 6528 Scelerisque Road","Ap #794-1017 Pede. St.","828-4794 Ultricies Road",
			"Ap #683-1579 Adipiscing, Rd.","Ap #702-9238 Amet, Rd.","Ap #952-2937 Turpis St.","Ap #487-7457 Eu St.","210-7433 Quis, Rd.","P.O. Box 763, 598 Sagittis Street",
			"1335 Faucibus St.","954-8210 Est, Av.","P.O. Box 257, 5489 Sagittis St.","281-8087 Ante Road","844-7210 Egestas Rd.","P.O. Box 357, 4004 Enim. Ave","740-4034 Sociosqu Avenue",
			"1268 Cras Ave","5283 Est St.","6544 Nullam Rd.","Ap #902-2862 Sed St.","Ap #880-5611 Semper Ave","7902 Non St.","Ap #825-7336 Velit Road","840-4584 Eget St.","2357 Rhoncus. Road",
			"P.O. Box 541, 6494 Suspendisse Ave","P.O. Box 757, 1452 Vitae, St.","Ap #458-4341 Faucibus. St.","4658 Eget, Road","590-7617 Ipsum Street","P.O. Box 814, 8809 Venenatis Street",
			"368 Turpis Ave","115 Dapibus Av.","3439 Sed Rd.","Ap #945-6104 Penatibus St.","P.O. Box 334, 9299 Libero Rd.","Ap #574-2681 Risus Av.","Ap #174-1430 Ultricies Ave",
			"893-3420 Et Rd.","7921 Ac St.","8618 Vitae Street","P.O. Box 210, 8333 Eget St.","Ap #408-1515 At Road","P.O. Box 239, 3589 Ullamcorper, Rd.","Ap #796-4278 Vivamus Rd.",
			"428-1323 Mus. Av.","Ap #621-5042 Dui. Avenue","P.O. Box 226, 1941 Magna. St.","Ap #531-6920 Sit Rd.","Ap #723-7464 Velit Avenue","Ap #425-1275 Integer St.","1864 Ut Rd.",
			"P.O. Box 550, 7486 Maecenas Avenue","Ap #575-1869 Congue Rd.","P.O. Box 557, 2043 Porttitor St.","Ap #209-3340 Elit, Avenue","P.O. Box 834, 2848 Nulla Street","901-3339 Erat. St.",
			"P.O. Box 425, 5685 Lacinia Road","448-8683 Sit Road","458-6352 In St.","Ap #486-573 Eget St.","Ap #523-7245 Suscipit St.","7911 Ligula Rd.","946-4408 Facilisis Avenue",
			"P.O. Box 974, 9045 At St.","Ap #894-405 Sem Av."};
	
	static int numberOfCustomersToday = rand.nextInt(25);
	static int numberOfVehicles = rand.nextInt(50);
	
	private static void generateDailyReport() {
		

	}
	
	public static Customer[] generateDaysCustomers() {
		Customer[] customersToday = new Customer[numberOfCustomersToday];
		
		for( int i = 0; i < numberOfCustomersToday; i++) {
			int pickCustomer = rand.nextInt(100);			
			customersToday[i] = new Customer();
			customersToday[i].setName(namePool[pickCustomer]);
			customersToday[i].setAddress(addressPool[pickCustomer]);
			customersToday[i].setCashOnHand(rand.nextInt(20_000) + 1);
		}
		return customersToday;
	}
	
	public static Vehicle[] generateInventory() {
		String[] make = {"Toyota", "Ford", "Hyundai", "Tesla", "BMW", "Honda", "Chevy", "Lamobourghini", "Maserati", "Jeep", "Mercedes"};
		String[] model = {"Conshita", "Beater", "FlyBoat", "SX", "Barretta", "Eclipse", "Tundra", "Sprinter Van", "Sports Devil", "SedanX", "SUV-Y"};
		Vehicle[] inventory = new Vehicle[numberOfVehicles];

		for( int i = 0; i < numberOfVehicles; i++) {
			int randomMake = rand.nextInt(11);
			int randomModel = rand.nextInt(11);
			
			inventory[i] = new Vehicle();
			inventory[i].setMake(make[randomMake]);
			inventory[i].setModel(model[randomModel]);
			inventory[i].setPrice(rand.nextInt(50_000) + 1);
		}
		return inventory;
	}
	
	public static Employee[] generateEmployees() {
		Employee[] employees = new Employee[15];
		int randomEmployeeName = rand.nextInt(15) + 1;
		
		for(int i=0; i < 15; i++) {
			Employee thisEmployee = new Employee();
			thisEmployee.setName(namePool[randomEmployeeName]);
			employees[i] = thisEmployee;
		}
		return employees;
	}
}
