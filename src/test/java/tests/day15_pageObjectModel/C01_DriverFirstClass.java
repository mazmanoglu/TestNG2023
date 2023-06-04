package tests.day15_pageObjectModel;

import org.testng.annotations.Test;
import utilities.Driver;


public class C01_DriverFirstClass {

    /*
    In Page Object Model (POM), from 4 different files we get the information we need.
    1- Driver class ==> driver
    2- page class from pages package ==> locate
    3- configuration properties ==> test data
    4- Reusable methods ==> practical methods we may need

    Inheritance with the extends keyword we used before, is not preferred in POM, because inheritance can only be for 1 class.

    There are different ways to use members of a class in java.
        - Using it directly by inheriting with extends
        - make class members static, then className.memberName
        - Instant an object from any class we want, then use its members

    In POM, we use second and third options.
     */
    @Test
    public void test01(){

        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.wisequarter.com"); // created second driver
        Driver.getDriver().get("https://www.youtube.com"); // created third driver,
        Driver.closeDriver();



        /*
            We are using getDriver method which creates new Chrome driver everytime, open new browser.
            But we need just one driver, and continue to work via this
            To solve this problem, we used If(driver==null) and put new Chrome driver into this.
            If driver is not null, then program couldn't create driver again and again
         */
    }
}
