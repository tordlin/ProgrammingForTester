package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.ContactDataGenerator.loadContactsFromCSVFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TestContact extends TestBase{

    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        return  wrapContactsForDataProvider(loadContactsFromCSVFile(new File("contacts.txt"))).iterator();
    }

    @Test (dataProvider = "contactsFromFile")
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

