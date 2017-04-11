package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactData("Georgi", "Voronov", null, "53089127", "georgi.voronov@outlook.com", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size());
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Miwa", "Alijev", "Rusty", "5556789", "miwa@gmail.com", null);
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        //int after = app.getContactHelper().getContactCount();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }

}
