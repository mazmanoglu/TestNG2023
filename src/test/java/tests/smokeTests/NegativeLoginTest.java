package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegativeLoginTest {
    // go to mycoursedemy homepage
    // click login link
    // create 3 test methods and test you cannot log in with wrong info
        // - wrong email, true password
        // - true email, wrong password
        // - wrong email, wrong password
    // click login button to enter
    // test that you canNOT successfully enter

    MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();

    @BeforeClass
    public void setup(){
        // go to mycoursedemy home page
        Driver.getDriver().get(ConfigReader.getProperty("mcdURL"));
        ReusableMethods.wait(2);
        // accept cookies
        myCoursedemyPage.acceptCookies.click();
        ReusableMethods.wait(2);
        // click login link
        myCoursedemyPage.loginLinkElement.click();
    }

    @Test
    public void wrongEmailTruePasswordLoginTest(){
        // enter failed email address
        myCoursedemyPage.emailBoxElement.sendKeys(ConfigReader.getProperty("mcdFailedEmail"));
        // enter valid password
        myCoursedemyPage.passwordBoxElement.sendKeys(ConfigReader.getProperty("mcdValidPassword"));
        // click login button
        myCoursedemyPage.loginButtonElement.click();
        // test that you canNOT successfully enter (check email box is still displayed)
        Assert.assertTrue(myCoursedemyPage.emailBoxElement.isDisplayed());
    }
    @Test
    public void trueEmailWrongPasswordLoginTest(){
        // enter valid email address
        myCoursedemyPage.emailBoxElement.sendKeys(ConfigReader.getProperty("mcdValidEmail"));
        // enter failed password
        myCoursedemyPage.passwordBoxElement.sendKeys(ConfigReader.getProperty("mcdFailedPassword"));
        // click login button
        myCoursedemyPage.loginButtonElement.click();
        // test that you canNOT successfully enter (check email box is still displayed)
        Assert.assertTrue(myCoursedemyPage.emailBoxElement.isDisplayed());
    }
    @Test
    public void wrongEmailWrongPasswordLoginTest(){
        // enter failed email address
        myCoursedemyPage.emailBoxElement.sendKeys(ConfigReader.getProperty("mcdFailedEmail"));
        // enter failed password
        myCoursedemyPage.passwordBoxElement.sendKeys(ConfigReader.getProperty("mcdFailedPassword"));
        // click login button
        myCoursedemyPage.loginButtonElement.click();
        // test that you canNOT successfully enter (check email box is still displayed)
        Assert.assertTrue(myCoursedemyPage.emailBoxElement.isDisplayed());
    }
    @AfterClass
    public void teardown(){
        ReusableMethods.wait(3);
        Driver.closeDriver();
    }
}
