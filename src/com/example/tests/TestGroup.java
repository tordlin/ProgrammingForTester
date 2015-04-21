package com.example.tests;


import org.testng.annotations.Test;


public class TestGroup extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        gotoGroupPage();
        initGroupPage();
        GroupData groupData = new GroupData();
        groupData.name = "GroupName1";
        groupData.header = "Header1";
        groupData.footer = "Footer1";
        fillGroupForm(groupData);
        submitGroupCreation();
        returnToGroupPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        openMainPage();
        gotoGroupPage();
        initGroupPage();
        fillGroupForm(new GroupData("", "", ""));
        submitGroupCreation();
        returnToGroupPage();
    }


}
