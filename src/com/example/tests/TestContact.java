package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestContact extends TestBase{


    @Test (dataProvider = "randomContactGeneration")
    public void testContactCreation(ContactData contactData) throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().gotoInitContactPage();
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().rebuildContactCache();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        oldList.add(contactData);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }

}

