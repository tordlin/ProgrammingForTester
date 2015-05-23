package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestGroupRemoval extends TestBase{

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().deleteSomeGroup(0);
        app.getGroupHelper().returnToGroupPage();
        app.getGroupHelper().rebuildGroupCache();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.remove(0);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
