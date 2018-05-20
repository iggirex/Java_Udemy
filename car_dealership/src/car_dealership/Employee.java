package car_dealership;

public class Employee {
	
	String name;
	Customer cust;
	double diffVehiclePriceCashOnHand;
	
	public void handleCustomer(Customer cust, boolean finance, Vehicle vehicle) {
		
		if(finance == true) {
			 cust.runCreditHistory(cust, diffVehiclePriceCashOnHand);   //in Customer
		 } else if(vehicle.getPrice() <= cust.getCashOnHand()) {
			 processTransaction(cust, vehicle);
		 } else {
			 System.out.println("Customer needs more money");
		 }
		 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void runCreditHistory() {
		
	}
	public void processTransaction(Customer cust, Vehicle car) {
		
	}
}
