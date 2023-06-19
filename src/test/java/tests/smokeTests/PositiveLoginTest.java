package tests.smokeTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PositiveLoginTest {

    // go to mycoursedemy homepage
    // click login link
    // enter valid email as email
    // enter valid password as password
    // click login button to enter
    // test that you can successfully enter

    @Test
    public void positiveLoginTest(){
        // go to mycoursedemy home page
        Driver.getDriver().get(ConfigReader.getProperty("mcdURL"));
        MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();
        ReusableMethods.wait(2);
        // accept cookies
        myCoursedemyPage.acceptCookies.click();
        ReusableMethods.wait(2);
        // click login link
        myCoursedemyPage.loginLinkElement.click();
        // enter valid email address
        myCoursedemyPage.emailBoxElement.sendKeys(ConfigReader.getProperty("mcdValidEmail"));
        // enter valid password
        myCoursedemyPage.passwordBoxElement.sendKeys(ConfigReader.getProperty("mcdValidPassword"));
        // click login button
        myCoursedemyPage.loginButtonElement.click();
        // test that you can successfully enter
        Assert.assertTrue(myCoursedemyPage.myCoursesLink.isDisplayed());


        ReusableMethods.wait(3);
        Driver.closeDriver();

    }
}