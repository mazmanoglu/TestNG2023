package tests.day16_pageObjectModel;

import org.testng.annotations.Test;

public class C03_XmlFiles {
    @Test(groups = "smoke")
    public void test05(){
        System.out.println("Test 5 is successful.");
    }
    @Test(groups = "smoke")
    public void test06(){ System.out.println("Test 6 is successful."); }
    @Test(groups = {"smoke","regression"})
    public void test07(){
        System.out.println("Test 7 is successful.");
    }
    @Test(groups = "regression")
    public void test08(){
        System.out.println("Test 8 is successful.");
    }
}
