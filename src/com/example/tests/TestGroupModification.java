package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestGroupModification extends TestBase {

    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();

        //save old state
        List<GroupData> oldlist = app.getGroupHelper().getGroups();

        //action
        app.getGroupHelper().initGroupModification(0);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

        //save new state
        List<GroupData> newlist = app.getGroupHelper().getGroups();

        //compare states
        oldlist.remove(0);
        oldlist.add(group);
        Collections.sort(oldlist);
        assertEquals(newlist, oldlist);
    }
}
