package org.lucky.Ex_01_Sample;

public class API_003_NoDesignPattern {

    // Example for no pattern design
    // suppose to prepare a building...
    // this is step- 1

    public void step1()
    {
        System.out.println("Step 1");
    }

    //this is step- 2

    public void step2()
    {
        System.out.println("Step 2");
    }

    // this is step- 3

    public void step3()
    {
        System.out.println("Step 3");
    }


    public static void main(String[] args) {

        API_003_NoDesignPattern nd= new API_003_NoDesignPattern();
        nd.step1();
        nd.step2();
        nd.step3();
    }
}
