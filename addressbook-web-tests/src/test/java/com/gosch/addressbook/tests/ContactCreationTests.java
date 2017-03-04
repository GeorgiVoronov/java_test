package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

   @Test
   public void ContactCreationTests() {
      app.getNavigationHelper().initContactCreation();
      app.getContactHelper().fillContactForm(
              new ContactData("Georgi", "Voronov", null, "53089127", "georgi.voronov@outlook.com", "test1"),
              true
      );
      app.getContactHelper().submitContactCreation();
      app.getContactHelper().returnToHomePage();
   }

}
