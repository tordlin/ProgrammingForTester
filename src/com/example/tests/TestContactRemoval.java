package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestContactRemoval extends TestBase {

    @Test
    public void removeSomeContact(){
        app.getNavigationHelper().openMainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initModifySomeContact(0);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().rebuildContactCache();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        oldList.remove(0);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}
