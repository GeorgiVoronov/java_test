package com.gosch.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

   // Delegation -> Объекту вспомогательного класса делегируются некоторые действия
   protected final ApplicationManager app = new ApplicationManager();

   @BeforeMethod
   public void setUp() throws Exception {
      app.init();
   }

   @AfterMethod
   public void tearDown() {
      app.stop();
   }

}
