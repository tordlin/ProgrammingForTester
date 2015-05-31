package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCSVFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TestGroup extends TestBase {

    @DataProvider
    public Iterator<Object[]> groupsFromFile() throws IOException {
        return  wrapGroupsForDataProvider(loadGroupsFromCSVFile(new File("groups.txt"))).iterator();
    }



    @Test(dataProvider = "groupsFromFile")
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
