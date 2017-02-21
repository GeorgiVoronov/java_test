package com.gosch.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");

		Square square = new Square(5);
      System.out.println("Area of square with side " + square.side + " = " + area(square));

      Rectangle rectangle = new Rectangle(5, 7);
      System.out.println("Area of rectangle with sides " + rectangle.a + " and " + rectangle.b + " = " + area(rectangle));

      System.out.println(distance(new Point(2,3), new Point(2,3)));
   }

	public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
   }

   public static void hello(String somebody) {
      System.out.println("Hello, " + somebody + "!");
   }

   public static double area(Square s) {
	   return s.side * s.side;
   }

   public static double area(Rectangle r) {
	   return r.a * r.b;
   }
	
}