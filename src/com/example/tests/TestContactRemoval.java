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
        List<ContactData> oldlist = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initModifySomeContact(0);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();

        //save new state
        List<ContactData> newlist = app.getContactHelper().getContacts();

        //compare states
        oldlist.remove(0);
        Collections.sort(oldlist);
        assertEquals(newlist, oldlist);
    }
}
