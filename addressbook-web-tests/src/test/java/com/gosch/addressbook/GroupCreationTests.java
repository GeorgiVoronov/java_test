package com.gosch.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation() {
      // Refactoring Mechanism - creating helping methods
      gotoGroupPage();
      initGroupCreation();
      // Вместо того чтобы передавать несколько параметров - передаётся 1 объект
      fillGroupForm(new GroupData("test1", "test2", "test3"));
      submitGroupCreation();
      returnToGroupPage();
   }

}
