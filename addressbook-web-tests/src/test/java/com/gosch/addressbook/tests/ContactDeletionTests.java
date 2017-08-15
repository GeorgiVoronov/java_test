package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().create(new ContactData()
                    .withFirstName("Georgi")
                    .withLastName("Voronov")
                    .withMobile("53089127")
                    .withEmail("georgi.voronov@outlook.com")
                    .withGroup("modified1"),
                    true);
            app.goTo().homePage();
        }
    }

    @Test(enabled = true)
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }



}
