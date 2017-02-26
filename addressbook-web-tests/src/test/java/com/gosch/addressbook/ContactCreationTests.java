package com.gosch.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

   @Test
   public void ContactCreationTests() {
      initContactCreation();
      fillContactForm(new ContactData("Georgi", "Voronov", "Gosch", "53089127", "georgi.voronov@outlook.com"));
      submitContactCreation();
      returnToHomePage();
   }

}
