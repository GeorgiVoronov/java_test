package com.gosch.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {

   protected FirefoxDriver wd;
   protected WebDriverWait wait;

   public BaseHelper(FirefoxDriver wd) {
      this.wd = wd;
      wait = new WebDriverWait(wd, 10);
   }

   protected void click(By locator) {
      wd.findElement(locator).click();
   }

   protected void type(By locator, String text) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
   }

   public boolean isAlertPresent() {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }
}
