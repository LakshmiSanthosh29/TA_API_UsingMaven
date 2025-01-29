package org.lucky.Ex_03_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_015_TestNG_DependsOn {

    @Test
    public void serverStartedOk()
    {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }


    @Test(dependsOnMethods = "method2")
   // @Test
    public void method1()
    {
        System.out.println("Method1");
        Assert.assertTrue(true);
    }

   // @Test
    @Test(dependsOnMethods = "serverStartedOk")
    public void method2()
    {
        System.out.println("Method2");
        Assert.assertTrue(true);

    }

}
