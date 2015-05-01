package com.example.tests;


import org.testng.annotations.Test;


public class TestGroup extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupPage();
        GroupData groupData = new GroupData();
        groupData.name = "GroupName1";
        groupData.header = "Header1";
        groupData.footer = "Footer1";
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupPage();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }


}
