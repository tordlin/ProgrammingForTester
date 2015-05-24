package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TestGroup extends TestBase {

    @Test(dataProvider = "randomGroupGeneration")
    public void testGroupCreation(GroupData groupData) throws Exception {

        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().createGroup(groupData);

        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        assertThat(newList, equalTo(oldList.withAdded(groupData)));
    }

}
