package car_dealership;

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
		
		
		public static void generateDailyReport() {
			System.out.println("daily report");
		}
		

		


	}

}
