package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNGFirstTest extends TestBase {

    /*
        - TestNG runs test methods in order of name
        If we want to change the order, we can use priority annotation

        - Methods that we use priority annotation are sorted from smallest to biggest
        If there is a method that doesn't use priority, it means  priority=0
        If there are multiple methods with the same priority value, they will work in alphabetical order.
     */

    @Test(priority = 10)
    public void firstTest(){
        driver.get("https://www.amazon.com");
    }

    @Test(priority = 10)
    public void secondTest(){
        driver.get("https://www.youtube.com");
    }

    @Test
    public void thirdTest(){
        driver.get("https://www.imdb.com");
    }
}
