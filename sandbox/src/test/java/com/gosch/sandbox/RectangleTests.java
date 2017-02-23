package com.gosch.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {

   @Test
   public void testAreaDifferentSides() {
      Rectangle rectangle = new Rectangle(3, 7);
      Assert.assertEquals(rectangle.area(), 21.0);
   }

   @Test
   public void testAreaSameSides() {
      Rectangle rectangle = new Rectangle(3,3);
      Assert.assertEquals(rectangle.area(), 9.0);
   }
   
}
