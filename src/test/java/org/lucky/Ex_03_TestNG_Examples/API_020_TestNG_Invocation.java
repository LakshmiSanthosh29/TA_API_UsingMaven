package org.lucky.Ex_03_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_020_TestNG_Invocation {


    @Test(invocationCount = 3)
    public void test01(){
        Assert.assertTrue(true);
    }


}
