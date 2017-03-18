package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactData("Georgi", "Voronov", null, "53089127", "georgi.voronov@outlook.com", "test1"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().submitContactsDeletion();
    }

}
