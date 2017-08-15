package com.gosch.addressbook.appmanager;

import com.gosch.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            // Select in Drop down
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactModification(int index) {
        click(By.xpath("//table[@id='maintable']/tbody/tr[" + (index + 1) + "]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //click(By.name("selected[]"));
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

    public void create(ContactData contactData, boolean creation) {
        fillContactForm(contactData, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(int index, ContactData contact) {
        initContactModification(index);
        fillContactForm(contact,false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        submitContactsDeletion();
        wait.withTimeout(10, TimeUnit.SECONDS)
                .withMessage("Error returning to Home Page")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-az > form > input[type=\"text\"]")));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String text = element.getText();
            List<WebElement> list = element.findElements(By.tagName("td"));
            /*
            String name = element.findElements(By.tagName("td")).get(1).getText();
            System.out.println(name);
            */
            int id = Integer.parseInt(list.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstName(list.get(2).getText())
                    .withLastName(list.get(1).getText())
            );
        }
        return contacts;
    }
}
