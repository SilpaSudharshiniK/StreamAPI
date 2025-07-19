package com.learn.methods.functional;
@FunctionalInterface
interface A{
	void show();
	//void display(); we cannot have more than one method in functional interface
	String toString(); // will not give error because every class in Java extends "Object" class
}

//class B extends Object implements A{
//
//	public void show() {
//		System.out.println("hii");
//	}
//	
//}


public class FunctionalInterfaceJ {

	public static void main(String[] args) {
		
		 //here to create object of interface we have created  B to implement it and created object of A
		
		//creating the object of 'A' there it self instead of implementing it
		
         A obj = new A() {
        	 public void show()
        	 {
        			System.out.println("hii");
        	 }
         };
         
        obj.show();
	}

}


//anonymous class:
//here Class B is created just to create object of A.


