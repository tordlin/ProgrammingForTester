package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestContactRemoval extends TestBase {

    @Test
    public void removeSomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initModifySomeContact(4);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
