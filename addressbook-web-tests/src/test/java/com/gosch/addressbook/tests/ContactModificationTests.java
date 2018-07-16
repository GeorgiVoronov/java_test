package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import com.gosch.addressbook.models.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                            .withFirstName("Georgi")
                            .withLastName("Voronov")
                            .withMobilePhone("53089127")
                            .withEmail("georgi.voronov@outlook.com")
                            .withGroup("modified1"));
        }
    }

    @Test(enabled = true)
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData contactToModify = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(contactToModify.getId())
                .withFirstName("Miwa")
                .withLastName("Alijev")
                .withNickName("Rusty")
                .withMobilePhone("5556789")
                .withEmail("miwa@gmail.com");
        app.contact().modify(contact);

        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(contactToModify).withAdded(contact)));
    }



}
