package com.example.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;


public class TestGroup extends TestBase {

    @Test(dataProvider = "randomGroupGeneration")
    public void testGroupCreation(GroupData groupData) throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initGroupPage();
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

}
