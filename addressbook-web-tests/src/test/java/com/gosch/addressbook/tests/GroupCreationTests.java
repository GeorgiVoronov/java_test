package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage(); // only one line of code for navigation
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        // Lambda - Anonymous function
        // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        // If it were List:
        // Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        // before.sort(byId);
        // after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
