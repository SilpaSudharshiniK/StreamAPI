//lambda function is also called as Arrow function
package com.learn.methods.functional;

@FunctionalInterface
interface L{
	void show();
}
public class LambdaExp {

	public static void main(String[] args) {
		// lamda expression
        L obj = () -> {
        	System.out.println("interface L is implemented");
        };
        obj.show();
	}

}
