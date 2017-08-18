package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
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
        Set<ContactData> before = app.contact().all();
        ContactData contactToDelete = before.iterator().next();
        app.contact().delete(contactToDelete);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(contactToDelete);
        Assert.assertEquals(before, after);
    }



}
