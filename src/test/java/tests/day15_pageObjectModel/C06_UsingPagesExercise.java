package tests.day15_pageObjectModel;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_UsingPagesExercise {

    // mail = aurora@gmail.com
    // password = aurora

    @Test
    public void test01(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("https://automationexercise.com");
        SoftAssert softAssert = new SoftAssert();

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"you are not on homepage");

        //4. Click on 'Signup / Login' button
        AutomationExercisePage automationExercisePage = new AutomationExercisePage(); //create object from page class
        automationExercisePage.signUpLoginElement.click();

        //5. Verify 'Login to your account' is visible
        softAssert.assertTrue(automationExercisePage.loginToYourAccountTextElement.isDisplayed(), "Login to your account text is not displayed");

        //6. Enter correct email address and password
        automationExercisePage.emailLoginBoxElement.sendKeys("aurora@gmail.com");
        automationExercisePage.passwordBoxElement.sendKeys("aurora");

        //7. Click 'login' button
        automationExercisePage.loginButtonElement.click();

        //8. Verify that 'Logged in as username' is visible

        softAssert.assertTrue(automationExercisePage.loginAsUserText.isDisplayed(), "login as text is not displayed");

        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible

        softAssert.assertAll();
        ReusableMethods.wait(3);
        Driver.closeDriver();
    }
}
