package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

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
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size();
        ContactData contact = new ContactData()
                .withId(before.get(before.size() - 1).getId())
                .withFirstName("Miwa")
                .withLastName("Alijev")
                .withNickName("Rusty")
                .withMobile("5556789")
                .withEmail("miwa@gmail.com");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }



}
