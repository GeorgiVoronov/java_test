package com.gosch.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		System.out.println("Hello World!");
      System.out.println(distance(new Point(2,3), new Point(2,3)));
   }

	public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
   }
	
}