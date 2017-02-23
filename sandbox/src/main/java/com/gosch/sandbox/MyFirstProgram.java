package com.gosch.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");

		Square square = new Square(5);
      System.out.println("Area of square with side " + square.side + " = " + square.area());

      Rectangle rectangle = new Rectangle(5, 7);
      System.out.println("Area of rectangle with sides " + rectangle.a + " and " + rectangle.b + " = " + rectangle.area());

      Point a = new Point(1,2);
      Point b = new Point(2,3);

      System.out.println("Distance between two points: " + a.distance(b));
   }

   //Function
   public static void hello(String somebody) {
      System.out.println("Hello, " + somebody + "!");
   }
	
}