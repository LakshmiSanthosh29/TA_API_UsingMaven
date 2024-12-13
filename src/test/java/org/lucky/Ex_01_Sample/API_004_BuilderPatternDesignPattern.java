package org.lucky.Ex_01_Sample;

public class API_004_BuilderPatternDesignPattern {

    // Example for BuilderPattern Design Pattern



    public API_004_BuilderPatternDesignPattern step1()
    {
        System.out.println("Step 1");
        return this;
    }


    public API_004_BuilderPatternDesignPattern step2()
    {
        System.out.println("Step 2");
        return this;
    }


    public API_004_BuilderPatternDesignPattern step3()
    {
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {

        API_004_BuilderPatternDesignPattern bp= new API_004_BuilderPatternDesignPattern();
        bp.step1().step2().step3();
    }

}
