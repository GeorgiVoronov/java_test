package com.gosch.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {

   protected WebDriver wd;
   protected WebDriverWait wait;

   public BaseHelper(WebDriver wd) {
      this.wd = wd;
      wait = new WebDriverWait(wd, 10);
   }

   protected void click(By locator) {
      wd.findElement(locator).click();
   }

   protected void type(By locator, String text) {
      click(locator);
      if (text != null) {
         // use .getText() in all cases except input fields
         String existingText = wd.findElement(locator).getAttribute("value");
         if (!text.equals(existingText)) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
         }
      }
   }

   public boolean isAlertPresent() {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   protected boolean isElementPresent(By locator) {
      try {
         wd.findElement(locator);
         return true;
      } catch (NoSuchElementException ex) {
         return false;
      }
   }
}
