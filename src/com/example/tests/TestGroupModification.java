package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestGroupModification extends TestBase {

    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupModification(2);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
