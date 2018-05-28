package genericsbasics2;

//public class Container {  ==> How make this class generic ?? --> add angle brackets
public class Container<i1, i2> {

	
	
//	String item1;
//	String item2;
	
//	Object item1; --> not generic yet
//	Object item2;
	
	i1 item1; // 
	i2 item2;
	
	public Container(i1 item1, i2 item2) {
		super();
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public void printItems() {
		System.out.println("Printing Contents of container: ");
		System.out.println("Item 1: " + item1);
		System.out.println("Item 1: " + item2);
	}
	
	public i1 getItem1() {
		return item1;
	}

	public void setItem1(i1 item1) {
		this.item1 = item1;
	}

	public i2 getItem2() {
		return item2;
	}

	public void setItem2(i2 item2) {
		this.item2 = item2;
	}
}

