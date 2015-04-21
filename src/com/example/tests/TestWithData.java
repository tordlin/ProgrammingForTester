package com.example.tests;


import org.testng.annotations.Test;


public class TestWithData extends TestBase {

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


}
