package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestContactModification extends TestBase{

    @Test
    public void modifySomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initModifySomeContact(6);
        ContactData group = new ContactData();
        group.address = "new address";
        app.getContactHelper().fillContactForm(group);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
