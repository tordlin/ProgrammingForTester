package com.example.tests;


import org.testng.annotations.Test;

public class TestContact extends TestBase{


    @Test
    public void testNonEmptyContactCreation() throws Exception {
        openMainPage();
        gotoInitContactPage();
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
        fillContactForm(contactData);
        submitContactForm();
        gotoHomePage();
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        openMainPage();
        gotoInitContactPage();
        fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
        submitContactForm();
        gotoHomePage();
    }


}

