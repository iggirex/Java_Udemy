package car_dealership;

public class Customer {
	
	private String name;
	private String address;
	private double cashOnHand;


	public void purchaseCar(Vehicle vehicle, Employee emp, boolean finance) {
		
	}
	
	public void runCreditHistory(Customer cust, double diffVehiclePriceCashOnHand, Vehicle car) {
		if(diffVehiclePriceCashOnHand < 10_000) {
			System.out.println("---------------------------------------");
			System.out.println("PURCHASE: ");
			System.out.println("customer: " + cust.getName() + " purchased car: " + car.getMake() + " " + car.getModel());
			System.out.println("---------------------------------------");
		} else {
			System.out.println("");
			System.out.println("*" + cust.getName() + " needs more money");
			System.out.println("");
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getCashOnHand() {
		return cashOnHand;
	}


	public void setCashOnHand(double cashOnHand) {
		this.cashOnHand = cashOnHand;
	}
			
}
