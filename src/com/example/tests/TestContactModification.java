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
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initModifySomeContact(0);
        ContactData contactData = new ContactData();
        contactData.name = "";
        contactData.surname = "";
        contactData.address = "new address";
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().rebuildContactCache();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        oldList.remove(0);
        oldList.add(contactData);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}
