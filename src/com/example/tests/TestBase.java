package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.*;


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


}
