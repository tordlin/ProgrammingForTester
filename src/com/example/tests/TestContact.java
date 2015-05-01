package com.example.tests;


import org.testng.annotations.Test;

public class TestContact extends TestBase{


    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().gotoInitContactPage();
        ContactData contactData = new ContactData();
        contactData.name = "TestName";
        contactData.surname = "TestSurname";
        contactData.address = "TestAddress";
        contactData.homeNumber = "001";
        contactData.mobileNumber = "002";
        contactData.workNumber = "003";
        contactData.email1 = "test@mail.ru";
        contactData.email2 = "test2@mail.ru";
        contactData.bday = "1";
        contactData.bmonth = "January";
        contactData.byear = "2000";
        contactData.groupName = "GroupName1";
        contactData.secondaryAddress = "TestSecondaryAddress";
        contactData.secondaryPhone = "TestHome";
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().gotoInitContactPage();
        app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().gotoHomePage();
    }


}

