package com.gosch.addressbook.appmanager;

import com.gosch.addressbook.models.ContactData;
import com.gosch.addressbook.models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
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
        type(By.name("mobile"), contactData.getMobilePhone());
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

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastname).withHomePhone(home)
                .withMobilePhone(mobile).withWorkPhone(work);
    }

    public void initContactModificationById(int id) {
        /*
            Example #1: Метод последовательных приближений
         */
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        // Находим нужную строку
        WebElement row = checkbox.findElement(By.xpath("./../..")); // два прыжка вверх по DOM [.. означают родительскую директорию]
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        /*
            Other Examples
         */
        //click(By.xpath("//*[@id='maintable']/tbody/tr[.//input[@value='" + id + "']]/td[8]/a/img"));
        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
        //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
        //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact,false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        submitContactsDeletion();
        contactCache = null;
        wait.withTimeout(10, TimeUnit.SECONDS)
                .withMessage("Error returning to Home Page")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-az > form > input[type=\"text\"]")));
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        submitContactsDeletion();
        contactCache = null;
        wait.withTimeout(10, TimeUnit.SECONDS)
                .withMessage("Error returning to Home Page")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-az > form > input[type=\"text\"]")));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
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

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData()
                    .withId(id)
                    .withLastName(cells.get(1).getText())
                    .withFirstName(cells.get(2).getText())
                    .withAllPhones(allPhones)
            );
        }
        return new Contacts(contactCache);
    }
}
