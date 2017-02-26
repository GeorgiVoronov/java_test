package com.gosch.addressbook.appmanager;

import com.gosch.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper {

   private FirefoxDriver wd;

   public ContactHelper(FirefoxDriver wd) {
      this.wd = wd;
   }

   public void fillContactForm(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
   }

   public void returnToHomePage() {
      wd.findElement(By.linkText("home page")).click();
   }

   public void submitContactCreation() {
      wd.findElement(By.name("submit")).click();
   }

   public void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
   }

}
