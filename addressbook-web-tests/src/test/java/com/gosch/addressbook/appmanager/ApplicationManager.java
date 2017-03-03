package com.gosch.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

// AppManager will delegate some functions to one of his Helpers
public class ApplicationManager {

   FirefoxDriver wd;
   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private ContactHelper contactHelper;

   public void init() {
      //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Georgi\\Documents\\Firefox Driver\\geckodriver.exe");
      //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Georgi\\Documents\\Chrome Driver\\chromedriver.exe");
      // Firefox Driver -> Work
      System.setProperty("webdriver.gecko.driver", "C:\\Users\\gvoronov\\Documents\\Firefox Driver\\geckodriver.exe");
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      contactHelper = new ContactHelper(wd);
      sessionHelper = new SessionHelper(wd);
      sessionHelper.login("admin", "secret");
   }

   public void stop() {
      wd.quit();
   }

   public ContactHelper getContactHelper() {
      return contactHelper;
   }

   public GroupHelper getGroupHelper() {
      return groupHelper;
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }
}
