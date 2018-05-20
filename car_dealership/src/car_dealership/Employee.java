package car_dealership;

public class Employee {
	
	String name;
	Customer cust;
	double diffVehiclePriceCashOnHand;
	
	public void handleCustomer(Customer cust, boolean finance, Vehicle vehicle) {
		
		if(finance == true) {
			diffVehiclePriceCashOnHand = vehicle.getPrice() - cust.getCashOnHand();
			 cust.runCreditHistory(cust, diffVehiclePriceCashOnHand, vehicle);   //in Customer
		 } else if(vehicle.getPrice() <= cust.getCashOnHand()) {
			 processTransaction(cust, vehicle);
		 } else {
			 System.out.println("");
			 System.out.println("*" + cust.getName() + " needs more money");
			 System.out.println("");
		 }
		 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void runCreditHistory() {
		
	}
	public void processTransaction(Customer cust, Vehicle car) {
		System.out.println("---------------------------------------");
		System.out.println("PURCHASE: ");
		System.out.println("customer: " + cust.getName() + " purchased car: " + car.getMake() + " " + car.getModel());
		System.out.println("---------------------------------------");
	}
}
