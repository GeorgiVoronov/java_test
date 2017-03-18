package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactData("Georgi", "Voronov", null, "53089127", "georgi.voronov@outlook.com", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(
                new ContactData("Miwa", "Alijev", "Rusty", "5556789", "miwa@gmail.com", null),
                false
        );
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }

}
