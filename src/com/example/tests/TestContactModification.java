package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Random;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestContactModification extends TestBase{

    @Test
    public void modifySomeContact(){
        app.navigateTo().mainPage();

        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        ContactData contactData = new ContactData()
                .withName("")
                .withSurname("")
                .withAddress("new Address");

        app.getContactHelper().modifyContact(index, contactData);


        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(contactData)));
    }
}
