package tests.day16_pageObjectModel;

import org.testng.annotations.Test;

public class C02_XmlFiles {
    @Test(groups = "smoke")
    public void test01(){
        System.out.println("Test 1 is successful.");
    }
    @Test(groups = "smoke")
    public void test02(){
        System.out.println("Test 2 is successful.");
    }
    @Test(groups = "regression")
    public void test03(){
        System.out.println("Test 3 is successful.");
    }
    @Test
    public void test04(){
        System.out.println("Test 4 is successful.");
    }
}
