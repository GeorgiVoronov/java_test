package com.gosch.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests {
   FirefoxDriver wd;

   @BeforeMethod
   public void setUp() throws Exception {
      System.setProperty("webdriver.gecko.driver", "C:\\Users\\Georgi\\Documents\\Firefox Driver\\geckodriver.exe");
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      login("admin", "secret");
   }

   private void login(String username, String password) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
   }

   @Test
   public void ContactCreationTests() {
      initContactCreation();
      fillContactForm(new ContactData("Georgi", "Voronov", "Gosch", "53089127", "georgi.voronov@outlook.com"));
      submitContactCreation();
      returnToHomePage();
   }

   private void fillContactForm(ContactData contactData) {
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

   private void returnToHomePage() {
      wd.findElement(By.linkText("home page")).click();
   }

   private void submitContactCreation() {
      wd.findElement(By.name("submit")).click();
   }

   private void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
   }

   @AfterMethod
   public void tearDown() {
      wd.quit();
   }

   public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }
}
