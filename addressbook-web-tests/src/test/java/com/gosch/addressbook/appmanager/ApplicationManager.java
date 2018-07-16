package com.gosch.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   WebDriver wd;

   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private ContactHelper contactHelper;
   private String browser;

   public ApplicationManager(String browser) {
      this.browser = browser;
   }

   public void init() {
      //System.setProperty("webdriver.gecko.driver", "C:\\Firefox Driver\\geckodriver.exe");
      switch (browser) {
         case BrowserType.CHROME:
            wd = new ChromeDriver();
            break;
         case BrowserType.FIREFOX:
            wd = new FirefoxDriver();
            break;
         case BrowserType.EDGE:
            wd = new EdgeDriver();
            break;
      }
      //wd.manage().window().maximize();
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //неявное ожидание
      wd.get("http://localhost/addressbook/");
      navigationHelper = new NavigationHelper(wd);
      groupHelper = new GroupHelper(wd);
      contactHelper = new ContactHelper(wd);
      sessionHelper = new SessionHelper(wd);
      sessionHelper.login("admin", "secret");
   }

   public void stop() {
      wd.quit();
   }

   public ContactHelper contact() {
      return contactHelper;
   }

   public GroupHelper group() {
      return groupHelper;
   }

   public NavigationHelper goTo() {
      return navigationHelper;
   }
}
