package org.lucky.Ex_03_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_019_TestNG_AlwaysRun {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
