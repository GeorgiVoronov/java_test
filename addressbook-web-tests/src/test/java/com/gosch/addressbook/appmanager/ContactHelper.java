package com.gosch.addressbook.appmanager;

import com.gosch.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

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
   }

   public void returnToHomePage() {
      click(By.linkText("home page"));
   }

   public void submitContactCreation() {
      click(By.name("submit"));
   }

   public void initContactModification() {
      click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
   }

   public void submitContactModification() {
      click(By.name("update"));
   }

   public void selectContact() {
      click(By.name("selected[]"));
   }

   public void deleteSelectedContacts() {
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
   }

   public void submitContactsDeletion() {
      wd.switchTo().alert().accept();
      wait.withTimeout(10, TimeUnit.SECONDS)
              .withMessage("Davaj ponovoj")
              .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.msgbox")));
      /*
      if(isAlertPresent()) {
         wd.switchTo().alert().accept();
      }
      */
   }
}
