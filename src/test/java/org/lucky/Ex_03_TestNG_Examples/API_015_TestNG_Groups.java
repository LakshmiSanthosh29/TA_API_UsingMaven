package org.lucky.Ex_03_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_015_TestNG_Groups {


    // Example for TestNG Grouping


    @Test(groups = {"sanity", "qa","prod", "P0"})
    public void sanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg", "P1"})
    public void RegRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "P0"})
    public void SmokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
