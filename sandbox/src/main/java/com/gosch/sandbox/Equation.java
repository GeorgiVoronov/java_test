package com.gosch.sandbox;

// Уравнение
public class Equation {

   private double a;
   private double b;
   private double c;

   // количество корней
   private int n;

   public Equation(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;

      // d - Дискриминант
      double d = b * b - 4 * a * c;

      // уравнение из квадратного превращается в линейное
      if (a != 0) {
         // Если уравнение Квадратное
         if (d > 0) {
            n = 2;
         } else if (d == 0) {
            n = 1;
         } else {
            n = 0;
         }
         // System.out.println("Это вырожденное уравнение");
      } else if (b != 0) {
         n = 1;
      } else if (c != 0) {
         n = 0;
      } else {
         // на самом деле корней тут бесконечно много, но условно обозначим -1
         n = -1;
      }

   }

   public int rootNumber() {
      return n;
   }

}
