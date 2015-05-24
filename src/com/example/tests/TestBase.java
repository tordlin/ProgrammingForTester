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
            GroupData groupData = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(new Object[]{groupData});
        }
        return  list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> randomContactGeneration(){
        List<Object[]> list = new ArrayList<Object[]>();
        for(int i = 0; i < 5; i++){
            ContactData contactData = new ContactData()
                    .withName(generateRandomString())
                    .withSurname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHomeNumber("00" + i)
                    .withMobileNumber("00" + i)
                    .withWorkNumber("00" + i)
                    .withEmail1("test" + i + "@mail.ru")
                    .withEmail2("test2" + i + "@mail.ru")
                    .withBDay("1")
                    .withBMonth("January")
                    .withBYear("2000")
                    .withGroupName("GroupName1")
                    .withSecondaryAddress(generateRandomString())
                    .withSecondaryPhone(generateRandomString());
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
