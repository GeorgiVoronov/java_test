package com.gosch.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");

		Square square = new Square(5);
      System.out.println("Area of square with side " + square.side + " = " + square.area());

      Rectangle rectangle = new Rectangle(5, 7);
      System.out.println("Area of rectangle with sides " + rectangle.a + " and " + rectangle.b + " = " + rectangle.area());

      System.out.println(distance(new Point(2,3), new Point(2,3)));
   }

   public static void hello(String somebody) {
      System.out.println("Hello, " + somebody + "!");
   }

	public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
   }
	
}