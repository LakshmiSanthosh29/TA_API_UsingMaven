package org.lucky.Ex_03_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API_013_TestNG_Ex1 {


    //TestNG Annotations examples

    @BeforeTest
    public void getToken()
    {
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingId()
    {
        System.out.println("2");
    }

    @Test
    public void test_put()
    {
        System.out.println("3");
    }

    @AfterTest
        public void closeAllThings()
    {
        System.out.println("close");
    }


}
