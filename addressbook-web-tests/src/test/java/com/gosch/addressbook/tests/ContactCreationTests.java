package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactCreationPage();
        app.getContactHelper().createContact(new ContactData("Georgi", "Voronov", null, "53089127", "georgi.voronov@outlook.com", "test1"), true);
        //int after = app.getContactHelper().getContactCount();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
