package com.iggi.learningfilereader;

class MyClass implements AutoCloseable{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("closing");
	}
	
}

public class Application2 {

	public static void main(String[] args) {
		try(MyClass var = new MyClass();){
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
