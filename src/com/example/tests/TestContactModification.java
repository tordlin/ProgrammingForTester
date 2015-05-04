package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestContactModification extends TestBase{

    @Test
    public void modifySomeContact(){
        app.getNavigationHelper().openMainPage();

        //save old state
        List<ContactData> oldlist = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initModifySomeContact(0);
        ContactData contactData = new ContactData();
        contactData.address = "new address";
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomePage();

        //save new state
        List<ContactData> newlist = app.getContactHelper().getContacts();

        //compare states
        oldlist.remove(0);
        oldlist.add(contactData);
        Collections.sort(oldlist);
        assertEquals(newlist, oldlist);
    }
}
