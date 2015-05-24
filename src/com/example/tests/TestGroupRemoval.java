package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Random;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Created by Tordlin on 01/05/2015.
 */
public class TestGroupRemoval extends TestBase{

    @Test
    public void deleteSomeGroup(){

        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getGroupHelper().deleteGroup(index);


        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }
}
