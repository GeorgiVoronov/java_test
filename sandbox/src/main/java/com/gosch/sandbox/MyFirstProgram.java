package com.gosch.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");

		double side = 5;
      System.out.println("Area of square with side " + side + " = " + area(side));

      double a = 5;
      double b = 7;
      System.out.println("Area of rectangle with sides " + a + " and " + b + " = " + area(a,b));

      System.out.println(distance(new Point(2,3), new Point(2,3)));
   }

	public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
   }

   public static void hello(String somebody) {
      System.out.println("Hello, " + somebody + "!");
   }

   public static double area(double side) {
	   return side * side;
   }

   public static double area(double sideA, double sideB) {
	   return sideA * sideB;
   }
	
}