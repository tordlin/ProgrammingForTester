package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;


/**
 * Created by Tordlin on 21/04/2015.
 */
public class TestBase {

    protected static ApplicationManager app;


    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File("application.properties")));
        app = new ApplicationManager(properties);

    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }


    @DataProvider
    public Iterator<Object[]> randomGroupGeneration(){
        return  wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
    }

    public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for(GroupData groupData : groups){
           list.add(new Object[]{groupData});
        }
        return list;
    }


    @DataProvider
    public Iterator<Object[]> randomContactGeneration(){
        return  wrapContactsForDataProvider(generateRandomContacts(5)).iterator();
    }

    public List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for(ContactData contactData : contacts){
            list.add(new Object[]{contactData});
        }
        return list;
    }

}
