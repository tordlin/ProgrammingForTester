package com.example.tests;


import org.testng.annotations.Test;


public class TestWithoutData extends TestBase {



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
