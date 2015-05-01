package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestGroupRemoval extends TestBase{

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().deleteSomeGroup(1);
        app.getGroupHelper().returnToGroupPage();
    }
}
