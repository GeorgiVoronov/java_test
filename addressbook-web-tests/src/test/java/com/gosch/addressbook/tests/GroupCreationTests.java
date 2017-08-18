package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.GroupData;
import com.gosch.addressbook.models.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage(); // only one line of code for navigation
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        // Fluent Interface
        assertThat(after, equalTo(before.withAdded(
                group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
