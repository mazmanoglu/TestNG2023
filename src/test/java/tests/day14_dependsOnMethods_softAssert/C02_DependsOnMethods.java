package tests.day14_dependsOnMethods_softAssert;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    /*
        If two test methods are connected to each other with dependOnMethods,
         even if you want to run only one method but the dependOnMethod annotation is defined on that one,
          the connected method will run first, if that is passed, then other method will run.

          BUT if we connect all 3 methods with 2 dependsOnMethod, it gives "No tests were found" error
          On this example, you cannot ron just test03 method.
     */
    @Test
    public void test01(){
        System.out.println("First test run");
    }
    @Test(dependsOnMethods = "test01")
    public void test02(){
        System.out.println("Second test run");
    }
    @Test(dependsOnMethods = "test02")
    public void test03(){
        System.out.println("Third test run");
    }


}
