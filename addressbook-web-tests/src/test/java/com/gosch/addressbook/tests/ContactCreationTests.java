package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import com.gosch.addressbook.models.Contacts;
import com.gosch.addressbook.models.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    private final String groupName = "test1";

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().all().stream().anyMatch(item -> groupName.equals(item.getName()))) {
            app.group().create(new GroupData().withName(groupName));
        }
    }

    @Test(enabled = true)
    public void ContactCreationTests() {
        app.goTo().homePage();
        Contacts before = app.contact().all();

        app.goTo().contactCreationPage();
        ContactData contact = new ContactData()
                .withFirstName("Georgi")
                .withLastName("Voronov")
                .withMobile("53089127")
                .withEmail("georgi.voronov@outlook.com")
                .withGroup(groupName);
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();


        assertThat(after, equalTo(before.withAdded(
                contact.withId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId()))));
    }

}
