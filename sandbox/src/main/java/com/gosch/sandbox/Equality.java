package com.gosch.sandbox;

public class Equality {

   public static void main(String[] args) {
      String s1 = "firefox 2.0";
      String s2 = new String(s1);
      String s3 = "firefox " + Math.sqrt(4.0);

      // Компилятор оптимизирует код.
      // Все переменные которые ссылаются на одну и ту же литеральную строку будут ссылаться на один и тот же объект.
      // s1 и s2 имеют один и тот же адрес в памяти.
      String s4 = "firefox 2.0";

      System.out.println(s1 == s2); //reference equality
      System.out.println(s1.equals(s2));
      System.out.println(s1.equals(s3));
      System.out.println(s1 == s4);
   }

}
