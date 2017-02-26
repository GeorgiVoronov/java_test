package com.gosch.addressbook.appmanager;

import com.gosch.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends BaseHelper {

   public ContactHelper(FirefoxDriver wd) {
      super(wd);
   }

   public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"), contactData.getFirstName());
      type(By.name("lastname"), contactData.getLastName());
      type(By.name("nickname"), contactData.getNickName());
      type(By.name("mobile"), contactData.getMobile());
      type(By.name("email"), contactData.getEmail());
      click(By.xpath("//div[@id='content']/form/input[21]"));
   }

   public void returnToHomePage() {
      click(By.linkText("home page"));
   }

   public void submitContactCreation() {
      click(By.name("submit"));
   }

   public void initContactCreation() {
      click(By.linkText("add new"));
   }

}
