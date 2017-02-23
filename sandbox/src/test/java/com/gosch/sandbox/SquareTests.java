package com.gosch.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

   @Test
   public void testArea() {
      Square s = new Square(5);
      // Easiest way to test:
      //assert s.area() == 25;
      // Correct way to test (it also controls if both values are the same type):
      Assert.assertEquals(s.area(), 25.0);
   }

}
