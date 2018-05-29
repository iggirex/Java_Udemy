package genericsbasics3;

public class Accountant extends Employee{
//public class Accountant implements Employee{
	
	@Override                  // this will override parent method
	public void work() {
		System.out.println("Accountant working");
	}
	
	public void account() {
		System.out.println("Accounting");
	}


}
