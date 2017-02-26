package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

   @Test
   public void testContactModification() {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("Miwa", "Alijev", "Rusty","5556789","miwa@gmail.com"));
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();
   }

}
