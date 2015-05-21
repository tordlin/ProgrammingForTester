package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 * Created by Tordlin on 21/04/2015.
 */
public class TestBase {

    protected static ApplicationManager app;


    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();

    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();

    }


    @DataProvider
    public Iterator<Object[]> randomGroupGeneration(){
        List<Object[]> list = new ArrayList<Object[]>();
        for(int i = 0; i < 5; i++){
            GroupData groupData = new GroupData();
            groupData.name = generateRandomString();
            groupData.header = generateRandomString();
            groupData.footer = generateRandomString();
            list.add(new Object[]{groupData});
        }
        return  list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomContactGeneration(){
        List<Object[]> list = new ArrayList<Object[]>();
        for(int i = 0; i < 5; i++){
            ContactData contactData = new ContactData();
            contactData.name = generateRandomString();
            contactData.surname = generateRandomString();
            contactData.address = generateRandomString();
            contactData.homeNumber = "00" + i;
            contactData.mobileNumber = "00" + i;
            contactData.workNumber = "00" + i;
            contactData.email1 = "test" + i + "@mail.ru";
            contactData.email2 = "test2" + i + "@mail.ru";
            contactData.bday = "1";
            contactData.bmonth = "January";
            contactData.byear = "2000";
            contactData.groupName = "GroupName1";
            contactData.secondaryAddress = generateRandomString();
            contactData.secondaryPhone = generateRandomString();
            list.add(new Object[]{contactData});
        }
        return  list.iterator();
    }


    public String generateRandomString(){
        Random rnd = new Random();
        if(rnd.nextInt(4) == 0){
            return "";
        }else{
            return "test" + rnd.nextInt();
        }
    }
}
