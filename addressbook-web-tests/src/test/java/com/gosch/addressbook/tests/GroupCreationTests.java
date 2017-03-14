package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        // Refactoring Mechanism - creating helping methods
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }

}
