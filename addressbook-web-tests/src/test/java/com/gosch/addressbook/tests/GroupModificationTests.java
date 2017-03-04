package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

   @Test
   public void testGroupModification() {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("modified1","test2", "modified3"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
   }

}
