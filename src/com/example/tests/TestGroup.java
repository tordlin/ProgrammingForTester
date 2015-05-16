package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;


public class TestGroup extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initGroupPage();
        GroupData groupData = new GroupData();
        groupData.name = "GroupName1";
        groupData.header = "Header1";
        groupData.footer = "Footer1";
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.add(groupData);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();

        //save old state
        List<GroupData> oldlist = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initGroupPage();
        GroupData groupData = new GroupData("", "", "");
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        //save new state
        List<GroupData> newlist = app.getGroupHelper().getGroups();

        //compare states
        oldlist.add(groupData);
        Collections.sort(oldlist);
        assertEquals(newlist, oldlist);
    }


}
