package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Random;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestContactRemoval extends TestBase {

    @Test
    public void removeSomeContact(){
        app.navigateTo().mainPage();

        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getContactHelper().removeContact(index);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }
}
