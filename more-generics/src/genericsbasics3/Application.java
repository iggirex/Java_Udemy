package genericsbasics3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		// Polymorphism in GENERICS
	
		Object myObject = new Object();
		String myVar = "hello";
		myObject = myVar;  // -----> this is polymorphism  --> making an Object then assigning it a String
		
		
//		Employee emp = new Employee();   - Can no longer instantiate Employee because we changed it to interface
//		Accountant acc = new Accountant();
//		emp = acc;
//		acc = emp;   --> can't do this, accountant extends employee so an employee can be an accountant, but you can't make an accountant an employee
		
		ArrayList<Employee> employees = new ArrayList<>();
		ArrayList<Accountant> accountants = new ArrayList<>();
		
		//employees = accountants;   // A list of accountants is NOT a list of Employees !!! Can't do this on ArrayLists
		
		
		
		
		
		// WILD CARDS IN GENERICS
		
		ArrayList<?> employees2 = new ArrayList<>();
		ArrayList<Accountant> accountants2 = new ArrayList<>();
		employees2 = accountants2;
		
//		ArrayList<? extends Employee> employees3 = new ArrayList();
//		ArrayList<String> accountants3 = new ArrayList<String>();   // WILL NOT WORK because string is not a child of Employee
//		employees3 = accountants3;
		 
		// LOWER BOUND --> Can control type by only allowing children of Employee
		ArrayList<? extends Employee> employees3 = new ArrayList();  // UPPER BOUND -- means the highest type in hierarchy of objects is Employee, we can accept subclass of Employee into ArrayList
//		ArrayList<Object> accountants3 = new ArrayList<>();  // upper bound is EMPLOYEE, can't go higher to Object
		ArrayList<Accountant> accountants3 = new ArrayList<>();

		employees3 = accountants3;
		
		// UPPER BOUND --> must be parent of Employee
		ArrayList<? super Employee> employees4 = new ArrayList<>();  // SUPER means that the list WILL HAVE TO BE HIGHER THAN EMPLOYEE (LOWER BOUND SETTING)
//		ArrayList<Accountant> accountants4 = new ArrayList<Accountant>();  // can't use Accountant because Accountant is child of Employee
		ArrayList<Object> accountants4 = new ArrayList<>(); 

		employees4 = accountants4;
		
			
		
		
		
		ArrayList<Employee> employees5 = new ArrayList<>();
		ArrayList<Accountant> accountants5 = new ArrayList<>();
		
		employees5.add(new Employee());
		accountants5.add(new Accountant());

		makeEmployeeWork(accountants5);   // ARRAYS ARE NOT POLYMORPHIC WITH EACH OTHER, UNLESS WILDCARD IS USED!!!!
		
		}
	
	
	// DONT DO TYPECASTING!!!!!!!!!!!!!!     !!!!!!! !!! !  !  ! ! !      !!!!
	
//	public static void makeEmployeeWork(List<Employee> employees) {
	public static void makeEmployeeWork(List<? extends Employee> employees) {  // all we can see here is EMployee --> Can't use Accountant methods only

//		for(Employee emp : employees) {   // NORMAL WAY of doing this, making type Employee
//		for(Accountat emp : employees) {  --> NOT going to work! Means all children of Employee are allowed, BUT THE TYPE HERE IS EMPLOYEE
		for(Accountant emp : (ArrayList<Accountant>) employees) {  // DownCasting WILL WORK
			emp.work();
//			emp.account();   --> not going to work, declared as an employee, can only use Employee methods, that is ITS TYPE
		}

	}

}
