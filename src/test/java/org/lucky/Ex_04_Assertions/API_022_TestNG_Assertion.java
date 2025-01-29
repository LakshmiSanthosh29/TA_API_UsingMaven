package org.lucky.Ex_04_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class API_022_TestNG_Assertion {

    // There are two types of TestNg Assertions
    // 1. Hard Assertion-> If one Assertion failed the next remaining in the test will not be executed
    // 2. Soft Assertion->
    // even though any assertion fail it executes the next remaining assertions until softAssert.assertAll();

    @Test
    public void test_Hard_AssertionEx()
    {
        System.out.println("Start of the Program");
        Boolean is_XYZ_male=false;
        Assert.assertTrue(is_XYZ_male);
        System.out.println("End of the program");

    }

    @Test
    public void test_Soft_AssertionEx()
    {

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        softAssert.assertAll(); // this will report all collected errors

    }



}


