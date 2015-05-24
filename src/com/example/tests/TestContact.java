package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TestContact extends TestBase{


    @Test (dataProvider = "randomContactGeneration")
    public void testContactCreation(ContactData contactData) throws Exception {
        app.navigateTo().mainPage();

        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().createContact(contactData);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        assertThat(newList, equalTo(oldList.withAdded(contactData)));
    }

}

