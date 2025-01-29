package org.lucky.Ex_03_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class API_017_TestNG_Parameters {


    @Parameters("browser")
    @Test
    public void demo1(String value)
    {
        System.out.println("Browser is "+ value);
        if (value.equalsIgnoreCase("chrome"))
        {
            System.out.println("Start my Testing");
        }
        if (value.equalsIgnoreCase("firefox"))
        {
            System.out.println("Start my Firefox");

        }

    }

}
